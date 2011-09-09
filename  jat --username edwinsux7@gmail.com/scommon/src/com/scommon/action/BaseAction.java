package com.scommon.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	protected Log log = LogFactory.getLog(BaseAction.class);
	
	public HttpServletResponse getResponse(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		return response;
	}
	
	public HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
	public HttpSession getSession(){
		return getRequest().getSession();
	}
	
	public void out(String json){
		PrintWriter out = null;
		try {
			out = this.getResponse().getWriter();
			out.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			this.closeOut(out);
		}
	}
	/**
	 * 
	 * outForExt:ajax请求成功时返回信息 
	 *   
	 * @param  @param msg    设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public void outForSuccess(String msg){
		this.out("{success: true, msg: '"+msg+"'}");
	}
	/**
	 * 
	 * outForExt:ajax请求成功时返回信息 
	 *   
	 * @param  @param msg    设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public void outForSuccess(String msg, String other){
		this.out("{success: true, msg: '"+msg+"', other: '"+other+"'}");
	}
	/**
	 * 
	 * outForException:系统异常时返回信息
	 *   
	 * @param  @param msg    设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public void outForException(String msg){
		this.out("{exception: true, msg: '"+msg+"'}");
	}
	
	public void closeOut(PrintWriter out) {
		if(null != out){
			out.close();
		}
	}
}
