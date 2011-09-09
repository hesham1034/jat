package com.sc.jat.jbpm.service;   

import java.util.List;

import com.sc.jat.jbpm.model.Leaved;
import com.scommon.exception.SaveException;

/**   
 * ClassName:LeaveService   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-30   
 * @since    leave21.0   
 */
public interface LeaveService {
	/**
	 * 
	 * deploy:发布新流程   
	 *   
	 * @param  @param path    设定文件   
	 * @return void    DOM对象   
	 * @throws Exception 
	 * @throws    
	 * @since  leave21.0
	 */
	public void deploy(String path) throws Exception;
	
	/**
	 * 
	 * getLeaves:请假列表
	 *   
	 * @param  @param userId
	 * @param  @return    设定文件   
	 * @return List<Leave>    DOM对象   
	 * @throws    
	 * @since  leave21.0
	 */
	public String getLeaves(String userId);

	/**
	 * 
	 * getTasks:任务列表   
	 *   
	 * @param  @param loginName
	 * @param  @return    设定文件   
	 * @return List<Leave>    DOM对象   
	 * @throws    
	 * @since  leave21.0
	 */
	public String getTasks(String loginName);

	/**
	 * 
	 * save:保存
	 *   
	 * @param  @param leave
	 * @param  @param position
	 * @param  @return
	 * @param  @throws SaveException    设定文件   
	 * @return String    下一任务名称   
	 * @throws    
	 * @since  jat1.0
	 */
	public String save(Leaved leave, String position) throws SaveException;
	/**
	 * 
	 * applyLeave:申请请假
	 *   
	 * @param  @param leaveId
	 * @param  @param position    设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  leave21.0
	 */
	public void applyLeave(String leaveId, String position);
	/**
	 * 
	 * getLeaves:请假列表分页
	 *   
	 * @param  @param id
	 * @param  @param start
	 * @param  @param limit
	 * @param  @return    设定文件   
	 * @return String    DOM对象   
	 * @throws    
	 * @since  jat1.0
	 */
	public String getLeaves(String userId, Integer start, Integer limit);
	/**
	 * 
	 * getTasks:任务列表分页
	 *   
	 * @param  @param username
	 * @param  @param start
	 * @param  @param limit
	 * @param  @return    设定文件   
	 * @return String    DOM对象   
	 * @throws    
	 * @since  jat1.0
	 */
	public String getTasks(String username, Integer start, Integer limit);
	/**
	 * 
	 * getById:按id查询   
	 *   
	 * @param  @param string
	 * @param  @return    设定文件   
	 * @return String    DOM对象   
	 * @throws    
	 * @since  jat1.0
	 */
	public String getById(String leaveId);
	/**
	 * 
	 * updateLeaveStatus:审核修改状态  
	 *   
	 * @param  @param taskId
	 * @param  @param leave    设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  jat1.0
	 */
	public void updateLeaveStatus(String taskId, Leaved leave);
	/**
	 * 
	 * getNextPerson:获取下一任务的候选人   
	 *   
	 * @param  @param nextTaskName
	 * @param  @return    设定文件   
	 * @return String    DOM对象   
	 * @throws Exception 
	 * @throws    
	 * @since  jat1.0
	 */
	public String getNextPerson(String nextTaskName) throws Exception;
	/**
	 * 
	 * getNextTaskName:取得下一任务名称
	 *   
	 * @param  @param position
	 * @param  @return    设定文件   
	 * @return String    DOM对象   
	 * @throws    
	 * @since  jat1.0
	 */
	public String getNextTaskName(String position);
}
   
