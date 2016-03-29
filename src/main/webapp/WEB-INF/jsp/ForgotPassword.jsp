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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap-responsive.min.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/alveolae.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/font-awesome.css">
    
    <!-- Google font -->
    <link href="/css/css.css" rel="stylesheet" type="text/css">

	     <script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>
	     
	<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
 
      
    <![endif]-->
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
</head>
<form:form commandName="ResetPassword" id="log" >
<body onload="myFunction()">
		<!-- Navbar -->
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#"><img src="${pageContext.request.contextPath}/resources/images/logo90.png" Style=" width:300px; height:40px;" align="left"/></a>			</div>
	  </div>
	</div>
	<!-- /Navbar -->
	
	<div id="main-content">
		<!-- Container -->
		<div class="container" >
			<div class="box-container">
				
			</div>
			 <br>
		<!-- Tittle Header -->
            <div class="row">
				<div class="span12 desktop">      				                
					<div class="widget">                    					
					    <div class="widget-content"> 
                            <div class="span7">
								<h3>RESET/CHANGE PASSWORD</h3>	
							</div> 
							<div class="span3">                                                                                                           
                                <div class="box-holder"><a href="#" id="savd" class="savd" hidden="hide"/><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save.png"/>Save</div></a></div> 													                                              
								<div class="box-holder"><a href="#" id="savnewd" class="savnewd" hidden="hide"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save-new.PNG"/>Save & New</div></a></div>
								<div class="box-holder"><a href="#"id="savcold" class="savcold" hidden="hide"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-saveclose.PNG"/>Save & Close</div></a></div>
                                <div class="box-holder"><a href="${pageContext.request.contextPath}/index"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-close.png"/>close</div></a></div>
                            </div>      
						</div> 			
                    </div>	
                </div>
            </div>
		<!-- /Tittle Header -->
		<!-- Body -->
			<div class="row">
                <div class="span12" >
				     <div class="mobile"><h3>RESET/CHANGE PASSWORD</h3></div> 	
					<div class="widget">
						
						<div class="widget-content" >
						    
							<div class="row">
						  		<div class="span4">
									<label class="span4">User Name<span style="color:red"> *</span></label>
								</div>
								<div class="span7">
							        <form:input path="username" placeholder="Enter the User Name" id="username" onKeyup="selected()" class="span4"  style="height:30px;"/>
									<span style="color:green" id="userid" >${ResetPassword.successmessage}</span>	
								</div>
						    </div>
							
							<div class="row">
								<div class="span4">
									<label class="span4">Select User Type<span style="color:red"> *</span></label>
								</div>
								<div class="span7">
									<form:select path="userType" class="span4" placeholder="Search by User Type" id="searchusertype" style="height:30px;"
									onChange="selected()"><option value="0">-select-</option><form:options items="${userTypeList}" />
									</form:select>
								</div>		
                            </div>
							<div class="row">
								<div class="span4">
								
								</div>
								<div class="span7">
									<a class="btn btn-info " id="idaddorder" onClick="check()">Check</a>
								</div>	
							</div>
                       </div>		
					   <br>
					    <div class="widget-header showhid">
						    <div class="span7">						       
								<h5>Please answer the security questions for changing the password.</h5>
						    </div>
						</div>
					   <div class="widget-content showhid">	
					   
						    <div class="row">
								<div class="span4">
								    <label class="span4">What is your favorite color?<span style="color:red"> *</span></label>
								</div>
								<div class="span7">
							         <form:input path="firstquestion" placeholder="Enter your favorite color" id="first" onBlur="firstname()"  class="span4" style="height:30px;"/>
									 <span style="color:green" id="firstnames">${ResetPassword.errormessage}</span>	
						        </div>
							</div>
							<div class="row">
								<div class="span4">
								    <label class="span4">Who is your favorite hero?<span style="color:red"> *</span></label>
								</div>
								<div class="span7">
								    <form:input path="secondquestion" placeholder="Enter your favorite hero" id="second"  onKeyPress="return isNumberKey(event)" onBlur="secondname()" class="span4" style="height:30px;"/>
								    <span style="color:green" id="secondnames">${ResetPassword.errormessage}</span>	
							    </div>
							</div>							
							<div class="row">		
								<div class="span4">
								    <label class="span4">New Password<span style="color:red"> *</span></label>
								</div>
								<div class="span7">
								    <form:input path="newPassword" type="password" placeholder="Enter the new password" id="password" onBlur="newpassword()" class="span4" onKeyup="passwordCheck()" style="height:30px;"/>
								    <span style="color:red" id="check"></span>
								</div>
							</div>
							<div class="row">		
								<div class="span4">
								    <label class="span4">Confirm Password<span style="color:red"> *</span></label>
								</div>
								<div class="span7">
								     <form:input path="confirmPassword" type="password" placeholder="Re-enter the new password for confirmation" id="conpassword" onBlur="matchpwd()" class="span4" style="height:30px;"/>
									 <span style="color:red" id="match"></span>
								</div>	
							</div>
						
						
							<div class="row">  
							   <div class="span4">
								
								</div>
								<div class="span7">
							        <a class="btn btn-info " id="idaddorder" onClick="validate()">Change</a>
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
			<div class="dock-wrapper">    
				<div class="navbar navbar-fixed-bottom">
					<div class="navbar-inner">
						<div class="container">                  
							<center>
								<div class="btn-group btn-group-justified">                                               
							  
									<a href="${pageContext.request.contextPath}/index" class="btn btn-default">
									<img src="${pageContext.request.contextPath}/resources/images/e-close.png"/><br>Close</a>
							  </div>
							</center>	                       		
						</div>
					</div>
				</div>
			</div>	
        </div>
	
    </div>
	<!-- /Main content -->
	
   
	<!-- Javascript files -->
	<form:hidden path="dispatch"/>
	<form:hidden path="dispatchhit"/>
	<form:hidden path="dispatchhitted"/>
	</body>
	<script>
$(".showhid").hide();

$("#password").attr("readonly", true);
$("#conpassword").attr("readonly", true);
	if(document.getElementById("userid").value!="matched")
{
	$(".showhid").hide();
}
	var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
var form=document.getElementById("log");

	function passwordCheck()
{

var WeakPass = /(?=.{1,}).*/; 
var Medium = /^(?=\S*?[a-z])(?=\S*?[0-9])\S{5,}$/; 
var StrongPass = /^(?=\S*?[A-Z])(?=\S*?[a-z])(?=\S*?[0-9])\S{5,}$/; 
var VryStrongPass = /^(?=\S*?[A-Z])(?=\S*?[a-z])(?=\S*?[0-9])(?=\S*?[^\w\*])\S{5,}$/;

var password1 = document.getElementById("password"); 

 if(VryStrongPass.test(password1.value))
    {
       document.getElementById('check').innerHTML = '<b><span style="color:blue"> very Strong!</span>';
    }   
 else if(StrongPass.test(password1.value))
    {
        document.getElementById('check').innerHTML = '<b><span style="color:green">Strong!</span>';
    }   
  else if(Medium.test(password1.value))
    {
        document.getElementById('check').innerHTML = '<b><span style="color:orange"> good!</span>';
    }
  else if(WeakPass.test(password1.value))
    {
        document.getElementById('check').innerHTML = '<b><span style="color:red">low!</span>';
    }
	else
	{
	 document.getElementById('check').innerHTML = '';
	}
  
}
function matchpwd(){
if(document.getElementById("password").value!=document.getElementById("conpassword").value)
{
 document.getElementById('match').innerHTML = "Password did not match. Re-enter";
}
else{
document.getElementById('match').innerHTML = "";
 document.getElementById("conpassword").style.borderColor="#64FE2E";
}

}
function firstname(){
	if (!document.getElementById("first").value.match(/\S/))
	{

	       document.getElementById("firstnames").innerHTML='<b><span style="color:red">please give the firstquestion answer</span>';
	  document.getElementById("first").style.borderColor="#FF0000";
	      
	    }
		else{
		  document.getElementById("firstnames").innerHTML= "";
	  document.getElementById("first").style.borderColor="#64FE2E";
		}
}
function newpassword(){
var a=/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$/;
	 if (!document.getElementById("password").value.match(a))
	 {

	        document.getElementById("check").innerHTML= "Enter 8 characters minimum one numeric char or one alpha char";
	   document.getElementById("password").style.borderColor="#FF0000";
	       
	     }
	 	else{
	 	  document.getElementById("check").innerHTML= "";
	   document.getElementById("password").style.borderColor="#64FE2E";
	 	}
}
function secondname(){
  if (!document.getElementById("second").value.match(/\S/))
  {

       document.getElementById("secondnames").innerHTML='<b><span style="color:red">please give the secondquestion answer</span>';
  document.getElementById("second").style.borderColor="#FF0000";
      
    }
	else{
	 	  document.getElementById("secondnames").innerHTML= "";
	   document.getElementById("second").style.borderColor="#64FE2E";
	 	}
	

	if((document.getElementById("first").value.match(/\S/))&& (document.getElementById("second").value.match(/\S/))){	
		form.dispatchhitted.value="resetpwdchange";
		form.submit();
		}
   if(typeof(Storage)!=="undefined")
  {
  if (sessionStorage.clickcount)
    {
    sessionStorage.clickcount=Number(sessionStorage.clickcount)+1;
    }
  else
    {
    sessionStorage.clickcount=1;
    }	  
	 sessionStorage.clickcount;
  }
if( sessionStorage.clickcount==3){
window.location.assign("http://www.gaddieltech.com/index.php/contact")
}
}
if( sessionStorage.clickcount>=3){
	sessionStorage.clear();
	}
function validate(){
	 if (!document.getElementById("password").value.match(/\S/))
{

       document.getElementById("check").innerHTML= "please enter the new password";
  document.getElementById("password").style.borderColor="#FF0000";
      
    }
	
	 if (!document.getElementById("conpassword").value.match(/\S/))
{

       document.getElementById("match").innerHTML= "please enter the confirm password";
  document.getElementById("conpassword").style.borderColor="#FF0000";
      
    }
	
   
	if((document.getElementById("password").value.match(/\S/)) && (document.getElementById("conpassword").value.match(/\S/)) && (document.getElementById("password").value==document.getElementById("conpassword").value))
{

form.dispatch.value="resetpwd";
alert(form.dispatch.value);
form.submit();
}
 }

function check(){

if((document.getElementById("username").value.match(reg)) || (document.getElementById("searchusertype").value!="-Select Type-"))
{
form.dispatchhit.value="resetvalue";
form.submit();
}
}
function myFunction(){
if(document.getElementById("userid").innerHTML.match("matched"))
{
	$(".showhid").show();
}
if((document.getElementById("secondnames").innerHTML.match("correct answer")) && (!document.getElementById("secondnames").innerHTML.match("Enter the correct answer")))
{
$("#password").attr("readonly", false);
$("#conpassword").attr("readonly", false);
}
  
}
window.history.forward(1);
</script>
	</form:form>
</html>