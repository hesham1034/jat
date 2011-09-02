package com.sc.jat.ss.model;   

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * ClassName:Users   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-16   
 * @since    ss31.0   
 */
@Entity(name="Users")
@Table(name="users")
public class Users implements Serializable{

	private static final long serialVersionUID = -4411488267872227925L;
	
	private String id;
	private String username;
	private String password;
	private Integer enabled;
	private Roles role;
	
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
	@Column(name="username", length=20, insertable=true, updatable=true, nullable=false)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="password", length=50, insertable=true, updatable=true, nullable=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="enabled", length=1, insertable=true, updatable=true, nullable=false)
	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	
	@ManyToOne(targetEntity=Roles.class)
	@JoinColumn(name="role", referencedColumnName="id")
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
}
   
