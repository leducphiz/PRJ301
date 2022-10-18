/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dal.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import models.ProductDAO;

/**
 *
 * @author Anh
 */
public class searchPro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");

        ProductDAO p = new ProductDAO();
        try {
//            ArrayList<Product> products = new ProductDAO().search(s);    
            int count = p.count(search);
            if (count == 0) {
                //resp.sendRedirect("index.jsp");
                resp.sendRedirect("list-product");
            }
            String inS = req.getParameter("index");

            int index = Integer.parseInt(inS);

            int sizePage = 10;
            int endPage = 0;
            endPage = count / sizePage;
            if (count % sizePage != 0) {
                endPage++;
            }

            ArrayList<Product> products = p.searchPageSize(search, index, sizePage);

            req.setAttribute("products", products);

            req.setAttribute("endPage", endPage);
            req.setAttribute("search", search);
            req.getRequestDispatcher("search_In4.jsp").forward(req, resp);
        } catch (Exception e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");

        ProductDAO p = new ProductDAO();
        try {
//            ArrayList<Product> products = new ProductDAO().search(s);    
            int count = p.count(search);
            if (count == 0) {
                
                req.setAttribute("msg", "Your information which you SEARCH is not available");
               resp.sendRedirect("list-product");
                //req.getRequestDispatcher("list-product").forward(req, resp);
            }
            String inS = req.getParameter("index");

            int index = Integer.parseInt(inS);

            int sizePage = 10;
            int endPage = 0;
            endPage = count / sizePage;
            if (count % sizePage != 0) {
                endPage++;
            }

            ArrayList<Product> products = p.searchPageSize(search, index, sizePage);

            req.setAttribute("products", products);

            req.setAttribute("endPage", endPage);
            req.setAttribute("search", search);
            req.getRequestDispatcher("search_In4.jsp").forward(req, resp);
        } catch (Exception e) {
        }
    }

}
