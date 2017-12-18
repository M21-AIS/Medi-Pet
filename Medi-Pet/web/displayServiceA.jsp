<%-- 
    Document   : displayServiceA
    Created on : 18-Dec-2017, 00:16:43
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Display Service</title>
    </head>
    <body>
        <jsp:forward page="/AServiceServlet?action=listServiceA"></jsp:forward>
    </body>
</html>

