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
<form:form commandName="vendorDetailView" id="viewid">
<body>
<!-- Navbar -->

	<!-- /Navbar -->
	
	<!-- Main content -->
	<div id="main-content">
		<!-- Container -->
		<div class="container">
			<!-- Header boxes -->
			<div class="box-container">
			<!-- 	<div class="alert alert-success alert-block" id="sucessdiv">
						<button type="button" class="close" onClick="sucessclose()" data-dismiss="alert">&times;</button>
						<h4>Success title!</h4>
						<br>Successful message goes here
					</div>
                    <div class="alert alert-error alert-block" id="errordiv">
						<button type="button" class="close" onClick="errorclose()"  data-dismiss="alert">&times;</button>
						<h4>Error title!</h4>
						<br>Error message goes here
					</div> -->
			</div>
			<!-- /Header boxes -->
			
                            <div class="row">
				<!-- Sidebar -->				
				<!-- /Sidebar -->				
				<!-- Content -->
				<div class="span12 desktop" >					
				    <div class="widget">                    					
					<div class="widget-content"> 
                                            <div class="span7">
                                            <h3>Vendor Manager :  ${vendorDetailView.testVendorName} </h3>	
                                            </div>                       
                                                <div class="span3 ">                                                                
                                                    <div class="box-holder"><a href="#"  disable="disable">
													<div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save.png"/>Save</div></a></div>  
                                                    <div class="box-holder"><a href="#"  disable="disable">
													<div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save-new.PNG"/>Save-New</div></a></div> 
                                                    <div class="box-holder"><a href="#"  disable="disable">
													<div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-saveclose.PNG"/>Save-Close</div></a></div>
                                                    <div class="box-holder"><a href="${pageContext.request.contextPath}/refferdLabIfo"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-close.png"/>close</div></a></div> 
                                                </div>             
                                        </div>                                    
                                    </div>	              
                                </div>
                            </div>
				<div class="row">
                  <!-- Sidebar -->
					<div class="span3">
					<div class="widget-content">					
                        <div class="mobile"> <h3>Vendor Manager :  ${vendorDetailView.testVendorName}  </h3></div> 					
						<div class="span2"><img src="${pageContext.request.contextPath}/download"/></div>
					</div>	
					  <ul id="sidebar" class="nav nav-tabs nav-stacked">
						<li><a style="cursor:pointer;">Test Categories</a></li>
					  </ul>	
				</div>	
			
				<!-- /Sidebar -->
				
				<!-- Content -->
				<div class="span9">
					
								
					<div class="widget">
						
						<div class="widget-content">
							
						
								<div class="row">
								<div class="span4">
								<label>Vendor Name</label>
								<form:input path="testVendorName" placeholder="Vendor Name" class="span4" id="vendorname" onKeyPress="return isNumberKey(event)" onBlur="vendname()"/>
								<span style="color:red" id="names"></span>
								</div>								
								<div class="span4">
								<label>Lab Regn#</label>
								<form:input path="testVendorRegnNumber" placeholder="Vendor Reg No(Please Enter Numeric Value)" class="span4" id="labregno" onKeyPress="return isNumberKey2(event)" onBlur="labreg()" />
								<span style="color:red" id="regno"></span>
								</div>		     							      
								</div>
								<div class="row">
								<div class="span4">
								<label>Contact Name</label><form:input path="vendorContactName" placeholder="Vendor Contact Name" id="picker1" class="span4" onKeyPress="return isNumberKey(event)" onBlur="contacname()" />
								<span style="color:red" id="contname"></span>
								</div>
								<div class="span4"><label>Tie-Up</label>								
								           <form:select path="tieUp" class="span4" id="tiiup"  onBlur="tiup()">
										   <form:options items="${tieuplistvalue}"/>
								           </form:select><span style="color:red" id="tup"></span>								
								</div>                             
								</div>
								<div class="row">
								<div class="span4">
								<label>E-mail ID</label>
								<form:input path="emailId" placeholder="E-mail ID" class="span4" id="emailid" onBlur="email()" />
								<span style="color:red" id="mailid"></span>
								</div>
								<div class="span4">
								<label>Alternate E-mail ID</label>
								<form:input path="alternateEmailId" placeholder="Alternate E-mail ID" class="span4" id="alternateemail" onBlur="alteremail()" />
								<span style="color:red" id="emailalter"></span>
								</div>
								</div>
								<div class="row">
								<div class="span4">
								<label>Phone Mobile</label>
								<form:input path="phoneMobile" placeholder="Phone Mobile(Please Enter Numeric Value)" class="span4" id="mobile"  maxlength="12" onKeyPress="return isNumberKey2(event)" onBlur="mobil()" />
								<span style="color:red" id="mobileid"></span>
								</div>
								<div class="span4">
								<label>Phone LandLine</label>
								<form:input path="phoneLandline" placeholder="Phone LandLine(Please Enter Numeric Value)" class="span4" id="landline" maxlength="10" onKeyPress="return isNumberKey2(event)"/>
								</div>
								</div>
								<div class="row">
								<div class="span4">
								<label>Emergency Phone</label>
								<form:input path="emergencyPhoneNumber" placeholder="Emergency Phone(Please Enter Numeric Value)" class="span4" id="emergencyphone" maxlength="12" onKeyPress="return isNumberKey2(event)"/>
								</div>
								<div class="span4">
								<label>Phone Fax</label>
								<form:input path="phoneFax" placeholder="Phone Fax(Please Enter Numeric Value)" class="span4" id="fax" maxlength="10" onKeyPress="return isNumberKey2(event)"/>
								</div>
								</div>
								<div class="row">
								<div class="span4">
								<label>Door/Building</label>
								<form:input path="addressLine1" placeholder="Door/Building" class="span4" id="addline1"/>
								</div>
								<div class="span4">
								<label>StreetName</label>
								<form:input path="addressLine2" placeholder="StreetName" class="span4" id="addline2"/>
								</div>
								</div>
								<div class="row">
								<div class="span4">
								<label>Area</label>
								<form:input path="area" placeholder="Area" class="span4" id="area" onKeyPress="return isNumberKey(event)"/>
								</div>
								<div class="span4">
								<label>Post Office Code</label>
								<form:input path="postOfficeCode" placeholder="Post Office Code(Please Enter Numeric Value)" class="span4" id="postcode" maxlength="7" onBlur="postinputValue();" onKeyPress="return isNumberKey2(event)"/>
								</div>
								</div>
								<div class="row">
								<div class="span4">
								<label>City</label>
								<form:input path="city" placeholder="City" class="span4" id="city"/>
								</div>
								<div class="span4">
								<label>District</label>
								<form:input path="district" placeholder="District" class="span4" id="dist"/>
								</div>
								</div>
								<div class="row">
								<div class="span4">
								<label>State</label>
								<form:input path="state" placeholder="State" class="span4" id="state"/>
								</div>
								<div class="span4">
								<label>Country</label>
								<form:input path="country" placeholder="Country" class="span4" id="county"/>
								</div>
								</div>
								<div class="row">
								<div class="span4"><label>Preferred Contact</label>
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
							 <a href="#" class="btn btn-default">
							 <img src="${pageContext.request.contextPath}/resources/images/d-save.png"/><br>Save</a>
						 
						      <a href="#" class="btn btn-default" >
							 <img src="${pageContext.request.contextPath}/resources/images/d-save-new.PNG"/><br>Save-New</a>
								  
					  
							<a href="#" class="btn btn-default" >
							<img src="${pageContext.request.contextPath}/resources/images/d-saveclose.PNG"/><br>Save-Close</a>
						
						<a href="${pageContext.request.contextPath}/refferdLabIfo" class="btn btn-default">
							<img src="${pageContext.request.contextPath}/resources/images/e-close.png"/><br>Close</a>
						  </div>
                      </center>                       		
				</div>
           	</div>
		</div>
     </div>
        </div>
<form:hidden path="dispatch" />        
</body>
<script>
var form = document.getElementById("viewid");
function sucessclose()
{	
	$("#sucessdiv").hide();	
}
function errorclose()
{	
	$("#errordiv").hide(); 
}
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

</script>
</form:form>
</html>