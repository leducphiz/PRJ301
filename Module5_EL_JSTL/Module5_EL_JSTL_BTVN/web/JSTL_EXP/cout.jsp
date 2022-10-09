<%-- 
    Document   : cout
    Created on : Oct 10, 2022, 1:48:00 AM
    Author     : leducphi
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>The person's name is <c:out value="${person.name}" /></p>
        <p>The person's name is ${person.name}</p>
    </body>
</html>
