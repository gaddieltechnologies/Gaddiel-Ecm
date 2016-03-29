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
<form:form commandName="userAccessManager" action="" id="userAccessManagerId">
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
				
					<div class="alert alert-success alert-block" id="sucessdiv" >
						<button type="button" class="close" onClick="sucessclose()" data-dismiss="alert">&times;</button>
						<h4 id="successmessage">${userAccessManager.successMessage}</h4>
				
					</div>
			</div>
			<!-- /Header boxes -->
			<!-- row boxes -->
			<div class="row">
			   <div class="span12 desktop">
				
				 <div class="widget">                 					
					<div class="widget-content "> 
                       <div class="span8"> <h3>User Access Manager</h3>	</div>
                                <div class="span3">                                                                
	                               <div class="box-holder">
	                                   <a href="#" onclick="newPage()"><div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-add.png"/>New</div></a>
	                               </div>  
	                               <div class="box-holder">
								        <a id="viewdisable" class="viewdisable">
                                        <div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-view.png"/>View</div></a>
										<a style="cursor:pointer;" id="viewid" class="viewid">
									    <div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-view.png"/>View</div></a>
	                               </div>  
	                               <div class="box-holder">
	                                  <a  style="cursor:pointer;" id="editenable" class="editenable">
	                                  <div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-edit.png"/>Edit</div></a>
									  <a id="editdisable" class="editdisable">
                                      <div class="box"><img src="${pageContext.request.contextPath}/resources/images/d-edit.png"/>Edit</div></a>
	                               </div>  
	                                <div class="box-holder">
	                                  <a href="#" id="deletenable" class="deletenable" >
	                                  <div class="box"><img src="${pageContext.request.contextPath}/resources/images/e-trash.png"/>delete</div></a>
									  <a id="deletedisable" class="deletedisable" >
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
						    <div class="mobile"><h3>User Access Manager</h3></div> 
                            <div class="span3"><form:input path="searchUserName" class="span3" placeholder="Search by User Name" id="searchname"/></div>               
                            <div class="span2"><form:input path="searchPhoneMobile" class="span2" placeholder="Search by Phone Number" id="searchphone"/></div>                          
                            <div class="span2"><form:select path="searchRole" class="span2" placeholder="Search by Role" id="searchrole">
                             <option>-Select Role-</option>
                            <option>SUPERUSER</option>
                            <option>LABADMIN</option>
                            <option>LABUSER</option>
                            <option>OTHERS</option>
                            </form:select>
                            </div>                             
                            <div class="span2"><form:select path="searchUserType" class="span2" placeholder="Search by User Type" id="searchusertype">
                             <option>-Select Type-</option>
                            <option>LAB</option>
                            <option>PATIENT</option>
                            <option>DOCTOR</option>
                            <option>TESTVENDOR</option>
                            </form:select>
                            </div>  
                            <div class="span2"><a href="#" class="btn btn-info " onClick="searchvalue()">Search</a> <a href="#" class="btn btn-info " onClick="clearvalue()">Clear</a></div>               
                                              
						
					
			
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
							<table class="table demo table-bordered " data-filter="#filter" data-page-size="5"
							       data-page-previous-text="prev" data-page-next-text="next">
						                          
								<thead>
									<tr class="widget-header">
										<th data-toggle="true">User Name</th>
										<th data-hide="phone">User Type</th>
										<th data-hide="phone">Role</th>
										<th data-hide="phone,tablet">Postal Code</th>                                                                               
                                        <th data-hide="phone,tablet">Phone_mobile</th>
                                        <th data-hide="phone,tablet">Email Id</th>                                       	
                             		</tr>
								</thead>
								
								<tbody id="gridvaluediv" class="mytable1">
								<c:forEach items="${userAccessManager.userDetailSubForm}" var="userSubForm" varStatus="gridRow">
									<tr onClick="userId('${userSubForm.userId}');" Style="cursor:pointer;">                                   
										
										<td>${userSubForm.userName}</td>
										<td>${userSubForm.userType}</td>
										<td>${userSubForm.role}</td>
										<td>${userSubForm.postOfficeCode}</td>                                        
										<td>${userSubForm.phoneMobile}</td>
										<td>${userSubForm.emailID}</td>
										
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
			</div><!-- /row boxes -->
			
			<!-- Footer -->
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
							<a class="btn btn-default" onclick="newPage()">
									<img src="${pageContext.request.contextPath}/resources/images/e-add.png"/><br>New</a>
									
							<a style="cursor:pointer;" id="viewid" class="viewid btn btn-default">							
									<img src="${pageContext.request.contextPath}/resources/images/e-view.png"/><br>View</a>
							<a id="viewdisable" class="viewdisable btn btn-default">
									<img src="${pageContext.request.contextPath}/resources/images/d-view.png"/><br>View</a>								  
							
							<a id="editenable"style="cursor:pointer;" href="#" class="editenable btn btn-default">
									<img src="${pageContext.request.contextPath}/resources/images/e-edit.png"/><br>Edit</a>
							<a id="editdisable" class="editdisable btn btn-default">
									<img src="${pageContext.request.contextPath}/resources/images/d-edit.png"/><br>Edit</a>
									
							<a href="#" id="deletenable" class="deletenable btn btn-default">
									<img src="${pageContext.request.contextPath}/resources/images/e-trash.png"/><br>Delete</a>
							<a id="deletedisable" class="deletedisable btn btn-default">
									<img src="${pageContext.request.contextPath}/resources/images/d-trash.png"/><br>Delete</a>		
									
							<a href="${pageContext.request.contextPath}/controlPanel" class="btn btn-default">
									<img src="${pageContext.request.contextPath}/resources/images/e-close.png"/><br>Close</a>
							
                          </div>
                     </center>                  		
				</div>
           	</div>
		</div>
     </div>		<!-- /Footer -->
	
		</div>
		<!-- /Container -->
	</div>
	<!-- /Main content -->
<form:hidden path="dispatchGridView"/>
<form:hidden path="dispatchid"/>
	
</body>
<!-- Javascript files -->

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

var form = document.getElementById("userAccessManagerId");
var js=jQuery.noConflict();
js("#sucessdiv").hide();
js("#newenable").show();
js("#newdisable").hide();

js(".viewid").hide();
js(".viewdisable").show();

js(".editenable").hide();
js(".editdisable").show();

js(".deletenable").hide();
js(".deletedisable").show();

js("#gridvaluediv").hide();

function sucessclose()
{
	
	js("#sucessdiv").hide();
	
}

function userId(idvalue)
{
	
	var viewid=idvalue;
	//alert(viewid);
	
	 $(".viewid").click(function () 
		{
		
			form.dispatchGridView.value="view";
			form.dispatchid.value=idvalue;
			
 			form.submit();
 			//alert(form.dispatchGridView.value);
 			//alert(form.dispatch.value);
		});
	 $("#deletenable").click(function(){  
		  form.dispatchGridView.value="delete";
		  form.dispatchid.value=idvalue;
		  
		  form.submit();
		 });  
   
}
if(form.dispatchGridView.value=="delete")
{
	 js("#sucessdiv").show();
}

if(form.dispatchGridView.value=="Save&Close")
{
	js("#sucessdiv").show();
}

function searchvalue()
{
	//alert("");
	
	form.dispatchGridView.value="search";
	
	form.submit();
	
	}
	if(form.dispatchGridView.value=="search")
	{
		js("#gridvaluediv").show();
		js(".viewid").show();
		js(".viewdisable").hide();

		js(".editenable").hide();
		js(".editdisable").show();

		js(".deletenable").show();
		js(".deletedisable").hide();
		
		}
	
	function newPage(){
		form.dispatchGridView.value="new";
		 form.submit();
	}
	
function clearvalue()
{
	
	document.getElementById("searchname").value="";
	document.getElementById("searchphone").value="";
	document.getElementById("searchrole").value="-Select Role-";
	document.getElementById("searchusertype").value="-Select Type-";
	js("#gridvaluediv").hide();
	js("#newenable").show();
	js("#newdisable").hide();

	js(".viewid").hide();
	js(".viewdisable").show();

	js(".editenable").hide();
	js(".editdisable").show();

	js(".deletenable").hide();
	js(".deletedisable").show();
	}
</script>
</form:form>
</html>
