<%-- 
    Document   : usersList
    Created on : Sep 9, 2020, 9:56:18 PM
    Author     : Sachindra Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>National Consumer Complaint Reporting Portal</title>
        <link type="text/css" rel="stylesheet" href="CSS/usersList.css">
        <link rel="icon" type="image/png" href="images/icon1.png">
        <script type="text/javascript">
            function myFunction()
            {
                alert("User removed successfully");
            }
        </script>
    </head>
    <body>
        <h3>Manage Users</h3>
        <table>
            <tr>
                <th>username</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            <tr>
                <c:forEach var="tempUser" items="${USERS_LIST}">
                    <c:url var="delete" value="DeleteUser">
                        <c:param name="command" value = "DELETE"/>
                        <c:param name="username" value="${tempUser.username}"/>
                    </c:url>
                    <td>${tempUser.username}</td>
                    <td>${tempUser.firstName}</td>
                    <td>${tempUser.lastName}</td>
                    <td>${tempUser.email}</td>
                    <td><a href="${delete}" onclick="myFunction()">Remove</a></td>
                </tr>
            </c:forEach>
        </table>
        <input type="button" value="Go back to home" onclick="
                window.location.href = 'adminHomePage.jsp';
                return false;" class="button button1"/>
    </body>
</html>

