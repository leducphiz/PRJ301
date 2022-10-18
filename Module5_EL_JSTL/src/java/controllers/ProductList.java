package controllers;

import dal.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import models.ProductDAO;

public class ProductList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ProductDAO pDao = new ProductDAO();
            ArrayList<Product> products = new ProductDAO().getProducts();
            //req.getSession().setAttribute("product", products);
            int count = pDao.countProductList();

            int sizePage = 10;
            int endPage = 0;
            endPage = count / sizePage;
            if (count % sizePage != 0) {
                endPage++;
            }
            int index;
            String inS = req.getParameter("index");
            if(inS == null) {
                index = 1;
            } else {
                index = Integer.parseInt(inS);
            }
            
            ArrayList<Product> product = pDao.PageSize(index, sizePage);

            req.setAttribute("product", product);

            req.setAttribute("endPage", endPage);
            //req.setAttribute("search", search);
            req.setAttribute("products", products);
            req.getSession().getAttribute("msg");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (Exception e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ProductDAO pDao = new ProductDAO();
            ArrayList<Product> products = new ProductDAO().getProducts();
            //req.getSession().setAttribute("product", products);
            int count = pDao.countProductList();
            resp.sendRedirect("index.jsp");
            String inS = req.getParameter("index");
            int index = Integer.parseInt(inS);

            int sizePage = 10;
            int endPage = 0;
            endPage = count / sizePage;
            if (count % sizePage != 0) {
                endPage++;
            }

            ArrayList<Product> product = pDao.PageSize(index, sizePage);

            req.setAttribute("product", product);

            req.setAttribute("endPage", endPage);
            //req.setAttribute("search", search);
            req.setAttribute("products", products);
            req.getSession().getAttribute("msg");

            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (Exception e) {
        }

    }

}
