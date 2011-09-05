
/*   
 * @(#)PagingBean.java 1.0 2011-9-5   
 *   
 * Copyright (c) 2011 SUX, Inc. All Rights Reserved.
 * TRI-SUN PROPRIETTARY/CONFIDENTIAL. Use is subject to license terms. 
 */   
  
package com.scommon.util;   

import java.util.List;

/**   
 * ClassName:PagingBean   
 * Function: 分页Bean
 *   
 * @author   sux  
 * @version     
 * @since    jat1.0   
 * @Date     2011-9-5        下午09:40:53   
 *   
 */
public class PagingBean {
	private Integer totalProperty;
	/**
	 * 不能传入集合再转为json，因为要求root为一Json对象而不是数组
	 */
	private String root;
	
	public PagingBean(Integer totalProperty, String root){
		this.totalProperty = totalProperty;
		this.root = root;
	}
	
	public Integer getTotalProperty() {
		return totalProperty;
	}
	public void setTotalProperty(Integer totalProperty) {
		this.totalProperty = totalProperty;
	}
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
}
   
