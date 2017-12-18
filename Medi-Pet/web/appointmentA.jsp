
<%-- 
    Document   : Admin
    Created on : Dec 10, 2017, 10:32:39 PM
    Author     : User
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Set Appointment</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Best Pets Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">   
<link href="css/font-awesome.css" rel="stylesheet"> <!-- font-awesome icons -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" property="" />
<!-- //Custom Theme files -->  
<!-- web-fonts -->   
<link href="//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Dosis:200,300,400,500,600,700,800" rel="stylesheet">
<!-- //web-fonts -->
<style>
p
{
    color: white;
    font-size: 20px;
}
.button {
    background-color: #FF7F50;
    border: none;
    color: white;
    padding: 16px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
    border-radius: 12px;
    background-color: white; 
    color: black; 
    border: 2px solid #FF7F50;
}

.button:hover {
    background-color: #FF7F50;
    color: white;
}

.control-label{
    font-size: 20px;
    color : white;
}

span {
    color : red;
}
</style>
</head>
<body> 
	<!-- banner -->
	<div class="w3ls-banner jarallax">
		<div class="w3lsbanner-info">
			<!-- header -->
			<div class="header">
				<div class="container">   
					<div class="agile_header_grid"> 
						<div class="header-mdl agileits-logo"><!-- header-two --> 
							<h1><a href="index.jsp">Medi Pet</a></h1> 
						</div>
						<div class="agileits_w3layouts_sign_in">
							<ul>
                                                            <li>Welcome <%=request.getAttribute("userName") %></li>
                                                            <li>|</li>
                                                            <li><a href="<%=request.getContextPath()%>/LogoutServlet" data-toggle="modal" class="play-icon">Logout</a></li>
                                                            <li>Call us : <span>(+07) 553 0070</span></li>
							</ul>
						</div>
						<div class="clearfix"> </div>
					</div> 
					<div class="header-nav"><!-- header-three --> 	
						<nav class="navbar navbar-default">
							<div class="navbar-header">
								<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
									<span class="sr-only">Toggle navigation</span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button> 
							</div>
							<!-- top-nav -->
							<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
								<ul class="nav navbar-nav cl-effect-16">
									<li><a href="index.jsp" class="active" data-hover="Home">Home</a></li>
									<li><a href="about.html" data-hover="About">About</a></li> 
									<li><a href="gallery.html" data-hover="Gallery">Gallery</a></li>
									<li><a href="contact.jsp" data-hover="Contact">Contact</a></li>
								</ul>  
								<div class="clearfix"> </div>	
							</div>
						</nav>    
					</div>	
				</div>	
			</div>	
			<!-- //header --> 
			<!-- banner-text -->
			<div class="banner-text agileinfo"> 
				<div class="container">
                                <center>
                                <h3 class="w3ls-hdg">Set Appointment</h3>
				<div class="tab-content">
					<div class="tab-pane active" id="horizontal-form">
						<form class="form-horizontal" action="AppointmentServletA" method="post">
							<div class="form-group">
							<label for="appNo" class="col-sm-2 control-label">Appointment No</label>
							<div class="col-sm-8">
                                                            <input type="text" class="form-control1" name="appNo" id="appNo"  value="<c:out value="${app.appNo}"/>" placeholder="Appointment No">
							</div>
                                                        </div>
                                                        <div class="form-group">
                                                        <label for="name" class="col-sm-2 control-label">Pet Name<span>*</span></label>
							<div class="col-sm-8">
                                                            <input type="text" class="form-control1" name="name" id="name" value="<c:out value="${app.name}" />" placeholder="Pet Name">
                                                        </div>
                                                        </div>
                                                        <div class="form-group">
                                                        <label for="date" class="col-sm-2 control-label">Date <span>*</span></label>
							<div class="col-sm-8">
                                                            <input type="date" class="form-control1" name="date" id="date" value="<c:out value="${app.date}" />">
                                                        </div>
                                                        </div>
                                                        <div class="form-group">
							<label for="time" class="col-sm-2 control-label">Time<span>*</span></label>
							<div class="col-sm-8">
                                                            <input type="time" class="form-control1" name="time" id="time" value="<c:out value="${app.time}"/>" placeholder="Time">
							</div>
                                                        </div>
                                                        <div class="form-group">
							<label for="typeVacc" class="col-sm-2 control-label">Type of Vaccines<span>*</span></label>
							<div class="col-sm-8">
                                                           <p><input type="radio"  name="typeVacc" id="typeVacc" value="<c:out value="${app.typeVacc}"/>">Live Vaccines<br>&nbsp;&nbsp;
                                                            <input type="radio" name="typeVacc" id="typeVacc" value="<c:out value="${app.typeVacc}"/>">Killed Vaccines<br>&nbsp;&nbsp;
                                                            <input type="radio" name="typeVacc" id="typeVacc" value="<c:out value="${app.typeVacc}"/>">Subunit Vaccines<br>&nbsp;&nbsp;
                                                            <input type="radio" name="typeVacc" id="typeVacc" value="<c:out value="${app.typeVacc}"/>">Recombinant Vaccines<br>&nbsp;&nbsp;
                                                            <input type="radio" name="typeVacc" id="typeVacc" value="<c:out value="${app.typeVacc}"/>">Anti-idiotype antibodies<br>&nbsp;&nbsp;
                                                            <input type="radio" name="typeVacc" id="typeVacc" value="<c:out value="${app.typeVacc}"/>">DNA Vaccines</p>
                                                        </div>
                                                        </div>
                                                        <div class="form-group">
							<label for="fullname" class="col-sm-2 control-label">Owner Name<span>*</span></label>
							<div class="col-sm-8">
                                                            <input type="text" class="form-control1" name="fullname" id="fullname" value="<c:out value="${app.fullname}"/>" placeholder="Full Name">
							</div>
                                                        </div>        
						<button type="submit" class="button">Submit</button>	
						</form>
                                        </div>
                                    </div>
                                </center>
				</div>
				</div>
				</div>
			</div>
			<!-- //banner-text -->  
		</div>	
	</div>	
	<!-- //banner -->
	<!-- js --> 
	<script src="js/jquery-2.2.3.min.js"></script>  
	<!-- //js -->  
	<!-- jarallax -->  
	<script src="js/SmoothScroll.min.js"></script> 
	<script src="js/jarallax.js"></script> 
	<script type="text/javascript">
		/* init Jarallax */
		$('.jarallax').jarallax({
			speed: 0.5,
			imgWidth: 1366,
			imgHeight: 768
		})
	</script>  
	<!-- //jarallax -->
	<!-- ResponsiveTabs js -->
	<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			$('#horizontalTab').easyResponsiveTabs({
				type: 'default', //Types: default, vertical, accordion           
				width: 'auto', //auto or any width like 600px
				fit: true   // 100% fit in a container
			});
		});
	</script>
	<!-- //ResponsiveTabs js -->  
	<!-- banner-type-text -->
	<script src="js/typed.js" type="text/javascript"></script>
    <script>
		$(function(){

			$("#typed").typed({
				// strings: ["Typed.js is a <strong>jQuery</strong> plugin.", "It <em>types</em> out sentences.", "And then deletes them.", "Try it out!"],
				stringsElement: $('#typed-strings'),
				typeSpeed: 30,
				backDelay:700,
				loop: true,
				contentType: 'html', // or text
				// defaults to false for infinite loop
				loopCount: false,
				callback: function(){ foo(); },
				resetCallback: function() { newTyped(); }
			});

			$(".reset").click(function(){
				$("#typed").typed('reset');
			});

		}); 
		function newTyped(){ /* A new typed object */ }

		function foo(){ console.log("Callback"); }
    </script>
	<!-- //banner-type-text -->
	<!-- flexSlider -->
	<script defer src="js/jquery.flexslider.js"></script>
	<script type="text/javascript">
		$(window).load(function(){
		  $('.flexslider').flexslider({
			animation: "slide",
			start: function(slider){
			  $('body').removeClass('loading');
			}
		  });
		});
	</script>
	<!-- //flexSlider --> 
	<!-- start-smooth-scrolling -->
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>	
	<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
			
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
	</script>
	<!-- //end-smooth-scrolling -->	
	<!-- smooth-scrolling-of-move-up -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
			var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
			};
			*/
			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
	<!-- //smooth-scrolling-of-move-up --> 
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.js"></script>
</body>
</html>


