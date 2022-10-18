<%-- 
    Document   : Update
    Created on : Oct 12, 2022, 12:35:19 AM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
   <form action="update" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td>
                        <input value="${pt.getProductID()}" type="text" name="id" readonly >
                    </td>
                </tr>
                <tr>
                    <td>Product Name</td>
                    <td>
                        <input  value=${pt.getProductName()} type="text" name="name" required>
                    </td>
                </tr>
                <tr>
                </tr>
                <tr>
                   <td>Category </td>
                    <td> 
                        <select name="Cate" style="width :170px; ">   
                            <c:forEach var="c" items="${categories}">
                                <option value="${c.categoryId}" ${c.categoryId== pt.getCategoryID() ? 'selected' : ''} >${c.categoryName} </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Quantity Per Unit</td>
                    <td><input  value="${pt.getQuantityPerUnit()}" type="text" name="Quan" required></td>
                </tr>
                <tr>
                    <td>Unit Price</td>
                    <td><input  value="${pt.getUnitPrice()}" type="text" name="unit" required></td>
                </tr>
                <tr>
                    <td>Units In Stock</td>
                    <td><input  value="${pt.getUnitsInStock()}" type="text" name="stock" required></td>
                </tr>
                <tr>
                    <td>Units On Order</td>
                    <td><input  value="${pt.getUnitsOnOrder()}" type="text" name="order" required></td>
                </tr> 
                <tr>
                    <td>Re order Level</td>
                    <td><input  value="${pt.getReorderLevel()}" type="text" name="reorder" required></td>
                </tr>
                <tr>
                     <td>Discontinued</td>
                    <td><label for="true"> <input type="radio" id="true" name="discontinue" value="1" ${pt.isDiscontinued() == true ? 'checked' : ''}> TRUE </label>
                         
                          <label for="false">  <input type="radio" id="false" name="discontinue" value="0" ${pt.isDiscontinued() == false ? 'checked' : ''}> FALSE</label></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit" >Update</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
