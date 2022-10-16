<%-- 
    Document   : Update
    Created on : Oct 10, 2022, 12:56:08 AM
    Author     : leducphi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>

    <c:set value="${sessionScope.Prod}" var="p"/>
    <h1>Edit information of Product ID: ${p.getProductID()}</h1>


    <c:catch var ="catchException">
        <% String s = null; out.println(s.length());%>
    </c:catch>
    <c:if test = "${catchException != null}">
        <p>The exception is : ${catchException} <br />
            There is an exception: ${catchException.message}</p>
        </c:if>

    <c:if test="${p.getProductID() % 2 == 0 && p.getProductName().length()  > 5}" var="cookieTestResult" scope="request">
        day la so chan va ten sp dai hon 5 ki tu
    </c:if>
    Result of Cookie Test:  <c:out value="${requestScope.cookieTestResult}"/>


    <form action="update" method="post">
        Name: <input type="text" name="Name" value="${p.getProductName()}"><br>
        Price: <input type="number" name="Price" value="${p.getUnitPrice()}"><br>            
        <input type="submit" value="Edit" />
    </form>

</html>
