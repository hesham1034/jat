
/*   
 * @(#)UserService.java 1.0 2011-9-5   
 *   
 * Copyright (c) 2011 SUX, Inc. All Rights Reserved.
 * TRI-SUN PROPRIETTARY/CONFIDENTIAL. Use is subject to license terms. 
 */   
  
package com.sc.jat.ss.service;   
/**   
 * ClassName:UserService   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux  
 * @version     
 * @since    jat1.0   
 * @Date     2011-9-5        下午09:30:15   
 *   
 */
public interface UsersService {
	/**
	 * 
	 * getByPage:分页查询   
	 *   
	 * @param  @param start
	 * @param  @param limit
	 * @param  @return    设定文件   
	 * @return String    DOM对象   
	 * @throws    
	 * @since  jat1.0
	 */
	String getByPage(Integer start, Integer limit);

}
   
