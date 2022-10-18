<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dal.Product" %>
<%@page import="models.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>

            /*Clearing Floats*/
            .cf:before, .cf:after{
                content:"";
                display:table;
            }

            .cf:after{
                clear:both;
            }

            .cf{
                zoom:1;
            }
            /* Form wrapper styling */

            .search-wrapper {
                width: 650px;
                margin: 10px auto 50px auto;
                border-radius: 20px;
                background: transparent;
                box-shadow: 0 4px 20px -2px #e9e9e9;

            }

            /* Form text input */

            .search-wrapper input {
                padding-left: 20px;
                width: 500px;
                height: 20px;
                padding: 10px 5px;
                float: left;
                font: bold 13px 'lucida sans', 'trebuchet MS', 'Tahoma';
                border: 0;
                background: #fff;
                border-radius: 40px;
                border-top-style: none;

            }

            .search-wrapper input:focus {
                outline: 0;
                background: #fff;
                box-shadow: 0 0 2px rgba(0,0,0,0.8) inset;
            }

            .search-wrapper input::-webkit-input-placeholder {
                color: #999;
                font-weight: normal;
                font-style: italic;
                padding-left: 20px;
            }

            .search-wrapper input:-moz-placeholder {

                color: #999;
                font-weight: normal;
                font-style: italic;
            }

            .search-wrapper input:-ms-input-placeholder {
                color: #999;
                font-weight: normal;
                font-style: italic;
                border-style: none;
            }

            /* Form submit button */
            .search-wrapper button {
                overflow: visible;
                position: relative;
                float: right;
                border: 0;
                padding: 0;
                cursor: pointer;
                height: 40px;
                width: 110px;
                font: 13px/40px 'lucida sans', 'trebuchet MS', 'Tahoma';
                color: #fff;
                text-transform: uppercase;
                background: #198cff;
                border-radius: 40px;
                text-shadow: 0 -1px 0 rgba(0, 0 ,0, .3);

            }

            .search-wrapper button:hover{
                /*     background: #e54040; */
            }

            .search-wrapper button:active,
            .search-wrapper button:focus{
                background: #198cff;
                outline: 0;
            }

            .search-wrapper button:focus:before,
            .search-wrapper button:active:before{
                border-right-color: #c42f2f;
            }

            .search-wrapper button::-moz-focus-inner { /* remove extra button spacing for Mozilla Firefox */
                border: 0;
                padding: 0;
            }
            h1 a{
                text-decoration:none;
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
        </style>
    </head>
    <body>
        <h1 style="text-align: center" ><a href="list-product">PRODUCT LIST</a></h1>

        <%
        String m = (String)request.getAttribute("msg");
        if(m != null) {
    
        %>
        <script src="js/Note.js" type="text/javascript"></script>
        <%
            }
        %>
        <form action="search?index=1" method="POST" class="search-wrapper cf">
            <div>
                <input type="text" name="search" size="40" width="100" placeholder="Text..." required style="box-shadow: none"/>
                <button type="submit">SEARCH</button>     
            </div>

        </form>

    <center>
        <table border="1" width="100%" style="text-align: center">
            <tr><td>ID</td><td>Name</td><td>Price</td><td>UnitsInStock</td><td>ReorderLevel</td><td>Judge</td><td>Function</td></tr>

            <c:forEach items="${product}" var="p">
                <tr>
                    <td>${p.getProductID()}</td>
                    <td>${p.getProductName()}</td>
                    <td><c:if test="${p.getUnitPrice() < 3}">
                            <h3 style="color: red">Poor</h3>
                        </c:if>
                        <c:if test="${p.getUnitPrice() > 3}">
                            ${p.getUnitPrice()}
                        </c:if>
                    </td>
                    <td>${p.getUnitsInStock()}</td>
                    <td><c:out value="${p.getReorderLevel()}"/></td>
                    <td>
                        <c:choose>
                            <c:when test="${p.getUnitPrice()<=5 && p.getUnitPrice()>=0}">
                                <h3 style="color: red">Cheap</h3>
                            </c:when>

                            <c:when test="${p.getUnitPrice()<=20}">
                                <h3 style="color: blue">So So</h3>
                            </c:when>
                            <c:when test="${p.getUnitPrice() <= 200}">
                                <h3 style="color: purple">Expensive</h3>
                            </c:when>
                            <c:when test="${p.getUnitPrice() > 200}">
                                <h3 style="color: purple">Luxury</h3>
                            </c:when>    
                            <c:otherwise>
                                Normal
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a href="edit?id=${p.getProductID()}">Edit</a>

                        <a href="del?id=${p.getProductID()}">Delete</a>
                    </td>
                </tr>
            </c:forEach>           
        </table>
    </center>
    <div style="text-align: center;">
    <div class="pagination">
        <c:forEach begin="1" end="${endPage}" var="i">
            <a href="list-product?index=${i}">${i}</a>
        </c:forEach>
    </div>
        </div>


</body>
</html>
