
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
 * ClassName:RoleAuthorities   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-16   
 * @since    ss31.0   
 */
@Entity(name="RoleAuthorities")
@Table(name="role_authorities")
public class RoleAuthorities implements Serializable{
	private static final long serialVersionUID = -2043124343432916359L;
	private String id;
	private Roles role;
	private Authorities authorities;
	
	@Id
	@GenericGenerator(name="system-uuid",strategy="com.scommon.util.UUIDGenerator")
	@GeneratedValue(generator="system-uuid")
	@Column(name="id",insertable=true,nullable=false,updatable=true, length=32)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity=Roles.class)
	@JoinColumn(name="role", referencedColumnName="id")
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	@ManyToOne(targetEntity=Authorities.class)
	@JoinColumn(name="authorities", referencedColumnName="id")
	public Authorities getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Authorities authorities) {
		this.authorities = authorities;
	}
}
   
