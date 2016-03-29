<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- saved from url=(0057)http://wbpreview.com/previews/WB01BG165/user-account.html -->
<html lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
    <title>Clinical Laboratory - Admin Dashboard</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">    
    
    <!-- CSS files -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap-responsive.min.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/alveolae.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrapdate.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/pikaday.css">
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.18.custom.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.js"></script>    
    <script src="${pageContext.request.contextPath}/resources/js/zebra_datepicker.js"></script>
   
    <!-- Google font -->
    <link href="/css/css.css" rel="stylesheet" type="text/css">

	<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->	
</head>
<form:form commandName="PatienManagerAdd" id="patientaddid">
<body>
<!-- Navbar -->

	<!-- /Navbar -->
	
	<!-- Main content -->
	<div id="main-content">
		<!-- Container -->
		<div class="container">
			<!-- Header boxes -->
			<div class="box-container">
					<div class="alert alert-success alert-block" id="sucessdiv">
						<button type="button" class="close" onClick="sucessclose()" data-dismiss="alert">&times;</button>
						<h4>New Patient Added Successfully!</h4>
					</div>
                    <div class="alert alert-error alert-block" id="errordiv">
						<button type="button" class="close" onClick="errorclose()"  data-dismiss="alert">&times;</button>
						<h4>Error title!</h4>
					</div>
			</div>
			<!-- /Header boxes -->
			
                            <div class="row">
				<!-- Sidebar -->				
				<!-- /Sidebar -->				
				<!-- Content -->
				<div class="span12 desktop">					
				    <div class="widget">                    					
					<div class="widget-content"> 
                                            <div class="span7">
                                            <h3>Patient Manager : New Patient </h3>	
                                            </div>                       
                                                   
                                                <div class="span3">                                                                
                                                    <div class="box-holder">
													<a href="#" id="saveenable" class="saveenable" onclick="newSave()">
													<div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-save.png"/>Save</div></a>
										
													<a href="#" id="savedisable" class="savedisable"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save.png"/>Save</div></a>
													</div> 													
                                                    <div class="box-holder">
													<a href="#" id="savenewenable" class="savenewenable" onclick="savenew()" ><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-save-new.PNG"/>Save-New</div></a>
													
													<a href="#" id="savenewdisable" class="savenewdisable" ><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save-new.PNG"/>Save-New</div></a>
													</div>
                                                    <div class="box-holder">
													<a href="#"id="savecloseenable" class="savecloseenable" onClick="saveclose()" ><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-saveclose.PNG"/>Save-Close</div></a>
													
													<a href="#"id="saveclosedisable" class="saveclosedisable" ><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-saveclose.PNG"/>Save-Close</div></a>
													</div>
                                                    <div class="box-holder">
													<a href="${pageContext.request.contextPath}/patientManager"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-close.png"/>Close</div></a>
													</div>
                                                </div>                 												
                                        </div>                                    
                                    </div>	              
                                </div>
                            </div>
				<div class="row">
                                <!-- Sidebar -->
				<div class="span3">
				     <div class="widget-content">						
					    <div class="mobile"><h3>Patient Manager : New Patient</h3></div> 
						<div class="span2"><img src="${pageContext.request.contextPath}/download"/></div>
				     </div> 
					<ul id="sidebar" class="nav nav-tabs nav-stacked">
						<li><a href="#" onClick="createuser()" id="user">Create User & Online Access</a></li>
						<li><a href="#" id="addtest">Clinical Tests Manager</a></li>
					</ul>
				</div>
				<!-- /Sidebar -->
				
				<!-- Content -->
				<div class="span9">
					
								
					<div class="widget">
						
						<div class="widget-content">
						<div class="row">
								<div class="span4">
                                	<label>Referring Doctor<font color="#FF0000"> *</font></label>
									<form:select path="referringDoctor" class="span4" id="dname" onBlur="validateDrName()">
									<option>Select Referring Doctor</option>
									<form:options items="${drname}" itemLabel="referringDoctor" itemValue="referringDoctorid"/>
									</form:select>
                                     <span style="color:red" id="drnam"></span>
                                  
								</div>
								<div class="span4">
                                	<label>Referring Test Vendor <font color="#FF0000"> *</font></label>
                                    <form:select path="referringVendor" class="span4" id="vname" onBlur="validateVnrName()">
                                    <option>Select Referring Test Vendor</option>
                                   	<form:options items="${vnname}" itemLabel="referringVendor" itemValue="referringVendoid"/>
									</form:select>
                                     <span style="color:red" id="vnrnam"></span>
                                   
								</div>
                            </div>  
							<div class="row">
								<div class="span4">
                                	<label>Name<font color="#FF0000"> *</font></label>
                               		<form:input path="patientName" placeholder="Patient Name" id="pname" class="span4" onKeyPress="return isNumberKey(event)" onBlur="validatePname()"/>
                                    <span style="color:red" id="pn"></span>
                                </div>	
                                							
								<div class="span4">
                                	<label>Sex<font color="#FF0000"> *</font></label>
								     <form:select path="sex" class="span4" id="selectsex" onBlur="validateSex()" >	
								           <option>Select Sex</option>							           
                                           <form:options items="${sexTypeList}"/>
								     </form:select>
                                     <span style="color:red" id="sexerror"></span>
								</div>
							</div>
                                
							<div class="row">
								<div class="span4">
                                	<label>Date Of Birth<font color="#FF0000"> *</font></label>
                                    <form:input path="dateOfBirth" placeholder="Date Of Birth" id="dob" onBlur="validateDob()" class="span4 datepickerdob" data-zdp_direction="1"/>
                                    <span style="color:red" id="doberror"></span>
                                </div>
                                
								<div class="span4">
                                	<label>Age<font color="#FF0000"> *</font></label>
                                    <form:input path="age" placeholder="Age" id="age" onBlur="validateAge()" class="span4" onKeyPress="return isNumberKey2(event)"/>
                                    <span style="color:red" id="ageerror"></span>
                                </div>                             
							</div>
                              <div class="row">
								<div class="span4">
                                	<label>Preferred Contact<font color="#FF0000"> *</font></label>
									<form:select path="preferredContactMethod" class="span4" id="paprefcontact" onBlur="validatePrefCont()">
									<option>Select Preferred Contact</option>
									<form:options items="${prefferedlisttype}" />
									</form:select><span style="color:red" id="prefconterror"></span>
								</div>
								<div class="span4">
                                	<label>Send SMS Alerts?</label>
                                    <form:select path="smsAlerts" class="span4" id="smsalert">
                                    <option>Select</option>
                                    <form:options items="${smslisttype}"/>
                                     </form:select>
								</div>
                            </div>   
							<div class="row">
								<div class="span4">
                                	<label>E-mail ID<font color="#FF0000"> *</font></label>
                               		<form:input path="emailId" placeholder="E-mail ID" id="mailid" onBlur="validateEmail()" class="span4"/>
                                    <span style="color:red" id="emailerror"></span>
                                </div>
								<div class="span4">
                                	<label>Alternate E-mail ID</label>
                                	<form:input path="alternateEmailId" placeholder="Alternate E-mail ID"  id="aemailid" class="span4"/>
                                </div>
							</div>
							<div class="row">
								<div class="span4">
                                <label>Phone Mobile<font color="#FF0000"> *</font></label>
                                <form:input path="phoneMobile"  placeholder="Phone Mobile(Please Enter Numeric Value)" id="mobile" onBlur="validateMobile()" class="span4" maxlength="12" onKeyPress="return isNumberKey2(event)"/>
                                <span style="color:red" id="mobileerror"></span>
                                </div>
								<div class="span4">
                                <label>Phone LandLine</label>
                                <form:input path="phoneLandline"  placeholder="Phone LandLine(Please Enter Numeric Value)" id="landline" class="span4" maxlength="10" onKeyPress="return isNumberKey2(event)"/>
                                </div>
							</div>
							<div class="row">
								<div class="span4">
                                <label>Emergency Phone</label>
                                <form:input path="emergencyPhoneNumber" placeholder="Emergency Phone(Please Enter Numeric Value)" id="emerphone" class="span4" maxlength="12" onKeyPress="return isNumberKey2(event)"/>
                                </div>
								<div class="span4">
                                <label>Phone Fax</label>
                                <form:input path="phoneFax" placeholder="Phone Fax(Please Enter Numeric Value)" id="fax" class="span4" maxlength="10" onKeyPress="return isNumberKey2(event)"/>
                                </div>
							</div>
                            
                          <!--<div class="row">
								<div class="span4">
                                <label>Preferred Contact<font color="#FF0000"> *</font></label>
                                <form:input path="preferredContactMethod" placeholder="Preferred Contact" id="paprefcontact" class="span4" onBlur="validatePrefCont()"/>
                                <span style="color:red" id="prefconterror"></span>
                                </div>
								<div class="span4">
                                <label>Send SMS Alerts?</label>
                                <form:input path="smsAlerts" placeholder="Send SMS Alerts?" id="smsalert" class="span4"/>
                                </div>
						    </div>  -->
							<div class="row">
								<div class="span4">
                                <label>Door/Building</label>
                                <form:input path="addressLine1" placeholder="Door/Building" id="addressline1" class="span4"/>
                                </div>
								<div class="span4">
                                <label>StreetName</label>
                                <form:input path="addressLine2" placeholder="StreetName" id="addressline2" class="span4"/>
                                </div>
							</div>
							<div class="row">
								<div class="span4">
                                <label>Area</label>
                                <form:input path="area" placeholder="Area" id="area" class="span4"/>
                                </div>
								<div class="span4">
                                <label>Post Office Code</label>
                                <form:input path="postofficecode" placeholder="Post Office Code(Please Enter Numeric Value)" id="postcode" maxlength="7" class="span4" onBlur="postinputValue();" onKeyPress="return isNumberKey2(event)"/>
                                </div>
							</div>
							<div class="row">
								<div class="span4">
                                <label>City</label>
                                <form:input path="city" placeholder="City" id="city" class="span4"/>
                                </div>
								<div class="span4">
                                <label>District</label>
                                <form:input path="district" placeholder="District" id="district" class="span4"/>
                                </div>
							</div>
							<div class="row">
								<div class="span4">
                                <label>State</label>
                                <form:input path="state" placeholder="State" id="state" class="span4"/>
                                </div>
								<div class="span4">
                                <label>Country</label>
                                <form:input path="country" placeholder="Country" id="country" class="span4"/>
                                </div>
							</div>
							            		
							
						</div>
					</div>
                                     
				</div>
	<div class="dock-wrapper">    
        <div class="navbar navbar-fixed-bottom">
            <div class="navbar-inner">
                <div class="container">                  
                    <center>
                        <div class="btn-group btn-group-justified">  
                            <a href="#" id="saveenable" class="saveenable btn btn-default" onclick="newSave()" >
						    <img src="${pageContext.request.contextPath}/resources/images/e-save.png"/><br>Save</a>
							<a id="savedisable" class="savedisable btn btn-default" />
							<img src="${pageContext.request.contextPath}/resources/images/d-save.png"/><br>Save</a>
						
                            <a href="#" id="savenewenable" class="savenewenable btn btn-default" onclick="savenew()">
						    <img src="${pageContext.request.contextPath}/resources/images/e-save-new.PNG"/><br>Save-New</a>
						    <a href="#" id="savenewdisable" class="savenewdisable btn btn-default" >
							<img src="${pageContext.request.contextPath}/resources/images/d-save-new.PNG"/><br>Save-New</a>
								  
					   
                            <a href="#"id="savecloseenable" class="savecloseenable btn btn-default" onClick="saveclose()" >
						    <img src="${pageContext.request.contextPath}/resources/images/e-saveclose.PNG"/><br>Save-Close</a>
							<a href="#"id="saveclosedisable" class="saveclosedisable btn btn-default" >
							<img src="${pageContext.request.contextPath}/resources/images/d-saveclose.PNG"/><br>Save-Close</a>
						
                            <a href="${pageContext.request.contextPath}/patientManager" class="btn btn-default">
                            <img src="${pageContext.request.contextPath}/resources/images/e-close.png"/><br>Close</a></li>
                        </div>
                    </center>                      		
				</div>
           	</div>
		</div>
    </div>
				<!-- /Content -->
			</div>
		    <div id="footer">
				<hr>
				<p class="pull-right">Gaddiel Technologies Pvt Ltd &copy; 2013</p>
			</div>
                </div>
        </div>
        <form:hidden path="dispatch"/>
        <form:hidden path="patientId"/>
</body>
<script>
var form = document.getElementById("patientaddid");
var js=jQuery.noConflict();
js("#sucessdiv").hide();
js("#errordiv").hide(); 
js("#user").hide();
js("#addtest").hide();

js(".saveenable").show();
js(".savedisable").hide();

js(".savenewenable").show();
js(".savenewdisable").hide();

js(".savecloseenable").show();
js(".saveclosedisable").hide();

function sucessclose()
{
	
	js("#sucessdiv").hide();
	
}
function errorclose()
{
	
	js("#errordiv").hide(); 
}
function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode != 32 && charCode > 31 
     && (charCode < 65 || charCode > 90)
		 && (charCode < 97 || charCode > 122))
      return false;
   return true;
}
function isNumberKey2(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode != 46 && charCode > 31 
     && (charCode < 48 || charCode > 57))
      return false;  
   return true;
}
</script>
<script>
function validateDrName()
{ 
 if(document.getElementById("dname").value=="Select Referring Doctor")
 {   
   document.getElementById("drnam").innerHTML="Please Enter Referring Doctor ";
   document.getElementById("dname").style.borderColor="#FF0000";
 }
 else
 {
    document.getElementById("drnam").innerHTML=" ";
    document.getElementById("dname").style.borderColor="#64FE2E";	
 }
}
function validateVnrName()
{ 
 if(document.getElementById("vname").value=="Select Referring Test Vendor")
 {   
   document.getElementById("vnrnam").innerHTML="Please Enter Referring Test Vendor ";
   document.getElementById("vname").style.borderColor="#FF0000";
 }
 else
 {
    document.getElementById("vnrnam").innerHTML=" ";
    document.getElementById("vname").style.borderColor="#64FE2E";	
 }
}
function validatePname()
{ 
 if(document.getElementById("pname").value=="")
 {
   document.getElementById("pn").innerHTML="Please Enter the Patien Name";
   document.getElementById("pname").style.borderColor="#FF0000";
 }
 else
 {
    document.getElementById("pn").innerHTML=" ";
    document.getElementById("pname").style.borderColor="#64FE2E";	
 }
}
function validateSex()
{ 
 if(document.getElementById("selectsex").value=="Select Sex")
 {   
   document.getElementById("sexerror").innerHTML="Please Enter the M Or F ";
   document.getElementById("selectsex").style.borderColor="#FF0000";
 }
 else
 {
    document.getElementById("sexerror").innerHTML=" ";
    document.getElementById("selectsex").style.borderColor="#64FE2E";	
 }
}
function validateDob()
{ 
 if(document.getElementById("dob").value=="")
 {   
   document.getElementById("doberror").innerHTML="Please Enter the Date of birth ";
   document.getElementById("dob").style.borderColor="#FF0000";
 }
 else
 {
    document.getElementById("doberror").innerHTML=" ";
    document.getElementById("dob").style.borderColor="#64FE2E";	
 }
}
function validateAge()
{ 
 if(document.getElementById("age").value=="")
 {   
   document.getElementById("ageerror").innerHTML="Please Enter the Age ";
   document.getElementById("age").style.borderColor="#FF0000";
 }
 else
 {
    document.getElementById("ageerror").innerHTML=" ";
    document.getElementById("age").style.borderColor="#64FE2E";	
 }
}
function validateEmail()
{ 
 if(document.getElementById("mailid").value=="")
 {   
   document.getElementById("emailerror").innerHTML="Please Enter the Valid email id";
   document.getElementById("mailid").style.borderColor="#FF0000";
 }
 else
 {
    document.getElementById("emailerror").innerHTML=" ";
    document.getElementById("mailid").style.borderColor="#64FE2E";	
 }
}
function validateMobile()
{ 
 if(document.getElementById("mobile").value=="")
 {   
   document.getElementById("mobileerror").innerHTML="Please Enter Phone Mobile Number ";
   document.getElementById("mobile").style.borderColor="#FF0000";
 }
 else
 {
    document.getElementById("mobileerror").innerHTML=" ";
    document.getElementById("mobile").style.borderColor="#64FE2E";	
 }
}
function validatePrefCont()
{ 
 if(document.getElementById("paprefcontact").value=="Select Preferred Contact")
 {   
   document.getElementById("prefconterror").innerHTML="Please Enter the PrefferredContact";
        document.getElementById("paprefcontact").style.borderColor="#FF0000";
 }
 else
 {
    document.getElementById("prefconterror").innerHTML=" ";
    document.getElementById("paprefcontact").style.borderColor="#64FE2E";	
 }
}
function newSave()
{
//alert("HIt save function");
	var drName=document.getElementById("dname").value;
	var vnrName=document.getElementById("vname").value;
	var paName=document.getElementById("pname").value;
	var pSex=document.getElementById("selectsex").value;
	var pDob=document.getElementById("dob").value;
	var pAge=document.getElementById("age").value;
	var pEmailid=document.getElementById("mailid").value;
	var pMobile=document.getElementById("mobile").value;
	var pPrefcontact=document.getElementById("paprefcontact").value;
	//alert(pEmailid.length);
	var check=false;
	if(pEmailid.length!=0)
		{
			//alert("chek valid");	
			var atpos=pEmailid.indexOf("@");
			var dotpos=pEmailid.lastIndexOf(".");
			if(atpos<1 || dotpos<atpos+2 || dotpos+2>=pEmailid.length)
			{
				document.getElementById("emailerror").innerHTML="Please Enter the Valid email id";
				document.getElementById("mailid").style.borderColor="#FF0000";
				check=true;
			}	
		}	
	
	if(drName=="Select Referring Doctor"||vnrName=="Select Referring Test Vendor"||paName==""||pSex=="Select Sex"||pDob==""||pAge==""||pEmailid==""||pMobile==""||pPrefcontact=="Select Preferred Contact")
	{
		
		if(drName=="Select Referring Doctor")
		{
		 	document.getElementById("drnam").innerHTML="Please Enter Referring Doctor ";
   			document.getElementById("dname").style.borderColor="#FF0000";
		}
		if(vnrName=="Select Referring Test Vendor")
		{
			document.getElementById("vnrnam").innerHTML="Please Enter Referring Test Vendor ";
   			document.getElementById("vname").style.borderColor="#FF0000";
		}
		if(paName=="")
		{
			document.getElementById("pn").innerHTML="Please Enter the Patien Name";
			document.getElementById("pname").style.borderColor="#FF0000";
		}
		if(pSex=="Select Sex")
		{
			document.getElementById("sexerror").innerHTML="Please Enter the M Or F ";
			document.getElementById("selectsex").style.borderColor="#FF0000";
		}
		if(pDob=="")
		{
			document.getElementById("doberror").innerHTML="Please Enter the Date of birth ";
			document.getElementById("dob").style.borderColor="#FF0000";
		}
		if(pAge=="")
		{
			document.getElementById("ageerror").innerHTML="Please Enter the Age ";
			document.getElementById("age").style.borderColor="#FF0000";
		}	
		if(pEmailid=="")
		{
			document.getElementById("emailerror").innerHTML="Please Enter the Valid email id";
			document.getElementById("mailid").style.borderColor="#FF0000";	    
		}	
		
		if((pMobile=="")||(pMobile.length<10))
		{
			document.getElementById("mobileerror").innerHTML="Please Enter Phone Mobile Number";
			document.getElementById("mobile").style.borderColor="#FF0000";
		}
		if(pPrefcontact=="Select Preferred Contact")
		{
			document.getElementById("prefconterror").innerHTML="Please Enter the PrefferredContact";
			document.getElementById("paprefcontact").style.borderColor="#FF0000";
		}	
	}
	
	else
	{ 
		if(check==false){
		form.dispatch.value="Save";
		form.submit();
		//alert("New Patient Added.");
		}
		
	}
}
	//alert(form.dispatch.value);
	if(form.dispatch.value=="Save")
	{
		js("#sucessdiv").show();
		js("#dname").attr("disabled", true);
		js("#vname").attr("disabled", true);
		js("#pname").attr("disabled", true);
		js("#selectsex").attr("disabled", true);
		js("#dob").attr("disabled", true);
		js("#age").attr("disabled", true);
		js("#mailid").attr("disabled", true);
		js("#aemailid").attr("disabled", true);
		js("#mobile").attr("disabled", true);
		js("#landline").attr("disabled", true);
		js("#emerphone").attr("disabled", true);
		js("#fax").attr("disabled", true);
		js("#addressline1").attr("disabled", true);
		js("#addressline2").attr("disabled", true);
		js("#area").attr("disabled", true);
		js("#postcode").attr("disabled", true);
		js("#city").attr("disabled", true);
		js("#district").attr("disabled", true);
		js("#state").attr("disabled", true);
		js("#country").attr("disabled", true);
		js("#paprefcontact").attr("disabled", true);
		js("#smsalert").attr("disabled", true);
		
		js("#user").show();
		js("#addtest").show();
		
		js(".saveenable").hide();
		js(".savedisable").show();

		js(".savenewenable").hide();
		js(".savenewdisable").show();

		js(".savecloseenable").hide();
		js(".saveclosedisable").show();
}
function savenew()
{

//alert("HIt save& NEW function");

	var drName=document.getElementById("dname").value;
	var vnrName=document.getElementById("vname").value;
	var paName=document.getElementById("pname").value;
	var pSex=document.getElementById("selectsex").value;
	var pDob=document.getElementById("dob").value;
	var pAge=document.getElementById("age").value;
	var pEmailid=document.getElementById("mailid").value;
	var pMobile=document.getElementById("mobile").value;
	var pPrefcontact=document.getElementById("paprefcontact").value;
	//alert(pEmailid.length);
	var check=false;
	if(pEmailid.length!=0)
		{
			//alert("chek valid");	
			var atpos=pEmailid.indexOf("@");
			var dotpos=pEmailid.lastIndexOf(".");
			if(atpos<1 || dotpos<atpos+2 || dotpos+2>=pEmailid.length)
			{
				document.getElementById("emailerror").innerHTML="Please Enter the Valid email id";
				document.getElementById("mailid").style.borderColor="#FF0000";
				check=true;
			}	
		}	
	
	if(drName=="Select Referring Doctor"||vnrName=="Select Referring Test Vendor"||paName==""||pSex=="Select Sex"||pDob==""||pAge==""||pEmailid==""||pMobile==""||pPrefcontact=="Select Preferred Contact")
	{
		
		if(drName=="Select Referring Doctor")
		{
		 	document.getElementById("drnam").innerHTML="Please Enter Referring Doctor ";
   			document.getElementById("dname").style.borderColor="#FF0000";
		}
		if(vnrName=="Select Referring Test Vendor")
		{
			document.getElementById("vnrnam").innerHTML="Please Enter Referring Test Vendor ";
   			document.getElementById("vname").style.borderColor="#FF0000";
		}
		if(paName=="")
		{
			document.getElementById("pn").innerHTML="Please Enter the Patien Name";
			document.getElementById("pname").style.borderColor="#FF0000";
		}
		if(pSex=="Select Sex")
		{
			document.getElementById("sexerror").innerHTML="Please Enter the M Or F ";
			document.getElementById("selectsex").style.borderColor="#FF0000";
		}
		if(pDob=="")
		{
			document.getElementById("doberror").innerHTML="Please Enter the Date of birth ";
			document.getElementById("dob").style.borderColor="#FF0000";
		}
		if(pAge=="")
		{
			document.getElementById("ageerror").innerHTML="Please Enter the Age ";
			document.getElementById("age").style.borderColor="#FF0000";
		}	
		if(pEmailid=="")
		{
			document.getElementById("emailerror").innerHTML="Please Enter the Valid email id";
			document.getElementById("mailid").style.borderColor="#FF0000";	    
		}	
		
		if((pMobile=="")||(pMobile.length<10))
		{
			document.getElementById("mobileerror").innerHTML="Please Enter Phone Mobile Number";
			document.getElementById("mobile").style.borderColor="#FF0000";
		}
		if(pPrefcontact=="Select Preferred Contact")
		{
			document.getElementById("prefconterror").innerHTML="Please Enter the PrefferredContact";
			document.getElementById("paprefcontact").style.borderColor="#FF0000";
		}	
	}
	
	else
	{ 
		if(check==false){
		form.dispatch.value="SaveNew";
		form.submit();	
		//alert("New Patient Added.");
		}
		
	}
	
}
//alert(form.dispatch.value);
if(form.dispatch.value=="SaveNew")
{
	//alert(" SAVE NEW ");
	document.getElementById("dname").value="";
	document.getElementById("vname").value="";
	document.getElementById("pname").value="";
	document.getElementById("selectsex").value="";
	document.getElementById("dob").value="";
	document.getElementById("age").value="";
	document.getElementById("mailid").value="";
	document.getElementById("aemailid").value="";
	document.getElementById("mobile").value="";
	document.getElementById("landline").value="";
	document.getElementById("emerphone").value="";
	document.getElementById("fax").value="";
	document.getElementById("addressline1").value="";
	document.getElementById("addressline2").value="";
	document.getElementById("area").value="";
	document.getElementById("postcode").value="";
	document.getElementById("city").value="";
	document.getElementById("district").value="";
	document.getElementById("state").value="";
	document.getElementById("country").value="";
	document.getElementById("paprefcontact").value="";
	document.getElementById("smsalert").value="";
	js("#user").hide();
	js("#addtest").hide();
	
}
function saveclose()
{
	var drName=document.getElementById("dname").value;
	var vnrName=document.getElementById("vname").value;
	var paName=document.getElementById("pname").value;
	var pSex=document.getElementById("selectsex").value;
	var pDob=document.getElementById("dob").value;
	var pAge=document.getElementById("age").value;
	var pEmailid=document.getElementById("mailid").value;
	var pMobile=document.getElementById("mobile").value;
	var pPrefcontact=document.getElementById("paprefcontact").value;
	//alert(pEmailid.length);
	var check=false;
	if(pEmailid.length!=0)
		{
			//alert("chek valid");	
			var atpos=pEmailid.indexOf("@");
			var dotpos=pEmailid.lastIndexOf(".");
			if(atpos<1 || dotpos<atpos+2 || dotpos+2>=pEmailid.length)
			{
				document.getElementById("emailerror").innerHTML="Please Enter the Valid email id";
				document.getElementById("mailid").style.borderColor="#FF0000";
				check=true;
			}	
		}	
	
	if(drName=="Select Referring Doctor"||vnrName=="Select Referring Test Vendor"||paName==""||pSex=="Select Sex"||pDob==""||pAge==""||pEmailid==""||pMobile==""||pPrefcontact=="Select Preferred Contact")
	{
		if(drName=="Select Referring Doctor")
		{
		 	document.getElementById("drnam").innerHTML="Please Enter Referring Doctor ";
   			document.getElementById("dname").style.borderColor="#FF0000";
		}
		if(vnrName=="Select Referring Test Vendor")
		{
			document.getElementById("vnrnam").innerHTML="Please Enter Referring Test Vendor ";
   			document.getElementById("vname").style.borderColor="#FF0000";
		}
		if(paName=="")
		{
			document.getElementById("pn").innerHTML="Please Enter the Patien Name";
			document.getElementById("pname").style.borderColor="#FF0000";
		}
		if(pSex=="Select Sex")
		{
			document.getElementById("sexerror").innerHTML="Please Enter the M Or F ";
			document.getElementById("selectsex").style.borderColor="#FF0000";
		}
		if(pDob=="")
		{
			document.getElementById("doberror").innerHTML="Please Enter the Date of birth ";
			document.getElementById("dob").style.borderColor="#FF0000";
		}
		if(pAge=="")
		{
			document.getElementById("ageerror").innerHTML="Please Enter the Age ";
			document.getElementById("age").style.borderColor="#FF0000";
		}	
		if(pEmailid=="")
		{
			document.getElementById("emailerror").innerHTML="Please Enter the Valid email id";
			document.getElementById("mailid").style.borderColor="#FF0000";	    
		}	
		
		if((pMobile=="")||(pMobile.length<10))
		{
			document.getElementById("mobileerror").innerHTML="Please Enter Phone Mobile Number";
			document.getElementById("mobile").style.borderColor="#FF0000";
		}
		if(pPrefcontact=="Select Preferred Contact")
		{
			document.getElementById("prefconterror").innerHTML="Please Enter the PrefferredContact";
			document.getElementById("paprefcontact").style.borderColor="#FF0000";
		}	
	}
	
	else
	{ 
		if(check==false)
		{
			form.dispatch.value="Save&Close";
			form.submit();	
		}
	}
}
function postinputValue()
{
//alert("CHECK RECORD HIT");
	var post_No=document.getElementById("postcode").value;
	js(function() {
		js.post("${pageContext.request.contextPath}/postofficePatient/inputvalue",
					{postno: post_No},
				function(data){
				document.getElementById("city").value=data[0].city;				
				document.getElementById("district").value=data[0].district;				
				document.getElementById("state").value=data[0].state;				
				document.getElementById("country").value=data[0].country;				
				
			});
	});
}
function createuser()
{	
		form.dispatch.value="createuser";
        form.submit();		
}
</script>

	<script src="${pageContext.request.contextPath}/resources/js/moment-with-langs.js"></script>    
    <script src="${pageContext.request.contextPath}/resources/js/pikaday.js"></script>

<script>
	var picker = new Pikaday(
    {
		//changeMonth: true,
    	//changeYear: true,
		
        field: document.getElementById('dob'),		
        firstDay: 1,
	    //minDate: new Date('2000-01-01'),
       // maxDate: new Date('2020-12-31'),
        yearRange: [1920,2020],
		format: 'DD-MM-YYYY',
        onSelect: function() {
            console.log(this.getMoment().format('DD-MM-YYYY'));
        }
    });
	</script>
</form:form>
</html>