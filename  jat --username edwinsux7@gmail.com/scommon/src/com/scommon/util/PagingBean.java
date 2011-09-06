
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
	private List<?> root;
	
	public PagingBean(){
		
	}
	public PagingBean(Integer totalProperty, List<?>  root){
		this.totalProperty = totalProperty;
		this.root = root;
	}
	
	public Integer getTotalProperty() {
		return totalProperty;
	}
	public void setTotalProperty(Integer totalProperty) {
		this.totalProperty = totalProperty;
	}
	public List<?>  getRoot() {
		return root;
	}
	public void setRoot(List<?>  root) {
		this.root = root;
	}
}
   
