<%-- 
    Document   : Insert
    Created on : Oct 13, 2022, 9:53:27 PM
    Author     : PC
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
        <form action="insert" method="post" >
            <table>

                <tr>
                    <td>Product Name</td>
                    <td>
                        <input   type="text" name="name" required>
                    </td>
                </tr>
                <tr>
                </tr>
                <tr>
                    <td>Category </td>
                    <td> 
                        <select name="Cate" style="width :170px; ">   
                            <c:forEach var="c" items="${categories}">
                                <option value="${c.categoryId}">${c.categoryName} </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Quantity Per Unit</td>
                    <td><input type="text" name="Quan" required></td>
                </tr>
                <tr>
                    <td>Unit Price</td>
                    <td><input type="number" name="unit" required min="0"></td>
                </tr>
                <tr>
                    <td>Units In Stock</td>
                    <td><input type="number" name="stock" required min="0"></td>
                </tr>
                <tr>
                    <td>Units On Order</td>
                    <td><input type="number" name="order" required min="0"></td>
                </tr> 
                <tr>
                    <td>Re order Level</td>
                    <td><input type="number" name="reorder" required min="0"></td>
                </tr>
                <tr>
                    <td>Discontinued</td>
                    <td>
                          <label for="true"> <input type="radio" id="true" name="discontinue" value="1" checked> TRUE </label>
                         
                          <label for="false">  <input type="radio" id="false" name="discontinue" value="0"> FALSE</label></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit" >Create Product</button></td>
                </tr>
            </table>
        </form>   
    </body>
</html>
