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
	
	</style>	
</head>
<form:form commandName="resetPassword" id="log" >
<body>
	<div id="main-content">
		<!-- Container -->
		<div class="container" >
		   	<div class="box-container">
				<div class="alert alert-success alert-block" id="sucessdiv">
					<button type="button" class="close" onClick="sucessclose()" data-dismiss="alert">&times;</button>
					<h4 id="successmessage">${resetPassword.successmessage}</h4>
				</div>
			</div>
			<!-- Tittle Header -->
            <div class="row">
				<div class="span12">       				                
					<div class="widget">                    					
					    <div class="widget-content"> 
                            <div class="span7">
                                <h3>Change Password</h3>	
                            </div>  
					    </div>   
									
                    </div>	 
                </div>
            </div>
		<!-- /Tittle Header -->
		<!-- Body -->
			<div class="row">  
				<div class="span12">						
					<div class="widget">				
					    <div class="widget-header">
						    <div class="span7">						       
								<h5>Please set your security questions for changing your password.</h5>
						    </div>
						</div>
						<div class="widget-content">
						    							
						    <div class="row">
						        <div class="span4">
								    <label class="span4">What is your favorite color?<span style="color:red"> *</span></label>
								</div>
								<div class="span7">
							        <form:input path="firstquestion" placeholder="Enter your favorite color" id="first" onBlur="firstname()"  class="span4"/>
									<span style="color:green" id="firstnames">${resetPassword.errormessage}</span>	
						        </div>
							</div>
							<div class="row">							    
								<div class="span4">
								    <label class="span4">Who is your favorite hero?<span style="color:red"> *</span></label>
								</div>
								<div class="span7">
								    <form:input path="secondquestion" placeholder="Enter your favorite hero" id="second" onBlur="secondname()" class="span4"/>
									<span style="color:green" id="secondnames">${resetPassword.errormessage}</span>	
							    </div>
							</div>		
							<div class="row">		
								<div class="span4">
								    <label class="span4">New Password<span style="color:red"> *</span></label>
								</div>
								<div class="span7">
								    <form:input path="newPassword" type="password" placeholder="Enter the new password" id="password" onBlur="newpassword()" onKeyup="passwordCheck()" class="span4"/>
									<span style="color:red" id="check"></span>
								</div>	
							</div>
							<div class="row">		
								<div class="span4">
								 	<label class="span4" >Confirm Password<span style="color:red"> *</span></label>
								</div>
								<div class="span7">
								    <form:input path="confirmPassword" type="password" placeholder="Re-enter the new password for confirmation" id="conpassword" onBlur="matchpwd()" class="span4"/>
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
			<!-- /Body -->
		    <div id="footer">
				<hr>
				<p class="pull-right">Gaddiel Technologies Pvt Ltd &copy; 2013</p>
			</div>
			
        </div>
	
    </div>
	<!-- /Main content -->

	<!-- Javascript files -->
	<form:hidden path="dispatch"/>
	<form:hidden path="dispatchhitted"/>
	</body>
	<script>
var form=document.getElementById("log");
$("#sucessdiv").hide();
$("#password").attr("readonly", true);
$("#conpassword").attr("readonly", true);
function sucessclose()
{
	
	$("#sucessdiv").hide();
	
}
	function passwordCheck()
{

var WeakPass = /(?=.{1,}).*/; 
var Medium = /^(?=\S*?[a-z])(?=\S*?[0-9])\S{1,}$/; 
var StrongPass = /^(?=\S*?[A-Z])(?=\S*?[a-z])(?=\S*?[0-9])\S{1,}$/; 
var VryStrongPass = /^(?=\S*?[A-Z])(?=\S*?[a-z])(?=\S*?[0-9])(?=\S*?[^\w\*])\S{1,}$/;

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
function secondname(){

	if (!document.getElementById("second").value.match(/\S/))
	{

	       document.getElementById("secondnames").innerHTML= '<b><span style="color:red">please give the secondquestion answer</span>';
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
function validate(){
if (!document.getElementById("first").value.match(/\S/))
{

       document.getElementById("firstnames").innerHTML='<b><span style="color:red">please give the firstquestion answer</span>';
  document.getElementById("first").style.borderColor="#FF0000";
      
    }
	
	if (!document.getElementById("second").value.match(/\S/))
{

       document.getElementById("secondnames").innerHTML= '<b><span style="color:red">please give the secondquestion answer</span>';
  document.getElementById("second").style.borderColor="#FF0000";
      
    }
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

	if((document.getElementById("first").value.match(/\S/))&& (document.getElementById("second").value.match(/\S/)) && (document.getElementById("password").value.match(/\S/)) && (document.getElementById("conpassword").value.match(/\S/)) && (document.getElementById("password").value==document.getElementById("conpassword").value))
{

form.dispatch.value="Change";
alert(form.dispatch.value);
form.submit();
}
 }
 if(form.dispatch.value=="Change")
 {
 $("#sucessdiv").show();
 }
 if((document.getElementById("secondnames").innerHTML.match("correct answer")) && (!document.getElementById("secondnames").innerHTML.match("Enter the correct answer")))
 {
 $("#password").attr("readonly", false);
 $("#conpassword").attr("readonly", false);
 }
 window.history.forward(1);
</script>
	</form:form>
</html>