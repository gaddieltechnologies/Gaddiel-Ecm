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
<form:form commandName="userAccessManagerView" id="userviewid">
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
                                            <h3>User Access Manager </h3>	
                                            </div>                       
                                           
												 <div class="span3">                                                                                                           
                                                    <div class="box-holder"><a href="#" id="savd" class="savd" disable="disable"/><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save.png"/>Save</div></a></div> 													                                              
													<div class="box-holder"><a href="#" id="savnewd" class="savnewd" disable="disable"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save-new.PNG"/>Save-New</div></a></div>
													<div class="box-holder"><a href="#"id="savcold" class="savcold" disable="disable"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-saveclose.PNG"/>Save-Close</div></a></div>
                                                    <div class="box-holder"><a href="${pageContext.request.contextPath}/userAccessManager"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-close.png"/>Close</div></a></div>
                                                </div> 
                                        </div>                                    
                                    </div>	              
                                </div>
                            </div>
				<div class="row">
                                <!-- Sidebar -->
				<div class="span3">  
					<div class="widget-content">					
                        <div class="mobile">  <h3>User Access Manager </h3>	</div> 					
						<div class="span2"><img src="${pageContext.request.contextPath}/download"/></div>
					</div>
				</div>
				<!-- /Sidebar -->
				
				<!-- Content -->
				<div class="span9">
					
								
					<div class="widget">
						
						<div class="widget-content">
							<form>
						
								<div class="row">
								<div class="span4"><label>Name</label><form:input path="userName" id="usernameid" placeholder="Name" class="span4"/></div>								
								<div class="span4"><label>Role</label>
								      <form:input path="role" id="roleid" class="span4" />	
								           
								</div>
								</div>
								<div class="row">
								<div class="span4"><label>User Type</label><form:input path="userType" placeholder="User Type" id="usertypeid" class="span4"/></div>
								<div class="span4"><label>Default Password Changed?</label><form:input path="defaultPasswordChanged" id="defpasschangeid" placeholder="Y" class="span4"/></div>                             
								</div>
								<div class="row">
								<div class="span4"><label>Is User Deleted?</label><form:input path="userDelete" placeholder="N" id="userdeleteid" class="span4"/></div>
								<div class="span4"><label>Is User Active?</label><form:input path="userActive" placeholder="Y" id="useractiveid" class="span4"/></div>
								</div>
								<div class="row">
								
								<div class="span4"><label>Start Date</label><form:input path="startDate" id="startdateid" class="span4"/></div>
								<div class="span4"><label>End Date</label><form:input path="endDate" id="enddateid" class="span4"/></div>
								</div>
								<div class="row">
								
								<div class="span4"><label>Last Success Login on</label><form:input path="successLogin" id="successdateid" class="span4"/></div>
								<div class="span4"><label>Last Failed Login on</label><form:input path="failedLogin" id="faileddateid" class="span4"/></div>
								</div>
								<div class="row">
								
								<div class="span4"><label>Next Password Change Date</label><form:input path="nextPasswordChangeDate" id="nxpasschangeid" placeholder="" class="span4"/></div>
								<div class="span4"><label>Remarks</label><form:input path="remarks" id="remarksid" placeholder="" class="span4"/></div>
								
								               		
							</form>
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
					
                            <a href="${pageContext.request.contextPath}/userAccessManager" class="sav btn btn-default">
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
var js=jQuery.noConflict();
js(function() {

 	 js("#picker1").datepicker({
       changeMonth: true,
	   changeYear: true,
	     yearRange: '1900:2100',
	   dateFormat:"d-mm-yy",
       
    });
	
});
</script>
<script>

var form = document.getElementById("userviewid");
var js=jQuery.noConflict();
js("#errordiv").hide();
js("#sucessdiv").hide();
function sucessclose()
{
	
	js("#sucessdiv").hide();
	
}
function errorclose()
{
	
	js("#errordiv").hide(); 
}


	js("#usernameid").attr("disabled", true);
	js("#roleid").attr("disabled", true);
	js("#usertypeid").attr("disabled", true);
	js("#defpasschangeid").attr("disabled", true);
	js("#useractiveid").attr("disabled", true);
	js("#userdeleteid").attr("disabled", true);
	js("#startdateid").attr("disabled", true);
	js("#enddateid").attr("disabled", true);
	js("#successdateid").attr("disabled", true);
	js("#faileddateid").attr("disabled", true);
	js("#nxpasschangeid").attr("disabled", true);
	js("#remarksid").attr("disabled", true);
	


</script>
</form:form>
</html>