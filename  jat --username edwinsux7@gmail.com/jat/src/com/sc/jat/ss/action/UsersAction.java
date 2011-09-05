
/*   
 * @(#)UsersAction.java 1.0 2011-9-3   
 *   
 * Copyright (c) 2011 SUX, Inc. All Rights Reserved.
 * TRI-SUN PROPRIETTARY/CONFIDENTIAL. Use is subject to license terms. 
 */   
  
package com.sc.jat.ss.action;   

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sc.jat.ss.service.UsersService;
import com.scommon.action.BaseAction;

/**   
 * ClassName:UsersAction   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux  
 * @version     
 * @since    jat1.0   
 * @Date     2011-9-3        下午10:23:50   
 *   
 */
@Controller("usersAction")
@Scope("prototype")
public class UsersAction extends BaseAction{
	private UsersService usersService;
	private Integer start;
	private Integer limit;
	
	/**
	 * 
	 * list:查询出所有用户信息
	 *   
	 * @param  @return    设定文件   
	 * @return String    DOM对象   
	 * @throws    
	 * @since  jat1.0
	 */
	public String list(){
		String users = usersService.getByPage(start, limit);
		this.out(users);
		return null;
	}

	public UsersService getUsersService() {
		return usersService;
	}
	@Resource
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}
   
