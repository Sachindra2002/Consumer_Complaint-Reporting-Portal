<%-- 
    Document   : complainerHomePage
    Created on : Sep 7, 2020, 9:16:56 PM
    Author     : Sachindra Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>National Consumer Complaint Reporting Portal</title>
        <link type="text/css" rel="stylesheet" href="CSS/complainersHomePage.css">
        <link rel="icon" type="image/png" href="images/icon1.png">
    </head>
    <body>
        <c:url var="personal" value="complainersHomePage">
            <c:param name="command" value="PERSONAL"/>
        </c:url>
        
        <h1>National Consumer Complaint Reporting Portal</h1>
        <div class="username">
            <% 
                String usernameID = (String) session.getAttribute("uname");
                out.println("Welcome "+usernameID);
            %>
        </div>
        <div class="container">
        <a href="logComplaint.html" >
            <button class="button">Lodge a Complaint</button>
        </a><br>
        <br>
        <br>
        <br>
        <a href="complainersHomePage">
            <button class="button">View Lodged Complaints</button>
        </a><br>
        <br>
        <br>
        <br>
        <a href="${personal}" >
            <button class="button">View Personal Details</button>  
        </a><br>
        <br>
        <br>
        <br>
        <a href="logoutServlet">
            <button class="button">Sign Out</button>  
        </a>
        </div>
    </body>
</html>
