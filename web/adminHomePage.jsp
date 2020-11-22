<%-- 
    Document   : adminHomePage
    Created on : Sep 7, 2020, 9:16:45 PM
    Author     : Sachindra Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>National Consumer Complaint Reporting Portal</title>
        <link type="text/css" rel="stylesheet" href="CSS/adminHomePage.css">
        <link rel="icon" type="image/png" href="images/icon1.png">
    </head>
    <body>

        <h1>National Consumer Complaint Reporting Portal</h1>
        <div class="username">
            <% 
                String usernameID = (String) session.getAttribute("uname");
                out.println("Welcome "+usernameID);
            %>
        </div>
        <div class="container">
        <a href="AdminsHomePage">
            <button class="button">Manage Complaints</button>
        </a><br>
        <br>
        <br>
        <a href="DeleteUser">
            <button class="button">Manage Users</button>           
        </a><br>
        <br>
        <br>
        <a href="registerEmployees.html">
            <button class="button">Add Fellow Employees</button>
        </a><br>
        <br>
        <br>
        <a href="logoutServlet">
            <button class="button">Sign Out</button>  
        </a>
        </div>
    </body>
</html>

