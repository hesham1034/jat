
package com.sc.jat.jbpm.dao;   

import java.util.List;

import com.sc.jat.jbpm.model.Leave;

/**   
 * ClassName:LeaveService   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-30   
 * @since    leave21.0   
 */
public interface LeaveDao {

	List<Leave> findByUserId(String userId);

	Leave findByLeaveId(String leaveId);

	void save(Leave leave);

	void update(Leave leave);

}
   
