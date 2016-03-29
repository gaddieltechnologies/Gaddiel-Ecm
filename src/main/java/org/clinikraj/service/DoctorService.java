package org.clinikraj.service;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.clinikraj.form.DoctorForm;
import org.clinikraj.form.DoctorLoginForm;
import org.clinikraj.form.DoctorLoginSubForm;
import org.clinikraj.form.DoctorSubForm;
import org.clinikraj.form.DoctorTestOrderForm;
import org.clinikraj.form.IndexForm;
import org.clinikraj.form.PatientManagerForm;
import org.clinikraj.form.PatientManagerSubForm;

public interface DoctorService {
	public List doctorform(DoctorForm doctoform, DoctorSubForm subdoctor,String LabId);
	public String doctorAdd(String username, String labId,DoctorForm doctorForm );
	public String addUser(String username,DoctorForm doctoform, String LabId);
	public String addDocUser(String doctorId);
	public List getTieupList();
	public List getSmsList();
	public DoctorForm doctorView(String val);
	public List PrefferedDoctorcontacts();
	public List Specilizationdoctor() throws ParseException;
	public List postofficedoctor(String var) throws ParseException;
	public List viewDoctorLoginDetails(DoctorLoginForm doctorLoginform ,String LabId,String refId) throws ParseException;
	public DoctorLoginForm viewDoctorName(DoctorLoginForm doctorLoginform,String doctorname);
	public DoctorLoginForm DoctortestOrderDetails(String LabId,DoctorLoginForm doctorLoginform,String val);
	 public List DoctortestOrdergridView(String LabId,DoctorLoginForm doctorLoginform);
	public DoctorLoginForm DoctortestOrderViews(DoctorLoginForm doctorLoginforms,String val,String LabId);
	public String LoginForm(String username);
	public IndexForm logoutendsession(HttpSession httpSession, IndexForm indexForm);


}
