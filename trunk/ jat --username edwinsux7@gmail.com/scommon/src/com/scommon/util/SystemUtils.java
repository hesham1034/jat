
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
	/**
	 * 
	 * getSysURL:获取系统路径   
	 *   
	 * @param  @return    设定文件   
	 * @return String    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public static String getSysURL(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		return basePath;
	}

	/**
	 * 
	 * isEmpty:判断是否为空
	 *   
	 * @param  @param value
	 * @param  @return    空返回true   
	 * @return boolean    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public static boolean isEmpty(String value) {
		if(null != value && !"".equals(value)){
			return false;
		}
		return false;   
	}
}
   
