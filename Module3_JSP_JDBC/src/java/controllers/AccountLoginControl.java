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
        String msgEmail = "";
        String msgPass = "";

        if (email.equals("")) {
            msgEmail = "Email is requied";
            req.setAttribute("msgEmail", msgEmail);
        }

        if (email.equals("")) {
            msgPass = "Password is requied";
            req.setAttribute("msgPass", msgPass);
        }

        if (!msgEmail.equals("") || !msgPass.equals("")) {
            req.getRequestDispatcher(req.getContextPath() + "/signin.jsp").forward(req, resp);
        } else {

            Account acc = new AccountDAO().getAccount(email, pass);
            if (acc != null) {
                //cap session
                req.getSession().setAttribute("AccSession", acc);
                //dieu huong toi index
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
            } else {
                // else thi gui thong diep error ve doGet(login.jsps)
                req.setAttribute("msg", "Account not exist");
                req.getRequestDispatcher("../signin.jsp").forward(req, resp);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("AccSession") != null) {
            req.getSession().removeAttribute("AccSession");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        } else {
            req.getRequestDispatcher("../signin.jsp").forward(req, resp);
        }
    }

}
