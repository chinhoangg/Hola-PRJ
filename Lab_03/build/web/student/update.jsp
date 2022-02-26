<%-- 
    Document   : update
    Created on : Jan 26, 2022, 8:45:56 PM
    Author     : chinhoag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="update" method="post">
            <table>
                <tr>
                    <td>ID:</td>
                    <td>
                        <input type="text" name="id" value="${st.id}" readonly>
                    </td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td>
                        <input type="text" name="name" value="${st.name}">
                    </td>
                </tr>
                <tr>
                    <td>Gender:</td>
                    <td>
                        <input type="radio" name="gender" value="1" ${st.gender == 1?"checked":""}>Male
                        <input type="radio" name="gender" value="0" ${st.gender == 0?"checked":""}>Female
                    </td>
                </tr>
                <tr>
                    <td>DOB:</td>
                    <td><input type="text" name="dob" value="${st.DOB}"></td>
                </tr>
                <tr>
                    <td><button type="submit">Update</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
