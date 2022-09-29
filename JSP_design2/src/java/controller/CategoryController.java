/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import models.CategoryDAO;

/**
 *
 * @author leducphi
 */
public class CategoryController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Category> cateList = new CategoryDAO().getCategorys();
        ArrayList<Category> cate_ID1 = new CategoryDAO().getCategorysID_1();
        req.setAttribute("categorys", cateList);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
    
}
