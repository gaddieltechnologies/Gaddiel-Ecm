package org.clinikraj.service;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.clinikraj.form.IndexForm;
import org.clinikraj.form.UserAccessManagerForm;
import org.clinikraj.form.UserAccessManagerSubForm;

public interface UserService {
	
	public List viewLabUserDetails(HttpSession httpSession, UserAccessManagerForm userFormObject,UserAccessManagerSubForm userSubObject) throws ParseException;
	public List viewPatientUserDetails(HttpSession httpSession, UserAccessManagerForm userFormObject,UserAccessManagerSubForm userSubObject) throws ParseException;
	public List viewDoctorUserDetails(HttpSession httpSession, UserAccessManagerForm userFormObject,UserAccessManagerSubForm userSubObject) throws ParseException;
	public List viewTestVendorUserDetails(HttpSession httpSession, UserAccessManagerForm userFormObject,UserAccessManagerSubForm userSubObject) throws ParseException;
	public List viewUserAccessManagerViewList(HttpSession httpSession, UserAccessManagerForm userFormObject,UserAccessManagerSubForm userSubObject) throws ParseException;
	public String addUserDetails(String username, String labId, UserAccessManagerForm addUser) throws ParseException;
	public UserAccessManagerForm viewUser(String val) throws ParseException;
	public 	String  deleteUser(String val) throws ParseException;
	public List getRoleList();
	public List getUserTypeList();
	public List getDefaultPasswordChangedList();
	public List getActiveFlagList();
	public List getDeleteFlagList();
	public IndexForm logoutendsession(HttpSession httpSession, IndexForm indexForm);
}
