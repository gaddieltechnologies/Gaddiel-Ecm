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
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.clinikraj.form.IndexForm;
import org.clinikraj.form.PatientManagerForm;
import org.clinikraj.form.PatientManagerSubForm;
import org.clinikraj.form.TestVendorManagerForm;
import org.clinikraj.service.ClinicService;
import org.clinikraj.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PatientManagerController {
	private static final Logger logger = Logger.getLogger(PatientManagerController.class);
	@Autowired
	private PatientService patientService;
	
	@RequestMapping("/patientManager")
	public String patienManagerForm(HttpSession httpSession,HttpServletRequest request,HttpServletResponse response, Map model, @ModelAttribute(value ="patientManager")PatientManagerForm patientFormObject) throws ParseException{
		
System.out.println("Hit Patient Manager controller ");
try{
		
			Integer labid= (Integer) httpSession.getAttribute("labId");
			String username=(String) httpSession.getAttribute("username");

System.out.println("Hit Patient Grid View controller-----labid--------> "+labid);
System.out.println("Hit Patient Grid View controller-----username--------> "+username);
			String returnPage="patientManager";
		System.out.println(httpSession.getAttribute("labId").toString());
//PatientManagerForm patientFormObject=new PatientManagerForm();
			PatientManagerSubForm patientSubObject=new PatientManagerSubForm();
System.out.println("ON LOAD Dispatch Grid View value--------->>>"+patientFormObject.getDispatchGridView());
System.out.println("Dispatch Form Value --------->>>"+patientFormObject.getDispatch());

		List getdetails=new ArrayList();
		
		
		
		if((patientFormObject.getDispatch()!=null) && (patientFormObject.getDispatch().equals("search")))
		{
			getdetails=patientService.viewPatienDetails(patientFormObject, patientSubObject,labid,username);
			patientFormObject.setPatientDetailSubForm(getdetails);
System.out.println("GRID VIEW Controller------"+getdetails.size());
			model.put("patientManager",patientFormObject);
		}
		if((patientFormObject.getDispatch()!=null) && (patientFormObject.getDispatch().equals("view")))
		{
			try{String viewid=patientFormObject.getDispatchid();
System.out.println("VIWE CONTROLLER........>>>"+viewid);
			patientFormObject=patientService.viewPatient(viewid);
			
			List preffcontactlist=patientService.Prefferedcontact();
			model.put("prefferedlisttype",preffcontactlist);
			
			List smsList=patientService.getSmsList();
			model.put("smslisttype", smsList);
			
			List sexlist=patientService.sexList();
			model.put("sexTypeList", sexlist);
			
			List drList=patientService.doctorList();
			model.put("drname", drList);
			
			List vnrList=patientService.vendorList();
			model.put("vnname", vnrList);
			
			model.put("patientDetailView",patientFormObject);
			returnPage="PatientDetailView";}
			catch(NullPointerException e){
				e.printStackTrace();
				IndexForm logform=new IndexForm();
				model.put("index", logform);
				return "sessionexpire";}
		}
		
		if((patientFormObject.getDispatch()!=null) && (patientFormObject.getDispatch().equals("delete")))
		{
			String delid=patientFormObject.getDispatchid(); 	
System.out.println(" DELETE CONTROLLER VALVE.......>>>"+delid);
			patientService.deletePatient(delid);
			model.put("patientManager",patientFormObject);
			patientFormObject.setDispatchGridView("search");
			returnPage="patientManager";
						
		}
		if((patientFormObject.getDispatch()!=null) && (patientFormObject.getDispatch().equals("new")))		
		{
			try{System.out.println("---------------new@@@@@@@@@@@");
			PatientManagerForm patientformm=new PatientManagerForm();
			
			List preffcontactlist=patientService.Prefferedcontact();
			model.put("prefferedlisttype",preffcontactlist);
			
			List smsList=patientService.getSmsList();
			model.put("smslisttype", smsList);
			
			List sexlist=patientService.sexList();
			model.put("sexTypeList", sexlist);
			
			List drList=patientService.doctorList();
			model.put("drname", drList);
			
			List vnrList=patientService.vendorList();
			model.put("vnname", vnrList);
			
			model.put("PatienManagerAdd",patientformm);
			returnPage="patienManagerAdd";}
			catch(NullPointerException e){
				e.printStackTrace();
				IndexForm logform=new IndexForm();
				model.put("index", logform);
				return "sessionexpire";}
		}
		if((patientFormObject.getDispatch()!=null)&&(patientFormObject.getDispatch().equals("Save")))
		{
System.out.println("---------------------------CONTROLLER Dispatch valure------"+patientFormObject.getDispatch());
			
			
      patientService.addPatienDetails(patientFormObject,labid,username);
			//patientaddobject.setDispatch(patientaddobject.getDispatch());
      
      List preffcontactlist=patientService.Prefferedcontact();
		model.put("prefferedlisttype",preffcontactlist);
		
		List smsList=patientService.getSmsList();
		model.put("smslisttype", smsList);
		
		List sexlist=patientService.sexList();
		model.put("sexTypeList", sexlist);
		
		List drList=patientService.doctorList();
		model.put("drname", drList);
		
		List vnrList=patientService.vendorList();
		model.put("vnname", vnrList);
		
			model.put("PatienManagerAdd",patientFormObject);
			returnPage="patienManagerAdd";
		}
		if((patientFormObject.getDispatch()!=null)&&(patientFormObject.getDispatch().equals("Save&New")))
		{
System.out.println("----------------------------Dispatch valure------"+patientFormObject.getDispatch());
			PatientManagerForm patientSaveNewObject=new PatientManagerForm();
			patientService.addPatienDetails(patientFormObject,labid,username);
			//patientaddobject.setDispatch(patientaddobject.getDispatch());
			
			List preffcontactlist=patientService.Prefferedcontact();
			model.put("prefferedlisttype",preffcontactlist);
			
			List smsList=patientService.getSmsList();
			model.put("smslisttype", smsList);
			
			List sexlist=patientService.sexList();
			model.put("sexTypeList", sexlist);
			
			List drList=patientService.doctorList();
			model.put("drname", drList);
			
			List vnrList=patientService.vendorList();
			model.put("vnname", vnrList);
			
			model.put("PatienManagerAdd",patientSaveNewObject);
			returnPage="patienManagerAdd";
		}
		if((patientFormObject.getDispatch()!=null)&&(patientFormObject.getDispatch().equals("Save&Close")))
		{
System.out.println("----------------------------Dispatch valure------"+patientFormObject.getDispatch());
			patientService.addPatienDetails(patientFormObject,labid,username);
			//patientaddobject.setDispatch(patientaddobject.getDispatch());
			PatientManagerForm patientSaveNewObjects=new PatientManagerForm();
			 model.put("patientManager",patientSaveNewObjects);
		}
		if((patientFormObject.getDispatch()!=null)&&(patientFormObject.getDispatch().equals("createuser")))
		{
			String patientId=patientFormObject.getPatientId().toString();
			String patientName=patientService.patientUser(patientId);
			patientFormObject.setEmailId(patientName);
			patientService.createPatienAsUser(patientFormObject, labid, username);
			model.put("patientManager",patientFormObject);			
		}
		return returnPage;
	}
catch(NullPointerException e){
	e.printStackTrace();
	IndexForm logform=new IndexForm();
	model.put("index", logform);
	return "sessionexpire";
}}
	

	@RequestMapping(value="/postofficePatient/inputvalue" , method=RequestMethod.POST)
	public @ResponseBody List postofficeNo( @RequestParam(value="postno") String post_No, HttpServletRequest request, Map model, ModelMap map,
			@Valid PatientManagerForm patientForm) throws ParseException
			{
System.out.println("****************HIT postoffice CHECK CONTROLLER***************");		
		     List postofficevalue=new ArrayList();		 
		     try{
			 postofficevalue=patientService.postofficePatienvalues(post_No);
		     }
		     catch(Exception e)
				{
					e.printStackTrace();
				}
		     System.out.println("size of the List"+postofficevalue);
		     return postofficevalue;
			}
	
	
	@RequestMapping("/view")
	public String patientview( @RequestParam(value="idvalue") String viewid,HttpServletRequest request, Map model, @ModelAttribute(value ="patientDetailView")PatientManagerForm patientFormObject) throws ParseException{
		
System.out.println("HIT View PAGE");
		PatientManagerForm viewObject=new PatientManagerForm();
		
		viewObject=patientService.viewPatient(viewid);
		model.put("patientDetailView",viewObject);
		return "PatientDetailView";
		
	}
	
	
}
