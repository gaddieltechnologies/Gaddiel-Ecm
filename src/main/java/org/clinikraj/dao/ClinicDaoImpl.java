package org.clinikraj.dao;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolationException;

import org.apache.log4j.Logger;

import org.clinikraj.form.ClinicalLabInfoForm;

import org.clinikraj.model.Client;
import org.clinikraj.model.ClinicalLab;
import org.clinikraj.model.Doctor;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.clinikraj.form.ChangePassword;
import org.clinikraj.form.DoctorForm;
import org.clinikraj.form.DoctorLoginForm;
import org.clinikraj.form.DoctorLoginSubForm;
import org.clinikraj.form.DoctorSubForm;
import org.clinikraj.form.DoctorTestOrderForm;
import org.clinikraj.form.PatientLoginForm;
import org.clinikraj.form.PatientManagerForm;
import org.clinikraj.form.PatientManagerSubForm;
import org.clinikraj.form.TestOrderManagerForm;
import org.clinikraj.form.TestOrderManagerSubForm;
import org.clinikraj.form.UserAccessManagerForm;
import org.clinikraj.form.UserAccessManagerSubForm;
import org.clinikraj.form.TestVendorManagerForm;
import org.clinikraj.form.TestVendorManagerSubForm;
import org.clinikraj.model.Doctor;
import org.clinikraj.model.PatientTestOrders;
import org.clinikraj.model.PatientTests;
import org.clinikraj.model.Pintable;
import org.clinikraj.model.Specilizations;
import org.clinikraj.model.TestVendor;
import org.clinikraj.model.Patient;
import org.clinikraj.util.Converter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.clinikraj.form.IndexForm;
import org.clinikraj.model.User;


import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

@Repository
public class ClinicDaoImpl implements ClinicDao {
	
	private static final Logger logger = Logger.getLogger(ClinicDaoImpl.class);

	@Autowired	
	private SessionFactory sessionFactory;
	
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public ClinicDaoImpl(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		}
	
	 @Transactional
	 public IndexForm login(IndexForm indexForm)
	 {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String result = null;
	String output= null;
	IndexForm indexform=new IndexForm();
	try{
	List list=new ArrayList();
System.out.println(indexForm.getClinicallabUserName());
	list=hibernateTemplate.find("from User where userName='"+indexForm.getClinicallabUserName().toLowerCase()+"' and password='"+indexForm.getClinicallabUserPassword()+"' and endDate is null");
System.out.println("hitting daoimpl");
	
	
	User usera=(User)list.get(0);
	
    indexForm.setLabid(usera.getClinicalLab());
    indexForm.setRole(usera.getRole());
	indexForm.setRefid(usera.getReferenceId());
	indexForm.setFirstLogin(usera.getFirstLogin());
	indexForm.setUserType(usera.getUserType());
	//System.out.println("222222222222222222"+usera.getFirstLogin());
	
		if((usera.getUserName().equals(indexForm.getClinicallabUserName()))&&(usera.getPassword().equals(indexForm.getClinicallabUserPassword()))&&(usera.getActiveFlag().equals("Y"))&&(usera.getDeleteFlag().equals("N"))&&(usera.getUserType().equals("LAB")))
		{
		
			System.out.println("match daoimpl");
        result="match";
        	//System.out.println(dateFormat.format(new Date())+"+++++++");
		indexform.setDatename(usera.getNextPasswordChangeDate());
			//System.out.println(indexform.getDatename()+"oooooo");
			
		}
		if((usera.getNextPasswordChangeDate()!=null)){
			if((usera.getNextPasswordChangeDate().equals(new Date()))){
		//	System.out.println(">>>>>>>>>>>>>>>>>>>>>>match daoimp222222");
			  
	    	output= "Your Password has expired.Please reset the password.";
				}
			else if((usera.getNextPasswordChangeDate().before(new Date()))){
			//	System.out.println(">>>>>>>>>>>>>>>>>>>>>>match daoimp33333");
				  
		    	output= "Your Password has expired.Please reset the password.";
			}
		}
	    
	}
	catch(IndexOutOfBoundsException e)
	{
		System.out.println("not a match");
		result="not match";
	}
	catch(NullPointerException e)
	{
		System.out.println("not a match");
		result="not match";
	} 
	
	indexForm.setResult(result);
	indexForm.setOutput(output);
	return indexForm;
	
}
	
	 /*------------------------------------Clinical lab-----------------------------------------------------------------------*/
	 public List clinicalform(String LabId){
		 List list=new ArrayList();
		 
		 try{
		 list=hibernateTemplate.find("select c.clientName,cl.labId,cl.client,cl.labName,cl.websiteAddress,cl.emailId,cl.alternateEmailId,cl.addressLine1,cl.addressLine2,cl.area,cl.postOfficeCode,cl.city,cl.district,cl.state,cl.country,cl.phoneLandline,cl.emergencyPhoneNumber,cl.phoneMobile,cl.phoneFax,cl.startDate,cl.endDate,cl.allowThirdpartyAccess,cl.remarks from ClinicalLab as cl,Client as c where c.clientId=cl.client and cl.labId="+LabId+"");
	
		 
		
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		return list;
	   
	 }

	 public List getLabLogo(String LabId){
			
				 List getLogoList=hibernateTemplate.find("from ClinicalLab where labId="+LabId+"");
		
				
					 return getLogoList; 
			}
	 /*------------------------------------Patient Manager-----------------------------------------------------------------------*/
		/* Grid View after Search*/

	public IndexForm patientLoginClinicSelect(IndexForm indexForm)
	{
		List list=new ArrayList();
		List labname=new ArrayList();
		List patientlablist=new ArrayList();
		
		try{
System.out.println("xxxxxxxxxxxxxxxxxxxxx");
		labname=hibernateTemplate.find("select CL.labName from ClinicalLab as CL, User as U where U.userName= '" +indexForm.getPatientUserName().toLowerCase()+ "' and CL.labId=U.clinicalLab and U.activeFlag='Y' and U.deleteFlag='N'");
		for(int name=0;name<labname.size();name++){
			String obj=(String) labname.get(name);
			
			patientlablist.add(obj);
		}
		
		indexForm.setPatientClinicallabOptions(patientlablist);
		
System.out.println("---LIST SIZE OF PATIENTS----"+patientlablist.size());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return indexForm;
	}
	public IndexForm patientLogin(IndexForm indexForm){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String output=null;
		String result = null;
 		try{
		List list=new ArrayList();
System.out.println(indexForm.getClinicallabUserName());
		List listone=new ArrayList();
		list=hibernateTemplate.find("from User where userName='"+indexForm.getPatientUserName().toLowerCase()+"' and password='"+indexForm.getPatientUserPassword()+"' and endDate is null");

		User usera=(User)list.get(0);
		listone=hibernateTemplate.find("from Patient where patientId="+usera.getReferenceId());
		System.out.println("hitting daoimpl");
		System.out.println(list.size());
System.out.println("hitting daoimpl");
System.out.println(list.size());
		Patient patienta=(Patient)listone.get(0);
		indexForm.setUser(patienta.getPatientName());
		indexForm.setLabid(usera.getClinicalLab());
	    indexForm.setRole(usera.getRole());
		indexForm.setRefid(usera.getReferenceId());
		indexForm.setFirstLogin(usera.getFirstLogin());
		indexForm.setPatientdob(patienta.getDateOfBirth());
		indexForm.setUserType(usera.getUserType());
		if((usera.getUserName().equals(indexForm.getPatientUserName()))&&(usera.getPassword().equals(indexForm.getPatientUserPassword()))&&(usera.getActiveFlag().equals("Y"))&&(usera.getDeleteFlag().equals("N"))&&(usera.getUserType().equals("PATIENT")))
		{
			
System.out.println("match daoimpl");
			result="match";
		}
	
			
			if((usera.getNextPasswordChangeDate()!=null)){
			
				//System.out.println(">>>>>>>>>>>>>>>>>>>>>>match daoimp00000");
				if((usera.getNextPasswordChangeDate().equals(new Date()))){
				//System.out.println(">>>>>>>>>>>>>>>>>>>>>>match daoimp222222");
				  
		    	output= "Your Password has expired.Please reset the password.";
					}
				else if((usera.getNextPasswordChangeDate().before(new Date()))){
					//System.out.println(">>>>>>>>>>>>>>>>>>>>>>match daoimp33333");
					  
			    	output= "Your Password has expired.Please reset the password.";
				}
				
		    }
		
 		}catch(IndexOutOfBoundsException e){
 			System.out.println("not a match");
 			result="not match";
 		}
 		catch(NullPointerException e){
 			System.out.println("not a match");
 			result="not match";
 		}

		indexForm.setResult(result);
		indexForm.setOutput(output);
		return indexForm;
		
	}
 	
 	public IndexForm doctorLoginClinicSelect(IndexForm indexForm)
 	{
 		List list=new ArrayList();
 		List labname=new ArrayList();
 		List doctorlablist=new ArrayList();
 		
 		labname=hibernateTemplate.find("select CL.labName from ClinicalLab as CL, User as U where U.userName= '" +indexForm.getDoctorUserName().toLowerCase()+ "' and CL.labId=U.clinicalLab and U.activeFlag='Y' and U.deleteFlag='N'");
 		for(int name=0;name<=list.size();name++){
 			String obj=(String) labname.get(name);
 		doctorlablist.add(obj);
 		}
 		System.out.println("---Doctor Lab List---"+doctorlablist.size());
 		indexForm.setDoctorClinicallabOptions(doctorlablist);
 		
 		
 		return indexForm;
 	}
 
 	public IndexForm doctorLogin(IndexForm indexForm){
 		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String output=null;
 		String result = null;
		try{
 		List list=new ArrayList();
		list=hibernateTemplate.find("from User where userName='"+indexForm.getDoctorUserName().toLowerCase()+"' and password='"+indexForm.getDoctorUserPassword()+"' and endDate is null");

		User usera=(User)list.get(0);
		List listone=new ArrayList();
		listone=hibernateTemplate.find("from Doctor where doctorId="+usera.getReferenceId());
		Doctor doctora=(Doctor)listone.get(0);
		System.out.println("hitting daoimpl");
		System.out.println(list.size());

System.out.println("hitting daoimpl");
System.out.println(list.size());

		indexForm.setLabid(usera.getClinicalLab());
	    indexForm.setRole(usera.getRole());
		indexForm.setRefid(usera.getReferenceId());
		indexForm.setUser(doctora.getDoctorName());
		indexForm.setDoctorspecialization(doctora.getSpecialization());
		indexForm.setFirstLogin(usera.getFirstLogin());
		indexForm.setUserType(usera.getUserType());
		if((usera.getUserName().equals(indexForm.getDoctorUserName()))&&(usera.getPassword().equals(indexForm.getDoctorUserPassword()))&&(usera.getActiveFlag().equals("Y"))&&(usera.getDeleteFlag().equals("N"))&&(usera.getUserType().equals("DOCTOR")))
		{
			
System.out.println("match daoimpl");
			result="match";
		}
		
		if((usera.getNextPasswordChangeDate()!=null))
		{
			
			if((usera.getNextPasswordChangeDate().equals(new Date())))
			{
			//System.out.println(">>>>>>>>>>>>>>>>>>>>>>match daoimp222222");
				output= "Your Password has expired.Please reset the password.";
			}
			else if((usera.getNextPasswordChangeDate().before(new Date()))){
			//	System.out.println(">>>>>>>>>>>>>>>>>>>>>>match daoimp33333");
				  
		    	output= "Your Password has expired.Please reset the password.";
			}
			
	    }
		
 	}catch(IndexOutOfBoundsException e){
		System.out.println("not a match");
		result="not match";
	}
	catch(NullPointerException e){
		System.out.println("not a match");
		result="not match";
	}
	
		indexForm.setResult(result);
		indexForm.setOutput(output);
		return indexForm;
		
	}
 	
 	
 	public IndexForm reportLoginClinicSelect(IndexForm indexForm)
 	{
 		List list=new ArrayList();
 		List labname=new ArrayList();
 		List reportlablist=new ArrayList();
 		
 		labname=hibernateTemplate.find("select CL.labName from ClinicalLab as CL, User as U where U.userName= '" +indexForm.getReportUserName().toLowerCase()+ "' and CL.labId=U.clinicalLab and U.activeFlag='Y' and U.deleteFlag='N'");
 		for(int name=0;name<=list.size();name++){
 			String obj=(String) labname.get(name);
 		reportlablist.add(obj);
 		
 		indexForm.setReportClinicallabOptions(reportlablist);
 		}
 		
 		return indexForm;
 	}
 
 	public IndexForm reportLogin(IndexForm indexForm){
 		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String output=null;
 		String result = null;
		try{
 		List list=new ArrayList();
		list=hibernateTemplate.find("from User where userName='"+indexForm.getReportUserName().toLowerCase()+"' and password='"+indexForm.getReportUserPassword()+"' and endDate is null");

		User usera=(User)list.get(0);
		List listone=new ArrayList();
		listone=hibernateTemplate.find("from TestVendor where testVendorId="+usera.getReferenceId());
		System.out.println("hitting daoimpl");
		System.out.println(list.size());

System.out.println("hitting daoimpl");
System.out.println(list.size());

		TestVendor testvendora=(TestVendor)listone.get(0);
		indexForm.setUser(testvendora.getTestVendorName());
		indexForm.setLabid(usera.getClinicalLab());
	    indexForm.setRole(usera.getRole());
		indexForm.setRefid(usera.getReferenceId());
		indexForm.setFirstLogin(usera.getFirstLogin());
		indexForm.setTestvendorregistration(testvendora.getTestVendorRegnNumber());
		indexForm.setUserType(usera.getUserType());
		if((usera.getUserName().equals(indexForm.getReportUserName()))&&(usera.getPassword().equals(indexForm.getReportUserPassword()))&&(usera.getActiveFlag().equals("Y"))&&(usera.getDeleteFlag().equals("N"))&&(usera.getUserType().equals("TESTVENDOR")))
		{
			
System.out.println("match daoimpl");
			result="match";
		}
		
		if((usera.getNextPasswordChangeDate()!=null)){
			
			if((usera.getNextPasswordChangeDate().equals(new Date()))){
		//	System.out.println(">>>>>>>>>>>>>>>>>>>>>>match daoimp222222");
			  
	    	output= "Your Password has expired.Please reset the password.";
				}
			else if((usera.getNextPasswordChangeDate().before(new Date()))){
			//	System.out.println(">>>>>>>>>>>>>>>>>>>>>>match daoimp33333");
				  
		    	output= "Your Password has expired.Please reset the password.";
			}
			
	    }

		
 	}catch(IndexOutOfBoundsException e){
		System.out.println("not a match");
		result="not match";
	}
	catch(NullPointerException e){
		System.out.println("not a match");
		result="not match";
	}
	
		indexForm.setResult(result);
		indexForm.setOutput(output);
		return indexForm;
		
	}
	/*------------------------------------Lab Information Manager---------------------------------------------------------------*/
	 
	/*------------------------------------Patient Manager-----------------------------------------------------------------------*/


 	public List viewPatienDetails(PatientManagerForm patientFormObject,PatientManagerSubForm patientSubObject,Integer labid,String username) throws ParseException	
	{
			
System.out.println("HIT Patient DETAIL VIEW IMPL");	
			
	PatientManagerSubForm patientSubFormObject=new PatientManagerSubForm();				


	String searchName=patientFormObject.getSearchPatientName();
	String searchMobile=patientFormObject.getSearchPhoneMobile();
	String searchEmail=patientFormObject.getSearchEmailId();
	String searchVendorName=patientFormObject.getSearchTestVendorName();


	String qureyString="select pd.patientId,pd.patientName,pd.sex,pd.age,pd.preferredContactMethod,pd.phoneMobile,pd.emailId,pd.postOfficeCode,dr.doctorName,vr.testVendorName from Patient as pd,Doctor as dr,TestVendor as vr where pd.clinicalLab='"+labid+"'  and pd.referingDoctorId=dr.doctorId and pd.referingTestVendorId=vr.testVendorId and pd.activeFlag='Y' and pd.deleteFlag='N' and pd.endDate is null";

	List patientDetailList=new ArrayList();
						
				if(searchName!=null && searchName.length()!=0 )
				{
					qureyString=qureyString+" and pd.patientName like '"+searchName+"%' ";
				}
				
				if(searchMobile!=null && searchMobile.length()!=0)
				{
					qureyString=qureyString+" and pd.phoneMobile like '"+searchMobile+"%' ";
				}
				
				if(searchEmail!=null && searchEmail.length()!=0)
				{
					qureyString=qureyString+" and pd.emailId like '"+searchEmail+"%' ";
				}
				
				/*if(searchVendorName!=null)
				{
					qureyString=qureyString+"and where pd.patientName like '"+searchVendorName+"' ";
				}*/

				
		
		List patientDetailQueryList=new ArrayList();
		patientDetailQueryList=hibernateTemplate.find(qureyString);
		return patientDetailQueryList;

		}



	//Test Vendor Add details
		 public String save(TestVendor testVendor,Integer labid,String username) 
		 {	
	System.out.println("save in test vendor button in daoimpl"); 		 
		   		  hibernateTemplate.save(testVendor);
		   		  return "Save Success";			  
		 }
		
		/* Patient Add */
		public String addPatienDetails(Patient addPatient) throws ParseException	

		{
			hibernateTemplate.save(addPatient);

//System.out.println("-------Hit patirn add Impl----");

System.out.println("-------Hit patirn add Impl----");

			return "SAVE SUCCESS";
		}
	   	
		

		/*Fetching of patient postoffice code values*/
		public List postofficePatienvalues(String var) throws ParseException{			
		List postvalue=hibernateTemplate.find(" from Pintable  where postOfficeCode="+var+"");		
        return postvalue;
		}
		
		/* Patient Detailed View*/
		public List viewPatient(String val) throws ParseException
		{
			
			List patientViewQuery=hibernateTemplate.find("from Patient where patientId="+val+""); 
			return patientViewQuery;
		}

		//Fetching of postoffice code values in Test vendor
				public List postofficevalues(String var) throws ParseException
				{	
System.out.println("****************HIT POST OFFICE IMPL***************");
						List postvalue=new ArrayList();
					    postvalue=hibernateTemplate.find(" from Pintable  where postOfficeCode="+var+"");			   			
						return postvalue;
					}
		
		public List Prefferedcontact(){
			List prefferedcontact=new ArrayList();
			prefferedcontact=hibernateTemplate.find("select contactMode from ContactModes where activeFlag='Y'");
			return prefferedcontact;
		}

	

		/*------------------------------------Doctor Manager-----------------------------------------------------------------------*/
	

public List doctorform(DoctorForm doctoform, DoctorSubForm subdoctor,String LabId){
		String searchDoctor=doctoform.getSearchdoctor();
		Long searchPhoneno=doctoform.getSearchphoneno();
		String searchEmail=doctoform.getSearchemail();
		String searchSpecialzie=doctoform.getSearchspecialzie();
		String strquery="select doctor.doctorId, doctor.doctorName, doctor.doctorImcNumber, doctor.specialization, doctor.tieUp, doctor.emailId, doctor.phoneMobile, doctor.preferredContactMethod from Doctor doctor,ClinicalLab as cl where doctor.endDate is null and cl.labId="+LabId+"";
		if(searchDoctor!=null && searchDoctor.length()!=0)
		{
			strquery=strquery+" and  doctor.doctorName like '"+searchDoctor+"%' ";
		}
		
		if(searchPhoneno!=null && searchPhoneno.longValue()!=0)
		{
			strquery=strquery+" and  doctor.phoneMobile like '"+searchPhoneno+"%' ";
		}

		if(searchEmail!=null && searchEmail.length()!=0)
		{
			strquery=strquery+" and  doctor.emailId like '"+searchEmail+"%' ";
		}
		
		if(searchSpecialzie!=null && searchSpecialzie.length()!=0)
		{
			strquery=strquery+" and  doctor.specialization like '"+searchSpecialzie+"%' ";
		}
		List doctorlist=new ArrayList();
		doctorlist=hibernateTemplate.find(strquery);

		return doctorlist;
		}	

       /* Doctor Add */
	 public String doctorAdd(Doctor doctor,String username, String labId ){

	 		String output="Record saved successfully";
	 		try{
			hibernateTemplate.save(doctor);
			
//System.out.println("-------Hit patirn add Impl----");
	 		}
	 		catch(DataIntegrityViolationException e){
	 			output="Record already exists";
	 		}
			System.out.println("-------Hit patirn add Impl----"+output);

			return output;
		}
	 	
	
	 public String addUser(User user,String labid,String username){
	 		String output="Record saved successfully";
	 		try{
			hibernateTemplate.saveOrUpdate(user);
			

	 		}
	 		catch(DataIntegrityViolationException e){
	 			output="Username already exists";
	 		}
			

			return output;
	   
	   
	}
	 public String addDocUser(String doctorid){
		 List list=new ArrayList();
		 
		 list=hibernateTemplate.find("select emailId from Doctor where doctorId ="+doctorid+"");
		 String doctornam=list.get(0).toString();

	    return doctornam;
		
		 
	 }
	 /* Doctor View */
 public List doctorView(String val){
		List list=new ArrayList();
		list=hibernateTemplate.find("from Doctor where doctorId ="+val+"");
		return list;
		 
	 }
 
 /*Fetching of Doctor postoffice code values*/
	 public List postofficedoctor(String var) throws ParseException{
		 DoctorForm doctorform=new DoctorForm();
		 List postvalue=new ArrayList();
		    postvalue=hibernateTemplate.find(" from Pintable  where postOfficeCode="+var+"");
		    Pintable Doctor = (Pintable) postvalue.get(0);
			List postdetaillist=new ArrayList();
			doctorform.setCity(Doctor.getCity());
			doctorform.setDistrict(Doctor.getDistrict());
			doctorform.setState(Doctor.getState());
			doctorform.setCountry(Doctor.getCountry());
			postdetaillist.add(doctorform);
		return postdetaillist;
		 
	 }
	public List Specilizationdoctor() throws ParseException{
		 List specdetaillist=new ArrayList();
		 specdetaillist=hibernateTemplate.find(" select specilization  from Specilizations");
		return specdetaillist;
		 
	 }

		
	

	
/* Grid View after Search in Test vendor*/
		public List viewvendorDetails(TestVendorManagerForm vendorFormObject,TestVendorManagerSubForm vendormanagerSubObject,Integer labid,String username) throws ParseException	
		{
				
System.out.println("HIT vendor DETAIL VIEW IMPL");					
		TestVendorManagerSubForm vendormangerSubFormObject=new TestVendorManagerSubForm();
		
		String searchVendorName=vendorFormObject.getSearchTestvendorName();
		String searchMobile=vendorFormObject.getSearchPhoneMobile();
		String searchContactName=vendorFormObject.getSearchContactName();
		String searchEmail=vendorFormObject.getSearchEmailId();
		String searchpostcode=vendorFormObject.getSearchPostalcode();						
		
	    String vendorQueryList="select vendorDetail.testVendorId,vendorDetail.testVendorName,vendorDetail.phoneMobile,vendorDetail.vendorContactName,vendorDetail.preferredContactMethod,vendorDetail.emailId,vendorDetail.postOfficeCode from TestVendor vendorDetail where vendorDetail.clinicalLab='"+labid+"' and vendorDetail.activeFlag='Y' and vendorDetail.deleteFlag='N' and vendorDetail.endDate is null ";
	    if(searchVendorName!=null && searchVendorName.length()!=0 )
		{
	    	vendorQueryList=vendorQueryList+" and vendorDetail.testVendorName like '"+searchVendorName+"%' ";
		}
		
		if(searchMobile!=null && searchMobile.length()!=0)
		{
			vendorQueryList=vendorQueryList+" and vendorDetail.phoneMobile like '"+searchMobile+"%' ";
		}
		
		if(searchContactName!=null && searchContactName.length()!=0)
		{
			vendorQueryList=vendorQueryList+" and vendorDetail.vendorContactName like '"+searchContactName+"%' ";
		}   
		if(searchEmail!=null && searchEmail.length()!=0)
		{
			vendorQueryList=vendorQueryList+" and vendorDetail.emailId like '"+searchEmail+"%' ";
		} 
		if(searchpostcode!=null && searchpostcode.length()!=0)
		{
			vendorQueryList=vendorQueryList+" and vendorDetail.postOfficeCode like '"+searchpostcode+"%' ";
		}  
		List vendorDetailQueryList=new ArrayList();
		vendorDetailQueryList=hibernateTemplate.find(vendorQueryList);		
		
		return vendorDetailQueryList;
		}

/* Test Vendor Detailed View*/
		public List viewVendor(String val,Integer labid,String username) throws ParseException
		{			
			List vendorViewQuery=hibernateTemplate.find("from TestVendor where clinicalLab='"+labid+"' and testVendorId="+val+""); 
			return vendorViewQuery;
		}
/* Test vendor Delete*/
		public String updatevendor(TestVendor vendormodel,Integer labid,String username)
		{		
			String upvendor="Deleted Successfully";			
			hibernateTemplate.saveOrUpdate(vendormodel);
			return upvendor;
		}



		/*Delete patient*/
		public String deletePatient(Patient patientDeleteModel)
		{		
System.out.println("HIT DELETE DAO IMPL");
			String upvendor="Deleted Successfully";			
			hibernateTemplate.saveOrUpdate(patientDeleteModel);
			return upvendor;
		}
			
		public List getTieupList() {
			List tieUp=new ArrayList();
			tieUp.add("Y");
			tieUp.add("N");
			return tieUp;
		}
		public List getSmsList() {
			List sms=new ArrayList();
			sms.add("Y");
			sms.add("N");
			return sms;
		}

		public List sexList(){
			List sexOption=new ArrayList();
			sexOption.add("M");
			sexOption.add("F");
			return sexOption;
		}
		
/*------------------------------------User Manager-----------------------------------------------------------------------*/

			public List viewLabUserDetails(HttpSession httpSession, UserAccessManagerForm userFormObject,UserAccessManagerSubForm userSubObject) throws ParseException	
			{
					
System.out.println("HIT User DETAIL VIEW IMPL");	
					
			UserAccessManagerSubForm userSubFormObject=new UserAccessManagerSubForm();
			
			
			String searchName=userFormObject.getSearchUserName();
			String searchMobile=userFormObject.getSearchPhoneMobile();
			String searchRole=userFormObject.getSearchRole();
			String searchUserType=userFormObject.getSearchUserType();
					System.out.println("this is the role printed xxxxxxxxxxxxxxxxxxxxxxxxxxxx"+userFormObject.getSearchRole());
					System.out.println("this is the type printed yyyyyyyyyyyyyyyyyyyyyyyyyyyy"+userFormObject.getSearchUserType());
			System.out.println("Jojojojojojojojojojojojojojojojojojoj"+httpSession.getAttribute("labId"));
			List userDetailList=new ArrayList();
					List userLabDetailQueryList=new ArrayList();
					
					
					
					String qureyString="select userLabDetail.userName, userLabDetail.userType, userLabDetail.role, userLabDetail.userId from User as userLabDetail where userLabDetail.userType='LAB' and userLabDetail.activeFlag='Y' and userLabDetail.clinicalLab='"+httpSession.getAttribute("labId")+"'";
			
System.out.println("list of values  size ----> "+userLabDetailQueryList.size());
					if(searchName!=null && searchName.length()!=0 )
					{
						qureyString=qureyString+" and userLabDetail.userName like '"+searchName+"%' ";
					}
					
					
					if(!searchRole.equals("-Select Role-"))
					{
						qureyString=qureyString+" and userLabDetail.role like '"+searchRole+"%' ";
					}
					
					if(!searchUserType.equals("-Select Type-"))
					{
						qureyString=qureyString+"and userLabDetail.userType like '"+searchUserType+"%' ";
					}
					
					userLabDetailQueryList=hibernateTemplate.find(qureyString);
					
				
				return userLabDetailQueryList;

			}


		 	public List viewPatientUserDetails(HttpSession httpSession, UserAccessManagerForm userFormObject,UserAccessManagerSubForm userSubObject) throws ParseException	
			{
					
System.out.println("HIT User DETAIL VIEW IMPL");	
					
			UserAccessManagerSubForm userSubFormObject=new UserAccessManagerSubForm();
			
			String searchName=userFormObject.getSearchUserName();
			String searchMobile=userFormObject.getSearchPhoneMobile();
			String searchRole=userFormObject.getSearchRole();
			String searchUserType=userFormObject.getSearchUserType();
					
			List userDetailList=new ArrayList();
					List userPatientDetailQueryList=new ArrayList();
					
					String qureyString="select userLabDetail.userName, userLabDetail.userType, userLabDetail.role, Cl.postOfficeCode, Cl.phoneMobile, Cl.emailId, userLabDetail.userId from User as userLabDetail, Patient as Cl where userLabDetail.referenceId=Cl.patientId and userLabDetail.userType='PATIENT' and userLabDetail.activeFlag='Y' and userLabDetail.clinicalLab='"+httpSession.getAttribute("labId")+"'";
			
System.out.println("list of values  size ----> "+userPatientDetailQueryList.size());
					if(searchName!=null && searchName.length()!=0 )
					{
						qureyString=qureyString+" and userLabDetail.userName like '"+searchName+"%' ";
					}
					
					if(searchMobile!=null && searchMobile.length()!=0)
					{
						qureyString=qureyString+" and Cl.phoneMobile like '"+searchMobile+"%' ";
					}
					
					if(!searchRole.equals("-Select Role-"))
					{
						qureyString=qureyString+" and userLabDetail.role like '"+searchRole+"%' ";
					}
					
					if(!searchUserType.equals("-Select Type-"))
					{
						qureyString=qureyString+"and userLabDetail.userType like '"+searchUserType+"%' ";
					}
					
					userPatientDetailQueryList=hibernateTemplate.find(qureyString);
					
				
				return userPatientDetailQueryList;

			}

		 	public List viewDoctorUserDetails(HttpSession httpSession, UserAccessManagerForm userFormObject,UserAccessManagerSubForm userSubObject) throws ParseException	
			{
					
System.out.println("HIT User DETAIL VIEW IMPL");	
					
			UserAccessManagerSubForm userSubFormObject=new UserAccessManagerSubForm();
			
			String searchName=userFormObject.getSearchUserName();
			String searchMobile=userFormObject.getSearchPhoneMobile();
			String searchRole=userFormObject.getSearchRole();
			String searchUserType=userFormObject.getSearchUserType();
			System.out.println("this is the role printed xxxxxxxxxxxxxxxxxxxxxxxxxxxx"+userFormObject.getSearchRole());
			System.out.println("this is the type printed yyyyyyyyyyyyyyyyyyyyyyyyyyyy"+userFormObject.getSearchUserType());
			List userDetailList=new ArrayList();
					List userDoctorDetailQueryList=new ArrayList();
					
					String qureyString="select userLabDetail.userName, userLabDetail.userType, userLabDetail.role, Cl.postOfficeCode, Cl.phoneMobile, Cl.emailId, userLabDetail.userId from User as userLabDetail, Doctor as Cl where userLabDetail.referenceId=Cl.doctorId and userLabDetail.userType='DOCTOR' and userLabDetail.activeFlag='Y' and userLabDetail.clinicalLab='"+httpSession.getAttribute("labId")+"'";
			
System.out.println("list of values  size ----> "+userDoctorDetailQueryList.size());
					if(searchName!=null && searchName.length()!=0 )
					{
						qureyString=qureyString+" and userLabDetail.userName like '"+searchName+"%' ";
					}
					
					if(searchMobile!=null && searchMobile.length()!=0)
					{
						qureyString=qureyString+" and Cl.phoneMobile like '"+searchMobile+"%' ";
					}
					
					if(!searchRole.equals("-Select Role-"))
					{
						qureyString=qureyString+" and userLabDetail.role like '"+searchRole+"%' ";
					}
					
					if(!searchUserType.equals("-Select Type-"))
					{
						qureyString=qureyString+"and userLabDetail.userType like '"+searchUserType+"%' ";
					}
					
					userDoctorDetailQueryList=hibernateTemplate.find(qureyString);
									
				return userDoctorDetailQueryList;

			}
		 	public List viewTestVendorUserDetails(HttpSession httpSession, UserAccessManagerForm userFormObject,UserAccessManagerSubForm userSubObject) throws ParseException	
			{
					
System.out.println("HIT User DETAIL VIEW IMPL");	
					
			UserAccessManagerSubForm userSubFormObject=new UserAccessManagerSubForm();
			String searchName=userFormObject.getSearchUserName();
			String searchMobile=userFormObject.getSearchPhoneMobile();
			String searchRole=userFormObject.getSearchRole();
			String searchUserType=userFormObject.getSearchUserType();
			
			List userDetailList=new ArrayList();
					List userTestVendorDetailQueryList=new ArrayList();
					
					String qureyString="select userLabDetail.userName, userLabDetail.userType, userLabDetail.role, Cl.postOfficeCode, Cl.phoneMobile, Cl.emailId, userLabDetail.userId from User as userLabDetail, TestVendor as Cl where userLabDetail.referenceId=Cl.testVendorId and userLabDetail.userType='TESTVENDOR' and userLabDetail.activeFlag='Y' and userLabDetail.clinicalLab='"+httpSession.getAttribute("labId")+"'";
			
System.out.println("list of values  size ----> "+userTestVendorDetailQueryList.size());
					if(searchName!=null && searchName.length()!=0 )
					{
						qureyString=qureyString+" and userLabDetail.userName like '"+searchName+"%' ";
					}
					
					if(searchMobile!=null && searchMobile.length()!=0)
					{
						qureyString=qureyString+" and Cl.phoneMobile like '"+searchMobile+"%' ";
					}
					
					if(!searchRole.equals("-Select Role-"))
					{
						qureyString=qureyString+" and userLabDetail.role like '"+searchRole+"%' ";
					}
					
					if(!searchUserType.equals("-Select Type-"))
					{
						qureyString=qureyString+"and userLabDetail.userType like '"+searchUserType+"%' ";
					}
					
					
					userTestVendorDetailQueryList=hibernateTemplate.find(qureyString);
					
				
				return userTestVendorDetailQueryList;

			}
			 	
		 	public String addUserDetails(User addUser) throws ParseException	
			{
		 		String output="Record saved successfully";
		 		try{
				hibernateTemplate.saveOrUpdate(addUser);
				
	//System.out.println("-------Hit patirn add Impl----");
		 		}
		 		catch(DataIntegrityViolationException e){
		 			output="Record already exists";
		 		}
				System.out.println("-------Hit patirn add Impl----"+output);

				return output;
			}
		 	
		 	
		 	public List viewUser(String val) throws ParseException
			{
				
				List userViewQuery=hibernateTemplate.find("from User where userId="+val+""); 
				return userViewQuery;
			}

			
		 	
		 	public String deleteUser(User userDeleteModel)
			{		
				System.out.println("HIT DELETE DAO IMPL");
				String upvendor="Deleted Successfully";			
				hibernateTemplate.saveOrUpdate(userDeleteModel);
				return upvendor;
			}
		 	
		 	
		 	public List getRoleList(){
		 		List role=new ArrayList();
		 		role.add("SUPERUSER");
		 		role.add("LABADMIN");
		 		role.add("LABUSER");
		 		return role;
		 	}
		 	
		 	
		 	public List getUserTypeList(){
		 		List usertype=new ArrayList();
		 		usertype.add("LAB");
		 		usertype.add("PATIENT");
		 		usertype.add("DOCTOR");
		 		usertype.add("TESTVENDOR");
		 		return usertype;
		 	}
		 	
		 	
		 	public List getDefaultPasswordChangedList(){
		 		List defpasschange=new ArrayList();
		 		defpasschange.add("Y");
		 		defpasschange.add("N");
		 		return defpasschange;
		 	}
		 	
		 	
		 	public List getActiveFlagList(){
		 		List actflag=new ArrayList();
		 		actflag.add("Y");
		 		actflag.add("N");
		 		return actflag;
		 	}
		 	
		 	public List getDeleteFlagList(){
		 		List delflag=new ArrayList();
		 		delflag.add("Y");
		 		delflag.add("N");
		 		return delflag;
		 	}
		 	
			
	/*------------------------------------Test Manager-----------------------------------------------------------------------*/
	 
	/*------------------------------------doctor Login controller-----------------------------------------------------------------------*/ 
	 //Patient
		 	public List viewDoctorLoginDetails(DoctorLoginForm doctorLoginform,String LabId,String refId) throws ParseException
		 	{
		 	
							
                String searchDate=doctorLoginform.getSearchDate();
                Integer searchID=doctorLoginform.getSearchID();
				String searchName=doctorLoginform.getSearchName();
				String searchMobile=doctorLoginform.getSearchMobile();
				String searchEmail=doctorLoginform.getSearchEmail();
			    String searchVendorName=doctorLoginform.getSearchVendorname();	
				

				String qureyString="select porder.orderDate,porder.orderId,porder.orderReference,patientDetail.patientName,tv.testVendorName from PatientTestOrders as porder,Patient as patientDetail,TestVendor as tv,ClinicalLab as cl where porder.patient=patientDetail.patientId and porder.testVendor=tv.testVendorId and porder.doctor="+refId+" and cl.labId="+LabId+"";
		   

				List doctorview=new ArrayList();
				        if(searchDate!=null && searchDate.length()!=0 )
				        {
				        	qureyString=qureyString+" and  porder.orderDate like '"+searchDate+"%' ";
			         	}
				
				        if(searchID!=null && searchID!=0)
				        {
				         	qureyString=qureyString+" and porder.orderId like '"+searchID+"%' ";
				        }
					
						if(searchName!=null && searchName.length()!=0 )
						{
							qureyString=qureyString+" and patientDetail.patientName like '"+searchName+"%' ";
						}
						
						if(searchMobile!=null && searchMobile.length()!=0)
						{
							qureyString=qureyString+" and patientDetail.phoneMobile like '"+searchMobile+"%' ";
						}
						
						if(searchEmail!=null && searchEmail.length()!=0)
						{
							qureyString=qureyString+" and patientDetail.emailId like '"+searchEmail+"%' ";
						}
						
						if(searchVendorName!=null && searchVendorName.length()!=0)
						{
							qureyString=qureyString+" and tv.testVendorName like '"+searchVendorName+"%' ";
						}

						
				List doctorviewlist=new ArrayList();
				doctorviewlist=hibernateTemplate.find(qureyString);
				
				return doctorviewlist;

		 		
		 	}

		 	public List DoctortestOrderDetails(String LabId,String val){

				List list=new ArrayList();
				 
				 try{
				 list=hibernateTemplate.find("select porder.orderId,porder.orderDate,doct.doctorName,tvendor.testVendorName,porder.orderReference,porder.grossAmount,porder.discount,porder.netAmount,porder.adavance,porder.balance,porder.totalAmountCollected,c.clientName,cl.labId,cl.client from ClinicalLab as cl,Client as c,PatientTestOrders as porder,PatientTests as ptest,Doctor as doct,TestVendor as tvendor where ptest.patientTestOrders=porder.orderId  and porder.clinicalLab=cl.labId and c.clientId=cl.client and  porder.doctor=doct.doctorId and porder.testVendor=tvendor.testVendorId and porder.orderId="+val+"  and cl.labId="+LabId+"");
			
				 
				
				 } 
				 catch(Exception e){
					 e.printStackTrace();
				 }
				return list;
				
				
			}

		 	public List DoctortestOrdergridView(DoctorLoginForm doctorLoginform,String LabId){
		 		List list=new ArrayList();
		 		 list=hibernateTemplate.find("select tgroup.testGroupName,tsubgroup.testSubgroupName,test.testName,ptest.orderTestsId,ptest.testResult,ptest.testAnalysisRemarks,ptest.testRate,ptest.specimenCollected,ptest.testJobNumber,ptest.testBy,ptest.testResultApprovedBy from ClinicalLab as cl,PatientTestOrders as porder,PatientTests as ptest,TestGroups as tgroup,TestSubgroups as tsubgroup,Tests as test where ptest.testGroups=tgroup.testGroupId and ptest.testSubgroups=tsubgroup.testSubgroupId and porder.orderId=ptest.patientTestOrders and ptest.tests=test.testId and cl.labId="+LabId+" and porder.orderId="+doctorLoginform.getOrderId()+"  order by ptest.testJobNumber asc ");
		 		
				return list;
		 		
		 	}
		 	public List DoctortestOrderView(DoctorLoginForm doctorLoginform,String val,String LabId){
		 		List list=new ArrayList();
		 		 list=hibernateTemplate.find("select tgroup.testGroupName,tsubgroup.testSubgroupName,test.testName,ptest.orderTestsId,ptest.testResult,ptest.testAnalysisRemarks,ptest.testRate,ptest.specimenCollected,ptest.testJobNumber,ptest.testBy,ptest.testResultApprovedBy,ptest.testStartDate,ptest.testStartTime,ptest.testReference from ClinicalLab as cl, PatientTests as ptest,TestGroups as tgroup,TestSubgroups as tsubgroup,Tests as test where ptest.testGroups=tgroup.testGroupId and ptest.testSubgroups=tsubgroup.testSubgroupId and ptest.tests=test.testId and ptest.orderTestsId='"+val+"'and cl.labId="+LabId+"");
		 		
				return list;
		 		
		 	}
		 	

		 	public List viewDoctorName(String doctorname){
		 		 List doctornam=new ArrayList();
		 		doctornam=hibernateTemplate.find("select doctor.doctorName,doctor.specialization from Doctor doctor where doctor.emailId ='"+doctorname+"'");
		     
		       
				return doctornam;
		 		
		 	}
public List doctorList(){
	List doctor=new ArrayList();
	List showDoctor=new ArrayList();
	doctor=hibernateTemplate.find("select doctor.doctorId,doctor.doctorName from Doctor doctor where doctor.endDate is null");
	
	PatientManagerForm adddoctor  = new PatientManagerForm();
	for (int i = 0; i < doctor.size(); i++)
	{
		Object[] doctorObject = (Object[]) doctor.get(i);
		adddoctor  = new PatientManagerForm();
		adddoctor.setReferringDoctorid(doctorObject[0].toString());
		//System.out.println("DAO IMPL DOCTOR ID ------------->>>>>>>>>>>>>>"+adddoctor.getReferringVendoid());
		adddoctor.setReferringDoctor(doctorObject[1].toString());
	
		showDoctor.add(adddoctor);
	
}
	return showDoctor;
	}
		

		 	public List vendorList(){
				List vendor=new ArrayList();
				List showVendor=new ArrayList();
				vendor=hibernateTemplate.find("select testVendor.testVendorId,testVendor.testVendorName from TestVendor testVendor where activeFlag='Y'");
				
				PatientManagerForm adddoctor  = new PatientManagerForm();
				for (int i = 0; i < vendor.size(); i++)
				{
				
					Object[] vendorObject = (Object[]) vendor.get(i);
					adddoctor  = new PatientManagerForm();
					adddoctor.setReferringVendoid(vendorObject[0].toString());
					//System.out.println("DAO IMPL VENDOR ID ------------->>>>>>>>>>>>>>"+adddoctor.getReferringVendoid());
					adddoctor.setReferringVendor(vendorObject[1]==null ? null :vendorObject[1].toString());
					
					showVendor.add(adddoctor);
				
			}
				return showVendor;
			}

		 	
		 	/* Patient get doctor name for  View*/
			public List doctorName(String drid) throws ParseException
			{
System.out.println("HIT DOCTOR ID DAOIMPL");
				List drList=hibernateTemplate.find("from Doctor where doctorId="+drid+""); 
				
				return drList;
			}
			
			/* Patient get Vendor name for  View*/
			public List vendorName(String vnrid) throws ParseException
			{
System.out.println("HIT Vendor ID DAOIMPL");
				List vnrList=hibernateTemplate.find("from TestVendor where testVendorId="+vnrid+""); 
				
				return vnrList;
			}

/* Grid View after Search in Test Order Manger*/
			public List viewtestorderDetails(TestOrderManagerForm testorderFormOject,TestOrderManagerSubForm testordermanaerSuFormObject,Integer labid,String username)throws ParseException 
			{
				System.out.println("HIT order DETAIL VIEW IMPL");	
				TestOrderManagerSubForm testordermangerSubObject =new TestOrderManagerSubForm();
				
				String searchtestdate=testorderFormOject.getSearchTestDate();
				String searchordernumber=testorderFormOject.getSearchTestOrderNo();
				String searchpatientname=testorderFormOject.getSearchTestOrderPatientname();				
				String searchpatientmobile=testorderFormOject.getSearchTestOrderMobile();
				String searchpatientemailid=testorderFormOject.getSearchEmailid();
				String searchdoctorname=testorderFormOject.getSearchTestDoctorName();
				String searchvendorname=testorderFormOject.getSearchTestvendorName();
				
				System.out.println("searchvendorname------"+searchvendorname);
				
				String testorderQueryList="select od.orderDate,od.orderId,od.orderReference,od.netAmount,od.balance,p.patientName,d.doctorName,v.testVendorName,od.patient from PatientTestOrders od,Patient p,Doctor d,TestVendor v where od.clinicalLab='"+labid+"' and od.patient=p.patientId and od.doctor=d.doctorId and od.testVendor=v.testVendorId";
				if(searchtestdate!=null && searchtestdate.length()!=0 )
				{
					testorderQueryList=testorderQueryList+" and od.orderDate like '"+searchtestdate+"%' ";
				}
				if(searchordernumber!=null && searchordernumber.length()!=0 )
				{
					testorderQueryList=testorderQueryList+" and od.orderId like '"+searchordernumber+"%' ";
				}
				if(searchpatientname!=null && searchpatientname.length()!=0 )
				{
					testorderQueryList=testorderQueryList+" and p.patientName like '"+searchpatientname+"%' ";
				}
				if(searchpatientmobile!=null && searchpatientmobile.length()!=0 )
				{
					testorderQueryList=testorderQueryList+" and p.phoneMobile like '"+searchpatientmobile+"%' ";
				}
				if(searchpatientemailid!=null && searchpatientemailid.length()!=0 )
				{
					testorderQueryList=testorderQueryList+" and p.emailId like '"+searchpatientemailid+"%' ";
				}
				if(!searchdoctorname.equals("0") && searchdoctorname.length()!=0 )
				{
					testorderQueryList=testorderQueryList+" and d.doctorName like '"+searchdoctorname+"%' ";
				}
				if(!searchvendorname.equals("0") && searchvendorname.length()!=0  )
				{
					testorderQueryList=testorderQueryList+" and v.testVendorName like '"+searchvendorname+"%' ";
				}
				List orderDetailQueryList=new ArrayList();
				orderDetailQueryList=hibernateTemplate.find(testorderQueryList);	
				
				return orderDetailQueryList;
			}
			
//Doctor List in Test Order details search
public List DoctorListdetails()
{
List doctorlistdetails=new ArrayList();
doctorlistdetails=hibernateTemplate.find("select doctorName from Doctor");
return doctorlistdetails;			
}		
//Vendor List in Test ORder details in search
public List VendorList()
{
	List vendorlistdetails=new ArrayList();
	vendorlistdetails=hibernateTemplate.find("select testVendorName from TestVendor");
	return vendorlistdetails;	
}
//create user for new vendor details
public String  createuservendor(User createuservendorform,Integer labid,String username)
{
	System.out.println("save in create user button in daoimpl"); 		 
    hibernateTemplate.save(createuservendorform);			  
	return "Save Success";
}
public String vendoruserd(String vendid)
{
	List vendorusername=hibernateTemplate.find("select emailId from TestVendor where testVendorId="+vendid+"");
	
	String vendoruser=vendorusername.get(0).toString();
	return vendoruser;
}

/*------------------------------------report Login controller-----------------------------------------------------------------------*/ 


public String patientUserid(String patId)
{
	List patientUsername=hibernateTemplate.find("select emailId from Patient where patientId="+patId+"");
	
	String patientUser=patientUsername.get(0).toString();
	return patientUser;
}


public List viewVendorLoginDetails(String refId,DoctorLoginForm doctorLoginform,String LabId) throws ParseException 
{
				
    String searchDate=doctorLoginform.getSearchDate();
    Integer searchID=doctorLoginform.getSearchID();
	String searchName=doctorLoginform.getSearchName();
	String searchMobile=doctorLoginform.getSearchMobile();
	String searchEmail=doctorLoginform.getSearchEmail();
    String searchVendorName=doctorLoginform.getSearchVendorname();	
	
	String qureyString="select porder.orderDate,porder.orderId,porder.orderReference,patientDetail.patientName,tv.testVendorName from PatientTestOrders as porder,Patient as patientDetail,TestVendor as tv,ClinicalLab as cl where porder.patient=patientDetail.patientId and porder.testVendor=tv.testVendorId and porder.testVendor="+refId+" and cl.labId="+LabId+"";




	List doctorview=new ArrayList();
	        if(searchDate!=null && searchDate.length()!=0 )
	        {
	        	qureyString=qureyString+" and  porder.orderDate like '"+searchDate+"%' ";
         	}
	
	        if(searchID!=null && searchID!=0)
	        {
	         	qureyString=qureyString+" and porder.orderId like '"+searchID+"%' ";
	        }
		
			if(searchName!=null && searchName.length()!=0 )
			{
				qureyString=qureyString+" and patientDetail.patientName like '"+searchName+"%' ";
			}
			if(searchMobile!=null && searchMobile.length()!=0)
			{
				qureyString=qureyString+" and patientDetail.phoneMobile like '"+searchMobile+"%' ";
			}
			
			if(searchEmail!=null && searchEmail.length()!=0)
			{
				qureyString=qureyString+" and patientDetail.emailId like '"+searchEmail+"%' ";
			}
			
			
			if(searchVendorName!=null && searchVendorName.length()!=0)
			{
				qureyString=qureyString+" and tv.testVendorName like '"+searchVendorName+"%' ";
			}

			
	List doctorviewlist=new ArrayList();
	doctorviewlist=hibernateTemplate.find(qureyString);
	
	return doctorviewlist;		
	}
			

/* Grid View after Search in Test Order Manger  in Patient Search */
public List viewpatienttestorderDetails(TestOrderManagerForm patienttestorderFormOject,TestOrderManagerSubForm patienttestorderSuFormObject,Integer labid,String username)throws ParseException 
{
	System.out.println("HIT Patient order DETAIL VIEW IMPL");	
	TestOrderManagerSubForm testordermangerSubObject =new TestOrderManagerSubForm();
	
	String searchtestpatientname=patienttestorderFormOject.getSearchPatientName();
	String searchpatientmobile=patienttestorderFormOject.getSearchMobile();
	String searchpatientemailid=patienttestorderFormOject.getSearchEmailid();
	String searchpostalcode=patienttestorderFormOject.getSearchPostalcode();
	String searchdoctorname=patienttestorderFormOject.getSearchDoctorname();
	
		
	String patienttestorderQueryList="select pd.patientId,pd.patientName,pd.sex,pd.age,pd.preferredContactMethod,pd.phoneMobile,pd.emailId,pd.postOfficeCode,dr.doctorName,vr.testVendorName from Patient as pd,Doctor as dr,TestVendor as vr where pd.clinicalLab='"+labid+"' and  pd.referingDoctorId=dr.doctorId and pd.referingTestVendorId=vr.testVendorId and pd.activeFlag='Y' and pd.deleteFlag='N' and pd.endDate is null";

	if(searchtestpatientname!=null && searchtestpatientname.length()!=0 )
	{
		patienttestorderQueryList=patienttestorderQueryList+" and pd.patientName like '"+searchtestpatientname+"%' ";
	}
	if(searchpatientmobile!=null && searchpatientmobile.length()!=0 )
	{
		patienttestorderQueryList=patienttestorderQueryList+" and pd.phoneMobile like '"+searchpatientmobile+"%' ";
	}
	if(searchpatientemailid!=null && searchpatientemailid.length()!=0 )
	{
		patienttestorderQueryList=patienttestorderQueryList+" and pd.emailId like '"+searchpatientemailid+"%' ";
	}
	if(searchpostalcode!=null && searchpostalcode.length()!=0 )
	{
		patienttestorderQueryList=patienttestorderQueryList+" and pd.postOfficeCode like '"+searchpostalcode+"%' ";
	}
	if(searchdoctorname!=null && searchdoctorname.length()!=0 )
	{
		patienttestorderQueryList=patienttestorderQueryList+" and dr.doctorName like '"+searchdoctorname+"%' ";
	}
	
	List patientorderDetailQueryList=new ArrayList();
	patientorderDetailQueryList=hibernateTemplate.find(patienttestorderQueryList);	
	
	return patientorderDetailQueryList;
}			




/* test order manager */			


public List testOrderManagerDoctorList(HttpSession httpSession)throws ParseException {
	List doctor=new ArrayList();
	
	doctor=hibernateTemplate.find("select doctor.doctorId,doctor.doctorName from Doctor doctor where doctor.endDate is null and doctor.clinicalLab='"+httpSession.getAttribute("labId")+"'");
	
	
	return doctor;
	}
		

		 	public List testOrderManagerVendorList(HttpSession httpSession)throws ParseException{
				List vendor=new ArrayList();
				
				vendor=hibernateTemplate.find("select testVendor.testVendorId,testVendor.testVendorName from TestVendor testVendor where activeFlag='Y' and testVendor.clinicalLab='"+httpSession.getAttribute("labId")+"'");
				
				
				return vendor;
			}

			public List testOrderManagerGroupList(HttpSession httpSession)throws ParseException{
				
				List group=new ArrayList();
				
				group=hibernateTemplate.find("select testgroup.testGroupId, testgroup.testGroupName from TestGroups testgroup where testgroup.clinicalLab='"+httpSession.getAttribute("labId")+"'");
				
				return group;
			}
			
public List TestVendorOrderDetails(String LabId,String val){
	List list=new ArrayList();
	 
	 try{
		 list=hibernateTemplate.find("select porder.orderId,porder.orderDate,doct.doctorName,tvendor.testVendorName,porder.orderReference,porder.grossAmount,porder.discount,porder.netAmount,porder.adavance,porder.balance,porder.totalAmountCollected,c.clientName,cl.labId,cl.client from ClinicalLab as cl,Client as c,PatientTestOrders as porder,PatientTests as ptest,Doctor as doct,TestVendor as tvendor where ptest.patientTestOrders=porder.orderId  and porder.clinicalLab=cl.labId and c.clientId=cl.client and  porder.doctor=doct.doctorId and porder.testVendor=tvendor.testVendorId and porder.orderId="+val+"  and cl.labId="+LabId+"");

	 } 
	 catch(Exception e){
		 e.printStackTrace();
	 }
	return list;
}
public List testOrderManagerSubGroupList(HttpSession httpSession, TestOrderManagerForm testOrderManagerForm)throws ParseException{
				
				List subgroup=new ArrayList();
				
				subgroup=hibernateTemplate.find("select testsubgroup.testSubgroupId, testsubgroup.testSubgroupName from TestSubgroups testsubgroup where testsubgroup.clinicalLab='"+httpSession.getAttribute("labId")+"' and testsubgroup.testGroups='"+testOrderManagerForm.getTestGroup()+"'");
				
				
				return subgroup;
			}

public List testOrderManagerTestList(HttpSession httpSession, TestOrderManagerForm testOrderManagerForm)throws ParseException{
	
	List test=new ArrayList();
	
	test=hibernateTemplate.find("select test.testId, test.testName from Tests test where test.clinicalLab='"+httpSession.getAttribute("labId")+"' and test.testSubgroups='"+testOrderManagerForm.getTestSubGroup()+"' and test.testGroups='"+testOrderManagerForm.getTestGroup()+"'");
	
	return test;
}

	public List TestVendorOrdergridView(DoctorLoginForm doctorLoginform,String LabId){
		List list=new ArrayList();
		list=hibernateTemplate.find("select tgroup.testGroupName,tsubgroup.testSubgroupName,test.testName,ptest.orderTestsId,ptest.testResult,ptest.testAnalysisRemarks,ptest.testRate,ptest.specimenCollected,ptest.testJobNumber,ptest.testBy,ptest.testResultApprovedBy from ClinicalLab as cl,PatientTestOrders as porder,PatientTests as ptest,TestGroups as tgroup,TestSubgroups as tsubgroup,Tests as test where ptest.testGroups=tgroup.testGroupId and ptest.testSubgroups=tsubgroup.testSubgroupId and porder.orderId=ptest.patientTestOrders and ptest.tests=test.testId and cl.labId="+LabId+" and porder.orderId="+doctorLoginform.getOrderId()+"  order by ptest.testJobNumber asc ");
		return list;
		
	}
	public List TestVendorOrderView(DoctorLoginForm doctorLoginform,String val,String LabId){
		List list=new ArrayList();
		 list=hibernateTemplate.find("select tgroup.testGroupName,tsubgroup.testSubgroupName,test.testName,ptest.orderTestsId,ptest.testResult,ptest.testAnalysisRemarks,ptest.testRate,ptest.specimenCollected,ptest.testJobNumber,ptest.testBy,ptest.testResultApprovedBy,ptest.testStartDate,ptest.testStartTime,ptest.testReference from ClinicalLab as cl, PatientTests as ptest,TestGroups as tgroup,TestSubgroups as tsubgroup,Tests as test where ptest.testGroups=tgroup.testGroupId and ptest.testSubgroups=tsubgroup.testSubgroupId and ptest.tests=test.testId and ptest.orderTestsId="+val+" and cl.labId="+LabId+"");
		
		return list;
		
	}
	public List viewVendorName(String testvendorname){
		 List testvendornam=new ArrayList();
		 testvendornam=hibernateTemplate.find("select tv.testVendorName,tv.testVendorRegnNumber from TestVendor tv where tv.emailId ='"+testvendorname+"'");
    
      
		return testvendornam;
		
	}

	
	public PatientTestOrders addOrderDetails(PatientTestOrders addOrder) throws ParseException	
	{
 		try{
		hibernateTemplate.save(addOrder);
//System.out.println("-------Hit patirn add Impl----");
 		}
 		catch(Exception e){
 			e.printStackTrace();
 		}
		System.out.println("-------Hit patirn add Impl----");

		return addOrder;
	}
	
	public String saveOrderDetails(PatientTestOrders addOrder) throws ParseException	
	{String output="ORDER SAVED SUCCESSFULLY";
 		try{
		hibernateTemplate.update(addOrder);
//System.out.println("-------Hit patirn add Impl----");
 		}
 		catch(Exception e){
 			e.printStackTrace();
 		}
		System.out.println("-------Hit patirn add Impl----");

		return output;
	}
	
	public PatientTests addOrderTestDetails(PatientTests addOrderTest) throws ParseException	
	{
 		try{
		hibernateTemplate.save(addOrderTest);
//System.out.println("-------Hit patirn add Impl----");
 		}
 		catch(Exception e){
 			e.printStackTrace();
 		}
		System.out.println("-------Hit patirn add Impl----");

		return addOrderTest;
	}
	
	public Integer testOrderManagerRate(HttpSession httpSession, TestOrderManagerForm testOrderManagerForm)throws ParseException{
		
		System.out.println(" HIT RATE DAO IMPL");
		List test=new ArrayList();
		
		test=hibernateTemplate.find("select test.rate from Tests test where test.clinicalLab="+httpSession.getAttribute("labId")+" and test.testId="+testOrderManagerForm.getTestId()+"");
		Object testrate;
		testrate=test.get(0);
		
		return (Integer) testrate;
	}

public List testOrderManagerSpecimen(HttpSession httpSession, TestOrderManagerForm testOrderManagerForm)throws ParseException{
		
		List test=new ArrayList();
		
		test=hibernateTemplate.find("select test.specimenType from Tests test where test.clinicalLab="+httpSession.getAttribute("labId")+" and test.testId="+testOrderManagerForm.getTestId()+"");
		
		
		return test;
	}

/*---------------------------------------------------------patient Login-------------------------------------------------------------*/	

	public List viewPatientLoginDetails(PatientLoginForm patientLoginform,String LabId,String refId) throws ParseException
 	{
 				
        String searchDate=patientLoginform.getSearchDate();
        Integer searchID=patientLoginform.getSearchID();
		String searchDoctorName=patientLoginform.getSearchDoctorName();
			
		

		String qureyString="select porder.orderDate,porder.orderId,porder.orderReference,doctorDetail.doctorName,porder.totalAmountCollected from PatientTestOrders as porder,Doctor as doctorDetail,ClinicalLab as cl where porder.doctor=doctorDetail.doctorId and porder.patient="+refId+" and cl.labId="+LabId+"";

		List doctorview=new ArrayList();
		        if(searchDate!=null && searchDate.length()!=0 )
		        {
		        	qureyString=qureyString+" and  porder.orderDate like '"+searchDate+"%' ";
	         	}
		
		        if(searchID!=null && searchID!=0)
		        {
		         	qureyString=qureyString+" and porder.orderId like '"+searchID+"%' ";
		        }
			
				if(searchDoctorName!=null && searchDoctorName.length()!=0 )
				{
					qureyString=qureyString+" and doctorDetail.doctorName like '"+searchDoctorName+"%' ";
				}

		List doctorviewlist=new ArrayList();
		doctorviewlist=hibernateTemplate.find(qureyString);
		
		return doctorviewlist;

 		
 	}

	public List PatientOrderDetails(String LabId,String val){
		List list=new ArrayList();
		 
		 try{
			 list=hibernateTemplate.find("select porder.orderId,porder.orderDate,doct.doctorName,tvendor.testVendorName,porder.orderReference,porder.grossAmount,porder.discount,porder.netAmount,porder.adavance,porder.balance,porder.totalAmountCollected,c.clientName,cl.labId,cl.client from ClinicalLab as cl,Client as c,PatientTestOrders as porder,PatientTests as ptest,Doctor as doct,TestVendor as tvendor where ptest.patientTestOrders=porder.orderId  and porder.clinicalLab=cl.labId and c.clientId=cl.client and  porder.doctor=doct.doctorId and porder.testVendor=tvendor.testVendorId and porder.orderId="+val+"  and cl.labId="+LabId+"");
		 } 
		 catch(Exception e){
			 e.printStackTrace();
		 }
		return list;
	}
	public List PatientOrdergridView(PatientLoginForm patientLoginForm,String LabId){
		List list=new ArrayList();
		list=hibernateTemplate.find("select tgroup.testGroupName,tsubgroup.testSubgroupName,test.testName,ptest.orderTestsId,ptest.testResult,ptest.testAnalysisRemarks,ptest.testRate,ptest.specimenCollected,ptest.testJobNumber,ptest.testBy,ptest.testResultApprovedBy from ClinicalLab as cl,PatientTestOrders as porder,PatientTests as ptest,TestGroups as tgroup,TestSubgroups as tsubgroup,Tests as test where ptest.testGroups=tgroup.testGroupId and ptest.testSubgroups=tsubgroup.testSubgroupId and porder.orderId=ptest.patientTestOrders and ptest.tests=test.testId and cl.labId="+LabId+" and porder.orderId="+patientLoginForm.getOrderId()+"  order by ptest.testJobNumber asc ");
		return list;
		
	}
	public List PatientOrderView(PatientLoginForm patientLoginForm,String val,String LabId){
		List list=new ArrayList();
		 list=hibernateTemplate.find("select tgroup.testGroupName,tsubgroup.testSubgroupName,test.testName,ptest.orderTestsId,ptest.testResult,ptest.testAnalysisRemarks,ptest.testRate,ptest.specimenCollected,ptest.testJobNumber,ptest.testBy,ptest.testResultApprovedBy,ptest.testStartDate,ptest.testStartTime,ptest.testReference from ClinicalLab as cl, PatientTests as ptest,TestGroups as tgroup,TestSubgroups as tsubgroup,Tests as test where ptest.testGroups=tgroup.testGroupId and ptest.testSubgroups=tsubgroup.testSubgroupId and ptest.tests=test.testId and ptest.orderTestsId='"+val+"'and cl.labId="+LabId+"");
		
		return list;
		
	}
	public List TestOrderManagergridView(HttpSession httpSession,TestOrderManagerForm testordermanagerform){
 		List list=new ArrayList();
 		list=hibernateTemplate.find("select tgroup.testGroupName,tsubgroup.testSubgroupName,test.testName,ptest.orderTestsId,ptest.testResult,ptest.testAnalysisRemarks,ptest.testRate,ptest.specimenCollected,ptest.testJobNumber,ptest.testBy,ptest.testResultApprovedBy from ClinicalLab as cl,PatientTestOrders as porder,PatientTests as ptest,TestGroups as tgroup,TestSubgroups as tsubgroup,Tests as test where ptest.testGroups=tgroup.testGroupId and ptest.testSubgroups=tsubgroup.testSubgroupId and porder.orderId=ptest.patientTestOrders and ptest.tests=test.testId and cl.labId="+httpSession.getAttribute("labId")+" and porder.orderId="+testordermanagerform.getOrderId()+"  order by ptest.testJobNumber asc ");
 		
		return list;
 		
 	}
	
	public List testOrderManagerView(TestOrderManagerForm testOrderManagerForm,String val,HttpSession httpSession){
 		List list=new ArrayList();
 		 list=hibernateTemplate.find("select tgroup.testGroupName,tsubgroup.testSubgroupName,test.testName,ptest.orderTestsId,ptest.testResult,ptest.testAnalysisRemarks,ptest.testRate,ptest.specimenCollected,ptest.testJobNumber,ptest.testBy,ptest.testResultApprovedBy,ptest.testStartTime,ptest.testReference from ClinicalLab as cl, PatientTests as ptest,TestGroups as tgroup,TestSubgroups as tsubgroup,Tests as test where ptest.testGroups=tgroup.testGroupId and ptest.testSubgroups=tsubgroup.testSubgroupId and ptest.tests=test.testId and ptest.orderTestsId='"+val+"'and cl.labId="+httpSession.getAttribute("labId")+"");
 		
		return list;
 		
 	}
 	
	public List testOrderDetails(String LabId,String val){

		List list=new ArrayList();
		 try
		 {
		 
			 list=hibernateTemplate.find("select porder.orderId,porder.orderDate,doct.doctorName,tvendor.testVendorName,porder.orderReference,porder.grossAmount,porder.discount,porder.netAmount,porder.adavance,porder.balance,porder.totalAmountCollected,c.clientName,cl.labId,cl.client,ptest.testGroups,ptest.testSubgroups,ptest.tests,porder.doctor,porder.testVendor,porder.publish from ClinicalLab as cl,Client as c,PatientTestOrders as porder,PatientTests as ptest,Doctor as doct,TestVendor as tvendor where ptest.patientTestOrders=porder.orderId and porder.clinicalLab=cl.labId and c.clientId=cl.client and porder.doctor=doct.doctorId and porder.testVendor=tvendor.testVendorId and porder.orderId="+val+" and cl.labId="+LabId+"");
		 } 
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return list;

	}
	public List testOrdergridView(String LabId,TestOrderManagerForm testViewForm){
 		List list=new ArrayList();
 		 list=hibernateTemplate.find("select tgroup.testGroupName,tsubgroup.testSubgroupName,test.testName,ptest.orderTestsId,ptest.testResult,ptest.testAnalysisRemarks,ptest.testRate,ptest.specimenCollected,ptest.testJobNumber,ptest.testBy,ptest.testResultApprovedBy from ClinicalLab as cl,PatientTestOrders as porder, PatientTests as ptest,TestGroups as tgroup,TestSubgroups as tsubgroup,Tests as test where ptest.testGroups=tgroup.testGroupId and ptest.testSubgroups=tsubgroup.testSubgroupId and porder.orderId=ptest.patientTestOrders and ptest.tests=test.testId and cl.labId="+LabId+" and porder.orderId="+testViewForm.getOrderId()+"  order by ptest.testJobNumber asc ");
 		System.out.println(" PRINT LIST SIZE IN DAO IMPL------->"+list.size());
		return list;
 		
 	}
	public List testOrderGridDetails(TestOrderManagerForm getGirdTestDetail,String val,String LabId,HttpSession httpSession)
	{
		List list=new ArrayList();
		 list=hibernateTemplate.find("select tgroup.testGroupName,tsubgroup.testSubgroupName,test.testName,ptest.orderTestsId,ptest.testResult,ptest.testAnalysisRemarks,ptest.testRate,ptest.specimenCollected,ptest.testJobNumber,ptest.testBy,ptest.testResultApprovedBy,ptest.testStartDate,ptest.testStartTime,ptest.testReference,ptest.testGroups,ptest.testSubgroups,ptest.tests,porder.doctor,porder.testVendor from ClinicalLab as cl, PatientTests as ptest, PatientTestOrders as porder, TestGroups as tgroup,TestSubgroups as tsubgroup,Tests as test where ptest.testGroups=tgroup.testGroupId and ptest.testSubgroups=tsubgroup.testSubgroupId and ptest.tests=test.testId and ptest.orderTestsId='"+getGirdTestDetail.getDispatchTestId()+"'and cl.labId="+httpSession.getAttribute("labId")+"");
		System.out.println("------------!!!!!!!!HHHHHHHHH------------@@@@"+list.size());
		return list;
	}
	public String updateOrderValue(PatientTestOrders updateOrder) throws ParseException	
	{String output="UPDATED SUCCESSFULLY";
 		try
 		{
 			hibernateTemplate.update(updateOrder);
 			
 		}
 		catch(Exception e)
 		{
 			e.printStackTrace();
 		}

		return output;
	}
	
	public String updateOrderValueTest(PatientTests testorderAddModel) throws ParseException	
	{String output="UPDATED SUCCESSFULLY";
 		try
 		{
 			
 			hibernateTemplate.update(testorderAddModel);
 		}
 		catch(Exception e)
 		{
 			e.printStackTrace();
 		}

		return output;
	}


	public String changepassword(String username,IndexForm indexformobj){
		String output = null;
		String record = null;
		try
 		{ 	
			Calendar cal = Calendar.getInstance();
		     Calendar cals = Calendar.getInstance();
		     cal.add(Calendar.DATE,180);
		     cals.add(Calendar.DATE,1);
		List list=new ArrayList();
		 System.out.println(indexformobj.getClinicallabUserName());
		list=hibernateTemplate.find("from User where userName='"+username+"'");
		User user=(User)list.get(0);
	      user.setPasswordAnswer1(indexformobj.getFirstquestion());
		   System.out.println("ooo"+indexformobj.getFirstquestion());
			user.setPasswordAnswer2(indexformobj.getSecondquestion());
			user.setPassword(indexformobj.getConfirmPassword());
			user.setNextPasswordChangeDate(cal.getTime());
			user.setFirstLogin("N");
		hibernateTemplate.saveOrUpdate(user);	
		 record="Your password was saved successfully. Login with new password";
 		}
 		catch(Exception e)
 		{
 			e.printStackTrace();
 		}
		indexformobj.setOutput(output);
		indexformobj.setSuccessmessage(record);
		return output;
		
	}
	public String changepasswordpatient(String patientname,IndexForm indexformobj){
		String record = null;
		String output = null;
		try
 		{ 	
			Calendar cal = Calendar.getInstance();
		     Calendar cals = Calendar.getInstance();
		     cal.add(Calendar.DATE,180);
		     cals.add(Calendar.DATE,1);
		List list=new ArrayList();
		 System.out.println(indexformobj.getClinicallabUserName());
		list=hibernateTemplate.find("from User where userName='"+patientname+"'");
		User user=(User)list.get(0);
	      user.setPasswordAnswer1(indexformobj.getFirstquestion());
		   System.out.println("ooo"+indexformobj.getFirstquestion());
			user.setPasswordAnswer2(indexformobj.getSecondquestion());
			user.setPassword(indexformobj.getConfirmPassword());
			user.setNextPasswordChangeDate(cal.getTime());
			user.setFirstLogin("N");
		hibernateTemplate.saveOrUpdate(user);	
		record="Your password was saved successfully. Login with new password";
 		}
 		catch(Exception e)
 		{
 			e.printStackTrace();
 		}
		indexformobj.setOutput(output);
		indexformobj.setSuccessmessage(record);
		return output;
	
	}
	public String changePasswordDoctor(String doctorname,IndexForm indexformobj){
		String record = null;
		String output = null;
		try
 		{ 	
			Calendar cal = Calendar.getInstance();
		     Calendar cals = Calendar.getInstance();
		     cal.add(Calendar.DATE,180);
		     cals.add(Calendar.DATE,1);
		List list=new ArrayList();
		 System.out.println(indexformobj.getClinicallabUserName());
		list=hibernateTemplate.find("from User where userName='"+doctorname+"'");
		User user=(User)list.get(0);
	      user.setPasswordAnswer1(indexformobj.getFirstquestion());
		   System.out.println("ooo"+indexformobj.getFirstquestion());
			user.setPasswordAnswer2(indexformobj.getSecondquestion());
			user.setPassword(indexformobj.getConfirmPassword());
			user.setNextPasswordChangeDate(cal.getTime());
			user.setFirstLogin("N");
		hibernateTemplate.saveOrUpdate(user);	
		record="Your password was saved successfully. Login with new password";
 		}
 		catch(Exception e)
 		{
 			e.printStackTrace();
 		}
		indexformobj.setOutput(output);
		indexformobj.setSuccessmessage(record);
		return output;
	}
	public String changePasswordVendor(String vendorname,IndexForm indexformobj){
		String record = null;
		String output = null;
		try
 		{ 	
			Calendar cal = Calendar.getInstance();
		    
		     cal.add(Calendar.DATE,180);
		     		List list=new ArrayList();
		 System.out.println(indexformobj.getClinicallabUserName());
		list=hibernateTemplate.find("from User where userName='"+vendorname+"'");
		User user=(User)list.get(0);
	      user.setPasswordAnswer1(indexformobj.getFirstquestion());
		   System.out.println("ooo"+indexformobj.getFirstquestion());
			user.setPasswordAnswer2(indexformobj.getSecondquestion());
			user.setPassword(indexformobj.getConfirmPassword());
			user.setNextPasswordChangeDate(cal.getTime());
		
			user.setFirstLogin("N");
		hibernateTemplate.saveOrUpdate(user);	
		record="Your password was saved successfully. Login with new password";
 		}
 		catch(Exception e)
 		{
 			e.printStackTrace();
 		}
		indexformobj.setOutput(output);
		indexformobj.setSuccessmessage(record);
		return output;
	}
	public ChangePassword forgotPassword(ChangePassword changepassword){	
		String result = null;
		try
 		{ 			
		 
	List list=new ArrayList();
	list=hibernateTemplate.find("from User where userName='"+changepassword.getUsername()+"' and userType='"+changepassword.getUserType()+"' ");
	
	User user=(User)list.get(0);
	if(user.getUserName().equals(changepassword.getUsername())&& user.getUserType().equals(changepassword.getUserType())){
		System.out.print("sdfafsadfasf");
		result="matched";
	}
 		}
		catch(IndexOutOfBoundsException e){
			e.printStackTrace();
			System.out.println("if condition not working");
			result="not match";
				}

		changepassword.setResult(result);
		
		return changepassword;
		
	}
	public ChangePassword forgotPasswordvq(ChangePassword changepassword){
		ChangePassword changepasswords=new ChangePassword();
		String resultvalue=null;
		try
 		{ 				
		List list=new ArrayList();	
		list=hibernateTemplate.find("from User where userName='"+changepassword.getUsername()+"'and userType='"+changepassword.getUserType()+"' ");
		User usera=(User)list.get(0);	
		if(usera.getPasswordAnswer1().equals(changepassword.getFirstquestion())&& usera.getPasswordAnswer2().equals(changepassword.getSecondquestion())){		
		  resultvalue="print";
		}		
			
		if(!usera.getPasswordAnswer1().equals(changepassword.getFirstquestion())|| !usera.getPasswordAnswer2().equals(changepassword.getSecondquestion())){
  
			resultvalue="not print";		
		}
		
		
	}
		catch(Exception e)
 		{
 			e.printStackTrace();
 		}
			
				
	
		changepassword.setqResult(resultvalue);
		return changepassword;
		
	}
public ChangePassword forgotPasswordSave(ChangePassword changepassword){
		
		String output = null;
		String resultvalue=null;
	
		try
 		{ 	
			
		 Calendar cal = Calendar.getInstance();		 
 	    cal.add(Calendar.DATE,180);		
		List list=new ArrayList();	
		list=hibernateTemplate.find("from User where userName='"+changepassword.getUsername()+"'and userType='"+changepassword.getUserType()+"' ");
		User usera=(User)list.get(0);
		usera.setPassword(changepassword.getConfirmPassword());
		usera.setNextPasswordChangeDate(cal.getTime());		
		hibernateTemplate.saveOrUpdate(usera);		
	    resultvalue="print";
	}
		catch(Exception e)
 		{
 			e.printStackTrace();
 		}
			
				
	
		changepassword.setqResult(resultvalue);
		return changepassword;
		
	}
	public List getUserType(){
 		List userType=new ArrayList();
 		userType.add("LAB");
 		userType.add("PATIENT");
 		userType.add("DOCTOR");
 		userType.add("TESTVENDOR");
 		
 		return userType;
 	}
	 public List LoginForm(String username){
		 
		  List list=new ArrayList();
		 	list=hibernateTemplate.find("from User where userName='"+username+"'");
		 	
		return list;
		 
	 }
	 public ChangePassword verifyQuestion(ChangePassword changepassword, String username, String usertype){
			ChangePassword changepasswords=new ChangePassword();
			String resultvalue=null;
			try
	 		{ 				
			List list=new ArrayList();	
			list=hibernateTemplate.find("from User where userName='"+username+"'and userType='"+usertype+"' ");
			User usera=(User)list.get(0);	
			if(usera.getPasswordAnswer1().equals(changepassword.getFirstquestion())&& usera.getPasswordAnswer2().equals(changepassword.getSecondquestion())){		
			  resultvalue="print";
			}		
				
			if(!usera.getPasswordAnswer1().equals(changepassword.getFirstquestion())|| !usera.getPasswordAnswer2().equals(changepassword.getSecondquestion())){
	  
				resultvalue="not print";		
			}
			
			
		}
			catch(Exception e)
	 		{
	 			e.printStackTrace();
	 		}
				
					
		
			changepassword.setqResult(resultvalue);
			return changepassword;
			
		}
	public ChangePassword changingpassword(ChangePassword changepassword, String username, String usertype){
			
			String output = null;
			String resultvalue=null;
		
			try
	 		{ 	
				
			 Calendar cal = Calendar.getInstance();		 
	 	    cal.add(Calendar.DATE,180);		
			List list=new ArrayList();	
			list=hibernateTemplate.find("from User where userName='"+username+"'and userType='"+usertype+"' ");
			User usera=(User)list.get(0);
			usera.setPassword(changepassword.getConfirmPassword());
			usera.setNextPasswordChangeDate(cal.getTime());		
			hibernateTemplate.saveOrUpdate(usera);		
		    resultvalue="print";
		}
			catch(Exception e)
	 		{
	 			e.printStackTrace();
	 		}
				
					
		
			changepassword.setqResult(resultvalue);
			return changepassword;
			
		}

	
	
	
	
	/*------------Sign Up-----------------------*/
	public String registersave(ClinicalLab labmodel) throws ParseException
	
	{
		String output="Saved Successfully";
		try
 		{
 			
 			hibernateTemplate.save(labmodel);
 		}
 		catch(Exception e)
 		{
 			e.printStackTrace();
 		}

		return output;
		
	}
	
public String registersaveuser(User labmodel) throws ParseException
	
	{
		String output="Saved Successfully";
		try
 		{
 			
 			hibernateTemplate.save(labmodel);
 		}
 		catch(Exception e)
 		{
 			e.printStackTrace();
 		}

		return output;
		
	}

public List getLabIdSignUp(ClinicalLabInfoForm form){
	
	List list=new ArrayList();
	list=hibernateTemplate.find("select cl.labId from ClinicalLab as cl where cl.emailId='"+form.getEmailId().toLowerCase()+"'");
	
	return list;

}

public List sendmailifsuccess(ClinicalLabInfoForm form){
	
	List list=new ArrayList();
	list=hibernateTemplate.find("select cl.emailId from ClinicalLab as cl where cl.emailId='"+form.getEmailId().toLowerCase()+"'");
	return list;
}

}
