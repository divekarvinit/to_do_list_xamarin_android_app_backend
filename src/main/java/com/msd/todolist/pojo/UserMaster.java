package com.msd.todolist.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/* UserMaster pojo by VINIT DIVEKAR- 17960822 STARTS*/ 
public class UserMaster {

	private String userName;
	private String emailId;
	private String password;
	private String firstName;
	private String lastName;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date joiningDate;
	private String createdBy;
	private String modifiedBy;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifiedDate;
	
	
	public UserMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserMaster(String userName, String emailId, String password, String firstName, String lastName,
			Date joiningDate, String createdBy, String modifiedBy, Date createdDate, Date modifiedDate) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.joiningDate = joiningDate;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}
/* UserMaster pojo by VINIT DIVEKAR- 17960822 ENDS*/
