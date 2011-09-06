
package com.sc.jat.jbpm.dao;   

import java.util.List;

import com.sc.jat.jbpm.model.Leaved;
import com.scommon.exception.SaveException;
import com.scommon.util.PagingBean;

/**   
 * ClassName:LeaveService   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-30   
 * @since    leave21.0   
 */
public interface LeaveDao {

	List<Leaved> findByUserId(String userId);

	Leaved findByLeaveId(String leaveId);

	void save(Leaved leave) throws SaveException;

	void update(Leaved leave);
	/**
	 * 
	 * findByUserIdAndPage:分页请假列表   
	 *   
	 * @param  @param userId
	 * @param  @param start
	 * @param  @param limit
	 * @param  @return    设定文件   
	 * @return PagingBean    DOM对象   
	 * @throws    
	 * @since  jat1.0
	 */
	PagingBean findByUserIdAndPage(String userId, Integer start, Integer limit);

}
   
