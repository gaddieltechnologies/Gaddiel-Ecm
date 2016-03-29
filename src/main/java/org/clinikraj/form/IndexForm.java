package org.clinikraj.form;

import java.util.Date;
import java.util.List;

public class IndexForm {
	
	private String role;
	private Integer labid;
	private Integer refid;
	private String user;
	private Date patientdob;
	private String doctorspecialization;
	private String testvendorregistration;
	private String alertMessage;
	private String firstLogin;
	private String loginMessage;
	private Date datename;

	
	
	
	
	public Date getPatientdob() {
		return patientdob;
	}
	public void setPatientdob(Date patientdob) {
		this.patientdob = patientdob;
	}
	public String getDoctorspecialization() {
		return doctorspecialization;
	}
	public void setDoctorspecialization(String doctorspecialization) {
		this.doctorspecialization = doctorspecialization;
	}
	public String getTestvendorregistration() {
		return testvendorregistration;
	}
	public void setTestvendorregistration(String testvendorregistration) {
		this.testvendorregistration = testvendorregistration;
	}
	
	

	public Date getDatename() {
		return datename;
	}
	public void setDatename(Date datename) {
		this.datename = datename;
	}



	private String userDisplay;
	private String clinicalerrormessage;
	private String patienterrormessage;
	private String doctorerrormessage;
	private String reporterrormessage;
	private String clinikrajlogincheck;
	private String clinicallabUserName;
	private String clinicallabUserPassword;
	private String result;
	private String patientUserName;
	private String patientUserPassword;
	private String patientClinicallabSelect;
	private List patientClinicallabOptions;
	private String doctorUserName;
	private String doctorUserPassword;
	private String doctorClinicallabSelect;
	private List doctorClinicallabOptions;
	private String reportUserName;
	private String reportUserPassword;
	private String reportClinicallabSelect;
	private List reportClinicallabOptions;
	private String firstquestion;
	private String secondquestion;
	private String currentPassword;
	private String newPassword;
	private String confirmPassword;
	private String errormessage;
	private String successmessage;
	private String output;
	private String qResult;
	private String dispatch;
	private String userType;
	private long controlmessage;
	
	private String allowthirdparty;
	
	public String getPatientClinicallabSelect() {
		return patientClinicallabSelect;
	}
	public void setPatientClinicallabSelect(String patientClinicallabSelect) {
		this.patientClinicallabSelect = patientClinicallabSelect;
	}
	public List getPatientClinicallabOptions() {
		return patientClinicallabOptions;
	}
	public void setPatientClinicallabOptions(List patientClinicallabOptions) {
		this.patientClinicallabOptions = patientClinicallabOptions;
	}
	public String getDoctorClinicallabSelect() {
		return doctorClinicallabSelect;
	}
	public void setDoctorClinicallabSelect(String doctorClinicallabSelect) {
		this.doctorClinicallabSelect = doctorClinicallabSelect;
	}
	public List getDoctorClinicallabOptions() {
		return doctorClinicallabOptions;
	}
	public void setDoctorClinicallabOptions(List doctorClinicallabOptions) {
		this.doctorClinicallabOptions = doctorClinicallabOptions;
	}
	public String getReportClinicallabSelect() {
		return reportClinicallabSelect;
	}
	public void setReportClinicallabSelect(String reportClinicallabSelect) {
		this.reportClinicallabSelect = reportClinicallabSelect;
	}
	public List getReportClinicallabOptions() {
		return reportClinicallabOptions;
	}
	public void setReportClinicallabOptions(List reportClinicallabOptions) {
		this.reportClinicallabOptions = reportClinicallabOptions;
	}
	private int id;
	
	public String getPatientUserName() {
		return patientUserName;
	}
	public void setPatientUserName(String patientUserName) {
		this.patientUserName = patientUserName;
	}
	public String getPatientUserPassword() {
		return patientUserPassword;
	}
	public void setPatientUserPassword(String patientUserPassword) {
		this.patientUserPassword = patientUserPassword;
	}
	public String getDoctorUserName() {
		return doctorUserName;
	}
	public void setDoctorUserName(String doctorUserName) {
		this.doctorUserName = doctorUserName;
	}
	public String getDoctorUserPassword() {
		return doctorUserPassword;
	}
	public void setDoctorUserPassword(String doctorUserPassword) {
		this.doctorUserPassword = doctorUserPassword;
	}
	public String getReportUserName() {
		return reportUserName;
	}
	public void setReportUserName(String reportUserName) {
		this.reportUserName = reportUserName;
	}
	public String getReportUserPassword() {
		return reportUserPassword;
	}
	public void setReportUserPassword(String reportUserPassword) {
		this.reportUserPassword = reportUserPassword;
	}
	
	
	
	public String getClinikrajlogincheck() {
		return clinikrajlogincheck;
	}
	public void setClinikrajlogincheck(String clinikrajlogincheck) {
		this.clinikrajlogincheck = clinikrajlogincheck;
	}
	public String getClinicallabUserName() {
		return clinicallabUserName;
	}
	public void setClinicallabUserName(String clinicallabUserName) {
		this.clinicallabUserName = clinicallabUserName;
	}
	public String getClinicallabUserPassword() {
		return clinicallabUserPassword;
	}
	public void setClinicallabUserPassword(String clinicallabUserPassword) {
		this.clinicallabUserPassword = clinicallabUserPassword;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getClinicalerrormessage() {
		return clinicalerrormessage;
	}
	public void setClinicalerrormessage(String clinicalerrormessage) {
		this.clinicalerrormessage = clinicalerrormessage;
	}
	public String getPatienterrormessage() {
		return patienterrormessage;
	}
	public void setPatienterrormessage(String patienterrormessage) {
		this.patienterrormessage = patienterrormessage;
	}
	public String getDoctorerrormessage() {
		return doctorerrormessage;
	}
	public void setDoctorerrormessage(String doctorerrormessage) {
		this.doctorerrormessage = doctorerrormessage;
	}
	public String getReporterrormessage() {
		return reporterrormessage;
	}
	public void setReporterrormessage(String reporterrormessage) {
		this.reporterrormessage = reporterrormessage;
	}
	public String getUserDisplay() {
		return userDisplay;
	}
	public void setUserDisplay(String userDisplay) {
		this.userDisplay = userDisplay;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getLabid() {
		return labid;
	}
	public void setLabid(Integer labid) {
		this.labid = labid;
	}
	public Integer getRefid() {
		return refid;
	}
	public void setRefid(Integer refid) {
		this.refid = refid;
	}
	public String getAllowthirdparty() {
		return allowthirdparty;
	}
	public void setAllowthirdparty(String allowthirdparty) {
		this.allowthirdparty = allowthirdparty;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getAlertMessage() {
		return alertMessage;
	}
	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}
	public String getLoginMessage() {
		return loginMessage;
	}
	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}
	public String getFirstquestion() {
		return firstquestion;
	}
	public void setFirstquestion(String firstquestion) {
		this.firstquestion = firstquestion;
	}
	public String getSecondquestion() {
		return secondquestion;
	}
	public void setSecondquestion(String secondquestion) {
		this.secondquestion = secondquestion;
	}
	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	public String getSuccessmessage() {
		return successmessage;
	}
	public void setSuccessmessage(String successmessage) {
		this.successmessage = successmessage;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getqResult() {
		return qResult;
	}
	public void setqResult(String qResult) {
		this.qResult = qResult;
	}
	public String getDispatch() {
		return dispatch;
	}
	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public long getControlmessage() {
		return controlmessage;
	}
	public void setControlmessage(long diffDays) {
		this.controlmessage = diffDays;
	}

	public String getFirstLogin() {
		return firstLogin;
	}
	public void setFirstLogin(String firstLogin) {
		this.firstLogin = firstLogin;
	}

	
	
	
	
	
	
}
