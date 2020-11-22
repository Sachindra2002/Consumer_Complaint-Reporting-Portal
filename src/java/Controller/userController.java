/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sachindra Rodrigo
 */
public class userController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try{
            String command = request.getParameter("command");
            if (command == null)
            {
                command="LIST";
            }
            switch (command)
            {
                case"ADD":AddUsers(request, response);break;
            }
            
        } catch (Exception ex) {
            Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void AddUsers(HttpServletRequest request, HttpServletResponse response) 
            throws Exception
    {
        DAO dao = new DAO();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("uname");
        String email = request.getParameter("email");
        String role = "Complainer";
        String password = request.getParameter("pass");
        if(dao.checkUserExists(username))
        {
            out.println("Username already Exists!");
            RequestDispatcher rs = request.getRequestDispatcher("registerError1.html");
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
