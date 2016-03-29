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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/footable.core.css?v=2-0-1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/footable-demos.css">
    <!-- Google font -->
    <link href="/css/css.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery.1.9.1.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>
	<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->	
</head>
<form:form commandName="testOrderManager" id="ordermanagerId">
<body>
	<!-- Navbar -->
<style>
.oddtr
{
background-color:#FFFFFF;
}
.eventr
{
	background-color:#F5F5F5;
}
.trover
{
background-color: #0099CC;
}
.trclick
{
	background-color: #7EC2EB;
}
	
</style>
	<!-- /Navbar -->
	
	<!-- Main content -->
	<div id="main-content">
		<!-- Container -->
		<div class="container">
		<!-- Header boxes -->
				<div class="box-container">
					
				</div>
				<!-- /Header boxes -->
			<!-- Header boxes -->
			<div class="alert alert-success alert-block" id="sucessdiv" >
						<button type="button" class="close" onClick="sucessclose()" data-dismiss="alert">&times;</button>
						<h4 id="successmessage">${testOrderManager.successMessage}</h4>
				
					</div>
			<!-- /Header boxes -->
			
			<div class="row">
				<!-- Sidebar -->
				
				<!-- /Sidebar -->
				
				<!-- Content -->
				<!-- Menu1 -->
				<div id="menu1" class="menu1 span12">	
					<div class="desktop widget">                    					
						<div class="widget-content"> 
                        <div class="span8"><h3>Test Orders Manager:Search For Orders</h3></div>                       
						        <div class="span3">                                                                
	                               <div class="box-holder">
	                                   <a href="#" onclick="newpatient()"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-add.png"/>New</div></a>
	                               </div>  
	                               <div class="box-holder">
								        <a id="view-d" class="view-d">
                                        <div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-view.png"/>View</div></a>
										<a style="cursor:pointer;" id="viewid" class="viewid">
									    <div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-view.png"/>View</div></a>
	                               </div>  
	                               <div class="box-holder">
	                                  <a  style="cursor:pointer;" id="edite" class="edite">
	                                  <div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-edit.png"/>Edit</div></a>
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
				<!-- /Menu1 -->
					
				  <!-- Menu2 -->
				<div id="menu2" class="menu2 span12">
				
					<div class="desktop widget">                    					
						<div class="widget-content"> 
                        <div class="span8"><h3>Test Order Manager : Search For Patient</h3></div>                       
							<div class="span3">                                                                   
							   <div class="box-holder">
	                            <a href="#" id="addTestView" class="addTestView">
								<div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-add.png"/><br>Add Test</div></a>
	                            </div>
							    <div class="box-holder">
	                                  <a href="${pageContext.request.contextPath}/testOrderManager">
	                                  <div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-close.png"/><br>Close</div></a>
	                            </div> 
                           </div>
            			</div>
				    </div>								
				</div>
				<!-- /Menu2 -->
				<!-- /Content -->
				
                <div id="orderhide1" class="span12 orderhide1">
				    
					<div class="widget">					
						<div class="widget-content">
						  	<div class="mobile"><div class="orderhide1"><h3>Test Orders Manager:Search For Orders</h3></div></div> 
                            <div class="span3"><form:input path="searchTestDate" id="searchTestdate" class="span3" placeholder="Search by Test Date" /></div>               
                            <div class="span3"><form:input path="searchTestOrderNo" id="searchTestorderNo"  class="span3" placeholder="Search by Order Number"/></div>                          
                            <div class="span3"><form:input path="searchTestOrderPatientname" id="searchTestorderPatientname" class="span3" placeholder="Search by Patient Name"/></div>                             
                            <div class="span2"><form:input path="searchTestOrderMobile" id="searchTestorderMobile" class="span2" placeholder="Search by Mobile Phone"/></div> 
							<div class="span3"><form:input path="searchTestOrderPEmailid" id="searchTestorderPEmailid" class="span3" placeholder="Search by Patient Email-Id"/></div> 
							<div class="span3">
							<form:select path="searchTestDoctorName" id="searchTestdoctorName"  class="span3" placeholder="Search by Doctor Name">
							<option value="0">Select Doctor's</option>
							<form:options items="${listdoctorname}" />							
							</form:select>
							</div> 
							<div class="span3">
							<form:select path="searchTestvendorName" id="searchTestvVndorName" class="span3" placeholder="Search by Vendor Name">
							<option value="0">Select Vendor's</option>
							<form:options items="${listvendorname}" />	
							</form:select>
							</div> 
                            <div class="span2"><a href="#" class="btn btn-info "onClick="searchvalue()">Search</a> <a href="#" class="btn btn-info "onClick="clearvalue()">Clear</a></div>               
                               
				</div>
              </div>  
              </div>  
                <!------>
                <!-- /Content -->
                <div id="orderhide2" class="span12">
										
						<div class="widget-content">
						<div class="tab-content">
							<div class="tab-pane active" id="demo">
							<table class="table demo table-bordered " data-filter="#filter" data-page-size="5"
							       data-page-previous-text="prev" data-page-next-text="next">
							<!--<table class="table table-striped table-bordered">-->                            
								<thead>
									<tr class="widget-header">
										<th data-toggle="true">Date</th>
										<th>Order#</th>
										<th data-hide="phone,tablet">Order Reference</th>
										<th data-hide="phone,tablet">Patient Name</th>
										<th data-hide="phone,tablet">Doctor Name</th>
                                        <th data-hide="phone,tablet">Vendor Name</th>                                        
                                        <th data-hide="phone">Amount</th>
                                       	<th data-hide="phone">Balance Due</th> 										
                             		</tr>
								</thead>
								
								<tbody id="gridvaluediv" class="mytable1 gridvaluediv1">
								<c:forEach items="${testOrderManager.testOrderManagerrDetailSubForm}" var="testorderDetail" varStatus="gridRow">
									<tr onClick="testorderId('${testorderDetail.orderId}','${testorderDetail.patientid}');" Style="cursor:pointer;">    
									     
										<td>${testorderDetail.ordersubDate}</td>									  
										<td>${testorderDetail.orderId}</td>
										<td>${testorderDetail.orderReference}</td>
										<td>${testorderDetail.patient}</td>
										<td>${testorderDetail.doctor}</td>
										<td>${testorderDetail.testVendor}</td>
										<td>${testorderDetail.netAmount}</td>
										<td>${testorderDetail.balance}</td>												
                                                                   								
									</tr>
							    </c:forEach>
								</tbody>
							</table>
						</div>
					</div>					
				</div>
		    	
		        </div>
				  <!------>
			
				<div id="patient1" class="span12 patient1">
					<div class="widget">					
						<div class="widget-content">
							<div class="mobile"><div class="patient1"><h3>Test Order Manager : Search For Patient</h3></div></div>  
                            <div class="span3"><form:input path="searchPatientName" id="search1" class="span3" placeholder="Search by Patient Name" /></div>               
                            <div class="span3"><form:input path="searchMobile"   id="search2" class="span3" placeholder="Search by Mobile Phone"/></div>                          
                            <div class="span3"><form:input path="searchEmailid"  id="search3" class="span3" placeholder="Search by Patient Email-Id"/></div>                             
                            <div class="span2"><form:input path="searchPostalcode"  id="search4" class="span2" placeholder="Search by Postal Code"/></div> 
							<div class="span3"><form:input path="searchDoctorname" id="search5" class="span3" placeholder="Search by Doctor Name"/></div> 							
							<div class="span2"><a href="#" class="btn btn-info "onClick="searchvalue1()">Search</a> 
							<a href="#" class="btn btn-info "onClick="clearvalue1()">Clear</a>
							</div>               
                               
				</div>
              </div>  
              </div>  
                <!------>
                <!-- /Content -->
                <div id="patient2" class="span12">
										
						<div class="widget-content">
							<div class="tab-content">
							<div class="tab-pane active" id="demo">
							<table class="table demo table-bordered" data-filter="#filter" data-page-size="5"
							       data-page-previous-text="prev" data-page-next-text="next">
							<!--<table class="table table-striped table-bordered">-->                            
								<thead>
									<tr class="widget-header">
										<th data-toggle="true">Patient Id</th>
										<th>Name</th>
										<th data-hide="phone,tablet">Sex</th>
										<th data-hide="phone,tablet">Age</th>
										<th data-hide="phone,tablet">Preferred Contact</th>
                                        <th data-hide="phone,tablet">Mobile Phone</th>                                        
                                        <th data-hide="phone">Email</th>
                                       	<th data-hide="phone">Postal Code</th> 
										<th data-hide="phone">Doctor</th> 
										<th data-hide="phone">Vendor</th> 
                             		</tr>
								</thead>
								
								<tbody id="gridvaluediv2" class="mytable1 gridvaluediv2">
								<c:forEach items="${testOrderManager.testOrderManagerrDetailSubForm}" var="testorderDetailPatientw" varStatus="gridRow">
								<tr onClick="testorderpatientId('${testorderDetailPatientw.patientid}','${testorderDetailPatientw.patientname}');" Style="cursor:pointer;"> 
								        <td>${testorderDetailPatientw.patientid}</td>
										<td>${testorderDetailPatientw.patientname}</td>
										<td>${testorderDetailPatientw.patientsex}</td>
										<td>${testorderDetailPatientw.patientage}</td>
										<td>${testorderDetailPatientw.prefferdcontact}</td>
										<td>${testorderDetailPatientw.mobphoneno}</td>
										<td>${testorderDetailPatientw.email}</td>
										<td>${testorderDetailPatientw.code}</td>
										<td>${testorderDetailPatientw.doctorna}</td>
										<td>${testorderDetailPatientw.vendorna}</td>
                                    </tr>
							    </c:forEach>
								</tbody>
							</table>
						    </div>
					    </div>					
				     </div>
		    	
		     </div>									
	    
     
	  </div>
			<!-- Footer -->
				<div id="footer">
					<hr>
					<p class="pull-right">Gaddiel Technologies Pvt Ltd &copy; 2013</p>
				</div>
			<!-- /Footer -->
		
		<!-- /Container -->
				<div class="menu1">    
					<div class="mobile navbar navbar-fixed-bottom">
						<div class="navbar-inner">
							<div class="container">                  
								  <center>
									 <div class="btn-group btn-group-justified">                         
										<a class="btn btn-default" onclick="newpatient()">
												<img src="${pageContext.request.contextPath}/resources/images/e-add.png"/><br>New</a>
												
										<a style="cursor:pointer;" id="viewid" class="viewid btn btn-default">							
												<img src="${pageContext.request.contextPath}/resources/images/e-view.png"/><br>View</a>
										<a id="view-d" class="view-d btn btn-default">
												<img src="${pageContext.request.contextPath}/resources/images/d-view.png"/><br>View</a>								  
										
										<a id="edite"style="cursor:pointer;" href="#" class="edite btn btn-default">
												<img src="${pageContext.request.contextPath}/resources/images/e-edit.png"/><br>Edit</a>
										<a id="edit-d" class="edit-d btn btn-default">
												<img src="${pageContext.request.contextPath}/resources/images/d-edit.png"/><br>Edit</a>
												
										<a class="btn btn-default">
												<img src="${pageContext.request.contextPath}/resources/images/d-trash.png"/><br>Delete</a>
												
										<a href="${pageContext.request.contextPath}/controlPanel" class="btn btn-default">
												<img src="${pageContext.request.contextPath}/resources/images/e-close.png"/><br>Close</a>
										
									  </div>
								  </center>                    		
							</div>
						</div>
					</div>
				 </div>	
				<div class="menu2">    
					<div class="mobile navbar navbar-fixed-bottom">
						<div class="navbar-inner">
							<div class="container">                  
								  <center>
									 <div class="btn-group btn-group-justified">                         
										<a class="addTestView btn btn-default">
												<img src="${pageContext.request.contextPath}/resources/images/e-add.png"/><br>Add Test</a>
												<a href="${pageContext.request.contextPath}/testOrderManager" class="btn btn-default">
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
<form:hidden path="dispatch" /> 
<form:hidden path="dispatchGridView" />   
<form:hidden path="dispatchPatientId"/>    
<form:hidden path="dispatchPatientName"/>
<form:hidden path="flag" id="idflag"/>
</body>
<!-- Javascript files -->
<script src="${pageContext.request.contextPath}/resources/js/footable.js?v=2-0-1"></script>
<script type="text/javascript">
$(function(){
		//these two line adds the color to each different row  
    $(".mytable1 tr:even").addClass("eventr");
    $(".mytable1 tr:odd").addClass("oddtr");
 	//handle the mouseover , mouseout and click event
  $(".mytable1 tr")  
  .mouseover(function() {$(this).addClass("trover");})
  .mouseout(function() {$(this).removeClass("trover");})
  .click(function(){$(this).toggleClass("trclick");})
  .click(function(){$(this).siblings().removeClass('trclick');}); 
 }); 
</script>
<script type="text/javascript">
        $(function () {
            $('table').bind('footable_breakpoint', function() {
                $('table').trigger('footable_expand_first_row');
            }).footable();
        });	
</script>
<script>
$("#sucessdiv").hide();
var form = document.getElementById("ordermanagerId");
$(".orderhide1").show();
$("#orderhide2").show();
$(".patient1").hide();
$("#patient2").hide();
$(".menu1").show();
$(".menu2").hide();

$(".gridvaluediv1").hide();
$(".edit-d").show();
$(".edite").hide();
$(".viewid").hide();
$(".view-d").show();
$(".deletee").hide();
$(".delete-d").show();

function newpatient()
{ 
            form.dispatchGridView.value="newpatient";			
	        form.submit();	
}
//alert(form.dispatch.value);
if(form.dispatchGridView.value=="newpatient")
{
$(".orderhide1").hide();
$("#orderhide2").hide();
$(".patient1").show();
$("#patient2").show();
$(".menu2").show();
$(".menu1").hide();
}
function searchvalue()
{     
	//alert("");	
	form.dispatchGridView.value="search";
	form.submit();
}
if(form.dispatchGridView.value=="search")
	{
	$(".gridvaluediv1").show();
    $(".menu2").hide();	
    $(".patient1").hide();
    $("#patient2").hide();
	$(".gridvaluediv2").hide();	
	$(".edit-d").hide();
    $(".edite").show();
	$(".viewid").show();
    $(".view-d").hide();
 }
function clearvalue()
    {	
	document.getElementById("searchTestdate").value="";
	document.getElementById("searchTestorderNo").value="";
	document.getElementById("searchTestorderPatientname").value="";
	document.getElementById("searchTestorderMobile").value="";
    document.getElementById("searchTestorderPEmailid").value="";
	document.getElementById("searchTestdoctorName").value="0";
	document.getElementById("searchTestvVndorName").value="0";
	
	$("#gridvaluediv").hide();
	$(".view-d").show();
	$(".viewid").hide();
	$(".edit-d").show();
    $(".edite").hide();
	}
function searchvalue1()
  {
	//alert("");	
	form.dispatchGridView.value="patientsearch";
	form.submit();
}
if(form.dispatchGridView.value=="patientsearch")
	{
	$(".gridvaluediv2").show();
    $(".menu2").show();	
    $(".patient1").show();
    $("#patient2").show();
	$(".gridvaluediv1").hide();
	$(".menu1").hide();
	$(".orderhide1").hide();
    $("#orderhide2").hide();	
   	}
   	
if(form.dispatchGridView.value=="update")
{
$("#sucessdiv").show();
}

function clearvalue1()
    {	
	document.getElementById("search1").value="";
	document.getElementById("search2").value="";
	document.getElementById("search3").value="";
	document.getElementById("search4").value="";
    document.getElementById("search5").value="";
		
	$("#gridvaluediv2").hide();
	
	}	
	
function testorderpatientId(idvalue,namevalue)
{

	var viewid=idvalue;
	var viewname=namevalue;
	
	 $(".addTestView").click(function () 
		{
			form.dispatchGridView.value="addtest";
			form.dispatchPatientId.value=idvalue;
			form.dispatchPatientName.value=namevalue;
		form.submit();
 		});
}

function testorderId(val,valone)

{     
	
			var viewid=val;
			var patid=valone;

			$(".viewid").click(function () 
			{
			form.dispatchGridView.value="views";
			form.dispatch.value=val;
			form.dispatchPatientId.value=valone;
			form.flag.value="disable";

			form.submit();
			});
			
			$(".edite").click(function () 
			{
			form.dispatchGridView.value="edit";
			form.dispatch.value=val;
			form.dispatchPatientId.value=valone;
			form.flag.value="able";

			form.submit();
			});				
}

</script>
</form:form>
</html>