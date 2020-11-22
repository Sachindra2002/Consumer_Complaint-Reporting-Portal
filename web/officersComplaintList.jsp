<%-- 
    Document   : officersComplaintList
    Created on : Sep 10, 2020, 9:50:33 PM
    Author     : Sachindra Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>National Consumer Complaint Reporting Portal</title>
        <link type="text/css" rel="stylesheet" href="CSS/officersComplaintList.css">
        <link rel="icon" type="image/png" href="images/icon1.png">
    </head>
    <body>
        <script>
            function myFunction()
            {
                alert("Complaint Updated Sucessfully!");
            }
         </script>
        <h3>Manage Complaints</h3>
        <table>
            <tr>
                <th>Complaint ID</th>
                <th>Category</th>
                <th>City</th>
                <th>Description</th>
                <th>Status</th>
                <th>Progress Status</th>
                <th>Progress Description</th>
                <th>Update Complaint Progress </th>
            </tr>
            <tr>
            <c:forEach var="tempComp" items="${ACCEPTEDCOMPLAINTS_LIST}">
                <%--<c:url var="update" value="OfficersHomePage">
                    <c:param name="command" value = "UPDATE"/>
                    <c:param name="complaintID" value="${tempComp.complaintID}"/>
                </c:url>--%>
                <td>${tempComp.complaintID}</td>
                <td>${tempComp.category}</td>
                <td>${tempComp.city}</td>
                <td>${tempComp.description}</td>
                <td>${tempComp.status}</td>
                <td>${tempComp.progressStatus}</td>
                <td>${tempComp.progressDescription}</td>
                <td>
                    <form action="OfficersHomePage" method="GET">
                        <input type="hidden" name="command" value="UPDATE">
                        <input type="hidden" name="complaintID" value="${tempComp.complaintID}">
                        <select name="progress">
                            <option>Resolved</option>
                            <option>In Progress</option>
                            <option>Data Insufficient to process</option>
                        </select>
                        <input type="text" name="proDescription" placeholder="Enter progress" required>
                        <input type="submit" value="Submit" onclick="myFunction()">
                    </form>
                </td>
            </tr>
            </c:forEach>
        </table>
        <br>
        <input type="button" value="Go back to home" onclick="
            window.location.href='officersHomePage.jsp'; return false;" class="button button1" />
    </body>
</html>
