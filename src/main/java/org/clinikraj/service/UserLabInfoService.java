package org.clinikraj.service;

import javax.servlet.http.HttpSession;

import org.clinikraj.form.ClinicalLabInfoForm;
import org.clinikraj.form.IndexForm;

public interface UserLabInfoService {

	public ClinicalLabInfoForm clinicalform(String LabId,ClinicalLabInfoForm clinicallabform);

	public byte[] getLabLogo(String LabId);
	public String LoginForm(String username);

	public IndexForm logoutendsession(HttpSession httpSession, IndexForm indexForm);

}
