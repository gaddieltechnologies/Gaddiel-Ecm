<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaImpl" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaResponse" %>


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
<form:form commandName="signup" id="signupid"  enctype="multipart/form-data" method="POST">
<body >
<!-- Navbar -->
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#"><img src="${pageContext.request.contextPath}/resources/images/logo90.png" Style=" width:300px; height:40px;" align="left"/></a>			</div>
	  </div>
	</div>
	<!-- /Navbar -->
	
	<!-- Main content -->
	<div id="main-content">
		<!-- Container -->
		<div class="container">
			<div class="box-container">
			</div>
			
                            <div class="row">
				<!-- Sidebar -->				
				<!-- /Sidebar -->				
				<!-- Content -->
				<div class="span12" >					
				    <div class="widget">                    					
					<div class="widget-content"> 
                                            <div class="span7">
                                            <h3>Sign Up </h3>	
                                            </div>                       
                                                <div class="span1 pull-right">                                                                
                                                    <div class="box-holder">
	                                  <a href="${pageContext.request.contextPath}/index">
	                                  <div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-close.png"/>Close</div></a>
	                               </div>   
                                                    
                                                </div>                 
                                        </div>                                    
                                    </div>	              
                                </div>
                            </div>
				<div class="row">
                              
				
				<!-- Content -->
				<div class="span12" >
					
								
					<div class="widget">
						
						<div class="widget-content">
						<div class="row">
								<div class="span4">
								<label>Lab Name<font color="#FF0000"> *</font></label>
                                	<form:input path="labName" class="span4" id="labnameid" placeholder="Lab's Name" onkeyup="nameval()" onblur="valname()" style="height:30px;"/>
                                	<br/><font color="#FF0000"><span id="ename"></span></font>
                                  
								</div>
								<div class="span4">
                                	<label>Web-site Address</label>
                                	<form:input path="websiteAddress" class="span4" id="labwebsiteid" placeholder="www.mylab.org" style="height:30px;"/>
                                   
								</div>
								<div class="span3">
                                	<label>Email<font color="#FF0000"> *</font></label>
                                	<form:input path="emailId" class="span3" id="labmailid" placeholder="Example:admin@gmail.com" onblur="unamevalidate()" style="height:30px;"/>
                                	<br/><font color="#FF0000"><span id="eemail"></span></font>
                                </div>
								
								
                            </div>  
							<div class="row">
									
                                <div class="span4">
                                	<label>Alternate Email</label>
                                	<form:input path="alternateEmailId" class="span4" id="labalternatemailid" placeholder="Example:alternateadmin@gmail.com" onblur="vnamevalidate()" style="height:30px;"/>
                                	<br/><font color="#FF0000"><span id="ealtemail"></span></font>
								</div>							
								
								
								<div class="span4">
                                	<label>Door No.<font color="#FF0000"> *</font></label>
                                	<form:input path="addressLine1" class="span4" id="labdoorid" placeholder="Door No." onkeyup="doorval()" onblur="valdoor()" style="height:30px;"/>
                                	<br/><font color="#FF0000"><span id="edoor"></span></font>
                                </div>
								<div class="span3">
                                	<label>Street<font color="#FF0000"> *</font></label>
                                	<form:input path="addressLine2" class="span3" id="labstreetid" placeholder="Street" onkeyup="streetval()" onblur="valstreet()" style="height:30px;"/>
                                	<br/><font color="#FF0000"><span id="estreet"></span></font>
                                </div>
							</div>
                                
							
                              <div class="row">
								<div class="span4">
                                	<label>Area<font color="#FF0000"> *</font></label>
                                	<form:input path="area" class="span4" id="labareaid" placeholder="Area" onkeyup="areaval()" onblur="valarea()" style="height:30px;"/>
                                	<br/><font color="#FF0000"><span id="earea"></span></font>
								</div>
								<div class="span4">
                                	<label>Post Office Code<font color="#FF0000"> *</font></label>
                                	<form:input path="postalcode" class="span4" id="labpostalid" placeholder="Postal Code" maxlength="6" onkeyup="postval()" onblur="valpost();postoffice()" onKeyPress="return isNumberKey2(event)" style="height:30px;"/>
                                	<br/><font color="#FF0000"><span id="epost"></span></font>
								</div>
								<div class="span3">
                                	<label>City<font color="#FF0000"> *</font></label>
                                	<form:input path="city" class="span3" id="labcityid" placeholder="City" onkeyup="cityval()" onblur="valcity()" style="height:30px;"/>
                                	<br/><font color="#FF0000"><span id="ecity"></span></font>
                                </div>
                            </div>   
							<div class="row">
								
								<div class="span4">
                                	<label>District<font color="#FF0000"> *</font></label>
                                	<form:input path="district" class="span4" id="labdistrictid" placeholder="District" onkeyup="distval()" onblur="valdist()" style="height:30px;"/>
                                	<br/><font color="#FF0000"><span id="edist"></span></font>
                                </div>
								<div class="span4">
                                	<label>State<font color="#FF0000"> *</font></label>
                                	<form:input path="state" class="span4" id="labstateid" placeholder="State" onkeyup="stateval()" onblur="valstate()" style="height:30px;"/>
                                	<br/><font color="#FF0000"><span id="estate"></span></font>
                                </div>
								<div class="span3">
									<label>Country<font color="#FF0000"> *</font></label>
                                	<form:input path="country" class="span3" id="labcountryid" placeholder="Country" onkeyup="countryval()" onblur="valcountry()" style="height:30px;"/>
                                	<br/><font color="#FF0000"><span id="ecountry"></span></font>
                                </div>
							</div>
							
							<div class="row">
								<div class="span4">
									<label>Landline No.</label>
                                	<form:input path="phoneLandLine" class="span4" id="lablandlineid" placeholder="Phone Landline (Please enter numeric value)" maxlength="10" onKeyPress="return isNumberKey2(event)" style="height:30px;"/>
                                	<br/><font color="#FF0000"><span id="eland"></span></font>
                               </div>
								<div class="span4">
									<label>Mobile No.<font color="#FF0000"> *</font></label>
                                	<form:input path="phoneMobile" class="span4" id="labmobileid" placeholder="Phone Mobile (Please enter numeric value)" onkeyup="mobval()" onblur="valmob()" maxlength="12" onKeyPress="return isNumberKey2(event)" style="height:30px;"/>
                                	<br/><font color="#FF0000"><span id="emob"></span></font>
                                </div>
								<div class="span3">
									<label>Emergency Phone No.</label>
                                	<form:input path="emergencyPhoneNumber" class="span3" id="labemergencyid" maxlength="12" placeholder="Emergency Phone (Please enter numeric value)" onKeyPress="return isNumberKey2(event)" style="height:30px;"/>
                                	<br/><font color="#FF0000"><span id="eem"></span></font>
                                </div>
							</div>
                            
                          
							<div class="row">
								
								<div class="span4">
									<label>Fax</label>
                                	<form:input path="phoneFax" class="span4" id="labfaxid" placeholder="Phone Fax (Please enter numeric value)" maxlength="7" onKeyPress="return isNumberKey2(event)" style="height:30px;"/>
                                	<br/><font color="#FF0000"><span id="efax"></span></font>
                                </div>
								<div class="span4">
									<label>Remarks</label>
                                	<form:input path="remarks" class="span4" id="labremarksid" placeholder="Example:Registration No. or other useful information" style="height:30px;"/>
                                </div>
								<div class="span3">
									<label>Allow Third Party Access?</label>
                                	<form:select path="allowThirdpartyAccess" class="span3" id="labaccessid">
                                	<option>N</option>
                                	<form:options items="${actflaglistvalue}" />
                                	</form:select>
                                </div>
								
							</div>
							
							

								<div class="row">
									<div class="span4">
											<label>Upload Lab Logo </label>
											<form:input path="fileupload" type="file" size="40" class="span4" id="lablogoid"  />
									</div>
								
									<div class="span4">
											
											<% ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LfYJO0SAAAAAItI0yIL7j-URcvKldMoynK83ag8", "6LfYJO0SAAAAAG9TU8j3RWzpYbYv9807sJyt8ZC0", false);
										   out.print(c.createRecaptchaHtml(null, null));%>
										   
									</div>
								
									<div class="span3">
									<label class="checkbox inline">
										<form:input path="privypol" type="checkbox" name="checktwo" value="twocheck" class="span1" id="privacyid"/>
											I read and agree to 
											<a href="${pageContext.request.contextPath}/underConstruction">Data Security & Privacy Policy</a>
											&nbsp;/&nbsp;<a href="${pageContext.request.contextPath}/underConstruction">Terms & Conditions</a> 
											<br/><font color="#FF0000"><span id="eterms"></span></font>
									</label>	
									
									 
										<a class="btn btn-success span2 " onClick="newSave()" id="saveenable">Submit</a>
											
										
									</div>
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
</body>
<script>

var jq = jQuery.noConflict();
/*
if((document.getElementById("privacyid").checked==1)
{
	jq("#saveenable").attr("disabled", false);
}

if((document.getElementById("privacyid").checked==0))
{
	jq("#saveenable").attr("disabled", true);
}
*/
function valname()
{
	var name=document.getElementById("labnameid").value;
	if(!name.match(/\S/)){
		document.getElementById("ename").innerHTML="Enter Lab Name";
		document.getElementById("labnameid").style.borderColor="#FF0000";
	}
}

function nameval()
{
	var name=document.getElementById("labnameid").value;
	if(name.match(/\S/)){
		document.getElementById("ename").innerHTML="";
	}
}




function valdoor()
{
	var name=document.getElementById("labdoorid").value;
	if(!name.match(/\S/)){
		document.getElementById("edoor").innerHTML="Enter Door No.";
		document.getElementById("labdoorid").style.borderColor="#FF0000";
	}
}

function doorval()
{
	var name=document.getElementById("labdoorid").value;
	if(name.match(/\S/)){
		document.getElementById("edoor").innerHTML="";
	}
}





function valarea()
{
	var name=document.getElementById("labareaid").value;
	if(!name.match(/\S/)){
		document.getElementById("earea").innerHTML="Enter Area";
		document.getElementById("labareaid").style.borderColor="#FF0000";
	}
}

function areaval()
{
	var name=document.getElementById("labareaid").value;
	if(name.match(/\S/)){
		document.getElementById("earea").innerHTML="";
	}
}






function valstreet()
{
	var name=document.getElementById("labstreetid").value;
	if(!name.match(/\S/)){
		document.getElementById("estreet").innerHTML="Enter Street";
		document.getElementById("labstreetid").style.borderColor="#FF0000";
	}
}

function streetval()
{
	var name=document.getElementById("labstreetid").value;
	if(name.match(/\S/)){
		document.getElementById("estreet").innerHTML="";
	}
}







function valpost()
{
	var name=document.getElementById("labpostalid").value;
	if(!name.match(/\S/)){
		document.getElementById("epost").innerHTML="Enter PIN Code";
		document.getElementById("labpostalid").style.borderColor="#FF0000";
	}
}

function postval()
{
	var name=document.getElementById("labpostalid").value;
	if(name.match(/\S/)){
		document.getElementById("epost").innerHTML="";
	}
}







function valdist()
{
	var name=document.getElementById("labdistrictid").value;
	if(!name.match(/\S/)){
		document.getElementById("edist").innerHTML="Enter District";
		document.getElementById("labdistrictid").style.borderColor="#FF0000";
	}
}

function distval()
{
	var name=document.getElementById("labdistrictid").value;
	if(name.match(/\S/)){
		document.getElementById("edist").innerHTML="";
	}
}






function valcity()
{
	var name=document.getElementById("labcityid").value;
	if(!name.match(/\S/)){
		document.getElementById("ecity").innerHTML="Enter City";
		document.getElementById("labcityid").style.borderColor="#FF0000";
	}
}

function cityval()
{
	var name=document.getElementById("labcityid").value;
	if(name.match(/\S/)){
		document.getElementById("ecity").innerHTML="";
	}
}







function valstate()
{
	var name=document.getElementById("labstateid").value;
	if(!name.match(/\S/)){
		document.getElementById("estate").innerHTML="Enter State";
		document.getElementById("labstateid").style.borderColor="#FF0000";
	}
}

function stateval()
{
	var name=document.getElementById("labstateid").value;
	if(name.match(/\S/)){
		document.getElementById("estate").innerHTML="";
	}
}






function valcountry()
{
	var name=document.getElementById("labcountryid").value;
	if(!name.match(/\S/)){
		document.getElementById("ecountry").innerHTML="Enter Country";
		document.getElementById("labcountryid").style.borderColor="#FF0000";
	}
}

function countryval()
{
	var name=document.getElementById("labcountryid").value;
	if(name.match(/\S/)){
		document.getElementById("ecountry").innerHTML="";
	}
}






function valmob()
{
	var name=document.getElementById("labmobileid").value;
	if(!name.match(/\S/)){
		document.getElementById("emob").innerHTML="Enter Mobile No.";
		document.getElementById("labmobileid").style.borderColor="#FF0000";
	}
}

function mobval()
{
	var name=document.getElementById("labmobileid").value;
	if(name.match(/\S/)){
		document.getElementById("emob").innerHTML="";
	}
}





function isNumberKey2(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode != 46 && charCode > 31 
     && (charCode < 48 || charCode > 57))
      return false;  
   return true;
}








function unamevalidate()
{
var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
var mail=document.getElementById("labmailid");
             if (!mail.value.match(reg) && mail.value !="")
             {
            	 document.getElementById("eemail").innerHTML="Enter Valid Email Id";
            		document.getElementById("labmailid").style.borderColor="#FF0000";    

                 return false;
             }
             if (mail.value.match(reg) && mail.value !="")
             {
            	 document.getElementById("eemail").innerHTML="";
            	    

                 return false;
             }
}

function vnamevalidate()
{
var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
var mail=document.getElementById("labalternatemailid");
             if (!mail.value.match(reg) && mail.value !="")
             {
            	 document.getElementById("ealtemail").innerHTML="Enter Valid Email Id";
            		document.getElementById("labalternatemailid").style.borderColor="#FF0000";    

                 return false;
             }
             if (mail.value.match(reg) && mail.value !="")
             {
            	 document.getElementById("ealtemail").innerHTML="";
            	    

                 return false;
             }
}

function newSave()
{
	
	var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	
	var name=document.getElementById("labnameid").value;
	var gmailid=document.getElementById("labmailid").value;
	var door=document.getElementById("labdoorid").value;
	var area=document.getElementById("labareaid").value;
	var postal=document.getElementById("labpostalid").value;
	var street=document.getElementById("labstreetid").value;
	var state=document.getElementById("labstateid").value;
	var district=document.getElementById("labdistrictid").value;
	var city=document.getElementById("labcityid").value;
	var country=document.getElementById("labcountryid").value;
	
	var mobile=document.getElementById("labmobileid").value;
	
	var checkprivacy=document.getElementById("privacyid");
	
	var namee=document.getElementById("ename");
	var emaile=document.getElementById("eemail");
	var doore=document.getElementById("edoor");
	var streete=document.getElementById("estreet");
	var areae=document.getElementById("earea");
	var poste=document.getElementById("epost");
	var citye=document.getElementById("ecity");
	var diste=document.getElementById("edist");
	var statee=document.getElementById("estate");
	var countrye=document.getElementById("ecountry");
	
	var mobe=document.getElementById("emob");
	

	
	if (!name.match(/\S/)){
		document.getElementById("ename").innerHTML="Enter Lab Name";
		document.getElementById("labnameid").style.borderColor="#FF0000";
	}
	if (!gmailid.match(/\S/)){
		emaile.innerHTML="Enter Email Id";
		document.getElementById("labmailid").style.borderColor="#FF0000";
	}
	if (!door.match(/\S/)){
		doore.innerHTML="Enter Door No.";
		document.getElementById("labdoorid").style.borderColor="#FF0000";
	}
	if (!area.match(/\S/)){
		areae.innerHTML="Enter Area";
		document.getElementById("labareaid").style.borderColor="#FF0000";
	}
	if (!postal.match(/\S/)){
		poste.innerHTML="Enter PIN Code";
		document.getElementById("labpostalid").style.borderColor="#FF0000";
	}
	if (!street.match(/\S/)){
		streete.innerHTML="Enter Street";
		document.getElementById("labstreetid").style.borderColor="#FF0000";
	}
	if (!state.match(/\S/)){
		statee.innerHTML="Enter State";
		document.getElementById("labstateid").style.borderColor="#FF0000";
	}
	if (!district.match(/\S/)){
		diste.innerHTML="Enter District";
		document.getElementById("labdistrictid").style.borderColor="#FF0000";
	}
	if (!city.match(/\S/)){
		citye.innerHTML="Enter City";
		document.getElementById("labcityid").style.borderColor="#FF0000";
	}
	if (!country.match(/\S/)){
		countrye.innerHTML="Enter Country";
		document.getElementById("labcountryid").style.borderColor="#FF0000";
	}
	
	if (!mobile.match(/\S/)){
		mobe.innerHTML="Enter Mobile No.";
		document.getElementById("labmobileid").style.borderColor="#FF0000";
	}
	
	
	if (checkprivacy.checked==0){
		document.getElementById("eterms").innerHTML="You cannot Sign Up until you agree to our privacy policy and terms & conditions";
		
	}
	
	
	if((name.match(/\S/))&&(gmailid.match(reg))&&(door.match(/\S/))&&(area.match(/\S/))&&(postal.match(/\S/))&&(street.match(/\S/))&&(state.match(/\S/))&&(district.match(/\S/))&&(city.match(/\S/))&&(country.match(/\S/))&&(mobile.match(/\S/))&&(checkprivacy.checked==1))
	{
	
	var form=document.getElementById("signupid");
	var val=document.getElementById("labmailid").value;
	form.dispatch.value="signupsubmit";
	form.submit();
	

	
	}
}

function postoffice()
	{
	
	var post_No=document.getElementById("labpostalid").value;
	
	jq(function() {
		jq.post("${pageContext.request.contextPath}/inputvalue",
					{postno: post_No},
				function(data){
				document.getElementById("labcityid").value=data[0].city;				
				document.getElementById("labdistrictid").value=data[0].district;				
				document.getElementById("labstateid").value=data[0].state;				
				document.getElementById("labcountryid").value=data[0].country;				
				
			});
	});
	}



</script>


</form:form>
</html>