package org.clinikraj.form;

import java.util.Date;

import org.clinikraj.model.ClinicalLab;
import org.clinikraj.model.Doctor;
import org.clinikraj.model.Patient;
import org.clinikraj.model.TestVendor;

public class TestOrderManagerSubForm implements java.io.Serializable {
	
	private String groupId;
	private String subgroupId;
	private String testId;
	private String group;
	private String subGroup;
	private String test;
	
	private String testReference;
	private Integer orderId;
	private Integer orderTest;
    private String patient;
    private String testVendor;
    private Integer clinicalLab;
    private String doctor;
    private String createdBy;
    private Date createdDate;
    private String lastUpdatedBy;
    private Date lastUpdatedDate;
    private String orderReference;
    private String ordersubDate;
    private Integer grossAmount;
    private Integer discount;
    private Integer adavance;
    private Integer netAmount;
    private Integer balance;
    private String balanceCollectedDate;
    private String remarks;



    private String patientid;
    private String patientname;
    private String patientsex;
    private String patientage;
    private String prefferdcontact;
    private String mobphoneno;
    private String email;
    private String code;
    private String doctorna;
    private String vendorna;

    private Integer totalCollected;
    private String referringDoctor;
	private String vendorList;
	private String searchdispatch;
	
	private Integer order;
	private Integer testGroup;
	private Integer testSubgroup;
	private Integer tests;
	private String testResult;
	private String analystRemarks;
	private String rate;
	private String specimenDetails;
	private String testJob;
	private String testedBy;
	private String testApprovedBy;
	
	public String getReferringDoctor() {
		return referringDoctor;
	}
	public void setReferringDoctor(String referringDoctor) {
		this.referringDoctor = referringDoctor;
	}
	public String getVendorList() {
		return vendorList;
	}
	public void setVendorList(String vendorList) {
		this.vendorList = vendorList;
	}

	public Integer getTotalCollected() {
		return totalCollected;
	}
	public void setTotalCollected(Integer totalCollected) {
		this.totalCollected = totalCollected;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	public String getTestVendor() {
		return testVendor;
	}
	public void setTestVendor(String testVendor) {
		this.testVendor = testVendor;
	}
	public Integer getClinicalLab() {
		return clinicalLab;
	}
	public void setClinicalLab(Integer clinicalLab) {
		this.clinicalLab = clinicalLab;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
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
	public String getOrderReference() {
		return orderReference;
	}
	public void setOrderReference(String orderReference) {
		this.orderReference = orderReference;
	}
	
	public Integer getGrossAmount() {
		return grossAmount;
	}
	public void setGrossAmount(Integer grossAmount) {
		this.grossAmount = grossAmount;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Integer getAdavance() {
		return adavance;
	}
	public void setAdavance(Integer adavance) {
		this.adavance = adavance;
	}
	public Integer getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(Integer netAmount) {
		this.netAmount = netAmount;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public String getBalanceCollectedDate() {
		return balanceCollectedDate;
	}
	public void setBalanceCollectedDate(String balanceCollectedDate) {
		this.balanceCollectedDate = balanceCollectedDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getOrdersubDate() {
		return ordersubDate;
	}
	public void setOrdersubDate(String ordersubDate) {
		this.ordersubDate = ordersubDate;
	}
	public String getPatientid() {
		return patientid;
	}
	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getPatientsex() {
		return patientsex;
	}
	public void setPatientsex(String patientsex) {
		this.patientsex = patientsex;
	}
	public String getPatientage() {
		return patientage;
	}
	public void setPatientage(String patientage) {
		this.patientage = patientage;
	}
	public String getPrefferdcontact() {
		return prefferdcontact;
	}
	public void setPrefferdcontact(String prefferdcontact) {
		this.prefferdcontact = prefferdcontact;
	}
	public String getMobphoneno() {
		return mobphoneno;
	}
	public void setMobphoneno(String mobphoneno) {
		this.mobphoneno = mobphoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDoctorna() {
		return doctorna;
	}
	public void setDoctorna(String doctorna) {
		this.doctorna = doctorna;
	}
	public String getVendorna() {
		return vendorna;
	}
	public void setVendorna(String vendorna) {
		this.vendorna = vendorna;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getSubgroupId() {
		return subgroupId;
	}
	public void setSubgroupId(String subgroupId) {
		this.subgroupId = subgroupId;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getTestResult() {
		return testResult;
	}
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	public String getAnalystRemarks() {
		return analystRemarks;
	}
	public void setAnalystRemarks(String analystRemarks) {
		this.analystRemarks = analystRemarks;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getSpecimenDetails() {
		return specimenDetails;
	}
	public void setSpecimenDetails(String specimenDetails) {
		this.specimenDetails = specimenDetails;
	}
	public String getTestJob() {
		return testJob;
	}
	public void setTestJob(String testJob) {
		this.testJob = testJob;
	}
	public String getTestedBy() {
		return testedBy;
	}
	public void setTestedBy(String testedBy) {
		this.testedBy = testedBy;
	}
	public String getTestApprovedBy() {
		return testApprovedBy;
	}
	public void setTestApprovedBy(String testApprovedBy) {
		this.testApprovedBy = testApprovedBy;
	}
	public String getTestReference() {
		return testReference;
	}
	public void setTestReference(String testReference) {
		this.testReference = testReference;
	}
	public String getSearchdispatch() {
		return searchdispatch;
	}
	public void setSearchdispatch(String searchdispatch) {
		this.searchdispatch = searchdispatch;
	}
	public Integer getOrderTest() {
		return orderTest;
	}
	public void setOrderTest(Integer orderTest) {
		this.orderTest = orderTest;
	}
	public Integer getTestGroup() {
		return testGroup;
	}
	public void setTestGroup(Integer testGroup) {
		this.testGroup = testGroup;
	}
	public Integer getTestSubgroup() {
		return testSubgroup;
	}
	public void setTestSubgroup(Integer testSubgroup) {
		this.testSubgroup = testSubgroup;
	}
	public Integer getTests() {
		return tests;
	}
	public void setTests(Integer tests) {
		this.tests = tests;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getSubGroup() {
		return subGroup;
	}
	public void setSubGroup(String subGroup) {
		this.subGroup = subGroup;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
    
    
    

}
