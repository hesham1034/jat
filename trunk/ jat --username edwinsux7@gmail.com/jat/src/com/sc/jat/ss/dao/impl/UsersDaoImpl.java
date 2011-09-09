  
package com.sc.jat.ss.dao.impl;   

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sc.jat.ss.dao.UsersDao;
import com.sc.jat.ss.model.Users;
import com.scommon.dao.BaseDao;
import com.scommon.util.PagingBean;

/**   
 * ClassName:UsersDaoImpl   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-16   
 * @since    ss31.0   
 */
@Repository("userDao")
public class UsersDaoImpl extends BaseDao<Users> implements UsersDao{

	public Users findByUsername(String username){
		List<Users> users = super.findByProperty("username", username);
		if(users.size() > 0){
			return users.get(0);
		}
		return null;   
	}

	public List<Users> findByCols(List cols) {
		StringBuffer hql = new StringBuffer("SELECT ");
		for(int i = 0; i < cols.size(); i++){
			hql.append(cols.get(i));
			if(i != (cols.size() -1)){
				hql.append(",");
			}
		}
		hql.append("FROM Users");
		return null;   
	}

	public PagingBean findByPage(Integer start, Integer limit) {
		String hql = "FROM Users";
		return findStringByPage(hql, start, limit);
	}

	public List<Users> findUsersByPosition(String position) {
		return findByProperty("position", position);  
	}
}
   
