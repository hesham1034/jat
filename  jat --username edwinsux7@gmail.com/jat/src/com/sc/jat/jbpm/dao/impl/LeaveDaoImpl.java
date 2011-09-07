package com.sc.jat.jbpm.dao.impl;   

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sc.jat.jbpm.dao.LeaveDao;
import com.sc.jat.jbpm.model.Leaved;
import com.scommon.dao.BaseDao;
import com.scommon.exception.SaveException;
import com.scommon.util.PagingBean;

/**   
 * ClassName:LeaveDaoImpl   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-30   
 * @since    leave21.0   
 */
@Repository("leaveDao")
public class LeaveDaoImpl extends BaseDao<Leaved>implements LeaveDao{

	public List<Leaved> findByUserId(String userId) {
		String hql = "from Leaved where users.id = ?";  
		return super.findByHQLAndValue(hql, userId);   
	}

	public Leaved findByLeaveId(String leaveId) {
		return super.get(leaveId);
	}

	public void save(Leaved leave) throws SaveException{
		super.save(leave);
	}

	public void update(Leaved leave) {
		super.update(leave);
	}

	public PagingBean findByUserIdAndPage(String userId, Integer start, Integer limit) {
		String hql = "from Leaved where users.id = '"+userId+"'";  
		return super.findStringByPage(hql, start, limit);   
	}

	public Leaved getById(String leaveId) {
		return super.get(leaveId);   
	}
}
   
