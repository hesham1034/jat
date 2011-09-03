
/*   
 * @(#)MenuService.java 1.0 2011-9-3   
 *   
 * Copyright (c) 2011 SUX, Inc. All Rights Reserved.
 * TRI-SUN PROPRIETTARY/CONFIDENTIAL. Use is subject to license terms. 
 */   
  
package com.sc.jat.service;   
/**   
 * ClassName:MenuService   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux  
 * @version     
 * @since    jat1.0   
 * @Date     2011-9-3        上午10:25:56   
 *   
 */
public interface MenuService {
	/**
	 * 
	 * getNodeById:查询子节点   
	 *   
	 * @param  @param node
	 * @param  @return    设定文件   
	 * @return String    返回json字符串   
	 * @throws    
	 * @since  jat1.0
	 */
	String getNodeById(String node);

}
   
