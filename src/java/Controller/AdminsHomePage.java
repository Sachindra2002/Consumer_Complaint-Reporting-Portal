/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Complaints;
import Model.DAO;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sachindra Rodrigo
 */
public class AdminsHomePage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String command = request.getParameter("command");
            if (command == null) {
                command = "VIEW";
            }
            switch (command) {
                case "VIEW":
                    viewComplaints(request, response);
                    break;
                case "ACCEPT":
                    acceptComplaints(request, response);
                    break;
                case "REJECT":
                    rejectComplaints(request, response);
                    break;
                case "ADD":
                    addEmployees(request, response);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void viewComplaints(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAO dao = new DAO();
        List<Complaints> complaints = new ArrayList<>();
        complaints = dao.getAllComplaints();
        request.setAttribute("COMPLAINTS_LIST", complaints);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminsComplaintList.jsp");
        dispatcher.forward(request, response);
    }

    private void acceptComplaints(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAO dao = new DAO();

        int complaintID = Integer.parseInt(request.getParameter("complaintID"));
        String status = "Accepted";
        String progressDescription = "Pending";
        String progressStatus = "Pending";
        dao.addAcceptedComplaints(complaintID, status, progressDescription, progressStatus);
        viewComplaints(request, response);
    }

    private void rejectComplaints(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAO dao = new DAO();
        int complaintID = Integer.parseInt(request.getParameter("complaintID"));
        String status = "Rejected";
        String progressDescription = "Not Available";
        String progressStatus = "Not Available";
        dao.addRejectedComplaints(complaintID, status, progressDescription, progressStatus);
        viewComplaints(request, response);
    }

    private void addEmployees(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAO dao = new DAO();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("uname");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String password = request.getParameter("pass");
         if(dao.checkUserExists(username))
        {
            out.println("Username already Exists!");
            RequestDispatcher rs = request.getRequestDispatcher("registerError2.html");
            rs.forward(request, response);
        }
        else
        {
            Users user = new Users(firstName, lastName, username, email, role, password);
            dao.addUser(user);
            out.println("Account created successfully!");
            response.sendRedirect("success.html"); 
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
