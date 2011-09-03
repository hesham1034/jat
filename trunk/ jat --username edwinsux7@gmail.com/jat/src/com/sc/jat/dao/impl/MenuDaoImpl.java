
/*   
 * @(#)MenuDaoImpl.java 1.0 2011-9-3   
 *   
 * Copyright (c) 2011 SUX, Inc. All Rights Reserved.
 * TRI-SUN PROPRIETTARY/CONFIDENTIAL. Use is subject to license terms. 
 */   
  
package com.sc.jat.dao.impl;   

import java.util.List;

import org.springframework.stereotype.Service;

import com.sc.jat.dao.MenuDao;
import com.sc.jat.model.Menu;
import com.scommon.dao.BaseDao;

/**   
 * ClassName:MenuDaoImpl   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux  
 * @version     
 * @since    jat1.0   
 * @Date     2011-9-3        上午10:28:42   
 *   
 */
@Service("menuDao")
public class MenuDaoImpl extends BaseDao<Menu> implements MenuDao{

	public List<Menu> findByParent(String node) {
		return super.findByProperty("parent", node);  
	}

}
   
