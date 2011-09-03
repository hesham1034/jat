
/*   
 * @(#)ValidateCodeFilter.java 1.0 2011-9-3   
 *   
 * Copyright (c) 2011 SUX, Inc. All Rights Reserved.
 * TRI-SUN PROPRIETTARY/CONFIDENTIAL. Use is subject to license terms. 
 */   
  
package com.sc.jat.ss.filter;   

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**   
 * ClassName:ValidateCodeFilter   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux  
 * @version     
 * @since    jat1.0   
 * @Date     2011-9-3        上午12:21:02   
 *   
 */
public class ValidateCodeFilter implements Filter{

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse rsp = (HttpServletResponse)response;
		String code = (String) req.getSession().getAttribute("validateCode");
		String inputCode = req.getParameter("j_code");
		if(null != code && null != inputCode && !"".equals(code) && !"".equals(inputCode)){
			if(inputCode.equals(code)){
				chain.doFilter(req, rsp);
			}else{
				rsp.sendRedirect("login.jsp?message=1");
			}
		}else{
			rsp.sendRedirect("login.jsp?message=1");
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
   
