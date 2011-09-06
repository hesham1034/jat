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
	 * @throws    
	 * @since  leave21.0
	 */
	public void deploy(String path);
	
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

	public void save(Leaved leave) throws SaveException;
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
	 * agree:处理同意请求   
	 *   
	 * @param  @param taskId    设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  leave21.0
	 */
	public void agree(String taskId);
	/**
	 * disagree:请求不同意
	 *   
	 * @param  @param taskId    设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  leave21.0
	 */
	public void disagree(String taskId);
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
}
   
