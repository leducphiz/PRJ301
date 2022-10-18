<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Module 5</title>
    </head>
    <body>
        <h1>Product List</h1>
        <table border="1">
            <tr><td>ID</td><td>Name</td><td>Price</td><td>Action</td></tr>

            <c:forEach items="${products}" var="p">
                <tr>
                    <td>${p.getProductID()}</td>
                    <td>${p.getProductName()}</td>
                    <td>${p.getUnitPrice()}</td>
                    <td>
                        <a href="update?id=${p.getProductID()}">Edit</a>
                        <a href="delete?id=${p.getProductID()}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
