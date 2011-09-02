
package com.sc.jat.ss.dao;   

import java.util.List;

import com.sc.jat.ss.model.Users;
import com.scommon.bean.jqGrid.PageParamBean;
import com.scommon.bean.jqGrid.PageResultBean;
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
	/**
	 * 
	 * findByCols:查询要求显示的列   
	 *   
	 * @param  @param cols
	 * @param  @return    设定文件   
	 * @return List<Users>    DOM对象   
	 * @throws    
	 * @since  ss31.0
	 */
	List<Users> findByCols(List cols);
	/**
	 * 
	 * findByPageParamBean:分页查询
	 *   
	 * @param  @param pageParamBean
	 * @param  @return    设定文件   
	 * @return List<Users>    DOM对象   
	 * @throws    
	 * @since  ss31.0
	 */
	PageResultBean findByPageParamBean(PageParamBean pageParamBean);
	/**
	 * 
	 * findTotal:查询总记录数 
	 *   
	 * @param  @return    设定文件   
	 * @return int    DOM对象   
	 * @throws    
	 * @since  ss31.0
	 */
	int findTotal();

}
   
