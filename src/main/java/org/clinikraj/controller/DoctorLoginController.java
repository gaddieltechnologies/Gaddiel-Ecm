package org.clinikraj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.clinikraj.form.DoctorForm;
import org.clinikraj.form.DoctorLoginForm;
import org.clinikraj.form.DoctorLoginSubForm;
import org.clinikraj.form.DoctorTestOrderForm;
import org.clinikraj.form.IndexForm;
import org.clinikraj.form.PatientLoginForm;
import org.clinikraj.form.PatientManagerForm;
import org.clinikraj.form.PatientManagerSubForm;
import org.clinikraj.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DoctorLoginController {
	private static final Logger logger = Logger.getLogger(DoctorLoginController.class);
	@Autowired
	private DoctorService doctorService;
	

	@RequestMapping("/doctorLogin")
public String doctorLoginviewForm(HttpSession httpSession, HttpServletResponse response, HttpServletRequest request, Map model, @ModelAttribute("doctorLogin")DoctorLoginForm doctorLoginform) throws ParseException{

		IndexForm indexform=new IndexForm();
		System.out.println(indexform.getOutput());
		DoctorLoginForm doctorfomboj=new DoctorLoginForm();

		System.out.println("Hit Patient Manager controller ");
		try{
		
		DoctorLoginSubForm doctorLoginsubForm=new DoctorLoginSubForm();
		DoctorTestOrderForm doctortestForm=new DoctorTestOrderForm();
		String LabId=httpSession.getAttribute("labId").toString();
		String username=httpSession.getAttribute("username").toString();
		String refId=httpSession.getAttribute("referenceId").toString();
		doctorLoginform.setDispatchhit("start");
		   
		 String returnPage="doctorLogin";
		
		List getdetails=new ArrayList();

		String output=doctorService.LoginForm(username);
		   doctorLoginform.setAlertMessage(output);					   
		   model.put("doctorLogin",doctorLoginform);
  
		if((doctorLoginform.getSearchdispatch()!=null) && (doctorLoginform.getSearchdispatch().equals("search")))
		{ 
			System.out.println(doctorLoginform.getSearchdispatch()+"search");
			getdetails=doctorService.viewDoctorLoginDetails(doctorLoginform,LabId,refId);
			doctorLoginform.setDoctorLoginSubForm(getdetails);
			
			model.put("doctorLogin",doctorLoginform);
		}

		if((doctorLoginform.getSearchdispatch()!=null) && (doctorLoginform.getSearchdispatch().equals("views"))){
			try{
			String orderId=doctorLoginform.getDispatch();
			System.out.println("Patient id "+orderId);
			doctorLoginform=doctorService.DoctortestOrderDetails(LabId, doctorLoginform, orderId);
			getdetails=doctorService.DoctortestOrdergridView(LabId, doctorLoginform);
			doctorLoginform.setDoctorLoginSubForm(getdetails);
		
			model.put("doctortestOrderView",doctorLoginform);
			returnPage="doctortestOrderView";}
			catch(NullPointerException e){
				e.printStackTrace();
				IndexForm logform=new IndexForm();
				model.put("index", logform);
				return "sessionexpire";}
		}
		if((doctorLoginform.getSearchdispatch()!=null) && (doctorLoginform.getSearchdispatch().equals("view"))){
			try{
			String orderId=doctorLoginform.getDispatch();
			System.out.println("order id "+orderId);
			String orderTestId=doctorLoginform.getDispatchTestId();
			doctorLoginform=doctorService.DoctortestOrderDetails(LabId, doctorLoginform, orderId);
			getdetails=doctorService.DoctortestOrdergridView(LabId, doctorLoginform);
			doctorLoginform.setDoctorLoginSubForm(getdetails);
			doctorLoginform=doctorService.DoctortestOrderViews(doctorLoginform,orderTestId,LabId);
		
			model.put("doctortestOrderView",doctorLoginform);
			returnPage="doctortestOrderView";}
			catch(NullPointerException e){
				e.printStackTrace();
				IndexForm logform=new IndexForm();
				model.put("index", logform);
				return "sessionexpire";}
		}
		 
		
		  return returnPage;}
		catch(NullPointerException e){
			e.printStackTrace();
			IndexForm logform=new IndexForm();
			model.put("index", logform);
			return "sessionexpire";}
	}
	
}
