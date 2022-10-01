<%-- 
    Document   : login
    Created on : Sep 30, 2022, 8:15:45 AM
    Author     : leducphi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="color: red">
            <%
                if(request.getAttribute("msg") != null){
                    out.print(request.getAttribute("msg"));
                }
            %>
        </div>
        <form action="login" method="post">
            Email: <input type="text" name="txtEmail"/><br>
            Password: <input type="password" name = "txtPass"/></br>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
