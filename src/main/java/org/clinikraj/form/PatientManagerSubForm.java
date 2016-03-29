package org.clinikraj.form;

import java.util.Date;
import java.util.List;

import org.clinikraj.model.ClinicalLab;

public class PatientManagerSubForm implements java.io.Serializable {
	
	private Integer patientIdRegNo;
	private String patientName;
	private String sex;
    private Integer age;
    private String prefferedContact;
    private String phoneContactNo;
    private String emailId;
    private String smsAlert;
    private String startDate;
    private Integer patientId;
    private ClinicalLab clinicalLab;
    private String createdBy;
    private Date createdDate;
    private String lastUpdatedBy;
    private Date lastUpdatedDate;  
    private Date dateOfBirth;   
    private String alternateEmailId;
    private String addressLine1;
    private String addressLine2;
    private String area;
    private Integer postofficecode;
    private String city;
    private String district;
    private String state;
    private String country;
    private Long phoneLandline;
    private Integer emergencyPhoneNumber;
    private Long phoneMobile;
    private Integer phoneFax;    
    private Date endDate;
    private String preferredContactMethod;
    private String smsAlerts;
    private byte[] patientPhoto;
    
    private String referringDoctorid;
    private String referringDoctor;
    
	private String referringVendoid;
    private String referringVendor;
    
    
    
    public String getReferringDoctorid() {
		return referringDoctorid;
	}
	public void setReferringDoctorid(String referringDoctorid) {
		this.referringDoctorid = referringDoctorid;
	}
	public String getReferringVendoid() {
		return referringVendoid;
	}
	public void setReferringVendoid(String referringVendoid) {
		this.referringVendoid = referringVendoid;
	}
	public String getReferringDoctor() {
		return referringDoctor;
	}
	public void setReferringDoctor(String referringDoctor) {
		this.referringDoctor = referringDoctor;
	}
	public String getReferringVendor() {
		return referringVendor;
	}
	public void setReferringVendor(String referringVendor) {
		this.referringVendor = referringVendor;
	}
	private List sexTypeList;
    private List prefferedlisttype;
    private List smslisttype;
    private List drname;
    private List vnname;
    
    
    
    
    public List getPrefferedlisttype() {
		return prefferedlisttype;
	}
	public void setPrefferedlisttype(List prefferedlisttype) {
		this.prefferedlisttype = prefferedlisttype;
	}
	public List getDrname() {
		return drname;
	}
	public void setDrname(List drname) {
		this.drname = drname;
	}
	public List getVnname() {
		return vnname;
	}
	public void setVnname(List vnname) {
		this.vnname = vnname;
	}
	public List getSmslisttype() {
		return smslisttype;
	}
	public void setSmslisttype(List smslisttype) {
		this.smslisttype = smslisttype;
	}
	public List getSexTypeList() {
		return sexTypeList;
	}
	public void setSexTypeList(List sexTypeList) {
		this.sexTypeList = sexTypeList;
	}
	public Integer getPatientIdRegNo() {
		return patientIdRegNo;
	}
	public void setPatientIdRegNo(Integer patientIdRegNo) {
		this.patientIdRegNo = patientIdRegNo;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPrefferedContact() {
		return prefferedContact;
	}
	public void setPrefferedContact(String prefferedContact) {
		this.prefferedContact = prefferedContact;
	}
	public String getPhoneContactNo() {
		return phoneContactNo;
	}
	public void setPhoneContactNo(String phoneContactNo) {
		this.phoneContactNo = phoneContactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getSmsAlert() {
		return smsAlert;
	}
	public void setSmsAlert(String smsAlert) {
		this.smsAlert = smsAlert;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public ClinicalLab getClinicalLab() {
		return clinicalLab;
	}
	public void setClinicalLab(ClinicalLab clinicalLab) {
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	public Integer getPostofficecode() {
		return postofficecode;
	}
	public void setPostofficecode(Integer postofficecode) {
		this.postofficecode = postofficecode;
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
	public Integer getEmergencyPhoneNumber() {
		return emergencyPhoneNumber;
	}
	public void setEmergencyPhoneNumber(Integer emergencyPhoneNumber) {
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
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	public byte[] getPatientPhoto() {
		return patientPhoto;
	}
	public void setPatientPhoto(byte[] patientPhoto) {
		this.patientPhoto = patientPhoto;
	}
	
    

}
