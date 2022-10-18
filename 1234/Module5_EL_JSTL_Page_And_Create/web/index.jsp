<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="index"> <h1>Product List</h1> </a>
        <form action="SearchProduct">
            <label for="filter">Filter  <select id="filter" name="filter">
                    <option value="name">Search by Name </option>
                    <option value="price">Search by Price </option>
                    <option value="category">Search by Category </option>
                    <option value="all" selected>All option </option>
                </select>  </label>
            <input name="search" placeholder="Enter search..." > <button type="submit">Search</button>  
        </form>
        <br
            <br>

        <table border="1">
            <tr><td>ID</td><td>Product Name</td><td>Category Name</td><td>Quantity Per Unit</td><td>Price</td><td>Units In Stock</td><td>Units On Order</td><td>Reorder Level</td><td>Discontinued</td></tr>

            <c:if test="${newProduct != null}">
                <tr>
                    <td>${newProduct.getProductID()}</td>
                    <td>${newProduct.getProductName()}</td>

                    <c:forEach var="c" items="${categories}">
                        <c:if test="${c.categoryId == newProduct.getCategoryID()}">
                            <td>${c.categoryName} </td>
                        </c:if>
                    </c:forEach>

                    <td>${newProduct.getQuantityPerUnit()}</td>
                    <td>${newProduct.getUnitPrice()}</td>
                    <td>${newProduct.getUnitsInStock()}</td>
                    <td>${newProduct.getUnitsOnOrder()}</td>
                    <td>${newProduct.getReorderLevel()}</td>
                    <c:if test="${newProduct.isDiscontinued() == true}"><td>1</td></c:if>
                    <c:if test="${newProduct.isDiscontinued() == false}"><td>0</td></c:if>
                    <td><a href="update?id=${newProduct.getProductID()} ">update</a>
                        <button onclick="showMess(${newProduct.getProductID()})">delete</button></td>
                </tr>
            </c:if>

            <c:forEach items="${products}" var="p">
                <tr>
                    <td>${p.getProductID()}</td>
                    <td>${p.getProductName()}</td>

                    <c:forEach var="c" items="${categories}">
                        <c:if test="${c.categoryId == p.getCategoryID()}">
                            <td>${c.categoryName} </td>
                        </c:if>
                    </c:forEach>

                    <td>${p.getQuantityPerUnit()}</td>
                    <td>${p.getUnitPrice()}</td>
                    <td>${p.getUnitsInStock()}</td>
                    <td>${p.getUnitsOnOrder()}</td>
                    <td>${p.getReorderLevel()}</td>
                    <c:if test="${p.isDiscontinued() == true}"><td>1</td></c:if>
                    <c:if test="${p.isDiscontinued() == false}"><td>0</td></c:if>
                    <td><a href="update?id=${p.getProductID()} ">update</a>
                        <button onclick="showMess(${p.getProductID()})">delete</button></td>
                </tr>
            </c:forEach>


        </table>
        <a href="insert">Create Product</a>

        <br>
        <br>
        <br>

        <c:if test="${numberOfPage > 1}">
            <c:forEach var = "i" begin = "1" end = "${numberOfPage}">
                <c:choose>
                    <c:when test="${i==page}">
                        <button class="active">
                            <a  href="index?page=${i}">${i}</a>
                        </button>
                    </c:when>    
                    <c:otherwise>
                        <button>
                            <a  href="index?page=${i}">${i}</a>
                        </button>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
        </div>
    </c:if>
    <style>
        .active{
            background: red;
        }
        button > a {
            text-decoration: none;
            color : black;
        }
    </style>
</body>
<script>
    function showMess(id) {
        var option = confirm('Do you want to delete product : ' + id + ' ? ');
        if (option === true) {
            window.location.href = 'delete?id=' + id;
        }


    }
</script>
</html>
