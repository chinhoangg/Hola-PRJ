<%-- 
    Document   : student
    Created on : Jan 17, 2022, 9:40:48 PM
    Author     : chinhoag
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Information Student</title>
    </head>
    <body>
        <form action = "StudentServlet" method="POST">
            Number of Students:
            <input type="text" name="id" size="20"/>
            <input type="submit" value="Generate"/>

            <%if (request.getAttribute("generate") != null) {%>
            <br><br>
            <table border = "1">
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Gender</td>
                    <td>DOB</td>
                </tr>
                
                <%
                    ArrayList<Student> list = (ArrayList<Student>) request.getAttribute("generate");
                    SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyy");
                    if (list != null) {
                        for (Student s : list) {
                %>
                
                <tr>
                    <td> <%= s.getId()%> </td>
                    <td> <%= s.getName()%> </td>
                    <% if (s.isGender()) { %>
                    <td><input type="checkbox" checked disabled/></td>
                        <% }else{ %>
                    <td><input type="checkbox" disabled/></td>
                        <%}%>                   
                    <td> <%= formatDate.format(s.getDOB())%> </td>
                </tr>
                    <%}%>
                <%}%>
            <%}%>
            </table>
        </form>

    </body>
</html>
