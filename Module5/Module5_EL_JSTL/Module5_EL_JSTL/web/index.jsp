<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dal.Product" %>
<%@page import="models.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            input.Edit {
                width: 100px;
                height: 30px;
                display: block;
                margin-top: 20px;
            }
        </style>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>

        <h1 style="text-align: center">Product List</h1>
    <center>
        <table border="1" width="100%" style="text-align: center" class="table table-striped table-hover">
            <tr><td>ID</td><td>Name</td><td>Price</td><td>Action</td></tr>

            <c:forEach items="${products}" var="p">
                <tr>
                    <td>${p.getProductID()}</td>
                    <td>${p.getProductName()}</td>
                    <td>${p.getUnitPrice()}</td>
                    <td>
                        <a href="edit?id=${p.getProductID()}">Edit</a>
                        <a href="del?id=${p.getProductID()}">Delete</a>
                    </td>
                </tr>
            </c:forEach>



        </table>
    </center>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>
