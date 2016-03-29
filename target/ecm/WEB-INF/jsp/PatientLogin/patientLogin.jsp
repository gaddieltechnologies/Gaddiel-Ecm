	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
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
<form:form commandName="patientLogin" action="" id="patientLoginId">
<body onload="myFunction()">
   
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
                                	      <span><%= session.getAttribute("patientage") %></span>.                                       
                                          
                                         
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
							  <div class="span3.5"><form:input path="searchDate" type="text"  class="span3" placeholder="Search by Test Date"  id="searchdate"/></div>               
                            <div class="span2"><form:input path="searchID" type="text" class="span2" placeholder="Search by Order Number" id="searchid"></form:input></div>                  
                            <div class="span2"><form:input path="searchDoctorName" type="text"  class="span2" placeholder="Search by Doctor Name" id="searchname"></form:input></div>                        
                            <div class="span2"><a href="#" class="btn btn-info "onClick="searchvalue()">Search</a> 
                            <a href="#" class="btn btn-info "onClick="clearvalue()">Clear</a></div>               
                               
                               
				</div>
              </div>  
              </div> 
			 	
				<!-- Content -->
				<div class="span12">	
				<span style="color:green"><h3>${patientLogin.alertMessage}</h3></span>		
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
										<th data-hide="phone,tablet">Doctor Name</th>
                                        <th data-hide="phone,tablet">Amount</th>                                                                                
                             		</tr>
								</thead>
								
								<tbody id="gridvaluediv" class="mytable1">
								<c:forEach  items="${patientLogin.patientLoginSubForm}" var="patientLoginDetail" varStatus="gridRow" >
									<tr onClick="orderId('${patientLoginDetail.orderId}');" Style="cursor:pointer;">                                    
										<td>${patientLoginDetail.date}</td>
										<td>${patientLoginDetail.orderId}</td>
										<td>${patientLoginDetail.orderReference}</td>
										<td>${patientLoginDetail.doctorName}</td>
										<td>${patientLoginDetail.totalCollected}</td>								
                                                                       
										
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
     </div>    <!-- /Content -->
             
                 
					</div><!--/row-->                       
		      </div>
        </div>
           			
	<form:hidden path="dispatch"/>		
    <form:hidden path="searchdispatch"/>  
    <form:hidden path="dispatchhit"/>
	</body>
	<script type="text/javascript">
	$(".viewid").hide();
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
	 var form = document.getElementById("patientLoginId");
	 
	js("#gridvaluediv").hide();
	  
	 js(".viewdd").show();
	 function searchvalue()
	 {
	 	
	 	
	 	form.searchdispatch.value="search";
	 	form.submit();
	 	
	 	}
	 	if(form.searchdispatch.value=="search")
	 	{
	 		js("#gridvaluediv").show();
			js(".viewid").show();
			 js(".viewdd").hide();
	 		}
	 function clearvalue()
	 {
	 	
	 	document.getElementById("searchdate").value="";
	 	document.getElementById("searchid").value="";
	 
	 	document.getElementById("searchname").value="";
	 	js("#gridvaluediv").hide();
	 	js(".viewid").hide();
		js(".viewdd").show();
	 	}
	 function orderId(val){     
			

			var viewid=val;
			
			
			$(".viewid").click(function () {
				
				form.searchdispatch.value="views";
			form.dispatch.value=val;
		
		 form.submit();
				});
		}
	 function myFunction(){
		   form.dispathhit.value="timeout";
		   form.submit();
		 }
	 </script>
	</form:form>
</html>