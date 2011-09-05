package com.sc.jat.jbpm.action;   

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sc.jat.jbpm.model.Leave;
import com.sc.jat.jbpm.service.LeaveService;
import com.sc.jat.ss.model.Users;
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
	private Leave leave;
	private String leaveId;
	private String taskId;
	
	
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
	 * listLeave:初始化页面，查询出请假及任务列表   
	 *   
	 * @param  @return    设定文件   
	 * @return String    DOM对象   
	 * @throws    
	 * @since  leave21.0
	 */
	public String listLeave(){
		Users user = (Users) getSession().getAttribute("user");
		String leaves = leaveService.getLeaves(user.getId());
		this.out(leaves);
		return null;
	}
	public String listTask(){
		Users user = (Users) getSession().getAttribute("user");
		String tasks = leaveService.getTasks(user.getUsername());
		this.out(tasks);
		return null;
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

	public Leave getLeave() {
		return leave;
	}

	public void setLeave(Leave leave) {
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
}
   
