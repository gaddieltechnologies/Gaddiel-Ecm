package org.clinikraj.controller;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.clinikraj.form.IndexForm;
import org.clinikraj.service.ClinicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportController {
	private static final Logger logger = Logger.getLogger(ControlPanelController.class);
	@Autowired
	private ClinicService clinicService;
	
	@RequestMapping("/report")
	public String reportForm(HttpServletResponse response, Map model, HttpSession httpSession){
		try{	String returnpage="report";
		System.out.println(httpSession.getAttribute("labId").toString());
		return "report";}
		catch(NullPointerException e){
			e.printStackTrace();
			IndexForm logform=new IndexForm();
			model.put("index", logform);
			return "sessionexpire";
		}
	}

}
