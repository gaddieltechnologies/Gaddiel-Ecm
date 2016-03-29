package org.clinikraj.form;

import java.util.Date;
import java.util.List;



public class UserAccessManagerForm {
	
	 private List<UserAccessManagerSubForm> userDetailSubForm;
	 
	 private String dispatch;
	 	private String dispatchGridView;
	 	private String dispatchid;
	 	private String errorMessage;
	 	private String successMessage;
	 	

		private String searchUserName;
	 	public String getDispatch() {
			return dispatch;
		}

		public void setDispatch(String dispatch) {
			this.dispatch = dispatch;
		}

		public String getDispatchGridView() {
			return dispatchGridView;
		}

		public void setDispatchGridView(String dispatchGridView) {
			this.dispatchGridView = dispatchGridView;
		}

		public String getSearchUserName() {
			return searchUserName;
		}

		public void setSearchUserName(String searchUserName) {
			this.searchUserName = searchUserName;
		}

		public String getSearchPhoneMobile() {
			return searchPhoneMobile;
		}

		public void setSearchPhoneMobile(String searchPhoneMobile) {
			this.searchPhoneMobile = searchPhoneMobile;
		}

		public String getSearchRole() {
			return searchRole;
		}

		public void setSearchRole(String searchRole) {
			this.searchRole = searchRole;
		}

		public String getSearchUserType() {
			return searchUserType;
		}

		public void setSearchUserType(String searchUserType) {
			this.searchUserType = searchUserType;
		}

		private String searchPhoneMobile;
	 	private String searchRole;
	 	private String searchUserType;
	 
	 	private String userName;
		private String role;
	    private String userType;
	 private Integer refId;
	 private String defaultPasswordChanged;
	 private String userActive;
	 private String userDelete;
	 private Date startDate;
	 private Date endDate;
	 private Date successLogin;
	 private Date failedLogin;
	 private Date nextPasswordChangeDate;
	 private Integer lastSessionId;
	 private String remarks;
	 private List rolelistvalue;
	 private List usertypelistvalue;
	 private List defpasschangelistvalue;
	 private List actflaglistvalue;
	 private List delflaglistvalue;
	 
	public List getRolelistvalue() {
		return rolelistvalue;
	}

	public void setRolelistvalue(List rolelistvalue) {
		this.rolelistvalue = rolelistvalue;
	}

	public List getUsertypelistvalue() {
		return usertypelistvalue;
	}

	public void setUsertypelistvalue(List usertypelistvalue) {
		this.usertypelistvalue = usertypelistvalue;
	}

	public List getDefpasschangelistvalue() {
		return defpasschangelistvalue;
	}

	public void setDefpasschangelistvalue(List defpasschangelistvalue) {
		this.defpasschangelistvalue = defpasschangelistvalue;
	}

	public List getActflaglistvalue() {
		return actflaglistvalue;
	}

	public void setActflaglistvalue(List actflaglistvalue) {
		this.actflaglistvalue = actflaglistvalue;
	}

	public List getDelflaglistvalue() {
		return delflaglistvalue;
	}

	public void setDelflaglistvalue(List delflaglistvalue) {
		this.delflaglistvalue = delflaglistvalue;
	}

	public Integer getRefId() {
		return refId;
	}

	public void setRefId(Integer refId) {
		this.refId = refId;
	}

	public String getDefaultPasswordChanged() {
		return defaultPasswordChanged;
	}

	public void setDefaultPasswordChanged(String defaultPasswordChanged) {
		this.defaultPasswordChanged = defaultPasswordChanged;
	}

	public String getUserActive() {
		return userActive;
	}

	public void setUserActive(String userActive) {
		this.userActive = userActive;
	}

	public String getUserDelete() {
		return userDelete;
	}

	public void setUserDelete(String userDelete) {
		this.userDelete = userDelete;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getSuccessLogin() {
		return successLogin;
	}

	public void setSuccessLogin(Date successLogin) {
		this.successLogin = successLogin;
	}

	public Date getFailedLogin() {
		return failedLogin;
	}

	public void setFailedLogin(Date failedLogin) {
		this.failedLogin = failedLogin;
	}

	public Date getNextPasswordChangeDate() {
		return nextPasswordChangeDate;
	}

	public void setNextPasswordChangeDate(Date nextPasswordChangeDate) {
		this.nextPasswordChangeDate = nextPasswordChangeDate;
	}

	public Integer getLastSessionId() {
		return lastSessionId;
	}

	public void setLastSessionId(Integer lastSessionId) {
		this.lastSessionId = lastSessionId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<UserAccessManagerSubForm> getUserDetailSubForm() {
		return userDetailSubForm;
	}

	public void setUserDetailSubForm(
			List<UserAccessManagerSubForm> userDetailSubForm) {
		this.userDetailSubForm = userDetailSubForm;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getDispatchid() {
		return dispatchid;
	}

	public void setDispatchid(String dispatchid) {
		this.dispatchid = dispatchid;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	
}
