package org.clinikraj.form;

import java.util.Date;
import java.util.List;

import org.clinikraj.model.ClinicalLab;
import org.clinikraj.model.Doctor;
import org.clinikraj.model.Patient;
import org.clinikraj.model.TestVendor;

public class TestOrderManagerForm {
	
	private List<TestOrderManagerSubForm> testOrderManagerrDetailSubForm;

	
	private String errorMessage;
	private String referringDoctor;
	private String vendorList;
	private List subgroupoptions;	
	private List testoptions;
	private List publishlist;
	private String publish;
    private Integer patient;
    private Integer clinicalLab;
    private String createdBy;
    private Date createdDate;
    private String lastUpdatedBy;
    private Date lastUpdatedDate;
    private String remarks;
    private String clientName;
    private Integer labId;
    private Integer client;
    private String ordervalue;
	private String searchTestDate;
    private String searchTestOrderNo;
    private String searchTestOrderPatientname;
    private String searchTestOrderMobile;
    private String searchTestOrderPEmailid;
    private String searchTestDoctorName;
    private String searchTestvendorName;
   
    private Integer orderTest;
    private String searchPatientName;
    private String searchMobile;
    private String searchEmailid;
    private String searchPostalcode;
    private String searchDoctorname; 
    	
    private List listdoctorname;
    private List listvendorname; 	
    private Integer totalCollected;
    private Integer order;
    
    private String dispatch;
    private String searchdispatch;
	private String dispatchTestId;
	private String dispatchPatientId;
	private String dispatchPatientName;
	private String successMessage;
	
	

	private String dispatchGridView;
    
    private Integer orderId;
	private String orderDate;
	private Integer doctor;
	private String doctorname;	
	private Integer testVendor;
	private String vendorname;
	private String orderReference;
	private Integer grossAmount;
	private Integer discount;
    private Integer adavance;
    private Integer netAmount;
    private Integer balance;
    private Date balanceCollectedDate;
    
    private Integer testGroup;
    private String group;
	private Integer testSubGroup;
	private String subGroup;
	private Integer testId;
	private String test;
    
	private Integer orderTestId;
	private String	testResult;
    private String	analystRemarks;
    private Integer rate;
    private String	specimenDetails;
    private Integer testJob;
    private String testjob;
    private String	testedBy;
    private String	testApprovedBy;
    private String	testStartDate;
    private String	testStartTime;
    private String	testReference;
    private String flag; 
     
     
     public List getSubgroupoptions() {
 		return subgroupoptions;
 	}
 	public void setSubgroupoptions(List subgroupoptions) {
 		this.subgroupoptions = subgroupoptions;
 	}
 	public List getTestoptions() {
 		return testoptions;
 	}
 	public void setTestoptions(List testoptions) {
 		this.testoptions = testoptions;
 	}
 	public Integer getTestGroup() {
 		return testGroup;
 	}
 	public void setTestGroup(Integer testGroup) {
 		this.testGroup = testGroup;
 	}
 	public Integer getTestSubGroup() {
 		return testSubGroup;
 	}
 	public void setTestSubGroup(Integer testSubGroup) {
 		this.testSubGroup = testSubGroup;
 	}
 	public Integer getTestId() {
 		return testId;
 	}
 	public void setTestId(Integer testId) {
 		this.testId = testId;
 	}
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
        
     public List<TestOrderManagerSubForm> getTestOrderManagerrDetailSubForm() {
		return testOrderManagerrDetailSubForm;
	}
	public void setTestOrderManagerrDetailSubForm(
			List<TestOrderManagerSubForm> testOrderManagerrDetailSubForm) {
		this.testOrderManagerrDetailSubForm = testOrderManagerrDetailSubForm;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getPatient() {
		return patient;
	}
	public void setPatient(Integer patient) {
		this.patient = patient;
	}
	public Integer getTestVendor() {
		return testVendor;
	}
	public void setTestVendor(Integer testVendor) {
		this.testVendor = testVendor;
	}
	public Integer getClinicalLab() {
		return clinicalLab;
	}
	public void setClinicalLab(Integer clinicalLab) {
		this.clinicalLab = clinicalLab;
	}
	public Integer getDoctor() {
		return doctor;
	}
	public void setDoctor(Integer doctor) {
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
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
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
	public Date getBalanceCollectedDate() {
		return balanceCollectedDate;
	}
	public void setBalanceCollectedDate(Date balanceCollectedDate) {
		this.balanceCollectedDate = balanceCollectedDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getSearchTestDate() {
		return searchTestDate;
	}
	public void setSearchTestDate(String searchTestDate) {
		this.searchTestDate = searchTestDate;
	}
	public String getSearchTestOrderNo() {
		return searchTestOrderNo;
	}
	public void setSearchTestOrderNo(String searchTestOrderNo) {
		this.searchTestOrderNo = searchTestOrderNo;
	}
	public String getSearchTestOrderPatientname() {
		return searchTestOrderPatientname;
	}
	public void setSearchTestOrderPatientname(String searchTestOrderPatientname) {
		this.searchTestOrderPatientname = searchTestOrderPatientname;
	}
	public String getSearchTestOrderMobile() {
		return searchTestOrderMobile;
	}
	public void setSearchTestOrderMobile(String searchTestOrderMobile) {
		this.searchTestOrderMobile = searchTestOrderMobile;
	}
	public String getSearchTestOrderPEmailid() {
		return searchTestOrderPEmailid;
	}
	public void setSearchTestOrderPEmailid(String searchTestOrderPEmailid) {
		this.searchTestOrderPEmailid = searchTestOrderPEmailid;
	}
	public String getSearchTestDoctorName() {
		return searchTestDoctorName;
	}
	public void setSearchTestDoctorName(String searchTestDoctorName) {
		this.searchTestDoctorName = searchTestDoctorName;
	}
	public String getSearchTestvendorName() {
		return searchTestvendorName;
	}
	public void setSearchTestvendorName(String searchTestvendorName) {
		this.searchTestvendorName = searchTestvendorName;
	}
	public String getDispatch() {
		return dispatch;
	}
	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}
	public String getSearchPatientName() {
		return searchPatientName;
	}
	public void setSearchPatientName(String searchPatientName) {
		this.searchPatientName = searchPatientName;
	}
	public String getSearchMobile() {
		return searchMobile;
	}
	public void setSearchMobile(String searchMobile) {
		this.searchMobile = searchMobile;
	}
	public String getSearchEmailid() {
		return searchEmailid;
	}
	public void setSearchEmailid(String searchEmailid) {
		this.searchEmailid = searchEmailid;
	}
	public String getSearchPostalcode() {
		return searchPostalcode;
	}
	public void setSearchPostalcode(String searchPostalcode) {
		this.searchPostalcode = searchPostalcode;
	}
	public String getSearchDoctorname() {
		return searchDoctorname;
	}
	public void setSearchDoctorname(String searchDoctorname) {
		this.searchDoctorname = searchDoctorname;
	}
	public List getListdoctorname() {
		return listdoctorname;
	}
	public void setListdoctorname(List listdoctorname) {
		this.listdoctorname = listdoctorname;
	}
	public List getListvendorname() {
		return listvendorname;
	}
	public void setListvendorname(List listvendorname) {
		this.listvendorname = listvendorname;
	}
	public String getDispatchGridView() {
		return dispatchGridView;
	}
	public void setDispatchGridView(String dispatchGridView) {
		this.dispatchGridView = dispatchGridView;
	}

	
	public String getOrdervalue() {
		return ordervalue;
	}
	public void setOrdervalue(String ordervalue) {
		this.ordervalue = ordervalue;
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
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
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
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public String getSpecimenDetails() {
		return specimenDetails;
	}
	public void setSpecimenDetails(String specimenDetails) {
		this.specimenDetails = specimenDetails;
	}
	public Integer getTestJob() {
		return testJob;
	}
	public void setTestJob(Integer testJob) {
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
	public String getTestStartDate() {
		return testStartDate;
	}
	public void setTestStartDate(String testStartDate) {
		this.testStartDate = testStartDate;
	}
	public String getTestStartTime() {
		return testStartTime;
	}
	public void setTestStartTime(String testStartTime) {
		this.testStartTime = testStartTime;
	}
	public String getTestReference() {
		return testReference;
	}
	public void setTestReference(String testReference) {
		this.testReference = testReference;
	}
	public Integer getTotalCollected() {
		return totalCollected;
	}
	public void setTotalCollected(Integer totalCollected) {
		this.totalCollected = totalCollected;
	}
	
	public String getDispatchPatientId() {
		return dispatchPatientId;
	}
	public void setDispatchPatientId(String dispatchPatientId) {
		this.dispatchPatientId = dispatchPatientId;
	}
	public String getDispatchPatientName() {
		return dispatchPatientName;
	}
	public void setDispatchPatientName(String dispatchPatientName) {
		this.dispatchPatientName = dispatchPatientName;
	}
	public String getSearchdispatch() {
		return searchdispatch;
	}
	public void setSearchdispatch(String searchdispatch) {
		this.searchdispatch = searchdispatch;
	}
	public String getDispatchTestId() {
		return dispatchTestId;
	}
	public void setDispatchTestId(String dispatchTestId) {
		this.dispatchTestId = dispatchTestId;
	}
	public Integer getOrderTest() {
		return orderTest;
	}
	public void setOrderTest(Integer orderTest) {
		this.orderTest = orderTest;
	}
	public List getPublishlist() {
		return publishlist;
	}
	public void setPublishlist(List publishlist) {
		this.publishlist = publishlist;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getVendorname() {
		return vendorname;
	}
	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}
	public Integer getOrderTestId() {
		return orderTestId;
	}
	public void setOrderTestId(Integer orderTestId) {
		this.orderTestId = orderTestId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Integer getLabId() {
		return labId;
	}
	public void setLabId(Integer labId) {
		this.labId = labId;
	}
	public Integer getClient() {
		return client;
	}
	public void setClient(Integer client) {
		this.client = client;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getTestjob() {
		return testjob;
	}
	public void setTestjob(String testjob) {
		this.testjob = testjob;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
