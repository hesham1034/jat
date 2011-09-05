
package com.sc.jat.ss.dao;   

import com.sc.jat.ss.model.Users;
import com.scommon.exception.QueryException;
import com.scommon.util.PagingBean;

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
	/**
	 * 
	 * findByPage:查询分页结果    
	 *   
	 * @param  @param start
	 * @param  @param limit
	 * @param  @return    设定文件   
	 * @return PagingBean    DOM对象   
	 * @throws    
	 * @since  jat1.0
	 */
	String findByPage(Integer start, Integer limit);

}
   
