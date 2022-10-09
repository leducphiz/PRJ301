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
import models.ProductDAO;

/**
 *
 * @author leducphi
 */
public class Update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Name = req.getParameter("Name");
        double Price = Double.parseDouble(req.getParameter("Price"));
        int ID =(int)req.getSession().getAttribute("id");
        try {
            Product p = new Product(ID, Name, Price);
            ProductDAO x = new ProductDAO();
            x.UpdateProduct(p);
            resp.sendRedirect("index");
        } catch (IOException e) {
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ID = Integer.parseInt(req.getParameter("id"));
        try {
            Product product = new ProductDAO().getProductByID(ID);
            req.getSession().setAttribute("id", ID);
            req.getSession().setAttribute("Prod", product);
            req.getRequestDispatcher("Update.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
        }
    }

}
