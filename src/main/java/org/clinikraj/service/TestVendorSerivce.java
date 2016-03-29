package org.clinikraj.service;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.clinikraj.form.DoctorLoginForm;
import org.clinikraj.form.IndexForm;
import org.clinikraj.form.TestVendorManagerForm;
import org.clinikraj.form.TestVendorManagerSubForm;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public interface TestVendorSerivce {
	
	public TestVendorManagerForm save(TestVendorManagerForm testvendormanagerform,Integer labid,String username);
	public List viewvendorDetails(TestVendorManagerForm vendorFormObject,TestVendorManagerSubForm vendormanagerSubObject,Integer labid,String username) throws ParseException;	
	public List postofficevalues(String var) throws ParseException;
	public List Prefferedcontact();
	public TestVendorManagerForm viewVendor(String val,Integer labid,String username) throws ParseException;
	public String  deleteVendor(String val,Integer labid,String username) throws ParseException ;
    public List getTieupList();
    public List getSmsList();
    public String createuservendor(TestVendorManagerForm createuservendorform,Integer labid,String username);
    public String vendoruser(String vendid);
    public List viewVendorLoginDetails(String refId,DoctorLoginForm doctorLoginform,String LabId) throws ParseException;
    public TestVendorManagerForm viewDoctorName(TestVendorManagerForm testvendorLoginform,String testvendorname);
    public DoctorLoginForm TestVendorOrderViews(DoctorLoginForm doctorLoginforms,String val,String LabId);
    public List TestVendorOrdergridView(DoctorLoginForm doctorLoginform,String LabId);
    public DoctorLoginForm testVendorOrderDetails(String LabId,DoctorLoginForm doctorLoginform,String val);
    public String LoginForm(String username);
    public IndexForm logoutendsession(HttpSession httpSession, IndexForm indexForm);

}
