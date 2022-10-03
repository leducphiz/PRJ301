<%@page import="DAL.*" %>
<%@page import="controllers.*" %>
<%@page import="models.*" %>
<%@page import="java.util.ArrayList" %>
<%@include file="./template/header.jsp" %>

<div id="content">
    <div id="content-left">
        <h3>CATEGORY</h3>
        <ul>
            <%
                ArrayList<Category> categoryList = new CategoryDAO().getCategory();
                ArrayList<Product> productlist = new ProductDAO().getProducts();
                for(Category item: categoryList){
            %>
            <a class="category-item" href="product-list?category-id=<%=item.getCategoryID()%>"><li><%=item.getCategoryName()%></li></a>          
                    <%
                        }
                    %>
        </ul>
    </div>
    <div id="content-right">
        <div class="path">Hot</b></div>      
        <div class="content-main">
            <%
            int size = 0;
            for(Product item: productlist){
                if(item.getReorderLevel() >= 15){
                    size++;
                    if(size > 5){
            %>
            <div class="product more-hot-product">
                <a href="detail.jsp?product-name=<%=item.getProductName()%>&category-id=<%=item.getCategoryID()%>&model=<%=item.getProductID()%>"><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="detail.jsp?product-name=<%=item.getProductName()%>&category-id=<%=item.getCategoryID()%>&model=<%=item.getProductID()%>"><%=item.getProductName()%></a></div>
                <div class="price"><%=item.getUnitPrice()%></div>
                <div><a href="">Buy now</a></div>
            </div>
            <%        
                }else{
            %>      

            <div class="product">
                <a href="detail.jsp?product-name=<%=item.getProductName()%>&category-id=<%=item.getCategoryID()%>&model=<%=item.getProductID()%>"><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="detail.jsp?product-name=<%=item.getProductName()%>&category-id=<%=item.getCategoryID()%>&model=<%=item.getProductID()%>"><%=item.getProductName()%></a></div>
                <div class="price"><%=item.getUnitPrice()%></div>
                <div><a href="">Buy now</a></div>
            </div>

            <%
                        }
                    }
                }
            %>
            <%
                    if(size > 5){
            %>               
            <button class="show-more-hot">Show more</button>
            <%}%>
        </div>
        <div class="path">Best Sale</b></div>
        <div class="content-main">
            <%
             size = 0;
            for(Product item: productlist){
                if(item.isDiscontinued()){
                    size++;
                    if(size > 5){
            %>
            <div class="product more-sale-product">
                <a href="detail.jsp?product-name=<%=item.getProductName()%>&category-id=<%=item.getCategoryID()%>&model=<%=item.getProductID()%>"><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="detail.jsp?product-name=<%=item.getProductName()%>&category-id=<%=item.getCategoryID()%>&model=<%=item.getProductID()%>"><%=item.getProductName()%></a></div>
                <div class="price"><%=item.getUnitPrice()%></div>
                <div><a href="">Buy now</a></div>
            </div>
            <%        
                }else{
            %>      

            <div class="product">
                <a href="detail.jsp?product-name=<%=item.getProductName()%>&category-id=<%=item.getCategoryID()%>&model=<%=item.getProductID()%>"><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="detail.jsp?product-name=<%=item.getProductName()%>&category-id=<%=item.getCategoryID()%>&model=<%=item.getProductID()%>"><%=item.getProductName()%></a></div>
                <div class="price"><%=item.getUnitPrice()%></div>
                <div><a href="">Buy now</a></div>
            </div>

            <%
                        }
                    }
                }
            %>
            <%
                    if(size > 5){
            %>               
            <button class="show-more-sale">Show more</button>
            <%}%>
        </div>
        <div class="path">New Product</b></div>
        <div class="content-main">
            <%
            size = 0;
           for(Product item: productlist){
               if(item.getUnitsInStock() >= 100){
                   size++;
                   if(size > 5){
            %>
            <div class="product more-new-product">
                <a href="detail.jsp?product-name=<%=item.getProductName()%>&category-id=<%=item.getCategoryID()%>&model=<%=item.getProductID()%>"><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="detail.jsp?product-name=<%=item.getProductName()%>&category-id=<%=item.getCategoryID()%>&model=<%=item.getProductID()%>"><%=item.getProductName()%></a></div>
                <div class="price"><%=item.getUnitPrice()%></div>
                <div><a href="">Buy now</a></div>
            </div>
            <%        
                }else{
            %>      

            <div class="product">
                <a href="detail.jsp?product-name=<%=item.getProductName()%>&category-id=<%=item.getCategoryID()%>&model=<%=item.getProductID()%>"><img src="img/1.jpg" width="100%"/></a>
                <div class="name"><a href="detail.jsp?product-name=<%=item.getProductName()%>&category-id=<%=item.getCategoryID()%>&model=<%=item.getProductID()%>"><%=item.getProductName()%></a></div>
                <div class="price"><%=item.getUnitPrice()%></div>
                <div><a href="">Buy now</a></div>
            </div>

            <%
                        }
                    }
                }
            %>
            <%
                    if(size > 5){
            %>               
            <button class="show-more-new">Show more</button>
            <%}%>
        </div>
    </div>
</div>
<script src="js/main.js"></script>
<%@include file="./template/footer.jsp" %>

