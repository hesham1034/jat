
/*   
 * @(#)MenuDao.java 1.0 2011-9-3   
 *   
 * Copyright (c) 2011 SUX, Inc. All Rights Reserved.
 * TRI-SUN PROPRIETTARY/CONFIDENTIAL. Use is subject to license terms. 
 */   
  
package com.sc.jat.dao;   

import java.util.List;

import com.sc.jat.model.Menu;

/**   
 * ClassName:MenuDao   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux  
 * @version     
 * @since    jat1.0   
 * @Date     2011-9-3        上午10:28:15   
 *   
 */
public interface MenuDao {
	/**
	 * 
	 * findByParent:按父节点查询子节点    
	 *   
	 * @param  @param node
	 * @param  @return    设定文件   
	 * @return List<Menu>    DOM对象   
	 * @throws    
	 * @since  jat1.0
	 */
	List<Menu> findByParent(String node);

}
   
