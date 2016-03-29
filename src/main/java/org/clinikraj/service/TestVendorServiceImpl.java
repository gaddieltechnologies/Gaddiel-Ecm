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
import org.clinikraj.form.TestVendorManagerForm;
import org.clinikraj.form.TestVendorManagerSubForm;
import org.clinikraj.model.Pintable;
import org.clinikraj.model.TestVendor;
import org.clinikraj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
@Service
public class TestVendorServiceImpl implements TestVendorSerivce {
	@Autowired
	public ClinicDao clinicDao;

	@Transactional
	public TestVendorManagerForm save(TestVendorManagerForm testvendormanagerform,Integer labid,String username)
	{
		
		 TestVendor testvendormodel = new TestVendor();
		 
		  testvendormodel.setTestVendorId(null);
		  testvendormodel.setCreatedBy(username);
		  testvendormodel.setCreatedDate(new Date());
		  testvendormodel.setLastUpdatedBy(username);
		  testvendormodel.setLastUpdatedDate(new Date());
		  testvendormodel.setClinicalLab(labid);
		  testvendormodel.setStartDate(new Date());
		  
		  testvendormodel.setTestVendorName(testvendormanagerform.getTestVendorName());
		  testvendormodel.setTestVendorRegnNumber(testvendormanagerform.getTestVendorRegnNumber());
		  testvendormodel.setVendorContactName(testvendormanagerform.getVendorContactName());
		  testvendormodel.setTieUp(testvendormanagerform.getTieUp());
		  testvendormodel.setEmailId(testvendormanagerform.getEmailId());
		  testvendormodel.setAlternateEmailId(testvendormanagerform.getAlternateEmailId());
		  testvendormodel.setPhoneMobile(testvendormanagerform.getPhoneMobile());
		  testvendormodel.setPhoneLandline(testvendormanagerform.getPhoneLandline());
		  testvendormodel.setEmergencyPhoneNumber(testvendormanagerform.getEmergencyPhoneNumber());
		  testvendormodel.setPhoneFax(testvendormanagerform.getPhoneFax());
		  testvendormodel.setAddressLine1(testvendormanagerform.getAddressLine1());
		  testvendormodel.setAddressLine2(testvendormanagerform.getAddressLine2());
		  testvendormodel.setArea(testvendormanagerform.getArea());
		  
		  testvendormodel.setPostOfficeCode(testvendormanagerform.getPostOfficeCode());
		  testvendormodel.setCity(testvendormanagerform.getCity());
		  testvendormodel.setDistrict(testvendormanagerform.getDistrict());
		  testvendormodel.setState(testvendormanagerform.getState());
		  testvendormodel.setCountry(testvendormanagerform.getCountry());
		  testvendormodel.setPreferredContactMethod(testvendormanagerform.getPreferredContactMethod());
		  testvendormodel.setSmsAlerts(testvendormanagerform.getSmsAlerts());
		  testvendormodel.setRemarks(testvendormanagerform.getRemarks());
		  testvendormodel.setEndDate(null);
		  testvendormodel.setActiveFlag("Y");
		  testvendormodel.setDeleteFlag("N");
		  String output=clinicDao.save(testvendormodel,labid,username);
		  testvendormanagerform.setTestVendorId(testvendormodel.getTestVendorId());
		  testvendormanagerform.setEmailId(testvendormodel.getEmailId());
		  return testvendormanagerform;
	 }
	
	public List viewvendorDetails(TestVendorManagerForm vendorFormObject,TestVendorManagerSubForm vendormangerSubFormObject,Integer labid,String username) throws ParseException	
	{
		List vendorDetailList=new ArrayList();
		List vendorDetailQueryList=clinicDao.viewvendorDetails(vendorFormObject, vendormangerSubFormObject,labid,username);
		System.out.println("list of values  size ----> "+vendorDetailQueryList.size());			
		for (int i = 0; i < vendorDetailQueryList.size(); i++)
		{
			Object[] testvendor = (Object[]) vendorDetailQueryList.get(i);					
			vendormangerSubFormObject=new TestVendorManagerSubForm();					
					vendormangerSubFormObject.setTestVendorId(testvendor[0]==null ? null :Integer.parseInt(testvendor[0].toString()));
					vendormangerSubFormObject.setTestVendorName(testvendor[1]==null ? null :testvendor[1].toString());
					vendormangerSubFormObject.setPhoneMobile(testvendor[2]==null ? null :Long.parseLong(testvendor[2].toString()));
					vendormangerSubFormObject.setVendorContactName(testvendor[3]==null ? null :testvendor[3].toString());
					vendormangerSubFormObject.setPreferredContactMethod(testvendor[4]==null ? null :testvendor[4].toString());
					vendormangerSubFormObject.setEmailId(testvendor[5]==null ? null :testvendor[5].toString());
					vendormangerSubFormObject.setPostOfficeCode(testvendor[6]==null ? null :Integer.parseInt(testvendor[6].toString()));					
								
					vendorDetailList.add(vendormangerSubFormObject);
				}
			return vendorDetailList;
	}
	public List postofficevalues(String var) throws ParseException{	
		TestVendorManagerForm vendorobject =new TestVendorManagerForm();
		List postvalue=clinicDao.postofficevalues(var);
	    Pintable patient = (Pintable) postvalue.get(0);
		List postdetaillist=new ArrayList();
		vendorobject=new TestVendorManagerForm();		
		
		vendorobject.setCity(patient.getCity());
		vendorobject.setDistrict(patient.getDistrict());
		vendorobject.setState(patient.getState());
		vendorobject.setCountry(patient.getCountry());
		
		postdetaillist.add(vendorobject);	
		return postdetaillist;
}

	public List Prefferedcontact() {
		// TODO Auto-generated method stub
		return clinicDao.Prefferedcontact();
	}
	
public 	TestVendorManagerForm viewVendor(String val,Integer labid,String username) throws ParseException
  {
	TestVendorManagerForm vendorviewObject=new TestVendorManagerForm();
	List vendorviewQueryList=clinicDao.viewVendor(val,labid,username);
	TestVendor vendorviewModel=(TestVendor)vendorviewQueryList.get(0);
	   vendorviewObject.setTestVendorName(vendorviewModel.getTestVendorName());
	   vendorviewObject.setTestVendorRegnNumber(vendorviewModel.getTestVendorRegnNumber());
	   vendorviewObject.setVendorContactName(vendorviewModel.getVendorContactName());
	   vendorviewObject.setTieUp(vendorviewModel.getTieUp());
	   vendorviewObject.setEmailId(vendorviewModel.getEmailId());
	   vendorviewObject.setAlternateEmailId(vendorviewModel.getAlternateEmailId());
	   vendorviewObject.setPhoneMobile(vendorviewModel.getPhoneMobile());
	   vendorviewObject.setPhoneLandline(vendorviewModel.getPhoneLandline());
	   vendorviewObject.setEmergencyPhoneNumber(vendorviewModel.getEmergencyPhoneNumber());
	   vendorviewObject.setPhoneFax(vendorviewModel.getPhoneFax());
	   vendorviewObject.setAddressLine1(vendorviewModel.getAddressLine1());
	   vendorviewObject.setAddressLine2(vendorviewModel.getAddressLine2());
	   vendorviewObject.setArea(vendorviewModel.getArea());
	  
	   vendorviewObject.setPostOfficeCode(vendorviewModel.getPostOfficeCode());
	   vendorviewObject.setCity(vendorviewModel.getCity());
	   vendorviewObject.setDistrict(vendorviewModel.getDistrict());
	   vendorviewObject.setState(vendorviewModel.getState());
	   vendorviewObject.setCountry(vendorviewModel.getCountry());
	   vendorviewObject.setPreferredContactMethod(vendorviewModel.getPreferredContactMethod());
	   vendorviewObject.setSmsAlerts(vendorviewModel.getSmsAlerts());
	   vendorviewObject.setRemarks(vendorviewModel.getRemarks());
 return vendorviewObject;
  }

public 	String  deleteVendor(String val,Integer labid,String username) throws ParseException 
{
	
	TestVendorManagerForm vendordeleteObject=new TestVendorManagerForm();
    List vendorlist=clinicDao.viewVendor(val,labid,username);
	TestVendor vendormodelobj= (TestVendor)vendorlist.get(0);
	vendormodelobj.setActiveFlag("N");	
	vendormodelobj.setDeleteFlag("Y");	
	return clinicDao.updatevendor(vendormodelobj, labid, username);
}

public List getTieupList()
  {
	// TODO Auto-generated method stub
	return clinicDao.getTieupList();
  }
public List getSmsList()
   {
	return clinicDao.getSmsList();
   }
public String vendoruser(String vendid)
{
	return clinicDao.vendoruserd(vendid);
}
//create user in vendor details new
public String createuservendor(TestVendorManagerForm createuservendorform,Integer labid,String username )
{
	User usermodel= new User();
	System.out.println("daoimpl-------emaild"+createuservendorform.getEmailId());
	usermodel.setUserName(createuservendorform.getEmailId());
	usermodel.setReferenceId(createuservendorform.getTestVendorId());
	usermodel.setCreatedBy(username);
	usermodel.setLastUpdatedBy(username);
	usermodel.setRole("OTHERS");
	usermodel.setUserType("TESTVENDOR");
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
public List viewVendorLoginDetails(String refId,DoctorLoginForm doctorLoginform,String LabId) throws ParseException {
	
	List doctorDetailList=new ArrayList();
	DoctorLoginSubForm doctorSubFormObject=new DoctorLoginSubForm();
	List doctorDetailQueryList= clinicDao.viewVendorLoginDetails(refId, doctorLoginform, LabId);
	
	for (int i = 0; i < doctorDetailQueryList.size(); i++)
	{
		Object[] view = (Object[]) doctorDetailQueryList.get(i);
		
		doctorSubFormObject=new DoctorLoginSubForm();
		
		doctorSubFormObject.setDate(view[0]==null ? null :(view[0].toString()));
		doctorSubFormObject.setOrderId(view[1]==null ? null :Integer.parseInt(view[1].toString()));
		doctorSubFormObject.setOrderReference(view[2]==null ? null :view[2].toString());
		doctorSubFormObject.setPatientName(view[3]==null ? null :view[3].toString());
		doctorSubFormObject.setVendorName(view[4]==null ? null :view[4].toString());
		
		doctorDetailList.add(doctorSubFormObject);
	}
	 
	return doctorDetailList;
	
}
@Transactional
public TestVendorManagerForm viewDoctorName(TestVendorManagerForm testvendorLoginform,String testvendorname){
	 List list=clinicDao.viewVendorName(testvendorname);
	   Object[] object=(Object[])list.get(0);
	   testvendorLoginform.setTestVendorName(object[0].toString());
	   testvendorLoginform.setTestVendorRegnNumber(object[1].toString());
	
	return testvendorLoginform;
	
}   @Transactional
	public DoctorLoginForm testVendorOrderDetails(String LabId,DoctorLoginForm doctorLoginform,String val){
	
	 List list=clinicDao.DoctortestOrderDetails(LabId,val);
	 Object[] object=(Object[])list.get(0);
	 doctorLoginform.setOrderId(object[0]==null ? null:Integer.parseInt(object[0].toString()));
	 doctorLoginform.setOrderDate(object[1]==null ? null:(object[1].toString()));
	 doctorLoginform.setDoctorName(object[2]==null ? null:(object[2].toString()));
	 doctorLoginform.setVendorName(object[3]==null ? null:(object[3].toString()));
	 doctorLoginform.setOrderReference(object[4]==null ? null:(object[4].toString()));
	 doctorLoginform.setOrderValue(object[5]==null ? null:(object[5].toString()));
	 doctorLoginform.setDiscount(object[6]==null ? null:Integer.parseInt(object[6].toString()));
	 doctorLoginform.setNetValue(object[7]==null ? null:Integer.parseInt(object[7].toString()));
	 doctorLoginform.setAdvance(object[8]==null ? null:Integer.parseInt(object[8].toString()));
	 doctorLoginform.setBalance(object[9]==null ? null:Integer.parseInt(object[9].toString()));
	 doctorLoginform.setTotalCollected(object[10]==null ? null:Integer.parseInt(object[10].toString()));

	 doctorLoginform.setClientName(object[11]==null ? null:(object[11].toString()));
	 doctorLoginform.setLabId(object[12]==null ? null:Integer.parseInt(object[12].toString()));
	
	 doctorLoginform.setClient(object[13]==null ? null:Integer.parseInt(object[13].toString()));
	 
		return doctorLoginform;
		
	}
  //Test Default 1st Test as Visible
  @Transactional
    public List TestVendorOrdergridView(DoctorLoginForm doctorLoginform,String LabId){
  	List doctorDetailList=new ArrayList();
  	
		DoctorLoginSubForm doctorSubFormObject=new DoctorLoginSubForm();
		List doctorDetailQueryList= clinicDao.TestVendorOrdergridView(doctorLoginform, LabId);

		for (int i = 0; i < doctorDetailQueryList.size(); i++)
		{
			Object[] view = (Object[]) doctorDetailQueryList.get(i);
			
			doctorSubFormObject=new DoctorLoginSubForm();
			
			doctorSubFormObject.setTestGroup(view[0]==null ? null :(view[0].toString()));
			doctorSubFormObject.setTestSubgroup(view[1]==null ? null :(view[1].toString()));
			doctorSubFormObject.setTests(view[2]==null ? null :view[2].toString());
			doctorSubFormObject.setOrder(view[3]==null ? null :Integer.parseInt(view[3].toString()));
			doctorSubFormObject.setTestResult(view[4]==null ? null :view[4].toString());
			doctorSubFormObject.setAnalystRemarks(view[5]==null ? null :view[5].toString());
			doctorSubFormObject.setRate(view[6]==null ? null :Integer.parseInt(view[6].toString()));
			doctorSubFormObject.setSpecimenDetails(view[7]==null ? null :view[7].toString());
			doctorSubFormObject.setTestjob(view[8]==null ? null :view[8].toString());
			doctorSubFormObject.setTestedBy(view[9]==null ? null :view[9].toString());
			doctorSubFormObject.setTestApproved(view[10]==null ? null :view[10].toString());
							
			doctorDetailList.add(doctorSubFormObject);
		}
		 
		return doctorDetailList;
		
	     
	
}
  //Test
  @Transactional
  public DoctorLoginForm TestVendorOrderViews(DoctorLoginForm doctorLoginforms,String val,String LabId){
		List doctorDetailQueryList= clinicDao.TestVendorOrderView(doctorLoginforms, val, LabId);
	
		for (int i = 0; i < doctorDetailQueryList.size(); i++)
		{
			Object[] view = (Object[]) doctorDetailQueryList.get(i);
			
			doctorLoginforms.setTestGroup(view[0]==null ? null :(view[0].toString()));
			doctorLoginforms.setTestSubgroup(view[1]==null ? null :(view[1].toString()));
			doctorLoginforms.setTests(view[2]==null ? null :view[2].toString());
			doctorLoginforms.setOrder(view[3]==null ? null :Integer.parseInt(view[3].toString()));
			doctorLoginforms.setTestResult(view[4]==null ? null :view[4].toString());
			doctorLoginforms.setAnalystRemarks(view[5]==null ? null :view[5].toString());
			doctorLoginforms.setRate(view[6]==null ? null :view[6].toString());
			doctorLoginforms.setSpecimenDetails(view[7]==null ? null :view[7].toString());
			doctorLoginforms.setTestjob(view[8]==null ? null :view[8].toString());
			doctorLoginforms.setTestedBy(view[9]==null ? null :view[9].toString());
			doctorLoginforms.setTestApprovedby(view[10]==null ? null :view[10].toString());
			doctorLoginforms.setTestStartdate(view[11]==null ? null:(view[11].toString()));
			doctorLoginforms.setTestStarttime(view[12]==null ? null:(view[12].toString()));
			doctorLoginforms.setTestReference(view[13]==null ? null:(view[13].toString()));
							
			
		}
		 
		return doctorLoginforms;
		
	     
	
}

  public String LoginForm(String username)
	 {   
 	DoctorLoginForm doctorFormObject=new DoctorLoginForm();
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
