
package com.sc.jat.ss.dao;   

import java.util.List;

/**   
 * ClassName:AuthoritiesDao   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-16   
 * @since    ss31.0   
 */
public interface AuthoritiesDao {

	/**
	 * 
	 * findByUsername:根据用户名查询出所有权限名称的集合   
	 *   
	 * @param  @param username
	 * @param  @return    设定文件   
	 * @return List<String>    DOM对象   
	 * @throws    
	 * @since  ss31.0
	 */
	List<String> findNameByUsername(String username);
	/**
	 * 
	 * findNameByUrl:按资源请求地址查询出所有权限名称集合   
	 *   
	 * @param  @param url
	 * @param  @return    设定文件   
	 * @return List<String>    DOM对象   
	 * @throws    
	 * @since  ss31.0
	 */
	List<String> findNameByUrl(String url);

}
   
