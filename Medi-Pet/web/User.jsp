<%-- 
    Document   : User
    Created on : Dec 10, 2017, 10:33:11 PM
    Author     : User
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>User Page </title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fidele Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!---->
<script src="js/menu_jquery.js"></script>
</head>
<body> 
<!--header-->	
<div class="header">
	<div class="container">
		 <div class="logo">
		  	<a href="index.jsp"><img src="images/logo.png" alt="" ></a>
	  	 </div>
	   <div class="head-right">
	   	<div class="head-grid">
	   		<ul>
				<li ><span>+607 5530070</span></li>
				<label>|</label>
                                <li>Welcome <%=request.getAttribute("userName") %></li>
                                <label>|</label>
                                <li><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></li>
                        </ul>
                </div>
	   <div class="top-nav">
			  <span class="menu"><img src="images/menu.png" alt=""> </span>
					<ul>
						 <li class="active"><a href="index.jsp">Home</a></li>
					   	 <li><a href="about.html">About</a></li>
					   	 <li><a href="services.html">Services</a></li>
					   	 <li><a href="sppointment.html">Appointment</a></li>
					   	 <li><a href="codes.html">Short Codes</a></li>
					   	 <li><a href="contact.jsp">Contact</a></li>
						<div class="clearfix"> </div>
					</ul>

					<!--script-->
				<script>
					$("span.menu").click(function(){
						$(".top-nav ul").slideToggle(500, function(){
						});
					});
			</script>
		</div>
		</div>
		<div class="clearfix"> </div>
	</div>
</div>
<!--//header-->
<div class="banner">
	<div class="banner-1"> </div>
		<div class="container">
			<div class="banner-top">
				<div class="col-sm-6 head-banner">
					<p class="grid1">
                                            <button type="button" class="btn btn-lg btn-warning"><a href="dispUPet.jsp">Pet List</a></button></p>
                                </div>	
				<div class="col-sm-6 banner-head1">
					<img src="images/cat1.png" class="img-responsive" alt="">
				</div>
				<div class="clearfix"> </div>
			</div>
	</div>
</div>

</body>
</html>