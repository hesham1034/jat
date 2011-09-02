
/*   
 * @(#)SysUtils.java 1.0 2011-7-5   
 *   
 * Copyright (c) 2011 SUX, Inc. All Rights Reserved.
 * TRI-SUN PROPRIETTARY/CONFIDENTIAL. Use is subject to license terms. 
 */   
  
package com.scommon.util;   

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

/**   
 * ClassName:SysUtils   
 * Function: 系统工具   
 *   
 * @author   sux  
 * @version     
 * @since    scommon1.0   
 * @Date     2011-7-5        下午09:20:13   
 *   
 */
public class SystemUtils {
	public static String getSysURL(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		return basePath;
	}
}
   
