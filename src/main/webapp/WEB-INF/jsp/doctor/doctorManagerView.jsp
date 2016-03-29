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
<form:form commandName="doctorManagerView" id="next">
<body>
<!-- Navbar -->

	<!-- /Navbar -->
	
	<!-- Main content -->
	<div id="main-content">
		<!-- Container -->
		<div class="container">
			<!-- Header boxes -->
			<div class="box-container">
			
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
                                            <h3>Doctor Manager : ${doctorManagerView.doctorName} </h3>	
                                            </div>                       
                                                <div class="span3">                                                                                                           
                                                    <div class="box-holder"><a href="#" id="savd" class="savd" disable="disable"/><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save.png"/>Save</div></a></div> 													                                              
													<div class="box-holder"><a href="#" id="savnewd" class="savnewd" disable="disable"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save-new.PNG"/>Save-New</div></a></div>
													<div class="box-holder"><a href="#"id="savcold" class="savcold" disable="disable"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-saveclose.PNG"/>Save-Close</div></a></div>
                                                    <div class="box-holder"><a href="${pageContext.request.contextPath}/doctorManager"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-close.png"/>Close</div></a></div>
                                                </div>                 
                                        </div>   
									
                                    </div>	              
                                </div>
                            </div>
				<div class="row">
                                <!-- Sidebar -->
				<div class="span3">
					<div class="widget-content">					
                        <div class="mobile"> <h3>Doctor Manager : ${doctorManagerView.doctorName} </h3></div> 					
						<div class="span2"><img src="${pageContext.request.contextPath}/download"/></div>
					</div>				
					<ul id="sidebar" class="nav nav-tabs nav-stacked">
						<li><a style="cursor:pointer;">Commsion Rates</a></li>
					</ul>
				</div>
				
				<!-- /Sidebar -->
				
				<!-- Content -->
				<div class="span9">
					
								
					<div class="widget">
						
						<div class="widget-content">
						
						
								<div class="row">
								<div class="span4"><label>Name</label><input type="text" value="${doctorManagerView.doctorName}" disabled="disable" id="doctorname" onkeyup="docname()" onchange="doctname()" class="span4"/><span style="color:red" id="names"></span></div>
								<div class="span4"><label>Tie-Up</label>
								<input type="text" value="${doctorManagerView.tieUp}" class="span4" disabled="disable" onchange="tieUps()" id="tieup"/>	
								           
								<span style="color:red" id="tieups"></span>
								</div>
								</div>
								<div class="row">
								<div class="span4"><label>IMC Registration</label><input type="text" value="${doctorManagerView.doctorImcNumber}" disabled="disable" placeholder="IMC Registration" onkeyup="docimcnumber()" id="imcregistration" class="span4"/><span style="color:red" id="imcregistrations"></span></div>
								<div class="span4"><label>Specialization</label><input type="text" value="${doctorManagerView.specialization}" placeholder="Specialization" disabled="disable" onkeyup="Specializations()" id="specialization" class="span4"/><span style="color:red" id="specializations"></span></div>                             
								</div>
								<div class="row">
								<div class="span4"><label>E-mail ID</label><input type="text" value="${doctorManagerView.emailId}" placeholder="E-mail ID" disabled="disable" onblur="EmailID(this)" onkeyup="email()" id="emailId" class="span4"/><span style="color:red" id="emailid"></span></div>
								<div class="span4"><label>Alternate E-mail ID</label><input type="text" value="${doctorManagerView.alternateEmailId}"  disabled="disable" onblur="AlterEmailID(this)" onkeyup="alterEmail()" id="valitemailId" placeholder="Alternate E-mail ID" class="span4"/><span style="color:red" id="valitemailid"></span></div>
								</div>
								<div class="row">
								<div class="span4"><label>Phone Mobile</label><input type="text" value="${doctorManagerView.phoneMobile}" disabled="disable"  placeholder="Phone Mobile" onkeyup="mobile()" id="phonemobile" class="span4"/><span style="color:red" id="phonemobiles"></span></div>
								<div class="span4"><label>Phone LandLine</label><input type="text" value="${doctorManagerView.phoneLandline}" disabled="disable" placeholder="Phone LandLine" onkeyup="landline()" id="phonelandline" class="span4"/><span style="color:red" id="phonelandlines"></span></div>
								</div>
								<div class="row">
								<div class="span4"><label>Emergency Phone</label><input type="text" value="${doctorManagerView.emergencyPhoneNumber}" disabled="disable" placeholder="Emergency Phone" onkeyup="phone()" id="emergencyphone" class="span4"/><span style="color:red" id="emergencyphones"></span></div>
								<div class="span4"><label>Phone Fax</label><input type="text" value="${doctorManagerView.phoneMobile}" placeholder="Phone Fax" disabled="disable" id="phonefax" onkeyup="fax()" class="span4"/><span style="color:red" id="phonefaxs"></span></div>
								</div>
								<div class="row">
								<div class="span4"><label>Door/Building</label><input type="text" value="${doctorManagerView.addressLine1}" placeholder="Door/Building" disabled="disable" onkeyup="Door()" id="door" class="span4"/><span style="color:red" id="doors"></span></div>
								<div class="span4"><label>StreetName</label><input type="text" value="${doctorManagerView.addressLine2}" placeholder="StreetName" disabled="disable" onkeyup="Street()" id="street" class="span4"/><span style="color:red" id="streets"></span></div>
								</div>
								<div class="row">
								<div class="span4"><label>Area</label><input type="text" value="${doctorManagerView.area}" placeholder="Area" onkeyup="Area()" disabled="disable"  id= "area" class="span4"/><span style="color:red" id="areas"></span></div>
								<div class="span4"><label>Post Office Code</label><input type="text" value="${doctorManagerView.postalcode}" id="postcode" disabled="disable" onkeyup="postCode()" placeholder="Post Office Code" class="span4"/><span style="color:red" id="postcodes"></span></div>
								</div>
								<div class="row">
								<div class="span4"><label>City</label><input type="text" value="${doctorManagerView.city}" id="City" onchange="zity()" disabled="disable" class="span4" placeholder="City"/>
				                <span style="color:red" id="citys"></span>
								</div>
								<div class="span4"><label>District</label><input type="text" value="${doctorManagerView.district}" onchange="dist()" disabled="disable" class="span4" />	
								<span style="color:red" id="districts"></span></div>
								</div>
								<div class="row">
								<div class="span4"><label>State</label><input type="text" value="${doctorManagerView.state}" onchange="stat()" disabled="disable" class="span4" />
								<span style="color:red" id="states"></span></div>
								<div class="span4"><label>Country</label><input type="text" value="${doctorManagerView.country}" onchange="coun()" disabled="disable" class="span4" />
							    <span style="color:red" id="countrys"></span></div>
								
								</div>
								<div class="row">
								<div class="span4"><label>Preferred Contact</label><input type="text" value="${doctorManagerView.preferredContactMethod}" disabled="disable" onkeyup="contacted()" id="contact" placeholder="Preferred Contact" class="span4"/><span style="color:red" id="contacts"></span></div>
								<div class="span4"><label>Send SMS Alerts?</label> <input type="text" value="${doctorManagerView.smsAlerts}" id="sms" disabled="disable" onchange="sendSms()" class="span4" />	
								<span style="color:red" id="smss"></span></div>
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
                                          
                      
						    <a id="savd" class="savd sav btn btn-default" />
							<img src="${pageContext.request.contextPath}/resources/images/d-save.png"/><br>Save</a>

						    <a href="#" id="savnewd" class="savnewd sav btn btn-default" >
							<img src="${pageContext.request.contextPath}/resources/images/d-save-new.PNG"/><br>SaveNew</a>

							<a href="#"id="savcold" class="savcold sav btn btn-default" >
							<img src="${pageContext.request.contextPath}/resources/images/d-saveclose.PNG"/><br>SaveClose</a>
					
                            <a href="${pageContext.request.contextPath}/doctorManager" class="sav btn btn-default">
                            <img src="${pageContext.request.contextPath}/resources/images/e-close.png"/><br>Close</a></li>
                        </div>
				    </center>                      			
				</div>
           	</div>
		</div>
    </div>
        </div>
<form:hidden path="dispatch"/>
		</body>
	
		
<script>
var form=document.getElementById("next");




</script>
</form:form>
</html>