<%-- 
    Document   : appointment
    Created on : Dec 17, 2017, 4:49:33 PM
    Author     : ACER
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointment </title>
<link rel="stylesheet" href="style.css">
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>

<body>   
    <h1>Your Pet Information</h1>
    <div class="info">
    <p> Made with <i class="fa fa-heart"></i> by M21-AIS </p></a>
    </div>
  
  <form action="AppointmentControllerA" method="post">
      <h1>Appointment</h1>
	    
    <div class="contentform">
        
    	<div class="leftcontact">
        <div class="form-group">
            <p>Pet Name</p>
            <span class="icon-case"><i class="fa fa-info"></i></span>
            <input type="text" name="name" id="name" value="<c:out value="${app.name}" />"/>
        </div>
        
        <div class="form-group">
            <p>Appointment ID <span>*</span></p>
            <span class="icon-case"><i class="fa fa-user"></i></span>
            <input type="text" name="aapNo" id="username" value="<c:out value="${app.appNo}" />"/>
        </div>
        
        <div class="form-group">
            <p>Owner Name <span>*</span></p>
            <span class="icon-case"><i class="fa fa-male"></i></span>
            <input type="text" name="username" id="username" value="<c:out value="${app.username}" />"/>
            <div class="validation"></div>
	</div>
            
	<div class="form-group">
            <p>Date of Appointment <span>*</span></p>	
            <span class="icon-case"><i class="fa fa-calendar-o"></i></span>
            <input type="date" name="date" id="date" value="<c:out value="${app.date}" />"/>
        </div>
        </div>
            
	<div class="form-group">
            <p>Time <span>*</span></p>
            <span class="icon-case"><i class="fa fa-female"></i></span>
            <input type="time" name="time" id="time" value="<c:out value="${app.time}" />"/>
	</div>

	<div class="form-group">
            <p>Type of Vaccine <span>*</span></p>
            <span class="icon-case"><i class="fa fa-location-arrow"></i></span>
            <input type="radio" name="typeVacc" id="typeVacc" value="<c:out value="${app.typeVacc}" />"/> Modified Live Vaccines
            <input type="radio" name="typeVacc" id="typeVacc" value="<c:out value="${app.typeVacc}" />"/> Killed Vaccines
            <input type="radio" name="typeVacc" id="typeVacc" value="<c:out value="${app.typeVacc}" />"/> Recombinant Vaccines
            <input type="radio" name="typeVacc" id="typeVacc" value="<c:out value="${app.typeVacc}" />"/> Anti-idiotype antibodies
            <input type="radio" name="typeVacc" id="typeVacc" value="<c:out value="${app.typeVacc}" />"/> DNA Vaccines
            <input type="radio" name="typeVacc" id="typeVacc" value="<c:out value="${app.typeVacc}" />"/> Subunit
            <div class="validation"></div>
	</div>
            
    </div>

	
<button type="submit" class="bouton-contact">Submit</button>
	
</form>	

</body>
</html>
