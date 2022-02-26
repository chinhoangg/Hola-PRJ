<%-- 
    Document   : detail
    Created on : Feb 25, 2022, 10:03:24 AM
    Author     : chinhoag
--%>

<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login successfull!</h1>
        <%
            Cookie[] cookies = request.getCookies();
            String n = "";
            String uname = null;
            String pass = null;
            for (Cookie cooky : cookies) {
                    if (cooky.getName().equals("cook")) {
                        n = cooky.getValue();
                        break;
                    }
            }
            if (request.getAttribute("username") != null) {
                n = ((Account) request.getAttribute("username")).getDisplayName();
            } 
        %>
        <h2 style = "color: red">Hello: <%= n %></h2>
    </body>
</html>
