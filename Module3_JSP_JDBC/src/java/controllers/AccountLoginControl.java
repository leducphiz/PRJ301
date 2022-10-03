/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAL.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.AccountDAO;

/**
 *
 * @author leducphi
 */
public class AccountLoginControl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("txtEmail");
        String pass = req.getParameter("txtPass");
        Account acc = new AccountDAO().getAccount(email, pass);
        if (acc != null) {
            //cap session
            req.getSession().setAttribute("AccSession", acc);
            //dieu huong toi index
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        } else {
            // else thi gui thong diep error ve doGet(login.jsps)
            req.setAttribute("msg", "Account not exist");
            req.getRequestDispatcher("/signin").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("../signin.jsp").forward(req, resp);
    }

}
