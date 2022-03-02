<%-- 
    Document   : index
    Created on : Feb 27, 2022, 1:55:20 PM
    Author     : chinhoag
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%if (request.getAttribute("employeeArray") == null) {
                response.sendRedirect("ThirdServlet");
            }
        %>
        <h2>Employee(Array):</h2>
        <c:forEach items="${employeeArray}" varStatus="array" var="emp" >
            FirstName: ${emp.getName().getFirstName()} ___
            LastName: ${emp.getName().getLastName()} ___ 
            ZipCode: ${emp.getAddress().getZip()} ___ 
            City: ${emp.getAddress().getCity()} ___ 
            Street: ${emp.getAddress().getStreet()}
            <br>
    </c:forEach>

    <h2>String Name(ArrayList):</h2>
    <c:forEach items="${nameArrayList}" var="namee">
        <li>
            ${namee.getFirstName()}
            ${namee.getLastName()}
        </li>
    </c:forEach>
</body>
</html>