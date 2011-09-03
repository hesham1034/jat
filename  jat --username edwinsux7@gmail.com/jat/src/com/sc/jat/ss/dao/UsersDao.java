
package com.sc.jat.ss.dao;   

import com.sc.jat.ss.model.Users;
import com.scommon.exception.QueryException;

/**   
 * ClassName:UsersDao   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-16   
 * @since    ss31.0   
 */
public interface UsersDao {
	/**
	 * 
	 * findByUsername:按用户名查询   
	 *   
	 * @param  @param username
	 * @param  @return    设定文件   
	 * @return Users    DOM对象   
	 * @throws    
	 * @since  ss31.0
	 */
	Users findByUsername(String username) throws QueryException;

}
   
