<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Clinical Laboratory - Admin Dashboard</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">    
    
    <!-- CSS files -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap-responsive.min.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/alveolae.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/font-awesome.css">
    <!-- Google font -->
    <link href="/css/css.css" rel="stylesheet" type="text/css">

	<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->	
</head>
<form:form commandName="userLabInfo">
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
                                            <h3>Clinical Lab Profile</h3>	
                                            </div>                       
                                               <div class="span3">                                                                
	                               <div class="box-holder">
	                                   <a><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-add.png"/>New</div></a>
	                               </div>  
	                               <div class="box-holder">
								        <a id="viewd" class="viewdd">
                                        <div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-view.png"/>View</div></a>
										 
	                               </div>  
	                               <div class="box-holder">	                                
									  <a id="edit-d" class="edit-d">
                                      <div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-edit.png"/>Edit</div></a>
	                               </div>  
	                               <div class="box-holder">
	                                  <a >
	                                  <div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-trash.png"/>delete</div></a>
	                               </div>  
	                               <div class="box-holder">
	                                  <a href="${pageContext.request.contextPath}/controlPanel">
	                                  <div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-close.png"/>Close</div></a>
	                               </div>        
	                              	                                              
	                             </div>                       
                                        </div>                                    
                                    </div>	              
                                </div>
                            </div>
				<div class="row">
                
				<!-- Sidebar -->
				<div class="span3">	
				    <div class="mobile"> <h3>Clinical Lab Profile</h3></div> 
					<div class="widget-content">	
						<div class="span2"><h2>${userLabInfo.labName}</h2></div>
						<div class="span2"><img src="${pageContext.request.contextPath}/download"/></div>							
						<div class="span2"><label>Lab Id : </label><input type="text" value="${userLabInfo.labId}" disabled="disable" class="span2"></div>
						<div class="span2"><label>Client Id : </label><input type="text" value="${userLabInfo.client}" disabled="disable" class="span2"></div>
						<div class="span2"><label>Client Name : </label><input type="text" value="${userLabInfo.clientName}" disabled="disable" class="span2"></div>					
					</div>					
				</div>
				<!-- /Sidebar -->
				
				<!-- Content -->
					<div class="span9">	
						<div class="widget">
							<div class="widget-header">
								<h3>Address & contact</h3>
							</div>
							<div class="widget-content">							   
								<div class="span2"><label>Door</label><input type="text" value="${userLabInfo.addressLine1}" disabled="disable" class="span2"></div>
								<div class="span2"><label>Street Name</label><input type="text" value="${userLabInfo.addressLine2}" disabled="disable" class="span2"></div>
								<div class="span2"><label>Area</label><input type="text" value="${userLabInfo.area}" disabled="disable" class="span2"></div>
								<div class="span2"><label>Post Office Code</label><input type="text" value="${userLabInfo.postalcode}" disabled="disable" class="span2"></div>
								<div class="span2"><label>City</label><input type="text" value="${userLabInfo.city}" disabled="disable" class="span2"></div>
								<div class="span2"><label>District</label><input type="text" value="${userLabInfo.district}" disabled="disable" class="span2"></div>
                                <div class="span2"><label>State</label><input type="text" value="${userLabInfo.state}" disabled="disable" class="span2"></div>
                                <div class="span2"><label>Country</label><input type="text" value="${userLabInfo.country}" disabled="disable" class="span2"></div>
                                <div class="span2"><label>Phone LandLine</label><input type="text" value="${userLabInfo.phoneLandLine}" disabled="disable" class="span2"></div>
                                <div class="span2"><label>Phone Mobile</label><input type="text" value="${userLabInfo.phoneMobile}" disabled="disable" class="span2"></div>
							    <div class="span2"><label>Emergency Phone</label><input type="text" value="${userLabInfo.emergencyPhoneNumber}" disabled="disable" class="span2"></div>
                                <div class="span2"><label>PhoneFax</label><input type="text" value="${userLabInfo.phoneFax}" disabled="disable" class="span2"></div>
                                <div class="span4"><label>E-mail Id</label><input type="text" value="${userLabInfo.emailId}" disabled="disable" class="span4"></div>
                                <div class="span4"><label>Website Address</label><input type="text" value="${userLabInfo.websiteAddress}" disabled="disable" class="span4"></div>			                                		
								<div class="span4"><label> Allow Third Party Access</label><input type="text" value="${userLabInfo.allowThirdpartyAccess}" disabled="disable" class="span4"></div>
								<div class="span4"><label> Remarks</label><input type="text" value="${userLabInfo.remarks}" disabled="disable" class="span4"></div>								
							</div>                
						</div>
					</div>
				<!-- /Content -->
                </div>
				<div id="footer">
				<hr>
				<p class="pull-right">Gaddiel Technologies Pvt Ltd &copy; 2013</p>
<div class="dock-wrapper">    
         <div class="navbar navbar-fixed-bottom">
            <div class="navbar-inner">
                <div class="container">                  
                        <center>
                            <div class="btn-group btn-group-justified">                      
							    <a href="#" class="btn btn-default" onclick="newPage()">
								<img src="${pageContext.request.contextPath}/resources/images/d-add.png"/><br>New</a> 
								<a id="viewd" class="viewd btn btn-default">
								<img src="${pageContext.request.contextPath}/resources/images/d-view.png"/><br>View</a>								   
								<a id="edit-d" href="#" class="edit-d btn btn-default">
								<img src="${pageContext.request.contextPath}/resources/images/d-edit.png"/><br>Edit</a>
							    <a href="${pageContext.request.contextPath}/controlPanel" class="btn btn-default">
								<img src="${pageContext.request.contextPath}/resources/images/d-trash.png"/><br>Delete</a>
							    <a href="${pageContext.request.contextPath}/controlPanel" class="btn btn-default">
									<img src="${pageContext.request.contextPath}/resources/images/e-close.png"/><br>Close</a>		
						    </div>   
						</center> 	
				</div>     
           	</div>
		</div>
     </div>		</div>
				
        </div>
		
</body>
</form:form>
</html>