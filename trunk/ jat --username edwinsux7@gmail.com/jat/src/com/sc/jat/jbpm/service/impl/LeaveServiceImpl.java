package com.sc.jat.jbpm.service.impl;   

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;

import com.sc.jat.enums.TypeStaticValues;
import com.sc.jat.jbpm.dao.LeaveDao;
import com.sc.jat.jbpm.dao.impl.JbpmDao;
import com.sc.jat.jbpm.model.Leaved;
import com.sc.jat.jbpm.service.LeaveService;
import com.scommon.emnus.CommonStaticValues;
import com.scommon.exception.SaveException;
import com.scommon.util.PagingBean;
import com.scommon.util.json.JsonUtils;
import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;

/**   
 * ClassName:LeaveServiceImpl   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-30   
 * @since    leave21.0   
 */
@Service("leaveService")
public class LeaveServiceImpl implements LeaveService{
	Log log = LogFactory.getLog(LeaveServiceImpl.class);
	private JbpmDao jbpmDao;
	private LeaveDao leaveDao;

	public void deploy(String path) throws Exception{
		String version = jbpmDao.deploy(path);
		log.info("发布新流程version:" + version);
	}
	
	public String getTasks(String loginName) {
		List<Task> tasks = jbpmDao.findByUserName(loginName);
		List<Leaved> leaves = new ArrayList<Leaved>();
		
		for(Task task : tasks){
			String taskId = task.getId();
			String leaveId = (String) jbpmDao.findByTaskIdAndProperty(taskId, "leaveId");
			Leaved leave = leaveDao.findByLeaveId(leaveId);
			leave.setTaskId(taskId);
			leaves.add(leave);
		}
		return JSONArray.fromObject(leaves).toString();   
	}
	
	public String getTasks(String username, Integer start, Integer limit) {
		PagingBean taskBean = jbpmDao.findByUserName(username, start, limit);
		List<Task> tasks = (List<Task>) taskBean.getRoot();
		List<Leaved> leaves = new ArrayList<Leaved>();
		//根据任务获取请假信息
		for(Task task : tasks){
			String taskId = task.getId();
			String leaveId = (String) jbpmDao.findByTaskIdAndProperty(taskId, "leaveId");
			Leaved leave = leaveDao.findByLeaveId(leaveId);
			leave.setTaskId(taskId);
			leaves.add(leave);
		}
		taskBean.setRoot(leaves);
		Set<String> props = new HashSet<String>();
		props.add("applyTime");
		props.add("startTime");
		props.add("endTime");
		Set<String> fprops = new HashSet<String>();
		fprops.add("addTime");
		//fprops.add("role");
		return JsonUtils.getJsonAndConvertFilter(taskBean, props, Long.class, CommonStaticValues.SYS_DATE_FORMAT, fprops);
	}
	
	public void save(Leaved leave) throws SaveException{
		leaveDao.save(leave);
	}
	
	public void applyLeave(String leaveId, String position) {
		updateApplyTime(leaveId);
		Map<String, Object> map = new HashMap<String, Object>();
		//当非职员登录时从变量集合中获取leaveId，即查询出属于自己的任务
		map.put("leaveId", leaveId);
		Leaved leave = leaveDao.findByLeaveId(leaveId);
		if("职员".equals(position)){
			map.put("manager", "否");
			map.put("username", "xi");
			leave.setStatus(TypeStaticValues.LEAVE_STATUS_AUDITINGBYMANAGER);
		}else if("经理".equals(position)){
			map.put("manager", "是");
			leave.setStatus(TypeStaticValues.LEAVE_STATUS_AUDITINGBYBOSS);
		}
		//leave,writeForm为jpdl文件中配置
		//开始一流程实例
		ProcessInstance pi = jbpmDao.startProcessInstance("leave", map, leaveId);
		//取的任务Id
		String taskId = ((List<Task>)jbpmDao.findByUserName("writeForm")).get(0).getId();
		//完成阶段性任务
		jbpmDao.completeTask(taskId);
		
		//修改请假信息状态
		leaveDao.update(leave);
	}
	
	public void agree(String taskId, String auditContent) {
		String leaveId = (String) jbpmDao.findByTaskIdAndProperty(taskId, "leaveId");
		Leaved leave = leaveDao.findByLeaveId(leaveId);
		Task task = jbpmDao.findByTaskId(taskId);
		String assignee = task.getAssignee();
		if("sux".equals(assignee)){
			jbpmDao.completeTask(taskId, "老板批准");
			leave.setStatus(TypeStaticValues.LEAVE_STATUS_AGREEBYBOSS);//审核通过
			leave.setAuditContent(auditContent);
			leaveDao.update(leave);
			return;
		}
		int day = leave.getDay();
		if(day > 5){
			jbpmDao.completeTask(taskId, "请假天数>5");
			leave.setStatus(TypeStaticValues.LEAVE_STATUS_AUDITINGBYBOSS);
			leaveDao.update(leave);
		}else{
			jbpmDao.completeTask(taskId, "经理批准");
			leave.setStatus(TypeStaticValues.LEAVE_STATUS_AGREEBYMANAGER);//通过
			leave.setAuditContent(auditContent);
			leaveDao.update(leave);
		}
	}
	
	public void disagree(String taskId, String auditContent){
		String leaveId = (String) jbpmDao.findByTaskIdAndProperty(taskId, "leaveId");
		Leaved leave = leaveDao.findByLeaveId(leaveId);
		Task task = jbpmDao.findByTaskId(taskId);
		String assignee = task.getAssignee();
		if("sux".equals(assignee)){
			jbpmDao.completeTask(taskId, "老板不批准");
			leave.setStatus(TypeStaticValues.LEAVE_STATUS_DISAGREEBYBOSS);//不通过
		}else{
			jbpmDao.completeTask(taskId, "经理不批准");
			leave.setStatus(TypeStaticValues.LEAVE_STATUS_DISAGREEBYMANAGER);//不通过
		}
		leave.setAuditContent(auditContent);
		leaveDao.update(leave);
	}
	public void reject(String taskId, String auditContent){
		String leaveId = (String) jbpmDao.findByTaskIdAndProperty(taskId, "leaveId");
		Leaved leave = leaveDao.findByLeaveId(leaveId);
		Task task = jbpmDao.findByTaskId(taskId);
		String assignee = task.getAssignee();
		if("sux".equals(assignee)){
			jbpmDao.completeTask(taskId, "老板驳回");
			leave.setStatus(TypeStaticValues.LEAVE_STATUS_REJECTBYBOSS);
		}else{
			jbpmDao.completeTask(taskId, "经理驳回");
			leave.setStatus(TypeStaticValues.LEAVE_STATUS_REJECTBYMANAGER);
		}
		leave.setAuditContent(auditContent);
		leaveDao.update(leave);
	}
	
	public String getLeaves(String userId, Integer start, Integer limit) {
		PagingBean pagingBean = leaveDao.findByUserIdAndPage(userId, start, limit); 
		Set<String> props = new HashSet<String>();
		props.add("addTime");
		props.add("startTime");
		props.add("endTime");
		Set<String> fprops = new HashSet<String>();
		fprops.add("applyTime");
		fprops.add("users");
		return JsonUtils.getJsonAndConvertFilter(pagingBean, props, Long.class, CommonStaticValues.SYS_DATE_FORMAT, fprops);
	}
	
	public String getLeaves(String userId) {
		List<Leaved> leaves = leaveDao.findByUserId(userId);
		return JSONArray.fromObject(leaves).toString();
	}
	
	public String getById(String leaveId) {
		Leaved leave = leaveDao.findByLeaveId(leaveId);
		Set<String> props = new HashSet<String>();
		props.add("applyTime");
		props.add("startTime");
		props.add("endTime");
		Set<String> fprops = new HashSet<String>();
		fprops.add("addTime");
		fprops.add("role");
		return JsonUtils.getJsonAndConvertFilter(leave, props, Long.class, CommonStaticValues.SYS_DATE_FORMAT, fprops);
	}
	
	public void updateLeaveStatus(String taskId, Leaved leave) {
		if(leave.getStatus() == 0){
			this.agree(taskId, leave.getAuditContent());
		}
		if(leave.getStatus() == 1){
			this.disagree(taskId, leave.getAuditContent());
		}
		if(leave.getStatus() == 2){
			this.reject(taskId, leave.getAuditContent());
		}
	}
	
	/**
	 * 
	 * updateApplyTime:添加申请时间 
	 *   
	 * @param  @param leaveId    设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  jat1.0
	 */
	public void updateApplyTime(String leaveId){
		Leaved leave = leaveDao.getById(leaveId);
		leave.setApplyTime(System.currentTimeMillis());
		leaveDao.update(leave);
	}
	
	public JbpmDao getJbpmDao() {
		return jbpmDao;
	}
	@Resource
	public void setJbpmDao(JbpmDao jbpmDao) {
		this.jbpmDao = jbpmDao;
	}

	public LeaveDao getLeaveDao() {
		return leaveDao;
	}
	@Resource
	public void setLeaveDao(LeaveDao leaveDao) {
		this.leaveDao = leaveDao;
	}

}
   
