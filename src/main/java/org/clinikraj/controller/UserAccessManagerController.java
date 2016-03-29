package org.clinikraj.controller;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.clinikraj.form.DoctorForm;
import org.clinikraj.form.IndexForm;
import org.clinikraj.form.PatientManagerForm;
import org.clinikraj.form.PatientManagerSubForm;
import org.clinikraj.form.UserAccessManagerForm;
import org.clinikraj.form.UserAccessManagerSubForm;
import org.clinikraj.service.ClinicService;
import org.clinikraj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserAccessManagerController {
	private static final Logger logger = Logger.getLogger(UserAccessManagerController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping("/userAccessManager")
	public String userAccessManagerForm(HttpSession httpSession, HttpServletRequest request,HttpServletResponse response, Map model, @ModelAttribute(value ="userAccessManager")UserAccessManagerForm userFormObject) throws ParseException{
		
		System.out.println("Hit User Manager controller ");
		try{
		
		//PatientManagerForm patientFormObject=new PatientManagerForm();
		UserAccessManagerSubForm userSubObject=new UserAccessManagerSubForm();
		System.out.println(httpSession.getAttribute("labId").toString());
PatientManagerSubForm patientSubObject=new PatientManagerSubForm();
		String returnpage="userAccessManager";
		List getdetails=new ArrayList();
		
		
		
		if((userFormObject.getDispatchGridView()!=null) && (userFormObject.getDispatchGridView().equals("search")))
		{
			getdetails=userService.viewUserAccessManagerViewList(httpSession, userFormObject, userSubObject);
			
		}
		
		if((userFormObject.getDispatchGridView()!=null) && (userFormObject.getDispatchGridView().equals("view")))
		{
			try{String viewid=userFormObject.getDispatchid();
			System.out.println("User id "+viewid);
			userFormObject=userService.viewUser(viewid);
						model.put("userAccessManagerView",userFormObject);
			returnpage="userAccessManagerView";}
			catch(NullPointerException e){
				e.printStackTrace();
				IndexForm logform=new IndexForm();
				model.put("index", logform);
				return "sessionexpire";
			}
			
		}
		
		if((userFormObject.getDispatchGridView()!=null) && (userFormObject.getDispatchGridView().equals("delete")))
		{
			String delid=userFormObject.getDispatchid(); 	
System.out.println(" DELETE CONTROLLER VALVE.......>>>"+delid);
String output=userService.deleteUser(delid);
userFormObject.setSuccessMessage(output);
			model.put("userAccessManager",userFormObject);
			
			
						
		}
		
		if((userFormObject.getDispatchGridView()!=null) && (userFormObject.getDispatchGridView().equals("new"))){
			try{String username=httpSession.getAttribute("username").toString();
			String labid=httpSession.getAttribute("labId").toString();
			/*List prefcontact=new ArrayList();
			prefcontact=clinicService.Prefferedcontact();
			model.put("prefferedlisttype", prefcontact);*/
			List userrole=userService.getRoleList();
			List usertype=userService.getUserTypeList();
			List defpasschange=userService.getDefaultPasswordChangedList();
			List actflag=userService.getActiveFlagList();
			List delflag=userService.getDeleteFlagList();
			model.put("rolelistvalue",userrole);
			model.put("usertypelistvalue",usertype);
			model.put("defpasschangelistvalue",defpasschange);
			model.put("actflaglistvalue",actflag);
			model.put("delflaglistvalue",delflag);
			model.put("UserAccessManagerAdd",userFormObject);
			returnpage="userAccessManagerAdd";
		}
			catch(NullPointerException e){
				e.printStackTrace();
				IndexForm logform=new IndexForm();
				model.put("index", logform);
				return "sessionexpire";
			}}
		
		if((userFormObject.getDispatchGridView()!=null)&&(userFormObject.getDispatchGridView().equals("Save")))
		{
			String username=httpSession.getAttribute("username").toString();
			String labid=httpSession.getAttribute("labId").toString();
			/*List prefcontact=new ArrayList();
			prefcontact=clinicService.Prefferedcontact();
			model.put("prefferedlisttype", prefcontact);*/
			List userrole=userService.getRoleList();
			List usertype=userService.getUserTypeList();
			List defpasschange=userService.getDefaultPasswordChangedList();
			List actflag=userService.getActiveFlagList();
			List delflag=userService.getDeleteFlagList();
			model.put("rolelistvalue",userrole);
			model.put("usertypelistvalue",usertype);
			model.put("defpasschangelistvalue",defpasschange);
			model.put("actflaglistvalue",actflag);
			model.put("delflaglistvalue",delflag);
			
			String output=userService.addUserDetails(username, labid, userFormObject);
			if(output!="Record already exists")
			{
				userFormObject.setSuccessMessage(output);
				model.put("UserAccessManagerAdd",userFormObject);	
			}
				System.out.println("checking for saved username disAAAAAAAAAAAbleDDDDDDDDD"+userFormObject.getUserName());
				System.out.println("checking for saved usertype disAAAAAAAAAAAbleDDDDDDDDD"+userFormObject.getUserType());
				System.out.println("!!!!!!!!!!!!!!!CCCCCCCC"+output);
				userFormObject.setErrorMessage(output);
				model.put("UserAccessManagerAdd",userFormObject);
				returnpage="userAccessManagerAdd";
			
			//userSaveObject.setDispatch(useraddobject.getDispatch());
			
		}
		
		if((userFormObject.getDispatchGridView()!=null)&&(userFormObject.getDispatchGridView().equals("Save&New")))
		{
			String username=httpSession.getAttribute("username").toString();
			String labid=httpSession.getAttribute("labId").toString();
			/*List prefcontact=new ArrayList();
			prefcontact=clinicService.Prefferedcontact();
			model.put("prefferedlisttype", prefcontact);*/
			List userrole=userService.getRoleList();
			List usertype=userService.getUserTypeList();
			List defpasschange=userService.getDefaultPasswordChangedList();
			List actflag=userService.getActiveFlagList();
			List delflag=userService.getDeleteFlagList();
			model.put("rolelistvalue",userrole);
			model.put("usertypelistvalue",usertype);
			model.put("defpasschangelistvalue",defpasschange);
			model.put("actflaglistvalue",actflag);
			model.put("delflaglistvalue",delflag);
			
			String output=userService.addUserDetails(username, labid, userFormObject);
			if(output!="Record already exists")
			{
				userFormObject.setSuccessMessage(output);
				model.put("UserAccessManagerAdd",userFormObject);	
			}
			//userSaveObject.setDispatch(useraddobject.getDispatch());
			userFormObject.setErrorMessage(output);
			model.put("UserAccessManagerAdd",userFormObject);
			returnpage="userAccessManagerAdd";
		}
		
		if((userFormObject.getDispatchGridView()!=null)&&(userFormObject.getDispatchGridView().equals("Save&Close")))
		{
			String username=httpSession.getAttribute("username").toString();
			String labid=httpSession.getAttribute("labId").toString();
			/*List prefcontact=new ArrayList();
			prefcontact=clinicService.Prefferedcontact();
			model.put("prefferedlisttype", prefcontact);*/
			List userrole=userService.getRoleList();
			List usertype=userService.getUserTypeList();
			List defpasschange=userService.getDefaultPasswordChangedList();
			List actflag=userService.getActiveFlagList();
			List delflag=userService.getDeleteFlagList();
			model.put("rolelistvalue",userrole);
			model.put("usertypelistvalue",usertype);
			model.put("defpasschangelistvalue",defpasschange);
			model.put("actflaglistvalue",actflag);
			model.put("delflaglistvalue",delflag);
			
		
			String output=userService.addUserDetails(username, labid, userFormObject);
			//userSaveObject.setDispatch(useraddobject.getDispatch());
			
			if(output!="Record saved successfully"){
			
			userFormObject.setErrorMessage(output);
			model.put("UserAccessManagerAdd", userFormObject);
			returnpage="userAccessManagerAdd";
			
			}
			userFormObject.setSuccessMessage(output);
				model.put("userAccessManager", userFormObject);				
			
		}
		
		userFormObject.setUserDetailSubForm(getdetails);
		System.out.println("Controller------"+getdetails.size());
		//model.put("patientManager",patientFormObject);
		return returnpage;}
		catch(NullPointerException e){
			e.printStackTrace();
			IndexForm logform=new IndexForm();
			model.put("index", logform);
			return "sessionexpire";
		}
		
		
	}
	
	


	


}
