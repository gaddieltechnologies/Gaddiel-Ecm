package org.clinikraj.controller;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;

import org.clinikraj.form.ClinicalLabInfoForm;
import org.clinikraj.form.DoctorForm;
import org.clinikraj.form.DoctorSubForm;
import org.clinikraj.form.IndexForm;
import org.clinikraj.form.PatientManagerForm;
import org.clinikraj.service.ClinicService;
import org.clinikraj.service.DoctorService;
import org.clinikraj.dao.ClinicDaoImpl;
import org.clinikraj.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller

public class DoctorManageController {
	private static final Logger logger = Logger.getLogger(DoctorManageController.class);
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping("/doctorManager")
	public String doctorLabform(HttpSession httpSession,HttpServletRequest request,HttpServletResponse response, Map model, @ModelAttribute("doctorManager")DoctorForm doctoform)throws ParseException{
	try{
		
		DoctorSubForm subdoctor=new DoctorSubForm();
		String username=httpSession.getAttribute("username").toString();
		String LabId=httpSession.getAttribute("labId").toString();
		List doctordetails=new ArrayList();
		
		
		String returnPage="doctorManager";
		
		System.out.println(httpSession.getAttribute("labId").toString());
		
		if((doctoform.getDispatch()!=null) && (doctoform.getDispatch().equals("search")))
		{
			
		doctordetails = doctorService.doctorform(doctoform, subdoctor, LabId);
		doctoform.setDoctorDetailSubForm(doctordetails);
		model.put("doctorManager",doctoform);
		}
		if((doctoform.getDispatch()!=null) && (doctoform.getDispatch().equals("views"))){
			try{
			String viewid=doctoform.getDispatchs();
			doctoform=doctorService.doctorView(viewid);
			List tieUpList=doctorService.getTieupList();
			model.put("tieuplistvalue", tieUpList);
			List smsList=doctorService.getSmsList();
			model.put("smslisttype", smsList);
			List prefcontact=doctorService.PrefferedDoctorcontacts();
			model.put("prefferedlisttype", prefcontact);
			List spcidoctor=doctorService.Specilizationdoctor();
			model.put("specilizationlisttype", spcidoctor);
			model.put("doctorManagerView",doctoform);
			returnPage="doctorManagerView";}
			catch(NullPointerException e){
				e.printStackTrace();
				IndexForm logform=new IndexForm();
				model.put("index", logform);
				return "sessionexpire";}
		}
		if((doctoform.getDispatch()!=null) && (doctoform.getDispatch().equals("new"))){
		try{
			DoctorForm doctorformm=new DoctorForm();
			List tieUpList=doctorService.getTieupList();
			model.put("tieuplistvalue", tieUpList);
			List smsList=doctorService.getSmsList();
			model.put("smslisttype", smsList);
			List prefcontact=doctorService.PrefferedDoctorcontacts();
			model.put("prefferedlisttype", prefcontact);
			List spcidoctor=doctorService.Specilizationdoctor();
			model.put("specilizationlisttype", spcidoctor);
			model.put("doctorManagerAdd",doctorformm);
			returnPage="doctorManagerAdd";}
		catch(NullPointerException e){
			e.printStackTrace();
			IndexForm logform=new IndexForm();
			model.put("index", logform);
			return "sessionexpire";}
		}
		if((doctoform.getDispatch()!=null) && (doctoform.getDispatch().equals("save"))){
		      
		      String output=doctorService.doctorAdd(username, LabId, doctoform);
		      if(output!="Record already exists")
				{
		    	  doctoform.setSuccessMessage(output);
					model.put("doctorManagerAdd",doctoform);	
				}
				
		         doctoform.setErrorMessage(output);
		       List tieUpList=doctorService.getTieupList();
		      doctoform.setTieuplistvalue(tieUpList);
				model.put("tieuplistvalue", tieUpList);
				List smsList=doctorService.getSmsList();
				model.put("smslisttype", smsList);
				List prefcontact=doctorService.PrefferedDoctorcontacts();
				model.put("prefferedlisttype", prefcontact);
				List spcidoctor=doctorService.Specilizationdoctor();
				model.put("specilizationlisttype", spcidoctor);
		      model.put("doctorManagerAdd",doctoform);
		    	returnPage="doctorManagerAdd";
		  }
		if((doctoform.getDispatch()!=null) && (doctoform.getDispatch().equals("save&new"))){
		
			String output=doctorService.doctorAdd(username,LabId,doctoform);
			doctoform.setSuccessMessage(output);
			   if(output!="Record already exists")
				{
		    	  doctoform.setSuccessMessage(output);
					model.put("doctorManagerAdd",doctoform);	
				}
				
		         doctoform.setErrorMessage(output);
			DoctorForm doctorformm=new DoctorForm();
			List tieUpList=doctorService.getTieupList();
			model.put("tieuplistvalue", tieUpList);
			List smsList=doctorService.getSmsList();
			model.put("smslisttype", smsList);
			List prefcontact=doctorService.PrefferedDoctorcontacts();
			model.put("prefferedlisttype", prefcontact);
			List spcidoctor=doctorService.Specilizationdoctor();
			model.put("specilizationlisttype", spcidoctor);
			model.put("doctorManagerAdd",doctorformm);
			returnPage="doctorManagerAdd";
			
		   
		}
		if((doctoform.getDispatch()!=null) && (doctoform.getDispatch().equals("save&close"))){
		
			String output=doctorService.doctorAdd(username,LabId,doctoform);
			   if(output!="Record already exists")
				{
		    	  doctoform.setSuccessMessage(output);
					model.put("doctorManagerAdd",doctoform);	
				}
				
		         doctoform.setErrorMessage(output);
			doctoform.setSuccessMessage(output);
			DoctorForm doctorform=new DoctorForm();
			model.put("doctorManager",doctorform);
	  	}
		if((doctoform.getDispatch()!=null) && (doctoform.getDispatch().equals("createuser"))){
		
			String doctorId=doctoform.getDoctorId().toString();
			String doctname=doctorService.addDocUser(doctorId);
			doctoform.setEmailId(doctname);
			doctorService.addUser(username, doctoform, LabId);
			model.put("doctorManager",doctoform);
		}
		return returnPage;}
	catch(NullPointerException e){
		e.printStackTrace();
		IndexForm logform=new IndexForm();
		model.put("index", logform);
		return "sessionexpire";
	}
	}
	@RequestMapping("/views")
	public String doctorView( @RequestParam(value="idvalue") String viewid,HttpServletRequest request, Map model, @ModelAttribute(value ="doctorManagerView")DoctorForm doctorForm) throws ParseException{
		System.out.print("ok");
		try{DoctorForm doctorforms=new DoctorForm();
		doctorforms = doctorService.doctorView(viewid);
	
	
		model.put("doctorManagerView",doctorforms);
		
		return "doctorManagerView";}
		catch(NullPointerException e){
			e.printStackTrace();
			IndexForm logform=new IndexForm();
			model.put("index", logform);
			return "sessionexpire";
		}
	}
	@RequestMapping(value="/postofficeDoctor/inputvalue" , method=RequestMethod.POST)
	public @ResponseBody List postofficeNo( @RequestParam(value="postno") String post_No, HttpServletRequest request, Map model, ModelMap map,
			@Valid DoctorForm doctorForm) throws ParseException
			{
			
		     List postofficevalue=new ArrayList();		 
		     try{
			 postofficevalue=doctorService.postofficedoctor(post_No);
		     }
		     catch(Exception e)
				{
					e.printStackTrace();
				}
			
		     return postofficevalue;
			}
}
