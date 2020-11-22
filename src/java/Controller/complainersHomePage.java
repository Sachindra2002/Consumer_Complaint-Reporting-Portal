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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sachindra Rodrigo
 */
public class complainersHomePage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String command = request.getParameter("command");
            if (command == null) {
                command = "VIEW";
            }
            switch (command) {
                case "ADDCOMPLAINT":
                    addComplaint(request, response);
                    break;
                case "VIEW":
                    viewComplaints(request, response);
                    break;
                case "PERSONAL":
                    viewPersonal(request, response);
                    break;
                case "DELETE":
                    deleteComplaint(request, response);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addComplaint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAO dao = new DAO();
        String category = request.getParameter("category");
        String city = request.getParameter("city");
        String description = request.getParameter("description");
        String status = "Pending";
        String progressDescription = "Pending";
        String progressStatus = "Pending";
        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        String usernameID = (String) session.getAttribute("uname");
        Complaints complaint = new Complaints(category, city, description, status, progressDescription, email, usernameID, progressStatus);

        dao.addComplaint(complaint);

        RequestDispatcher dispatcher = request.getRequestDispatcher("success2.html");
        dispatcher.forward(request, response);

    }

    private void viewComplaints(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        String usernameID = (String) session.getAttribute("uname");
        if (dao.checkComplaintsExist(usernameID)) {
            List<Complaints> logedComplaintsList = new ArrayList<>();
            logedComplaintsList = dao.getLogedComplaints(usernameID);

            request.setAttribute("COMPLAINT_LIST", logedComplaintsList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("complainersComplaintList.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("noComplaints.html");
            dispatcher.forward(request, response);
        }

    }

    private void viewPersonal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("uname");
        Users user = dao.viewPersonalDetails(username);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewPersonalDetails.jsp");
        dispatcher.forward(request, response);

    }

    private void deleteComplaint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAO dao = new DAO();
        int complaintID = Integer.parseInt(request.getParameter("complaintID"));
        dao.removeComplaint(complaintID);
        viewComplaints(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
