package org.clinikraj.controller;



import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.tanesha.recaptcha.ReCaptchaException;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.apache.log4j.Logger;
import org.clinikraj.form.ChangePassword;
import org.clinikraj.form.DoctorLoginForm;
import org.clinikraj.form.ClinicalLabInfoForm;
import org.clinikraj.form.IndexForm;
import org.clinikraj.form.PatientLoginForm;
import org.clinikraj.model.User;
import org.clinikraj.form.PatientManagerForm;
import org.clinikraj.model.ClinicalLab;
import org.clinikraj.model.User;
import org.clinikraj.service.ClinicService;
import org.clinikraj.service.UserService;
import org.clinikraj.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.multipart.support.StringMultipartFileEditor;





@Controller
public class ClinicLoginController {
	
	private static final Logger logger = Logger.getLogger(ClinicLoginController.class);
	@Autowired
	private ClinicService clinicService;
	private UserService userService;
	
	
	
	@RequestMapping("/index")
	public String indexform(HttpServletRequest request,HttpSession httpSession,Map model, @ModelAttribute("index")IndexForm indexForm, User users) throws IOException{
		System.out.println("hit login");
		String linked = indexForm.getClinikrajlogincheck();
		//System.out.println("hit login@@@@@@@!!!");
		
		String returnpage="index";
		IndexForm logform = new IndexForm();
		ChangePassword changepassword=new ChangePassword();
		
		String username="";
		String role="";
		Integer labid=null;
		Integer refid=null;
		String user="";
		String allowthirdparty="";
		int  patientage=0;
		String doctorspecialization="";
		String testvendorregistration="";
		String loginname="";
		String userType="";
		
		if ((linked != null) && (linked.equals("clinicallablogin"))) {
			System.out.println("---------------dipatch inside");
			indexForm=clinicService.login(indexForm);
			
			if(indexForm.getResult().equals("match")){
				System.out.println("---------------dipatch----");
				if(indexForm.getFirstLogin().equals("Y")){
					System.out.println("---------------dipatch---------");
					loginname=indexForm.getClinicallabUserName();
					httpSession.setAttribute("loginname", loginname);
					userType=indexForm.getUserType();
					httpSession.setAttribute("userType", userType);
				    model.put("ChangePwd", indexForm);
				    returnpage="redirect:ChangePwd";
				}
				
				if(indexForm.getFirstLogin().equals("N")){
				String messagevalue="Your Password has expired.Please reset the password.";
                  //  System.out.println(indexForm.getOutput()+"101010");
				  // System.out.println(messagevalue+"11111111");
			      if((indexForm.getOutput()!=null) && (indexForm.getOutput().equals(messagevalue)))
					{
			    	 // System.out.println(indexForm.getOutput()+"101010controller");
					 //  System.out.println(messagevalue+"11111111controller");
					  
					   model.put("ResetPassword", changepassword);
						 returnpage="redirect:ResetPassword";
					  
				}
			      else
			      {
			    	 
			    	 returnpage = "redirect:controlPanel";
			      }
				indexForm.setUserDisplay(indexForm.getClinicallabUserName());
				username=indexForm.getClinicallabUserName().toLowerCase();
			   
				
				doctorspecialization=indexForm.getDoctorspecialization();
				testvendorregistration=indexForm.getTestvendorregistration();
				user=indexForm.getUser();
				role=indexForm.getRole();
				labid=indexForm.getLabid();
				refid=indexForm.getRefid();
				userType=indexForm.getUserType();
				//allowthirdparty=indexForm.getAllowthirdparty();
				//model.put("login", logform);
				}
				
			}
			
	
			else{
				
				returnpage = "index";
				indexForm.setClinicalerrormessage("Invalid User Name/Password (or) User is not Active");
				System.out.println(indexForm.getClinicalerrormessage());
				model.put("index", indexForm);
			}
		}
		
	
		if ((linked != null) && (linked.equals("patientlogin"))) {
			System.out.println("---------------dipatch inside");
			PatientLoginForm patientLoginform=new PatientLoginForm();
			indexForm=clinicService.patientLogin(indexForm);
			if(indexForm.getResult().equals("match")){
				if(indexForm.getFirstLogin().equals("Y")){
					String patientname="";
					patientname=indexForm.getPatientUserName();
					httpSession.setAttribute("patientname", patientname);
					userType=indexForm.getUserType();
					httpSession.setAttribute("userType", userType);
					 model.put("ChangePwd", indexForm);
					    returnpage="redirect:ChangePwd";
				}
				//String controlvalue="Your Password will expire in "+indexForm.getControlmessage()+"day(s)..Please reset the password";
				
				if(indexForm.getFirstLogin().equals("N")){
					//String output=clinicService.changepassword(username, indexForm);
					httpSession.setAttribute("Num", indexForm.getFirstLogin());
					
				      if((indexForm.getOutput()!=null) && (indexForm.getOutput().equals("Your Password has expired.Please reset the password.")))
						{
				    	  
				    	   model.put("ResetPassword", changepassword);
							 returnpage="redirect:ResetPassword";
						  
					}
				      else
				      {
				    	  model.put("patientLogin", patientLoginform);
				    	  returnpage = "redirect:patientLogin";
				      }
                username=indexForm.getPatientUserName().toLowerCase();
			  // ;
				indexForm.setUserDisplay(indexForm.getPatientUserName());
				patientage= Converter.AgeCalculation(indexForm.getPatientdob());
				
				
				
				doctorspecialization=indexForm.getDoctorspecialization();
				testvendorregistration=indexForm.getTestvendorregistration();
				user=indexForm.getUser();
				role=indexForm.getRole();
				labid=indexForm.getLabid();
				refid=indexForm.getRefid();
				userType=indexForm.getUserType();
				//allowthirdparty=indexForm.getAllowthirdparty();
				//model.put("login", logform);
			}
			}
			else{
				returnpage = "index";
				indexForm.setPatienterrormessage("Invalid User Name/Password (or) User is not Active");
				model.put("index", indexForm);
			}
			}
		
		if ((linked != null) && (linked.equals("doctorlogin")))
		{
			System.out.println("---------------dipatch inside");
			indexForm=clinicService.doctorLogin(indexForm);
			if(indexForm.getResult().equals("match"))
			{
				if(indexForm.getFirstLogin().equals("Y"))
				{
					String doctorname="";
					doctorname=indexForm.getDoctorUserName();
					httpSession.setAttribute("doctorname", doctorname);
					userType=indexForm.getUserType();
					httpSession.setAttribute("userType", userType);
					 model.put("ChangePwd", indexForm);
					    returnpage="redirect:ChangePwd";
					
				}
				if(indexForm.getFirstLogin().equals("N"))
				{
				
				      if((indexForm.getOutput()!=null) && (indexForm.getOutput().equals("Your Password has expired.Please reset the password.")))
						{
				    		
				    	   model.put("ResetPassword", changepassword);
							 returnpage="redirect:ResetPassword";
						}
				      else
				      {
				    	 
				    	  returnpage = "redirect:doctorLogin";
				    	  
				      }
	            username=indexForm.getDoctorUserName().toLowerCase();
				//
				indexForm.setUserDisplay(indexForm.getDoctorUserName());

				
				doctorspecialization=indexForm.getDoctorspecialization();
				testvendorregistration=indexForm.getTestvendorregistration();
				user=indexForm.getUser();
				role=indexForm.getRole();
				labid=indexForm.getLabid();
				refid=indexForm.getRefid();
				userType=indexForm.getUserType();
				//allowthirdparty=indexForm.getAllowthirdparty();
				//model.put("login", logform);
			}
			}
			else{
				returnpage = "index";
				indexForm.setDoctorerrormessage("Invalid User Name/Password (or) User is not Active");
				model.put("index", indexForm);
			}
			}
		
		if ((linked != null) && (linked.equals("reportlogin"))) {
			System.out.println("---------------dipatch inside");
			indexForm=clinicService.reportLogin(indexForm);
			if(indexForm.getResult().equals("match")){
				if(indexForm.getFirstLogin().equals("Y")){
					String vendorname=indexForm.getReportUserName();
					httpSession.setAttribute("vendorname", vendorname);
					userType=indexForm.getUserType();
					httpSession.setAttribute("userType", userType);
					 model.put("ChangePwd", indexForm);
					    returnpage="redirect:ChangePwd";
					
				}
				if(indexForm.getFirstLogin().equals("N")){
					httpSession.setAttribute("Num", indexForm.getFirstLogin());
				      if((indexForm.getOutput()!=null) && (indexForm.getOutput().equals("Your Password has expired.Please reset the password.")))
						{
				    	  
				    	   model.put("ResetPassword", changepassword);
							 returnpage="redirect:ResetPassword";
						  
					}
				      else
				      {
			
				    	  returnpage = "redirect:testvendorLogin";	
				      }
				username=indexForm.getReportUserName().toLowerCase();
			

				indexForm.setUserDisplay(indexForm.getReportUserName());
				
				doctorspecialization=indexForm.getDoctorspecialization();
				testvendorregistration=indexForm.getTestvendorregistration();
				user=indexForm.getUser();
				role=indexForm.getRole();
				labid=indexForm.getLabid();
				refid=indexForm.getRefid();
				userType=indexForm.getUserType();
				//allowthirdparty=indexForm.getAllowthirdparty();
				//model.put("login", logform);
			}
			}
			else{
				returnpage = "index";
				indexForm.setReporterrormessage("Invalid User Name/Password (or) User is not Active");
				model.put("index", indexForm);
			}
			}
		httpSession.setAttribute("user", user);
		httpSession.setAttribute("username", username);
		httpSession.setAttribute("labId", labid);
		httpSession.setAttribute("role", role);
		httpSession.setAttribute("referenceId", refid);
		httpSession.setAttribute("patientage", patientage);
		httpSession.setAttribute("doctorspecialization", doctorspecialization);
		httpSession.setAttribute("testvendorregistration", testvendorregistration);
		httpSession.setAttribute("userType", userType);
		//httpSession.setAttribute("allowthirdparty",allowthirdparty );
		
		System.out.println(httpSession.getAttribute("user"));
		System.out.println(httpSession.getAttribute("username"));
		System.out.println(httpSession.getAttribute("labId"));
		System.out.println(httpSession.getAttribute("role"));
		System.out.println(httpSession.getAttribute("referenceId"));
		//System.out.println(httpSession.getAttribute("patientdob"));
		System.out.println(httpSession.getAttribute("doctorspecialization"));
		System.out.println(httpSession.getAttribute("testvendorregistration"));
		System.out.println(httpSession.getAttribute("userType"));
		return returnpage;
	}
	
	
	@RequestMapping(value="/indexpatientclinicselect" , method=RequestMethod.POST)
	public @ResponseBody List LabName( @RequestParam(value="userName") String user_Name, HttpServletRequest request, Map model, ModelMap map,
			@Valid IndexForm indexform1,	@ModelAttribute(value = "log")IndexForm indexForm) throws Exception
			{
		System.out.println("****************HIT RECORD CHECK CONTROLLER***************");
			
						indexForm.setPatientUserName(user_Name);
			indexForm=clinicService.patientLoginClinicSelect(indexForm);
			
			System.out.println(indexForm.getPatientClinicallabOptions());
			
			List checkList=new ArrayList();
			
			checkList.add(indexForm);
			
				return indexForm.getPatientClinicallabOptions();
			}
	

	@RequestMapping(value="/indexdoctorclinicselect" , method=RequestMethod.POST)
	public @ResponseBody List LabsName( @RequestParam(value="docuserName") String user_Name, HttpServletRequest request, Map model, ModelMap map,
			@Valid IndexForm indexform1,	@ModelAttribute(value = "log")IndexForm indexForm) throws Exception
			{
		System.out.println("****************HIT RECORD CHECK CONTROLLER***************");
			
						indexForm.setDoctorUserName(user_Name);
			indexForm=clinicService.doctorLoginClinicSelect(indexForm);
			
			System.out.println(indexForm.getDoctorClinicallabOptions());
			
			List checkList=new ArrayList();
			

			System.out.println("List In Controller"+indexForm.getDoctorClinicallabOptions().size());
			checkList=indexForm.getDoctorClinicallabOptions();
				return checkList;
			}
	
	@RequestMapping(value="/indexreportclinicselect" , method=RequestMethod.POST)
	public @ResponseBody List LabNames( @RequestParam(value="testvendoruserName") String user_Name, HttpServletRequest request, Map model, ModelMap map,
			@Valid IndexForm indexform1,	@ModelAttribute(value = "log")IndexForm indexForm) throws Exception
			{
		System.out.println("****************HIT RECORD CHECK CONTROLLER***************");
			
						indexForm.setReportUserName(user_Name);
			indexForm=clinicService.reportLoginClinicSelect(indexForm);
			
			System.out.println(indexForm.getReportClinicallabOptions());
			
			List checkList=new ArrayList();
			
			checkList.add(indexForm);
			
				return indexForm.getReportClinicallabOptions();
			}

	@RequestMapping("/signup")
	public String SignUp(HttpServletRequest request, Map model, @ModelAttribute("signup")ClinicalLabInfoForm indexForm, ClinicalLab labmodel) throws ParseException, IOException 
	
	{
		

        
		
		
		String returnPage="signup";
		ClinicalLabInfoForm index=new ClinicalLabInfoForm();
		String dispatch=indexForm.getDispatch();
		System.out.println("-----------where is the dispatch?------------"+dispatch);
		List actflag=clinicService.getActiveFlagList();
		model.put("actflaglistvalue",actflag);
		
		if ((dispatch != null) && (dispatch.equals("signupsubmit"))) 
		{
			String remoteAddr = request.getRemoteAddr();
	        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
	        reCaptcha.setPrivateKey("6LfYJO0SAAAAAG9TU8j3RWzpYbYv9807sJyt8ZC0");

	        String challenge = request.getParameter("recaptcha_challenge_field");
	        String response = request.getParameter("recaptcha_response_field");
	        System.out.print(challenge);
	        System.out.print(response);
	        try{
	        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, response);
			if (reCaptchaResponse.isValid()==true) {
		          System.out.print("Answer was entered correctly!");
		          indexForm=clinicService.registersave(indexForm);
					indexForm=clinicService.registersaveuser(indexForm, labmodel);
					actflag=clinicService.getActiveFlagList();
	model.put("actflaglistvalue",actflag);
					
					returnPage="thankyou";
					
					ClinicalLabInfoForm index1 =new ClinicalLabInfoForm();
					System.out.println("AAAAAAAAA______________________"+indexForm.getLabName());
					System.out.println("AAAAAAAAAXXXXPPPP______________________"+index1.getLabName());
					System.out.println("Is this It????????????????????"+labmodel.getLabName());	
					
					
					String finalmail=clinicService.sendmailifsuccess(indexForm);
					
						final String username = "gaddieltech@gmail.com";
						final String password = "Gaddiel15";
				 
						Properties props = new Properties();
						props.put("mail.smtp.auth", "true");
						props.put("mail.smtp.starttls.enable", "true");
						props.put("mail.smtp.host", "smtp.gmail.com");
						props.put("mail.smtp.port", "587");
				 
						Session session = Session.getInstance(props,
								  new javax.mail.Authenticator() {
									protected PasswordAuthentication getPasswordAuthentication() {
										return new PasswordAuthentication(username, password);
									}
								  });
						 
								try {
						 
									Message message = new MimeMessage(session);
									message.setFrom(new InternetAddress("gaddieltech@gmail.com"));
									message.setRecipients(Message.RecipientType.TO,
										InternetAddress.parse(finalmail));
									message.setSubject("ECM USER DETAILS");
									message.setText("Dear User"
											+ "\n\n You are registered for ECM - online Clinical Lab Application, which can be accessed across the world from multiple devices."
											+ "\n\n Your Sign in Details:"
											+ "\n Sign in Email: "+ finalmail +""
											+ "\n Default Password: 123"
											+ "\n Use this email address when signing into all ECM services."
											+ "\n To  confirm the authenticity of your email address, please click the button below."
											+ "\n http://localhost:8090/clinikraj/index"
											+ "\n\n\n For a full introduction to ECM services, click here."
											+ "\n\n If you have any questions about your ECM Membership, please contact us."
											+ "\n\n Wishing you the very best of business,"
											+ "\n Team Gaddiel. "
											+ "\n\n This email was sent to "+ finalmail +""
											+ "\n You are receiving this email because you are a registered member of the ECM."
											+ "\n To unsubscribe from future site announcement emails, click here."
											+ "\n Read our Privacy Policy and Terms of Use.");
						 
									Transport.send(message);
						 
									System.out.println("Done");
						 
								} catch (MessagingException e) {
									throw new RuntimeException(e);
								}
					System.out.println("-----Mail Sent----");
				        model.put("signup",indexForm);	
									
				   return "thankyou";
		        } else {
		          System.out.print("Answer is wrong");
		          model.put("signup", indexForm);
		          returnPage="signup";
		        }}catch(ReCaptchaException e){
		        	e.printStackTrace();
		        	returnPage="signup";
		        }
	        
	    
			
		}
		

		
		model.put("signup", index);
		return returnPage;
	}
	
	@RequestMapping("/underConstruction")
	public String underConstruction(HttpServletRequest request, Map model)
	{
		IndexForm index=new IndexForm();
		model.put("underconstruction", index);
		return "underconstruction";
	}
	@RequestMapping("/ResetPassword")
	public String resetPassword(HttpSession httpSession,HttpServletRequest request, Map model,ChangePassword changepassword)
	{   
		IndexForm indexForm = new IndexForm();
		String result="matching";
		String returnpage="ResetPassword";
			try
			{
				 List userType=clinicService.getUserType();
				model.put("userTypeList", userType);
		System.out.println("---------------dipatch---------"+changepassword.getDispatch());
		if((changepassword.getDispatchhit()!=null) && (changepassword.getDispatchhit().equals("resetvalue"))){
			clinicService.forgotPassword(changepassword);
			//System.out.print(changepassword.getResult()+"dfsadsde3333");
			//result=changepassword.getResult();
			String matched=changepassword.getResult();
			userType=clinicService.getUserType();
			model.put("userTypeList", userType);	
			if((changepassword.getResult()!=null) && (changepassword.getResult().equals("matched"))) {	
				changepassword.setSuccessmessage("matched");
			userType=clinicService.getUserType();
			model.put("userTypeList", userType);
			 model.put("ResetPassword", changepassword);
			 returnpage= "ResetPassword";
			}
			else {
				
				System.out.print("dispatch matcheddd");
				 userType=clinicService.getUserType();
				model.put("userTypeList", userType);
				 model.put("ResetPassword", changepassword);
				 returnpage= "ResetPassword";
				}
		}
		System.out.println("---!!!!!!!----dipatch---------"+changepassword.getDispatchhitted());
		if((changepassword.getDispatchhitted()!=null) && (changepassword.getDispatchhitted().equals("resetpwdchange"))){
			//System.out.print("control hit");
	        clinicService.forgotPasswordvq(changepassword);
			//System.out.print("control hit");
		if((changepassword.getqResult().equals("print"))) {		
			System.out.print("value get");
			changepassword.setErrormessage("correct answer");
			userType=clinicService.getUserType();
			model.put("userTypeList", userType);
			 model.put("ResetPassword", changepassword);
			 returnpage= "ResetPassword";
			}
        if((changepassword.getqResult().equals("not print"))) {			
        	changepassword.setErrormessage("Enter the correct answer");
				 userType=clinicService.getUserType();
				model.put("userTypeList", userType);
				 model.put("ResetPassword", changepassword);
				 returnpage= "ResetPassword";
        }	 
		}	
		
		if((changepassword.getDispatch()!=null) && (changepassword.getDispatch().equals("resetpwd"))){	
			clinicService.forgotPasswordSave(changepassword);
			
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
		 model.put("ResetPassword", changepassword);
		return returnpage;	
	}

	/*@RequestMapping("/sendmail")
	public String showForm2(@RequestParam("mail") String mail,Map model,HttpServletRequest request,@ModelAttribute(value = "signup")ClinicalLabInfoForm  memberform1, ClinicalLab clab) throws IOException, SQLException, ClassNotFoundException, IllegalAccessException, InvocationTargetException{

	System.out.println("=---------Mail Controller has been Hit--------------");
		
	ClinicalLabInfoForm index1 =new ClinicalLabInfoForm();
	System.out.println("AAAAAAAAA______________________"+memberform1.getLabName());
	System.out.println("AAAAAAAAAXXXXPPPP______________________"+index1.getLabName());
	System.out.println("Is this It????????????????????"+clab.getLabName());	
	
	index1.setEmailId(mail);
	String finalmail=clinicService.sendmailifsuccess(memberform1);
	
		final String username = "nikjajo@gmail.com";
		final String password = "nick0411mania1989black2111";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
		 
				try {
		 
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("nikjajo@gmail.com"));
					message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(finalmail));
					message.setSubject("CLINIKRAJ USER DETAILS");
					message.setText("Dear User"
							+ "\n\n You are registered for ClinikRaj - online Clinical Lab Application, which can be accessed across the world from multiple devices."
							+ "\n\n Your Sign in Details:"
							+ "\n Sign in Email: "+ finalmail +""
							+ "\n Default Password: 123"
							+ "\n Use this email address when signing into all ClinikRaja services."
							+ "\n To  confirm the authenticity of your email address, please click the button below."
							+ "\n http://localhost:8090/clinikraj/index"
							+ "\n\n\n For a full introduction to ClinikRaja services, click here."
							+ "\n\n If you have any questions about your ClinikRaja Membership, please contact us."
							+ "\n\n Wishing you the very best of business,"
							+ "\n Team Gaddiel. "
							+ "\n\n This email was sent to "+ finalmail +""
							+ "\n You are receiving this email because you are a registered member of the ClinikRaj."
							+ "\n To unsubscribe from future site announcement emails, click here."
							+ "\n Read our Privacy Policy and Terms of Use.");
		 
					Transport.send(message);
		 
					System.out.println("Done");
		 
				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}
	System.out.println("-----Mail Sent----");
        model.put("signup",memberform1);	
					
   return "thankyou";
   }*/

	@RequestMapping("/logout")
	public String showFormSession(HttpSession httpSession, Map model,@ModelAttribute("index")IndexForm indexForm,HttpServletResponse response){
		httpSession.invalidate();
		
		
		IndexForm logform=new IndexForm();
		logform.setClinikrajlogincheck("Session Timed Out");
		model.put("index", logform);
		return "redirect:index";
	}
	
	@RequestMapping(value="/inputvalue" , method=RequestMethod.POST)
	public @ResponseBody List postofficeNo( @RequestParam(value="postno") String post_No, HttpServletRequest request, Map model, ModelMap map,
			@Valid ClinicalLabInfoForm clinicLabInfoForm) throws ParseException
			{
System.out.println("****************HIT postoffice CHECK CONTROLLER***************");		
		     List postvalue=new ArrayList();		 
		     try{
			 postvalue=clinicService.postofficePatientvalues(post_No);
		     }
		     catch(Exception e)
				{
					e.printStackTrace();
				}
		     System.out.println("size of the List"+postvalue);
		     return postvalue;
			}
	
	
}

