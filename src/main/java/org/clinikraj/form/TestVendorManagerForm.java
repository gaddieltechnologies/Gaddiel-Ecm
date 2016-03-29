package org.clinikraj.form;

import java.util.Date;
import java.util.List;

public class TestVendorManagerForm {

	 private List<TestVendorManagerSubForm> vendorDetailSubForm;
	
	 private Integer testVendorId;
     private Integer clinicalLab;
     private String createdBy;
     private Date createdDate;
     private String lastUpdatedBy;
     private Date lastUpdatedDate;
     private String testVendorName;
     private String testVendorRegnNumber;
     private String tieUp;
     private String vendorContactName;
     private String emailId;
     private String alternateEmailId;
     private String addressLine1;
     private String addressLine2;
     private String area;
     private Integer postOfficeCode;
     private String city;
     private String district;
     private String state;
     private String country;
     private Long phoneLandline;
     private Long emergencyPhoneNumber;
     private Long phoneMobile;
     private Long phoneFax;
     private Date startDate;
     private Date endDate;
     private String activeFlag;
     private String deleteFlag;
     private String preferredContactMethod;
     private String smsAlerts;
     private String remarks;
     private String allowThirdPartyAccess;
     
        private String createuser;
        private String dispatch;
        private String dispatchGridView;	
		private String searchTestvendorName;
	 	private String searchPhoneMobile;
	 	private String searchEmailId;
	 	private String searchContactName;
        private String searchPostalcode;     
        
        private List tieuplistvalue;
        private List smslisttype;
        private List prefferedlisttype;
        private String dispatchid;
        
        private List<TestVendorManagerSubForm> testvendordetailsubform;
        
	 public List<TestVendorManagerSubForm> getVendorDetailSubForm() {
			return vendorDetailSubForm;
		}

		public void setVendorDetailSubForm(
				List<TestVendorManagerSubForm> vendorDetailSubForm) {
			this.vendorDetailSubForm = vendorDetailSubForm;
		}

	public Integer getTestVendorId() {
		return testVendorId;
	}

	public void setTestVendorId(Integer testVendorId) {
		this.testVendorId = testVendorId;
	}

	public Integer getClinicalLab() {
		return clinicalLab;
	}

	public void setClinicalLab(Integer clinicalLab) {
		this.clinicalLab = clinicalLab;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getTestVendorName() {
		return testVendorName;
	}

	public void setTestVendorName(String testVendorName) {
		this.testVendorName = testVendorName;
	}

	public String getTestVendorRegnNumber() {
		return testVendorRegnNumber;
	}

	public void setTestVendorRegnNumber(String testVendorRegnNumber) {
		this.testVendorRegnNumber = testVendorRegnNumber;
	}

	public String getTieUp() {
		return tieUp;
	}

	public void setTieUp(String tieUp) {
		this.tieUp = tieUp;
	}

	public String getVendorContactName() {
		return vendorContactName;
	}

	public void setVendorContactName(String vendorContactName) {
		this.vendorContactName = vendorContactName;
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

	public Integer getPostOfficeCode() {
		return postOfficeCode;
	}

	public void setPostOfficeCode(Integer postOfficeCode) {
		this.postOfficeCode = postOfficeCode;
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

	public Long getPhoneLandline() {
		return phoneLandline;
	}

	public void setPhoneLandline(Long phoneLandline) {
		this.phoneLandline = phoneLandline;
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

	public Long getPhoneFax() {
		return phoneFax;
	}

	public void setPhoneFax(Long phoneFax) {
		this.phoneFax = phoneFax;
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

	public String getPreferredContactMethod() {
		return preferredContactMethod;
	}

	public void setPreferredContactMethod(String preferredContactMethod) {
		this.preferredContactMethod = preferredContactMethod;
	}

	public String getSmsAlerts() {
		return smsAlerts;
	}

	public void setSmsAlerts(String smsAlerts) {
		this.smsAlerts = smsAlerts;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	public List<TestVendorManagerSubForm> getTestvendordetailsubform() {
		return testvendordetailsubform;
	}

	public void setTestvendordetailsubform(List<TestVendorManagerSubForm> testvendordetailsubform) {
		this.testvendordetailsubform = testvendordetailsubform;
	}

	public String getDispatch() {
		return dispatch;
	}

	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}

	public String getDispatchGridView() {
		return dispatchGridView;
	}

	public void setDispatchGridView(String dispatchGridView) {
		this.dispatchGridView = dispatchGridView;
	}

	public String getSearchTestvendorName() {
		return searchTestvendorName;
	}

	public void setSearchTestvendorName(String searchTestvendorName) {
		this.searchTestvendorName = searchTestvendorName;
	}

	public String getSearchPhoneMobile() {
		return searchPhoneMobile;
	}

	public void setSearchPhoneMobile(String searchPhoneMobile) {
		this.searchPhoneMobile = searchPhoneMobile;
	}

	public String getSearchEmailId() {
		return searchEmailId;
	}

	public void setSearchEmailId(String searchEmailId) {
		this.searchEmailId = searchEmailId;
	}

	public String getSearchContactName() {
		return searchContactName;
	}

	public void setSearchContactName(String searchContactName) {
		this.searchContactName = searchContactName;
	}

	public String getSearchPostalcode() {
		return searchPostalcode;
	}

	public void setSearchPostalcode(String searchPostalcode) {
		this.searchPostalcode = searchPostalcode;
	}

	public List getTieuplistvalue() {
		return tieuplistvalue;
	}

	public void setTieuplistvalue(List tieuplistvalue) {		
		this.tieuplistvalue = tieuplistvalue;
	}

	public List getSmslisttype() {
		return smslisttype;
	}

	public void setSmslisttype(List smslisttype) {
		this.smslisttype = smslisttype;
	}

	public List getPrefferedlisttype() {
		return prefferedlisttype;
	}

	public void setPrefferedlisttype(List prefferedlisttype) {
		this.prefferedlisttype = prefferedlisttype;
	}

	public String getAllowThirdPartyAccess() {
		return allowThirdPartyAccess;
	}

	public void setAllowThirdPartyAccess(String allowThirdPartyAccess) {
		this.allowThirdPartyAccess = allowThirdPartyAccess;
	}

	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	public String getDispatchid() {
		return dispatchid;
	}

	public void setDispatchid(String dispatchid) {
		this.dispatchid = dispatchid;
	}

	

	
	
}
