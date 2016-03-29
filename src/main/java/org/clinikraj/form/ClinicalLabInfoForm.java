package org.clinikraj.form;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;



public class ClinicalLabInfoForm {
	private String dispatch;
	private Integer labId;
	private String labName;
	private String websiteAddress;
	private String emailId;
	private String alternateEmailId;
	private String addressLine1;
	private String addressLine2;
	private String area;
	private Integer postalcode; 
	private String city;
	private String district;
	private String state;
	private String country;
	private Long phoneLandLine;
	private Long emergencyPhoneNumber;
	private Long phoneMobile;
	private Integer phoneFax;
	private String startDate;
	private String endDate;
	private String allowThirdpartyAccess;
	private String remarks;
	private MultipartFile fileupload;
	private Integer client;
	private String clientName;
	private String alertMessage;
	private String activeFlag;
	private String deleteFlag;
	private String captcha;
	private String verifycaptcha;
	private Integer labref;
	private List actflaglistvalue;
	private byte[] storedimage;
	private String termscondt;
	private String privypol;

	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Integer getClient() {
		return client;
	}
	public void setClient(Integer client) {
		this.client = client;
	}
	public Integer getLabId() {
		return labId;
	}
	public void setLabId(Integer labId) {
		this.labId = labId;
	}
	
	public String getDispatch() {
		return dispatch;
	}
	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}
	public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}
	public String getWebsiteAddress() {
		return websiteAddress;
	}
	public void setWebsiteAddress(String websiteAddress) {
		this.websiteAddress = websiteAddress;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAlternateEmailId() {
		return alternateEmailId;
	}
	public void setAlternateEmailId(String alternateEmailId) {
		this.alternateEmailId = alternateEmailId;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(Integer postalcode) {
		this.postalcode = postalcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getPhoneLandLine() {
		return phoneLandLine;
	}
	public void setPhoneLandLine(Long phoneLandLine) {
		this.phoneLandLine = phoneLandLine;
	}
	public Long getEmergencyPhoneNumber() {
		return emergencyPhoneNumber;
	}
	public void setEmergencyPhoneNumber(Long emergencyPhoneNumber) {
		this.emergencyPhoneNumber = emergencyPhoneNumber;
	}
	public Long getPhoneMobile() {
		return phoneMobile;
	}
	public void setPhoneMobile(Long phoneMobile) {
		this.phoneMobile = phoneMobile;
	}
	public Integer getPhoneFax() {
		return phoneFax;
	}
	public void setPhoneFax(Integer phoneFax) {
		this.phoneFax = phoneFax;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getAllowThirdpartyAccess() {
		return allowThirdpartyAccess;
	}
	public void setAllowThirdpartyAccess(String allowThirdpartyAccess) {
		this.allowThirdpartyAccess = allowThirdpartyAccess;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAlertMessage() {
		return alertMessage;
	}
	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public String getVerifycaptcha() {
		return verifycaptcha;
	}
	public void setVerifycaptcha(String verifycaptcha) {
		this.verifycaptcha = verifycaptcha;
	}
	public Integer getLabref() {
		return labref;
	}
	public void setLabref(Integer labref) {
		this.labref = labref;
	}
	public List getActflaglistvalue() {
		return actflaglistvalue;
	}
	public void setActflaglistvalue(List actflaglistvalue) {
		this.actflaglistvalue = actflaglistvalue;
	}
	public byte[] getStoredimage() {
		return storedimage;
	}
	public void setStoredimage(byte[] storedimage) {
		this.storedimage = storedimage;
	}
	public MultipartFile getFileupload() {
		return fileupload;
	}
	public void setFileupload(MultipartFile fileupload) {
		this.fileupload = fileupload;
	}
	public String getTermscondt() {
		return termscondt;
	}
	public void setTermscondt(String termscondt) {
		this.termscondt = termscondt;
	}
	public String getPrivypol() {
		return privypol;
	}
	public void setPrivypol(String privypol) {
		this.privypol = privypol;
	}

	
	
	
}
