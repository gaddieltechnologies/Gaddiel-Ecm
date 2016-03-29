package org.clinikraj.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolationException;

import org.clinikraj.dao.ClinicDao;
import org.clinikraj.form.IndexForm;
import org.clinikraj.form.UserAccessManagerForm;
import org.clinikraj.form.UserAccessManagerSubForm;
import org.clinikraj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public ClinicDao clinicDao;
	
	@Transactional
	public List viewLabUserDetails(HttpSession httpSession, UserAccessManagerForm userFormObject,UserAccessManagerSubForm userSubObject) throws ParseException	
	{
		UserAccessManagerSubForm userSubFormObject=new UserAccessManagerSubForm();
		List userDetailList=new ArrayList();
		List userLabDetailQueryList=clinicDao.viewLabUserDetails(httpSession, userFormObject, userSubObject);
		String searchMobile=userFormObject.getSearchPhoneMobile();
		for (int i = 0; i < userLabDetailQueryList.size(); i++)
		{
			Object[] user = (Object[]) userLabDetailQueryList.get(i);
			
			userSubFormObject=new UserAccessManagerSubForm();
			
			userSubFormObject.setUserName(user[0].toString());
			userSubFormObject.setUserType(user[1].toString());
			userSubFormObject.setRole((user[2].toString()));
			
			userSubFormObject.setUserId(Integer.parseInt(user[3].toString()));
			
			
		
			userDetailList.add(userSubFormObject);
		}
		if(searchMobile!=null && searchMobile.length()!=0)
		{
			userDetailList=new ArrayList();
		}
		return userDetailList;
	}

	public List viewPatientUserDetails(HttpSession httpSession, UserAccessManagerForm userFormObject,UserAccessManagerSubForm userSubObject) throws ParseException	
	{
		
		UserAccessManagerSubForm userSubFormObject=new UserAccessManagerSubForm();
		List userDetailList=new ArrayList();
		List userPatientDetailQueryList=clinicDao.viewPatientUserDetails(httpSession, userFormObject, userSubObject);
		
		for (int i = 0; i < userPatientDetailQueryList.size(); i++)
		{
			Object[] user = (Object[]) userPatientDetailQueryList.get(i);
			
			userSubFormObject=new UserAccessManagerSubForm();
			
			userSubFormObject.setUserName(user[0].toString());
			userSubFormObject.setUserType(user[1].toString());
			userSubFormObject.setRole((user[2].toString()));
			userSubFormObject.setPostOfficeCode(user[3]==null ? "" : user[3].toString());
			userSubFormObject.setUserId(Integer.parseInt(user[6].toString()));
			userSubFormObject.setPhoneMobile(user[4]==null ? "" : user[4].toString());
			userSubFormObject.setEmailID(user[5]==null ? "" : user[5].toString());
			userSubFormObject.setUserId(Integer.parseInt(user[6].toString()));
		
			userDetailList.add(userSubFormObject);
		}
		
		return userDetailList;
		
	}
	
	public List viewDoctorUserDetails(HttpSession httpSession, UserAccessManagerForm userFormObject,UserAccessManagerSubForm userSubObject) throws ParseException	
	{
			
	System.out.println("HIT User DETAIL VIEW IMPL");	
			
	UserAccessManagerSubForm userSubFormObject=new UserAccessManagerSubForm();
	List userDetailList=new ArrayList();
	List userDoctorDetailQueryList=clinicDao.viewDoctorUserDetails(httpSession, userFormObject, userSubObject);
	
	for (int i = 0; i < userDoctorDetailQueryList.size(); i++)
	{
		Object[] user = (Object[]) userDoctorDetailQueryList.get(i);
		
		userSubFormObject=new UserAccessManagerSubForm();
		userSubFormObject.setUserId(Integer.parseInt(user[6].toString()));
		userSubFormObject.setUserName(user[0].toString());
		userSubFormObject.setUserType(user[1].toString());
		userSubFormObject.setRole((user[2].toString()));
		userSubFormObject.setPostOfficeCode(user[3]==null ? "" : user[3].toString());
		
		userSubFormObject.setPhoneMobile(user[4]==null ? "" : user[4].toString());
		userSubFormObject.setEmailID(user[5]==null ? "" : user[5].toString());
		
	
		userDetailList.add(userSubFormObject);
	}

return userDetailList;

	
	}

	
	public List viewTestVendorUserDetails(HttpSession httpSession, UserAccessManagerForm userFormObject,UserAccessManagerSubForm userSubObject) throws ParseException	
	{
			
	System.out.println("HIT User DETAIL VIEW IMPL");	
			
	UserAccessManagerSubForm userSubFormObject=new UserAccessManagerSubForm();
	List userDetailList=new ArrayList();
	List userTestVendorDetailQueryList=clinicDao.viewTestVendorUserDetails(httpSession, userFormObject, userSubObject);
	
	for (int i = 0; i < userTestVendorDetailQueryList.size(); i++)
	{
		Object[] user = (Object[]) userTestVendorDetailQueryList.get(i);
		
		userSubFormObject=new UserAccessManagerSubForm();
		
		userSubFormObject.setUserId(Integer.parseInt(user[6].toString()));
		userSubFormObject.setUserName(user[0].toString());
		userSubFormObject.setUserType(user[1].toString());
		userSubFormObject.setRole((user[2].toString()));
		userSubFormObject.setPostOfficeCode(user[3]==null ? "" : user[3].toString());
		
		userSubFormObject.setPhoneMobile(user[4]==null ? "" : user[4].toString());
		userSubFormObject.setEmailID(user[5]==null ? "" : user[5].toString());
		
	
		userDetailList.add(userSubFormObject);
	}
	
	return userDetailList;
	
	}
	
public List viewUserAccessManagerViewList(HttpSession httpSession, UserAccessManagerForm userFormObject,UserAccessManagerSubForm userSubObject) throws ParseException {
		
		List LabList=viewLabUserDetails(httpSession, userFormObject, userSubObject);
		List PatientList=viewPatientUserDetails(httpSession, userFormObject, userSubObject);
		List DoctorList=viewDoctorUserDetails(httpSession, userFormObject, userSubObject);
		List TestVendorList=viewTestVendorUserDetails(httpSession, userFormObject, userSubObject);		
		
		List <UserAccessManagerSubForm> viewUserAccessManagerList=new ArrayList();
		viewUserAccessManagerList.addAll(LabList);
		viewUserAccessManagerList.addAll(PatientList);
		viewUserAccessManagerList.addAll(DoctorList);
		viewUserAccessManagerList.addAll(TestVendorList);
		
		return viewUserAccessManagerList;
	}
	
public String addUserDetails(String username, String labId, UserAccessManagerForm addUser)throws ParseException {
	User userAddModel=new User();
	String output=null;
	try{
		/*not null*/	userAddModel.setUserName(addUser.getUserName());
						userAddModel.setCreatedBy(username);
						userAddModel.setCreatedDate(new Date());
						userAddModel.setLastUpdatedBy(username);
						userAddModel.setLastUpdatedDate(new Date());
						userAddModel.setUserId(null);
						userAddModel.setClinicalLab(Integer.parseInt(labId));
						userAddModel.setPassword("123");
						userAddModel.setPasswordQuestion1("123");
						userAddModel.setPasswordAnswer1("123");
						userAddModel.setPasswordQuestion2("123");
						userAddModel.setPasswordAnswer2("123");
						userAddModel.setPasswordQuestion3("123");
						userAddModel.setPasswordAnswer3("123");
						userAddModel.setLastSuccessLoginDate(new Date());
						userAddModel.setLastFailedLoginDate(new Date());
		/*not null*/	userAddModel.setUserType(addUser.getUserType());
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxwwwwwwwwwwwwwhhhhhh"+addUser.getUserType());
		/*not null*/	userAddModel.setRole(addUser.getRole());
		/*not null*/	userAddModel.setDefaultPasswordChanged(addUser.getDefaultPasswordChanged());
		/*not null*/	userAddModel.setActiveFlag(addUser.getUserActive());
		/*not null*/	userAddModel.setDeleteFlag(addUser.getUserDelete());		
		/*not null*/	userAddModel.setStartDate(new Date());
		/*not null*/	userAddModel.setRemarks(addUser.getRemarks());
		/*not null*/	
	 output=clinicDao.addUserDetails(userAddModel);
	 System.out.println("---------OUTPUT IN SERVICE IMPL_________----------"+output);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return output;

}


public 	String  deleteUser(String val) throws ParseException 
{
	
	UserAccessManagerForm userDelete=new UserAccessManagerForm();
    List userDeletelist=clinicDao.viewUser(val);
    System.out.println("Delete user Impl");
    User userDeleteModel= (User)userDeletelist.get(0);
    userDeleteModel.setActiveFlag("N");
    userDeleteModel.setDeleteFlag("Y");	
    userDeleteModel.setEndDate(new Date());
	String output=clinicDao.deleteUser(userDeleteModel);
	return output;
}


public UserAccessManagerForm viewUser(String val) throws ParseException
{
	UserAccessManagerForm viewObject= new UserAccessManagerForm();
	List userDetailQueryList= clinicDao.viewUser(val);
	User userViewModel= (User) userDetailQueryList.get(0) ;
	viewObject.setUserName(userViewModel.getUserName());
	viewObject.setDefaultPasswordChanged(userViewModel.getDefaultPasswordChanged());
	
	viewObject.setEndDate(userViewModel.getEndDate());
	viewObject.setFailedLogin(userViewModel.getLastFailedLoginDate());
	viewObject.setLastSessionId(userViewModel.getSessionId());
	viewObject.setNextPasswordChangeDate(userViewModel.getNextPasswordChangeDate());
	viewObject.setRemarks(userViewModel.getRemarks());
	viewObject.setRole(userViewModel.getRole());
	viewObject.setUserType(userViewModel.getUserType());
	viewObject.setStartDate(userViewModel.getStartDate());
	viewObject.setSuccessLogin(userViewModel.getLastSuccessLoginDate());
	viewObject.setUserActive(userViewModel.getActiveFlag());
	viewObject.setUserDelete(userViewModel.getDeleteFlag());
	
	return viewObject;
}

public List getRoleList() {
	// TODO Auto-generated method stub
	return clinicDao.getRoleList();
}



public List getUserTypeList() {
	// TODO Auto-generated method stub
	return clinicDao.getUserTypeList();
}



public List getDefaultPasswordChangedList() {
	// TODO Auto-generated method stub
	return clinicDao.getDefaultPasswordChangedList();
}



public List getActiveFlagList() {
	// TODO Auto-generated method stub
	return clinicDao.getActiveFlagList();
}



public List getDeleteFlagList() {
	// TODO Auto-generated method stub
	return clinicDao.getDeleteFlagList();
}

public IndexForm logoutendsession(HttpSession httpSession, IndexForm indexForm){
	 
	 httpSession.setAttribute("username", null);
	 return indexForm;
}

}
