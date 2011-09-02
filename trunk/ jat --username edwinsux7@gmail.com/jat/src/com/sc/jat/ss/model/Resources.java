  
package com.sc.jat.ss.model;   

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * ClassName:Resources   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-16   
 * @since    ss31.0   
 */
@Entity(name="Resources")
@Table(name="resources")
public class Resources implements Serializable{
	
	private static final long serialVersionUID = 7345434147187958306L;
	
	private String id;
	private String name;
	private String url;
	private String describle;
	private Integer enabled;
	
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
	
	@Column(name="name", length=32, insertable=true, updatable=true, nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="url", length=20, insertable=true, updatable=true, nullable=false)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescrible() {
		return describle;
	}
	@Column(name="describle", length=20, insertable=true, updatable=true, nullable=false)
	public void setDescrible(String describle) {
		this.describle = describle;
	}
	public Integer getEnabled() {
		return enabled;
	}
	@Column(name="enabled", length=1, insertable=true, updatable=true, nullable=false)
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
}
   
