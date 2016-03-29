package org.clinikraj.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.clinikraj.dao.ClinicDao;
import org.clinikraj.form.DoctorForm;
import org.clinikraj.form.DoctorLoginForm;
import org.clinikraj.form.DoctorLoginSubForm;
import org.clinikraj.form.DoctorSubForm;
import org.clinikraj.form.DoctorTestOrderForm;
import org.clinikraj.form.PatientLoginForm;
import org.clinikraj.form.IndexForm;
import org.clinikraj.form.PatientManagerForm;
import org.clinikraj.form.PatientManagerSubForm;
import org.clinikraj.model.Doctor;
import org.clinikraj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	public ClinicDao clinicDao;
	
	@Transactional
	public List doctorform(DoctorForm doctoform, DoctorSubForm subdoctor,String LabId){
		 List doctorlist=clinicDao.doctorform(doctoform, subdoctor, LabId);
		 DoctorSubForm subDoctor=new DoctorSubForm();
		 List list=new ArrayList();
		 for(int i=0 ;i<doctorlist.size();i++){
			 Object[] doctorView = (Object[]) doctorlist.get(i);
			 subDoctor=new DoctorSubForm();
		     subDoctor.setDoctorId(Integer.parseInt(doctorView[0].toString()));
			 subDoctor.setDoctorName((doctorView[1]==null) ? "":(doctorView[1].toString()));
			 subDoctor.setDoctorImcNumber((doctorView[2]==null) ? "":(doctorView[2].toString()));
			 subDoctor.setSpecialization((doctorView[3]==null) ? "":(doctorView[3].toString()));
			 subDoctor.setTieUp((doctorView[4]==null) ? "":(doctorView[4].toString()));
			 subDoctor.setEmailId((doctorView[5]==null) ? "":(doctorView[5].toString()));
			 subDoctor.setPhoneMobile((doctorView[6]==null) ? "":(doctorView[6].toString()));
			 subDoctor.setPreferredContactMethod((doctorView[7]==null) ? "":doctorView[7].toString());
		
			 list.add(subDoctor);
			
		
	          }
		return list;
	}
	
	public String doctorAdd(String username, String labId,DoctorForm doctorForm ){
		 Doctor doctor=new Doctor();
		 String output=null;
		 /*not null*/	doctor.setCreatedBy(username);
		 /*not null*/	 doctor.setCreatedDate(new Date());
		 /*not null*/	 doctor.setLastUpdatedBy(username);
		 /*not null*/	 doctor.setLastUpdatedDate(new Date());
		 /*not null*/	 doctor.setDoctorId(null);
		 /*not null*/	 doctor.setClinicalLab(Integer.parseInt(labId));
		 /*not null*/    doctor.setStartDate(new Date());
		 /*not null*/	 doctor.setDoctorName(doctorForm.getDoctorName());
		 doctor.setDoctorImcNumber(doctorForm.getDoctorImcNumber());
		 doctor.setSpecialization(doctorForm.getSpecialization());
		 doctor.setTieUp(doctorForm.getTieUp());
		 doctor.setEmailId(doctorForm.getEmailId());
		 doctor.setAlternateEmailId(doctorForm.getAlternateEmailId());
		 doctor.setPhoneMobile(doctorForm.getPhoneMobile());
		 doctor.setPhoneLandline(doctorForm.getPhoneLandline());
		 doctor.setEmergencyPhoneNumber(doctorForm.getEmergencyPhoneNumber());
		 doctor.setPhoneFax(doctorForm.getPhoneFax());
		 doctor.setAddressLine1(doctorForm.getAddressLine1());
		 doctor.setAddressLine2(doctorForm.getAddressLine2());
		 doctor.setArea(doctorForm.getArea());
		 doctor.setPostOfficeCode(doctorForm.getPostalcode());
		 doctor.setCity(doctorForm.getCity());
		 doctor.setDistrict(doctorForm.getDistrict());
		 doctor.setState(doctorForm.getState());
		 doctor.setCountry(doctorForm.getCountry());
		 doctor.setPreferredContactMethod(doctorForm.getPreferredContactMethod());
		 doctor.setSmsAlerts(doctorForm.getSmsAlerts());
		 output=clinicDao.doctorAdd(doctor, username, labId);
		 
		 doctorForm.setDoctorId(doctor.getDoctorId());
		 doctorForm.setEmailId(doctor.getEmailId());
		 
		
		return output;
		 
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
	 public List PrefferedDoctorcontacts(){
		return clinicDao.Prefferedcontact();
		 
	 }
	 public String addDocUser(String doctorId){
		return clinicDao.addDocUser(doctorId);
		 
	 }
	 public String addUser(String username,DoctorForm doctoform, String LabId){
		User user=new User();
		 String output=null;
		user.setCreatedBy(username);
		user.setCreatedDate(new Date());
		user.setLastUpdatedBy(username);
		user.setLastUpdatedDate(new Date());
		user.setUserId(null);
		
		user.setClinicalLab(Integer.parseInt(LabId));
		user.setUserName(doctoform.getEmailId());
		System.out.print("username"+doctoform.getEmailId());
		user.setUserType("DOCTOR");
		user.setReferenceId(doctoform.getDoctorId());
		user.setRole("OTHERS");
		user.setPassword("123");
		user.setPasswordQuestion1("123");
		user.setPasswordAnswer1("123");
		user.setPasswordQuestion2("123");
		user.setPasswordAnswer2("123");
		user.setPasswordQuestion3("123");
		user.setPasswordAnswer3("123");
		user.setLastSuccessLoginDate(new Date());
		user.setLastFailedLoginDate(new Date());

/*not null*/	user.setDefaultPasswordChanged("N");
/*not null*/	user.setActiveFlag("Y");
/*not null*/	user.setDeleteFlag("N");		
/*not null*/	user.setStartDate(new Date());

		
       output=clinicDao.addUser(user, LabId, username);
		return output;
		 
	 }
	 public DoctorForm doctorView(String val){
		 DoctorForm doctorsubForm=new DoctorForm();
		 List list=clinicDao.doctorView(val);
			 Doctor doctor=(Doctor)list.get(0);
			 doctorsubForm.setDoctorName(doctor.getDoctorName());
			 doctorsubForm.setDoctorImcNumber(doctor.getDoctorImcNumber());
			 doctorsubForm.setSpecialization(doctor.getSpecialization());
			 doctorsubForm.setTieUp(doctor.getTieUp());
			 doctorsubForm.setEmailId(doctor.getEmailId());
			 doctorsubForm.setAlternateEmailId(doctor.getAlternateEmailId());
			 doctorsubForm.setPhoneMobile(doctor.getPhoneMobile());
			 doctorsubForm.setPhoneLandline(doctor.getPhoneLandline());
			 doctorsubForm.setEmergencyPhoneNumber(doctor.getEmergencyPhoneNumber());
			 doctorsubForm.setPhoneFax(doctor.getPhoneFax());
			 doctorsubForm.setAddressLine1(doctor.getAddressLine1());
			 doctorsubForm.setAddressLine2(doctor.getAddressLine2());
			 doctorsubForm.setArea(doctor.getArea());
			 doctorsubForm.setPostalcode(doctor.getPostOfficeCode());
			 doctorsubForm.setCity(doctor.getCity());
			 doctorsubForm.setDistrict(doctor.getDistrict());
			 doctorsubForm.setState(doctor.getState());
			 doctorsubForm.setCountry(doctor.getCountry());
			 doctorsubForm.setPreferredContactMethod(doctor.getPreferredContactMethod());
			 doctorsubForm.setSmsAlerts(doctor.getSmsAlerts());
			 return doctorsubForm;
	 }
	public List postofficedoctor(String var) throws ParseException{
		return clinicDao.postofficedoctor(var) ;
		
	}
	public List Specilizationdoctor() throws ParseException{
		return clinicDao.Specilizationdoctor();
		
	}
	@Transactional
	public List viewDoctorLoginDetails(DoctorLoginForm doctorLoginform,String LabId,String refId) throws ParseException {
		
		List doctorDetailList=new ArrayList();
		DoctorLoginSubForm doctorSubFormObject=new DoctorLoginSubForm();
		List doctorDetailQueryList= clinicDao.viewDoctorLoginDetails(doctorLoginform, LabId, refId);
		
	
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
  public DoctorLoginForm viewDoctorName(DoctorLoginForm doctorLoginform,String doctorname){
	 List list=clinicDao.viewDoctorName(doctorname);
	   Object[] object=(Object[])list.get(0);
	   doctorLoginform.setDoctorName(object[0].toString());
	   doctorLoginform.setSpecialization(object[1].toString());
	
	return doctorLoginform;
	
}   @Transactional
	public DoctorLoginForm DoctortestOrderDetails(String LabId,DoctorLoginForm doctorLoginform,String val){

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
      public List DoctortestOrdergridView(String LabId,DoctorLoginForm doctorLoginform){
    	List doctorDetailList=new ArrayList();
		DoctorLoginSubForm doctorSubFormObject=new DoctorLoginSubForm();
		List doctorDetailQueryList= clinicDao.DoctortestOrdergridView(doctorLoginform, LabId);
		
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
    public DoctorLoginForm DoctortestOrderViews(DoctorLoginForm doctorLoginforms,String val,String LabId){
	List doctorDetailQueryList= clinicDao.DoctortestOrderView(doctorLoginforms, val,LabId);

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
