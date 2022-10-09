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
public class DelInfor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ID = (req.getParameter("id"));
        int IDdel;
        try {
            IDdel = Integer.parseInt(ID);
            ProductDAO p = new ProductDAO();
            p.deleteOrderDetail(IDdel);
            p.deletePro(IDdel);
            resp.sendRedirect("list-product");
        } catch (IOException | NumberFormatException e) {
        }
    }

}
