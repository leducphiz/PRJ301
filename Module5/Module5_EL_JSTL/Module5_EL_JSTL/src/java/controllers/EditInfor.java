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
 * @author Anh
 */
public class EditInfor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idd = (req.getParameter("id"));
        int id;
        try {
            id = Integer.parseInt(idd);
            Product p = new ProductDAO().getProductByID(id);
            req.getSession().setAttribute("id", id);
            
            req.getSession().setAttribute("proD", p);
            req.getRequestDispatcher("update.jsp").forward(req, resp);
        } catch (ServletException | IOException | NumberFormatException e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Name = req.getParameter("Name");
        double Price = Double.parseDouble(req.getParameter("Price"));
        int id =(int)req.getSession().getAttribute("id");
        ProductDAO proD = new ProductDAO();
        try {           
            Product p = new Product();
            p.setProductID(id);
            p.setProductName(Name);
            p.setUnitPrice(Price);
            proD.updatePro(p);
            resp.sendRedirect("list-product");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    

}
