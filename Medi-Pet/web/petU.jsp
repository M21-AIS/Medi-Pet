<%-- 
    Document   : listAPet
    Created on : Dec 13, 2017, 10:58:13 PM
    Author     : User
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Pet</title>
<link rel="stylesheet" href="style.css">
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>

<body>   
    <h1>Your Pet Information</h1>
    <div class="info">
    <p> Made with <i class="fa fa-heart"></i> by M21-AIS </p></a>
    </div>
  
  <form action="PetController" method="post">
      <h1>Pet Registration</h1>
	    
    <div class="contentform">
        
    	<div class="leftcontact">
        <div class="form-group">
            <p>Pet ID</p>
            <span class="icon-case"><i class="fa fa-info"></i></span>
            <input type="text" name="petid" id="petid" readonly="readonly" value="<c:out value="${pet.petid}" />"/>
        </div>
        
        <div class="form-group">
            <p>Name <span>*</span></p>
            <span class="icon-case"><i class="fa fa-user"></i></span>
            <input type="text" name="name" id="name" value="<c:out value="${pet.name}" />"/>
        </div>

	<div class="form-group">
            <p>Date of Birth <span>*</span></p>	
            <span class="icon-case"><i class="fa fa-calendar-o"></i></span>
            <input type="date" name="dob" id="dob" value="<c:out value="${pet.dob}" />"/>
        </div>
        </div>
            
    <div class="rightcontact">	

	<div class="form-group">
            <p>Sex <span>*</span></p>
            <span class="icon-case"><i class="fa fa-female"></i></span>
            <input type="text" name="sex" id="sex" value="<c:out value="${pet.sex}" />"/>
	</div>

	<div class="form-group">
            <p>Breed <span>*</span></p>
            <span class="icon-case"><i class="fa fa-location-arrow"></i></span>
            <input type="text" name="breed" id="breed" value="<c:out value="${pet.breed}" />"/>
            <div class="validation"></div>
	</div>
            
        <div class="form-group">
            <p>Owner Name <span>*</span></p>
            <span class="icon-case"><i class="fa fa-male"></i></span>
            <input type="text" name="fullname" id="fullname" value="<c:out value="${pet.fullName}" />"/>
            <div class="validation"></div>
	</div>

    </div>
        
    </div>
	
<button type="submit" class="bouton-contact">Submit</button>
	
</form>	

</body>
</html>
