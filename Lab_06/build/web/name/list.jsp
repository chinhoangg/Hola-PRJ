<%-- 
    Document   : list
    Created on : Mar 7, 2022, 8:17:11 AM
    Author     : chinhoag
--%>

<%@page import="java.util.List"%>
<%@page import="model.Name"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Name</title>
        <style>
            .text{
                text-align: center;
                width: 150px;
            }
            .num{
                text-align: center;
                width: 50px;
            }
        </style>  
    </head>
    <body>
        <%try {%>
        <c:if test="${param.page!=null}">
            <c:set scope="page" var="first" value="<%=(Integer.parseInt(request.getParameter("page")) - 1) * 15%>"/>
            <c:set scope="page" var="second" value="<%=Integer.parseInt(request.getParameter("page")) * 15 < ((List) request.getAttribute("list")).size()
                    ? Integer.parseInt(request.getParameter("page")) * 15 - 1 : ((List) request.getAttribute("list")).size() - 1%>"/>
        </c:if>
        <c:if test="${param.page==null}">
            <c:set scope="page" var="first" value="0"/>
            <c:set scope="page" var="second" value="<%= ((List) request.getAttribute("list")).size() <= 15 ? ((List) request.getAttribute("list")).size(): 4%>"/>
        </c:if>
        <table border="1px solid black">
            <tr>
                <th class="num">ID</th>
                <th class="text">Name</th>
            </tr>
            <c:forEach items="${list}" begin="${first}" end="${second}" var="n" step="1">
                <tr>
                    <td class="num">${n.getID()}</td>
                    <td class="text">${n.getName()}</td>
                </tr>
            </c:forEach>   
        </table>
        <nav>
            <%for (int i = 1; i <= (Integer)request.getAttribute("listS"); i++) {%>
            <a href="list?page=<%=i%>"><%= i%></a>
            <%}%>
        </nav>
        <%} catch (NullPointerException e) {
                response.sendRedirect("list");
            }%>
    </body>
</html>
