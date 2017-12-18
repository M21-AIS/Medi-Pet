<%-- 
    Document   : listAppA
    Created on : Dec 17, 2017, 11:46:11 PM
    Author     : ACER
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
    <caption>List of Appointment</caption>
    <thead>
      <tr>
        <th scope="col">Pet Name</th>
        <th scope="col">Appointment ID</th>
        <th scope="col">Owner Name</th>
        <th scope="col">Date</th>
        <th scope="col">Time</th>
        <th scope="col">Type of Vaccines</th>
        <th scope="col" colspan="2">Action</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${apps}" var="app">
	<tr>
        <td data-label="Pet ID"><c:out value="${app.name}" /></td>
	<td data-label="Appointment ID"><c:out value="${app.appNo}" /></td>
 	<td data-label="Owner Name"><c:out value="${app.username}" /></td>
	<td data-label="Date"><c:out value="${app.date}" /></td>
	<td data-label="Time"><c:out value="${app.time}" /></td>
        <td data-label="Type of Vaccines"><c:out value="${app.typeVacc}" /></td>
	<td data-label="Action"><a href="AppointmentControllerA?action=edit&appNo=<c:out value="${app.appNo}"/>">Edit</a></td>
	<td data-label="Action"><a href="AppointmentControllerA?action=delete&appNo=<c:out value="${app.appNo}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
        
        <br><br>
        <center><button><a href="AppointmentControllerA?action=insert">Set Appointment</a></button></center>
    </div>
  
</body>
</html>
