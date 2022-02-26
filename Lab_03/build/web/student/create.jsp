<%-- 
    Document   : create
    Created on : Jan 26, 2022, 4:30:49 PM
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
        <form action="create" method="post">
            <table>
                <tr>
                    <td>Name:</td>
                    <td>
                        <input type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td>Gender:</td>
                    <td>
                        <input type="radio" name="gender" value="1">Male
                        <input type="radio" name="gender" value="0">Female
                    </td>
                </tr>
                <tr>
                    <td>DOB:</td>
                    <td><input type="text" name="dob"</td>
                </tr>
                <tr>
                    <td><button type="submit">Create</button></td>
                </tr>
            </table>
        </form>
    </body>

</html>
