<%-- 
    Document   : complainersComplaintList.jsp
    Created on : Sep 8, 2020, 1:38:22 PM
    Author     : Sachindra Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>National Consumer Complaint Reporting Portal</title>
        <link type="text/css" rel="stylesheet" href="CSS/complainersComplaintList.css">
        <link rel="icon" type="image/png" href="images/icon1.png">
        <script type="text/javascript">
            function myFunction()
            {
                alert("Complaint removed successfully");
            }
        </script>
    </head>
    <body>
        <h3>Lodged Complaints</h3>
        <table>
            <tr>
                <th>Complaint ID</th>
                <th>Category</th>
                <th>City</th>
                <th>Status</th>
                <th>Progress Status</th>
                <th>Progress Description</th>
                <th>Action</th>
            </tr>
            <tr>
            <c:forEach var="tempComp" items="${COMPLAINT_LIST}">
                <c:url var="delete" value="complainersHomePage">
                        <c:param name="command" value = "DELETE"/>
                        <c:param name="complaintID" value="${tempComp.complaintID}"/>
                    </c:url>
                <td>${tempComp.complaintID}</td>
                <td>${tempComp.category}</td>
                <td>${tempComp.city}</td>
                <td>${tempComp.status}</td>
                <td>${tempComp.progressStatus}</td>
                <td>${tempComp.progressDescription}</td>
                <td><a href="${delete}" onclick="myFunction()">Remove</a></td>
            </tr>
            </c:forEach>
        </table>
        <input type="button" value="Go back to home" onclick="
            window.location.href='complainerHomePage.jsp'; return false;" class="button button1"/>
    </body>
</html>
