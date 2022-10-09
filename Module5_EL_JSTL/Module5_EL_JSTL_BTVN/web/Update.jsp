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


    <!--DEMO JSTL BY EXAMPLE-->
    <!--demo c:set c:out-->
    <c:set var="varA" value="${p.getProductName()}" />
    <h5>The old Product Name: <c:out value="${varA}" /></h5>

    <c:set var="varB" value="${p.getUnitPrice()}" />
    <h5>The old Product Price <c:out value="${varB}" /></h5>
    <c:remove var="varB"></c:remove>
    <h5>The new Product Price <c:out value="${varB}" /></h5>


    <c:catch var ="catchException">
        <% int x = 5/0;%>
    </c:catch>
    <c:if test = "${catchException != null}">
        <p>The exception is : ${catchException} <br />
            There is an exception: ${catchException.message}</p>
        </c:if>

    <c:if test="${p.getProductID()!= null }">
        <c:choose>
            <c:when test="${p.getProductID()%2 == 0 }">
                <p>${p.getProductID() } is even</p>
            </c:when>
            <c:otherwise>
                <p>${p.getProductID() } is odd</p>
            </c:otherwise>
        </c:choose>
    </c:if>


    <a href = "<c:url value = "index"/>">HOME</a>
    <c:url value="/index.jsp" var="completeURL">  
        <c:param name="ID" value="786"/>  
        <c:param name="Name" value="PhiLe"/>  
    </c:url>  
    <p>${completeURL}</p>

    <c:forTokens items="Le-Duc-Phi-Lop-SE1641" delims="-" var="name">  
        <c:out value="${name}"/><p>  
        </c:forTokens>  

    <c:import var = "data" url = "http://www.tutorialspoint.com"/>
    <c:out value = "${data}"/>

    <form action="update" method="post">
        Name: <input type="text" name="Name" value="${p.getProductName()}"><br>
        Price: <input type="number" name="Price" value="${p.getUnitPrice()}"><br>            
        <input type="submit" value="Edit" />
    </form>

</html>
