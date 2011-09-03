
/*   
 * @(#)MenuServiceImpl.java 1.0 2011-9-3   
 *   
 * Copyright (c) 2011 SUX, Inc. All Rights Reserved.
 * TRI-SUN PROPRIETTARY/CONFIDENTIAL. Use is subject to license terms. 
 */   
  
package com.sc.jat.service.impl;   

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;

import com.sc.jat.dao.MenuDao;
import com.sc.jat.model.Menu;
import com.sc.jat.service.MenuService;

/**   
 * ClassName:MenuServiceImpl   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux  
 * @version     
 * @since    jat1.0   
 * @Date     2011-9-3        上午10:26:33   
 *   
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService{
	private MenuDao menuDao;
	
	public String getNodeById(String node) {
		List<Menu> menus = menuDao.findByParent(node);  
		return JSONArray.fromObject(menus).toString();   
	}

	public MenuDao getMenuDao() {
		return menuDao;
	}
	@Resource
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
}
   
