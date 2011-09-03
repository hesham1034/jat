
/*   
 * @(#)MenuAction.java 1.0 2011-9-3   
 *   
 * Copyright (c) 2011 SUX, Inc. All Rights Reserved.
 * TRI-SUN PROPRIETTARY/CONFIDENTIAL. Use is subject to license terms. 
 */   
  
package com.sc.jat.action;   

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sc.jat.service.MenuService;
import com.scommon.action.BaseAction;
import com.scommon.util.SystemUtils;

/**   
 * ClassName:MenuAction   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux  
 * @version     
 * @since    jat1.0   
 * @Date     2011-9-3        上午10:24:58   
 *   
 */
@Controller("menuAction")
@Scope("prototype")
public class MenuAction extends BaseAction{
	private MenuService menuService;
	/**
	 * 异步加载菜单传入的节点ID
	 */
	private String node;
	/**
	 * 
	 * load:加载菜单   
	 *   
	 * @param  @throws IOException    设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  jat1.0
	 */
	public void load() throws IOException{
		String menuJson = null;
		if(!SystemUtils.isEmpty(node)){
			menuJson =  menuService.getNodeById(node);
		}
		this.out(menuJson);
	}
	
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public MenuService getMenuService() {
		return menuService;
	}
	@Resource
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
}
   
