
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Calculate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = Integer.parseInt(req.getParameter("txtA"));
        int b = Integer.parseInt(req.getParameter("txtB"));
        int sum = a + b;
        resp.getWriter().print("Sum:" + a + "+" + b + "=" + sum);

    }

    /**
     * *
     * Phuong thuc xu ly cac request tu client gui len bang phuong thuc get
     *
     * @param req doi tuong tiep nhan du lieu tu web client
     * @param resp doi tuong tra ve noi dung cho web client
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Nhan du lieu tu web ve
        String name = req.getParameter("name");
        //Hien thi ket qua
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print("welcome: " + name);

    }

}
