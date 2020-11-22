<%-- 
    Document   : adminsComplaintList
    Created on : Sep 9, 2020, 9:03:18 AM
    Author     : Sachindra Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>National Consumer Complaint Reporting Portal</title>
        <link type="text/css" rel="stylesheet" href="CSS/adminsComplaintList.css">
        <link rel="icon" type="image/png" href="images/icon1.png">

        <%--<script src="https://smtpjs.com/v3/smtp.js"></script>--%>
        <script type="text/javascript">
            function myFunction()
             {
             alert("Complaint Accepted successfully");
             }
             function myFunction2()
             {
             alert("Complaint Rejected Sucessfully");
             }
            /*function sendEmail()
            {
                Email.send({
                    Host: "smtp.elasticemail.com",
                    Username: "memepreter@gmail.com",
                    Password: "8B06B0F8DCE0C361EFA81B4E3481F4A25091",
                    To: 'memepreter@gmail.com',
                    From: "memepreter@gmail.com",
                    Subject: "this is for testing purposes only",
                    Body: "And this is is s the body"
                }).then(function (message) {
                    alert("Email sent sucessfully")
                }
                );
            }*/
        </script>
    </head>
    <body>
        <h3>Manage Complaints</h3>
        <div style="overflow-x:auto;">
            <table>
                <tr>
                    <th>Complaint ID</th>
                    <th>Category</th>
                    <th>City</th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>Email</th>
                    <th>Accept</th>
                    <th>Reject</th>
                </tr>
                <tr>
                    <c:forEach var="tempComp" items="${COMPLAINTS_LIST}">
                        <c:url var="accept" value="AdminsHomePage">
                            <c:param name="command" value = "ACCEPT"/>
                            <c:param name="complaintID" value="${tempComp.complaintID}"/>
                        </c:url>
                        <c:url var="reject" value="AdminsHomePage">
                            <c:param name="command" value = "REJECT"/>
                            <c:param name="complaintID" value="${tempComp.complaintID}"/>
                        </c:url>
                        <td>${tempComp.complaintID}</td>
                        <td>${tempComp.category}</td>
                        <td>${tempComp.city}</td>
                        <td>${tempComp.description}</td>
                        <td>${tempComp.status}</td>
                        <td>${tempComp.email}</td>
                        <td><a href="${accept}" class="accept" onclick="myFunction()">Accept</a></td>
                        <td><a href="${reject}" class="reject" onclick="myFunction2()">Reject</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div><br>
        <input type="button" value="Go back to home" onclick="
                window.location.href = 'adminHomePage.jsp';
                return false;" class="button button1"/>
        <div class="counter">On this server there are currently <%= Controller.SCounter.getNumberOfSessions()%> active sessions.</div>
    </body>
</html>

