<%-- 
    Document   : visitorsComplaintList
    Created on : Sep 8, 2020, 3:14:27 PM
    Author     : Sachindra Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>National Consumer Complaint Reporting Portal</title>
        <link type="text/css" rel="stylesheet" href="CSS/visitorsComplaintList.css">
        <link rel="icon" type="image/png" href="images/icon1.png">
    </head>
    <body>
        <h3>Resolved Complaints</h3>
        <table>
            <tr>
                <th>Complaint ID</th>
                <th>Category</th>
                <th>City</th>
                <th>Description</th>
                <th>Status</th>
                <th>Progress Status</th>
                <th>Progress Description</th>
                <th>Email</th>
            </tr>
            <tr>
            <c:forEach var="tempComp" items="${VISITOR_LIST}">
                <td>${tempComp.complaintID}</td>
                <td>${tempComp.category}</td>
                <td>${tempComp.city}</td>
                <td>${tempComp.description}</td>
                <td>${tempComp.status}</td>
                <td>${tempComp.progressStatus}</td>
                <td>${tempComp.progressDescription}</td>
                <td>${tempComp.email}</td>
            </tr>
            </c:forEach>
        </table>
        <input type="button" value="Go back to home" onclick="
            window.location.href='visitorsHomePage.html'; return false;" class="button button1" />
    </body>
</html>

