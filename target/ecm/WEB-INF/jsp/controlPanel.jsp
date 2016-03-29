<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- saved from url=(0057)http://wbpreview.com/previews/WB01BG165/user-account.html -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
    <title>Clinikraja</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">    
    
    <!-- CSS files -->
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap-responsive.min.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/alveolae.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/font-awesome.css">
    <!-- Google font -->
   

	<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->	
</head>
<form:form commandName="index" id="log" >
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
		<div class="span12">
			<h1 class="page-title desktop">Control Panel</h1>
				<div class="widget">						
					<div class="widget-content">
						<div class="box-container">
							 <div class="box-holder">
                                 <a href="${pageContext.request.contextPath}/userLabInfo">
                                 	<div class="box" style="height:60px;">
                                    <img src="${pageContext.request.contextPath}/resources/images/info.png"/><br>Lab Profile</div>
                                 </a>
				       	    </div>
                            <div class="box-holder">
                                <a href="${pageContext.request.contextPath}/patientManager">
                                	<div class="box" style="height:60px;">
                                    <img src="${pageContext.request.contextPath}/resources/images/user.png"/><br>Patient Manager</div>
                                 </a>
                            </div>
                            <div class="box-holder">						
                                <a href="${pageContext.request.contextPath}/doctorManager">
                               		 <div class="box" style="height:60px;">
                                     <img src="${pageContext.request.contextPath}/resources/images/add.png"/><br>Doctor Manager</div>
                                </a>
                            </div>                            
                            <div class="box-holder">						
                                <a href="${pageContext.request.contextPath}/refferdLabIfo">
                                	<div class="box" style="height:60px;">
                                    <img src="${pageContext.request.contextPath}/resources/images/puzzle.png"/><br>Vendor Manager </div>
                                </a>
                            </div>
                        </div> 
                		<div class="box-container"> 
                       		 <div class="box-holder">						
								<a href="${pageContext.request.contextPath}/underConstruction">
                  				  <div class="box" style="height:60px;">
                                  <img src="${pageContext.request.contextPath}/resources/images/process.png"/><br>Configuration</div>
                 			   	</a>
							</div>             
							<div class="box-holder">						
								<a href="${pageContext.request.contextPath}/testOrderManager">
                               	 <div class="box" style="height:60px;">
                                 <img src="${pageContext.request.contextPath}/resources/images/books.png"/><br>Test Order Manager</div>
                                </a>
							</div>
							<div class="box-holder">						
								<a href="${pageContext.request.contextPath}/underConstruction">
                               	 <div class="box" style="height:60px;">
                                 <img src="${pageContext.request.contextPath}/resources/images/print.png"/><br>Report Manager</div>
                                </a>
							</div>
							<div class="box-holder">						
								<a href="${pageContext.request.contextPath}/userAccessManager">
                                	<div class="box" style="height:60px;">
                                    <img src="${pageContext.request.contextPath}/resources/images/users.png"/><br>User Manager</div>
                                </a>
							</div>                            
              		  </div> 
					</div>
				</div>										
			</div>
				<!-- /Content -->
		</div>
			<span style="color:green"><h3>${controlPanel.alertMessage}</h3></span>
			
			<!-- Footer -->
			<div id="footer">
				<hr>
				<p class="pull-right">Gaddiel Technologies Pvt Ltd &copy; 2013</p>
			</div>
			<!-- /Footer -->
	
		</div>
		<!-- /Container -->
	</div>
	<!-- /Main content -->

	<!-- Javascript files -->
	


</body>
	</form:form>
	</html>