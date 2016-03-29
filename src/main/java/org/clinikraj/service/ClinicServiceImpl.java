package org.clinikraj.service;



import java.text.DateFormat;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.util.IOUtils;
import org.clinikraj.dao.ClinicDao;
import org.clinikraj.form.ChangePassword;
import org.clinikraj.form.ClinicalLabInfoForm;
import org.clinikraj.form.DoctorLoginForm;
import org.clinikraj.form.DoctorLoginSubForm;
import org.clinikraj.form.IndexForm;
import org.clinikraj.form.PatientLoginForm;
import org.clinikraj.form.PatientManagerForm;
import org.clinikraj.form.PatientManagerSubForm;
import org.clinikraj.form.UserAccessManagerForm;
import org.clinikraj.form.UserAccessManagerSubForm;
import org.clinikraj.form.TestVendorManagerForm;
import org.clinikraj.form.TestVendorManagerSubForm;
import org.clinikraj.model.ClinicalLab;
import org.clinikraj.model.Patient;
import org.clinikraj.model.Pintable;
import org.clinikraj.model.User;
import org.clinikraj.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.FileEditor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ClinicServiceImpl implements ClinicService{
	@Autowired
	public ClinicDao clinicDao;

	@Transactional
	public IndexForm login(IndexForm indexForm){
		return clinicDao.login(indexForm);
	}
	public IndexForm patientLoginClinicSelect(IndexForm indexForm){
		return clinicDao.patientLoginClinicSelect(indexForm);
	}
	public IndexForm patientLogin(IndexForm indexForm){
		return clinicDao.patientLogin(indexForm);
	}
	public IndexForm doctorLoginClinicSelect(IndexForm indexForm){
		return clinicDao.doctorLoginClinicSelect(indexForm);
	}
	public IndexForm doctorLogin(IndexForm indexForm){
		return clinicDao.doctorLogin(indexForm);
	}
	public IndexForm reportLoginClinicSelect(IndexForm indexForm){
		return clinicDao.reportLoginClinicSelect(indexForm);
	}
	public IndexForm reportLogin(IndexForm indexForm){
		return clinicDao.reportLogin(indexForm);
	}
	public List viewPatienDetails(PatientManagerForm patientFormObject,PatientManagerSubForm patientSubObject,Integer labid,String username) throws ParseException{
	
		return clinicDao.viewPatienDetails(patientFormObject, patientSubObject,labid,username);
	}
	public List postofficevalues(String var) throws ParseException{	
		return clinicDao.postofficevalues( var);
	}
	public List Prefferedcontact(){
		return clinicDao.Prefferedcontact();
	}
	public List postofficePatienvalues(String var) throws ParseException
	{
		return clinicDao.postofficePatienvalues(var);
	}
	public ClinicalLabInfoForm registersave(ClinicalLabInfoForm labform) throws ParseException, IOException{
		String output=null;
		
		ClinicalLab labmodel= new ClinicalLab();
		User usermodel= new User();
		labmodel.setCreatedBy("SYSTEM");
		labmodel.setCreatedDate(new Date());
		labmodel.setLastUpdatedBy("SYSTEM");
		labmodel.setLastUpdatedDate(new Date());
		labmodel.setLabId(null);
		labmodel.setClient(1);
		labmodel.setLabName(labform.getLabName());
		labmodel.setWebsiteAddress(labform.getWebsiteAddress());
		labmodel.setEmailId(labform.getEmailId().toLowerCase());
		labmodel.setAlternateEmailId(labform.getAlternateEmailId().toLowerCase());
		labmodel.setAddressLine1(labform.getAddressLine1());
		labmodel.setAddressLine2(labform.getAddressLine2());
		labmodel.setArea(labform.getArea());
		labmodel.setPostOfficeCode(labform.getPostalcode());
		labmodel.setCity(labform.getCity());
		labmodel.setDistrict(labform.getDistrict());
		labmodel.setState(labform.getState());
		labmodel.setCountry(labform.getCountry());
		labmodel.setPhoneLandline(labform.getPhoneLandLine());
		labmodel.setPhoneMobile(labform.getPhoneMobile());
		labmodel.setPhoneFax(labform.getPhoneFax());
		labmodel.setEmergencyPhoneNumber(labform.getEmergencyPhoneNumber());
		labmodel.setActiveFlag("Y");
		labmodel.setDeleteFlag("N");
		labmodel.setAllowThirdpartyAccess(labform.getAllowThirdpartyAccess());
		labmodel.setStartDate(new Date());
		labmodel.setRemarks(labform.getRemarks());
		
		//call to resize the image
		if(labform.getFileupload().getBytes().length!=0)
		{
		InputStream input=labform.getFileupload().getInputStream();
		InputStream is;
		BufferedImage buff=ImageIO.read(input);
		int type = buff.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : buff.getType();
        System.out.println(type);
        BufferedImage resizedImage = new BufferedImage(200, 200, type);//set width and height of image
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(buff, 0, 0, 200, 200, null);
        g.dispose();

       // BufferedImage to ByteArrayInputStream
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(resizedImage, "jpg", os);
        is = new ByteArrayInputStream(os.toByteArray()); 
		labmodel.setLogo(os.toByteArray());
		}
		
		output=clinicDao.registersave(labmodel);
		
		return labform;
	}

public TestVendorManagerForm save(TestVendorManagerForm testvendormanagerform) {
		// TODO Auto-generated method stub
		return null;
	}


public ClinicalLabInfoForm registersaveuser(ClinicalLabInfoForm labform, ClinicalLab labmodel) throws ParseException{
		
		User usermodel= new User();
		Integer refid=null;
		
		 
		List labid=clinicDao.getLabIdSignUp(labform);
		
		refid=(Integer)labid.get(0);
		
		
		
		usermodel.setCreatedBy("SYSTEM");
		usermodel.setCreatedDate(new Date());
		usermodel.setLastUpdatedBy("SYSTEM");
		usermodel.setLastUpdatedDate(new Date());
		usermodel.setUserId(null);
		usermodel.setClinicalLab(refid);
		usermodel.setUserName(labform.getEmailId().toLowerCase());
		usermodel.setUserType("LAB");
		usermodel.setReferenceId(refid);
		usermodel.setRole("LABADMIN");
		usermodel.setPassword("123");
		usermodel.setDefaultPasswordChanged("N");
		usermodel.setPasswordQuestion1("123");
		usermodel.setPasswordAnswer1("123");
		usermodel.setPasswordQuestion2("123");
		usermodel.setPasswordAnswer2("123");
		usermodel.setPasswordQuestion3("123");
		usermodel.setPasswordAnswer3("123");
		usermodel.setActiveFlag("Y");
		usermodel.setDeleteFlag("N");
		usermodel.setStartDate(new Date());
		usermodel.setLastSuccessLoginDate(new Date());
		usermodel.setLastFailedLoginDate(new Date());
		usermodel.setFirstLogin("Y");
		String output=null;
		
		output=clinicDao.registersaveuser(usermodel);
		return labform;
		
	}
	
	public List getActiveFlagList() {
		// TODO Auto-generated method stub
		return clinicDao.getActiveFlagList();
	}

	public List postofficePatientvalues(String var) throws ParseException {
		ClinicalLabInfoForm patientobject =new ClinicalLabInfoForm();
		List postvalue=clinicDao.postofficePatienvalues(var);
		
		Pintable patient = (Pintable) postvalue.get(0);
		List postdetaillist=new ArrayList();
		patientobject=new ClinicalLabInfoForm();		
			
		patientobject.setCity(patient.getCity());
		patientobject.setDistrict(patient.getDistrict());
		patientobject.setState(patient.getState());
		patientobject.setCountry(patient.getCountry());
		postdetaillist.add(patientobject);				
		return postdetaillist;
	}
	
public String changepassword(String username,IndexForm indexformobj)
	{	 
		String output=clinicDao.changepassword(username, indexformobj);
		return output;
	}
public ChangePassword forgotPassword(ChangePassword changepassword){
	return clinicDao.forgotPassword(changepassword);
	
}
public ChangePassword forgotPasswordvq(ChangePassword changepassword){
	return clinicDao.forgotPasswordvq(changepassword);
}
public List getUserType(){
	return clinicDao.getUserType();
}
	public String changepasswordpatient(String patientname,IndexForm indexformobj){
		
		   String output=clinicDao.changepasswordpatient(patientname, indexformobj);
		 
		return output;
	}
	public String changePasswordVendor(String vendorname,IndexForm indexformobj)
	{  
		
		return clinicDao.changePasswordVendor( vendorname, indexformobj);
	}
	public String changePasswordDoctor(String doctorname,IndexForm indexformobj)
	{  
		
		return clinicDao.changePasswordDoctor( doctorname, indexformobj);
	}
	
	public ChangePassword forgotPasswordSave(ChangePassword changepassword){
		return clinicDao.forgotPasswordSave(changepassword);
	}
	public ChangePassword verifyQuestion(ChangePassword changepassword, String username, String usertype)
	{
		return clinicDao.verifyQuestion(changepassword, username, usertype);
	}
	public ChangePassword changingpassword(ChangePassword changepassword, String username, String usertype)
	{
		return clinicDao.changingpassword(changepassword, username, usertype);
	}
	public String sendmailifsuccess(ClinicalLabInfoForm form){
		List email=clinicDao.sendmailifsuccess(form);
		String mail=null;
		mail=(String) email.get(0);
		return mail;
	}
}



