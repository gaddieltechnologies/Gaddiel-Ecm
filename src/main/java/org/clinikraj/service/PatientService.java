package org.clinikraj.service;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.clinikraj.form.IndexForm;
import org.clinikraj.form.PatientLoginForm;
import org.clinikraj.form.PatientManagerForm;
import org.clinikraj.form.PatientManagerSubForm;
import org.clinikraj.form.TestVendorManagerForm;
import org.clinikraj.model.Patient;

public interface PatientService {
	public List viewPatienDetails(PatientManagerForm patientFormObject,PatientManagerSubForm patientSubObject,Integer labid,String username) throws ParseException;
	public PatientManagerForm addPatienDetails(PatientManagerForm addPatient,Integer labid,String username) throws ParseException;
	public List postofficePatienvalues(String var) throws ParseException;
	public PatientManagerForm viewPatient(String val) throws ParseException;
	public 	String  deletePatient(String val) throws ParseException; 
	public List Prefferedcontact();
	public List getSmsList();
	public List sexList();
	public List doctorList();
	public List vendorList();
	public String createPatienAsUser(PatientManagerForm createPatienUserObj,Integer labid,String username);
	public String patientUser(String patId);
	public List viewPatientLoginDetails(PatientLoginForm patientLoginform,String LabId,String refId)throws ParseException;
	public PatientLoginForm PatienttestOrderDetails(String LabId,PatientLoginForm patientLoginform,String val);
	public List PatienttestOrdergridView(String LabId,PatientLoginForm patientLoginform);
	 public PatientLoginForm patienttestOrderViews(PatientLoginForm patientLoginforms,String val,String LabId);
	 public String LoginFormPatient(String username);

	 public IndexForm logoutendsession(HttpSession httpSession, IndexForm indexForm);

}
