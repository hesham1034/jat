package com.sc.jat.jbpm.action;   

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.sc.jat.jbpm.model.Leaved;
import com.sc.jat.jbpm.service.LeaveService;
import com.sc.jat.ss.model.Users;
import com.sc.jat.ss.vo.CustomUserDetails;
import com.scommon.action.BaseAction;
import com.scommon.exception.SaveException;
import com.scommon.util.DateTimeUtils;

/**   
 * ClassName:LeaveAction   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-30   
 * @since    leave21.0   
 */
@Controller("leaveAction")
@Scope("prototype")
public class LeaveAction extends BaseAction{
	private LeaveService leaveService;
	private Leaved leave;
	private String leaveId;
	private String taskId;
	private Integer start;
	private Integer limit;
	
	
	/**
	 * 
	 * deploy:流程发布   
	 *   
	 * @param  @return    设定文件   
	 * @return String    DOM对象   
	 * @throws    
	 * @since  leave21.0
	 */
	public String deploy(){
		String path = "/com/sc/leave/jpbm/jpdl/leave.jpdl.xml";
		leaveService.deploy(path);
		return LOGIN;
	}
	
	/**
	 * 
	 * listLeave:查询分页请假列表
	 *   
	 * @param  @return    设定文件   
	 * @return String    DOM对象   
	 * @throws    
	 * @since  leave21.0
	 */
	public void listLeave(){
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext()
	    .getAuthentication()
	    .getPrincipal();
		String leaves = leaveService.getLeaves(userDetails.getId(), start, limit);
		this.out(leaves);
	}
	/**
	 * 
	 * listTask:查询分页任务列表   
	 *   
	 * @param  @return    设定文件   
	 * @return String    DOM对象   
	 * @throws    
	 * @since  jat1.0
	 */
	public void listTask(){
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext()
		.getAuthentication().getPrincipal();
		String tasks = leaveService.getTasks(userDetails.getUsername(), start, limit);
		this.out(tasks);
	}
	/**
	 * 
	 * save:保存请假信息 
	 *   
	 * @param  @return    设定文件   
	 * @return String    DOM对象   
	 * @throws    
	 * @since  leave21.0
	 */
	public String save(){
		String datetime = DateTimeUtils.getStringDate("yyyy-MM-dd");
		leave.setApplyTime(datetime);
		leave.setStatus(0);
		Users user = (Users) getSession().getAttribute("user");
		if(null == user){
			return LOGIN;
		}
		leave.setUsers(user);
		try{
			leaveService.save(leave);
		}catch(SaveException e){
			this.addActionError("save leave is failed...");
			e.printStackTrace();
			return ERROR;
		}
		//String leaves = leaveService.getLeaves(user.getId());
		//String tasks = leaveService.getTasks(user.getUsername());
		return "leaveList";
	}
	/**
	 * 
	 * apply:请假申请
	 *   
	 * @param  @return    设定文件   
	 * @return String    DOM对象   
	 * @throws    
	 * @since  leave21.0
	 */
	public String apply(){
		Users user = (Users) getSession().getAttribute("user");
		leaveService.applyLeave(leaveId, user.getPosition());
		return "leaveList";
	}
	
	/**
	 * 
	 * agree:同意   
	 *   
	 * @param  @return    设定文件   
	 * @return String    DOM对象   
	 * @throws    
	 * @since  leave21.0
	 */
	public String agree(){
		leaveService.agree(taskId);
		return "leaveList";
	}
	
	public String disagree(){
		leaveService.disagree(taskId);
		return "leaveList";
	}
	
	public LeaveService getLeaveService() {
		return leaveService;
	}
	@Resource
	public void setLeaveService(LeaveService leaveService) {
		this.leaveService = leaveService;
	}

	public Leaved getLeave() {
		return leave;
	}

	public void setLeave(Leaved leave) {
		this.leave = leave;
	}

	public String getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}
   