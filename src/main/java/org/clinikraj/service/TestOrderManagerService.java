package org.clinikraj.service;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.clinikraj.form.IndexForm;
import org.clinikraj.form.TestOrderManagerForm;
import org.clinikraj.form.TestOrderManagerSubForm;

public interface TestOrderManagerService {
	
	public List viewtestorderDetails(TestOrderManagerForm testorderFormOject,TestOrderManagerSubForm testordermanaerSuFormObject,Integer labid,String username)throws ParseException;	
	public List testOrderManagerDoctorList(HttpSession httpSession)throws ParseException;
	public List testOrderManagerVendorList(HttpSession httpSession)throws ParseException;
	public List testOrderManagerGroupList(HttpSession httpSession)throws ParseException;
    public List testOrderManagerSubGroupList(HttpSession httpSession, TestOrderManagerForm testOrderManagerForm)throws ParseException;
    public List testOrderManagerTestList(HttpSession httpSession, TestOrderManagerForm testOrderManagerForm)throws ParseException;
	public List DoctorList();
	public List VendorListdetails();
	public List viewpatientorderDetails(TestOrderManagerForm patienttestorderFormOject,TestOrderManagerSubForm patienttestorderSuFormObject,Integer labid,String username) throws ParseException;

	
	public TestOrderManagerForm addOrderDetails(String username, String labId, TestOrderManagerForm addOrder)throws ParseException;
	public TestOrderManagerForm addOrderTestDetails(String username, String labId, TestOrderManagerForm addOrder)throws ParseException;
	public List TestOrderManagergridView(HttpSession httpSession,TestOrderManagerForm testordermanagerform);
	public String saveOrderDetails(String username, String labId, TestOrderManagerForm addOrder)throws ParseException;

	public TestOrderManagerForm testOrderDetails(String LabId,TestOrderManagerForm testViewForm,String val);
	public List testOrdergrid(String LabId,TestOrderManagerForm testViewForm);
	public TestOrderManagerForm testOrderViews(TestOrderManagerForm getGirdTestDetail,String val,String LabId,HttpSession httpSession);

	public List testOrderManagerRate(HttpSession httpSession, TestOrderManagerForm testOrderManagerForm)throws ParseException;
	public List testOrderManagerSpecimen(HttpSession httpSession, TestOrderManagerForm testOrderManagerForm)throws ParseException;

	public List getPublishList();
	public String saveChangesInOrder(String username, String labId, TestOrderManagerForm updateOrder)throws ParseException;
	public String saveChangesInOrderTest(String username, String labId, TestOrderManagerForm updateOrder)throws ParseException;
	public IndexForm logoutendsession(HttpSession httpSession, IndexForm indexForm);
}
