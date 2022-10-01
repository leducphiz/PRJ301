/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAL.Category;
import DAL.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import models.CategoryDAO;
import models.ProductDAO;

/**
 *
 * @author Admin
 */
public class ProductListController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int categoryID = Integer.parseInt(req.getParameter("category-id"));
        String categoryName = "";
        ArrayList<Product> productList = new ProductDAO().getProducts();
        ArrayList<Category> categoryList = new CategoryDAO().getCategory();
        ArrayList<Product> output = new ArrayList<Product>();
        String categoryDescription = "";
        for (Product item : productList) {
            if (item.getCategoryID() == categoryID) {
                output.add(item);
            }
        }
        for (Category item : categoryList) {
            if (item.getCategoryID() == categoryID) {
                categoryName = item.getCategoryName();
                categoryDescription = item.getDescription();
            }
        }
        req.setAttribute("cateDesc", categoryDescription);
        req.setAttribute("input-category-name", categoryName);
        req.setAttribute("input-product-list", output);
//        resp.getWriter().println(categoryID);
        req.getRequestDispatcher("category.jsp").forward(req, resp);
    }
    
}
