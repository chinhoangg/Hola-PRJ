<%-- 
    Document   : list
    Created on : Jan 26, 2022, 3:41:04 PM
    Author     : chinhoag
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Student"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Student</title>
        <%
           ArrayList<Student> students = (ArrayList<Student>)request.getAttribute("listS");
       %>
    </head>
    <body>
        <%try {%>
            <table border="1px solid black">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>DOB</th>
                </tr>
            <% for (Student s : students) { %> 
                <tr>
                    <td> <%=s.getId() %></td>
                    <td> <%=s.getName() %></td>
                    <td>
                        <%if(s.getGender() == 1) {%>
                                Male
                        <%}%>        
                        <%if(s.getGender() == 0) {%>
                                Female
                        <%}%> 
                    </td>
                    <td> <%=s.getDOB() %></td>
                    <td>
                        <a href="update?sid=<%=s.getId() %>">update</a>
                        <a href="#" onclick="showMess(<%=s.getId() %>)">delete</a>
                    </td>
                </tr>
            <%}%>
            </table>
                <a href="create.jsp">Create student</a>   
        <%} catch (NullPointerException e) {
                   response.sendRedirect("list");
            }%>
    </body>
    <script>
        function showMess(id){
            var option = confirm('Really');
            if(option === true){
                window.location.href = 'delete?sid='+id;
            } 
        }   
    </script>

</html>
