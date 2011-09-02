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
 * ClassName:AuthoritiesResources   
 * Function: TODO ADD FUNCTION   
 *   
 * @author   sux   
 * @version  1.0, 2011-8-16   
 * @since    ss31.0   
 */
@Entity(name="AuthoritiesResources")
@Table(name="authorities_resources")
public class AuthoritiesResources implements Serializable{
	private static final long serialVersionUID = -8610774946883956375L;
	private String id;
	private Authorities authorities;
	private Resources resource;
	
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
	@ManyToOne(targetEntity=Authorities.class)
	@JoinColumn(name="authorities", referencedColumnName="id")
	public Authorities getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Authorities authorities) {
		this.authorities = authorities;
	}
	@ManyToOne(targetEntity=Resources.class)
	@JoinColumn(name="resource", referencedColumnName="id")
	public Resources getResource() {
		return resource;
	}
	public void setResource(Resources resource) {
		this.resource = resource;
	}
}
   
