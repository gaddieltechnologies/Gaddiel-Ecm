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
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.18.custom.min.js"></script>
    <!-- Google font -->
    <link href="/css/css.css" rel="stylesheet" type="text/css">

	<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->	
</head>

<form:form commandName="refferdLabIfoAdd" id="testvendor">
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
						<h4>New Vendor Added Successfully!</h4>
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
                                            <h3>Test Vendor Manager : New Vendor </h3>	
                                            </div>                       
                                                <div class="span3">                                                                
                                                    <div class="box-holder">
													<a id="save-enable" class="save-enable" href="#" onclick="newSave()"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-save.png"/>Save</div></a>
													<a id="save-disable" class="save-disable"href="#" ><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save.png"/>Save</div></a>
													</div>  													
                                                    <div class="box-holder">
													<a id="SN-e" class="SN-e" href="#" onclick="savenew()"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-save-new.PNG"/>Save-New</div></a>
													<a id="SN-d" class="SN-d" href="#"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save-new.PNG"/>Save-New</div></a>
													</div> 
                                                    <div class="box-holder">
													<a id="SC-e" class="SC-e" href="#" onclick="saveclose()"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-saveclose.PNG"/>Save-Close</div></a>
													<a id="SC-d" class="SC-d" href="#" ><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-saveclose.PNG"/>Save-Close</div></a>
													</div>
                                                    <div class="box-holder">
													<a id="closeE" class="closeE" href="${pageContext.request.contextPath}/refferdLabIfo"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-close.png"/>Close</div></a>
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
					    <div class="mobile"><h3>Test Vendor Manager:New Vendor </h3></div> 
						<div class="span2"><img src="${pageContext.request.contextPath}/download"/></div>
				</div>	
					<ul id="sidebar" class="nav nav-tabs nav-stacked">
						
						<li><a href="#" onclick="createuser()" id="user">Create User & Online Access</a></li>
						<li><a href="#" id="testcate">Test Categories</a></li>
					</ul>
				</div>
				<!-- /Sidebar -->
				
				<!-- Content -->
				<div class="span9">
					
								
					<div class="widget">
						
						<div class="widget-content">
							
						
								<div class="row">
								<div class="span4"><label>Vendor Name<span style="color:red"> *</span></label><form:input path="testVendorName" placeholder="Vendor Name" class="span4" id="vendorname" onKeyPress="return isNumberKey(event)" onBlur="vendname()"/><span style="color:red" id="names"></span></div>								
								<div class="span4"><label>Lab Regn#<span style="color:red"> *</span></label><form:input path="testVendorRegnNumber" placeholder="Vendor Reg No(Please Enter Numeric Value)" class="span4" id="labregno" onKeyPress="return isNumberKey2(event)" onBlur="labreg()" /><span style="color:red" id="regno"></span></div>		     							      
								</div>
								<div class="row">
								<div class="span4"><label>Contact Name<span style="color:red"> *</span></label><form:input path="vendorContactName" placeholder="Vendor Contact Name" id="picker1" class="span4" onKeyPress="return isNumberKey(event)" onBlur="contacname()" /><span style="color:red" id="contname"></span></div>
								<div class="span4"><label>Tie-Up<span style="color:red"> *</span></label>								
								           <form:select path="tieUp" class="span4" id="tiiup"  onBlur="tiup()">
								           <option value="0">Select</option>	
										    <form:options items="${tieuplistvalue}"/>
								           </form:select><span style="color:red" id="tup"></span>								
								</div>                             
								</div>
								<div class="row">
								<div class="span4"><label>E-mail ID<span style="color:red"> *</span></label><form:input path="emailId" placeholder="E-mail ID" class="span4" id="emailid" onBlur="email()" /><span style="color:red" id="mailid"></span></div>
								<div class="span4"><label>Alternate E-mail ID</label><form:input path="alternateEmailId" placeholder="Alternate E-mail ID" class="span4" id="alternateemail" onBlur="alteremail()" /><span style="color:red" id="emailalter"></span></div>
								</div>
								<div class="row">
								<div class="span4"><label>Phone Mobile<span style="color:red"> *</span></label><form:input path="phoneMobile" placeholder="Phone Mobile(Please Enter Numeric Value)" class="span4" id="mobile"  maxlength="12" onKeyPress="return isNumberKey2(event)" onBlur="mobil()" /><span style="color:red" id="mobileid"></span></div>
								<div class="span4"><label>Phone LandLine</label><form:input path="phoneLandline" placeholder="Phone LandLine(Please Enter Numeric Value)" class="span4" id="landline" maxlength="10" onKeyPress="return isNumberKey2(event)"/></div>
								</div>
								<div class="row">
								<div class="span4"><label>Emergency Phone</label><form:input path="emergencyPhoneNumber" placeholder="Emergency Phone(Please Enter Numeric Value)" class="span4" id="emergencyphone" maxlength="12" onKeyPress="return isNumberKey2(event)"/></div>
								<div class="span4"><label>Phone Fax</label><form:input path="phoneFax" placeholder="Phone Fax(Please Enter Numeric Value)" class="span4" id="fax" maxlength="10" onKeyPress="return isNumberKey2(event)"/></div>
								</div>
								<div class="row">
								<div class="span4"><label>Door/Building</label><form:input path="addressLine1" placeholder="Door/Building" class="span4" id="addline1"/></div>
								<div class="span4"><label>StreetName</label><form:input path="addressLine2" placeholder="StreetName" class="span4" id="addline2"/></div>
								</div>
								<div class="row">
								<div class="span4"><label>Area</label><form:input path="area" placeholder="Area" class="span4" id="area" onKeyPress="return isNumberKey(event)"/></div>
								<div class="span4"><label>Post Office Code</label><form:input path="postOfficeCode" placeholder="Post Office Code(Please Enter Numeric Value)" class="span4" id="postcode" maxlength="7" onBlur="postinputValue();" onKeyPress="return isNumberKey2(event)"/></div>
								</div>
								<div class="row">
								<div class="span4"><label>City</label><form:input path="city" placeholder="City" class="span4" id="city"/></div>
								<div class="span4"><label>District</label><form:input path="district" placeholder="District" class="span4" id="dist"/></div>
								</div>
								<div class="row">
								<div class="span4"><label>State</label><form:input path="state" placeholder="State" class="span4" id="state"/></div>
								<div class="span4"><label>Country</label><form:input path="country" placeholder="Country" class="span4" id="county"/></div>
								</div>
								<div class="row">
								<div class="span4"><label>Preferred Contact<span style="color:red"> *</span></label>
								<form:select path="preferredContactMethod" class="span4" id="prefcontact" onBlur="prefcontac()">
								<option value="0">Select</option>
								<form:options items="${prefferedlisttype}" />
								</form:select><span style="color:red" id="prefcont"></span>
								</div>
								<div class="span4"><label>Send SMS Alerts?</label>								
								         <form:select path="smsAlerts" class="span4" id="smsalerts">
								         <option value="0">Select</option>									          						           
								           <form:options items="${smslisttype}" />
								           </form:select>
								</div>
						        </div>               		
							   <div class="row">
								<div class="span4"><label>Remarks</label><form:input path="remarks" placeholder="Remarks" class="span4" id="remarks"/></div>								
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
			<div class="dock-wrapper">    
        <div class="navbar navbar-fixed-bottom">
            <div class="navbar-inner">
                <div class="container">                  
                    <center>
                      <div class="btn-group btn-group-justified">                            
                        <a href="#" id="save-enable" class="save-enable btn btn-default"  onclick="newSave()" >
						     <img src="${pageContext.request.contextPath}/resources/images/e-save.png"/><br>Save</a>
							 <a id="save-disable" class="save-disable btn btn-default" />
							 <img src="${pageContext.request.contextPath}/resources/images/d-save.png"/><br>Save</a>
						
                        <a href="#" id="SN-e" class="SN-e btn btn-default" onclick="savenew()">
						      <img src="${pageContext.request.contextPath}/resources/images/e-save-new.PNG"/><br>Save & New</a>
						      <a href="#" id="SN-d" class="SN-d btn btn-default" >
							  <img src="${pageContext.request.contextPath}/resources/images/d-save-new.PNG"/><br>Save & New</a>
								  
					   
                        <a href="#"id="SC-e" class="SC-e btn btn-default" onClick="saveclose()" >
						     <img src="${pageContext.request.contextPath}/resources/images/e-saveclose.PNG"/><br>Save & Close</a>
							 <a href="#"id="SC-d" class="SC-d btn btn-default" >
							 <img src="${pageContext.request.contextPath}/resources/images/d-saveclose.PNG"/><br>Save & Close</a>
						
                        <a href="${pageContext.request.contextPath}/refferdLabIfo" class="btn btn-default">
                                  <img src="${pageContext.request.contextPath}/resources/images/e-close.png"/><br>Close</a>
                      </div>
                     </center>                    		
				</div>
           	</div>
		</div>
     </div>											
        </div>
      
        <% if(session.getAttribute("allowthirdparty").equals("N")) {%>
        		<form:hidden path="allowThirdPartyAccess" value="N" id="allowThirdPartyAccess"/>
        <%} else {%>
        		<form:hidden path="allowThirdPartyAccess" value="Y" id="allowThirdPartyAccess"/>	
        		<%} %>
<form:hidden path="dispatch" />
<form:hidden path="createuser"/>
<form:hidden path="testVendorId"/>        
</body>
<script>
var form=document.getElementById("testvendor");

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

$("#sucessdiv").hide();
$("#errordiv").hide(); 
$("#user").hide();
$("#testcate").hide();
$(".save-enable").show();
$(".save-disable").hide();
$(".SN-e").show();
$(".SN-d").hide();
$(".SC-e").show();
$(".SC-d").hide();

function sucessclose()
{
	
	$("#sucessdiv").hide();
	
}
function errorclose()
{
	
	$("#errordiv").hide(); 
}

function vendname()
{ 
 if(document.getElementById("vendorname").value=="")
 {
   document.getElementById("names").innerHTML="Please Enter the Vendor Name";
   document.getElementById("vendorname").style.borderColor="#FF0000";
 }
 else
 {
    document.getElementById("names").innerHTML=" ";
    document.getElementById("vendorname").style.borderColor="#64FE2E";	
 }
}
function labreg()
{ 
 if(document.getElementById("labregno").value=="")
 {
   document.getElementById("regno").innerHTML="Please Enter the LabRegister No";
   document.getElementById("labregno").style.borderColor="#FF0000";
 }
 else
 {
    document.getElementById("regno").innerHTML=" ";	
    document.getElementById("labregno").style.borderColor="#64FE2E";		
 }
}
function contacname()
{ 
 if(document.getElementById("picker1").value=="")
 {
   document.getElementById("contname").innerHTML="Please Enter the Contact Name";
   document.getElementById("picker1").style.borderColor="#FF0000";
 }
 else
 {
    document.getElementById("contname").innerHTML=" ";	
    document.getElementById("picker1").style.borderColor="#64FE2E";	
 }
}
function tiup()
{ 
 if(document.getElementById("tiiup").value=="Select")
 {   
   document.getElementById("tup").innerHTML="Please Enter the Y Or N";
   document.getElementById("tiiup").style.borderColor="#FF0000";
 }
 else
 {
    document.getElementById("tup").innerHTML=" ";
    document.getElementById("tiiup").style.borderColor="#64FE2E";	
 }
}
function email()
{ 
 if(document.getElementById("emailid").value=="")
 {   
   document.getElementById("mailid").innerHTML="Please Enter the EmailId";
   document.getElementById("emailid").style.borderColor="#FF0000";
 }
 else
 {
    document.getElementById("mailid").innerHTML=" ";
    document.getElementById("emailid").style.borderColor="#64FE2E";	
 }
}
function mobil()
{ 
 if(document.getElementById("mobile").value=="")
 {   
   document.getElementById("mobileid").innerHTML="Please Enter the MoileNo";
   document.getElementById("mobile").style.borderColor="#FF0000";
 }
 else
 {
    document.getElementById("mobileid").innerHTML=" ";	
    document.getElementById("mobile").style.borderColor="#64FE2E";		
 }
 }
function prefcontac()
{ 
 if(document.getElementById("prefcontact").value=="0")
 {   
   document.getElementById("prefcont").innerHTML="Please Enter the PrefferredContact";
   document.getElementById("prefcontact").style.borderColor="#FF0000";
 }
 else
 {
    document.getElementById("prefcont").innerHTML=" ";
    document.getElementById("prefcontact").style.borderColor="#64FE2E";	
 }
}

function newSave()
{ 
var Vendorname=document.getElementById("vendorname").value;
var Labreg=document.getElementById("labregno").value;
var Contactname=document.getElementById("picker1").value;
var Tieup=document.getElementById("tiiup").value;
var Emailid=document.getElementById("emailid").value;
var Mobile=document.getElementById("mobile").value;
var Prefcontact=document.getElementById("prefcontact").value;
var AlternateEmail=document.getElementById("alternateemail").value;
var check=false;
 //alert(Mobile.length);
	if(Emailid.length!=0)
		{
			//alert("chek valid");	
			var atpos=Emailid.indexOf("@");
			var dotpos=Emailid.lastIndexOf(".");
			if(atpos<1 || dotpos<atpos+2 || dotpos+2>=Emailid.length)
			{
				document.getElementById("mailid").innerHTML="Please Enter the Valid email id";
				document.getElementById("emailid").style.borderColor="#FF0000";
				check=true;
			}	
		}	
	if((Mobile.length <10))
	{	   
	   check=true;
	   document.getElementById("mobileid").innerHTML="Please Enter The Correct MoileNo";
       document.getElementById("mobile").style.borderColor="#FF0000";
	}
	
	
if(Vendorname==""||Labreg==""||Contactname==""||Tieup=="Select"||Emailid==""||Mobile==""||Prefcontact=="0")
{
    if(Vendorname=="")
	{
	   document.getElementById("names").innerHTML="Please Enter the Vendor Name";
       document.getElementById("vendorname").style.borderColor="#FF0000";
	}
	if(Labreg=="")
	{
	  document.getElementById("regno").innerHTML="Please Enter the LabRegister No";
      document.getElementById("labregno").style.borderColor="#FF0000";
	}
	if(Contactname=="")
	{
	   document.getElementById("contname").innerHTML="Please Enter the Contact Name";
       document.getElementById("picker1").style.borderColor="#FF0000";
	}
	if(Tieup=="Select")
	{
	   document.getElementById("tup").innerHTML="Please Enter the Y Or N";
       document.getElementById("tiiup").style.borderColor="#FF0000";
	}	
	if(Emailid=="")
	{
	  document.getElementById("mailid").innerHTML="Please Enter the EmailId";
      document.getElementById("emailid").style.borderColor="#FF0000";	    
	}	
	
	if(AlternateEmail.length!=0)
	{
	var atpos=AlternateEmail.indexOf("@");
   	var dotpos=AlternateEmail.lastIndexOf(".");
	if(atpos<1 || dotpos<atpos+2 || dotpos+2>=AlternateEmail.length)
	{
	 document.getElementById("emailalter").innerHTML="Please Enter the Correct EmailId";
     document.getElementById("alternateemail").style.borderColor="#FF0000";
	}	
	else
	{
	document.getElementById("emailalter").innerHTML=" ";	
    document.getElementById("alternateemail").style.borderColor="#64FE2E";		
	}
	}
	if(Mobile=="")
	{	   
	   //check=true;
	   document.getElementById("mobileid").innerHTML="Please Enter the MoileNo";
       document.getElementById("mobile").style.borderColor="#FF0000";
	}
	if(Prefcontact=="0")
	{
	    document.getElementById("prefcont").innerHTML="Please Enter the PrefferredContact";
        document.getElementById("prefcontact").style.borderColor="#FF0000";
	}	
}
else
{ 	
if(check==false)
		{   		   
			form.dispatch.value="save";
	        form.submit();		
		}		
}    
}
if(form.dispatch.value=="save"){
	$("#vendorname").attr("disabled", true);
	$("#labregno").attr("disabled", true);
	$("#picker1").attr("disabled", true);
	$("#tiiup").attr("disabled", true);
	$("#emailid").attr("disabled", true);
	$("#alternateemail").attr("disabled", true);
	$("#mobile").attr("disabled", true);
	$("#landline").attr("disabled", true);
	$("#emergencyphone").attr("disabled", true);
	$("#fax").attr("disabled", true);
	$("#addline1").attr("disabled", true);
	$("#addline2").attr("disabled", true);
	$("#area").attr("disabled", true);
	$("#postcode").attr("disabled", true);
	$("#city").attr("disabled", true);
	$("#dist").attr("disabled", true);
	$("#state").attr("disabled", true);
	$("#county").attr("disabled", true);
	$("#prefcontact").attr("disabled", true);
	$("#smsalerts").attr("disabled", true);
	$("#remarks").attr("disabled", true);
 if(document.getElementById("allowThirdPartyAccess").value=="Y")
	 {
	 $("#user").show();
	 }
 $("#sucessdiv").show();
$("#testcate").show();	
$(".save-enable").hide();
$(".save-disable").show();
$(".SN-e").hide();
$(".SN-d").show();
$(".SC-e").hide();
$(".SC-d").show();	
}
function savenew()
{
var Vendorname=document.getElementById("vendorname").value;
var Labreg=document.getElementById("labregno").value;
var Contactname=document.getElementById("picker1").value;
var Tieup=document.getElementById("tiiup").value;
var Emailid=document.getElementById("emailid").value;
var Mobile=document.getElementById("mobile").value;
var Prefcontact=document.getElementById("prefcontact").value;
var AlternateEmail=document.getElementById("alternateemail").value;
var check=false;
	if(Emailid.length!=0)
		{
			//alert("chek valid");	
			var atpos=Emailid.indexOf("@");
			var dotpos=Emailid.lastIndexOf(".");
			if(atpos<1 || dotpos<atpos+2 || dotpos+2>=Emailid.length)
			{
				document.getElementById("mailid").innerHTML="Please Enter the Valid email id";
				document.getElementById("emailid").style.borderColor="#FF0000";
				check=true;
			}	
		}	
if((Mobile.length <10))
	{	   
	   check=true;
	   document.getElementById("mobileid").innerHTML="Please Enter The Correct MoileNo";
       document.getElementById("mobile").style.borderColor="#FF0000";
	}		
if(Vendorname==""||Labreg==""||Contactname==""||Tieup=="Select"||Emailid==""||Mobile==""||Prefcontact=="0")
{
    if(Vendorname=="")
	{
	   document.getElementById("names").innerHTML="Please Enter the Vendor Name";
       document.getElementById("vendorname").style.borderColor="#FF0000";
	}
	if(Labreg=="")
	{
	  document.getElementById("regno").innerHTML="Please Enter the LabRegister No";
      document.getElementById("labregno").style.borderColor="#FF0000";
	}
	if(Contactname=="")
	{
	   document.getElementById("contname").innerHTML="Please Enter the Contact Name";
       document.getElementById("picker1").style.borderColor="#FF0000";
	}
	if(Tieup=="Select")
	{
	   document.getElementById("tup").innerHTML="Please Enter the Y Or N";
       document.getElementById("tiiup").style.borderColor="#FF0000";
	}	
	if(Emailid=="")
	{
	  document.getElementById("mailid").innerHTML="Please Enter the EmailId";
      document.getElementById("emailid").style.borderColor="#FF0000";	    
	}		
	if(AlternateEmail.length!="0")
	{
	var atpos=AlternateEmail.indexOf("@");
   	var dotpos=AlternateEmail.lastIndexOf(".");
	if(atpos<1 || dotpos<atpos+2 || dotpos+2>=AlternateEmail.length)
	{
	 document.getElementById("emailalter").innerHTML="Please Enter the Correct EmailId";
     document.getElementById("alternateemail").style.borderColor="#FF0000";
	}	
	else
	{
	document.getElementById("emailalter").innerHTML=" ";	
    document.getElementById("alternateemail").style.borderColor="#64FE2E";		
	}
	}
	if(Mobile=="")
	{
	   document.getElementById("mobileid").innerHTML="Please Enter the MoileNo";
       document.getElementById("mobile").style.borderColor="#FF0000";
	}
	if(Prefcontact=="0")
	{
	    document.getElementById("prefcont").innerHTML="Please Enter the PrefferredContact";
        document.getElementById("prefcontact").style.borderColor="#FF0000";
	}
	
}
else
{ 	
if(check==false)
		{
			form.dispatch.value="save&new";
	        form.submit();		
		}		
}    
}
if(form.dispatch.value=="save&new"){
	document.getElementById("vendorname").value=""
	document.getElementById("labregno").value=""
	document.getElementById("picker1").value=""
	document.getElementById("emailid").value=""
	document.getElementById("alternateemail").value=""
	document.getElementById("alternateemail").value=""
	document.getElementById("landline").value=""
	document.getElementById("emergencyphone").value=""
	document.getElementById("fax").value=""
	document.getElementById("fax").value=""
	document.getElementById("addline2").value=""
	document.getElementById("area").value=""
	document.getElementById("postcode").value=""
	document.getElementById("city").value=""
	document.getElementById("dist").value=""
	document.getElementById("state").value=""
	document.getElementById("county").value=""
	document.getElementById("prefcontact").value=""
	document.getElementById("smsalerts").value=""
	document.getElementById("remarks").value=""
$("#user").hide();
$("#testcate").hide();	
}
function saveclose(){
var Vendorname=document.getElementById("vendorname").value;
var Labreg=document.getElementById("labregno").value;
var Contactname=document.getElementById("picker1").value;
var Tieup=document.getElementById("tiiup").value;
var Emailid=document.getElementById("emailid").value;
var Mobile=document.getElementById("mobile").value;
var Prefcontact=document.getElementById("prefcontact").value;
var AlternateEmail=document.getElementById("alternateemail").value;
var check=false;
	if(Emailid.length!=0)
		{
			//alert("chek valid");	
			var atpos=Emailid.indexOf("@");
			var dotpos=Emailid.lastIndexOf(".");
			if(atpos<1 || dotpos<atpos+2 || dotpos+2>=Emailid.length)
			{
				document.getElementById("mailid").innerHTML="Please Enter the Valid email id";
				document.getElementById("emailid").style.borderColor="#FF0000";
				check=true;
			}	
		}
if((Mobile.length <10))
	{	   
	   check=true;
	   document.getElementById("mobileid").innerHTML="Please Enter The Correct MoileNo";
       document.getElementById("mobile").style.borderColor="#FF0000";
	}		
if(Vendorname==""||Labreg==""||Contactname==""||Tieup=="Select"||Emailid==""||Mobile==""||Prefcontact=="0")
{
    if(Vendorname=="")
	{
	   document.getElementById("names").innerHTML="Please Enter the Vendor Name";
       document.getElementById("vendorname").style.borderColor="#FF0000";
	}
	if(Labreg=="")
	{
	  document.getElementById("regno").innerHTML="Please Enter the LabRegister No";
      document.getElementById("labregno").style.borderColor="#FF0000";
	}
	if(Contactname=="")
	{
	   document.getElementById("contname").innerHTML="Please Enter the Contact Name";
       document.getElementById("picker1").style.borderColor="#FF0000";
	}
	if(Tieup=="Select")
	{
	   document.getElementById("tup").innerHTML="Please Enter the Y Or N";
       document.getElementById("tiiup").style.borderColor="#FF0000";
	}	
	if(Emailid=="")
	{
	  document.getElementById("mailid").innerHTML="Please Enter the EmailId";
      document.getElementById("emailid").style.borderColor="#FF0000";	    
	}	
	if(AlternateEmail.length!="0")
	{
	var atpos=AlternateEmail.indexOf("@");
   	var dotpos=AlternateEmail.lastIndexOf(".");
	if(atpos<1 || dotpos<atpos+2 || dotpos+2>=AlternateEmail.length)
	{
	 document.getElementById("emailalter").innerHTML="Please Enter the Correct EmailId";
     document.getElementById("alternateemail").style.borderColor="#FF0000";
	}	
	else
	{
	document.getElementById("emailalter").innerHTML=" ";	
    document.getElementById("alternateemail").style.borderColor="#64FE2E";		
	}
	}
	if(Mobile=="")
	{
	   document.getElementById("mobileid").innerHTML="Please Enter the MoileNo";
       document.getElementById("mobile").style.borderColor="#FF0000";
	}
	if(Prefcontact=="0")
	{
	    document.getElementById("prefcont").innerHTML="Please Enter the PrefferredContact";
        document.getElementById("prefcontact").style.borderColor="#FF0000";
	}
	
}
else
{ 	
if(check==false)
		{
			form.dispatch.value="save&close";
	        form.submit();		
		}		
}    
}
function postinputValue()
{
	var post_No=document.getElementById("postcode").value;
	$(function() {
		$.post("${pageContext.request.contextPath}/postoffice/inputvalue",
					{postno: post_No},
				function(data){
				document.getElementById("city").value=data[0].city;				
				document.getElementById("dist").value=data[0].district;				
				document.getElementById("state").value=data[0].state;				
				document.getElementById("county").value=data[0].country;				
				
			});
	});
}
function createuser()
{	
		form.dispatch.value="createuser";
        form.submit();		
}
</script>
</form:form>
</html>