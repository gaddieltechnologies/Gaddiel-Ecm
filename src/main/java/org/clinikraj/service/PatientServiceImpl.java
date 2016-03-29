package org.clinikraj.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.clinikraj.dao.ClinicDao;
import org.clinikraj.form.DoctorLoginForm;
import org.clinikraj.form.DoctorLoginSubForm;
import org.clinikraj.form.IndexForm;
import org.clinikraj.form.PatientLoginForm;
import org.clinikraj.form.PatientLoginSubForm;
import org.clinikraj.form.PatientManagerForm;
import org.clinikraj.form.PatientManagerSubForm;
import org.clinikraj.form.TestVendorManagerForm;
import org.clinikraj.model.Doctor;
import org.clinikraj.model.Patient;
import org.clinikraj.model.Pintable;
import org.clinikraj.model.TestVendor;
import org.clinikraj.model.User;
import org.clinikraj.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	public ClinicDao clinicDao;

	@Transactional
	public List viewPatienDetails(PatientManagerForm patientFormObject,PatientManagerSubForm patientSubObject,Integer labid,String username) throws ParseException {
		
		List patientDetailList=new ArrayList();
		PatientManagerSubForm patientSubFormObject=new PatientManagerSubForm();
		List patientDetailQueryList= clinicDao.viewPatienDetails(patientFormObject, patientSubObject, labid, username);
		
System.out.println("list of values  size ----> "+patientDetailQueryList.size());
		for (int i = 0; i < patientDetailQueryList.size(); i++)
		{
			Object[] patient = (Object[]) patientDetailQueryList.get(i);
			
			patientSubFormObject=new PatientManagerSubForm();
			
			patientSubFormObject.setPatientIdRegNo(patient[0]==null ? null :Integer.parseInt(patient[0].toString()));
			patientSubFormObject.setPatientName(patient[1]==null ? null :patient[1].toString());
			patientSubFormObject.setSex(patient[2]==null ? null :patient[2].toString());
			patientSubFormObject.setAge(patient[3]==null ? null :Integer.parseInt(patient[3].toString()));
			patientSubFormObject.setPrefferedContact(patient[4]==null ? null :patient[4].toString());
			patientSubFormObject.setPhoneContactNo(patient[5]==null ? null :patient[5].toString());
			patientSubFormObject.setEmailId(patient[6]==null ? null :patient[6].toString());
			
			patientSubFormObject.setPostofficecode(patient[7]==null ? null :Integer.parseInt(patient[7].toString()));
			
			patientSubFormObject.setReferringDoctorid(patient[8]==null ? null :(patient[8].toString()));
			
			patientSubFormObject.setReferringVendoid(patient[9]==null ? null :(patient[9].toString()));
			
							
			patientDetailList.add(patientSubFormObject);
		}
		return patientDetailList;
		
	}


	public PatientManagerForm addPatienDetails(PatientManagerForm addPatient,Integer labid,String username)throws ParseException {
		Patient patientAddModel=new Patient();
		String output=null;
		try{
			/*not null*/	patientAddModel.setCreatedBy(username);
			/*not null*/	patientAddModel.setCreatedDate(new Date());
			/*not null*/	patientAddModel.setLastUpdatedBy(username);
			/*not null*/	patientAddModel.setLastUpdatedDate(new Date());
			/*not null*/	patientAddModel.setPatientId(null);
			/*not null*/	patientAddModel.setClinicalLab(labid);		
			/*not null*/	patientAddModel.setStartDate(new Date());
			/*not null*/	patientAddModel.setPatientName(addPatient.getPatientName());
			/*not null*/	patientAddModel.setSex(addPatient.getSex());
		patientAddModel.setDateOfBirth(Converter.StringtoDateforDB(addPatient.getDateOfBirth().toString()));
		patientAddModel.setAge(addPatient.getAge());
		patientAddModel.setEmailId(addPatient.getEmailId());
		patientAddModel.setAlternateEmailId(addPatient.getAlternateEmailId());
		patientAddModel.setPhoneMobile(addPatient.getPhoneMobile());
		patientAddModel.setPhoneLandline(addPatient.getPhoneLandline());
		patientAddModel.setEmergencyPhoneNumber(addPatient.getEmergencyPhoneNumber());
		patientAddModel.setPhoneFax(addPatient.getPhoneFax());
		patientAddModel.setAddressLine1(addPatient.getAddressLine1());
		patientAddModel.setAddressLine2(addPatient.getAddressLine2());
		patientAddModel.setArea(addPatient.getArea());
		patientAddModel.setPostOfficeCode(addPatient.getPostofficecode());
		patientAddModel.setDistrict(addPatient.getDistrict());
		patientAddModel.setCity(addPatient.getCity());
		patientAddModel.setState(addPatient.getState());
		patientAddModel.setCountry(addPatient.getCountry());
System.out.println("************************>>>>>>>>>>> "+addPatient.getPreferredContactMethod());
		patientAddModel.setPreferredContactMethod(addPatient.getPreferredContactMethod());
		patientAddModel.setSmsAlerts(addPatient.getSmsAlert());
System.out.println("DOCTOR ID ------------->>>>>>>>>>>>>>"+addPatient.getReferringDoctor());
		patientAddModel.setReferingDoctorId(Integer.parseInt(addPatient.getReferringDoctor()));
System.out.println("VENDOR ID ------------->>>>>>>>>>>>>>"+addPatient.getReferringVendor());
		patientAddModel.setReferingTestVendorId(Integer.parseInt(addPatient.getReferringVendor()));
		patientAddModel.setActiveFlag("Y");
		patientAddModel.setDeleteFlag("N");
		 output=clinicDao.addPatienDetails(patientAddModel);
		 addPatient.setPatientId(patientAddModel.getPatientId());
		 addPatient.setEmailId(patientAddModel.getEmailId());
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return addPatient;
	
	}

	public List postofficePatienvalues(String var) throws ParseException {
		PatientManagerForm patientobject =new PatientManagerForm();
		List postvalue=clinicDao.postofficePatienvalues(var);
		
		Pintable patient = (Pintable) postvalue.get(0);
		List postdetaillist=new ArrayList();
		patientobject=new PatientManagerForm();		
			
		patientobject.setCity(patient.getCity());
		patientobject.setDistrict(patient.getDistrict());
		patientobject.setState(patient.getState());
		patientobject.setCountry(patient.getCountry());
		postdetaillist.add(patientobject);				
		return postdetaillist;
	}

	public PatientManagerForm viewPatient(String val) throws ParseException
	{
		PatientManagerForm viewObject= new PatientManagerForm();
		List patientDetailQueryList= clinicDao.viewPatient(val);
		Patient patientViewModel= (Patient) patientDetailQueryList.get(0) ;
		
		String drid;
		drid=patientViewModel.getReferingDoctorId().toString();
System.out.println("Doctor Id ------>>>>>>>>>"+drid);
		List drnameList= clinicDao.doctorName(drid);
		Doctor drmodel=(Doctor) drnameList.get(0);
		viewObject.setReferringDoctor(drmodel.getDoctorName());
		
		String vnrid;
		vnrid=patientViewModel.getReferingTestVendorId().toString();
System.out.println("Vendor Id ------>>>>>>>>>"+drid);
		List vnrnameList= clinicDao.vendorName(vnrid);
		TestVendor vnrmodel=(TestVendor) vnrnameList.get(0);
		viewObject.setReferringVendor(vnrmodel.getTestVendorName());
		
		viewObject.setPatientName(patientViewModel.getPatientName());
		viewObject.setSex(patientViewModel.getSex());
		viewObject.setDateOfBirth(patientViewModel.getDateOfBirth()== null ? "" :Converter.FormatDate(patientViewModel.getDateOfBirth().toString()));
		viewObject.setAge(patientViewModel.getAge());
		viewObject.setEmailId(patientViewModel.getEmailId());
		viewObject.setAlternateEmailId(patientViewModel.getAlternateEmailId());
		viewObject.setPhoneMobile(patientViewModel.getPhoneMobile());
		viewObject.setPhoneLandline(patientViewModel.getPhoneLandline());
		viewObject.setEmergencyPhoneNumber(patientViewModel.getEmergencyPhoneNumber());
		viewObject.setPhoneFax(patientViewModel.getPhoneFax());
		viewObject.setAddressLine1(patientViewModel.getAddressLine1());
		viewObject.setAddressLine2(patientViewModel.getAddressLine2());
		viewObject.setArea(patientViewModel.getArea());
		viewObject.setPostofficecode(patientViewModel.getPostOfficeCode());
		viewObject.setCity(patientViewModel.getCity());
		viewObject.setDistrict(patientViewModel.getDistrict());
		viewObject.setState(patientViewModel.getState());
		viewObject.setCountry(patientViewModel.getCountry());
		viewObject.setPreferredContactMethod(patientViewModel.getPreferredContactMethod());
		viewObject.setSmsAlerts(patientViewModel.getSmsAlerts());
		
		return viewObject;
	}
	/* Delete*/
	public 	String  deletePatient(String val) throws ParseException 
	{
		
		PatientManagerForm patientDelete=new PatientManagerForm();
	    List patientDeletelist=clinicDao.viewPatient(val);
System.out.println("Delete pateint Impl");
	    Patient patientDeleteModel= (Patient)patientDeletelist.get(0);
	    patientDeleteModel.setActiveFlag("N");
	    patientDeleteModel.setDeleteFlag("Y");	
		return clinicDao.deletePatient(patientDeleteModel);
	}
	public List Prefferedcontact() {
		// TODO Auto-generated method stub
		return clinicDao.Prefferedcontact();
	}
	public List getSmsList()
	   {
		return clinicDao.getSmsList();
	   }
	public List sexList()
	{
		return clinicDao.sexList();
	}
	public List doctorList()
	{
		return clinicDao.doctorList();
	}
    public List vendorList()
    {
    	return clinicDao.vendorList();  
    }

  //create patient as new user in User table

    public String patientUser(String patId)
    {
    	return clinicDao.patientUserid(patId);
    }
    
    public String createPatienAsUser(PatientManagerForm createPatienUserObj,Integer labid,String username)
    {
    	User usermodel= new User();
    	System.out.println("daoimpl-------emaild"+createPatienUserObj.getEmailId());
    	usermodel.setUserName(createPatienUserObj.getEmailId());
    	usermodel.setReferenceId(createPatienUserObj.getPatientId());
    	usermodel.setCreatedBy(username);
    	usermodel.setLastUpdatedBy(username);
    	usermodel.setRole("OTHERS");
    	usermodel.setUserType("PATIENT");
    	usermodel.setPassword("123");
    	usermodel.setDefaultPasswordChanged("N");
    	usermodel.setDeleteFlag("N");
    	usermodel.setActiveFlag("Y");
    	usermodel.setStartDate(new Date());
    	usermodel.setLastSuccessLoginDate(new Date());
    	usermodel.setLastFailedLoginDate(new Date());
    	usermodel.setLastUpdatedDate(new Date());
    	usermodel.setClinicalLab(labid);
    	usermodel.setCreatedDate(new Date());
    	usermodel.setLastUpdatedDate(new Date());
    	usermodel.setPasswordQuestion1("123");
    	usermodel.setPasswordAnswer1("123");
    	usermodel.setPasswordQuestion2("123");
    	usermodel.setPasswordAnswer2("123");
    	usermodel.setPasswordQuestion3("123");
    	usermodel.setPasswordAnswer3("123");
    	
    	String output=clinicDao.createuservendor(usermodel,labid,username);
    	return output;
    }
	
    @Transactional
	public List viewPatientLoginDetails(PatientLoginForm patientLoginform,String LabId,String refId)throws ParseException {
    	
    	List PatientDetailList=new ArrayList();
    	PatientLoginSubForm PatientSubFormObject=new PatientLoginSubForm();
    	List PatientDetailQueryList= clinicDao.viewPatientLoginDetails(patientLoginform, LabId,refId);
    	
    	for (int i = 0; i < PatientDetailQueryList.size(); i++)
    	{
    		Object[] view = (Object[]) PatientDetailQueryList.get(i);
    		
    		PatientSubFormObject=new PatientLoginSubForm();
    		
    		PatientSubFormObject.setDate(view[0]==null ? null :(view[0].toString()));
    		PatientSubFormObject.setOrderId(view[1]==null ? null :Integer.parseInt(view[1].toString()));
    		PatientSubFormObject.setOrderReference(view[2]==null ? null :view[2].toString());
    		PatientSubFormObject.setDoctorName(view[3]==null ? null :view[3].toString());
    		PatientSubFormObject.setTotalCollected(view[4]==null ? null :Integer.parseInt(view[4].toString()));
    		
    		
    						
    		PatientDetailList.add(PatientSubFormObject);
    	}
		return PatientDetailList;
	
    }
    @Transactional
   	public PatientLoginForm PatienttestOrderDetails(String LabId,PatientLoginForm patientLoginform,String val){
  
   	 List list=clinicDao.PatientOrderDetails(LabId, val);
   	 Object[] object=(Object[])list.get(0);
   	patientLoginform.setOrderId(object[0]==null ? null:Integer.parseInt(object[0].toString()));
   	patientLoginform.setOrderDate(object[1]==null ? null:(object[1].toString()));
   	patientLoginform.setDoctorName(object[2]==null ? null:(object[2].toString()));
   	patientLoginform.setVendorName(object[3]==null ? null:(object[3].toString()));
   	patientLoginform.setOrderReference(object[4]==null ? null:(object[4].toString()));
   	patientLoginform.setOrderValue(object[5]==null ? null:(object[5].toString()));
   	patientLoginform.setDiscount(object[6]==null ? null:Integer.parseInt(object[6].toString()));
   	patientLoginform.setNetValue(object[7]==null ? null:Integer.parseInt(object[7].toString()));
   	patientLoginform.setAdvance(object[8]==null ? null:Integer.parseInt(object[8].toString()));
   	patientLoginform.setBalance(object[9]==null ? null:Integer.parseInt(object[9].toString()));
   	patientLoginform.setTotalCollected(object[10]==null ? null:Integer.parseInt(object[10].toString()));
  
   	patientLoginform.setClientName(object[11]==null ? null:(object[11].toString()));
   	patientLoginform.setLabId(object[12]==null ? null:Integer.parseInt(object[12].toString()));

   	patientLoginform.setClient(object[13]==null ? null:Integer.parseInt(object[13].toString()));
   	 
   		return patientLoginform;
   		
   	}
       //Test Default 1st Test as Visible
       @Transactional
         public List PatienttestOrdergridView(String LabId,PatientLoginForm patientLoginform){
       	List patientDetailList=new ArrayList();
   		PatientLoginSubForm patientSubFormObject=new PatientLoginSubForm();
   		List doctorDetailQueryList= clinicDao.PatientOrdergridView(patientLoginform, LabId);
   
   		for (int i = 0; i < doctorDetailQueryList.size(); i++)
   		{
   			Object[] view = (Object[]) doctorDetailQueryList.get(i);
   			
   			patientSubFormObject=new PatientLoginSubForm();
   			
   			patientSubFormObject.setTestGroup(view[0]==null ? null :(view[0].toString()));
   			patientSubFormObject.setTestSubgroup(view[1]==null ? null :(view[1].toString()));
   			patientSubFormObject.setTests(view[2]==null ? null :view[2].toString());
   			patientSubFormObject.setOrder(view[3]==null ? null :Integer.parseInt(view[3].toString()));
   			patientSubFormObject.setTestResult(view[4]==null ? null :view[4].toString());
   			patientSubFormObject.setAnalystRemarks(view[5]==null ? null :view[5].toString());
   			patientSubFormObject.setRate(view[6]==null ? null :Integer.parseInt(view[6].toString()));
   			patientSubFormObject.setSpecimenDetails(view[7]==null ? null :view[7].toString());
   			patientSubFormObject.setTestjob(view[8]==null ? null :view[8].toString());
   			patientSubFormObject.setTestedBy(view[9]==null ? null :view[9].toString());
   			patientSubFormObject.setTestApproved(view[10]==null ? null :view[10].toString());
   			
   							
   			patientDetailList.add(patientSubFormObject);
   		}
   		 
   		return patientDetailList;
   		
   	     
   	
   }
       //Test
       @Transactional
       public PatientLoginForm patienttestOrderViews(PatientLoginForm patientLoginforms,String val,String LabId){
   	List doctorDetailQueryList= clinicDao.PatientOrderView(patientLoginforms, val, LabId);
   		
   		for (int i = 0; i < doctorDetailQueryList.size(); i++)
   		{
   			Object[] view = (Object[]) doctorDetailQueryList.get(i);
   		
   			patientLoginforms.setTestGroup(view[0]==null ? null :(view[0].toString()));
   			patientLoginforms.setTestSubgroup(view[1]==null ? null :(view[1].toString()));
   			patientLoginforms.setTests(view[2]==null ? null :view[2].toString());
   			patientLoginforms.setOrder(view[3]==null ? null :Integer.parseInt(view[3].toString()));
   			patientLoginforms.setTestResult(view[4]==null ? null :view[4].toString());
   			patientLoginforms.setAnalystRemarks(view[5]==null ? null :view[5].toString());
   			patientLoginforms.setRate(view[6]==null ? null :view[6].toString());
   			patientLoginforms.setSpecimenDetails(view[7]==null ? null :view[7].toString());
   			patientLoginforms.setTestjob(view[8]==null ? null :view[8].toString());
   			patientLoginforms.setTestedBy(view[9]==null ? null :view[9].toString());
   			patientLoginforms.setTestApprovedby(view[10]==null ? null :view[10].toString());
   			patientLoginforms.setTestStartdate(view[11]==null ? null:(view[11].toString()));
   			patientLoginforms.setTestStarttime(view[12]==null ? null:(view[12].toString()));
   			patientLoginforms.setTestReference(view[13]==null ? null:(view[13].toString()));
   		
   		}
   		 
   		return patientLoginforms;
   		
   	     
   	
   }

       public String LoginFormPatient(String username)
  	 {   PatientLoginForm Patientloginform=new PatientLoginForm();
	     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         String output=null;
         Date checkDate=null;
		String chekdate=dateFormat.format((new Date()));
		Date currentdate=new Date();
		 List list=clinicDao.LoginForm(username);
		 User usera=(User)list.get(0);
		System.out.println(usera.getNextPasswordChangeDate()+"nextpasswordchangeday");
    	System.out.println(chekdate+"currentday");
    	System.out.println(currentdate+"currentdate");
  		 System.out.println("hitserviceimpl");
		if((usera.getNextPasswordChangeDate()!=null)){			
			long diff=Math.abs((usera.getNextPasswordChangeDate().getTime())-(new Date().getTime()));
			long diffDays = diff / (24 * 60 * 60 * 1000);
			System.out.println(diffDays+"subract time");
			if(diffDays<14){
			
				output="Your Password will expire in "+diffDays+"day(s)..Please reset the password";
			
			}
	
		}
  		 return output;
  	 }

       
       public IndexForm logoutendsession(HttpSession httpSession, IndexForm indexForm){
  		 
  		 httpSession.setAttribute("username", null);
  		 return indexForm;
  	 }

    }
