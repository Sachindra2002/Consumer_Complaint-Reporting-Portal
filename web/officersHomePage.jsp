<%-- 
    Document   : officersHomePage
    Created on : Sep 7, 2020, 9:17:06 PM
    Author     : Sachindra Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>National Consumer Complaint Reporting Portal</title>
        <link type="text/css" rel="stylesheet" href="CSS/officerHomePage.css">
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
        <a href="OfficersHomePage">
            <button class="button">Manage Complaints</button>
        </a><br>
        <br>
        <br>
        <a href="logoutServlet">
            <button class="button">Sign Out</button>  
        </a>
        </div>
    </body>
</html>

