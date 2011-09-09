
package com.sc.jat.ss.dao;   

import java.util.List;

import com.scommon.util.PagingBean;

/**   
 * ClassName:ResourcesDao   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-16   
 * @since    ss31.0   
 */
public interface ResourcesDao {
	/**
	 * 
	 * findAllUrl:查询出所有url的集合   
	 *   
	 * @param  @return    设定文件   
	 * @return List<String>    DOM对象   
	 * @throws    
	 * @since  ss31.0
	 */
	List<String> findAllUrl();

	PagingBean findByPage(int start, int limit);

}
   
