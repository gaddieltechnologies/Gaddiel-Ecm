package org.clinikraj.controller;






import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.apache.log4j.Logger;
import org.apache.poi.util.IOUtils;

import org.clinikraj.dao.ClinicDaoImpl;
import org.clinikraj.form.ClinicalLabInfoForm;

import org.clinikraj.form.IndexForm;



import org.clinikraj.model.ClinicalLab;
import org.clinikraj.service.ClinicService;
import org.clinikraj.service.UserLabInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class ControlPanelController {
	private static final Logger logger = Logger.getLogger(ControlPanelController.class);
	@Autowired
	private UserLabInfoService userLabInfoService;
	
	
	@RequestMapping("/controlPanel")
	public String controlPanelForm(HttpSession httpSession, HttpServletResponse response, HttpServletRequest request, Map model, @ModelAttribute("index") IndexForm indexform)
	{
		IndexForm indexforms=new IndexForm();
	
		try{
			
			
		String returnpage="controlPanel";
		
		
		
		
		
		ClinicalLabInfoForm cinicallab=new ClinicalLabInfoForm();
        String LabId=httpSession.getAttribute("labId").toString();
        String username=httpSession.getAttribute("username").toString();     
        System.out.println(httpSession.getAttribute("username")+"ooooo");
		cinicallab = userLabInfoService.clinicalform(LabId,cinicallab);
		 String output=userLabInfoService.LoginForm(username);	
		System.out.println("allowthirdparty----"+cinicallab.getAllowThirdpartyAccess());
		httpSession.setAttribute("allowthirdparty", cinicallab.getAllowThirdpartyAccess());
		  indexform.setAlertMessage(output);
		model.put("controlPanel",indexform);
		

		
		
		
		return returnpage;}
		catch(NullPointerException e){
			e.printStackTrace();
			IndexForm logform=new IndexForm();
			model.put("index", logform);
			return "sessionexpire";
		}

	}
	
	@RequestMapping("/userLabInfo")
	public String LabInFoForm(HttpSession httpSession, HttpServletResponse response, Map model, @ModelAttribute("userLabInfo")ClinicalLabInfoForm clinicallabform){
		System.out.print("ok");
		try{
		
		ClinicalLabInfoForm cinicallab=new ClinicalLabInfoForm();
		IndexForm indexForm=new IndexForm();
		String LabId=httpSession.getAttribute("labId").toString();
		cinicallab = userLabInfoService.clinicalform(LabId,clinicallabform);
		
		String returnpage="userLabInfo";
		
		System.out.println(httpSession.getAttribute("labId").toString());
		
		
		
		System.out.println("labname"+cinicallab.getLabName());
	
		model.put("userLabInfo",cinicallab);
		
		return returnpage;}
		catch(NullPointerException e){
			e.printStackTrace();
			IndexForm logform=new IndexForm();
			model.put("index", logform);
			return "sessionexpire";
		}
		
	}

	@RequestMapping("/download")
	public String download(HttpServletResponse response, HttpSession httpSession, String LabId) throws SQLException {
		
		LabId=httpSession.getAttribute("labId").toString();
		byte[] bytes=userLabInfoService.getLabLogo(LabId);
		try {
			response.setHeader("Content-Disposition", "inline;filename=\"");
			OutputStream out = response.getOutputStream();
			InputStream is = new ByteArrayInputStream(bytes);
			IOUtils.copy(is, out);
			out.flush();
			out.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	
	
	@RequestMapping("/test")
	public String testForm(){
		return "test";
	}
	
	
	
	
	
}
