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
<form:form commandName="patientDetailView" id="viewid">
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
						<h4>Success title!</h4>
						<br>Successful message goes here
					</div>
                    <div class="alert alert-error alert-block" id="errordiv">
						<button type="button" class="close" onClick="errorclose()"  data-dismiss="alert">&times;</button>
						<h4>Error title!</h4>
						<br>Error message goes here
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
                                            <h3>Patient Manager : ${patientDetailView.patientName} </h3>	
                                            </div>                       
                                                 <div class="span3 ">                                                                
                                                    <div class="box-holder"><a href="#"  disable="disable">
													<div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save.png"/>Save</div></a></div>  
                                                    <div class="box-holder"><a href="#"  disable="disable">
													<div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save-new.PNG"/>Save-New</div></a></div> 
                                                    <div class="box-holder"><a href="#"  disable="disable">
													<div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-saveclose.PNG"/>Save-Close</div></a></div>
                                                    <div class="box-holder"><a href="${pageContext.request.contextPath}/patientManager"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-close.png"/>close</div></a></div> 
                                                </div>                 
                                        </div>                                    
                                    </div>	              
                                </div>
                            </div>
				<div class="row">
                                <!-- Sidebar -->
				
				<div class="span3">
				<div class="widget-content">	
					<div class="span2"><img src="${pageContext.request.contextPath}/download"/></div>
				</div>
					<ul id="sidebar" class="nav nav-tabs nav-stacked">
						<li><a href="${pageContext.request.contextPath}/testOrderManager">Add Test</a></li>
					</ul>
				</div>
				<!-- /Sidebar -->
				
				<!-- Content -->
				<div class="span9">
					
								
					<div class="widget">
						
						<div class="widget-content">
						<div class="row">
								<div class="span4">
                                	<label>Referring Doctor</label>
									<form:input path="referringDoctor" class="span4" id="drname"/>
									<span style="color:red" id="prefcont"></span>
								</div>
								<div class="span4">
                                	<label>Referring Test Vendor</label>
                                    <form:input path="referringVendor" class="span4" id="vendorname"/>
                                    
								</div>
                            </div>         
							<div class="row">
								<div class="span4">
                                	<label>Name</label>
                               		<form:input path="patientName" placeholder=" Patient Name" id="name" class="span4"/>
                                    <span style="color:red" id="pn"></span>
                                </div>	
                                							
								<div class="span4">
                                	<label>Sex</label>
								     <form:select path="sex" class="span4" id="sex" >	
								          <form:options items="${sexTypeList}"/>
								     </form:select>
								</div>
							</div>
                                
							<div class="row">
								<div class="span4">
                                	<label>Date Of Birth</label>
                                    <form:input path="dateOfBirth" placeholder="Date Of Birth" id="dob" class="span4"/>
                                </div>
                                
								<div class="span4">
                                	<label>Age</label>
                                    <form:input path="age" placeholder="Age" id="age" class="span4"/>
                                </div>                             
							</div>
                                
							<div class="row">
								<div class="span4">
                                	<label>E-mail ID</label>
                               		<form:input path="emailId" placeholder="E-mail ID" id="mailid" class="span4"/>
                                </div>
								<div class="span4">
                                	<label>Alternate E-mail ID</label>
                                	<form:input path="alternateEmailId" placeholder="Alternate E-mail ID"  id="aemailid" class="span4"/>
                                </div>
							</div>
							<div class="row">
								<div class="span4">
                                <label>Phone Mobile</label>
                                <form:input path="phoneMobile" placeholder="Phone Mobile" id="mobile" class="span4"/>
                                </div>
								<div class="span4">
                                <label>Phone LandLine</label>
                                <form:input path="phoneLandline" placeholder="Phone LandLine" id="landline" class="span4"/>
                                </div>
							</div>
							<div class="row">
								<div class="span4">
                                <label>Emergency Phone</label>
                                <form:input path="emergencyPhoneNumber" placeholder="Emergency Phone" id="emerphone" class="span4"/>
                                </div>
								<div class="span4">
                                <label>Phone Fax</label>
                                <form:input path="phoneFax" placeholder="Phone Fax" id="fax" class="span4"/>
                                </div>
							</div>
							<div class="row">
								<div class="span4">
                                	<label>Preferred Contact</label>
									<form:input path="preferredContactMethod" class="span4" id="paprefcontact"/>
									
								</div>
								<div class="span4">
                                	<label>Send SMS Alerts?</label>
                                    <form:input path="smsAlerts" class="span4" id="smsalert"/>
                                    
								</div>
                            </div> 
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
                                <form:input path="postofficecode" placeholder="Post Office Code" id="postcode" class="span4" onBlur="postinputValue();"/>
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
							 <a href="#" class="btn btn-default">
							 <img src="${pageContext.request.contextPath}/resources/images/d-save.png"/><br>Save</a>
						 
						      <a href="#" class="btn btn-default" >
							 <img src="${pageContext.request.contextPath}/resources/images/d-save-new.PNG"/><br>Save-New</a>
								  
					  
							<a href="#" class="btn btn-default" >
							<img src="${pageContext.request.contextPath}/resources/images/d-saveclose.PNG"/><br>Save-Close</a>
						
						<a href="${pageContext.request.contextPath}/patientManager" class="btn btn-default">
							<img src="${pageContext.request.contextPath}/resources/images/e-close.png"/><br>Close</a>
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

var form = document.getElementById("viewid");
var js=jQuery.noConflict();
js("#sucessdiv").hide();
js("#errordiv").hide(); 
function sucessclose()
{
	
	js("#sucessdiv").hide();
	
}
function errorclose()
{
	
	js("#errordiv").hide(); 
}

js("#drname").attr("disabled", true);
js("#vendorname").attr("disabled", true);
js("#name").attr("disabled", true);
js("#sex").attr("disabled", true);
js("#dob").attr("disabled", true);
js("#age").attr("disabled", true);
js("#mailid").attr("disabled", true);
js("#aemailid").attr("disabled", true);
js("#mobile").attr("disabled", true);
js("#landline").attr("disabled", true);
js("#emerphone").attr("disabled", true);
js("#fax").attr("disabled", true);
js("#paprefcontact").attr("disabled", true);
js("#smsalert").attr("disabled", true);
js("#addressline1").attr("disabled", true);
js("#addressline2").attr("disabled", true);
js("#area").attr("disabled", true);
js("#postcode").attr("disabled", true);
js("#city").attr("disabled", true);
js("#district").attr("disabled", true);
js("#state").attr("disabled", true);
js("#country").attr("disabled", true);
	

</script>
</form:form>
</html>