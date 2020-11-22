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
public class visitorServlet extends HttpServlet {  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Create an object of the DAO class
        DAO dao = new DAO();
        //Get the category from the html form and initialize it to a variable
        String CATEGORY = request.getParameter("category");
        //Send it to the DAO method to check if complaints are available to the specific category
        if(dao.checkStatus(CATEGORY))
        {
            //Create a list for the class Complaints
            List<Complaints> visitorSearchedComplaint = new ArrayList<>();
            //send the list object along with the category
            visitorSearchedComplaint = dao.getLogedComplaint(CATEGORY);
            request.setAttribute("VISITOR_LIST", visitorSearchedComplaint);
            //Dispatch to the following jsp page along with the set attribute
            RequestDispatcher dispatcher = request.getRequestDispatcher("visitorsComplaintList.jsp");
            dispatcher.forward(request, response);
            
        }
        else
        {
            PrintWriter out = response.getWriter();
            out.println("Complaint/s does not Exist!");
            RequestDispatcher rs = request.getRequestDispatcher("visitorError.html");
            rs.forward(request, response);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
