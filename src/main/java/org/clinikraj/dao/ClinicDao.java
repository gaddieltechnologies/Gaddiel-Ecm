package org.clinikraj.dao;
import org.clinikraj.form.ChangePassword;
import org.clinikraj.form.IndexForm;
import org.clinikraj.form.PatientLoginForm;
import org.clinikraj.form.UserAccessManagerForm;
import org.clinikraj.form.UserAccessManagerSubForm;
import org.clinikraj.form.ClinicalLabInfoForm;
import org.clinikraj.form.DoctorForm;
import org.clinikraj.form.DoctorSubForm;
import org.clinikraj.model.ClinicalLab;
import org.clinikraj.model.Doctor;
import org.clinikraj.model.PatientTestOrders;
import org.clinikraj.model.PatientTests;
import org.clinikraj.model.User;
import java.text.ParseException;
import java.util.List;
import org.clinikraj.form.DoctorLoginForm;
import org.clinikraj.form.DoctorLoginSubForm;
import javax.servlet.http.HttpSession;
import org.clinikraj.form.PatientManagerForm;
import org.clinikraj.form.PatientManagerSubForm;
import org.clinikraj.form.TestOrderManagerForm;
import org.clinikraj.form.TestOrderManagerSubForm;
import org.clinikraj.form.TestVendorManagerForm;
import org.clinikraj.form.TestVendorManagerSubForm;
import org.clinikraj.model.TestVendor;
import org.clinikraj.model.Patient;
import org.clinikraj.model.User;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;


public interface ClinicDao {

	public IndexForm login(IndexForm indexForm);
	public IndexForm patientLoginClinicSelect(IndexForm indexForm);
	public IndexForm patientLogin(IndexForm indexForm);
	public IndexForm doctorLoginClinicSelect(IndexForm indexForm);
	public IndexForm doctorLogin(IndexForm indexForm);
	public IndexForm reportLoginClinicSelect(IndexForm indexForm);
	public IndexForm reportLogin(IndexForm indexForm);
	public List clinicalform(String LabId);
	public List viewPatient(String val) throws ParseException;
	public List viewLabUserDetails(HttpSession httpSession, UserAccessManagerForm userFormObject,UserAccessManagerSubForm userSubObject) throws ParseException;
	public List viewPatientUserDetails(HttpSession httpSession, UserAccessManagerForm userFormObject,UserAccessManagerSubForm userSubObject) throws ParseException;
	public List viewDoctorUserDetails(HttpSession httpSession, UserAccessManagerForm userFormObject,UserAccessManagerSubForm userSubObject) throws ParseException;
	public List viewTestVendorUserDetails(HttpSession httpSession, UserAccessManagerForm userFormObject,UserAccessManagerSubForm userSubObject) throws ParseException;
	
	public List viewUser(String val) throws ParseException;
	public List viewPatienDetails(PatientManagerForm patientFormObject,PatientManagerSubForm patientSubObject,Integer labid,String username) throws ParseException;
	public String addPatienDetails(Patient addPatient) throws ParseException;

	public String addUserDetails(User addUser) throws ParseException;
	public PatientTestOrders addOrderDetails(PatientTestOrders addOrder) throws ParseException;
	public PatientTests addOrderTestDetails(PatientTests addOrderTest) throws ParseException;
	public String deleteUser(User userDeleteModel);

	public String deletePatient(Patient patientDeleteModel);

	 public String doctorAdd(Doctor doctor,String username, String labId );
	 public String addUser(User user,String labid,String username);
	 public String addDocUser(String doctorid);
	 public List doctorView(String val);
	 public List getLabLogo(String LabId);
	 public List doctorform(DoctorForm doctoform, DoctorSubForm subdoctor,String LabId);
	 public List postofficedoctor(String var) throws ParseException;
	 public List Specilizationdoctor() throws ParseException;


		public List postofficevalues(String var) throws ParseException;
		public List Prefferedcontact();
		public List postofficePatienvalues(String var) throws ParseException;


public List viewvendorDetails(TestVendorManagerForm vendorFormObject,TestVendorManagerSubForm vendormanagerSubObject,Integer labid,String username) throws ParseException	;

	public String save(TestVendor testVendor,Integer labid,String username);

	

	
	public List getRoleList();
	public List getUserTypeList();
	public List getDefaultPasswordChangedList();
	public List getActiveFlagList();
	public List getDeleteFlagList();
	public List viewVendor(String val,Integer labid,String username) throws ParseException;   
    public String updatevendor(TestVendor vendormodel,Integer labid,String username);
    public List getTieupList();
    public List getSmsList();
    public List viewDoctorLoginDetails(DoctorLoginForm doctorLoginform,String LabId,String refId) throws ParseException;
	public List DoctortestOrderDetails(String LabId,String val);
	public List DoctortestOrdergridView(DoctorLoginForm doctorLoginform,String LabId);
	public List DoctortestOrderView(DoctorLoginForm doctorLoginform,String val,String LabId);
    public List viewDoctorName(String doctorname);
    public List sexList();
    public List doctorList();
    public List vendorList();


    
    public List doctorName(String drid) throws ParseException;
    public List vendorName(String vnrid) throws ParseException;



    public List viewtestorderDetails(TestOrderManagerForm testorderFormOject,TestOrderManagerSubForm testordermanaerSuFormObject,Integer labid,String username)	 throws ParseException;
    public List DoctorListdetails();
    public List VendorList();
    public String  createuservendor(User createuservendorform,Integer labid,String username);
    public String vendoruserd(String vendid);

    public String patientUserid(String patId);

    public List viewVendorLoginDetails(String refId,DoctorLoginForm doctorLoginform,String LabId) throws ParseException;
    public List TestVendorOrderView(DoctorLoginForm doctorLoginform,String val,String LabId);
    public List TestVendorOrdergridView(DoctorLoginForm doctorLoginform,String LabId);
    public List TestVendorOrderDetails(String LabId,String val);
    public List viewVendorName(String testvendorname);
    public List viewpatienttestorderDetails(TestOrderManagerForm patienttestorderFormOject,TestOrderManagerSubForm patienttestorderSuFormObject,Integer labid,String username)throws ParseException; 
  

    public List testOrderManagerVendorList(HttpSession httpSession)throws ParseException;
    public List testOrderManagerDoctorList(HttpSession httpSession)throws ParseException;
    public List testOrderManagerGroupList(HttpSession httpSession)throws ParseException;
    public List testOrderManagerSubGroupList(HttpSession httpSession, TestOrderManagerForm testOrderManagerForm)throws ParseException;
    public List testOrderManagerTestList(HttpSession httpSession, TestOrderManagerForm testOrderManagerForm)throws ParseException;

	public List viewPatientLoginDetails(PatientLoginForm patientLoginform,String LabId,String refId) throws ParseException;
	public List PatientOrdergridView(PatientLoginForm patientLoginForm,String LabId);
	public List PatientOrderView(PatientLoginForm patientLoginForm,String val,String LabId);
	public List PatientOrderDetails(String LabId,String val);


	

	public List TestOrderManagergridView(HttpSession httpSession,TestOrderManagerForm testordermanagerform);
	public String saveOrderDetails(PatientTestOrders addOrder) throws ParseException;

	public Integer testOrderManagerRate(HttpSession httpSession, TestOrderManagerForm testOrderManagerForm)throws ParseException;
	public List testOrderManagerSpecimen(HttpSession httpSession, TestOrderManagerForm testOrderManagerForm)throws ParseException;


	public List testOrderDetails(String LabId,String val);
	public List testOrdergridView(String LabId,TestOrderManagerForm testViewForm);
	public List testOrderGridDetails(TestOrderManagerForm getGirdTestDetail,String val,String LabId,HttpSession httpSession);
	
	public String updateOrderValue(PatientTestOrders updateOrder) throws ParseException;
	public String updateOrderValueTest(PatientTests testorderAddModel) throws ParseException;
	public String changepassword(String username,IndexForm indexformobj);
	public ChangePassword forgotPassword(ChangePassword changepassword);
	public ChangePassword forgotPasswordvq(ChangePassword changepassword);
	public String changepasswordpatient(String patientname,IndexForm indexformobj);
	public String changePasswordVendor(String vendorname,IndexForm indexformobj);
	public String changePasswordDoctor( String doctorname,IndexForm indexformobj);
	public List getUserType();
	public ChangePassword forgotPasswordSave(ChangePassword changepassword);
	public List LoginForm(String username);
	public ChangePassword verifyQuestion(ChangePassword changepassword, String username, String usertype);
	public ChangePassword changingpassword(ChangePassword changepassword, String username, String usertype);
	public String registersave(ClinicalLab labmodel) throws ParseException;
	public String registersaveuser(User labmodel) throws ParseException;
	public List getLabIdSignUp(ClinicalLabInfoForm form);
	public List sendmailifsuccess(ClinicalLabInfoForm form);

}
