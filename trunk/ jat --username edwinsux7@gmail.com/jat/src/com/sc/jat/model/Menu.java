
/*   
 * @(#)Menu.java 1.0 2011-9-3   
 *   
 * Copyright (c) 2011 SUX, Inc. All Rights Reserved.
 * TRI-SUN PROPRIETTARY/CONFIDENTIAL. Use is subject to license terms. 
 */   
  
package com.sc.jat.model;   

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**   
 * ClassName:Menu   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux  
 * @version     
 * @since    jat1.0   
 * @Date     2011-9-3        上午10:10:38   
 *   
 */
@Entity(name="Menu")
@Table(name="menu")
public class Menu {
	private String id;
	private String text;
	private String parent;
	private Integer leaf;
	private String url;
	private String icon;
	
	@Id
	@GenericGenerator(name="system-uuid", strategy="com.scommon.util.UUIDGenerator")
	@GeneratedValue(generator="system-uuid")
	@Column(name="id", length=32, insertable=true, updatable=true, nullable=false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name="parent", length=32, insertable=true, updatable=true, nullable=true)
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	@Column(name="text", length=20, insertable=true, updatable=true, nullable=false)
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Column(name="leaf", length=1, insertable=true, updatable=true, nullable=false)
	public Integer getLeaf() {
		return leaf;
	}
	public void setLeaf(Integer leaf) {
		this.leaf = leaf;
	}
	@Column(name="url", length=100, insertable=true, updatable=true, nullable=true)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Column(name="icon", length=100, insertable=true, updatable=true, nullable=true)
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
}
   
