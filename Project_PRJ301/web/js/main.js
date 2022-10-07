/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

var showMoreHot = document.querySelector(".show-more-hot");
var moreHotProducts = document.querySelectorAll(".product.more-hot-product");

var showMoreSale = document.querySelector(".show-more-sale");
var moreSaleProducts = document.querySelectorAll(".product.more-sale-product");

var showMoreNew = document.querySelector(".show-more-new");
var moreNewProducts = document.querySelectorAll(".product.more-new-product");

showMoreHot.addEventListener('click', function () {

    if (showMoreHot.innerHTML === "Show more") {
        showMoreHot.innerHTML = "Show less";
        for (var i in moreHotProducts) {
            moreHotProducts[i].style.display = 'block';
        }
    }

    if (showMoreHot.innerHTML === "Show less") {
        showMoreHot.innerHTML = "Show more";
        for (var i in moreHotProducts) {
            moreHotProducts[i].style.display = 'none';
        }
    }
}
);
showMoreSale.addEventListener('click', function () {
    if (showMoreSale.innerHTML === "Show more") {
        showMoreSale.innerHTML = "Show less";
        for (var i in moreSaleProducts) {
            moreSaleProducts[i].style.display = 'block';
        }
    }

    if (showMoreSale.innerHTML === "Show less") {
        showMoreSale.innerHTML = "Show more";
        for (var i in moreSaleProducts) {
            moreSaleProducts[i].style.display = 'none';
        }
    }
}
);

showMoreNew.addEventListener('click', function () {

    if (showMoreNew.innerHTML === "Show more") {
        showMoreNew.innerHTML = "Show less";
        for (var i in moreNewProducts) {
            moreNewProducts[i].style.display = 'block';
        }
    }

    if (showMoreNew.innerHTML === "Show less") {
        showMoreNew.innerHTML = "Show more";
        for (var i in moreNewProducts) {
            moreNewProducts[i].style.display = 'none';
        }
    }
}
);

function updateInfo() {
    if(confirm("confirm")) {
        window.location="profile?id=";
    }
}


