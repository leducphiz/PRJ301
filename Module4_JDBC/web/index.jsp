<%-- 
    Document   : index
    Created on : Sep 30, 2022, 9:02:23 AM
    Author     : leducphi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dal.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Black Page</title>
    </head>
    <body>
        <%
            if(request.getSession().getAttribute("AccSession")!= null){
                Account acc = (Account) request.getSession().getAttribute("AccSession");
                out.println("Welcome " + acc.getEmail());
            }
        %>
    </body>
</html>
