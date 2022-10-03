<%@page import="models.*" %>
<%@page import="controllers.*" %>
<%@page import="DAL.*" %>
<%@page import="java.util.*" %>
<%@include file="./template/header.jsp" %>
<div id="content">
    <div id="content-left">
        <h3>CATEGORY</h3>
        <ul>
            <%
                ArrayList<Category> categoryList = new CategoryDAO().getCategory();
                
                for(Category item: categoryList){
            %>
            <a class="category-item" href="product-list?category-id=<%=item.getCategoryID()%>"><li><%=item.getCategoryName()%></li></a>          
                    <%
                        }
                    %>
        </ul>
    </div>
    <div id="content-right">
        <%
            String cateDesc = (String)request.getAttribute("cateDesc");
            String categoryName = (String)request.getAttribute("input-category-name");
            ArrayList<Product> productList = (ArrayList<Product>)request.getAttribute("input-product-list");
        %>
        <div class="path"><%=categoryName%></br></div> 
        
        <div class="content-main">
            <%
            int size = 0;
            for(Product item: productList){             
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
            %>
            <%
                    if(size > 5){
            %>               
            <button class="show-more-hot">Show more</button>
            <%}%>
        </div>
    </div>
</div>
<script src="./js/main.js"></script>
<%@include file="./template/footer.jsp" %>
