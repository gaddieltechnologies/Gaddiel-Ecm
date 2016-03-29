package org.clinikraj.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.clinikraj.form.ChangePassword;
import org.clinikraj.form.IndexForm;
import org.clinikraj.service.ClinicService;
import org.clinikraj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChangePasswordControl
{
	private static final Logger logger = Logger.getLogger(ClinicLoginController.class);
	@Autowired
	private ClinicService clinicService;
	private UserService userService;
	
@RequestMapping("/ChangePwd")
	public String changePassword(HttpSession httpSession,HttpServletRequest request, Map model, @ModelAttribute("ChangePwd")IndexForm indexform)
	{
		String returnpage="ChangePwd";
		String username="";
		String patientname="";
		String vendorname="";
		String doctorname="";
		IndexForm indexForms=new IndexForm();
		if(httpSession.getAttribute("userType").toString().equals("LAB")){
			System.out.println(httpSession.getAttribute("userType"));
		username=httpSession.getAttribute("loginname").toString();
		}
		if(httpSession.getAttribute("userType").toString().equals("PATIENT")){
		 patientname=httpSession.getAttribute("patientname").toString();
		}
		if(httpSession.getAttribute("userType").toString().equals("DOCTOR")){
			 doctorname=httpSession.getAttribute("doctorname").toString();
			}
		if(httpSession.getAttribute("userType").toString().equals("TESTVENDOR")){
			 vendorname=httpSession.getAttribute("vendorname").toString();
			}
		//System.out.println(username);
		//System.out.println(changepassword.getUsername()+"username");
		//System.out.println(indexform.getClinicallabUserName()+"username");
		try
		{
			System.out.println(indexform.getDispatch()+"++++++++++++");
			
		
			if((indexform.getDispatch()!=null) && (indexform.getDispatch().equals("Change"))){	

			if(httpSession.getAttribute("userType").toString().equals("LAB")){
				clinicService.changepassword(username, indexform);
				if((indexform.getSuccessmessage()!=null)&(indexform.getSuccessmessage().equals("Your password was saved successfully. Login with new password")))
				{
					indexform.setSuccessmessage("Your password was saved successfully. Login with new password");
				}
				}
				if(httpSession.getAttribute("userType").toString().equals("PATIENT")){
					clinicService.changepasswordpatient(patientname, indexform);
					if((indexform.getSuccessmessage()!=null)&(indexform.getSuccessmessage().equals("Your password was saved successfully. Login with new password")))
					{
						indexform.setSuccessmessage("Your password was saved successfully. Login with new password");
					}
				}
				if(httpSession.getAttribute("userType").toString().equals("DOCTOR")){
					clinicService.changePasswordDoctor(doctorname, indexform);
					if((indexform.getSuccessmessage()!=null)&(indexform.getSuccessmessage().equals("Your password was saved successfully. Login with new password")))
					{
						indexform.setSuccessmessage("Your password was saved successfully. Login with new password");
					}
					}
				if(httpSession.getAttribute("userType").toString().equals("TESTVENDOR")){
					clinicService.changePasswordVendor(vendorname, indexform);
					if((indexform.getSuccessmessage()!=null)&(indexform.getSuccessmessage().equals("Your password was saved successfully. Login with new password")))
					{
						indexform.setSuccessmessage("Your password was saved successfully. Login with new password");
					}
					}
		 System.out.println("---------------save");	
	     model.put("ChangePwd", indexform);
	     returnpage="ChangePwd";
		}
		}
      catch(Exception e)
		{
			e.printStackTrace();
		}
	 model.put("ChangePwd", indexform);
      return returnpage;
		
	}
@RequestMapping("/resetPassword")
public String resetPassword(HttpSession httpSession,HttpServletRequest request, Map model, @ModelAttribute("resetPassword")ChangePassword changepassword)
{
	String returnpage="resetPassword";
	String username="";
	String userType="";
	username=httpSession.getAttribute("username").toString();
	//System.out.println(username+"username");
	userType=httpSession.getAttribute("userType").toString();
	//System.out.println(userType+"userType");
	//System.out.println(username);
	//System.out.println(changepassword.getUsername()+"username");
	//System.out.println(indexform.getClinicallabUserName()+"username");
	try
	{
		//System.out.println(changepassword.getDispatch()+"++++++++++++");
		//System.out.println((httpSession.getAttribute("userType").toString()+"usertype"));
		if((changepassword.getDispatchhitted()!=null) && (changepassword.getDispatchhitted().equals("resetpwdchange"))){
			//System.out.print("control hit");
			clinicService.verifyQuestion(changepassword, username, userType);
			//System.out.print("control hit");
			if((changepassword.getqResult().equals("print"))) {		
			//System.out.print("value get");
			changepassword.setErrormessage("correct answer");			
			 model.put("resetPassword", changepassword);
			 returnpage= "resetPassword";
			}
			if((changepassword.getqResult().equals("not print"))) {			
			changepassword.setErrormessage("Enter the correct answer");
				 model.put("resetPassword", changepassword);
				 returnpage= "resetPassword";
			}	 
			}	
		System.out.println(changepassword.getDispatch()+"dispatch hit");
	if((changepassword.getDispatch()!=null) && (changepassword.getDispatch().equals("Change")))
	{	
		clinicService.changingpassword(changepassword, username, userType);
		if((changepassword.getqResult().equals("print"))) {		
			 System.out.println("---------------save");	
			    returnpage= "redirect:index";
			}
	}
	}
  catch(Exception e)
	{
		e.printStackTrace();
	}
 model.put("resetPassword", changepassword);
  return returnpage;
}
}
