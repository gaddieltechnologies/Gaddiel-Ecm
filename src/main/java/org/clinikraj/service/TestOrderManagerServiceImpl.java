package org.clinikraj.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.clinikraj.dao.ClinicDao;

import org.clinikraj.form.DoctorLoginForm;
import org.clinikraj.form.DoctorLoginSubForm;
import org.clinikraj.form.IndexForm;
import org.clinikraj.form.TestOrderManagerForm;
import org.clinikraj.form.TestOrderManagerSubForm;
import org.clinikraj.form.TestVendorManagerSubForm;
import org.clinikraj.form.UserAccessManagerForm;
import org.clinikraj.model.PatientTestOrders;
import org.clinikraj.model.PatientTests;
import org.clinikraj.model.User;
import org.clinikraj.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestOrderManagerServiceImpl implements TestOrderManagerService {
	

	@Autowired
	public ClinicDao clinicDao;
	
	@Transactional
	
public List viewtestorderDetails(TestOrderManagerForm testorderFormOject,TestOrderManagerSubForm testordermanaerSuFormObject,Integer labid,String username)throws ParseException	
	{
		List orderDetailList=new ArrayList();
		List orderDetailQueryList=clinicDao.viewtestorderDetails(testorderFormOject, testordermanaerSuFormObject,labid,username);
		System.out.println("list of values  size ----> "+orderDetailQueryList.size());			
		for (int i = 0; i < orderDetailQueryList.size(); i++)
		{
			Object[] testorder = (Object[]) orderDetailQueryList.get(i);					
			testordermanaerSuFormObject=new TestOrderManagerSubForm();					
			  testordermanaerSuFormObject.setOrdersubDate(testorder[0]==null ? null :(testorder[0].toString()));
//System.out.println("************************"+testorder[0].toString());
			  testordermanaerSuFormObject.setOrderId(testorder[1]==null ? null :Integer.parseInt(testorder[1].toString()));
			  testordermanaerSuFormObject.setOrderReference(testorder[2]==null ? null :(testorder[2].toString()));
			  testordermanaerSuFormObject.setNetAmount(testorder[3]==null ? null :Integer.parseInt(testorder[3].toString()));
			  testordermanaerSuFormObject.setBalance(testorder[4]==null ? null :Integer.parseInt(testorder[4].toString()));
			  testordermanaerSuFormObject.setPatient(testorder[5]==null ? null :testorder[5].toString());
			  testordermanaerSuFormObject.setDoctor(testorder[6]==null ? null :testorder[6].toString());
			  testordermanaerSuFormObject.setTestVendor(testorder[7]==null ? null :testorder[7].toString()); 
			  testordermanaerSuFormObject.setPatientid(testorder[8]==null ? null :testorder[8].toString());
			  testordermanaerSuFormObject.setBalanceCollectedDate("31-01-2013");	  
			  orderDetailList.add(testordermanaerSuFormObject);
		}
		return orderDetailList;
	}
	public List DoctorList()
	{
		return clinicDao.DoctorListdetails();
	}
    public List VendorListdetails()
    {
    	return clinicDao.VendorList();  
    }

    public List testOrderManagerDoctorList(HttpSession httpSession)throws ParseException{
    	List doctorlist=clinicDao.testOrderManagerDoctorList(httpSession);
    	TestOrderManagerForm adddoctor  = new TestOrderManagerForm();
    	List showDoctor=new ArrayList();
    	for (int i = 0; i < doctorlist.size(); i++)
    	{
    		Object[] doctorObject = (Object[]) doctorlist.get(i);
    		adddoctor  = new TestOrderManagerForm();
    		adddoctor.setDoctor(Integer.parseInt((doctorObject[0]).toString()));
    		//System.out.println("DAO IMPL DOCTOR ID ------------->>>>>>>>>>>>>>"+adddoctor.getReferringVendoid());
    		adddoctor.setReferringDoctor((doctorObject[1].toString()));
    	
    		showDoctor.add(adddoctor);
    	
    }
    	return showDoctor;
    }
    
    public List testOrderManagerVendorList(HttpSession httpSession)throws ParseException{
    	List vendorlist=clinicDao.testOrderManagerVendorList(httpSession);
    	TestOrderManagerForm adddoctor  = new TestOrderManagerForm();
    	List showVendor=new ArrayList();
		for (int i = 0; i < vendorlist.size(); i++)
		{
		
			Object[] vendorObject = (Object[]) vendorlist.get(i);
			adddoctor  = new TestOrderManagerForm();
			adddoctor.setTestVendor(Integer.parseInt((vendorObject[0].toString())));
			//System.out.println("DAO IMPL VENDOR ID ------------->>>>>>>>>>>>>>"+adddoctor.getReferringVendoid());
			adddoctor.setVendorList((vendorObject[1]==null ? null :vendorObject[1].toString()));
			
			showVendor.add(adddoctor);
		
	}
    	return showVendor;
    }
    
    public List testOrderManagerGroupList(HttpSession httpSession)throws ParseException{
    	List grouplist=clinicDao.testOrderManagerGroupList(httpSession);
    	TestOrderManagerForm addgroup  = new TestOrderManagerForm();
    	List showGroup=new ArrayList();
		for (int i = 0; i < grouplist.size(); i++)
		{
		
			Object[] groupObject = (Object[]) grouplist.get(i);
			addgroup  = new TestOrderManagerForm();
			addgroup.setTestGroup((Integer.parseInt((groupObject[0].toString()))));
			//System.out.println("DAO IMPL VENDOR ID ------------->>>>>>>>>>>>>>"+adddoctor.getReferringVendoid());
			addgroup.setGroup(((groupObject[1]==null ? null :groupObject[1].toString())));
			
			showGroup.add(addgroup);
		
	}
    	return showGroup;
    }
    public List testOrderManagerSubGroupList(HttpSession httpSession, TestOrderManagerForm testOrderManagerForm)throws ParseException{
    	List subgrouplist=clinicDao.testOrderManagerSubGroupList(httpSession, testOrderManagerForm);
    	TestOrderManagerForm addsubgroup  = new TestOrderManagerForm();
    	List showsubGroup=new ArrayList();
    	for (int i = 0; i < subgrouplist.size(); i++)
		{
		
			Object[] subgroupObject = (Object[]) subgrouplist.get(i);
			addsubgroup  = new TestOrderManagerForm();
			addsubgroup.setTestSubGroup(((Integer.parseInt((subgroupObject[0].toString())))));
			//System.out.println("DAO IMPL VENDOR ID ------------->>>>>>>>>>>>>>"+adddoctor.getReferringVendoid());
			addsubgroup.setSubGroup(((subgroupObject[1]==null ? null :subgroupObject[1].toString())));
			
			showsubGroup.add(addsubgroup);
		
	}
    	return showsubGroup;
    }
    public List testOrderManagerTestList(HttpSession httpSession, TestOrderManagerForm testOrderManagerForm)throws ParseException{
    	List testlist=clinicDao.testOrderManagerTestList(httpSession, testOrderManagerForm);
    	TestOrderManagerForm addtest  = new TestOrderManagerForm();
    	List showTest=new ArrayList();
    	for (int i = 0; i < testlist.size(); i++)
    	{
    	
    		Object[] testObject = (Object[]) testlist.get(i);
    		addtest  = new TestOrderManagerForm();
    		addtest.setTestId(((Integer.parseInt((testObject[0].toString())))));
    		//System.out.println("DAO IMPL VENDOR ID ------------->>>>>>>>>>>>>>"+adddoctor.getReferringVendoid());
    		addtest.setTest(((testObject[1]==null ? null :testObject[1].toString())));
    		
    		showTest.add(addtest);
    }
    	return showTest;
    }


public List viewpatientorderDetails(TestOrderManagerForm patienttestorderFormOject,TestOrderManagerSubForm patienttestorderSuFormObject,Integer labid,String username) throws ParseException
{
	List patientorderDetailsList=new ArrayList();
	List patientorderDetailQueryList=clinicDao.viewpatienttestorderDetails(patienttestorderFormOject, patienttestorderSuFormObject, labid, username);
	for (int i = 0; i < patientorderDetailQueryList.size(); i++)
	{
		Object[] patienttestorder = (Object[]) patientorderDetailQueryList.get(i);					
		patienttestorderSuFormObject=new TestOrderManagerSubForm();
		patienttestorderSuFormObject.setPatientid(patienttestorder[0]==null ? null:(patienttestorder[0].toString()));
		patienttestorderSuFormObject.setPatientname(patienttestorder[1]==null ? null :(patienttestorder[1].toString()));
		patienttestorderSuFormObject.setPatientsex(patienttestorder[2]==null ? null: (patienttestorder[2].toString()));
		patienttestorderSuFormObject.setPatientage(patienttestorder[3]==null ? null: (patienttestorder[3].toString()));
		patienttestorderSuFormObject.setPrefferdcontact(patienttestorder[4]==null ? null: (patienttestorder[4].toString()));
		patienttestorderSuFormObject.setMobphoneno(patienttestorder[5]==null ? null: (patienttestorder[5].toString()));
		patienttestorderSuFormObject.setEmail(patienttestorder[6]==null ? null: (patienttestorder[6].toString()));
		patienttestorderSuFormObject.setCode(patienttestorder[7]==null ? null:(patienttestorder[7].toString()));
		patienttestorderSuFormObject.setDoctorna(patienttestorder[8]==null ? null: (patienttestorder[8].toString()));
		patienttestorderSuFormObject.setVendorna(patienttestorder[9]==null ? null: (patienttestorder[9].toString()));
		
		patientorderDetailsList.add(patienttestorderSuFormObject);		
	}
	return patientorderDetailsList;
}


public TestOrderManagerForm addOrderDetails(String username, String labId, TestOrderManagerForm addOrder)throws ParseException {
	PatientTestOrders orderAddModel=new PatientTestOrders();
	String output=null;
	try{
		/*not null*/	orderAddModel.setOrderDate(new Date());
		orderAddModel.setDoctor(addOrder.getDoctor());
		orderAddModel.setCreatedBy(username);
		orderAddModel.setCreatedDate(new Date());
						orderAddModel.setLastUpdatedBy(username);
						orderAddModel.setPatient(Integer.parseInt(addOrder.getDispatchPatientId()));
						orderAddModel.setLastUpdatedDate(new Date());
						orderAddModel.setOrderId(null);
						orderAddModel.setClinicalLab(Integer.parseInt(labId));
						orderAddModel.setDoctor(addOrder.getDoctor());
						orderAddModel.setTestVendor(addOrder.getTestVendor());
						orderAddModel.setPublish(addOrder.getPublish());
						orderAddModel.setOrderReference(addOrder.getOrderReference());
						orderAddModel.setOrderDate(new Date());
						orderAddModel.setGrossAmount(addOrder.getGrossAmount());
						orderAddModel.setAdavance(addOrder.getAdavance());
						orderAddModel.setDiscount(addOrder.getDiscount());
						orderAddModel.setBalance(addOrder.getBalance());
		/*not null*/	orderAddModel.setNetAmount(addOrder.getNetAmount());
						
		/*not null*/	/*orderAddModel.setTotalAmountCollected(addOrder.getTotalCollected());*/
		/*not null*/	orderAddModel.setActiveFlag("Y");
		/*not null*/	orderAddModel.setDeleteFlag("N");
		/*not null*/	orderAddModel.setRemarks(addOrder.getRemarks());		
		/*not null*/	addOrder.setGrossAmount(0);
		/*not null*/	
		orderAddModel=clinicDao.addOrderDetails(orderAddModel);
	 
	 addOrder.setOrderId(orderAddModel.getOrderId());
	 DateFormat outputdate=new SimpleDateFormat("dd-MM-yyyy");
	   String outstrdate=outputdate.format(orderAddModel.getOrderDate());
	 addOrder.setOrderDate(outstrdate);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return addOrder;


}

public TestOrderManagerForm addOrderTestDetails(String username, String labId, TestOrderManagerForm addOrder)throws ParseException{
	PatientTests orderAddModel=new PatientTests();
	
	orderAddModel.setTestGroups(Integer.parseInt(addOrder.getGroup()));
	orderAddModel.setTestSubgroups(Integer.parseInt(addOrder.getSubGroup()));
	orderAddModel.setCreatedBy(username);
	orderAddModel.setCreatedDate(new Date());
					orderAddModel.setLastUpdatedBy(username);
					orderAddModel.setTests(Integer.parseInt(addOrder.getTest()));
					orderAddModel.setLastUpdatedDate(new Date());
					orderAddModel.setOrderTestsId(null);
					orderAddModel.setPatientTestOrders(addOrder.getOrderId());
					orderAddModel.setTestRate((addOrder.getRate()));
					orderAddModel.setTestReference(addOrder.getTestReference());
					orderAddModel.setTestJobNumber(addOrder.getTestJob());
					orderAddModel.setTestStartTime(addOrder.getTestStartTime()==null || addOrder.getTestStartTime()=="" ? null :Converter.StringtoDateforDB(addOrder.getTestStartTime()));
					orderAddModel.setTestResult(addOrder.getTestResult());
					orderAddModel.setTestBy(addOrder.getTestedBy());
					orderAddModel.setTestResultApprovedBy(addOrder.getTestApprovedBy());
					orderAddModel.setTestAnalysisRemarks(addOrder.getAnalystRemarks());
					orderAddModel.setSpecimenCollected(addOrder.getSpecimenDetails());
					orderAddModel=clinicDao.addOrderTestDetails(orderAddModel);
					
					Integer testJob=addOrder.getTestJob();
					
					Integer nextrate=addOrder.getGrossAmount();
					Integer addrate=(addOrder.getRate());
					Integer totrate=nextrate+addrate;
					addOrder.setGrossAmount(totrate);
					addOrder.setNetAmount(totrate);
					addOrder.setBalance(totrate);
					nextrate=addrate;
					return addOrder;
	
}

public String saveOrderDetails(String username, String labId, TestOrderManagerForm addOrder)throws ParseException {
	PatientTestOrders orderAddModel=new PatientTestOrders();
	String output=null;
	try{
		/*not null*/	orderAddModel.setOrderDate(new Date());
		orderAddModel.setDoctor(addOrder.getDoctor());
		orderAddModel.setCreatedBy(username);
		orderAddModel.setCreatedDate(new Date());
						orderAddModel.setLastUpdatedBy(username);
						orderAddModel.setPatient(Integer.parseInt(addOrder.getDispatchPatientId()));
						orderAddModel.setLastUpdatedDate(new Date());
						orderAddModel.setOrderId(addOrder.getOrderId());
						orderAddModel.setClinicalLab(Integer.parseInt(labId));
						orderAddModel.setDoctor(addOrder.getDoctor());
						orderAddModel.setTestVendor(addOrder.getTestVendor());
						orderAddModel.setPublish(addOrder.getPublish());
						orderAddModel.setOrderReference(addOrder.getOrderReference());
						orderAddModel.setOrderDate(new Date());
						orderAddModel.setGrossAmount(addOrder.getGrossAmount());
						orderAddModel.setAdavance(addOrder.getAdavance());
						orderAddModel.setDiscount(addOrder.getDiscount());
						orderAddModel.setBalance(addOrder.getBalance());
		/*not null*/	orderAddModel.setNetAmount(addOrder.getNetAmount());
						
		/*not null*/	/*orderAddModel.setTotalAmountCollected(addOrder.getTotalCollected());*/
		/*not null*/	orderAddModel.setActiveFlag("Y");
		/*not null*/	orderAddModel.setDeleteFlag("N");
		/*not null*/	orderAddModel.setRemarks(addOrder.getRemarks());		
		/*not null*/	
		/*not null*/	
		output=clinicDao.saveOrderDetails(orderAddModel);
	 
	 addOrder.setOrderId(orderAddModel.getOrderId());
	 DateFormat outputdate=new SimpleDateFormat("dd-MM-yyyy");
	   String outstrdate=outputdate.format(orderAddModel.getOrderDate());
	 addOrder.setOrderDate(outstrdate);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return output;

}



public List TestOrderManagergridView(HttpSession httpSession,TestOrderManagerForm testordermanagerform){
	List doctorDetailList=new ArrayList();
	TestOrderManagerSubForm testOrderSubFormObject=new TestOrderManagerSubForm();
	List testOrderDetailQueryList= clinicDao.TestOrderManagergridView( httpSession,testordermanagerform);
	
	System.out.println("list of values  size ----> "+testOrderDetailQueryList.size());
	for (int i = 0; i < testOrderDetailQueryList.size(); i++)
	{
		Object[] view = (Object[]) testOrderDetailQueryList.get(i);
		
		testOrderSubFormObject=new TestOrderManagerSubForm();
		
		testOrderSubFormObject.setGroupId(view[0]==null ? null :(view[0].toString()));
		testOrderSubFormObject.setSubgroupId(view[1]==null ? null :(view[1].toString()));
		testOrderSubFormObject.setTestId(view[2]==null ? null :view[2].toString());
		testOrderSubFormObject.setOrderTest(view[3]==null ? null :Integer.parseInt(view[3].toString()));
		testOrderSubFormObject.setTestResult(view[4]==null ? null :view[4].toString());
		testOrderSubFormObject.setAnalystRemarks(view[5]==null ? null :view[5].toString());
		testOrderSubFormObject.setRate(view[6]==null ? null :(view[6].toString()));
		testOrderSubFormObject.setSpecimenDetails(view[7]==null ? null :view[7].toString());
		testOrderSubFormObject.setTestJob(view[8]==null ? null :view[8].toString());
		testOrderSubFormObject.setTestedBy(view[9]==null ? null :view[9].toString());
		testOrderSubFormObject.setTestApprovedBy(view[10]==null ? null :view[10].toString());
		
						
		doctorDetailList.add(testOrderSubFormObject);
	}
	 
	return doctorDetailList;
	
   

}


//Test ON Click View 
			
			/* 1st Div Order Details */
@Transactional
	public TestOrderManagerForm testOrderDetails(String LabId,TestOrderManagerForm testViewForm,String val){
	
System.out.println("hit servicesimpl");
	 
		List list=clinicDao.testOrderDetails(LabId, val);
		Object[] object=(Object[])list.get(0);
		
		testViewForm.setOrderId(object[0]==null ? null:Integer.parseInt(object[0].toString()));
		System.out.println("---xxxx order ID xxxxx----"+testViewForm.getOrderId());
		testViewForm.setOrderDate(object[1]==null ? null:(object[1].toString()));
		testViewForm.setDoctorname(object[2]==null ? null:(object[2].toString()));
		testViewForm.setVendorname(object[3]==null ? null:(object[3].toString()));
		testViewForm.setOrderReference(object[4]==null ? null:(object[4].toString()));
		testViewForm.setOrdervalue(object[5]==null ? null:(object[5].toString()));
		testViewForm.setDiscount(object[6]==null ? null:Integer.parseInt(object[6].toString()));
		testViewForm.setNetAmount(object[7]==null ? null:Integer.parseInt(object[7].toString()));
		testViewForm.setAdavance(object[8]==null ? null:Integer.parseInt(object[8].toString()));
		testViewForm.setBalance(object[9]==null ? null:Integer.parseInt(object[9].toString()));
		testViewForm.setTotalCollected(object[10]==null ? null:Integer.parseInt(object[10].toString()));
		//testViewForm.setOrderTestId(object[11]==null ? null:Integer.parseInt(object[11].toString()));
		testViewForm.setClientName(object[11]==null ? null:(object[11].toString()));
		testViewForm.setLabId(object[12]==null ? null:Integer.parseInt(object[12].toString()));
		testViewForm.setClient(object[13]==null ? null:Integer.parseInt(object[13].toString()));
		testViewForm.setTestGroup(object[14]==null ? null:Integer.parseInt(object[14].toString()));
		testViewForm.setTestSubGroup(object[15]==null ? null:Integer.parseInt(object[15].toString()));
		testViewForm.setTestId(object[16]==null ? null:Integer.parseInt(object[16].toString()));
		testViewForm.setDoctor(object[17]==null ? null:Integer.parseInt(object[17].toString()));
		testViewForm.setTestVendor(object[18]==null ? null:Integer.parseInt(object[18].toString()));
		testViewForm.setPublish(object[19]==null ? null:(object[19].toString()));
	 
		return testViewForm;
		
	}

public List testOrderManagerRate(HttpSession httpSession, TestOrderManagerForm testOrderManagerForm)throws ParseException{
	
	System.out.println(" HIT RATE SEICE IMPL");
	Integer testlist=clinicDao.testOrderManagerRate(httpSession, testOrderManagerForm);
	List showTest=new ArrayList();
	Integer obj=testlist;
	try{
		
		testOrderManagerForm.setRate(obj);
		System.out.println("******************RATE************9999999999999"+testOrderManagerForm.getRate());
	}
	catch(Exception e){
		e.printStackTrace();
	
		}
	showTest.add(testOrderManagerForm);
	return showTest;
}


@Transactional
	public List testOrdergrid(String LabId,TestOrderManagerForm testViewForm){
		
		List testGridList=new ArrayList();
		
		TestOrderManagerSubForm testSubFormObject=new TestOrderManagerSubForm();
	
		List testGridQurey= clinicDao.testOrdergridView(LabId, testViewForm);
	
System.out.println("list of values SERVICE  size ----> "+testGridQurey.size());
		for (int i = 0; i < testGridQurey.size(); i++)
		{
			Object[] view = (Object[]) testGridQurey.get(i);
		
			testSubFormObject=new TestOrderManagerSubForm();
		
			testSubFormObject.setGroup(view[0]==null ? null :(view[0].toString()));
			testSubFormObject.setSubGroup(view[1]==null ? null :(view[1].toString()));
			testSubFormObject.setTest(view[2]==null ? null :(view[2].toString()));
			testSubFormObject.setOrder(view[3]==null ? null :Integer.parseInt(view[3].toString()));
			testSubFormObject.setTestResult(view[4]==null ? null :view[4].toString());
			testSubFormObject.setAnalystRemarks(view[5]==null ? null :view[5].toString());
			testSubFormObject.setRate(view[6]==null ? null :view[6].toString());
			testSubFormObject.setSpecimenDetails(view[7]==null ? null :view[7].toString());
			testSubFormObject.setTestJob(view[8]==null ? null :view[8].toString());
			testSubFormObject.setTestedBy(view[9]==null ? null :view[9].toString());
			testSubFormObject.setTestApprovedBy(view[10]==null ? null :view[10].toString());
		
						
			testGridList.add(testSubFormObject);
	}
	 
	return testGridList;
	

}
@Transactional
public TestOrderManagerForm testOrderViews(TestOrderManagerForm getGirdTestDetail,String val,String LabId,HttpSession httpSession){
	
	List doctorDetailQueryList= clinicDao.testOrderGridDetails(getGirdTestDetail, val, LabId, httpSession);
	
	System.out.println("list of values  size ----> "+doctorDetailQueryList.size());
	
		Object[] view = (Object[]) doctorDetailQueryList.get(0);
		
		//doctorSubFormObject=new DoctorLoginSubForm();
		
		getGirdTestDetail.setGroup(view[0]==null ? null :(view[0].toString()));
		getGirdTestDetail.setSubGroup(view[1]==null ? null :(view[1].toString()));
		getGirdTestDetail.setTest(view[2]==null ? null :view[2].toString());
		getGirdTestDetail.setOrder(view[3]==null ? null :Integer.parseInt(view[3].toString()));
		getGirdTestDetail.setTestResult(view[4]==null ? null :view[4].toString());
		getGirdTestDetail.setAnalystRemarks(view[5]==null ? null :view[5].toString());
		getGirdTestDetail.setRate(view[6]==null ? null :Integer.parseInt(view[6].toString()));
		getGirdTestDetail.setSpecimenDetails(view[7]==null ? null :view[7].toString());
		getGirdTestDetail.setTestjob(view[8]==null ? null :view[8].toString());
		getGirdTestDetail.setTestedBy(view[9]==null ? null :view[9].toString());
		getGirdTestDetail.setTestApprovedBy(view[10]==null ? null :view[10].toString());
		getGirdTestDetail.setTestStartDate(view[11]==null ? null:(view[11].toString()));
		getGirdTestDetail.setTestStartTime(view[12]==null ? null:(view[12].toString()));
		getGirdTestDetail.setTestReference(view[13]==null ? null:(view[13].toString()));
		getGirdTestDetail.setTestGroup(view[14]==null ? null:Integer.parseInt(view[14].toString()));
		System.out.println("&&&&&&&&&&&&&&&&& what is the group id &&&&&&&&&&&&&&"+getGirdTestDetail.getTestGroup());
		getGirdTestDetail.setTestSubGroup(view[15]==null ? null:Integer.parseInt(view[15].toString()));
		getGirdTestDetail.setTestId(view[16]==null ? null:Integer.parseInt(view[16].toString()));
		getGirdTestDetail.setDoctor(view[17]==null ? null:Integer.parseInt(view[17].toString()));
		getGirdTestDetail.setTestVendor(view[18]==null ? null:Integer.parseInt(view[18].toString()));
		

	 
	return getGirdTestDetail;

}
public List testOrderManagerSpecimen(HttpSession httpSession, TestOrderManagerForm testOrderManagerForm)throws ParseException{
	List testlist=clinicDao.testOrderManagerSpecimen(httpSession, testOrderManagerForm);
	
	List showTest=new ArrayList();
	
	
		String obj=(String) testlist.get(0);
		
		testOrderManagerForm.setSpecimenDetails(obj);
		
		
		
		showTest.add(testOrderManagerForm);

	return showTest;
}
public String saveChangesInOrder(String username, String labId, TestOrderManagerForm updateOrder)throws ParseException {
	
	PatientTestOrders orderAddModel=new PatientTestOrders();
	
	String output=null;
	String testoutput=null;
		
			System.out.println(" get order Id "+updateOrder.getOrderId());
			orderAddModel.setOrderId(updateOrder.getOrderId());
			
			orderAddModel.setLastUpdatedBy(username);
			orderAddModel.setLastUpdatedDate(new Date());
			orderAddModel.setGrossAmount(Integer.parseInt(updateOrder.getOrdervalue()));
			orderAddModel.setDiscount(updateOrder.getDiscount());
			orderAddModel.setNetAmount(updateOrder.getNetAmount());
			orderAddModel.setAdavance(updateOrder.getAdavance());
			orderAddModel.setBalance(updateOrder.getBalance());
			
			orderAddModel.setOrderDate(new Date());
			orderAddModel.setCreatedBy(username);
			orderAddModel.setCreatedDate(new Date());
							
							orderAddModel.setPatient(Integer.parseInt(updateOrder.getDispatchPatientId()));
							
							
							orderAddModel.setClinicalLab(Integer.parseInt(labId));
							orderAddModel.setDoctor(updateOrder.getDoctor());
							orderAddModel.setTestVendor(updateOrder.getTestVendor());
							orderAddModel.setPublish(updateOrder.getPublish());
							orderAddModel.setOrderReference(updateOrder.getOrderReference());
							orderAddModel.setOrderDate(new Date());
							
			/*not null*/	orderAddModel.setActiveFlag("Y");
			/*not null*/	orderAddModel.setDeleteFlag("N");
			/*not null*/	orderAddModel.setRemarks(updateOrder.getRemarks());		
			/*not null*/	
			
			
							
			
		 
			updateOrder.setOrderId(orderAddModel.getOrderId());
		 DateFormat outputdate=new SimpleDateFormat("dd-MM-yyyy");
		   String outstrdate=outputdate.format(orderAddModel.getOrderDate());
		   updateOrder.setOrderDate(outstrdate);
		   output=clinicDao.updateOrderValue(orderAddModel);
		   
	
	return output;



}



public String saveChangesInOrderTest(String username, String labId, TestOrderManagerForm updateOrder)throws ParseException {
	
	
	PatientTests testorderAddModel=new PatientTests();
	String output=null;
	
		
			System.out.println(" get order Id "+updateOrder.getOrderId());
			
			testorderAddModel.setCreatedBy(username);
			System.out.println("-----------------------save func CREATED bY----------------------"+testorderAddModel.getCreatedBy());
			testorderAddModel.setCreatedDate(new Date());
			System.out.println("-----------------------save func CREATED DATE----------------------"+testorderAddModel.getCreatedDate());
			testorderAddModel.setLastUpdatedBy(username);
			System.out.println("-----------------------save func CREATED DATE----------------------"+testorderAddModel.getLastUpdatedBy());
			testorderAddModel.setLastUpdatedDate(new Date());
			System.out.println("-----------------------save func CREATED DATE----------------------"+testorderAddModel.getLastUpdatedDate());
			testorderAddModel.setTestGroups((updateOrder.getTestGroup()));
			System.out.println("-----------------------save func test group----------------------"+updateOrder.getTestGroup());
			testorderAddModel.setTestSubgroups((updateOrder.getTestSubGroup()));
			System.out.println("-----------------------save func test SUB group----------------------"+updateOrder.getTestSubGroup());
			testorderAddModel.setTests((updateOrder.getTestId()));
			System.out.println("-----------------------save func test SUB group----------------------"+updateOrder.getTestId());
			testorderAddModel.setOrderTestsId(updateOrder.getOrder());
			System.out.println("-----------------------save func test SUB group----------------------"+updateOrder.getOrder());
			testorderAddModel.setPatientTestOrders(updateOrder.getOrderId());
			System.out.println("-----------------------save func test SUB group----------------------"+updateOrder.getOrderId());
			testorderAddModel.setTestAnalysisRemarks(updateOrder.getAnalystRemarks());
			testorderAddModel.setTestRate(updateOrder.getRate());
			System.out.println("-----------------------save func test SUB group----------------------"+updateOrder.getRate());
			testorderAddModel.setSpecimenCollected(updateOrder.getSpecimenDetails());
			//testorderAddModel.setTestJobNumber(Integer.parseInt(updateOrder.getTestjob()));
			testorderAddModel.setTestBy(updateOrder.getTestedBy());
			testorderAddModel.setTestResultApprovedBy(updateOrder.getTestApprovedBy());
			//testorderAddModel.setTestStartTime(updateOrder.getTestStartTime()==null || updateOrder.getTestStartTime()=="" ? null :Converter.StringtoDateforDB(updateOrder.getTestStartTime()));
			System.out.println("-----------------------save func test SUB group----------------------"+updateOrder.getTestStartTime());
			testorderAddModel.setTestReference(updateOrder.getTestReference());
			
			
		
			
			
			
			
			testorderAddModel.setTestJobNumber(updateOrder.getTestJob());
			
			testorderAddModel.setTestResult(updateOrder.getTestResult());
			
			
							
			
		 
			
		   output=clinicDao.updateOrderValueTest(testorderAddModel);
	
	return output;



}

public IndexForm logoutendsession(HttpSession httpSession, IndexForm indexForm){
		 
		 httpSession.setAttribute("username", null);
		 return indexForm;
	 }

public List getPublishList() {
	// TODO Auto-generated method stub
	return clinicDao.getActiveFlagList();
}
}
