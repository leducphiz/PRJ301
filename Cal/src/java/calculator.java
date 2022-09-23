
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author leducphi
 */
public class calculator extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        double a = Double.parseDouble(req.getParameter("first"));
        double b = Double.parseDouble(req.getParameter("second"));
        double r = 0;
        String opera = req.getParameter("operator");

        if (opera.equalsIgnoreCase("plus")) {
            r = a + b;
        } else if (opera.equalsIgnoreCase("minus")) {
            r = a - b;
        } else if (opera.equalsIgnoreCase("mul")) {
            r = a / b;
        } else if (opera.equalsIgnoreCase("div")) {
            r = a * b;
        }

        req.setAttribute("first", a);
        req.setAttribute("second", b);
        req.setAttribute("operator", opera);
        req.setAttribute("result", r);

        req.getRequestDispatcher("index.jsp").include(req, resp);
    }

}
