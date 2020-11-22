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
public class DeleteUser extends HttpServlet {

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
                    viewAllComplainers(request, response);
                    break;
                case "DELETE":
                    removeComplainer(request, response);
                    break;

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void viewAllComplainers(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAO dao = new DAO();
        List<Users> users = new ArrayList<>();
        users = dao.getAllUsers();
        request.setAttribute("USERS_LIST", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/usersList.jsp");
        dispatcher.forward(request, response);
    }

    private void removeComplainer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAO dao = new DAO();
        String username = request.getParameter("username");
        dao.removeComplainer(username);
        viewAllComplainers(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
