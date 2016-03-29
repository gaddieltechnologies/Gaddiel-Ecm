package org.clinikraj.form;

import java.util.Date;
import java.util.List;

public class DoctorForm {
	private String errorMessage;
	
	private String dispatchd;
	 private String dispatchs;
	 private String dispatch;
	 private String searchdoctor;
	 private Long searchphoneno;
	 private String searchemail;
	 private String searchspecialzie;
	 private String searchdispatch;
     private Integer doctorId;
	 private String doctorName;
	 private String doctorImcNumber;
	 private String specialization;
	 private String tieUp;
	 private String emailId;
	 private String alternateEmailId;
	 private String addressLine1;
	 private String addressLine2;
	 private String area;
	 private String city;
	 private String district;
	 private String state;
	 private String country;
	 private Long phoneLandline;
	 private Long phoneFax;
	 private Long emergencyPhoneNumber;
	 private Long phoneMobile;
	 private String preferredContactMethod;
	 private String smsAlerts;
	 private String remarks;
	 private Integer postalcode;
	 private String successMessage;
	 private String allowThirdPartyAccess;
	 private List tieuplistvalue;
	 private String smslisttype;
		public List getTieuplistvalue() {
		return tieuplistvalue;
	}

	public void setTieuplistvalue(List tieuplistvalue) {
		this.tieuplistvalue = tieuplistvalue;
	}

	public String getSmslisttype() {
		return smslisttype;
	}

	public void setSmslisttype(String smslisttype) {
		this.smslisttype = smslisttype;
	}

		public String getAllowThirdPartyAccess() {
		return allowThirdPartyAccess;
	}

	public void setAllowThirdPartyAccess(String allowThirdPartyAccess) {
		this.allowThirdPartyAccess = allowThirdPartyAccess;
	}

		public String getSearchdoctor() {
			return searchdoctor;
		}

		public void setSearchdoctor(String searchdoctor) {
			this.searchdoctor = searchdoctor;
		}

		public Long getSearchphoneno() {
			return searchphoneno;
		}

		public void setSearchphoneno(Long searchphoneno) {
			this.searchphoneno = searchphoneno;
		}

		public String getSearchemail() {
			return searchemail;
		}

		public void setSearchemail(String searchemail) {
			this.searchemail = searchemail;
		}

		public String getSearchspecialzie() {
			return searchspecialzie;
		}

		public void setSearchspecialzie(String searchspecialzie) {
			this.searchspecialzie = searchspecialzie;
		}
		 public String getSearchdispatch() {
				return searchdispatch;
			}

			public void setSearchdispatch(String searchdispatch) {
				this.searchdispatch = searchdispatch;
			}
	 public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorImcNumber() {
		return doctorImcNumber;
	}

	public void setDoctorImcNumber(String doctorImcNumber) {
		this.doctorImcNumber = doctorImcNumber;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getTieUp() {
		return tieUp;
	}

	public void setTieUp(String tieUp) {
		this.tieUp = tieUp;
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

	public Long getPhoneFax() {
		return phoneFax;
	}

	public void setPhoneFax(Long phoneFax) {
		this.phoneFax = phoneFax;
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

	public Integer getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(Integer postalcode) {
		this.postalcode = postalcode;
	}

	private List<DoctorSubForm> doctorDetailSubForm;
	
	 
	
	public List<DoctorSubForm> getDoctorDetailSubForm() {
		return doctorDetailSubForm;
	}

	public void setDoctorDetailSubForm(List<DoctorSubForm> doctorDetailSubForm) {
		this.doctorDetailSubForm = doctorDetailSubForm;
	}
	
	

	public String getDispatch() {
		return dispatch;
	}

	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getDispatchs() {
		return dispatchs;
	}

	public void setDispatchs(String dispatchs) {
		this.dispatchs = dispatchs;
	}

	public String getDispatchd() {
		return dispatchd;
	}

	public void setDispatchd(String dispatchd) {
		this.dispatchd = dispatchd;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
	
}
