package org.clinikraj.form;

import java.util.Date;

public class DoctorLoginSubForm implements java.io.Serializable{
	
   private String date;
   private Integer orderId;
   private Integer order;
   private String orderReference;
   private String patientName;
   private String vendorName;
   private String testApproved;
   private String testGroup;
   private String testSubgroup;
   private String tests;
   private String testResult;
   private String analystRemarks;
   private Integer rate;
   private String specimenDetails;
   private String testjob;
   private String testedBy;
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}

public Integer getOrder() {
	return order;
}
public void setOrder(Integer order) {
	this.order = order;
}
public Integer getOrderId() {
	return orderId;
}
public void setOrderId(Integer orderId) {
	this.orderId = orderId;
}
public String getOrderReference() {
	return orderReference;
}
public void setOrderReference(String orderReference) {
	this.orderReference = orderReference;
}
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public String getVendorName() {
	return vendorName;
}
public void setVendorName(String vendorName) {
	this.vendorName = vendorName;
}
public String getTestApproved() {
	return testApproved;
}
public void setTestApproved(String testApproved) {
	this.testApproved = testApproved;
}
public String getTestGroup() {
	return testGroup;
}
public void setTestGroup(String testGroup) {
	this.testGroup = testGroup;
}
public String getTestSubgroup() {
	return testSubgroup;
}
public void setTestSubgroup(String testSubgroup) {
	this.testSubgroup = testSubgroup;
}
public String getTests() {
	return tests;
}
public void setTests(String tests) {
	this.tests = tests;
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
public String getTestjob() {
	return testjob;
}
public void setTestjob(String testjob) {
	this.testjob = testjob;
}
public String getTestedBy() {
	return testedBy;
}
public void setTestedBy(String testedBy) {
	this.testedBy = testedBy;
}

}
