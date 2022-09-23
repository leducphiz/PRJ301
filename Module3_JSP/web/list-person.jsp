<%-- 
    Document   : List-Person
    Created on : Sep 23, 2022, 8:14:46 AM
    Author     : leducphi
--%>

<%@page import = "DAL.Person"%>
<%@page import = "java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<Person> list = new ArrayList<>();
            list.add(new Person("Phi Le"));            
            list.add(new Person("Phi Le12"));
            list.add(new Person("Phi Le3"));

        %>
        
        <ul>
            <%
                for(Person p : list){
                    %>
                        <li><%= p.name%></li>
                    <%
                }
            %>
        </ul>
    </body>
</html>
