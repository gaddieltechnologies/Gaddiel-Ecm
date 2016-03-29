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
	<form:form commandName="doctorManager" action="" id="doctorManagerId">
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
				
				<div class="row">
					<!-- Sidebar -->
					
					<!-- /Sidebar -->
					
					<!-- Content -->
					<div class="span12 desktop">
						<div class="widget">
	                        <div class="widget-content"> 
	                        <div class="span8"><h3>Doctor Manager</h3></div>
	                            <div class="span3">                                                                
	                               <div class="box-holder">
	                                   <a href="#" onclick="newPage()"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-add.png"/>New</div></a>
	                               </div>  
	                               <div class="box-holder">
								        <a id="view-d" class="viewdd">
                                        <div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-view.png"/>View</div></a>
										<a style="cursor:pointer;" id="viewid" class="viewid">
									    <div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-view.png"/>View</div></a>
	                               </div>  
	                               <div class="box-holder">
	                                  <a  style="cursor:pointer;" id="edit-e" class="edit-e">
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
					<!-- /Content -->
	                <div class="span12">
						<div class="widget">					
							<div class="widget-content">
								
	                           	<div class="mobile"><h3>Doctor Manager</h3></div> 
	                            <div class="span3"><form:input path="searchdoctor" class="span3" placeholder="Search by Doctor Name" id="searchname"/></div>               
	                            <div class="span2"><form:input path="searchphoneno" class="span2" placeholder="Search by Phone Number" id="searchphone"/></div>                          
	                            <div class="span2"><form:input path="searchemail" class="span2" placeholder="Search by Email Id" id="searchmailid"/></div>                             
	                            <div class="span2"><form:input path="searchspecialzie" class="span2" placeholder="Search by Specialization" id="searchspecial"/></div>  
	                            <div class="span2"><a href="#" onclick="searchvalue()" class="btn btn-info ">Search</a> <a href="#" onclick="searchclear()" class="btn btn-info ">Clear</a></div>               
	                                       
						
				
					</div>
	              </div>  
	              </div>  
	                <!------>
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
										<th data-toggle="true">Doctor Reg#</th>
										<th>Doctor Name</th>
										<th data-hide="phone,tablet">Doctor IMC Number</th>
										<th data-hide="phone,tablet">Specialization</th>
                                        <th data-hide="phone,tablet">Tie Up</th>                                        
                                        <th data-hide="phone,tablet">Email Id</th>
										<th data-hide="phone,">Mobile No#</th>
										<th data-hide="phone,">Preferred Contact</th>
                             		</tr>
											 </thead>
									
											<tbody id="gridvaluediv" class="mytable1">
								             <c:forEach items="${doctorManager.doctorDetailSubForm}" var="doctorDetail" varStatus="gridRow">
									            <tr onClick="doctorId('${doctorDetail.doctorId}');"Style="cursor:pointer;">                                    
									
	                                    
											<td>${doctorDetail.doctorId}</td>
											<td>${doctorDetail.doctorName}</td>
											<td>${doctorDetail.doctorImcNumber}</td>
											<td>${doctorDetail.specialization}</td>
	                                        <td>${doctorDetail.tieUp}</td>
											<td>${doctorDetail.emailId}</td>
											<td>${doctorDetail.phoneMobile}</td>
	                                        <td>${doctorDetail.preferredContactMethod}</td>
	                                  
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
				
				
					<!------>
	                
	             
	                
				</div>
				
				<!-- Footer -->
				<div id="footer">
					<hr>
					<p class="pull-right">Gaddiel Technologies Pvt Ltd &copy; 2013</p>
				</div>
				<!-- /Footer -->
		        <!-- Navbar -->
    <div class="dock-wrapper">    
        <div class="navbar navbar-fixed-bottom">
            <div class="navbar-inner">
                <div class="container">                  
                      <center>
                         <div class="btn-group btn-group-justified">                         
							<a class="btn btn-default" onclick="newPage()">
									<img src="${pageContext.request.contextPath}/resources/images/e-add.png"/><br>New</a>
									
							<a style="cursor:pointer;" id="viewid" class="viewid btn btn-default">							
									<img src="${pageContext.request.contextPath}/resources/images/e-view.png"/><br>View</a>
							<a id="view-d" class="viewdd btn btn-default">
									<img src="${pageContext.request.contextPath}/resources/images/d-view.png"/><br>View</a>								  
							
							<a id="edit-e"style="cursor:pointer;" href="#" class="edit-e btn btn-default">
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
	<!-- /Navbar -->
			</div>
			<!-- /Container -->
		</div>
		<!-- /Main content -->

		<!-- Javascript files -->
		<form:hidden path="dispatchs"/>	
	    <form:hidden path="dispatch"/>
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
	<script>
	var form = document.getElementById("doctorManagerId");
	var js=jQuery.noConflict();
	js("#gridvaluediv").hide();
    js(".viewdd").show();
	js(".edit-d").show();
	js(".viewid").hide(); 
	js(".edit-e").hide();  
    
	
   
   
	function searchvalue()
	{
		form.dispatch.value="search";
		form.submit();
		
	}
	 if(form.dispatch.value=="search")
		{
			js("#gridvaluediv").show();
			js(".viewdd").hide();
			js(".viewid").show();
            
	
		}
	function searchclear()
	{
		
		document.getElementById("searchname").value="";
		document.getElementById("searchphone").value="";
		document.getElementById("searchmailid").value="";
		document.getElementById("searchspecial").value="";
		js("#gridvaluediv").hide();
		js(".viewid").hide();
		js(".viewdd").show();
		}
	function doctorId(val){     
		

		var viewid=val;
		
		
		js(".viewid").click(function () {
			
			form.dispatch.value="views";
			form.submit();
		form.dispatchs.value=val;
		
	 form.submit();
			});
	}
	function newPage(){
		form.dispatch.value="new";
		 form.submit();
	}
	</script>
	</form:form>
</html>
