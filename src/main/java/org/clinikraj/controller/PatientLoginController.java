package org.clinikraj.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.util.IOUtils;
import org.clinikraj.dao.ClinicDao;
import org.clinikraj.form.DoctorLoginForm;
import org.clinikraj.form.DoctorLoginSubForm;
import org.clinikraj.form.DoctorTestOrderForm;
import org.clinikraj.form.IndexForm;
import org.clinikraj.form.PatientLoginForm;
import org.clinikraj.form.PatientLoginSubForm;
import org.clinikraj.service.ClinicService;
import org.clinikraj.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatientLoginController {
	private static final Logger logger = Logger.getLogger(PatientLoginController.class);
	@Autowired
	private PatientService patientService;

	@RequestMapping("/patientLogin")

	public String patientLoginform(HttpSession httpSession,HttpServletRequest request,HttpServletResponse response, Map model, @ModelAttribute("patientLogin")PatientLoginForm patientLoginform) throws ParseException{
System.out.println("Hit Patient Manager controller ");

		try{
	PatientLoginSubForm patientLoginsubForm=new PatientLoginSubForm();
		String LabId=httpSession.getAttribute("labId").toString();
		String username=httpSession.getAttribute("username").toString();	
		String refId=httpSession.getAttribute("referenceId").toString();  
		String returnPage="patientLogin";
		List getdetails=new ArrayList();

	   String output=patientService.LoginFormPatient(username);
			   patientLoginform.setAlertMessage(output);					   
			   model.put("patientLogin",patientLoginform);
	
		if((patientLoginform.getSearchdispatch()!=null) && (patientLoginform.getSearchdispatch().equals("search")))
		{
			getdetails=patientService.viewPatientLoginDetails(patientLoginform, LabId,refId);
			System.out.println(httpSession.getAttribute("refId"));
			patientLoginform.setPatientLoginSubForm(getdetails);
			System.out.println("Controller------"+getdetails.size());
			model.put("patientLogin",patientLoginform);

		}

		if((patientLoginform.getSearchdispatch()!=null) && (patientLoginform.getSearchdispatch().equals("views"))){
			try{
				String orderId=patientLoginform.getDispatch();
			
			System.out.println("Patient id "+orderId);
			patientLoginform=patientService.PatienttestOrderDetails(LabId, patientLoginform, orderId);
			getdetails=patientService.PatienttestOrdergridView(LabId, patientLoginform);
			patientLoginform.setPatientLoginSubForm(getdetails);
			System.out.println("printSSSs"+patientLoginform.getPatientLoginSubForm().size());
			model.put("patienttestOrderView",patientLoginform);
			returnPage="patienttestOrderView";}
			catch(NullPointerException e){
				e.printStackTrace();
				IndexForm logform=new IndexForm();
				model.put("index", logform);
				return "sessionexpire";}
		}
          if((patientLoginform.getSearchdispatch()!=null) && (patientLoginform.getSearchdispatch().equals("view"))){
			try{
			String orderId=patientLoginform.getDispatch();
		
			String orderTestId=patientLoginform.getDispatchTestId();
			patientLoginform=patientService.PatienttestOrderDetails(LabId, patientLoginform, orderId);
			getdetails=patientService.PatienttestOrdergridView(LabId, patientLoginform);
			patientLoginform.setPatientLoginSubForm(getdetails);
			patientLoginform=patientService.patienttestOrderViews(patientLoginform, orderTestId, LabId);

			model.put("patienttestOrderView",patientLoginform);
			returnPage="patienttestOrderView";}
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
			return "sessionexpire";
		}
	}

}

