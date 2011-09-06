
/*   
 * @(#)ExceptionAction.java 1.0 2011-6-26   
 *   
 * Copyright (c) 2011 SUX, Inc. All Rights Reserved.
 * TRI-SUN PROPRIETTARY/CONFIDENTIAL. Use is subject to license terms. 
 */   
  
package com.sc.jat.action;   

import org.springframework.stereotype.Controller;

import com.scommon.action.BaseAction;

/**   
 * ClassName:ExceptionAction   
 * Function: 接收后台抛出的异常，根据异常不同类型，友好的显示到前台   
 *   其实可以在每个Action中捕获异常然后再输出异常Json就可以，
 *   但感觉那样太麻烦了。
 * @author   sux  
 * @version     
 * @since    scommon1.0   
 * @Date     2011-6-26        上午11:58:34   
 *   
 */
@Controller("exceptionAction")
public class ExceptionAction extends BaseAction {
	private String message;
	/**
	 * 
	 * saveException:数据保存异常处理方法   
	 *   
	 * @param      设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public void saveException(){
		this.outForException("后台数据保存异常");
	}
	/**
	 * 
	 * deleteException:数据删除异常处理方法 
	 *   
	 * @param      设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public void deleteException(){
		this.outForException("后台数据删除异常");
	}
	/**
	 * 
	 * queryException:数据查询异常处理方法   
	 *   
	 * @param      设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public void queryException(){
		this.outForException("后台数据查询异常");
	}
	
	/**
	 * 
	 * updateException:数据修改异常处理方法   
	 *   
	 * @param      设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public void updateException(){
		this.outForException("后台数据修改异常");
	}
	
	/**
	 * 
	 * exception:后台所有异常
	 *   
	 * @param      设定文件   
	 * @return void    DOM对象   
	 * @throws    
	 * @since  scommon1.0
	 */
	public void exception(){
		//TODO 这样只得到异常类型，没能定位，若传入exceptionStack，则参数长度又会超出。
		log.error(message);
		this.outForException("后台异常");
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
   
