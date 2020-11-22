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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sachindra Rodrigo
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //Read data from form
        String username = request.getParameter("uname");
        String password = request.getParameter("password");
        
        //Create new Users onject
        Users theuser = new Users(username, password);
        DAO dao = new DAO();
        String userRole = null;
        try {
            //Check for users role
            userRole = dao.authenticateUser(theuser);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        switch(userRole)
        {
            case"Admin":
            {
                //create a new session
                HttpSession session = request.getSession();
                //set the response attribute
                session.setAttribute("uname",username);
                //setting session attribute
                response.sendRedirect("adminHomePage.jsp");
                break;
            }
            case"Officer":
            {
                HttpSession session = request.getSession();
                session.setAttribute("uname",username);
                response.sendRedirect("officersHomePage.jsp");
                break;
            }
            case"Complainer":
            {
                HttpSession session = request.getSession();
                session.setAttribute("uname",username);
                response.sendRedirect("complainerHomePage.jsp");
                break;
            }
            default:
            {
                out.println("Sorry username or password incorrect");
                request.getRequestDispatcher("login.html").include(request, response);
                break;
            }
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
