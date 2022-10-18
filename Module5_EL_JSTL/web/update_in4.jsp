<%-- 
    Document   : update_in4
    Created on : Oct 9, 2022, 8:48:40 PM
    Author     : Anh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit information</h1>
        <c:set value="${sessionScope.proD}" var="p"/>
        <form action="edit" method="post">
            Name: <input type="text" name="Name" value="${p.getProductName()}"><br>
            Price: <input type="number" name="Price" value="${p.getUnitPrice()}"><br>            
            <input type="submit" value="Edit" />
        </form>
    </body>
</html>
