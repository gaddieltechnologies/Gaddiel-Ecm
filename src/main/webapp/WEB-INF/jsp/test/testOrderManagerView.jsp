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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/footable.core.css?v=2-0-1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/footable-demos.css">
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.18.custom.min.js"></script>
    <!-- Google font -->
    <link href="/css/css.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.1.9.1.min.js" type="text/javascript"></script>
      <script>
        if (!window.jQuery) { document.write('<script src="${pageContext.request.contextPath}/resources/js/jquery-1.9.1.min.js"><\/script>'); }
    </script>
     <script src="${pageContext.request.contextPath}/resources/js/footable.js?v=2-0-1"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>
	<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->	
</head>
<form:form commandName="testOrderManagerView" action="" id="ordermanager">
<body>
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
<!-- Navbar -->

	<!-- /Navbar -->
	
	<!-- Main content -->
	<div id="main-content">
		<!-- Container -->
		<div class="container">
			<!-- Header boxes -->
		
			<!-- /Header boxes -->
			
		<div class="row">
				<!-- Sidebar -->				
				<!-- /Sidebar -->				
				<!-- Content -->
			<div class="span12 desktop">					
				<div class="widget">                    					
					<div class="widget-content"> 
						<div class="span7">
                            <h3>Test Order Manager:View</h3>	
						</div>                       
						<div class="span1">                                                              
							  <div class="span3">                                                                                                           
                                 <div class="box-holder"><a href="#" id="savd" class="savd" hidden="hide"/><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save.png"/>Save</div></a></div> 													                                              
								<div class="box-holder"><a href="#" id="savnewd" class="savnewd" hidden="hide"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save-new.PNG"/>Save & New</div></a></div>
								<div class="box-holder"><a href="#"id="savcold" class="savcold" hidden="hide"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-saveclose.PNG"/>Save & Close</div></a></div>
                                <div class="box-holder"><a href="${pageContext.request.contextPath}/testOrderManager"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-close.png"/>close</div></a></div>
                              </div>
                        </div>                 
                    </div>                                    
                 </div>	              
            </div>
		</div>
	<div class="row">
                 
				
				<!-- Content -->
				<div class="span12">
						<div class="widget">
						  <div class="mobile"><h3>Test Order Manager</h3>	</div> 	
							<div class="widget-header">
								<h3>Order Details</h3>
							</div>
						<div class="widget-content">
							
                            <div class="row">
								<div class="span1"><label>Order Id</label>
									<form:input path="orderId" type="text" value="${testOrderManagerView.orderId}" class="span1"  placeholder="Order Id" id="orderId"/>
								</div>
								<div class="span2"><label>Order Date</label>
									<form:input path="orderDate" type="text" value="${testOrderManagerView.orderDate}" class="span2" id="fa" placeholder="Order Date"/>
								</div>
                                <div class="span2"><label>Doctor</label>
									<form:input path="doctorname" type="text" value="${testOrderManagerView.doctorname}"  class="span2" id="fb" placeholder="Doctor"/>
								</div>
                                <div class="span2"><label>Vendor</label>
									<form:input path="vendorname" type="text" value="${testOrderManagerView.vendorname}" class="span2" id="fc" placeholder="Vendor"/>
								</div>								
                                <div class="span2"><label>Order Ref</label>
									<form:input path="orderReference" type="text" value="${testOrderManagerView.orderReference}" class="span2" id="fd" placeholder="Order Ref"/>
								</div>
                                <div class="span2"><label>Publish?</label>
									<form:input path="publish" type="text" value="${testOrderManagerView.publish}" class="span2" id="fy" placeholder="Y"/>
								</div>
                                <div class="span2"><label>Order Value</label>
									<form:input path="ordervalue" type="text" value="${testOrderManagerView.ordervalue}" class="span2" id="fe" placeholder="Order Value"/>
								</div>
                                <div class="span1"><label>Discount</label>
									<form:input path="discount"  type="text" value="${testOrderManagerView.discount}"  class="span1" id="ff" onblur="calculatenetvalue()" placeholder="Discount"/>
								</div> 
                                <div class="span2"><label>Net Value</label>
									<form:input path="netAmount" type="text" value="${testOrderManagerView.netAmount}" class="span2" id="fg" placeholder="Net Value"/>
								</div> 
                                <div class="span2"><label>Advance</label>
									<form:input path="adavance" type="text" value="${testOrderManagerView.adavance}" class="span2" id="fh" onblur="calculatebalancetc()" placeholder="Advance"/>
								</div>
                                <div class="span2"><label>Balance</label>
									<form:input path="balance" type="text" value="${testOrderManagerView.balance}" class="span2" id="fi" placeholder="Balance"/>
								</div> 
								
								<a class="btn btn-info btn-user-info" id="idsaveorder" onClick="updateChange()">Save Changes</a>
                            </div>                                                        
						</div>
					</div>
                    <div class="widget">	
                                 <div class="widget-header">
							    <h3>Test Groups</h3>
						       </div>    					
						<div class="widget-content">							
                            <div class="row">
								<div class="span4"><label>Group</label>
                                <form:input path="group" type="text" value="${testOrderManagerView.group}" itemLabel="group" itemValue="testGroup" class="span4" id="fk" /></div>
								<div class="span4"><label>Sub Group</label>
                                 <form:input path="subGroup" type="text" value="${testOrderManagerView.subGroup}" class="span4" id="fl"/></div>
                                 <div class="span3"><label>Test</label>
                                 <form:input path="test" type="text" value="${testOrderManagerView.test}" class="span3" id="fm" /></div>                                 
                            </div>                                                     
						</div>
					</div>
					<div class="widget">
						<div class="widget-header">
							<h3>Test Details</h3>
						</div>
						<div class="widget-content">
							
                            <div class="row">
								<div class="span3"><label>Test#</label>
									<form:input path="order" type="text" value="${testOrderManagerView.order}" class="span3" id="fn" />
								</div>
								<div class="span3"><label>Test Result</label>
									<form:input path="testResult" type="text" value="${testOrderManagerView.testResult}" class="span3" id="fo"/>
								</div>
                                <div class="span3"><label>Analyst Remarks</label>
									<form:input path="analystRemarks" type="text" value="${testOrderManagerView.analystRemarks}" class="span3" id="fp"/>
								</div> 
                                 <div class="span2"><label>Rate</label>
									<form:input path="rate" type="text" value="${testOrderManagerView.rate}" class="span2" id="fq"/>
								</div>	                   
                            </div>
                             <div class="row">
								<div class="span3"><label>Specimen Details</label>
									<form:input path="specimenDetails" type="text" value="${testOrderManagerView.specimenDetails}" class="span3" id="fr" />
								</div>
								<div class="span3"><label>Test Job#</label>
       								<form:input path="testjob" type="text" value="${testOrderManagerView.testjob}" class="span3" id="fs" />
								</div>
								<div class="span3"><label>Tested By</label>
									<form:input path="testedBy" type="text" value="${testOrderManagerView.testedBy}" class="span3" id="ft" />
								</div> 
                                <div class="span2"><label>Test Approved By</label>
									<form:input path="testApprovedBy" type="text" value="${testOrderManagerView.testApprovedBy}" class="span2" id="fu" />
								</div>	                        
                            </div>
                            <div class="row">
								
								<div class="span3"><label>Test Start Time</label>
									<form:input path="testStartTime" type="text" value="${testOrderManagerView.testStartTime}" class="span3" id="fw" />
								</div>
                                <div class="span3"><label>Test Reference</label>
									<form:input path="testReference" type="text" value="${testOrderManagerView.testReference}" class="span3" id="fx" />
								</div> 
                                                     
                            </div>
                            
						</div>
					</div>
					<!-- /Content -->
					<div class="row">
				    <div class="span12">
						<div class="widget">	
							<div class="widget-content">
								<div class="tab-content">
									<div class="tab-pane active" id="demo">
										<table class="table demo table-bordered" data-filter="#filter" data-page-size="5" 
										data-page-previous-text="prev" data-page-next-text="next">
										<!--<table class="table table-striped table-bordered">-->                            
											<thead>
												<tr class="widget-header">
													<th data-toggle="true">Group</th>
													<th>Sub Group</th>
													<th data-hide="phone,tablet">Test</th>
													<th data-hide="phone,tablet">Test Result</th>
													<th data-hide="phone,tablet">Analyst Remarks</th>
													<th data-hide="phone,tablet">Rate</th>
													<th data-hide="phone,tablet">Specimen Details</th>
													<th data-hide="phone">Test Job#</th>
													<th data-hide="phone">Tested By</th>
													<th data-hide="phone">Test Approved By</th>
												</tr>
											</thead>						
											<tbody id="gridvaluediv" class="mytable1">
												<c:forEach  items="${testOrderManagerView.testOrderManagerrDetailSubForm}" var="testGrid" varStatus="gridRow" >
													<tr onClick="getorderTestId('${testGrid.order}');"  Style="cursor:pointer;">                                    
														<td>${testGrid.group}</td>
														<td>${testGrid.subGroup}</td>
														<td>${testGrid.test}</td>
														<td>${testGrid.testResult}</td>
														<td>${testGrid.analystRemarks}</td>
														<td>${testGrid.rate}</td>
														<td>${testGrid.specimenDetails}</td>
														<td>${testGrid.testJob}</td>
														<td>${testGrid.testedBy}</td> 	
														<td>${testGrid.testApprovedBy}</td> 	
													</tr>
												</c:forEach>		
											</tbody>
										</table>
									</div>			
								</div>
							</div>
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
	 <div class="dock-wrapper">    
        <div class="navbar navbar-fixed-bottom">
            <div class="navbar-inner">
                <div class="container">                  
                     <center>
                        <div class="btn-group btn-group-justified">
                      
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
	    <!-- dispatchTestId-->
		
		<form:hidden path="dispatch"/>	
	    <form:hidden path="dispatchGridView" />
		<form:hidden path="dispatchTestId"/> 
		<form:hidden path="dispatchPatientId"/>
		<form:hidden path="testGroup"/>
		<form:hidden path="testSubGroup"/>	
		<form:hidden path="testId"/>
		<form:hidden path="doctor"/>
		<form:hidden path="testVendor"/>
		<form:hidden path="flag" id="idflag"/>
</body>
<script type="text/javascript">
var flag=document.getElmentById("idflag").value;
if(flag=="disable"){
	$("#idsaveorder").hide();
	$("#ff").attr("disabled", true);
	$("#fh").attr("disabled", true);
	$("#fo").attr("disabled", true);
	$("#fp").attr("disabled", true);
	$("#ft").attr("disabled", true);
	$("#fu").attr("disabled", true);
	$("#fw").attr("disabled", true);
	
}
var js=jQuery.noConflict();
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

$("#idsaveorder").hide();

var form = document.getElementById("ordermanager");	
 if(form.dispatchGridView.value=="views")
 {
 
	$("#orderId").attr("disabled", true);
	$("#fa").attr("disabled", true);
	$("#fb").attr("disabled", true);
	$("#fc").attr("disabled", true);
	$("#fd").attr("disabled", true);
	$("#fe").attr("disabled", true);
	$("#ff").attr("disabled", true);
	
	$("#fg").attr("disabled", true);
	$("#fh").attr("disabled", true);
	$("#fi").attr("disabled", true);
	$("#fj").attr("disabled", true);
	$("#fk").attr("disabled", true);
	$("#fl").attr("disabled", true);
	
	$("#fm").attr("disabled", true);
	$("#fn").attr("disabled", true);
	$("#fo").attr("disabled", true);
	$("#fp").attr("disabled", true);
	$("#fq").attr("disabled", true);
	$("#fr").attr("disabled", true);
	
	$("#fs").attr("disabled", true);
	$("#ft").attr("disabled", true);
	$("#fu").attr("disabled", true);
	$("#fv").attr("disabled", true);
	$("#fw").attr("disabled", true);
	$("#fx").attr("disabled", true);
	$("#fy").attr("disabled", true);
 }
 if(form.dispatchGridView.value=="edit")
 {
	 
 	$("#idsaveorder").show();
	$("#orderId").attr("readonly",true);
	$("#fa").attr("readonly",true);
	$("#fb").attr("readonly",true);
	$("#fc").attr("readonly",true);
	$("#fd").attr("readonly",true);
	$("#fe").attr("readonly",true);
		
	$("#fg").attr("readonly",true);
	
	$("#fi").attr("readonly",true);
	$("#fj").attr("readonly",true);
	
	$("#fk").attr("readonly",true);
	$("#fl").attr("readonly",true);	
	$("#fm").attr("readonly",true);
	
	$("#fn").attr("readonly",true);
	
	$("#fq").attr("readonly",true);
	$("#fr").attr("readonly",true);	
	$("#fs").attr("readonly",true);
	$("#fy").attr("readonly",true);
	$("#fw").attr("readonly",true);
	$("#fv").attr("readonly",true);
	
 }
function getorderTestId(val){     


	var viewid=val;
//alert("fdhdfhdhdcbhdhdhjdhdfghdgdghdh  "+viewid);
	
	var orderId=document.getElementById("orderId").value;
//alert(orderId);
	form.dispatchGridView.value="view";
	form.dispatch.value=orderId;
	form.dispatchTestId.value=val;
	
      form.submit();
		
}
if((form.dispatchGridView.value=="view")&&(form.flag.value!="disable")){
$("#idsaveorder").show();
$("#orderId").attr("readonly",true);
$("#fa").attr("readonly",true);
$("#fb").attr("readonly",true);
$("#fc").attr("readonly",true);
$("#fd").attr("readonly",true);
$("#fe").attr("readonly",true);
$("#fg").attr("readonly",true);
$("#fi").attr("readonly",true);
$("#fk").attr("readonly",true);
$("#fl").attr("readonly",true);
$("#fm").attr("readonly",true);
$("#fn").attr("readonly",true);
$("#fq").attr("readonly",true);
$("#fr").attr("readonly",true);
$("#fs").attr("readonly",true);
$("#fv").attr("readonly",true);
$("#fw").attr("readonly",true);
$("#fy").attr("readonly",true);
}

if((form.dispatchGridView.value=="view")&&(form.flag.value=="disable")){
	$("#idsaveorder").hide();
	$("#ff").attr("disabled", true);
	$("#fh").attr("disabled", true);
	$("#fo").attr("disabled", true);
	$("#fp").attr("disabled", true);
	$("#ft").attr("disabled", true);
	$("#fu").attr("disabled", true);
	$("#fw").attr("disabled", true);
	$("#orderId").attr("readonly",true);
	$("#fa").attr("readonly",true);
	$("#fb").attr("readonly",true);
	$("#fc").attr("readonly",true);
	$("#fd").attr("readonly",true);
	$("#fe").attr("readonly",true);
	$("#fg").attr("readonly",true);
	$("#fi").attr("readonly",true);
	$("#fk").attr("readonly",true);
	$("#fl").attr("readonly",true);
	$("#fm").attr("readonly",true);
	$("#fn").attr("readonly",true);
	$("#fq").attr("readonly",true);
	$("#fr").attr("readonly",true);
	$("#fs").attr("readonly",true);
	$("#fv").attr("readonly",true);
	$("#fx").attr("readonly",true);
	$("#fy").attr("readonly",true);
	}
	
	
function updateChange()
{

	form.dispatch.value=orderId;
	form.dispatchGridView.value="update";
	
	
	//alert(document.getElementById("orderId").value);
	form.submit();
}

if(form.dispatchGridView.value=="update")
	{
	$("#sucessdiv").show();
	}
function calculatenetvalue(){
	
	document.getElementById("fg").value=(document.getElementById("fe").value)-(document.getElementById("ff").value);
}

function calculatebalancetc(){
	
	document.getElementById("fi").value=(document.getElementById("fg").value)-(document.getElementById("fh").value);
	//document.getElementById("idtotalcollected").value=(document.getElementById("idnetvalue").value)-(document.getElementById("idbalance").value);
}

</script>

</form:form>
</html>