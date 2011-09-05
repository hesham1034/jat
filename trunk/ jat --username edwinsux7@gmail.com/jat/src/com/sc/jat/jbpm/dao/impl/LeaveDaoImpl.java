package com.sc.jat.jbpm.dao.impl;   

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sc.jat.jbpm.dao.LeaveDao;
import com.sc.jat.jbpm.model.Leave;
import com.scommon.dao.BaseDao;
import com.scommon.exception.SaveException;

/**   
 * ClassName:LeaveDaoImpl   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-30   
 * @since    leave21.0   
 */
@Repository("leaveDao")
public class LeaveDaoImpl extends BaseDao<Leave>implements LeaveDao{

	public List<Leave> findByUserId(String userId) {
		String hql = "from Leave where users.userId = ?";  
		return super.findByHQLAndValue(hql, userId);   
	}

	public Leave findByLeaveId(String leaveId) {
		return super.get(leaveId);
	}

	public void save(Leave leave) throws SaveException{
		super.save(leave);
	}

	public void update(Leave leave) {
		super.update(leave);
	}

}
   
