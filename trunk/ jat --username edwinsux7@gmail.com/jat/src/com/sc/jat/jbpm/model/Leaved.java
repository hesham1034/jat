
package com.sc.jat.jbpm.model;   

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.sc.jat.ss.model.Users;

/**   
 * ClassName:Leave2   
 * Function: 请假实体类   
 * 实例命名时注意关键字引起sql查询出错  
 * @author   sux   
 * @version  1.0, 2011-8-30   
 * @since    leave21.0   
 */
@Entity(name="Leaved")
@Table(name="leaved")
public class Leaved {
	private String id;
	private Users users;
	private Integer day;
	private String applyTime;
	private Integer status;
	private String content;
	private String taskId;
	
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "com.scommon.util.UUIDGenerator")
	@GeneratedValue(generator = "system-uuid")
	@Column(name = "id", nullable = false, insertable = true, updatable = true, length = 32)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity=Users.class)
	@JoinColumn(name="users",referencedColumnName="id",insertable=true,updatable=true)
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	@Basic(optional=false)
	@Column(name="day",insertable=true,updatable=true,length=5)
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	@Basic(optional=false)
	@Column(name="apply_time",insertable=true,updatable=true,length=30)
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	@Basic(optional=true)
	@Column(name="status",insertable=true,updatable=true)
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Basic(optional=false)
	@Column(name="content",insertable=true,updatable=true,length=1000)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Transient
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
}
   
