
/*   
 * @(#)UserServiceImpl.java 1.0 2011-9-5   
 *   
 * Copyright (c) 2011 SUX, Inc. All Rights Reserved.
 * TRI-SUN PROPRIETTARY/CONFIDENTIAL. Use is subject to license terms. 
 */   
  
package com.sc.jat.ss.service.impl;   

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.sc.jat.ss.dao.UsersDao;
import com.sc.jat.ss.service.UsersService;
import com.scommon.util.PagingBean;

/**   
 * ClassName:UserServiceImpl   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux  
 * @version     
 * @since    jat1.0   
 * @Date     2011-9-5        下午09:31:02   
 *   
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService{
	private UsersDao usersDao;
	
	public String getByPage(Integer start, Integer limit) {
		return usersDao.findByPage(start, limit);   
	}
	
	public UsersDao getUsersDao() {
		return usersDao;
	}
	@Resource
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
}
   
