<%-- 
    Document   : product-list
    Created on : Sep 28, 2022, 8:40:36 AM
    Author     : leducphi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="models.ProductDAO" %>
<%@page import="dal.Product" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display</title>
    </head>
    <body>
        <table>
            <tr>
                <th>
                    Product ID
                </th>
                <th>
                    Product Name
                </th>
                <th>
                    Product Price
                </th>
            </tr>
            
            <%
                // lay du lieu tu controller chuyen sang
                ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("products");
                for(Product p : list){
            %>
            <tr>
                <td><%=p.getProductID()%></td>
                <td><%=p.getProductName()%></td>
                <td><%=p.getUnitPrice()%></td>
            </tr>


            <%
            }
            %>
        </table>
    </body>
</html>
