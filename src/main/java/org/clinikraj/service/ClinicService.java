package org.clinikraj.service;
import org.clinikraj.form.IndexForm;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.clinikraj.form.ChangePassword;
import org.clinikraj.form.ClinicalLabInfoForm;
import org.clinikraj.form.DoctorLoginForm;
import org.clinikraj.form.DoctorLoginSubForm;
import org.clinikraj.form.PatientLoginForm;
import org.clinikraj.form.ClinicalLabInfoForm;
import org.clinikraj.form.PatientManagerForm;
import org.clinikraj.form.PatientManagerSubForm;
import org.clinikraj.form.TestVendorManagerForm;
import org.clinikraj.form.UserAccessManagerForm;
import org.clinikraj.form.UserAccessManagerSubForm;
import org.clinikraj.form.TestVendorManagerSubForm;
import org.clinikraj.model.User;
import org.clinikraj.model.ClinicalLab;










public interface ClinicService {
	
	public IndexForm login(IndexForm indexForm);
	public IndexForm patientLoginClinicSelect(IndexForm indexForm);
	public IndexForm patientLogin(IndexForm indexForm);
	public IndexForm doctorLoginClinicSelect(IndexForm indexForm);
	public IndexForm doctorLogin(IndexForm indexForm);
	public IndexForm reportLoginClinicSelect(IndexForm indexForm);
	public IndexForm reportLogin(IndexForm indexForm);
	

	
	public List viewPatienDetails(PatientManagerForm patientFormObject,PatientManagerSubForm patientSubObject,Integer labid,String username) throws ParseException;

	public List postofficePatientvalues(String var) throws ParseException;
	
	
	
	

	

	public List postofficevalues(String var) throws ParseException;
	public List Prefferedcontact();
	public String changepassword(String username,IndexForm indexformobj);
	public ChangePassword forgotPassword(ChangePassword changepassword);
	public ChangePassword forgotPasswordvq(ChangePassword changepassword);
	public List getUserType();		
	public String changepasswordpatient(String patientname,IndexForm indexformobj);
	public String changePasswordVendor(String vendorname,IndexForm indexformobj);
	public String changePasswordDoctor(String doctorname,IndexForm indexformobj);
	public ChangePassword forgotPasswordSave(ChangePassword changepassword);
	public ChangePassword verifyQuestion(ChangePassword changepassword, String username, String usertype);
	public ChangePassword changingpassword(ChangePassword changepassword, String username, String usertype);
	public ClinicalLabInfoForm registersave(ClinicalLabInfoForm labform) throws ParseException, IOException;
	public ClinicalLabInfoForm registersaveuser(ClinicalLabInfoForm labform, ClinicalLab labmodel) throws ParseException;
	public List getActiveFlagList();
	public String sendmailifsuccess(ClinicalLabInfoForm form);
	
}

