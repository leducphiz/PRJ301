<%-- 
    Document   : jsp_syntax
    Created on : Sep 21, 2022, 8:13:59 AM
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
        <!--Declare in java--> 
        <%!
            //Declare a variable
            String roll = "HE163212";
            String name = "Le Duc Phi";
                    
            //Declare an objects
            //Person p = new Person();
            
            // Declare a function / methods
            public String displayStudent(){
                return "Roll: " + roll + ", Name: " + name;
            }
            
        %>
        
        <h3>
            <!--Embed JAVA expression-->
            Welcome : <%= displayStudent() %>
        </h3>
        
    </body>
</html>


