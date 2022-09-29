<%@include file="template/header.jsp" %>
<%@page import="java.util.ArrayList" %>
<%@page import="models.CategoryDAO" %>
<%@page import="dal.Category" %>
<%@page import="models.ProductDAO" %>
<%@page import="dal.Product" %>
<div id="content">
    <div id="content-left">
        <h3>CATEGORY</h3>
        <ul>
            <%
                ArrayList<Category> cateList = new CategoryDAO().getCategorys();
                for(Category c : cateList){
            %>
            <a href="#"><li><%=c.getCategoryName() %></li></a>
                    <%
                    }
                    %>
        </ul>
    </div>
    <div id="content-right">
        <div class="path">Hot</b></div>
        <div class="content-main">
            <%
                // lay du lieu tu controller chuyen sang
                ArrayList<Product> list = new ProductDAO().getProducts();
                for(Product p : list){
            %>
            <div class="product">
                <a href="detail.jsp"><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="detail.jsp"><%=p.getProductName()%></a></div>
                <div class="price"><%=p.getUnitPrice()%></div>
                <div><a href="">Buy now</a></div>
            </div>
            <%
            }
            %>
        </div>
        <div class="path">Best Sale</b></div>
        <div class="content-main">
            <div class="product">
                <a href="detail.html"><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="detail.jsp">Product 1</a></div>
                <div class="price">$1000</div>
                <div><a href="">Buy now</a></div>
            </div>
            <div class="product">
                <a href=""><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="">Product 1</a></div>
                <div class="price">$1000</div>
                <div><a href="">Buy now</a></div>
            </div>
            <div class="product">
                <a href=""><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="">Product 1</a></div>
                <div class="price">$1000</div>
                <div><a href="">Buy now</a></div>
            </div>
            <div class="product">
                <a href=""><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="">Product 1</a></div>
                <div class="price">$1000</div>
                <div><a href="">Buy now</a></div>
            </div>
        </div>
        <div class="path">New Product</b></div>
        <div class="content-main">
            <div class="product">
                <a href="detail.html"><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="detail.jsp">Product 1</a></div>
                <div class="price">$1000</div>
                <div><a href="">Buy now</a></div>
            </div>
            <div class="product">
                <a href=""><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="">Product 1</a></div>
                <div class="price">$1000</div>
                <div><a href="">Buy now</a></div>
            </div>
            <div class="product">
                <a href=""><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="">Product 1</a></div>
                <div class="price">$1000</div>
                <div><a href="">Buy now</a></div>
            </div>
            <div class="product">
                <a href=""><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="">Product 1</a></div>
                <div class="price">$1000</div>
                <div><a href="">Buy now</a></div>
            </div>
        </div>
    </div>
</div>
<%@include file="template/header.jsp" %>