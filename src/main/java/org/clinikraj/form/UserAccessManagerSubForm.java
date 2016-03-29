package org.clinikraj.form;

import java.util.Date;

import org.clinikraj.model.ClinicalLab;

public class UserAccessManagerSubForm implements java.io.Serializable {
	
	private Integer userId;
	private String userName;
	private String role;
    private String userType;
    private String postOfficeCode;
    private String preferredContact;
    private String phoneMobile;
    private String emailID;
    private Integer refId;
    private String defaultPasswordChanged;
	 private String userActive;
	 private String userDelete;
	 private Date startDate;
	 private Date endDate;
	 private Date successLogin;
	 private Date failedLogin;
	 private Date nextPasswordChangeDate;
	 private Integer lastSessionId;
	 private String remarks;
    
	public Integer getRefId() {
		return refId;
	}
	public void setRefId(Integer refId) {
		this.refId = refId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPostOfficeCode() {
		return postOfficeCode;
	}
	public void setPostOfficeCode(String postOfficeCode) {
		this.postOfficeCode = postOfficeCode;
	}
	public String getPreferredContact() {
		return preferredContact;
	}
	public void setPreferredContact(String preferredContact) {
		this.preferredContact = preferredContact;
	}
	public String getPhoneMobile() {
		return phoneMobile;
	}
	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getDefaultPasswordChanged() {
		return defaultPasswordChanged;
	}
	public void setDefaultPasswordChanged(String defaultPasswordChanged) {
		this.defaultPasswordChanged = defaultPasswordChanged;
	}
	public String getUserActive() {
		return userActive;
	}
	public void setUserActive(String userActive) {
		this.userActive = userActive;
	}
	public String getUserDelete() {
		return userDelete;
	}
	public void setUserDelete(String userDelete) {
		this.userDelete = userDelete;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getSuccessLogin() {
		return successLogin;
	}
	public void setSuccessLogin(Date successLogin) {
		this.successLogin = successLogin;
	}
	public Date getFailedLogin() {
		return failedLogin;
	}
	public void setFailedLogin(Date failedLogin) {
		this.failedLogin = failedLogin;
	}
	public Date getNextPasswordChangeDate() {
		return nextPasswordChangeDate;
	}
	public void setNextPasswordChangeDate(Date nextPasswordChangeDate) {
		this.nextPasswordChangeDate = nextPasswordChangeDate;
	}
	public Integer getLastSessionId() {
		return lastSessionId;
	}
	public void setLastSessionId(Integer lastSessionId) {
		this.lastSessionId = lastSessionId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
    	
    

}
