
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author leducphi
 */
public class checkLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String user = req.getParameter("user");
        String pass = req.getParameter("password");
        String uData = getInitParameter("user");
        String pData = getInitParameter("password");

        if (user.equalsIgnoreCase(uData) && pass.equalsIgnoreCase(pData)) {
            RequestDispatcher rs = req.getRequestDispatcher("WelcomServlet");
            rs.forward(req, resp);
        } else {
            resp.sendRedirect("index.html");
        }
    }

}
