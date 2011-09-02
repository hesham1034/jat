
package com.sc.jat.ss.model;   

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * ClassName:Roles   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-16   
 * @since    ss31.0   
 */
@Entity(name="Roles")
@Table(name="roles")
public class Roles implements Serializable{
	private static final long serialVersionUID = 327317550335441398L;
	private String id;
	private String name;
	
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
	@Column(name="name", length=30, insertable=true, updatable=true, nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
   
