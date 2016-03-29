<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- saved from url=(0057)http://wbpreview.com/previews/WB01BG165/user-account.html -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
    <title>Clinical Laboratory - Admin Dashboard</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">    
    
    <!-- CSS files -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap-responsive.min.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/alveolae.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery.1.9.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js" type="text/javascript"></script>
    

	<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->	
</head>
<style>
.contact-box {
				margin: 10px 10px 10px 10px;
				padding: 10px 20px 30px;
				border-radius: 5px;
				opacity: 0.8;
				background-color: #C4C4C4;
				position: relative;
				z-index: 3;
			}
</style>

<body>
	<!-- Navbar -->
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#">&nbsp;&nbsp;&nbsp;&nbsp;<img width="40px" height="40px" src="${pageContext.request.contextPath}/resources/images/ecmlogo.PNG"/></a>
				<div class="mobile pull-right ">
				   <ul class="nav navbar-nav navbar-right">
            			<li class="dropdown">
							<a href="#" style=" font-size: .80em;" data-toggle="dropdown" class="dropdown-toggle"><i class="icon-lock"></i>
							<%= session.getAttribute("username") %></a>
							<ul class="dropdown-menu ">
							<li><a href="${pageContext.request.contextPath}/resetPassword"><i style=" font-size: 1em;"></i>ChangePassword</a></li>
                              <li><a href="${pageContext.request.contextPath}/logout" ><i style=" font-size: 1em;" class="icon-unlock"></i>Logout</a></li>
                              
							</ul>
						</li>
					</ul>
				</div>
				<div class="desktop pull-right">
					<ul class="nav navbar-nav navbar-right">
						
						<li class="dropdown" ><a href="#" data-toggle="dropdown" class="dropdown-toggle"><i class="icon-lock"></i>&nbsp;&nbsp;<%= session.getAttribute("username") %></a>
						<ul class="dropdown-menu ">
						<li><a href="${pageContext.request.contextPath}/resetPassword">&nbsp;&nbsp;ChangePassword</a></li>
						<li><a href="${pageContext.request.contextPath}/logout" name="one" ><i  class="icon-unlock"></i>&nbsp;&nbsp;Logout</a></li>						
						</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- /Navbar -->
	
	
	
</body>


</html>