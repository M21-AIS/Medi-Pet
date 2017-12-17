<%-- 
    Document   : listPet
    Created on : Dec 13, 2017, 4:17:14 PM
    Author     : User
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Pet</title>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<style>
table {
  border: 1px solid #ccc;
  border-collapse: collapse;
  margin: 0;
  padding: 0;
  width: 100%;
  table-layout: fixed;
}
table caption {
  font-size: 1.5em;
  margin: .5em 0 .75em;
}
table tr {
  background: #f8f8f8;
  border: 1px solid #ddd;
  padding: .35em;
}
table th,
table td {
  padding: .625em;
  text-align: center;
}
table th {
  font-size: .85em;
  letter-spacing: .1em;
  text-transform: uppercase;
}
@media screen and (max-width: 600px) {
  table {
    border: 0;
  }
  table caption {
    font-size: 1.3em;
  }
  table thead {
    border: none;
    clip: rect(0 0 0 0);
    height: 1px;
    margin: -1px;
    overflow: hidden;
    padding: 0;
    position: absolute;
    width: 1px;
  }
  table tr {
    border-bottom: 3px solid #ddd;
    display: block;
    margin-bottom: .625em;
  }
  table td {
    border-bottom: 1px solid #ddd;
    display: block;
    font-size: .8em;
    text-align: right;
  }
  table td:before {
    /*
    * aria-label has no advantage, it won't be read inside a table
    content: attr(aria-label);
    */
    content: attr(data-label);
    float: left;
    font-weight: bold;
    text-transform: uppercase;
  }
  table td:last-child {
    border-bottom: 0;
  }
}
</style>
</head>

<body>
    <h1>Pet Information</h1>
    <div class="info">
    <p> Made with <i class="fa fa-heart"></i> by M21-AIS </p></a>
    </div>
    
    <div class="contentform">

    <table>
    <caption>List of Pet</caption>
    <thead>
      <tr>
        <th scope="col">Pet ID</th>
        <th scope="col">Name</th>
        <th scope="col">Date of Birth</th>
        <th scope="col">Sex</th>
        <th scope="col">Breed</th>
        <th scope="col">Owner Name</th>
        <th scope="col">Action</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${pets}" var="pet">
	<tr>
        <td data-label="Pet ID"><c:out value="${pet.petid}" /></td>
	<td data-label="Name"><c:out value="${pet.name}" /></td>
 	<td data-label="Date of Birth"><c:out value="${pet.dob}" /></td>
	<td data-label="Sex"><c:out value="${pet.sex}" /></td>
	<td data-label="Breed"><c:out value="${pet.breed}" /></td>
        <td data-label="Owner Name"><c:out value="${pet.fullName}" /></td>
	<td data-label="Action"><a href="PetController?action=edit&petId=<c:out value="${pet.petid}"/>">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
        
        <br><br>
        <center><button><a href="PetController?action=insert">Add Pet</a></button></center>
    </div>
  
</body>
</html>
