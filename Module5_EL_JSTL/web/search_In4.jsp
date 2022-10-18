<%-- 
    Document   : search_In4
    Created on : Oct 15, 2022, 11:19:27 PM
    Author     : Anh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            h1 a, h2 a {
                text-decoration: none;
            }

            h1 {
                text-align: center;
            }
            h2 {
                float: right;
            }
            .pagination {
                display: inline-block;
                
            }

            .pagination a {
                color: black;
                float: left;
                padding: 8px 16px;
                text-decoration: none;
            }

            .pagination a.active {
                background-color: #4CAF50;
                color: white;
                border-radius: 5px;
            }

            .pagination a:hover:not(.active) {
                background-color: #ddd;
                border-radius: 5px;
            }
            .footer {
                height: 40px;
                width: 40px;
            }
            .footer img{
                width: 100%;
            }
        </style>
    </head>
    <body>
        <h1><a href="search?index=1&search=a">INFORMATION FOUND</a></h1>
        <table border="1" width="100%" style="text-align: center">
            <tr><td>ID</td><td>Name</td><td>Price</td><td>UnitsInStock</td><td>ReorderLevel</td></tr>
            <c:forEach items="${products}" var="p">
                <tr>
                    <td>${p.getProductID()}</td>
                    <td>${p.getProductName()}</td>
                    <td>${p.getUnitPrice()}</td>
                    <td>${p.getUnitsInStock()}</td>
                    <td>${p.getReorderLevel()}</td>
                </tr>
            </c:forEach>
        </table>
        <div style="text-align: center;">
            <div class="pagination">
            <c:forEach begin="1" end="${endPage}" var="i">
                <a href="search?index=${i}&search=${search}">${i}</a>
            </c:forEach>
        </div>
        </div>
        
        <h2 class="footer"><a href="list-product"><img src="img/2048px-Go-home.svg.png" alt=""/></a></h2>
        

    </body>
</html>
