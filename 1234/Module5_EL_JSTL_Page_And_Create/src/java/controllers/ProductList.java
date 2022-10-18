package controllers;

import dal.CategoryDAO;
import models.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import dal.ProductDAO;
import models.Category;

public class ProductList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int page = 0;
            try {
                page = Integer.parseInt(req.getParameter("page"));
            } catch (Exception e) {
                page = 1;
            }
            // check sau khi insert neu khong phai page 1 thi se khong in ra cai product vua add vao 
            if (page != 1) {
                Product newProduct = null;
                req.getSession().setAttribute("newProduct", newProduct);
            }
            ProductDAO dao = new ProductDAO();           
            int elements = 20;
            ArrayList<Product> products = dao.getProductsByPage(page, elements);          
            int numberOfPage = dao.getAllProducts().size() % elements == 0 ? dao.getAllProducts().size() / elements : dao.getAllProducts().size() / elements + 1;
            ArrayList<Category> categories = new CategoryDAO().getAllCategory();  
            req.setAttribute("categories", categories);
            req.setAttribute("products", products);
            req.setAttribute("page", page);
            req.setAttribute("numberOfPage", numberOfPage);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (Exception e) {
        }
    }

}
