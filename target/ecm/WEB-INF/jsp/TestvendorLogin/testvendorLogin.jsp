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
	<script src="${pageContext.request.contextPath}/resources/js/footable.js?v=2-0-1"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.js"></script>
	<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->	
</head>
<form:form commandName="testvendorLogin" action="" id="testvendorLoginId">
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
			
                    <div id="main-content">
                            <!-- Container -->
                            <div class="container">
                                <!-- Header boxes -->
                                <div class="box-container">
                                    
                                </div>
                                <!-- /Header boxes -->
              	<div class="row">
            
                  <!-- Sidebar -->
                  <div class="span3">					
					<div class="widget">						
						<div class="widget-content">
							<ul class="messages-activity">
                              <li>
                                <a href="#"><img src="http://placehold.it/80x80" class="messages-activity-avatar" alt="avatar1"></a>
                               
                                        <P class="well well-message">  
                                         <span><%= session.getAttribute("user") %></span>,                                      
                                	      <span><%= session.getAttribute("testvendorregistration") %></span>.                                       
                                          
                                         
                                        </P>							
                              </li>  
                           </ul>
                         </div>
                      </div>
                  </div> 
                  <!-- /Sidebar -->
				<!-- span9 -->
                <div class="span9 desktop">
					
					<div class="widget">                    					
						<div class="widget-content"> 
                        <div class="span5"><h3>Profile</h3></div>                       
							 <div class="span3">                                                                
	                               <div class="box-holder">
	                                   <a href="#" onclick="newPage()"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-add.png"/>New</div></a>
	                               </div>  
	                               <div class="box-holder">
								        <a id="viewdd" class="viewdd">
                                        <div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-view.png"/>View</div></a>
										 <a style="cursor:pointer;" id="viewid" class="viewid">
                                  <div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-view.png"/>View</div></a>
										
	                               </div>  
	                               <div class="box-holder">	                                
									  <a id="edit-d" class="edit-d">
                                      <div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-edit.png"/>Edit</div></a>
	                               </div>
	                                <div class="box-holder">
	                                  <a href="${pageContext.request.contextPath}/controlPanel">
	                                  <div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-trash.png"/>delete</div></a>
	                               </div>  
	                               <div class="box-holder">
	                                  <a href="${pageContext.request.contextPath}/index">
	                                  <div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-close.png"/>Close</div></a>
	                               </div>        
	                              	                                              
	                             </div>            
            			</div>
				    </div>								
				</div>
                <!-- /span9 -->
                      <div class="span12">
					<div class="widget">					
						<div class="widget-content">
							  <div class="span3"><form:input path="searchDate" type="text"  class="span3" placeholder="Search by Test Date"  id="searchdate"/></div>               
                            <div class="span3"><form:input path="searchID" type="text" class="span3" placeholder="Search by Order Number" id="searchid"></form:input></div>                  
                            <div class="span2"><form:input path="searchName" type="text"  class="span2" placeholder="Search by Patient Name" id="searchname"></form:input></div>                        
                            <div class="span3"><form:input path="searchMobile" type="text"  class="span3" placeholder="Search by Mobile  Phone#" id="searchmobile"/></div> 
                            <div class="span3"><form:input path="searchEmail" type="text"  class="span3" placeholder="Search by Email Id" id="searchmailid"/></div> 
                            <div class="span3"><form:input path="searchVendorname"  type="text" class="span3" placeholder="Search by Vendor Name" id="searchtestName"/></div> 
						    <div class="span3"><a href="#" class="btn btn-info "onClick="searchvalue()">Search</a> 
                            <a href="#" class="btn btn-info "onClick="clearvalue()">Clear</a></div>               
                               
                               
				</div>
              </div>  
              </div>            
			  
				<!-- /Content -->
	                <div class="span12">
	                  <span style="color:green" id="memo"><h3>${testvendorLogin.alertMessage}</h3></span>
					<div class="widget">					
						<div class="widget-content">
							<div class="tab-content">
							<div class="tab-pane active" id="demo">
							<table class="table demo table-bordered" data-filter="#filter" data-page-size="5"
							       data-page-previous-text="prev" data-page-next-text="next">
							<!--<table class="table table-striped table-bordered">-->                            
								<thead>
									<tr class="widget-header">
										<th data-toggle="true">Date</th>
										<th>Order#</th>
										<th data-hide="phone,tablet">Order Reference</th>
										<th data-hide="phone,tablet">Patient Name</th>
                                        <th data-hide="phone,tablet">Vendor Name</th>                                        
                                                                               
                             		</tr>
								</thead>
								
								<tbody id="gridvaluediv" class="mytable1">
								<c:forEach  items="${testvendorLogin.doctorLoginSubForm}" var="doctorLoginDetail" varStatus="gridRow" >
									<tr onClick="orderId('${doctorLoginDetail.orderId}');" Style="cursor:pointer;">                                    
										<td>${doctorLoginDetail.date}</td>
										<td>${doctorLoginDetail.orderId}</td>
										<td>${doctorLoginDetail.orderReference}</td>
										<td>${doctorLoginDetail.patientName}</td>
										<td>${doctorLoginDetail.vendorName}</td>
																		
                                                                       
										
									</tr>
							</c:forEach>	
								</tbody>
							</table>
						</div>
					</div>					

                         </div>
                      </div>
                 </div>      
    <div class="dock-wrapper">    
         <div class="navbar navbar-fixed-bottom">
            <div class="navbar-inner">
                <div class="container">                  
                        <center>
                            <div class="btn-group btn-group-justified">                      
							    <a href="#" class="btn btn-default" onclick="newPage()">
								<img src="${pageContext.request.contextPath}/resources/images/d-add.png"/><br>New</a>
							
							    <a style="cursor:pointer;" id="viewid" class="viewid  btn btn-default">
								<img src="${pageContext.request.contextPath}/resources/images/e-view.png"/><br>View</a>
								<a id="viewdd" class="viewdd btn btn-default">
								<img src="${pageContext.request.contextPath}/resources/images/d-view.png"/><br>View</a>								  
							
							 
								 <a id="edit-d" href="#" class="edit-d btn btn-default">
								<img src="${pageContext.request.contextPath}/resources/images/d-edit.png"/><br>Edit</a>
							    <a href="${pageContext.request.contextPath}/controlPanel" class="btn btn-default">
								<img src="${pageContext.request.contextPath}/resources/images/d-trash.png"/><br>Delete</a>
							    <a href="${pageContext.request.contextPath}/index" class="btn btn-default">
								<img src="${pageContext.request.contextPath}/resources/images/e-close.png"/><br>Close</a>
							</div>
                      </center>	                      		
				</div>
           	</div>
		</div>
     </div>            <!-- /Content -->
             
                 
					</div><!--/row-->                       
		      </div>
        </div>
           			
	<form:hidden path="dispatch"/>		
    <form:hidden path="searchdispatch"/>  
     <form:hidden path="dispatchhit"/>
	</body>
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
	 <script type="text/javascript">
	 var form = document.getElementById("testvendorLoginId");
	 var js=jQuery.noConflict();
	 js("#gridvaluediv").hide();
	 js(".viewdd").show();
	 js(".edit-d").show();
	 js(".viewid").hide();
	 js(".viewid").hide();
	 js(".edit-e").hide();  
	 function searchvalue()
	 {
	 	//alert("");
	 	
	 	form.searchdispatch.value="search";
	 	form.submit();
	 	
	 	}
	 	if(form.searchdispatch.value=="search")
	 	{
	 		 js("#gridvaluediv").show();
			js(".viewdd").hide();
			js(".viewid").show();
	 		}
	 function clearvalue()
	 {
	 	
	 	document.getElementById("searchdate").value="";
	 	document.getElementById("searchid").value="";
	 	document.getElementById("searchmailid").value="";
	 	document.getElementById("searchname").value="";
		document.getElementById("searchmobile").value="";
		document.getElementById("searchtestName").value="";
	 	js("#gridvaluediv").hide();
		js(".viewid").hide();
		js(".viewdd").show();
	 	}
	 function orderId(val){     
			

			var viewid=val;
			
			
			 js(".viewid").click(function () {
				
				form.searchdispatch.value="views";
			form.dispatch.value=val;
		
		 form.submit();
				});
		}
	
	 </script>
	</form:form>
</html>