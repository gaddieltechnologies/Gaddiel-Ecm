package org.clinikraj.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.clinikraj.form.DoctorLoginForm;
import org.clinikraj.form.IndexForm;
import org.clinikraj.service.DoctorService;
import org.clinikraj.service.TestVendorSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestvendorLoginController {
	private static final Logger logger = Logger.getLogger(TestvendorLoginController.class);
	@Autowired
	private TestVendorSerivce testVendorSerivce;
	
	
	@RequestMapping("/testvendorLogin")
	public String testvendorLoginform(HttpSession httpSession,HttpServletRequest request,HttpServletResponse response, Map model, @ModelAttribute("testvendorLogin")DoctorLoginForm doctorLoginform) throws ParseException{
		try{
		
		String LabId=httpSession.getAttribute("labId").toString();
		String username=httpSession.getAttribute("username").toString();
		String refId=httpSession.getAttribute("referenceId").toString();
		String returnPage="testvendorLogin";
		String output=testVendorSerivce.LoginForm(username);
		
				   doctorLoginform.setAlertMessage(output);			    
				   model.put("testvendorLogin",doctorLoginform);
			
		List getdetails=new ArrayList();
		
		
		
		if((doctorLoginform.getSearchdispatch()!=null) && (doctorLoginform.getSearchdispatch().equals("search")))
		{
			getdetails=testVendorSerivce.viewVendorLoginDetails(refId,doctorLoginform, LabId);
			doctorLoginform.setDoctorLoginSubForm(getdetails);
			
			model.put("testvendorLogin",doctorLoginform);
		}
		if((doctorLoginform.getSearchdispatch()!=null) && (doctorLoginform.getSearchdispatch().equals("views"))){
			try{String viewid=doctorLoginform.getDispatch();
		
			doctorLoginform=testVendorSerivce.testVendorOrderDetails(LabId, doctorLoginform, viewid);
			getdetails=testVendorSerivce.TestVendorOrdergridView(doctorLoginform,LabId);
			doctorLoginform.setDoctorLoginSubForm(getdetails);
			
			model.put("testVendorView",doctorLoginform);
			returnPage="testVendorView";}
			catch(NullPointerException e){
				e.printStackTrace();
				IndexForm logform=new IndexForm();
				model.put("index", logform);
				return "sessionexpire";
			}
		}
			if((doctorLoginform.getSearchdispatch()!=null) && (doctorLoginform.getSearchdispatch().equals("view"))){
				
				try{String orderId=doctorLoginform.getDispatch();
				
				String orderTestId=doctorLoginform.getDispatchTestId();
				doctorLoginform=testVendorSerivce.testVendorOrderDetails(LabId, doctorLoginform, orderId);
				getdetails=testVendorSerivce.TestVendorOrdergridView(doctorLoginform, LabId);
				doctorLoginform.setDoctorLoginSubForm(getdetails);
				doctorLoginform=testVendorSerivce.TestVendorOrderViews(doctorLoginform, orderTestId, LabId);
			
				model.put("testVendorView",doctorLoginform);
				returnPage="testVendorView";}
				catch(NullPointerException e){
					e.printStackTrace();
					IndexForm logform=new IndexForm();
					model.put("index", logform);
					return "sessionexpire";
				}
			}
		
		return returnPage;}
		catch(NullPointerException e){
			e.printStackTrace();
			IndexForm logform=new IndexForm();
			model.put("index", logform);
			return "sessionexpire";
		}
	}
}
