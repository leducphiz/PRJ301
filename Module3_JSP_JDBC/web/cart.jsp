<%@include file="./template/header.jsp" %> 
<div id="content">
    <div id="cart">
        <div id="cart-title">
            <h3>SHOPPING CART</h3>
        </div>
        <div id="cart-content">
            <div class="cart-item">
                <div class="cart-item-infor">
                    <div class="cart-item-img">
                        <img src="img/1.jpg"/>
                    </div>
                    <div class="cart-item-name">
                        <a href="detail.html?id=1">Product 1</a>
                    </div>
                    <div class="cart-item-price">
                        1000 $
                    </div>
                    <div class="cart-item-button">
                        <a href="#">Remove</a>
                    </div>
                </div>
                <div class="cart-item-function">
                    <a href="#">-</a>  
                    <a href="#">+</a>
                    <input type="text" value="1" disabled/>
                </div>
            </div>
            <div class="cart-item">
                <div class="cart-item-infor">
                    <div class="cart-item-img">
                        <img src="img/1.jpg"/>
                    </div>
                    <div class="cart-item-name">
                        <a href="detail.html?id=1">Product 1</a>
                    </div>
                    <div class="cart-item-price">
                        1000 $
                    </div>
                    <div class="cart-item-button">
                        <a href="#">Remove</a>
                    </div>
                </div>
                <div class="cart-item-function">
                    <a href="#">-</a>  
                    <a href="#">+</a>
                    <input type="text" value="2" disabled/>
                </div>
            </div>
            <div class="cart-item">
                <div class="cart-item-infor">
                    <div class="cart-item-img">
                        <img src="img/1.jpg"/>
                    </div>
                    <div class="cart-item-name">
                        <a href="detail.html?id=1">Product 1</a>
                    </div>
                    <div class="cart-item-price">
                        1000 $
                    </div>
                    <div class="cart-item-button">
                        <a href="#">Remove</a>
                    </div>
                </div>
                <div class="cart-item-function">
                    <a href="#">-</a>  
                    <a href="#">+</a>
                    <input type="text" value="1" disabled/>
                </div>
            </div>
        </div>
        <div id="cart-order">
            <input type="button" value="ORDER"/>
        </div>
    </div>
</div>
<%@include file="./template/footer.jsp" %>