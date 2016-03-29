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
    <style></style>	
</head>
<form:form commandName="index" id="log" >
<body>
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
			<!-- Header boxes -->
			<div class="box-container">
				
			</div>
			<!-- /Header boxes -->
			
			<div class="row">
            <div class="span6 desktop">
					<div class="widget">	                    					
						<div class="widget-content"> 
                          <p><img width="100px" height="100px" src="${pageContext.request.contextPath}/resources/images/ecmlogo.PNG"/></p><p> Easy Clinical Manager (eCM) is a web-enabled product for Clinical Labs. This product is accessible by all registered users (Patient, Doctor, Lab, and Vendor Lab). This application support functions related to patient care, including registration, clinical systems for doctors and other care providers. Small-scale accounting could also be maintained in which the billing of patient and the commission of doctor is automatically calculated. </p>
</div>
              		</div>
               </div>
          
           	<!-- /Header boxes -->
				<!-- Sidebar -->
	<div class="span5">                
    	<div class="widget">
			<div class="widget-header Clinical" style="background-color:#5bb75b;">
				<h3 style="color:#333333">CLINICAL LABORATORY LOGIN</h3>
			</div>
			<div class="widget-content clinical">                       
				<div class="span4">
					<label>User Name</label>
					<form:input path="clinicallabUserName" type="email" name="clinicallabusername" id="clinicallabusname" placeholder="Example:nikhil@gmail.com" 
					class="span4" onblur="clinicallabunamevalidate();validateclinicallabuname()" onkeyup="validateclinicallabuname()"  style="height:35px;"/>
					<p id="clinicallabusernamealert" style="color:red;"></p>
                </div>
                
                <div class="span4">
					<label>Password</label>
					<form:password path="clinicallabUserPassword" name="clinicallabuserpassword" id="clinicallabpasswd" placeholder="Password"
					class="span4" onblur="clinicallabpasswordvalidate()" onkeyup="validateclinicallabpassword()" style="height:35px;"/>
					<p id="clinicallabpasswordalert" style="color:red;">${index.clinicalerrormessage}</p>
                </div>
               		<div class="span1" style="padding-bottom:5px">
						<a class="btn btn-success" onMouseOver="showFeatures()"  onMouseOut="hideFeatures()"onClick="clinicallabsubmitvalidate()">Login</a>
					</div> 
					<div class="span2 klog" style="float:left; padding-bottom:5px;">
						<label class="checkbox inline" ><input type="checkbox" onClick="chck()" id="chid1" title="For your protection, keep this checked only on devices you use regularly."/>Keep me Logged in</label>
					</div>       
                      
                   	<div class="span4 fpwd" align="left" style="padding-bottom:5px">
						<a href="${pageContext.request.contextPath}/ResetPassword"  class="btn-link" title="To reset the password">Forgot your Password ?</a>
					</div>
                    <div class="span4" align="left" id="signup">
                      <a href="${pageContext.request.contextPath}/signup"  class="btn-link" title="To get access">Register to access ClinikRaja</a></div>
        		 
                   
		    </div><!-- /widget-content clinical -->
             
		  </div> <!-- /Clinical-Login --> 
            <!-- Patient-Login --> 
            <div class="widget-header patient" style="background-color:#49afcd;">
				<h3 style="color:#333333">PATIENT'S LOGIN</h3>
		  </div>
		<div class="widget-content patient">                       
    	<div class="span4">
        	<label>User Name</label>
            <form:input path="patientUserName" name="patientusername" id="patientusname" placeholder="Example: nikhil@gmail.com" style="height:35px;"
            class="span4" onblur="patientunamevalidate();patcliniclabselect();patientusnamevalidate()" onkeyup="validatepatientuname()" />
            <p id="patientusernamealert" style="color:red;"></p>
        </div>
        <div class="span4">
            <form:select path="patientClinicallabSelect" name="patientclinicallabselect" id="patientclabselecton" style="height:35px;"
            onblur="patientclabselectionvalidate()" onkeyup="validatepatientclabselection()" class="span4">
            <option>-select lab-</option>
            <form:options path="patientClinicallabOptions"></form:options></form:select>
            <p id="patientclabselectionalert" style="color:red;"></p>             				
		</div>
        <div class="span4">
        	<label>Password</label>
            <form:password path="patientUserPassword" name="patientuserpassword" id="patientpasswd" placeholder="Password" 
            class="span4" onblur="patientpasswordvalidate()" onkeyup="validatepatientpassword()" style="height:35px;"/>
            <p id="patientpasswordalert" style="color:red;">${index.patienterrormessage}</p>
        </div>                           
        <div  class="span1" style="padding-bottom:5px">
		<a class="btn btn-info" onMouseOver="showFeatures()" onClick="patientsubmitvalidate()">Login</a>
		</div>	
        <div class="span2 klog" style="float:left; padding-bottom:5px;">
			<label class="checkbox inline" ><input type="checkbox" onClick="chck()" id="chid2" title="For your protection, keep this checked only on devices you use regularly."/>Keep me Logged in</label>
		</div>       
        <div class="span4 fpwd" align="left" style="padding-bottom:5px">
			<a href="${pageContext.request.contextPath}/ResetPassword"  class="btn-link" title="To reset the password">Forgot your Password ?</a>
		</div>
                        </div>
   <!-- /Patient-Login -->
   <!-- Doctor Login -->  
   <div class="widget-header doctor" style="background-color:#faa732;">
		<h3 style="color:#333333">DOCTOR'S LOGIN</h3>
	</div>
	<div class="widget-content doctor">  
    	<div class="span4">
        	<label>User Name</label>
            <form:input path="doctorUserName" name="doctorusername" id="doctorusname" placeholder="Example: nikhil@gmail.com" class="span4"
            onblur="doctorunamevalidate();doccliniclabselect();" onkeyup="validatedoctoruname()" style="height:35px;" />
            <p id="doctorusernamealert" style="color:red;"></p>
 
        </div>
        <div class="span4" >
        	<form:select path="doctorClinicallabSelect" name="doctorclinicallabselect" id="doctorclabselecton" class="span4"
            onblur="doctorclabselectionvalidate()" onkeyup="validatedoctorclabselection()" style="height:35px;">
			<option>-select lab-</option>
			<form:options path="doctorClinicallabOptions"></form:options></form:select>
            <p id="doctorclabselectionalert" style="color:red;"></p>
         				
		</div>
        <div class="span4">
        	<label>Password</label>
            <form:password path="doctorUserPassword" name="doctoruserpassword" id="doctorpasswd" placeholder="Password" class="span4"
            onblur="doctorpasswordvalidate()" onkeyup="validatedoctorpassword()" style="height:35px;"/>
           <p id="doctorpasswordalert" style="color:red;">${index.doctorerrormessage}</p>
 
        </div>                        
        <div  class="span1" style="padding-bottom:5px">
		<a class="btn btn-warning" onMouseOver="showFeatures()" onClick="doctorsubmitvalidate()">Login</a>
		</div> 
        <div class="span2 klog" style="float:left; padding-bottom:5px;">
			<label class="checkbox inline" ><input type="checkbox" onClick="chck()" id="chid3" title="For your protection, keep this checked only on devices you use regularly."/>Keep me Logged in</label>
		</div>       
        <div class="span4 fpwd" align="left" style="padding-bottom:5px">
			<a href="${pageContext.request.contextPath}/ResetPassword"  class="btn-link" title="To reset the password">Forgot your Password ?</a>
		</div>                           		
   </div><!-- /Doctor Login -->  
   <!-- /Vendor Login -->
   <div class="widget-header vendor" style="background-color:#da4f49;">
		<h3 style="color:#333333">VENDOR'S LOGIN</h3>
	</div>
	<div class="widget-content vendor">                            
    	<div class="span4">
        	<label>User Name</label>
            <form:input path="reportUserName" name="reportusername" id="reportusname" placeholder="Example: nikhil@gmail.com" style="height:35px;"
            class="span4" onblur="reportunamevalidate();repcliniclabselect();reportusnamevalidate()" onkeyup="validatereportuname()" />
            <p id="reportusernamealert" style="color:red;"></p>

        </div>
       <div class="span4">
       		<form:select path="reportClinicallabSelect" name="reportclinicallabselect" id="reportclabselecton" class="span4"
            onblur="reportclabselectionvalidate()" onkeyup="validatereportclabselection()" style="height:35px;">
			<option>-select lab-</option>
			<form:options path="reportClinicallabOptions"></form:options></form:select>
            <p id="reportclabselectionalert" style="color:red;"></p>
             				
		</div>
       <div class="span4">
       		<label>Password</label>
            <form:password path="reportUserPassword" name="reportuserpassword" id="reportpasswd" placeholder="Password"
            class="span4" onblur="reportpasswordvalidate()" onkeyup="validatereportpassword()" style="height:35px;"/>
            <p id="reportpasswordalert" style="color:red;">${index.reporterrormessage}</p>
            
       </div>                           
       <div  class="span1" style="padding-bottom:5px">
		<a class="btn btn-danger" onMouseOver="showFeatures()" onClick="reportsubmitvalidate()">Login</a>
	   </div> 
       <div class="span2 klog" style="float:left; padding-bottom:5px;">
			<label class="checkbox inline" ><input type="checkbox" onClick="chck()" id="chid4" title="For your protection, keep this checked only on devices you use regularly."/>Keep me Logged in</label>
		</div>       
        <div class="span4 fpwd" align="left" style="padding-bottom:5px">
			<a href="${pageContext.request.contextPath}/ResetPassword"  class="btn-link" title="To request a new password">Forgot your Password ?</a>
		</div>       		
   </div>
   <!-- /Vendor Login -->
   <br>
            <div class="widget-header desktop">
				<h3>LOGIN AS</h3>
			</div> 
       		 <div class="widget-content desktop"> 
           		<div class="box-container">
                   <div class="box-holder">
                        <a href="#" onClick="clinical()"><div class="box btn-success"><span><img src="${pageContext.request.contextPath}/resources/images/books.png" width="25px"/></span>Clinical</div></a>
                  </div>
                    <div class="box-holder">						
                        <a href="#" onClick="patient()"><div class="box btn-info"><span><img src="${pageContext.request.contextPath}/resources/images/user.png" width="25px"/></span>Patient</div></a>
                    </div>
                    <div class="box-holder ">						
                        <a href="#" onClick="doctor()"><div class="box btn-warning"><span><img src="${pageContext.request.contextPath}/resources/images/add.png" width="25px"/></i></span>Doctor</div></a>
                    </div>
                    <div class="box-holder">						
                        <a href="#" onClick="vendor()"><div class="box btn-danger"><span><img src="${pageContext.request.contextPath}/resources/images/puzzle.png" width="25px"/></i></span>Vendor</div></a>
                    </div>
				</div><!-- /box-container -->		
			</div><!-- /widget-content -->
        </div><!-- /widget -->  			
</div>  <!-- /span5-->                                                
 <!-- --------------------------------------------------------------/ Content -------------------------------------------------- -->              
		                 	
			

			
               
				
                
		
	
			<!-- Footer -->
			<div id="footer">
				<hr>
				<table border="0" class="desktop">
  <tr >
  <td width="95" height="30"></td>
	<td width="895" ><a href="${pageContext.request.contextPath}/underConstruction" style="font-size:12px">Terms and Conditions of Service</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/underConstruction" style="font-size:12px">Security and Privacy Policy</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/underConstruction" style="font-size:12px">Copyright and IP rights</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/underConstruction" style="font-size:12px">Contact Us</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/underConstruction" style="font-size:12px">Feedback</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/underConstruction" style="font-size:12px">Cookies</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/underConstruction" style="font-size:12px">Help</a></td>
  <td style="font-size:12px" >Find us on <a href="https://www.facebook.com/gaddieltechnologies">
  <img src="${pageContext.request.contextPath}/resources/images/facebook.png" width="37" height="35" align="absmiddle" title="Gaddiel Technologies" /></a></td>
  </tr>
</table>
<table align="center">
  <tr>
  <td><p>Copyright&copy;2013 Clinikraja</p>
  </tr>
  </table>
			</div>
			<!-- /Footer -->
	   <!-- Navbar -->
    <div class="dock-wrapper row">    
        <div class="navbar navbar-fixed-bottom">
            <div class="navbar-inner">
                <div class="container">                         
                       <center>
                         <div class="btn-group btn-group-justified">  
						
                        <a href="#" onClick="clinical()" class="btn btn-success">
						<img src="${pageContext.request.contextPath}/resources/images/books.png"/><br>Clinical</a>                 
                  						
                        <a href="#" onClick="patient()" class="btn btn-info">
						<img src="${pageContext.request.contextPath}/resources/images/user.png"/><br>Patient</a>                   
                  						
                        <a href="#" onClick="doctor()" class="btn btn-warning">
						<img src="${pageContext.request.contextPath}/resources/images/add.png"/><br>Doctor</a>
                   						
                        <a href="#" onClick="vendor()" class="btn btn-danger">
						<img src="${pageContext.request.contextPath}/resources/images/puzzle.png"/><br>Vendor</a>
                    					 
                      
                         </div>
                      </center>                        		
				</div>
           	</div>
		</div>
     </div>
	<!-- /Navbar -->
		</div>
		<!-- /Container -->
	</div>
	<!-- /Main content -->
 
	<!-- Javascript files -->
	</body>
	
<form:hidden path="clinikrajlogincheck"/>
<script>
var form = document.getElementById("log");
var js=jQuery.noConflict();

js(".clinical").show();
js(".patient").hide();
js(".doctor").hide();
js(".vendor").hide();
js(".klog").hide();
js(".fpwd").hide();
js("#signup").hide();

function showFeatures()
{
js(".klog").show();
js(".fpwd").show();
js("#signup").show();
}
/*function hideFeatures()
{
	js(".klog").hide();
	js(".fpwd").hide();
	js("#signup").hide();
}*/
function clinical()
{
	js(".clinical").show();
	js(".patient").hide();
	js(".doctor").hide();
	js(".vendor").hide();
	js(".klog").hide();
	js(".fpwd").hide();
	js("#signup").hide();
	}
	function patient()
{
	js(".clinical").hide();
	js(".patient").show();
	js(".doctor").hide();
	js(".vendor").hide();
	
	js(".klog").hide();
	js(".fpwd").hide();
	
	
	}
	function doctor()
{
	js(".clinical").hide();
	js(".patient").hide();
	js(".doctor").show();
	js(".vendor").hide();
	
	js(".klog").hide();
	js(".fpwd").hide();
	}
	function vendor()
{
	js(".clinical").hide();
	js(".patient").hide();
	js(".doctor").hide();
	js(".vendor").show();
	
	js(".klog").hide();
	js(".fpwd").hide();
	}

</script>
<script>
var js = jQuery.noConflict();
if((document.getElementById("clinicallabpasswordalert").innerHTML=="Invalid User Name/Password (or) User is not Active"))
{
	js(".clinical").show();
	js(".patient").hide();
	js(".doctor").hide();
	js(".vendor").hide();
	
}

if((document.getElementById("patientpasswordalert").innerHTML=="Invalid User Name/Password (or) User is not Active"))
{
	js(".clinical").hide();
	js(".patient").show();
	js(".doctor").hide();
	js(".vendor").hide();
	
}

if((document.getElementById("doctorpasswordalert").innerHTML=="Invalid User Name/Password (or) User is not Active"))
{
	js(".clinical").hide();
	js(".patient").hide();
	js(".doctor").show();
	js(".vendor").hide();
	
}

if((document.getElementById("reportpasswordalert").innerHTML=="Invalid User Name/Password (or) User is not Active"))
{
	js(".clinical").hide();
	js(".patient").hide();
	js(".doctor").hide();
	js(".vendor").show();
	
}

function clinicallabunamevalidate()
{
var su= document.getElementById("clinicallabusname").value; 
if(!su.match(/\S/)) {
	document.getElementById("clinicallabusernamealert").innerHTML="Enter valid email id";
	document.getElementById("clinicallabusname").style.borderColor="#FF0000";    
    
    }
var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
var mail=document.getElementById("clinicallabusname")
             if (!mail.value.match(reg) && mail.value !="")
             {
            	 document.getElementById("clinicallabusernamealert").innerHTML="Enter valid email id";
            		document.getElementById("clinicallabusname").style.borderColor="#FF0000";    
    
                 return false;
             }
			 }
			 function validateclinicallabuname(){
			 var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
var mail=document.getElementById("clinicallabusname")
			 if (mail.value.match(reg))
			 {
			   document.getElementById("clinicallabusernamealert").innerHTML="";
			   
			   }
}
			 
function clinicallabpasswordvalidate()
			   {
			   var sp= document.getElementById("clinicallabpasswd").value; 
if(!sp.match(/\S/)) {
	document.getElementById("clinicallabpasswordalert").innerHTML="Invalid User Name/Password";
	document.getElementById("clinicallabpasswd").style.borderColor="#FF0000"; 
    	
}
			   }
function validateclinicallabpassword()
{
var sp= document.getElementById("clinicallabpasswd").value; 
if(sp.match(/\S/)) {
	document.getElementById("clinicallabpasswordalert").innerHTML="";
        
    }
}

function clinicallabsubmitvalidate()
{

	var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	var su= document.getElementById("clinicallabusname").value; 
	if(!su.match(reg)) {
		document.getElementById("clinicallabusernamealert").innerHTML="Enter valid email id";
		document.getElementById("clinicallabusname").style.borderColor="#FF0000";    
       
	    }
	var sp= document.getElementById("clinicallabpasswd").value; 
	if(!sp.match(/\S/)) {
		document.getElementById("clinicallabpasswordalert").innerHTML="Invalid User Name/Password";
		document.getElementById("clinicallabpasswd").style.borderColor="#FF0000";    
    
	}
	
	
		
	if(su.match(reg)&&sp.match(/\S/)&&(document.getElementById("clinicallabpasswordalert").value!="Invalid User Name/Password (or) User is not Active")){
		var form=document.getElementById("log");
		  form.clinikrajlogincheck.value="clinicallablogin";
		  form.submit();
	}
}

function patientunamevalidate()
{
var su= document.getElementById("patientusname").value; 
if(!su.match(/\S/)) {
	document.getElementById("patientusernamealert").innerHTML="Enter valid email id";
	document.getElementById("patientusname").style.borderColor="#FF0000";    
        
    }
var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
var mail=document.getElementById("patientusname")
             if (!mail.value.match(reg) && mail.value !="")
             {
            	 document.getElementById("patientusernamealert").innerHTML="Enter valid email id";
            		document.getElementById("patientusname").style.borderColor="#FF0000";    

                 return false;
             }
			 }
			 function validatepatientuname(){
			 var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
var mail=document.getElementById("patientusname")
			 if (mail.value.match(reg))
			 {
			   document.getElementById("patientusernamealert").innerHTML="";
			   
			   }
}
function patientpasswordvalidate()
			   {
			   var sp= document.getElementById("patientpasswd").value; 
if(!sp.match(/\S/)) {
	document.getElementById("patientpasswordalert").innerHTML="Invalid User Name/Password";
	document.getElementById("patientpasswd").style.borderColor="#FF0000"; 
	
}
			   }
function validatepatientpassword()
{
var sp= document.getElementById("patientpasswd").value; 
if(sp.match(/\S/)) {
	document.getElementById("patientpasswordalert").innerHTML="";
        
    }
}


function patientclabselectionvalidate(){
	var sc= document.getElementById("patientclabselecton").value; 
	if(sc=="-select lab-") {
		document.getElementById("patientclabselectionalert").innerHTML="Please select the Clinical Lab to which you have access";
		document.getElementById("patientclabselecton").style.borderColor="#FF0000";    
    
	    }

	}

	function validatepatientclabselection(){
		var sc= document.getElementById("patientclabselecton").value; 
		if(sc!="-select lab-") {
			document.getElementById("patientclabselectionalert").innerHTML="";
		        
		    }

		}

function patientsubmitvalidate()
{

var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
var unameflag=true;
var passflag=true;
var clabflag=true;

var su= document.getElementById("patientusname").value; 
if(!su.match(reg)) {
	document.getElementById("patientusernamealert").innerHTML="Enter valid email id";
	document.getElementById("patientusname").style.borderColor="#FF0000";  
	
	unameflag=false;
    }
var sp= document.getElementById("patientpasswd").value; 
if(!sp.match(/\S/)) {
	document.getElementById("patientpasswordalert").innerHTML="Invalid User Name/Password";
	document.getElementById("patientpasswd").style.borderColor="#FF0000";
	
	passflag=false;
}
	
var sc= document.getElementById("patientclabselecton").value;

if(sc=="-select lab-") {
	document.getElementById("patientclabselectionalert").innerHTML="Please select the Clinical Lab to which you have access";
	document.getElementById("patientclabselecton").style.borderColor="#FF0000";    
	
	clabflag=false;
    }

	
if(su.match(/\S/)&&sp.match(/\S/)&&(sc!="-select lab-")&&(document.getElementById("patientpasswordalert").value!="Invalid User Name/Password (or) User is not Active")){
	var form=document.getElementById("log");
	  form.clinikrajlogincheck.value="patientlogin";
	  form.submit();
}
}



function doctorunamevalidate()
{
var su= document.getElementById("doctorusname").value; 
if(!su.match(/\S/)) {
	document.getElementById("doctorusernamealert").innerHTML="Enter valid email id";
	document.getElementById("doctorusname").style.borderColor="#FF0000"; 
	
    }
var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
var mail=document.getElementById("doctorusname")
             if (!mail.value.match(reg) && mail.value !="")
             {
            	 document.getElementById("doctorusernamealert").innerHTML="Enter valid email id";
            	 document.getElementById("doctorusname").style.borderColor="#FF0000";
				 
                 return false;
             }
			 }
			 function validatedoctoruname(){
			 var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
var mail=document.getElementById("doctorusname")
			 if (mail.value.match(reg))
			 {
			   document.getElementById("doctorusernamealert").innerHTML="";
			   
			   }
}
function doctorpasswordvalidate()
			   {
			   var sp= document.getElementById("doctorpasswd").value; 
if(!sp.match(/\S/)) {
	document.getElementById("doctorpasswordalert").innerHTML="Invalid User Name/Password";
	document.getElementById("doctorpasswd").style.borderColor="#FF0000";
	}
			   }
function validatedoctorpassword()
{
var sp= document.getElementById("doctorpasswd").value; 
if(sp.match(/\S/)) {
	document.getElementById("doctorpasswordalert").innerHTML="";
        
    }
}

function doctorclabselectionvalidate(){
	var sc= document.getElementById("doctorclabselecton").value; 
	if(sc=="-select lab-") {
		document.getElementById("doctorclabselectionalert").innerHTML="Please select the Clinical Lab to which you have access";
		document.getElementById("doctorclabselecton").style.borderColor="#FF0000";
	        
	    }

	}

	function validatedoctorclabselection(){
		var sc= document.getElementById("doctorclabselecton").value; 
		if(sc!="-select lab-") {
			document.getElementById("doctorclabselectionalert").innerHTML="";
		        
		    }

		}

function doctorsubmitvalidate()
{

var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
var su= document.getElementById("doctorusname").value; 
if(!su.match(reg)) {
	document.getElementById("doctorusernamealert").innerHTML="Enter valid email id";
	document.getElementById("doctorusname").style.borderColor="#FF0000";
        
    }
var sp= document.getElementById("doctorpasswd").value; 
if(!sp.match(/\S/)) {
	document.getElementById("doctorpasswordalert").innerHTML="Invalid User Name/Password";
	document.getElementById("doctorpasswd").style.borderColor="#FF0000";
	}
var sc= document.getElementById("doctorclabselecton").value; 
if(sc=="-select lab-") {
	document.getElementById("doctorclabselectionalert").innerHTML="Please select the Clinical Lab to which you have access";
	document.getElementById("doctorclabselecton").style.borderColor="#FF0000";
    
    }
    

	
if(su.match(reg)&&sp.match(/\S/)&&(sc!="-select lab-")&&(document.getElementById("doctorpasswordalert").value!="Invalid User Name/Password (or) User is not Active")){
	var form=document.getElementById("log");
	  form.clinikrajlogincheck.value="doctorlogin";
	  form.submit();
}
}





function reportunamevalidate()
{
var su= document.getElementById("reportusname").value; 
if(!su.match(/\S/)) {
	document.getElementById("reportusernamealert").innerHTML="Enter valid email id";
	document.getElementById("reportusname").style.borderColor="#FF0000";  
	
    }
var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
var mail=document.getElementById("reportusname")
             if (!mail.value.match(reg) && mail.value !="")
             {
            	 document.getElementById("reportusernamealert").innerHTML="Enter valid email id";
            	 document.getElementById("reportusname").style.borderColor="#FF0000";
				 
                 return false;
             }
			 }
			 function validatereportuname(){
			 var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
var mail=document.getElementById("reportusname")
			 if (mail.value.match(reg))
			 {
			   document.getElementById("reportusernamealert").innerHTML="";
			   
			   }
}
function reportpasswordvalidate()
			   {
			   var sp= document.getElementById("reportpasswd").value; 
if(!sp.match(/\S/)) {
	document.getElementById("reportpasswordalert").innerHTML="Invalid User Name/Password";
	document.getElementById("reportpasswd").style.borderColor="#FF0000";
	}
			   }
function validatereportpassword()
{
var sp= document.getElementById("reportpasswd").value; 
if(sp.match(/\S/)) {
	document.getElementById("reportpasswordalert").innerHTML="";
        
    }
}

function reportclabselectionvalidate(){
	var sc= document.getElementById("reportclabselecton").value; 
	if(sc=="-select lab-") {
		document.getElementById("reportclabselectionalert").innerHTML="Please select the Clinical Lab to which you have access";
		document.getElementById("reportclabselecton").style.borderColor="#FF0000";
		
	    }

	}

	function validatereportclabselection(){
		var sc= document.getElementById("reportclabselecton").value; 
		if(sc!="-select lab-") {
			document.getElementById("reportclabselectionalert").innerHTML="";
		        
		    }

		}

function reportsubmitvalidate()
{

var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
var su= document.getElementById("reportusname").value; 
if(!su.match(reg)) {
	document.getElementById("reportusernamealert").innerHTML="Enter valid email id";
	document.getElementById("reportusname").style.borderColor="#FF0000"; 
	
    }
var sp= document.getElementById("reportpasswd").value; 
if(!sp.match(/\S/)) {
	document.getElementById("reportpasswordalert").innerHTML="Invalid User Name/Password";
	document.getElementById("reportpasswd").style.borderColor="#FF0000";
	}
var sc= document.getElementById("reportclabselecton").value; 
if(sc=="-select lab-") {
	document.getElementById("reportclabselectionalert").innerHTML="Please select the Clinical Lab to which you have access";
	document.getElementById("reportclabselecton").style.borderColor="#FF0000"; 
	
    }
    

	
if(su.match(reg)&&sp.match(/\S/)&&(sc!="-select lab-")&&(document.getElementById("reportpasswordalert").value!="Invalid User Name/Password (or) User is not Active")){
	var form=document.getElementById("log");
	  form.clinikrajlogincheck.value="reportlogin";
	  form.submit();
}
}
function patcliniclabselect(){
	
	var user_Name=document.getElementById("patientusname").value;
js(function() {
	js.post("${pageContext.request.contextPath}/indexpatientclinicselect",
				{userName: user_Name},
								function(data){
					var options = '<option>-select lab-</option>';
					for (var patientlabname = 0; patientlabname < data.length; patientlabname++) {
						
						 
			                  options += '<option value="' + patientlabname + '">' + data[patientlabname] + '</option>';
							  
							   }js("select#patientclabselecton").html(options);
			              
				         
				           
				
					
				
					
				});});}
				
function doccliniclabselect(){
	
	var user_Name=document.getElementById("doctorusname").value;
	
js(function() {
	js.post("${pageContext.request.contextPath}/indexdoctorclinicselect",
				{docuserName: user_Name},
								function(data){
					var options = '<option>-select lab-</option>';
					
					for (var doctorlabname = 0; doctorlabname < data.length; doctorlabname++) {
						
						 
			                  options += '<option value="' + doctorlabname + '">' + data[doctorlabname] + '</option>';
							  
							   }js("select#doctorclabselecton").html(options);
			              
				         
				           
				
					
				
					
				});});}
				
function repcliniclabselect(){
	
	var user_Name=document.getElementById("reportusname").value;
js(function() {
	js.post("${pageContext.request.contextPath}/indexreportclinicselect",
				{testvendoruserName: user_Name},
								function(data){
					var options = '<option>-select lab-</option>';
					for (var reportlabname = 0; reportlabname < data.length; reportlabname++) {
						
						 
			                  options += '<option value="' + reportlabname + '">' + data[reportlabname] + '</option>';
							  
							   }js("select#reportclabselecton").html(options);
			              
				         
				           
				
					
				
					
				});});}
				
</script>
<script>
function chck()
{
	if(document.getElementById("chid1").checked)
	{
	//alert( "True");
	window.location.assign("${pageContext.request.contextPath}/underConstruction")
	}
	if(document.getElementById("chid2").checked)
	{
	//alert( "True");
	window.location.assign("${pageContext.request.contextPath}/underConstruction")
	}
	if(document.getElementById("chid3").checked)
	{
	//alert( "True");
	window.location.assign("${pageContext.request.contextPath}/underConstruction")
	}
	if(document.getElementById("chid4").checked)
	{
	//alert( "True");
	window.location.assign("${pageContext.request.contextPath}/underConstruction")
	}
	else
	{
	}
}

function sucessclose()
{
	

	
}
</script>

</form:form>
</html>