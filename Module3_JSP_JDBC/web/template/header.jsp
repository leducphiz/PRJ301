<%@page import="DAL.*" %>
<%@page import="controllers.*" %>
<%@page import="models.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="DTO.*" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Index</title>
        <% String path =request.getContextPath();%>
        <link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <div id="logo">
                    <a href="<%=path%>/index.jsp"><img src="<%=path%>/img/logo.png"/></a>
                </div>
                <div id="banner">
                    <ul>
                        <li><a href="cart.jsp">Cart:0</a></li>
                            <%
                                if(session.getAttribute("AccSession")==null){
                            %>
                        <li><a href="<%=path%>/account/signin">Sign In</a></li>
                        <li><a href="<%=path%>/account/signup">Sign Up</a></li>
                            <% 
                                }else{
                                    Account acc = (Account) request.getSession().getAttribute("AccSession");
                                    
                            %>
                        <li><a href="<%=path%>/account/profile?accountID=<%=acc.getAccountID() %>">Profile</a></li>
                        <li><a href="<%=path%>/account/signin">Sign Out</a></li>
                            <%
                                }
                            %>
                    </ul>
                </div>
            </div>
