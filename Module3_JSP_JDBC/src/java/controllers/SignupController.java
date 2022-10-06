/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAL.Account;
import DAL.Customers;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;
import models.AccountDAO;

/**
 *
 * @author leducphi
 */
public class SignupController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String CustomerID = randomString(5);
        String CompanyName = req.getParameter("txtCopName");
        String ContactName = req.getParameter("txtCName");
        String Tittle = req.getParameter("txtTitle");
        String Address = req.getParameter("txtAddress");
        String Email = req.getParameter("txtEmail");
        String Pass = req.getParameter("txtPass");

        Customers cus = new Customers(CustomerID, CompanyName, ContactName, Tittle, Address, "", Email);
        Account acc = new Account(0, Email, Pass, CustomerID, 0, 0);

        if (new AccountDAO().AddAccount(acc, cus) > 0) {
            resp.sendRedirect(req.getContextPath() + "/signin.jsp");
        } else {
            resp.sendRedirect(req.getContextPath() + "/signup.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("AccSession") == null) {
            req.getRequestDispatcher("../signup.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher(req.getContextPath() + "/index.jsp").forward(req, resp);
        }
    }

    private String randomString(int length) {
        Random random = new Random();
        String setOfCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ab = "";
        String abc = "";
        for (int i = 0; i < length; i++) {
            ab = Character.toString(setOfCharacters.charAt(random.nextInt(setOfCharacters.length())));
            abc += ab;
        }
        return abc;
    }

}
