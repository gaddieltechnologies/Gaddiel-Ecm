package org.clinikraj.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.clinikraj.dao.ClinicDao;
import org.clinikraj.form.ClinicalLabInfoForm;
import org.clinikraj.form.DoctorLoginForm;
import org.clinikraj.form.IndexForm;
import org.clinikraj.model.ClinicalLab;
import org.clinikraj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.clinikraj.form.IndexForm;

@Service
public class UserLabInfoServiceImpl  implements UserLabInfoService{

	@Autowired
	public ClinicDao clinicDao;
	
	@Transactional
	public ClinicalLabInfoForm clinicalform(String LabId,ClinicalLabInfoForm clinicallabform){
		 List list=clinicDao.clinicalform(LabId);
		 Object[] object=(Object[])list.get(0);
		 
		 clinicallabform.setClientName(object[0]==null ? null:object[0].toString());
		 clinicallabform.setLabId(object[1]==null ? null:Integer.parseInt(object[1].toString()));
		 clinicallabform.setClient(object[2]==null ? null:Integer.parseInt(object[2].toString()));
		 clinicallabform.setLabName(object[3]==null ? null:object[3].toString());
		 clinicallabform.setWebsiteAddress(object[4]==null ? null:object[4].toString());
		 clinicallabform.setEmailId(object[5]==null ? null:object[5].toString());
		 clinicallabform.setAlternateEmailId(object[6]==null ? null:object[6].toString());
		 clinicallabform.setAddressLine1(object[7]==null ? null:object[7].toString());
		 clinicallabform.setAddressLine2(object[8]==null ? null:object[8].toString());
		 clinicallabform.setArea(object[9]==null ? null:object[9].toString());
		 clinicallabform.setPostalcode(object[10]==null ? null:Integer.parseInt(object[10].toString()));
		 clinicallabform.setCity(object[11]==null ? null:object[11].toString());
		 clinicallabform.setDistrict(object[12]==null ? null:object[12].toString());;
		 clinicallabform.setState(object[13]==null ? null:object[13].toString());
		 clinicallabform.setCountry(object[14]==null ? null:object[14].toString());
		 clinicallabform.setPhoneLandLine(object[15]==null ? null:Long.parseLong(object[15].toString()));
		 clinicallabform.setEmergencyPhoneNumber(object[16]==null ? null:Long.parseLong(object[16].toString()));
		 clinicallabform.setPhoneMobile(object[17]==null ? null:Long.parseLong(object[17].toString()));
		 clinicallabform.setPhoneFax(object[18]==null ? null:Integer.parseInt(object[18].toString()));
		 clinicallabform.setStartDate(object[19]==null ? "":(object[19].toString()));
		 clinicallabform.setEndDate(object[20]==null ? "":(object[20].toString()));
		 clinicallabform.setAllowThirdpartyAccess(object[21]==null ? null:object[21].toString());
		 clinicallabform.setRemarks(object[22]==null ? "":(object[22].toString()));
		 return clinicallabform;
		
	}
	 
	 public byte[] getLabLogo(String LabId){
		 byte[] bytes;
		 List getLogoList=clinicDao.getLabLogo(LabId);
		 ClinicalLab clinicalLab=(ClinicalLab)getLogoList.get(0);
		 bytes=clinicalLab.getLogo();
		 return bytes;
		
	 }
	  public String LoginForm(String username)
	 	 {   
		     IndexForm indexForm=new IndexForm();
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
