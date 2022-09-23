<%-- 
    Document   : receive_request
    Created on : Sep 21, 2022, 8:37:44 AM
    Author     : leducphi
--%>

<%@page import="DAL.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--su dung sytax scriptlet de tiep nhan va tra ve gia tri cu the-->
        <%
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));

            Person p = new Person("leducphi");

            out.println("Name: " + name  + "Age: " + age);
            out.println(p);
//            response.getWriter().write("hehe");
            public String displayPerson(){
                return p.toString;
            }
        %>
        
        
        
        <div>
            <%=displayPerson()%>
        </div>
    </body>
</html>
