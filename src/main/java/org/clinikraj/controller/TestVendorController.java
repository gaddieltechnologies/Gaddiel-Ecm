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
import org.clinikraj.form.DoctorForm;
import org.clinikraj.form.IndexForm;
import org.clinikraj.form.PatientManagerForm;
import org.clinikraj.form.PatientManagerSubForm;
import org.clinikraj.form.TestVendorManagerForm;
import org.clinikraj.form.TestVendorManagerSubForm;

import org.clinikraj.service.ClinicService;
import org.clinikraj.service.TestVendorSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestVendorController {
	private static final Logger logger = Logger.getLogger(TestVendorController.class);
	@Autowired
	private TestVendorSerivce testVendorSerivce;
	
	@RequestMapping("/refferdLabIfo")	
		public String refferdLabIfoForm(HttpSession httpSession,HttpServletRequest request, HttpServletResponse response,Map model,@Valid TestVendorManagerForm testvendorobject, @ModelAttribute(value ="refferdLabIfo")TestVendorManagerForm vendorFormObject) throws ParseException{
			
			System.out.println("Hit Vendor Manager controller ");	
			try{
			Integer labid= (Integer) httpSession.getAttribute("labId");
			String username=(String) httpSession.getAttribute("username");
			
			String returnPage="refferdLabIfo";
			TestVendorManagerSubForm vendorSubObject=new TestVendorManagerSubForm();			
			System.out.println(httpSession.getAttribute("labId").toString());
			System.out.println("------------------tieuplistvalue"+testvendorobject.getTieuplistvalue());				
			model.put("tieuplistvalue", testvendorobject.getTieuplistvalue());
			List getdetails=new ArrayList();
			
			
			if((vendorFormObject.getDispatch()!=null) && (vendorFormObject.getDispatch().equals("search")))
			{
			   getdetails=testVendorSerivce.viewvendorDetails(vendorFormObject, vendorSubObject,labid,username);
			   vendorFormObject.setVendorDetailSubForm(getdetails);
			   System.out.println("Controller------"+getdetails.size());
			  // vendorFormObject.setDispatchGridView("Empty");
			   model.put("refferdLabIfo",vendorFormObject);
			}
			if((vendorFormObject.getDispatch()!=null) && (vendorFormObject.getDispatch().equals("view")))
			{
				try{String viewid=vendorFormObject.getDispatchid();
				System.out.println("Vendor id "+viewid);
				vendorFormObject=testVendorSerivce.viewVendor(viewid,labid,username);	
				List preffcontactlist=testVendorSerivce.Prefferedcontact();
				//vendorFormObject.setDispatchGridView("Empty");
				List tieUpList=testVendorSerivce.getTieupList();
				List smsList=testVendorSerivce.getSmsList();
				
				model.put("smslisttype", smsList);
				model.put("tieuplistvalue", tieUpList);
				model.put("prefferedlisttype",preffcontactlist);
				
				model.put("vendorDetailView",vendorFormObject);
				returnPage="refferdLabIfoView";}
				catch(NullPointerException e){
					e.printStackTrace();
					IndexForm logform=new IndexForm();
					model.put("index", logform);
					return "sessionexpire";
				}
			}
			if((vendorFormObject.getDispatch()!=null) && (vendorFormObject.getDispatch().equals("new"))){
				System.out.println("---------------new@@@@@@@@@@@");
				try{TestVendorManagerForm vendorformm=new TestVendorManagerForm();
				List tieUpList=testVendorSerivce.getTieupList();				
				List smsList=testVendorSerivce.getSmsList();				
				List preffcontactlist=testVendorSerivce.Prefferedcontact();
				
				model.put("tieuplistvalue", tieUpList);
				model.put("smslisttype", smsList);
				model.put("prefferedlisttype",preffcontactlist);
				
				model.put("refferdLabIfoAdd",vendorformm);
				returnPage="refferdLabIfoAdd";}
				catch(NullPointerException e){
					e.printStackTrace();
					IndexForm logform=new IndexForm();
					model.put("index", logform);
					return "sessionexpire";
				}
			}
			if((vendorFormObject.getDispatch()!=null) && (vendorFormObject.getDispatch().equals("delete")))
			{
				String delid=vendorFormObject.getDispatchid(); 				
			    testVendorSerivce.deleteVendor(delid,labid,username);
				model.put("refferdLabIfo",vendorFormObject);
						
			}
			 if((vendorFormObject.getDispatch()!=null)&&(vendorFormObject.getDispatch().equals("save")))
			    {
				//Save function goes here
				 System.out.println("Hit save r ");
				 vendorFormObject=testVendorSerivce.save(vendorFormObject,labid,username);				
				 //testvendormanageroj.setDispatch(testvendormanagerformobject.getDispatch());
				 List tieUpList=testVendorSerivce.getTieupList();				
					List smsList=testVendorSerivce.getSmsList();				
					List preffcontactlist=testVendorSerivce.Prefferedcontact();
					
					model.put("tieuplistvalue", tieUpList);
					model.put("smslisttype", smsList);
					model.put("prefferedlisttype",preffcontactlist);
					
				 model.put("refferdLabIfoAdd",vendorFormObject);
				 returnPage="refferdLabIfoAdd";
			    }
			 if((vendorFormObject.getDispatch()!=null)&&(vendorFormObject.getDispatch().equals("save&new")))
			    {
				//Save function goes here
				 System.out.println("Hit save r ");
				 TestVendorManagerForm testvendormanageroj=new TestVendorManagerForm();
				 testVendorSerivce.save(vendorFormObject,labid,username);
				// testvendormanageroj.setDispatch(testvendormanagerformobject.getDispatch());
				 List tieUpList=testVendorSerivce.getTieupList();				
					List smsList=testVendorSerivce.getSmsList();				
					List preffcontactlist=testVendorSerivce.Prefferedcontact();
					
					model.put("tieuplistvalue", tieUpList);
					model.put("smslisttype", smsList);
					model.put("prefferedlisttype",preffcontactlist);
					
				 model.put("refferdLabIfoAdd",testvendormanageroj);
				 returnPage="refferdLabIfoAdd";
			    }	
			  if((vendorFormObject.getDispatch()!=null)&&(vendorFormObject.getDispatch().equals("save&close")))
			    {
				//Save function goes here
				 System.out.println("Hit save r ");
				 testVendorSerivce.save(vendorFormObject,labid,username);
				 TestVendorManagerForm testvendormanager=new TestVendorManagerForm();
				// testvendormanageroj.setDispatch(testvendormanagerformobject.getDispatch());
				 model.put("refferdLabIfo",testvendormanager);				 
			    }	
			    if((vendorFormObject.getDispatch()!=null)&&(vendorFormObject.getDispatch().equals("createuser")))
			    {
			    				    	 
			    	 String vendorid=vendorFormObject.getTestVendorId().toString();
			    	 String vendorname=testVendorSerivce.vendoruser(vendorid);
			    	 vendorFormObject.setEmailId(vendorname);
			    	 
			    	 testVendorSerivce.createuservendor(vendorFormObject,labid,username);			    	
			    	 model.put("refferdLabIfo",vendorFormObject);			    	
			    }
		return returnPage;}
			catch(NullPointerException e){
				e.printStackTrace();
				IndexForm logform=new IndexForm();
				model.put("index", logform);
				return "sessionexpire";
			}
	}
	
/*	@RequestMapping("/refferdLabIfoAdd")
	public String refferdLabIfoAddForm(HttpSession httpSession,HttpServletRequest request, Map model,@ModelAttribute(value="refferdLabIfoAdd")TestVendorManagerForm testvendormanagerformobject,String EmailId) throws ParseException
	{
				
		System.out.println("Hit testvendor Manager Add controller ");
		Integer labid= (Integer) httpSession.getAttribute("labId");
		String username=(String) httpSession.getAttribute("username");
	
		String returnPage="refferdLabIfoAdd";
		List prefcontact=new ArrayList();
		prefcontact=testVendorSerivce.Prefferedcontact();
		model.put("prefferedlisttype", prefcontact);
		List tieUpList=testVendorSerivce.getTieupList();
		List smsList=testVendorSerivce.getSmsList();
		
		model.put("smslisttype", smsList);
		model.put("tieuplistvalue", tieUpList);
		String dispatch;		
		//TestVendorManagerForm testvendormanageroj=new TestVendorManagerForm();
		dispatch=testvendormanagerformobject.getDispatch();			
		model.put("refferdLabIfoAdd",testvendormanagerformobject);
	   
	   
	  
	    
		return returnPage;
	}*/
	
	@RequestMapping(value="/postoffice/inputvalue" , method=RequestMethod.POST)
	public @ResponseBody List postofficeNo( @RequestParam(value="postno") String post_No, HttpServletRequest request, Map model, ModelMap map,
			@Valid TestVendorManagerForm vendorform) throws ParseException
			{
		System.out.println("****************HIT postoffice CHECK CONTROLLER***************");		
		     List postofficevalue=new ArrayList();		 
		     try{
			 postofficevalue=testVendorSerivce.postofficevalues(post_No);
		     }
		     catch(Exception e)
				{
					e.printStackTrace();
				}
			 System.out.println("size of the List"+postofficevalue);
		     return postofficevalue;
			}

	
		
}
