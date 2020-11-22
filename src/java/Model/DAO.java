/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sachindra Rodrigo
 */
public class DAO {
private Connection connection;
    
    public DAO(){
        connection = Database.getConnection();
    }
    
    public boolean checkUserExists(String username) throws SQLException {
        boolean st = false;
        try{
            PreparedStatement ps = connection.prepareStatement("select * from users where username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
        }catch (Exception ex)
    {
        ex.printStackTrace();
    }
        return st;
    }
    public void addUser(Users user) {
        try{
            PreparedStatement ps = connection.prepareStatement(" insert into users (firstName,lastName,username,email,role,password)"+ " values (?,?,?,?,?,?)");
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getRole());
            ps.setString(6, user.getPassword());
            ps.executeUpdate();
            } catch (Exception e){
                e.printStackTrace();
            }
    }
    public String authenticateUser(Users theuser) throws SQLException {
        String username = theuser.getUsername();
        String password = theuser.getPassword();
        try{
            PreparedStatement ps = connection.prepareStatement("select username,password,role from users");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String USERNAME = rs.getString("username");
                String PASSWORD = rs.getString("password");
                String ROLE = rs.getString("role");
                
                if(username.equals(USERNAME) && password.equals(PASSWORD) && ROLE.equals("Admin"))
                    return "Admin";
                if(username.equals(USERNAME) && password.equals(PASSWORD) && ROLE.equals("Officer"))
                    return "Officer";
                if(username.equals(USERNAME) && password.equals(PASSWORD) && ROLE.equals("Complainer"))
                    return "Complainer";
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return "invalid";
    }

    public void addComplaint(Complaints complaint) {
        try
        {
            PreparedStatement ps = connection.prepareStatement("insert into complaints (category,city,description,status,progressDescription,email,usernameID,progressStatus)"
            +" values(?,?,?,?,?,?,?,?)");
            ps.setString(1, complaint.getCategory());
            ps.setString(2, complaint.getCity());
            ps.setString(3, complaint.getDescription());
            ps.setString(4, complaint.getStatus());
            ps.setString(5, complaint.getProgressDescription());
            ps.setString(6, complaint.getEmail());
            ps.setString(7, complaint.getUsernameID());
            ps.setString(8, complaint.getProgressStatus());
            ps.executeUpdate();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public List<Complaints> getLogedComplaints(String usernameID) throws Exception{
        List<Complaints> complaint = new ArrayList<Complaints>();
        try
        {
            PreparedStatement ps = connection.prepareStatement("SELECT complaintID,category,city,description,status,progressDescription,progressStatus FROM complaints WHERE usernameID=?");
            ps.setString(1, usernameID);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                int complaintID = Integer.parseInt(rs.getString("complaintID"));
                String category = rs.getString("category");
                String city = rs.getString("city");
                String description = rs.getString("description");
                String status = rs.getString("status");
                String progressDescription = rs.getString("progressDescription");
                String progressStatus = rs.getString("progressStatus");
                
                Complaints theComplaints = new Complaints(complaintID, category, city, description, status, progressDescription, progressStatus);
                complaint.add(theComplaints);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return complaint;
    }

    public boolean checkComplaintIDExists(int ID) {
        boolean st = false;
        try{
            PreparedStatement ps = connection.prepareStatement("select * from complaints where complaintID=?");
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
        }catch (Exception ex)
    {
        ex.printStackTrace();
    }
        return st;
    }

    public List<Complaints> getLogedComplaint(String CATEGORY) {
        List<Complaints> complaint = new ArrayList<Complaints>();
        try
        {
            PreparedStatement ps = connection.prepareStatement("SELECT complaintID,category,city,description,status,progressDescription,email,progressStatus FROM complaints WHERE category=? AND progressStatus=?");
            ps.setString(1, CATEGORY);
            ps.setString(2, "Resolved");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                int complaintID = Integer.parseInt(rs.getString("complaintID"));
                String category = rs.getString("category");
                String city = rs.getString("city");
                String description = rs.getString("description");
                String status = rs.getString("status");
                String progressDescription = rs.getString("progressDescription");
                String progressStatus = rs.getString("progressStatus");
                String email = rs.getString("email");
                
                Complaints theComplaints = new Complaints(complaintID, category, city, description, status, progressDescription,email,progressStatus);
                complaint.add(theComplaints);
            }
        }catch (Exception ex)
    {
        ex.printStackTrace();
    }
    return complaint;
}

    public boolean checkStatus(String CATEGORY) {
        boolean st = false;
        try{
            PreparedStatement ps = connection.prepareStatement("select * from complaints where category=? AND progressStatus=?");
            ps.setString(1, CATEGORY);
            ps.setString(2, "Resolved");
            ResultSet rs = ps.executeQuery();
            st = rs.next();
        }catch (Exception ex)
    {
        ex.printStackTrace();
    }
        return st;
    }
    
    public List<Complaints> getAllComplaints() {
        List<Complaints>complaints = new ArrayList<Complaints>();
        try
        {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM complaints");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                int complaintID = Integer.parseInt(rs.getString("complaintID"));
                String category = rs.getString("category");
                String city = rs.getString("city");
                String description = rs.getString("description");
                String status = rs.getString("status");
                String email = rs.getString("email");
                Complaints allcomplaints = new Complaints(complaintID, category, city, description, status, email);
                complaints.add(allcomplaints);
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    return complaints;
    }
    public void addRejectedComplaints(int complaintID, String status, String progressDescription, String progressStatus) throws SQLException {
        try
        {
            PreparedStatement ps = connection.prepareStatement("UPDATE complaints SET status=?, progressDescription=?, progressStatus=? WHERE complaintID=?");
            ps.setString(1, status);
            ps.setString(2, progressDescription);
            ps.setString(3, progressStatus);
            ps.setInt(4, complaintID);
            ps.executeUpdate();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public List<Users> getAllUsers() {
        List<Users>users = new ArrayList<>();
        try
        {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE role=?");
            ps.setString(1,"Complainer");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String username = rs.getString("username");
                String email = rs.getString("email");
                Users allusers = new Users(firstName,lastName,username,email);
                users.add(allusers);
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return users;
    }
    public void removeComplainer(String username) throws SQLException {
        try{
            PreparedStatement ps = connection.prepareStatement("DELETE FROM users WHERE username=?");
            ps.setString(1, username);
            ps.executeUpdate();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void addAcceptedComplaints(int complaintID, String status, String progressDescription, String progressStatus) {
     try{
            PreparedStatement ps = connection.prepareStatement("UPDATE complaints SET status=?, progressDescription=?, progressStatus=? WHERE complaintID=?");
            ps.setString(1, status);
            ps.setString(2, progressDescription);
            ps.setString(3, progressStatus);
            ps.setInt(4, complaintID);
            ps.executeUpdate();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public List<Complaints> getAllAcceptedComplaints() {
        List<Complaints> complaints = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM complaints WHERE status=?");
            ps.setString(1, "Accepted");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                int complaintID = Integer.parseInt(rs.getString("complaintID"));
                String category = rs.getString("category");
                String city = rs.getString("city");
                String description = rs.getString("description");
                String status = rs.getString("status");
                String progressDescription = rs.getString("progressDescription");
                String progressStatus = rs.getString("progressStatus");
                
                Complaints theComplaints = new Complaints(complaintID, category, city, description, status, progressDescription, progressStatus);
                complaints.add(theComplaints);
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return complaints;
    }
    public void addAcceptedComplaints(int COMPLAINTID, String PRODESCRIPTION, String PROGRESSSTATUS) {
        try{
            PreparedStatement ps = connection.prepareStatement("UPDATE complaints SET progressDescription=?, progressStatus=? WHERE complaintID=?");
            ps.setString(1, PRODESCRIPTION);
            ps.setString(2, PROGRESSSTATUS);
            ps.setInt(3, COMPLAINTID);
            ps.executeUpdate();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public Users viewPersonalDetails(String username) throws SQLException {

        try{
            PreparedStatement ps = connection.prepareStatement("SELECT firstName, lastName, email FROM users WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String FIRSTNAME = rs.getString("firstName");
                String LASTNAME = rs.getString("lastName");
                String EMAIL = rs.getString("email");
                
                Users user = new Users(FIRSTNAME,LASTNAME,EMAIL);
                return user;
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public void removeComplaint(int complaintID) {
        try{
            PreparedStatement ps = connection.prepareStatement("DELETE FROM complaints WHERE complaintID=?");
            ps.setInt(1, complaintID);
            ps.executeUpdate();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public boolean checkComplaintsExist(String usernameID) {
         boolean st = false;
        try{
            PreparedStatement ps = connection.prepareStatement("select * from complaints where usernameID=?");
            ps.setString(1, usernameID);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
        }catch (Exception ex)
    {
        ex.printStackTrace();
    }
        return st;
    }
}
