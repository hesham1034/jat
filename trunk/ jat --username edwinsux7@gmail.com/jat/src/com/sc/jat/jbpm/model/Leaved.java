
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
	private Long applyTime;
	private Integer status;
	private String content;
	private String taskId;
	private Long startTime;
	private Long endTime;
	private Long addTime;
	private String auditContent;
	
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
	@Basic(optional=true)
	@Column(name="apply_time",insertable=true,updatable=true,length=30)
	public Long getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Long applyTime) {
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
	@Column(name="content",insertable=true,updatable=true,length=200)
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
	@Column(name="start_time", insertable=true, updatable=true)
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	@Column(name="end_time", insertable=true, updatable=true)
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	@Column(name="add_time", insertable=true, updatable=true)
	public Long getAddTime() {
		return addTime;
	}
	public void setAddTime(Long addTime) {
		this.addTime = addTime;
	}
	@Column(name="audit_content",insertable=true,updatable=true,length=200)
	public String getAuditContent() {
		return auditContent;
	}
	public void setAuditContent(String auditContent) {
		this.auditContent = auditContent;
	}
}
   
