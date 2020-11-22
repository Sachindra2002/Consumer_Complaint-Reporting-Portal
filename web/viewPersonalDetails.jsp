<%-- 
    Document   : viewPersonalDetails
    Created on : Sep 16, 2020, 2:05:57 PM
    Author     : Sachindra Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>National Consumer Complaint Reporting Portal</title>
        <link type="text/css" rel="stylesheet" href="CSS/viewPersonalDetails.css">
        <link rel="icon" type="image/png" href="images/icon1.png">
    </head>
    <body>
        <h1>National Consumer Complaint Reporting Portal</h1>
        <div>
            <div class="container">
                <h3>Personal Details</h3>
                <%
                    String usernameID = (String) session.getAttribute("uname");
                    out.println("Username :" + usernameID);
                %>
                <br>
                <p><b>First Name:</b></p>
                
                <p>${user.firstName}</p>
                <p><b>Last Name:</b></p>
                <p>${user.lastName}</p>
                <p><b>Email:</b></p>
                <p>${user.email}</p><br>
                <a id="home" href="complainerHomePage.jsp">Go back to home</a>
            </div>
        </div>        
    </body>
</html>
