
package controllers;

import dal.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import models.ProductDAO;

public class ProductList extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Product> products = new ProductDAO().getAllProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher("./index.jsp").forward(req, resp);
    }
    
}
