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
<form:form commandName="doctorManagerAdd" id="next">
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
					<h4 id="successmessage">${doctorManagerAdd.successMessage}</h4>
					  </div>
                    <div class="alert alert-error alert-block" id="errordiv">
						<button type="button" class="close" onClick="errorclose()"  data-dismiss="alert">&times;</button>
						<h4 id="errormessage">${doctorManagerAdd.errorMessage}</h4>
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
                                            <h3>Doctor Manager : New Doctor </h3>	
                                            </div>                       
                                                <div class="span3">                                                                
                                                    <div class="box-holder">
													  <a href="#" id="sav" class="sav" onclick="add()">
													    <div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-save.png"/>Save</div></a>
										
													<a  id="savd" class="savd"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save.png"/>Save</div></a>
													</div> 													
                                                    <div class="box-holder">
													<a href="#" id="savnew" class="savnew" onclick="save()" ><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-save-new.PNG"/>Save-New</div></a>
													
													<a id="savnewd" class="savnewd" ><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save-new.PNG"/>Save-New</div></a>
													</div>
                                                    <div class="box-holder">
													<a href="#"id="savcol" class="savcol" onClick="saveclose()" ><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-saveclose.PNG"/>Save-Close</div></a>
													
													<a id="savcold" class="savcold" ><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-saveclose.PNG"/>Save-Close</div></a>
													</div>
                                                    <div class="box-holder">
													<a href="${pageContext.request.contextPath}/doctorManager"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-close.png"/>Close</div></a>
													</div>
                                                </div>                 
                                        </div>   
									
                                    </div>	              
                                </div>
                            </div>
				<div class="row">
                                <!-- Sidebar -->
				<div class="span3 ">
					<div class="widget-content">						
					    <div class="mobile"><h3>Doctor Manager : New Doctor</h3></div> 
						<div class="span2"><img src="${pageContext.request.contextPath}/download"/></div>
				</div>	
					<ul id="sidebar" class="nav nav-tabs nav-stacked">
						
						<li><a href="#" onclick="createuser()" id="create" >Create User</a></li>
						<li><a href="#" id="commsion" >Commission Rates</a></li>
					</ul>
				</div>
				<!-- /Sidebar -->
				
				<!-- Content -->
				<div class="span9">
					
								
					<div class="widget">
						
						<div class="widget-content">
						
						
								<div class="row">
								<div class="span4"><label>Name<span style="color:red"> *</span></label><form:input path="doctorName" placeholder="Name" id="doctorname"  onKeyPress="return isNumberKey(event)" onblur="doctname()" class="span4"/><span style="color:red" id="names"></span></div>
								<div class="span4"><label>Tie-Up<span style="color:red"> *</span></label>
								      <form:select path="tieUp" class="span4" onchange="tieUps()" onblur="ties()" id="tieup">	
								           <option>-select-</option>	
								           <form:options items="${tieuplistvalue}" />
										  
								       </form:select><span style="color:red" id="tieups"></span>
								</div>
								</div>
								<div class="row">
								<div class="span4"><label>IMC Registration<span style="color:red"> *</span></label><form:input path="doctorImcNumber" placeholder="IMC Registration" onblur="docimcnumber()" id="imcregistration" class="span4"/><span style="color:red" id="imcregistrations"></span></div>
								<div class="span4"><label>Specialization<span style="color:red"> *</span></label><form:select path="specialization" placeholder="Specialization" onchange="Specializations()" id="specialization" class="span4" onblur="Specializa()">
								<option >--Select--</option>
								<form:options items="${specilizationlisttype}" />
								</form:select><span style="color:red" id="specializations"></span></div>                             
								</div>
								<div class="row">
								<div class="span4"><label>E-mail ID<span style="color:red"> *</span></label><form:input path="emailId" placeholder="E-mail ID" onblur="EmailID(this)" onkeyup="email()" id="emailId" class="span4"/><span style="color:red" id="emailid"></span></div>
								<div class="span4"><label>Alternate E-mail ID</label><form:input path="alternateEmailId"  onblur="AlterEmailID(this)" onkeyup="alterEmail()" id="valitemailId" placeholder="Alternate E-mail ID" class="span4"/><span style="color:red" id="valitemailid"></span></div>
								</div>
								<div class="row">
								<div class="span4"><label>Phone Mobile<span style="color:red"> *</span></label><form:input path="phoneMobile" placeholder="Phone Mobile(Please Enter Numeric Value)" maxlength="10" onblur="mobile()" onkeyup="mobiles()" id="phonemobile" onKeyPress="return isNumberKey2(event)" class="span4"/><span style="color:red" id="phonemobiles"></span></div>
								<div class="span4"><label>Preferred Contact<span style="color:red"> *</span></label><form:select path="preferredContactMethod"  id="contact" placeholder="Preferred Contact" class="span4" onblur="Contact()" >
								<option>--Select--</option>
								<form:options items="${prefferedlisttype}" />
								</form:select><span style="color:red" id="contacts"></span></div>
								
								</div>
								<div class="row">
								<div class="span4"><label>Emergency Phone</label><form:input path="emergencyPhoneNumber" placeholder="Emergency Phone(Please Enter Numeric Value)"  maxlength="10" onkeyup="phone()" id="emergencyphone" onKeyPress="return isNumberKey2(event)" class="span4"/><span style="color:red" id="emergencyphones"></span></div>
								<div class="span4"><label>Phone Fax</label><form:input path="phoneFax" placeholder="Phone Fax(Please Enter Numeric Value)" id="phonefax"  maxlength="10" onkeyup="fax()" onKeyPress="return isNumberKey2(event)"  class="span4"/><span style="color:red" id="phonefaxs"></span></div>
								</div>
								<div class="row">
								<div class="span4"><label>Phone LandLine</label><form:input path="phoneLandline" placeholder="Phone LandLine(Please Enter Numeric Value)"  maxlength="12" onkeyup="landline()" id="phonelandline" onKeyPress="return isNumberKey2(event)" class="span4"/><span style="color:red" id="phonelandlines"></span></div>
								<div class="span4"><label>Door/Building</label><form:input path="addressLine1" placeholder="Door/Building" onkeyup="Door()" id="door" class="span4"/><span style="color:red" id="doors"></span></div>
								
								</div>
								<div class="row">
								<div class="span4"><label>StreetName</label><form:input path="addressLine2" placeholder="StreetName" onkeyup="Street()" id="street" class="span4"/><span style="color:red" id="streets"></span></div>
								<div class="span4"><label>Area</label><form:input path="area" placeholder="Area" onkeyup="Area()" id= "area" class="span4"/><span style="color:red" id="areas"></span></div>
								
								</div>
								<div class="row">
								<div class="span4"><label>Post Office Code</label><form:input path="postalcode" placeholder="Post Office Code(Please Enter Numeric Value)" class="span4" id="postcode" maxlength="7" onBlur="postinputValue();" onKeyPress="return isNumberKey2(event)"/><span style="color:red" id="postcodes"></span></div>
								<div class="span4"><label>City</label><form:input path="city" id="City" class="span4" placeholder="City"/>
				                <span style="color:red" id="citys"></span></div>
								</div>
								<div class="row">
								<div class="span4"><label>District</label><form:input path="district" placeholder="District" id="district" class="span4" />	
								<span style="color:red" id="districts"></span></div>
								<div class="span4"><label>State</label><form:input path="state" placeholder="State" id="state" class="span4" />
								<span style="color:red" id="states"></span></div>
								</div>
								<div class="row">
								<div class="span4"><label>Country</label><form:input path="country" placeholder="Country" id="country" class="span4" />
								<span style="color:red" id="countrys"></span></div>
								<div class="span4"><label>Send SMS Alerts?</label> <form:select path="smsAlerts" id="sms" class="span4" >	
								            <option value="0">-select-</option>
								            <form:options items="${smslisttype}" />
										  
								       </form:select><span style="color:red" id="smss"></span></div>
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
                            <a href="#" id="sav" class="sav btn btn-default" onclick="add()" >
						    <img src="${pageContext.request.contextPath}/resources/images/e-save.png"/><br>Save</a>
							<a id="savd" class="savd btn btn-default" />
							<img src="${pageContext.request.contextPath}/resources/images/d-save.png"/><br>Save</a>
						
                            <a href="#" id="savnew" class="savnew btn btn-default" onclick="save()">
						    <img src="${pageContext.request.contextPath}/resources/images/e-save-new.PNG"/><br>Save-New</a>
						    <a id="savnewd" class="savnewd btn btn-default" >
							<img src="${pageContext.request.contextPath}/resources/images/d-save-new.PNG"/><br>Save-New</a>
								  
					   
                            <a href="#"id="savcol" class="savcol btn btn-default" onClick="saveclose()" >
						    <img src="${pageContext.request.contextPath}/resources/images/e-saveclose.PNG"/><br>Save-Close</a>
							<a id="savcold" class="savcold btn btn-default" >
							<img src="${pageContext.request.contextPath}/resources/images/d-saveclose.PNG"/><br>Save-Close</a>
						
                            <a href="${pageContext.request.contextPath}/doctorManager" class="btn btn-default">
                            <img src="${pageContext.request.contextPath}/resources/images/e-close.png"/><br>Close</a></li>
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

<form:hidden path="doctorId"/>
<form:hidden path="dispatch"/>
		</body>
	
		
<script>
var js=jQuery.noConflict();
var form=document.getElementById("next");
js("#sucessdiv").hide();
js("#errordiv").hide(); 
js("#commsion").hide();
js("#create").hide();
js(".sav").show();
js(".savnew").show();
js(".savcol").show();
js(".savd").hide();
js(".savnewd").hide();
js(".savcold").hide();
function sucessclose()
{
	
	js("#sucessdiv").hide();
	
}
function errorclose()
{
	
	js("#errordiv").hide(); 
}
function EmailID(objEmail) 

{
   
var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
if (!reg.test(objEmail.value))

    {

       document.getElementById("emailid").innerHTML="Invalid Email Id";
       document.getElementById("emailId").style.borderColor="#FF0000";
  }
   

}
  function doctname() {
  if (document.getElementById("doctorname").value=="")
{

       document.getElementById("names").innerHTML= "please enter the name";
  document.getElementById("doctorname").style.borderColor="#FF0000";
      
    }
	else
	{
	 document.getElementById("names").innerHTML= "";
  document.getElementById("doctorname").style.borderColor="#64FE2E";
  }
  }
  function docimcnumber() {
  if (document.getElementById("imcregistration").value=="")
{

       document.getElementById("imcregistrations").innerHTML= "please enter the IMC Registration";
  document.getElementById("imcregistration").style.borderColor="#FF0000";
      
    }
	else
	{
	 document.getElementById("imcregistrations").innerHTML= "";
  document.getElementById("imcregistration").style.borderColor="#64FE2E";
  }
  }
  function ties(){
  	if (document.getElementById("tieup").value=="-select-")

{

document.getElementById("tieups").innerHTML="Please select tieup";
document.getElementById("tieup").style.borderColor="#FF0000";
     }
	 }
	
  function Specializa(){
  	if (document.getElementById("specialization").value=="--Select--")

{

document.getElementById("specializations").innerHTML="Please select Specialization";
document.getElementById("specialization").style.borderColor="#FF0000";
    }else{
	 document.getElementById("specializations").innerHTML= "";
  document.getElementById("specialization").style.borderColor="#64FE2E";
  }
	 }
	 function Contact(){
  	if (document.getElementById("contact").value=="--Select--")

{

document.getElementById("contacts").innerHTML="Please select Preferred Contact";
document.getElementById("contact").style.borderColor="#FF0000";
     }
	 else{
	 document.getElementById("contacts").innerHTML= "";
  document.getElementById("contact").style.borderColor="#64FE2E";
  }
	 }

function add()
{
var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
var reg1 = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
if (!document.getElementById("emailId").value.match(reg))
{

       document.getElementById("emailid").innerHTML="Please Enter the e-mail Address";
document.getElementById("emailId").style.borderColor="#FF0000";
       
}
if  (!document.getElementById("phonemobile").value.match(/^[1-9]{1}[0-9]{9}$/))
	{
	document.getElementById("phonemobiles").innerHTML="Please Enter the phone Mobile";  
document.getElementById("phonemobile").style.borderColor="#FF0000";	
	  }
  if (!document.getElementById("doctorname").value.match(/\S/))
{

       document.getElementById("names").innerHTML= "please enter the name";
  document.getElementById("doctorname").style.borderColor="#FF0000";
      
    }
	if (document.getElementById("imcregistration").value=="")
{

       document.getElementById("imcregistrations").innerHTML= "please enter the IMC Registration";
  document.getElementById("imcregistration").style.borderColor="#FF0000";
      
    }
	if (document.getElementById("specialization").value=="--Select--")

{

document.getElementById("specializations").innerHTML="Please select Specialization";
document.getElementById("specialization").style.borderColor="#FF0000";
    }
	if (document.getElementById("tieup").value=="-select-")

{

document.getElementById("tieups").innerHTML="Please select tieup";
document.getElementById("tieup").style.borderColor="#FF0000";
     }
	if (document.getElementById("contact").value=="--Select--")

{

document.getElementById("contacts").innerHTML="Please select Preferred Contact";
document.getElementById("contact").style.borderColor="#FF0000";
     }
	
		

		if ((document.getElementById("emailId").value.match(reg))&& (document.getElementById("phonemobile").value.match(/^[1-9]{1}[0-9]{9}$/)) && (document.getElementById("doctorname").value.match(/\S/)) && (document.getElementById("tieup").value.match(/\S/)) && (document.getElementById("imcregistration").value.match(/\S/)) && (document.getElementById("specialization").value.match(/\S/)) && (document.getElementById("contact").value.match(/\S/)))
		{
	
	form.dispatch.value="save";
		    form.submit();
			}
	}
		
		if(form.dispatch.value=="save"){
	js("#doctorname").attr("readonly", true);
	js("#tieup").attr("readonly", true);
	js("#imcregistration").attr("readonly", true);
	js("#specialization").attr("readonly", true);
	js("#emailId").attr("readonly", true);
	js("#valitemailId").attr("readonly", true);
	js("#phonemobile").attr("readonly", true);
	js("#phonelandline").attr("readonly", true);
	js("#emergencyphone").attr("readonly", true);
	js("#phonefax").attr("readonly", true);
	js("#door").attr("readonly", true);
	js("#street").attr("readonly", true);
	js("#postcode").attr("readonly", true);
	js("#area").attr("readonly", true);
	js("#City").attr("readonly", true);
	js("#district").attr("readonly", true);
	js("#state").attr("readonly", true);
	js("#country").attr("readonly", true);
	js("#contact").attr("readonly", true);
	js("#sms").attr("readonly", true);
	js(".sav").hide();
	js(".savnew").hide();
	js(".savcol").hide();
	js(".savd").show();
    js(".savnewd").show();
    js(".savcold").show();
	js("#errordiv").hide();
	js("#sucessdiv").show();
	
	}
	var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

	 if(document.getElementById("allowThirdPartyAccess").value=="Y")
	 {
	 js("#create").show();
	 }
	 	 if ((document.getElementById("emailId").value.match(reg)) &&(document.getElementById("phonemobile").value.match(/^[1-9]{1}[0-9]{9}$/))){
js("#create").show();
 }
		else{
   js("#create").hide();
   }
function save(){
	var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
var reg1 = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
if (!document.getElementById("emailId").value.match(reg))
{

       document.getElementById("emailid").innerHTML="Please Enter the e-mail Address";
document.getElementById("emailId").style.borderColor="#FF0000";
       
}
if (!document.getElementById("phonemobile").value.match(/^[1-9]{1}[0-9]{9}$/))
	{
	document.getElementById("phonemobiles").innerHTML="Please Enter the phone Mobile  ";  
document.getElementById("phonemobile").style.borderColor="#FF0000";	
	  }
  if (!document.getElementById("doctorname").value.match(/\S/))
{

       document.getElementById("names").innerHTML= "please enter the name";
  document.getElementById("doctorname").style.borderColor="#FF0000";
      
    }
	if (document.getElementById("imcregistration").value=="")
{

       document.getElementById("imcregistrations").innerHTML= "please enter the IMC Registration";
  document.getElementById("imcregistration").style.borderColor="#FF0000";
      
    }
	if (document.getElementById("tieup").value=="-select-")

{

document.getElementById("tieups").innerHTML="Please select tieup";
document.getElementById("tieup").style.borderColor="#FF0000";
     }
	if (document.getElementById("specialization").value=="--Select--")

{

document.getElementById("specializations").innerHTML="Please select Specialization";
document.getElementById("specialization").style.borderColor="#FF0000";
    }
	if (document.getElementById("contact").value=="--Select--")

{

document.getElementById("contacts").innerHTML="Please select Preferred Contact";
document.getElementById("contact").style.borderColor="#FF0000";
     }
		

		if ((document.getElementById("emailId").value.match(reg))&& (document.getElementById("phonemobile").value.match(/^[1-9]{1}[0-9]{9}$/)) && (document.getElementById("doctorname").value.match(/\S/)) && (document.getElementById("tieup").value.match(/\S/)) && (document.getElementById("imcregistration").value.match(/\S/)) && (document.getElementById("specialization").value.match(/\S/)) && (document.getElementById("contact").value.match(/\S/)))
		{
	

	
		//alert("registed successfully");
	form.dispatch.value="save&new";
		    form.submit();
			}
			}
		if(form.dispatch.value=="save&new"){	
	   document.getElementById("doctorname").value="";
	   document.getElementById("tieup").value="";
	   document.getElementById("imcregistration").value="";
	   document.getElementById("specialization").value="";
	    document.getElementById("emailId").value="";
		document.getElementById("valitemailId").value="";
		document.getElementById("phonemobile").value="";
		document.getElementById("phonelandline").value=""; 
		document.getElementById("emergencyphone").value="";
		document.getElementById("phonefax").value="";
		document.getElementById("door").value="";
		document.getElementById("street").value="";
		document.getElementById("postcode").value="";
		document.getElementById("area").value="";
		document.getElementById("City").value="";
		document.getElementById("district").value="";
		document.getElementById("state").value="";
		document.getElementById("country").value="";
		document.getElementById("contact").value="";
		document.getElementById("sms").value="";
	    js(".sav").hide();
	    js(".savnew").hide();
	    js(".savcol").hide();
		js("#errordiv").hide();
        js("#sucessdiv").show();
	}
	
function saveclose(){
	var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
var reg1 = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
if (!document.getElementById("emailId").value.match(reg))
{

       document.getElementById("emailid").innerHTML="Please Enter the e-mail Address";
document.getElementById("emailId").style.borderColor="#FF0000";
       
}
if  (!document.getElementById("phonemobile").value.match(/^[1-9]{1}[0-9]{9}$/))
	{
	document.getElementById("phonemobiles").innerHTML="Please Enter the phone Mobile ";  
document.getElementById("phonemobile").style.borderColor="#FF0000";	
	  }
  if (!document.getElementById("doctorname").value.match(/\S/))
{

       document.getElementById("names").innerHTML= "please enter the name";
  document.getElementById("doctorname").style.borderColor="#FF0000";
      
    }
	if (document.getElementById("imcregistration").value=="")
{

       document.getElementById("imcregistrations").innerHTML= "please enter the IMC Registration";
  document.getElementById("imcregistration").style.borderColor="#FF0000";
      
    }
	if (document.getElementById("specialization").value=="--Select--")

{

document.getElementById("specializations").innerHTML="Please select Specialization";
document.getElementById("specialization").style.borderColor="#FF0000";
    }
	if (document.getElementById("tieup").value=="-select-")

{

document.getElementById("tieups").innerHTML="Please select tieup";
document.getElementById("tieup").style.borderColor="#FF0000";
     }
	if (document.getElementById("contact").value=="--Select--")

{

document.getElementById("contacts").innerHTML="Please select Preferred Contact";
document.getElementById("contact").style.borderColor="#FF0000";
     }
	
		

		if ((document.getElementById("emailId").value.match(reg))&& (document.getElementById("phonemobile").value.match(/^[1-9]{1}[0-9]{9}$/)) && (document.getElementById("doctorname").value.match(/\S/)) && (document.getElementById("tieup").value.match(/\S/)) && (document.getElementById("imcregistration").value.match(/\S/)) && (document.getElementById("specialization").value.match(/\S/)) && (document.getElementById("contact").value.match(/\S/)))
		{

	
	form.dispatch.value="save&close";
		    form.submit();
			js(".savnew").hide();
	        js(".sav").hide();
	        js(".savcol").hide();
			js("#errordiv").show();
            js("#sucessdiv").hide();
		}
}

function tieUps(){
if (document.getElementById("tieup").value!="-select-")

{

document.getElementById("tieups").innerHTML="";
document.getElementById("tieup").style.borderColor="#64FE2E";
     }
if (document.getElementById("tieup").value=="Y"){
	js("#commsion").show();
}
else if (document.getElementById("tieup").value=="N"){
js("#commsion").hide();
}


}
function email(){
var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
if (document.getElementById("emailId").value.match(reg))
	{
	document.getElementById("emailid").innerHTML=" "; 
document.getElementById("emailId").style.borderColor="#64FE2E";	
	  }
}
function alterEmail(){
	var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	if (document.getElementById("valitemailId").value.match(reg))
		{
		document.getElementById("valitemalid").innerHTML=" "; 
	document.getElementById("valitemailId").style.borderColor="#64FE2E";	
		  }
	}
function mobile(){
var reg1 = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
if (!document.getElementById("phonemobile").value.match(/^[1-9]{1}[0-9]{9}$/))
{
document.getElementById("phonemobiles").innerHTML="Please Enter the phone Mobile ";  
document.getElementById("phonemobile").style.borderColor="#FF0000";	
}
else
	{
	document.getElementById("phonemobiles").innerHTML=" ";  
document.getElementById("phonemobile").style.borderColor="#64FE2E";	
	  }
}

function postinputValue()
{
	var post_No=document.getElementById("postcode").value;
	js(function() {
		js.post("${pageContext.request.contextPath}/postofficeDoctor/inputvalue",
					{postno: post_No},
				function(data){
				document.getElementById("City").value=data[0].city;				
				document.getElementById("district").value=data[0].district;				
				document.getElementById("state").value=data[0].state;				
				document.getElementById("country").value=data[0].country;				
				
			});
	});
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
function createuser(){
	form.dispatch.value="createuser";
    form.submit();
}


</script>
</form:form>
</html>