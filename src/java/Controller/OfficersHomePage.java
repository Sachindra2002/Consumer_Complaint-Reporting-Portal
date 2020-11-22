/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Complaints;
import Model.DAO;
import java.io.IOException;
import java.io.PrintWriter;
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
public class OfficersHomePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String command = request.getParameter("command");
            if(command == null)
            {
                command = "VIEW";
            }
            switch (command)
            {
                case"VIEW":viewAllAcceptedComplaints(request, response);break;
                case"UPDATE":updateAcceptedComplaints(request, response);break;

            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
    private void viewAllAcceptedComplaints(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = new DAO();
        List<Complaints> complaints = new ArrayList<>();
        complaints = dao.getAllAcceptedComplaints();
        request.setAttribute("ACCEPTEDCOMPLAINTS_LIST", complaints);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/officersComplaintList.jsp");
        dispatcher.forward(request, response);
    }
    private void updateAcceptedComplaints(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAO dao = new DAO();
        int COMPLAINTID = Integer.parseInt(request.getParameter("complaintID"));
        String PROGRESSSTATUS = request.getParameter("progress");
        String PRODESCRIPTION = request.getParameter("proDescription");
        dao.addAcceptedComplaints(COMPLAINTID,PRODESCRIPTION, PROGRESSSTATUS);
        viewAllAcceptedComplaints(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
