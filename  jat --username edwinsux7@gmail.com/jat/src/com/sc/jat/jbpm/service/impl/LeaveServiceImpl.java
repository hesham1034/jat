package com.sc.jat.jbpm.service.impl;   

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;

import com.sc.jat.jbpm.dao.LeaveDao;
import com.sc.jat.jbpm.dao.impl.JbpmDao;
import com.sc.jat.jbpm.model.Leave;
import com.sc.jat.jbpm.service.LeaveService;
import com.scommon.exception.SaveException;
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

	public void deploy(String path){
		String version = jbpmDao.deploy(path);
		log.info("发布新流程version:" + version);
	}
	
	public String getTasks(String loginName) {
		List<Task> tasks = jbpmDao.findByUserName(loginName);
		List<Leave> leaves = new ArrayList<Leave>();
		
		for(Task task : tasks){
			String taskId = task.getId();
			String leaveId = (String) jbpmDao.findByTaskIdAndProperty(taskId, "leaveId");
			Leave leave = leaveDao.findByLeaveId(leaveId);
			leave.setTaskId(taskId);
			leaves.add(leave);
		}
		return JSONArray.fromObject(leaves).toString();   
	}
	
	public void save(Leave leave) throws SaveException{
		leaveDao.save(leave);
	}
	
	public void applyLeave(String leaveId, String position) {
		Map<String, Object> map = new HashMap<String, Object>();
		//当非职员登录时从变量集合中获取leaveId，即查询出属于自己的任务
		map.put("leaveId", leaveId);
		if("职员".equals(position)){
			map.put("manager", "否");
			map.put("username", "xi");
		}else if("经理".equals(position)){
			map.put("manager", "是");
		}
		//leave,writeForm为jpdl文件中配置
		//开始一流程实例
		ProcessInstance pi = jbpmDao.startProcessInstance("leave", map, leaveId);
		//取的任务Id
		String taskId = ((List<Task>)jbpmDao.findByUserName("writeForm")).get(0).getId();
		//完成阶段性任务
		jbpmDao.completeTask(taskId);
		
		//修改请假信息状态
		Leave leave = leaveDao.findByLeaveId(leaveId);
		leave.setStatus(1);//审核中
		leaveDao.update(leave);
	}
	
	public void agree(String taskId) {
		String leaveId = (String) jbpmDao.findByTaskIdAndProperty(taskId, "leaveId");
		Leave leave = leaveDao.findByLeaveId(leaveId);
		Task task = jbpmDao.findByTaskId(taskId);
		String assignee = task.getAssignee();
		if("sux".equals(assignee)){
			jbpmDao.completeTask(taskId, "老板批准");
			leave.setStatus(2);//审核通过 
			leaveDao.update(leave);
			return;
		}
		int day = leave.getDay();
		if(day > 5){
			jbpmDao.completeTask(taskId, "请假天数>5");
		}else{
			jbpmDao.completeTask(taskId, "经理批准");
			leave.setStatus(2);//通过
			leaveDao.update(leave);
		}
	}
	
	public void disagree(String taskId){
		String leaveId = (String) jbpmDao.findByTaskIdAndProperty(taskId, "leaveId");
		Leave leave = leaveDao.findByLeaveId(leaveId);
		Task task = jbpmDao.findByTaskId(taskId);
		String assignee = task.getAssignee();
		if("sux".equals(assignee)){
			jbpmDao.completeTask(taskId, "老板不批准");
		}else{
			jbpmDao.completeTask(taskId, "经理不批准");
		}
		leave.setStatus(3);//不通过
		leaveDao.update(leave);
	}
	
	public String getLeaves(String userId) {
		List<Leave> leaves = leaveDao.findByUserId(userId);
		return JSONArray.fromObject(leaves).toString();
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
   
