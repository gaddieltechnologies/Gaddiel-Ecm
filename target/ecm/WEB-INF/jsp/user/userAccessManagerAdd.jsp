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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrapdate.css">
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.18.custom.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.js"></script>    
    <script src="${pageContext.request.contextPath}/resources/js/zebra_datepicker.js"></script>
   
    <!-- Google font -->
    <link href="/css/css.css" rel="stylesheet" type="text/css">

	<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->	
</head>
<form:form commandName="UserAccessManagerAdd" id="useraddid">
<body>
<!-- Navbar -->

	<!-- /Navbar -->
	
	<!-- Main content -->
	<div id="main-content">
		<!-- Container -->
		<div class="container">
			<!-- Header boxes -->
			<div class="box-container">
					<div class="alert alert-success alert-block" id="sucessdiv" >
						<button type="button" class="close" onClick="sucessclose()" data-dismiss="alert">&times;</button>
						<h4 id="successmessage">${UserAccessManagerAdd.successMessage}</h4>
					</div>
                    <div class="alert alert-error alert-block" id="errordiv">
						<button type="button" class="close" onClick="errorclose()"  data-dismiss="alert">&times;</button>
						<h4 id="errormessage">${UserAccessManagerAdd.errorMessage}</h4>
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
                                            <h3>User Access Manager : New User </h3>	
                                           </div>                       
                                                
												<div class="span3">                                                                
                                                    <div class="box-holder">
													<a href="#" id="saveenable" class="saveenable" onclick="newSave()">
													<div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-save.png"/>Save</div></a>
										
													<a  id="savedisable" class="savedisable"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save.png"/>Save</div></a>
													</div> 													
                                                    <div class="box-holder">
													<a href="#" id="savenewenable" class="savenewenable" onclick="savenew()" ><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-save-new.PNG"/>Save-New</div></a>
													
													<a id="savenewdisable" class="savenewdisable" ><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save-new.PNG"/>Save-New</div></a>
													</div>
                                                    <div class="box-holder">
													<a href="#"id="savecloseenable" class="savecloseenable" onClick="saveclose()" ><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-saveclose.PNG"/>Save-Close</div></a>
													
													<a id="saveclosedisable" class="saveclosedisable" ><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-saveclose.PNG"/>Save-Close</div></a>
													</div>
                                                    <div class="box-holder">
													<a href="${pageContext.request.contextPath}/userAccessManager"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-close.png"/>Close</div></a>
													</div>
                                                </div> 
                                        </div>                                    
                                    </div>	              
                                </div>
                            </div>
				<div class="row">
                                <!-- Sidebar -->
				<div class="span3">
				<div class="widget-content">	
                        <div class="mobile"><h3>User Access Manager : New User</h3></div> 				
						<div class="span2"><img src="${pageContext.request.contextPath}/download"/></div>
				</div>
					<ul id="sidebar" class="nav nav-tabs nav-stacked">
						<li><a href="#" id="addtest">Clinical Tests Manager</a></li>
					</ul>
				</div>
				<!-- /Sidebar -->
				
				<!-- Content -->
				<div class="span9">
					
								
					<div class="widget">
						
						<div class="widget-content">
						<div class="row">
								<div class="span4">
								<label>Name<font color="#FF0000"> *</font></label><form:input path="userName" id="usernameid" placeholder="Name" class="span4" onblur="unamevalidate();unval()" onkeyup="usnamevalidate()"/><span style="color:red" id="usernameerror"></span></div>								
								<div class="span4">
								<label>Role<font color="#FF0000"> *</font></label>
								      <form:select path="role" id="roleid" class="span4" onblur="urolevalidate();" onkeyup="usrolevalidate()">	
								           <option>-Select-</option>
								           <form:options items="${rolelistvalue}" />
								           
								           
								      </form:select>
								<span style="color:red" id="roleerror"></span>
								</div>
								</div>
								<div class="row">
								<div class="span4">
								<label>User Type<font color="#FF0000"> *</font></label>
								<form:input path="userType" id="usertypeid" value="LAB" class="span4" onblur="utypevalidate();" onkeyup="ustypevalidate()"/>
								
								
								<span style="color:red" id="typeerror"></span>
								</div>
								<div class="span4"><label>Default Password Changed?<font color="#FF0000"> *</font></label><form:select path="defaultPasswordChanged" id="defpasschangeid" class="span4" onblur="upassvalidate();" onkeyup="uspassvalidate()">
								<option>-Select-</option>
								<form:options items="${defpasschangelistvalue}" />
								
								</form:select>
								<span style="color:red" id="passchangeerror"></span>
								</div>                             
								</div>
								<div class="row">
								
								<div class="span4"><label>Is User Active?<font color="#FF0000"> *</font></label><form:select path="userActive" id="useractiveid" class="span4" onblur="uactvalidate();" onkeyup="usactvalidate()">
								<option>-Select-</option>
								<form:options items="${actflaglistvalue}" />
								
								</form:select>
								<span style="color:red" id="useractiveerror"></span>
								</div>
								<div class="span4"><label>Is User Deleted?<font color="#FF0000"> *</font></label><form:select path="userDelete" id="userdeleteid" class="span4" onblur="udelvalidate();" onkeyup="usdelvalidate()">
								<option>-Select-</option>
								<form:options items="${delflaglistvalue}" />
								
								</form:select>
								<span style="color:red" id="userdeleteerror"></span>
								</div>
								</div>
								
								<div class="row">
								
								
								<div class="span4"><label>Remarks</label><form:input path="remarks" id="remarksid" placeholder="" class="span4"/></div>
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
                            <a href="#" id="saveenable" class="saveenable btn btn-default" onclick="newSave()" >
						    <img src="${pageContext.request.contextPath}/resources/images/e-save.png"/><br>Save</a>
							<a id="savedisable" class="savedisable btn btn-default" />
							<img src="${pageContext.request.contextPath}/resources/images/d-save.png"/><br>Save</a>
						
                            <a href="#" id="savenewenable" class="savenewenable btn btn-default" onclick="savenew()">
						    <img src="${pageContext.request.contextPath}/resources/images/e-save-new.PNG"/><br>Save-New</a>
						    <a id="savenewdisable" class="savenewdisable btn btn-default" >
							<img src="${pageContext.request.contextPath}/resources/images/d-save-new.PNG"/><br>Save-New</a>
								  
					   
                            <a href="#"id="savecloseenable" class="savecloseenable btn btn-default" onClick="saveclose()" >
						    <img src="${pageContext.request.contextPath}/resources/images/e-saveclose.PNG"/><br>Save-Close</a>
							<a id="saveclosedisable" class="saveclosedisable btn btn-default" >
							<img src="${pageContext.request.contextPath}/resources/images/d-saveclose.PNG"/><br>Save-Close</a>
						
                            <a href="${pageContext.request.contextPath}/userAccessManager" class="btn btn-default">
                            <img src="${pageContext.request.contextPath}/resources/images/e-close.png"/><br>Close</a></li>
                        </div>
                    </center>                      		
				</div>
           	</div>
		</div>
     </div>       </div>
        </div>
        
        <form:hidden path="dispatchGridView"/>
</body>
<script>

var form = document.getElementById("useraddid");
var js=jQuery.noConflict();
js("#sucessdiv").hide();
js("#errordiv").hide(); 
js("#user").hide();
js("#addtest").hide();

js(".saveenable").show();
js(".savedisable").hide();

js(".savenewenable").show();
js(".savenewdisable").hide();

js(".savecloseenable").show();
js(".saveclosedisable").hide();
js("#usertypeid").attr("readonly", true);
function sucessclose()
{
	
	js("#sucessdiv").hide();
	
}
function errorclose()
{
	
	js("#errordiv").hide(); 
}

function unamevalidate()
{
var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
var mail=document.getElementById("usernameid");
             if (!mail.value.match(reg) && mail.value !="")
             {
            	 document.getElementById("usernameerror").innerHTML="please enter valid email id";
            		document.getElementById("usernameid").style.borderColor="#FF0000";    

                 return false;
             }
}

function usnamevalidate()
{
	var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	var mail=document.getElementById("usernameid");
	             if (mail.value.match(reg))
	             {
	            	 document.getElementById("usernameerror").innerHTML="";
	            		document.getElementById("usernameid").style.borderColor="#64FE2E";    

	                 
	             }
	}
	
	function unval(){
		
		var mail=document.getElementById("usernameid").value;
        if (!mail.match(/\S/) && mail.value !="")
        {
       	 document.getElementById("usernameerror").innerHTML="please enter email id";
       		document.getElementById("usernameid").style.borderColor="#FF0000";    

            return false;
        }
		
	}
	
	function urolevalidate(){
		
		
		var s11= document.getElementById("roleid").value; 
		if(s11=="-Select-") {
			document.getElementById("roleerror").innerHTML="Please specify the role of the user";
			document.getElementById("roleid").style.borderColor="#FF0000";
		    }
		if(s11!="-Select-"){document.getElementById("roleerror").innerHTML="";
		document.getElementById("roleid").style.borderColor="#64FE2E";}
		
	}
	
function usrolevalidate(){
		
		var s11= document.getElementById("roleid").value; 
		if(s11!="-Select-") {
			document.getElementById("roleerror").innerHTML="";
			document.getElementById("roleid").style.borderColor="#64FE2E";
		    }

	}
	
	
	
	function upassvalidate(){
		var s11= document.getElementById("defpasschangeid").value; 
		if(s11=="-Select-") {
			document.getElementById("passchangeerror").innerHTML="Please choose Y or N";
			document.getElementById("defpasschangeid").style.borderColor="#FF0000";
		    }
		if(s11!="-Select-"){document.getElementById("passchangeerror").innerHTML="";
		document.getElementById("defpasschangeid").style.borderColor="#64FE2E";}
	}
	
	function uspassvalidate(){
		var s11= document.getElementById("defpasschangeid").value; 
		if(s11!="-Select-") {
			document.getElementById("passchangeerror").innerHTML="";
			document.getElementById("defpasschangeid").style.borderColor="#64FE2E";
		    }
		
	}
	
	function uactvalidate(){
		var s11= document.getElementById("useractiveid").value; 
		if(s11=="-Select-") {
			document.getElementById("useractiveerror").innerHTML="Please choose Y or N";
			document.getElementById("useractiveid").style.borderColor="#FF0000";
		    }
		if(s11!="-Select-"){document.getElementById("useractiveerror").innerHTML="";
		document.getElementById("useractiveid").style.borderColor="#64FE2E";}	
	}
	
	function usactvalidate(){
		var s11= document.getElementById("useractiveid").value; 
		if(s11!="-Select-") {
			document.getElementById("useractiveerror").innerHTML="";
			document.getElementById("useractiveid").style.borderColor="#64FE2E";
		    }
		}
	function udelvalidate(){
		var s11= document.getElementById("userdeleteid").value; 
		if(s11=="-Select-") {
			document.getElementById("userdeleteerror").innerHTML="Please choose Y or N";
			document.getElementById("userdeleteid").style.borderColor="#FF0000";
		    }
		if(s11!="-Select-"){document.getElementById("userdeleteerror").innerHTML="";
		document.getElementById("userdeleteid").style.borderColor="#64FE2E";}	
	}
	function usdelvalidate(){
		var s11= document.getElementById("userdeleteid").value; 
		if(s11!="-Select-") {
			document.getElementById("userdeleteerror").innerHTML="";
			document.getElementById("userdeleteid").style.borderColor="#64FE2E";
		    }
		}

function newSave()
{
	var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	var mail=document.getElementById("usernameid").value;
	             if (!mail.match(/\S/) && mail.value !="")
	             {
	            	 document.getElementById("usernameerror").innerHTML="please enter valid email id";
	            		document.getElementById("usernameid").style.borderColor="#FF0000";    

	                 
	             }
	var s11= document.getElementById("roleid").value; 
	if(s11=="-Select-") {
		document.getElementById("roleerror").innerHTML="Please specify the role of the user";
		document.getElementById("roleid").style.borderColor="#FF0000";
	    }
	
	
	var s13= document.getElementById("defpasschangeid").value; 
	if(s13=="-Select-") {
		document.getElementById("passchangeerror").innerHTML="Please choose Y or N";
		document.getElementById("defpasschangeid").style.borderColor="#FF0000";
	    }
	
	var s14= document.getElementById("useractiveid").value; 
	if(s14=="-Select-") {
		document.getElementById("useractiveerror").innerHTML="Please choose Y or N";
		document.getElementById("useractiveid").style.borderColor="#FF0000";
	    }
	var s15= document.getElementById("userdeleteid").value; 
	if(s15=="-Select-") {
		document.getElementById("userdeleteerror").innerHTML="Please choose Y or N";
		document.getElementById("userdeleteid").style.borderColor="#FF0000";
	    }
	if(mail.match(/\S/)&&(s11!="-Select-")&&(s13!="-Select-")&&(s14!="-Select-")&&(s15!="-Select-")){
	
	form.dispatchGridView.value="Save";

//js("#sucessdiv").show();
		form.submit();
				
	}
}

if(form.dispatchGridView.value=="Save"){
	
	js("#usernameid").attr("disabled", true);
	js("#roleid").attr("disabled", true);
	js("#usertypeid").attr("disabled", true);
	js("#defpasschangeid").attr("disabled", true);
	js("#useractiveid").attr("disabled", true);
	js("#userdeleteid").attr("disabled", true);
	js("#remarksid").attr("disabled", true);
	js("#user").show();
	js("#addtest").show();
	
	js(".saveenable").hide();
	js(".savedisable").show();

	js(".savenewenable").hide();
	js(".savenewdisable").show();

	js(".savecloseenable").hide();
	js(".saveclosedisable").show();
	js("#sucessdiv").show();
	if(document.getElementById("errormessage").innerHTML=="Record already exists"){
			document.getElementById("usernameid").style.borderColor="#FF0000"; 
				js("#usernameid").attr("disabled", false);
	js("#roleid").attr("disabled", false);
	js("#usertypeid").attr("disabled", false);
	js("#defpasschangeid").attr("disabled", false);
	js("#useractiveid").attr("disabled", false);
	js("#userdeleteid").attr("disabled", false);
	js("#remarksid").attr("disabled", false);
	js(".saveenable").show();
	js(".savedisable").hide();

	js(".savenewenable").show();
	js(".savenewdisable").hide();

	js(".savecloseenable").show();
	js(".saveclosedisable").hide();
	js("#errordiv").show();
	js("#sucessdiv").hide();
	}
}
function savenew(){
	
	var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	var mail=document.getElementById("usernameid").value;
	             if (!mail.match(/\S/) && mail.value !="")
	             {
	            	 document.getElementById("usernameerror").innerHTML="please enter valid email id";
	            		document.getElementById("usernameid").style.borderColor="#FF0000";    

	                 
	             }
	var s11= document.getElementById("roleid").value; 
	if(s11=="-Select-") {
		document.getElementById("roleerror").innerHTML="Please specify the role of the user";
		document.getElementById("roleid").style.borderColor="#FF0000";
	    }
	
	
	
	var s13= document.getElementById("defpasschangeid").value; 
	if(s13=="-Select-") {
		document.getElementById("passchangeerror").innerHTML="Please choose Y or N";
		document.getElementById("defpasschangeid").style.borderColor="#FF0000";
	    }
	
	var s14= document.getElementById("useractiveid").value; 
	if(s14=="-Select-") {
		document.getElementById("useractiveerror").innerHTML="Please choose Y or N";
		document.getElementById("useractiveid").style.borderColor="#FF0000";
	    }
	var s15= document.getElementById("userdeleteid").value; 
	if(s15=="-Select-") {
		document.getElementById("userdeleteerror").innerHTML="Please choose Y or N";
		document.getElementById("userdeleteid").style.borderColor="#FF0000";
	    }
	if(mail.match(/\S/)&&(s11!="-Select-")&&(s13!="-Select-")&&(s14!="-Select-")&&(s15!="-Select-")){
	form.dispatchGridView.value="Save&New";
	form.submit();	}
}
if(form.dispatchGridView.value=="Save&New"){
	js("#sucessdiv").show();
	if(document.getElementById("errormessage").innerHTML=="Record already exists"){
		document.getElementById("usernameid").style.borderColor="#FF0000"; 
			js("#usernameid").attr("disabled", false);
js("#roleid").attr("disabled", false);
js("#usertypeid").attr("disabled", false);
js("#defpasschangeid").attr("disabled", false);
js("#useractiveid").attr("disabled", false);
js("#userdeleteid").attr("disabled", false);
js("#remarksid").attr("disabled", false);
js(".saveenable").show();
js(".savedisable").hide();

js(".savenewenable").show();
js(".savenewdisable").hide();

js(".savecloseenable").show();
js(".saveclosedisable").hide();
js("#errordiv").show();
js("#sucessdiv").hide();
}
	else{
	document.getElementById("usernameid").value="";
	document.getElementById("roleid").value="-Select-";
	document.getElementById("usertypeid").value="LAB";
	document.getElementById("defpasschangeid").value="-Select-";
	document.getElementById("useractiveid").value="-Select-";
	document.getElementById("userdeleteid").value="-Select-";
	document.getElementById("remarksid").value="";
	js("#usertypeid").attr("readonly", true);
	js("#user").hide();
	js("#addtest").hide();
	
	}
	
}
function saveclose(){
	var reg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	var mail=document.getElementById("usernameid").value;
	             if (!mail.match(/\S/) && mail.value!="")
	             {
	            	 document.getElementById("usernameerror").innerHTML="please enter valid email id";
	            		document.getElementById("usernameid").style.borderColor="#FF0000";    

	                 
	             }
	var sa= document.getElementById("roleid").value; 
	if(sa=="-Select-") {
		document.getElementById("roleerror").innerHTML="Please specify the role of the user";
		document.getElementById("roleid").style.borderColor="#FF0000";
	    }
	
	
	var sb= document.getElementById("defpasschangeid").value; 
	if(sb=="-Select-") {
		document.getElementById("passchangeerror").innerHTML="Please choose Y or N";
		document.getElementById("defpasschangeid").style.borderColor="#FF0000";
	    }
	
	var sc= document.getElementById("useractiveid").value; 
	if(sc=="-Select-") {
		document.getElementById("useractiveerror").innerHTML="Please choose Y or N";
		document.getElementById("useractiveid").style.borderColor="#FF0000";
	    }
	var sd= document.getElementById("userdeleteid").value; 
	if(sd=="-Select-") {
		document.getElementById("userdeleteerror").innerHTML="Please choose Y or N";
		document.getElementById("userdeleteid").style.borderColor="#FF0000";
	    }
	if(mail.match(/\S/)&&(sa!="-Select-")&&(sb!="-Select-")&&(sc!="-Select-")&&(sd!="-Select-")){
	form.dispatchGridView.value="Save&Close";
	form.submit();	}
}

if(form.dispatchGridView.value=="Save&Close"){
	
	if(document.getElementById("errormessage").innerHTML=="Record already exists"){
		document.getElementById("usernameid").style.borderColor="#FF0000"; 
			js("#usernameid").attr("disabled", false);
js("#roleid").attr("disabled", false);
js("#usertypeid").attr("disabled", false);
js("#defpasschangeid").attr("disabled", false);
js("#useractiveid").attr("disabled", false);
js("#userdeleteid").attr("disabled", false);
js("#remarksid").attr("disabled", false);
js(".saveenable").show();
js(".savedisable").hide();

js(".savenewenable").show();
js(".savenewdisable").hide();

js(".savecloseenable").show();
js(".saveclosedisable").hide();
js("#errordiv").show();
js("#sucessdiv").hide();
}
		
}

</script>
</form:form>
</html>