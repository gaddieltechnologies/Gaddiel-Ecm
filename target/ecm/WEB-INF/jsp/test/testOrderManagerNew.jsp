<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Clinical Laboratory - Admin Dashboard</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">    
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap-responsive.min.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/alveolae.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/footable.core.css?v=2-0-1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/footable-demos.css">
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/pikaday.css">
    <!-- Google font -->
    <link href="/css/css.css" rel="stylesheet" type="text/css">
     <script src="${pageContext.request.contextPath}/resources/js/jquery.1.9.1.min.js" type="text/javascript"></script>     
     <script src="${pageContext.request.contextPath}/resources/js/footable.js?v=2-0-1"></script>
     <script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>
     <script src="${pageContext.request.contextPath}/resources/js/moment-with-langs.js"></script>    
    <script src="${pageContext.request.contextPath}/resources/js/pikaday.js"></script>

	<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->		
</head>
<form:form commandName="testOrderManagerNew" id="testordermanagernewid">
<body>
<!-- Navbar -->

	<!-- /Navbar -->
	
	<!-- Main content -->
	<div id="main-content">
		<!-- Container -->
		<div class="container">
			<!-- Header boxes -->
			<div class="alert alert-success alert-block" id="sucessdiv" >
						<button type="button" class="close" onClick="sucessclose()" data-dismiss="alert">&times;</button>
						<h4 id="successmessage">${testOrderManagerNew.successMessage}</h4>
				
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
                                            <h3>Test Order Manager:${testOrderManagerNew.dispatchPatientName}</h3>	
                                            </div>                         
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
				<div class="span12 ">
				    <div class="mobile"><h3>Test Order Manager:${testOrderManagerNew.dispatchPatientName}</</h3>	</div> 	
						<div class="widget">
						<div class="widget-header">
							<h3>Order Details</h3>
						</div>
						<div class="widget-content">
							
                            <div class="row">
								<div class="span1"><label>Order Id</label>
                                <form:input path="orderId" id="idorderid" class="span1" placeholder="Order Id"/>
								</div>
								<div class="span2"><label>Order Date</label>
                                 <form:input path="orderDate" id="idorderdate" class="span2" placeholder="Order Date"/>
								 </div>
                                  <div class="span2"><label>Doctor</label>
                                 <form:select path="doctor" id="iddoctor" class="span2" placeholder="Doctor">
                                 <option value="0">-select doctor-</option>
                                 <form:options items="${drname}" itemLabel="referringDoctor" itemValue="doctor"/>
                                 </form:select>
								 </div>
                                 <div class="span2"><label>Vendor</label>
                                 <form:select path="testVendor" id="idvendor" class="span2" placeholder="Vendor">
                                 <option value="0">-select vendor-</option>
                                 <form:options items="${vendname}" itemLabel="vendorList" itemValue="testVendor"/>
                                 </form:select>
								 </div>							
                                 <div class="span2"><label>Order Ref</label>
                                 <form:input path="orderReference" id="idorderreference" class="span2" placeholder="Order Ref"/>
								 </div>
								 <div class="span2"><label>Publish?</label>
                                 <form:select path="publish" id="idpublish" class="span2" placeholder="Y">
								<option value="0">-select-</option>
								<form:options items="${publishlist}" />
								
								</form:select>
								 </div>
                                 <div class="span2"><label>Order Value</label>
                                 <form:input path="grossAmount" id="idordervalue" class="span2" placeholder="Order Value"/>
								 </div>
                                 <div class="span1"><label>Discount</label>
                                 <form:input path="discount" id="iddiscount" class="span1" placeholder="Discount" onblur="calculatenetvalue()"/>
								 </div> 
                                 <div class="span2"><label>Net Value</label>
                                 <form:input path="netAmount" id="idnetvalue" class="span2" placeholder="Net Value"/>
								 </div> 
                                 <div class="span2"><label>Advance</label>
                                 <form:input path="adavance" id="idadvance" class="span2" placeholder="Advance" onblur="calculatebalancetc()"/>
								 </div>
                                 <div class="span2"><label>Balance</label>
                                 <form:input path="balance" id="idbalance" class="span2" placeholder="Balance"/>
								 </div> 
								 <!--<div class="span2"><label>Total Collected</label>
                                 <form:input path="totalCollected" id="idtotalcollected" class="span2" placeholder="Total Collected"/>
								 </div>-->
								 <a class="btn btn-info btn-user-info" id="idaddorder" onClick="validate()">Add Order</a>
								 <a class="btn btn-info btn-user-info" id="idsaveorder" onClick="validateD()">Save Order</a>
							
                            </div>                                                        
						</div>
					</div>
                    <div class="widget" id="testgroupsdivid">	
                                 <div class="widget-header">
							    <h3>Test Groups</h3>
						       </div>    					
						<div class="widget-content">							
                            <div class="row">
                           	
								<div class="span3"><label>Group</label>
                                <form:select path="group" id="idgroup" class="span3"  onblur="subgroupselect()">
                                <option>-select group-</option>
							<form:options items="${groupname}" itemLabel="group" itemValue="testGroup"></form:options>
                                </form:select></div>
								<div class="span3"><label>Sub Group</label>
                                 <form:select path="subGroup" id="idsubgroup" class="span3"  onblur="testselect()">
                                 <option>-select subgroup-</option>
                                 <form:options path="subgroupoptions"></form:options>
                                 </form:select></div>
                                 <div class="span3"><label>Test</label>
                                 <form:select path="test" id="idtest" class="span3" placeholder="Tests" onblur="rateselect();specimenselect()">
                                  <option>-select test-</option>
                                  <form:options path="testoptions"></form:options>
                                 </form:select></div>                                 
                            </div>                                                     
						</div>
					</div>										
					<div class="widget" id="testdetailsdivid">
						<div class="widget-header">
							<h3>Test Details</h3>
						</div>
						<div class="widget-content">
							
                            <div class="row">
								<div class="span3"><label>Order#</label>
                                <form:input path="orderTest" id="idorder" class="span3" placeholder="Order#"/></div>
								<div class="span3"><label>Test Result</label>
                                 <form:input path="testResult" id="idtestresult" class="span3" placeholder="Test Result"/></div>
                                 <div class="span3"><label>Analyst Remarks</label>
                                 <form:input path="analystRemarks" id="idanalystremarks" class="span3" placeholder="Analyst Remarks"/></div> 
                                 <div class="span2"><label>Rate</label>
                                <form:input path="rate" id="idrate" class="span2" placeholder="Rate"/></div>	                        
                            </div>
                               <div class="row">
								<div class="span3"><label>Specimen Details</label>
                                <form:input path="specimenDetails" id="idspecimendetails" class="span3" placeholder="Specimen Details"/></div>
								<div class="span3"><label>Test Job#</label>
                                 <form:input path="testJob" id="idtestjob" class="span3" placeholder="Test Job#"/></div>
                                 <div class="span3"><label>Tested By</label>
                                 <form:input path="testedBy" id="idtestedby" class="span3" placeholder="Tested By"/></div> 
                                 <div class="span2"><label>Test Approved By</label>
                                <form:input path="testApprovedBy" id="idtestapprovedby" class="span2" placeholder="Test Approved By"/></div>	                        
                            </div>
                                <div class="row">
								
								<div class="span3"><label>Test Start Time</label>
                                 <form:input path="testStartTime" id="idteststarttime" class="span3" placeholder="Test Start Time"/></div>
                                 <div class="span3"><label>Test Reference</label>
                                 <form:input path="testReference" id="idtestreference" class="span3" placeholder="Test Reference"/></div> 
								 <a class="btn btn-info btn-user-info" onClick="validatetest()">Add Test</a>
                                 	                        
                            </div>
                             
                            
						</div>
					</div>
                 				
				</div>
				<!-- /Content -->
				     <div class="span12">
					<div class="widget-content" id="griddivid">
						<div class="tab-content">
							<div class="tab-pane active" id="demo">
							<table class="table demo table-striped table-bordered" data-filter="#filter" data-page-size="5"
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
							
							<c:choose>
				<c:when	test="${testOrderManagerNew.testOrderManagerrDetailSubForm==null}"> </c:when>
					<c:otherwise>
					<c:forEach  items="${testOrderManagerNew.testOrderManagerrDetailSubForm}" var="testgriddetail" varStatus="gridRow" >
									<tr onClick="orderTestId('${testgriddetail.testId}');"  Style="cursor:pointer;">                                    
										<td>${testgriddetail.groupId}</td>
										<td>${testgriddetail.subgroupId}</td>
										<td>${testgriddetail.testId}</td>
										<td>${testgriddetail.testResult}</td>
										<td>${testgriddetail.analystRemarks}</td>
										<td>${testgriddetail.rate}</td>
										<td>${testgriddetail.specimenDetails}</td>
										<td>${testgriddetail.testJob}</td>
									    <td>${testgriddetail.testedBy}</td> 	
										<td>${testgriddetail.testApprovedBy}</td> 	
					     				<!--<td class="actions">
											<a href="#" class="btn btn-small btn-info"><i class="icon-ok"></i></a>
											<a href="#" class="btn btn-small btn-success"><i class="icon-remove"></i></a>
										</td>-->
									</tr>
								</c:forEach>	
						</c:otherwise>
						</c:choose>
									
								</tbody>
							</table>
							</div>			
						</div>
					</div>
				    </div>
		<!--Span12-For Table-->					
                
              </div>  
                            	<!-- Footer -->
			<div id="footer">
				<hr>
				<p class="pull-right">Gaddiel Technologies Pvt Ltd &copy; 2013</p>
			</div>
			<!-- /Footer -->
			</div>

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
	    

	    <form:hidden path="dispatchGridView"/>
	    <form:hidden path="dispatchTestId"/>
	    <form:hidden path="dispatch"/>
	    <form:hidden path="searchdispatch"/>
		<form:hidden path="dispatchPatientId"/>
</body>
<script>
var form=document.getElementById("testordermanagernewid");
$("#sucessdiv").hide();
$(".save-enable").show();
$(".save-disable").hide();
$(".SN-e").show();
$(".SN-d").hide();
$("#testgroupsdivid").hide();
$("#testdetailsdivid").hide();
$("#griddivid").hide();
$("#idsaveorder").hide();
$("#idorderid").attr("readonly",true);
$("#idorderdate").attr("readonly",true);
$("#idordervalue").attr("readonly",true);
$("#iddiscount").attr("readonly",true);
$("#idnetvalue").attr("readonly",true);
$("#idadvance").attr("readonly",true);
$("#idbalance").attr("readonly",true);
$("#idtotalcollected").attr("readonly",true);

function sucessclose()
{
	
	js("#sucessdiv").hide();
	
}

function validate(){
	if((document.getElementById("iddoctor").value==0)||(document.getElementById("idvendor").value==0)){
		if(document.getElementById("iddoctor").value==0)
		{
		document.getElementById("iddoctor").style.borderColor="#FF0000";
		}
		if(document.getElementById("idvendor").value==0)
		{
		document.getElementById("idvendor").style.borderColor="#FF0000";
		}
		alert("Please enter the highlighted fields");
	}
	if((document.getElementById("iddoctor").value!=0)&&(document.getElementById("idvendor").value!=0)){
form.dispatchGridView.value="addtest";
form.dispatch.value="addorder";
form.submit();
	}
}

if(form.dispatch.value=="addorder"){
	
	$("#testgroupsdivid").show();
	$("#testdetailsdivid").show();
	$("#griddivid").show();
	$("#idorderid").attr("readonly",true);
	$("#idorderdate").attr("readonly",true);
	$("#iddoctor").attr("readonly",true);
	$("#idvendor").attr("readonly",true);
	$("#idorderreference").attr("readonly",true);
	$("#idpublish").attr("readonly",true);
	$("#idordervalue").attr("readonly",true);
	$("#iddiscount").attr("readonly",true);
	$("#idnetvalue").attr("readonly",true);
	$("#idadvance").attr("readonly",true);
	$("#idbalance").attr("readonly",true);
	//$("#idtotalcollected").attr("readonly",true);
	$("#idsaveorder").show();
	$("#idaddorder").hide();
	$("#idorder").attr("readonly",true);
	$("#idrate").attr("readonly",true);
	$("#idspecimendetails").attr("readonly",true);
}

function validatetest(){
	
	if((document.getElementById("idgroup").value=="-select group-")||(document.getElementById("idsubgroup").value=="-select subgroup-")||(document.getElementById("idtest").value=="-select test-")||(document.getElementById("idteststarttime").value.length==0)){
		if(document.getElementById("idgroup").value=="-select group-")
		{
		document.getElementById("idgroup").style.borderColor="#FF0000";
		}
		if(document.getElementById("idsubgroup").value=="-select subgroup-")
		{
		document.getElementById("idsubgroup").style.borderColor="#FF0000";
		}
		if(document.getElementById("idtest").value=="-select test-")
		{
		document.getElementById("idtest").style.borderColor="#FF0000";
		}
		if(document.getElementById("idteststarttime").value.length==0)
		{
		document.getElementById("idteststarttime").style.borderColor="#FF0000";
		}
		alert("Please enter the highlighted fields");
	}
	
	if((document.getElementById("idgroup").value!="-select group-")&&(document.getElementById("idsubgroup").value!="-select subgroup-")&&(document.getElementById("idtest").value!="-select test-")&&(document.getElementById("idteststarttime").value.length!=0))
	{
	
	form.dispatchGridView.value="addtest";
	form.dispatch.value="addtest";
	form.submit();
	}
}



if(form.dispatch.value=="addtest"){
	$("#testgroupsdivid").show();
	$("#testdetailsdivid").show();
	$("#griddivid").show();
	document.getElementById("idgroup").value="-select group-";
	document.getElementById("idsubgroup").value="-select subgroup-";
	document.getElementById("idtest").value="-select test-";
	document.getElementById("idorder").value="";
	document.getElementById("idtestresult").value="";
	document.getElementById("idanalystremarks").value="";
	document.getElementById("idrate").value="";
	document.getElementById("idspecimendetails").value="";
	document.getElementById("idtestjob").value="";
	document.getElementById("idtestedby").value="";
	document.getElementById("idtestapprovedby").value="";
	document.getElementById("idteststarttime").value="";
	document.getElementById("idtestreference").value="";
	$("#idorderid").attr("readonly",true);
	$("#idorderdate").attr("readonly",true);
	$("#iddoctor").attr("readonly",true);
	$("#idvendor").attr("readonly",true);
	$("#idorderreference").attr("readonly",true);
	$("#idpublish").attr("readonly",true);
	$("#idordervalue").attr("readonly",true);
	$("#iddiscount").attr("readonly",false);
	$("#idnetvalue").attr("readonly",true);
	$("#idadvance").attr("readonly",false);
	$("#idbalance").attr("readonly",true);
	//$("#idtotalcollected").attr("readonly",true);
	$("#idaddorder").hide();
	$("#idsaveorder").show();
	$("#idorder").attr("readonly",true);
	$("#idrate").attr("readonly",true);
	$("#idspecimendetails").attr("readonly",true);
}

function validateD(){
	
	form.dispatchGridView.value="addtest";
	form.dispatch.value="saveorder";
	form.submit();
	
}

if(form.dispatch.value=="saveorder"){
$("#sucessdiv").show();
document.getElementById("idorderid").value="";
document.getElementById("idorderdate").value="";
document.getElementById("idorderreference").value="";
document.getElementById("idordervalue").value="";
document.getElementById("iddiscount").value="";
document.getElementById("idnetvalue").value="";
document.getElementById("idadvance").value="";
document.getElementById("idbalance").value="";
//document.getElementById("idtotalcollected").value="";
document.getElementById("idtestjob").value="";

$("#idorderid").attr("readonly",true);
$("#idorderdate").attr("readonly",true);
$("#idordervalue").attr("readonly",true);
$("#iddiscount").attr("readonly",true);
$("#idnetvalue").attr("readonly",true);
$("#idadvance").attr("readonly",true);
$("#idbalance").attr("readonly",true);
//$("#idtotalcollected").attr("readonly",true);
document.getElementById("iddoctor").value="-select doctor-";
document.getElementById("idvendor").value="-select vendor-";	
document.getElementById("idpublish").value="-select-";
}

var js=jQuery.noConflict();
function subgroupselect(){
	var test_Group=document.getElementById("idgroup").value;

	js.post("${pageContext.request.contextPath}/testsubgroupselect",
				{allgroups: test_Group},
								function(data){
					var options = '<option>-select subgroup-</option>';
					for(var increment=0;increment<data.length;increment++){
						options += '<option value="'+data[increment].testSubGroup+'">'+data[increment].subGroup+'</option>';
						}
							  
							   $("select#idsubgroup").html(options);
			              
				});
}
				      
				      
function testselect(){
	var test_Group=document.getElementById("idgroup").value;
	var test_Subgroup=document.getElementById("idsubgroup").value;
	var test=test_Group+','+test_Subgroup;
		js.post("${pageContext.request.contextPath}/testselect",
					{allsubgroups: test},
									function(data){
						var options = '<option>-select test-</option>';
						
						for(var increment=0;increment<data.length;increment++){
							options += '<option value="'+data[increment].testId+'">'+data[increment].test+'</option>';
							}
								  
								   $("select#idtest").html(options);
				              
					});
	}
	
function rateselect(){
	
	var test_Test=document.getElementById("idtest").value;
		js.post("${pageContext.request.contextPath}/ratevalue",
					{allrate: test_Test},
									function(data){
						document.getElementById("idrate").value=data[0].rate;
								  
								  
				              
					});
	}
	
function specimenselect(){
	
	var test_Test=document.getElementById("idtest").value;
		js.post("${pageContext.request.contextPath}/specimentype",
					{allspecimen: test_Test},
									function(data){
						document.getElementById("idspecimendetails").value=data[0].specimenDetails;
								  
								   
				              
					});
	}
	
	function calculatenetvalue(){
		
		document.getElementById("idnetvalue").value=(document.getElementById("idordervalue").value)-(document.getElementById("iddiscount").value);
	}
	
	function calculatebalancetc(){
		
		document.getElementById("idbalance").value=(document.getElementById("idnetvalue").value)-(document.getElementById("idadvance").value);
		//document.getElementById("idtotalcollected").value=(document.getElementById("idnetvalue").value)-(document.getElementById("idbalance").value);
	}
	
function orderTestId(val){     
	

	var viewid=val;
	//alert(viewid);
	
	var orderId=document.getElementById("idorderid").value;
	form.dispatchGridView.value="addtest";
	form.searchdispatch.value="view";
	form.dispatch.value=orderId;
	form.dispatchTestId.value=val;
      form.submit();
		
}

if(form.searchdispatch.value=="view"){
$("#testgroupsdivid").show();
$("#testdetailsdivid").show();
$("#griddivid").show();
}

</script>

<script>
	var picker = new Pikaday(
    {
		//changeMonth: true,
    	//changeYear: true,
		
        field: document.getElementById('idteststarttime'),		
        firstDay: 1,
	    //minDate: new Date('2000-01-01'),
       // maxDate: new Date('2020-12-31'),
        yearRange: [1920,2020],
		format: 'DD-MM-YYYY',
        onSelect: function() {
            console.log(this.getMoment().format('DD-MM-YYYY'));
        }
    });
	</script>
</form:form>
</html>