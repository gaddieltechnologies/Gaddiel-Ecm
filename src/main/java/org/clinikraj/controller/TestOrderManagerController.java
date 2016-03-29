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
import org.clinikraj.form.IndexForm;
import org.clinikraj.form.TestOrderManagerForm;
import org.clinikraj.form.TestOrderManagerSubForm;
import org.clinikraj.form.TestVendorManagerForm;
import org.clinikraj.service.ClinicService;
import org.clinikraj.service.TestOrderManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestOrderManagerController {
	private static final Logger logger = Logger.getLogger(TestOrderManagerController.class);
	@Autowired
	private TestOrderManagerService testOrderManagerService;
	
	@RequestMapping("/testOrderManager")
	public String testOrderForm(HttpSession httpSession,HttpServletRequest request,HttpServletResponse response, Map model, @ModelAttribute(value ="testOrderManager")TestOrderManagerForm testorderFormObject) throws ParseException
	{	
		System.out.println("Hit Test Order Manager controller ");
		try{
		
		Integer labid= (Integer) httpSession.getAttribute("labId");
		String username=(String) httpSession.getAttribute("username");
		String LabId=httpSession.getAttribute("labId").toString();

		String returnPage="testOrderManager";
		System.out.println(httpSession.getAttribute("labId").toString());
		List getdetails=new ArrayList();
		TestOrderManagerSubForm ordersubobject=new TestOrderManagerSubForm();
		List doctor=testOrderManagerService.DoctorList();
	    List vendor=testOrderManagerService.VendorListdetails();
	    
		 
		     model.put("listdoctorname",doctor);		   
		     model.put("listvendorname", vendor);
			 model.put("testOrderManager",testorderFormObject);
			 
			
		
		if((testorderFormObject.getDispatchGridView()!=null) && (testorderFormObject.getDispatchGridView().equals("search")))
		{
		   getdetails=testOrderManagerService.viewtestorderDetails(testorderFormObject, ordersubobject,labid,username);
		   testorderFormObject.setTestOrderManagerrDetailSubForm(getdetails);		 
		   //testorderFormObject.setDispatchGridView("Empty");		   
		   model.put("testOrderManager",testorderFormObject);		   
		}
		if((testorderFormObject.getDispatchGridView()!=null) && (testorderFormObject.getDispatchGridView().equals("patientsearch")))
		{
			getdetails=testOrderManagerService.viewpatientorderDetails(testorderFormObject, ordersubobject, labid, username);
			testorderFormObject.setTestOrderManagerrDetailSubForm(getdetails);
		//	testorderFormObject.setDispatchGridView("Empty");	
			 model.put("testOrderManager",testorderFormObject);	
		}

	
		if((testorderFormObject.getDispatchGridView()!=null) && (testorderFormObject.getDispatchGridView().equals("views")))
		{testorderFormObject.setFlag("disable");
			try{
				testorderFormObject.setFlag("disable");
			String orderId=testorderFormObject.getDispatch();
			String patientId=testorderFormObject.getDispatchPatientId();
			testorderFormObject=testOrderManagerService.testOrderDetails(LabId, testorderFormObject, orderId);
			
			getdetails=testOrderManagerService.testOrdergrid(LabId, testorderFormObject);
			testorderFormObject.setFlag("disable");
			
			testorderFormObject.setTestOrderManagerrDetailSubForm(getdetails);

			model.put("testOrderManagerView",testorderFormObject);
			
			returnPage="testOrderManagerView";}
			catch(NullPointerException e){
				e.printStackTrace();
				IndexForm logform=new IndexForm();
				model.put("index", logform);
				return "sessionexpire";
		}
		}
	
		
		if((testorderFormObject.getDispatchGridView()!=null) && (testorderFormObject.getDispatchGridView().equals("view")))
		{
			
			try{
				if(testorderFormObject.getFlag()=="disable"){
					testorderFormObject.setFlag("disable");
				}
				String orderId=testorderFormObject.getDispatch();
			String patientId=testorderFormObject.getDispatchPatientId();
System.out.println("TEST id gird VIEW "+orderId);

			String orderTestId=testorderFormObject.getDispatchTestId();
			
			System.out.println("ORDER TEST id gird VIEW "+testorderFormObject.getDispatchTestId());
			
			testorderFormObject=testOrderManagerService.testOrderDetails(LabId, testorderFormObject, orderId);
			if(testorderFormObject.getFlag()=="disable"){
				testorderFormObject.setFlag("disable");
			}
			
			getdetails=testOrderManagerService.testOrdergrid(LabId, testorderFormObject);
			if(testorderFormObject.getFlag()=="disable"){
				testorderFormObject.setFlag("disable");
			}
			
			testorderFormObject.setTestOrderManagerrDetailSubForm(getdetails);
			System.out.println("FFFFFFFFFFFFFF------------------------ group id ffffffffffffffffff"+testorderFormObject.getDispatchTestId());
			testorderFormObject=testOrderManagerService.testOrderViews(testorderFormObject, orderTestId, LabId, httpSession);
			System.out.println("FFFFFFFFFFFFFF group id ffffffffffffffffff"+testorderFormObject.getTestGroup());
			
			model.put("testOrderManagerView",testorderFormObject);
			
			returnPage="testOrderManagerView";}
			catch(NullPointerException e){
				e.printStackTrace();
				IndexForm logform=new IndexForm();
				model.put("index", logform);
				return "sessionexpire";}
		}
		
		if((testorderFormObject.getDispatchGridView()!=null) && (testorderFormObject.getDispatchGridView().equals("edit")))
		{
			try{String orderId=testorderFormObject.getDispatch();
			String patid=testorderFormObject.getDispatchPatientId();
			testorderFormObject=testOrderManagerService.testOrderDetails(LabId, testorderFormObject, orderId);
			
			getdetails=testOrderManagerService.testOrdergrid(LabId, testorderFormObject);
			
			testorderFormObject.setTestOrderManagerrDetailSubForm(getdetails);

			model.put("testOrderManagerView",testorderFormObject);
			
			returnPage="testOrderManagerView";}
			catch(NullPointerException e){
				e.printStackTrace();
				IndexForm logform=new IndexForm();
				model.put("index", logform);
				return "sessionexpire";}
			
		}
System.out.println("Get Dispatch value------------->"+testorderFormObject.getDispatchGridView());	
		
		if((testorderFormObject.getDispatchGridView()!=null) && (testorderFormObject.getDispatchGridView().equals("addtest")))
		{try{
System.out.println("---Dispatch Value--"+testorderFormObject.getDispatchPatientId());
			returnPage=testOrderFormNew(httpSession, request, model,testorderFormObject);}
			catch(NullPointerException e){
				e.printStackTrace();
				IndexForm logform=new IndexForm();
				model.put("index", logform);
				return "sessionexpire";}
		}
		
		if((testorderFormObject.getDispatchGridView()!=null) && (testorderFormObject.getDispatchGridView().equals("update")))
		{
			String patientId=testorderFormObject.getDispatchPatientId();
			System.out.println("---get ordere id on controller----->"+testorderFormObject.getOrderId());
			System.out.println("------------test update contrr group id------------------"+testorderFormObject.getTestGroup());
			String output=testOrderManagerService.saveChangesInOrder(username, LabId, testorderFormObject);
			String testoutput=testOrderManagerService.saveChangesInOrderTest(username, LabId, testorderFormObject);
			model.put("testOrderManagerView",testorderFormObject);
			testorderFormObject.setSuccessMessage(output);
			
			
		}
		
		return returnPage;}
		catch(NullPointerException e){
			e.printStackTrace();
			IndexForm logform=new IndexForm();
			model.put("index", logform);
			return "sessionexpire";
		}

	}
	
	

	public String testOrderFormNew(HttpSession httpSession, HttpServletRequest request, Map model, @ModelAttribute(value ="testOrderManagerNew")TestOrderManagerForm testorderFormObject) throws ParseException
	{
		try{
		String returnPage="testOrderManagerNew";
		String patientId=testorderFormObject.getDispatchPatientId();
		String patientName= testorderFormObject.getDispatchPatientName();
		System.out.println("------ORDER ID----------"+testorderFormObject.getOrderId());
		System.out.println("...........GROUP ID............."+testorderFormObject.getGroup());
		System.out.println("...........SUBGROUP ID............."+testorderFormObject.getSubGroup());
		System.out.println("...........TEST ID............."+testorderFormObject.getTest());
		List publishlist=testOrderManagerService.getPublishList();
		model.put("publishlist",publishlist);
		
		String username=httpSession.getAttribute("username").toString();
		String labid=httpSession.getAttribute("labId").toString();
		String val=testorderFormObject.getDispatchTestId();
		String dispatch;
		dispatch=testorderFormObject.getDispatch();
		List getdetails=new ArrayList();
		List getTestdetails=new ArrayList();
		if((dispatch!=null)&&(dispatch.equals("addorder"))){
			System.out.println("HIT DiSPATCH---------------------------------");
			publishlist=testOrderManagerService.getPublishList();
			model.put("publishlist",publishlist);
			testorderFormObject=testOrderManagerService.addOrderDetails(username, labid, testorderFormObject);
getdetails=testOrderManagerService.TestOrderManagergridView(httpSession, testorderFormObject);
			if(getdetails.size()!=0){
			System.out.println("--LIST SIZE--"+getdetails.size());
			testorderFormObject.setTestOrderManagerrDetailSubForm(getdetails);
			}
		
			model.put("testOrderManagerNew", testorderFormObject);
		}
		
		if((dispatch!=null)&&(dispatch.equals("saveorder"))){
			System.out.println("HIT DiSPATCH---------------------------------");
			publishlist=testOrderManagerService.getPublishList();
			List doctor=testOrderManagerService.DoctorList();
		    List vendor=testOrderManagerService.VendorListdetails();
		    
			 
			     model.put("listdoctorname",doctor);		   
			     model.put("listvendorname", vendor);
			model.put("publishlist",publishlist);
			String output=testOrderManagerService.saveOrderDetails(username, labid, testorderFormObject);
			testorderFormObject.setSuccessMessage(output);
getdetails=testOrderManagerService.TestOrderManagergridView(httpSession, testorderFormObject);
			if(getdetails.size()!=0){
			System.out.println("--LIST SIZE--"+getdetails.size());
			testorderFormObject.setTestOrderManagerrDetailSubForm(getdetails);
			}
		
			model.put("testOrderManagerNew", testorderFormObject);
			
		}
		
	if((dispatch!=null)&&(dispatch.equals("addtest"))){
		System.out.println("------ORDER ID----------"+testorderFormObject.getOrderId());
		publishlist=testOrderManagerService.getPublishList();
		model.put("publishlist",publishlist);
			testorderFormObject=testOrderManagerService.addOrderTestDetails(username, labid, testorderFormObject);
			model.put("testOrderManagerNew",testorderFormObject);
		}
	if((testorderFormObject.getSearchdispatch()!=null) && (testorderFormObject.getSearchdispatch().equals("view"))){
		System.out.println("--------YYYYYYYYYYYYYYYY---------YYYYY----DISPATCH"+testorderFormObject.getDispatch());
		String orderId=testorderFormObject.getDispatch();		
		String orderTestId=testorderFormObject.getDispatchTestId();
		System.out.println("XOXOXOXOXOXOXOXOXO-------------------order id "+orderTestId);
		
		model.put("testOrderManagerNew",testorderFormObject);
	}
	getdetails=testOrderManagerService.TestOrderManagergridView(httpSession, testorderFormObject);
	System.out.println("--LIST SIZE--"+getdetails.size());
	testorderFormObject.setTestOrderManagerrDetailSubForm(getdetails);
	System.out.println("--SUB FORM LIST SIZE--"+testorderFormObject.getTestOrderManagerrDetailSubForm());
	List doctor=testOrderManagerService.testOrderManagerDoctorList(httpSession);
    List vendor=testOrderManagerService.testOrderManagerVendorList(httpSession);
    List group=testOrderManagerService.testOrderManagerGroupList(httpSession);
    model.put("drname", doctor);
    model.put("vendname", vendor);
    model.put("groupname", group);
	model.put("testOrderManagerNew", testorderFormObject);
	return returnPage;}
		catch(NullPointerException e){
			e.printStackTrace();
			IndexForm logform=new IndexForm();
			model.put("index", logform);
			return "sessionexpire";
		}
	}
	
	
	@RequestMapping(value="/testsubgroupselect" , method=RequestMethod.POST)
	public @ResponseBody List TestNames( @RequestParam(value="allgroups") Integer test_Group, HttpSession httpSession, HttpServletRequest request, Map model, ModelMap map,
			@ModelAttribute(value = "log")TestOrderManagerForm testOrderManagerForm) throws Exception
			{
		System.out.println("****************HIT RECORD CHECK CONTROLLER***************");
		List subgrouplist=new ArrayList();	
		testOrderManagerForm.setTestGroup((test_Group));
		subgrouplist=testOrderManagerService.testOrderManagerSubGroupList(httpSession, testOrderManagerForm);
		//testOrderManagerForm.setSubgroupoptions(subgrouplist);
		return subgrouplist;
			}
	
	@RequestMapping(value="/testselect" , method=RequestMethod.POST)
	public @ResponseBody List TestName( @RequestParam(value="allsubgroups") String test_Subgroup, HttpSession httpSession, HttpServletRequest request, Map model, ModelMap map,
			@ModelAttribute(value = "log")TestOrderManagerForm testOrderManagerForm) throws Exception
			{
		System.out.println("****************HIT RECORD CHECK CONTROLLER***************");
		List testlist=new ArrayList();	
		String[] testsGroups=test_Subgroup.split(",");
		String groupId=testsGroups[0];
		String subGroupId=testsGroups[1];
		testOrderManagerForm.setTestGroup(Integer.parseInt(groupId));
		testOrderManagerForm.setTestSubGroup(Integer.parseInt(subGroupId));
		testlist=testOrderManagerService.testOrderManagerTestList(httpSession, testOrderManagerForm);
		return testlist;
			}
	
	@RequestMapping(value="/ratevalue" , method=RequestMethod.POST)
	public @ResponseBody List rate( @RequestParam(value="allrate") Integer test_Test, HttpSession httpSession, HttpServletRequest request, Map model, ModelMap map,
			@ModelAttribute(value = "log")TestOrderManagerForm testOrderManagerForm) throws Exception
			{
		System.out.println("****************HIT RECORD CHECK CONTROLLER Rate***************");
		List testlist=new ArrayList();	
		testOrderManagerForm.setTestId((test_Test));
		testlist=testOrderManagerService.testOrderManagerRate(httpSession, testOrderManagerForm);
		System.out.println("!!!!!!!!!!XXXXXXXXXXXXXXXVVVVVVVVVVVVVVVVRRRRRRRRRRRRRRR"+testlist.get(0));
		return testlist;
			}
	
	@RequestMapping(value="/specimentype" , method=RequestMethod.POST)
	public @ResponseBody List specimen( @RequestParam(value="allspecimen") Integer test_Test, HttpSession httpSession, HttpServletRequest request, Map model, ModelMap map,
			@ModelAttribute(value = "log")TestOrderManagerForm testOrderManagerForm) throws Exception
			{
		System.out.println("****************HIT RECORD CHECK CONTROLLER***************");
		List testlist=new ArrayList();	
		testOrderManagerForm.setTestId((test_Test));
		testlist=testOrderManagerService.testOrderManagerSpecimen(httpSession, testOrderManagerForm);
		System.out.println("!!!!!!!!!!XXXXXXXXXXXXXXXVVVVVVVVVVVVVVVVRRRRRRRRRRRRRRR"+testlist.get(0));
		return testlist;
			}
	
}
