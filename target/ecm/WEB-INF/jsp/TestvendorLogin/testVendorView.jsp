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
<form:form commandName="testVendorView" action="" id="testVendorViewId">
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
                                            <h3>Test Order Manager</h3>	
                                            </div>                       
                                                 <div class="span3">                                                                                                           
                                                    <div class="box-holder"><a href="#" id="savd" class="savd" hidden="hide"/><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save.png"/>Save</div></a></div> 													                                              
													<div class="box-holder"><a href="#" id="savnewd" class="savnewd" hidden="hide"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-save-new.PNG"/>Save & New</div></a></div>
													<div class="box-holder"><a href="#"id="savcold" class="savcold" hidden="hide"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-saveclose.PNG"/>Save & Close</div></a></div>
                                                    <div class="box-holder"><a href="${pageContext.request.contextPath}/testvendorLogin"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-close.png"/>close</div></a></div>
                                                </div>                     
                                        </div>                                    
                                    </div>	              
                                </div>
                            </div>
				<div class="row">
                 
				<!-- Sidebar 
				<div class="span3">
					<ul id="sidebar" class="nav nav-tabs nav-stacked">
						<li>Test</li>
						<li>Test</li>
						
					</ul>
				</div>-->
				<!-- /Sidebar -->
				
				<!-- Content -->
				<div class="span12">
				       <div class="mobile"><h3>Test Order Manager</h3>	</div> 		
						<div class="widget">
						<div class="widget-header">
							<h3>Order Details</h3>
						</div>
						<div class="widget-content">
							
                            <div class="row">
								<div class="span1"><label>Order Id</label>
                                <input type="text" value="${testVendorView.orderId}" class="span1" disabled="disable" placeholder="Order Id" id="orderId"/>
								</div>
								<div class="span2"><label>Order Date</label>
                                 <input type="text" value="${testVendorView.orderDate}" class="span2" disabled="disable" placeholder="Order Date"/>
								 </div>
                                 <div class="span2"><label>Doctor</label>
                                 <input type="text" value="${testVendorView.doctorName}" class="span2" disabled="disable" placeholder="Doctor"/>
								 </div>
                                 <div class="span2"><label>Vendor</label>
                                 <input type="text" value="${testVendorView.vendorName}" class="span2" disabled="disable" placeholder="Vendor"/>
								 </div>								
                                 <div class="span2"><label>Order Ref</label>
                                 <input type="text" value="${testVendorView.orderReference}" class="span2" disabled="disable" placeholder="Order Ref"/>
								 </div>
                                 <div class="span2"><label>Order Value</label>
                                 <input type="text" value="${testVendorView.orderValue}" class="span2" disabled="disable" placeholder="Order Value"/>
								 </div>
                                 <div class="span1"><label>Discount</label>
                                 <input  type="text" value="${testVendorView.discount}"  class="span1" disabled="disable" placeholder="Discount"/>
								 </div> 
                                 <div class="span2"><label>Net Value</label>
                                 <input type="text" value="${testVendorView.netValue}" class="span2" disabled="disable" placeholder="Net Value"/>
								 </div> 
                                 <div class="span2"><label>Advance</label>
                                 <input type="text" value="${testVendorView.advance}" class="span2" disabled="disable" placeholder="Advance"/>
								 </div>
                                 <div class="span2"><label>Balance</label>
                                 <input type="text" value="${testVendorView.balance}" class="span2" disabled="disable" placeholder="Balance"/>
								 </div> 
								 <div class="span2"><label>Total Collected</label>
                                 <input type="text" value="${testVendorView.totalCollected}" class="span2" disabled="disable" placeholder="Total Collected"/>
								 </div>
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
                                <input type="text" value="${testVendorView.testGroup}" class="span4" disabled="disable" /></div>
								<div class="span4"><label>Sub Group</label>
                                 <input type="text" value="${testVendorView.testSubgroup}" class="span4" disabled="disable" /></div>
                                 <div class="span3"><label>Test</label>
                                 <input type="text" value="${testVendorView.tests}" class="span3" disabled="disable" /></div>                                 
                            </div>                                                     
						</div>
					</div>										
					<div class="widget">
						<div class="widget-header">
							<h3>Test Details</h3>
						</div>
						<div class="widget-content">
							
                            <div class="row">
								<div class="span3"><label>Order#</label>
                                <input type="text" value="${testVendorView.order}" class="span3" disabled="disable" /></div>
								<div class="span3"><label>Test Result</label>
                                 <input type="text" value="${testVendorView.testResult}" class="span3" disabled="disable" /></div>
                                 <div class="span3"><label>Analyst Remarks</label>
                                 <input type="text" value="${testVendorView.analystRemarks}" class="span3" disabled="disable" /></div> 
                                 <div class="span2"><label>Rate</label>
                                <input type="text" value="${testVendorView.rate}" class="span2" disabled="disable" /></div>	                        
                            </div>
                               <div class="row">
								<div class="span3"><label>Specimen Details</label>
                                <input type="text" value="${testVendorView.specimenDetails}" class="span3" disabled="disable" /></div>
								<div class="span3"><label>Test Job#</label>
                                 <input type="text" value="${testVendorView.testjob}" class="span3" disabled="disable" /></div>
                                 <div class="span3"><label>Tested By</label>
                                 <input type="text" value="${testVendorView.testedBy}" class="span3" disabled="disable" /></div> 
                                 <div class="span2"><label>Test Approved By</label>
                                <input type="text" value="${testVendorView.testApprovedby}" class="span2" disabled="disable" /></div>	                        
                            </div>
                                <div class="row">
								<div class="span3"><label>Test Start Date and Time</label>
                                 <input type="text" value="${testVendorView.testStarttime}" class="span3" disabled="disable" /></div>
                                 <div class="span3"><label>Test Reference</label>
                                 <input type="text" value="${testVendorView.testReference}" class="span3" disabled="disable" /></div>	                        
                            </div>
                             
                            
						</div>
					</div>
                 				
				</div>
				<!-- /Content -->
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
							<c:forEach  items="${testVendorView.doctorLoginSubForm}" var="doctorLoginDetail" varStatus="gridRow" >
									<tr onClick="orderTestId('${doctorLoginDetail.order}');"  Style="cursor:pointer;">                                    
										<td>${doctorLoginDetail.testGroup}</td>
										<td>${doctorLoginDetail.testSubgroup}</td>
										<td>${doctorLoginDetail.tests}</td>
										<td>${doctorLoginDetail.testResult}</td>
										<td>${doctorLoginDetail.analystRemarks}</td>
										<td>${doctorLoginDetail.rate}</td>
										<td>${doctorLoginDetail.specimenDetails}</td>
										<td>${doctorLoginDetail.testjob}</td>
									    <td>${doctorLoginDetail.testedBy}</td> 	
										<td>${doctorLoginDetail.testApproved}</td> 	
									 	
										<!--<td class="actions">
											<a href="#" class="btn btn-small btn-info"><i class="icon-ok"></i></a>
											<a href="#" class="btn btn-small btn-success"><i class="icon-remove"></i></a>
										</td>-->
									</tr>
								</c:forEach>		
								</tbody>
							</table>
							</div>			
						</div>
				      </div>	
				    </div>
				 </div>
		<!--Span12-For Table-->					
      <div class="dock-wrapper">    
        <div class="navbar navbar-fixed-bottom">
            <div class="navbar-inner">
                <div class="container">                  
                     <center>
                        <div class="btn-group btn-group-justified">
                      
                            <a href="${pageContext.request.contextPath}/testvendorLogin" class="btn btn-default">
                            <img src="${pageContext.request.contextPath}/resources/images/e-close.png"/><br>Close</a>
                         </div>
                    </center>	                        		
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
			</div>
			
           </div>
	    </div>
	    <!-- dispatchTestId--><form:hidden path="dispatchTestId"/>  
	  <form:hidden path="dispatch"/>	
	     <form:hidden path="searchdispatch"/>  
</body>

<script type="text/javascript">
$(function () {
    $('table').bind('footable_breakpoint', function() {
        $('table').trigger('footable_expand_first_row');
    }).footable();
});			
</script>
<script type="text/javascript">
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

<script>
var form = document.getElementById("testVendorViewId");
$("#save-enable").show();
$("#save-disable").hide();
$("#SN-e").hide();
$("#SN-d").hide();
function orderTestId(val){     
	

	var viewid=val;

	
	var orderId=document.getElementById("orderId").value;
	form.searchdispatch.value="view";
	form.dispatch.value=orderId;
	form.dispatchTestId.value=val;
      form.submit();
		
}
</script>

</form:form>
</html>