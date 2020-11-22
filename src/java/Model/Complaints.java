/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Sachindra Rodrigo
 */
public class Complaints {
    int complaintID;
    String category, city, description, status, progressDescription, email, usernameID, progressStatus;

    public Complaints(int complaintID, String category, String city, String description, String status, String progressDescription, String email, String usernameID, String progressStatus) {
        this.complaintID = complaintID;
        this.category = category;
        this.city = city;
        this.description = description;
        this.status = status;
        this.progressDescription = progressDescription;
        this.email = email;
        this.usernameID = usernameID;
        this.progressStatus = progressStatus;
    }

    public Complaints(int complaintID, String category, String city, String status, String progressDescription) {
        this.complaintID = complaintID;
        this.category = category;
        this.city = city;
        this.status = status;
        this.progressDescription = progressDescription;
    }

    public Complaints(int complaintID, String category, String city, String description, String status, String progressDescription, String progressStatus) {
        this.complaintID = complaintID;
        this.category = category;
        this.city = city;
        this.description = description;
        this.status = status;
        this.progressDescription = progressDescription;
        this.progressStatus = progressStatus;
    }

    public Complaints(int complaintID, String category, String city, String description, String status, String progressDescription, String email, String progressStatus) {
        this.complaintID = complaintID;
        this.category = category;
        this.city = city;
        this.description = description;
        this.status = status;
        this.progressDescription = progressDescription;
        this.email = email;
        this.progressStatus = progressStatus;
    }

    public Complaints(int complaintID, String category, String city, String description, String status, String email) {
        this.complaintID = complaintID;
        this.category = category;
        this.city = city;
        this.description = description;
        this.status = status;
        this.email = email;
    }

    public Complaints(String category, String city, String description, String status, String progressDescription, String email, String usernameID, String progressStatus) {
        this.category = category;
        this.city = city;
        this.description = description;
        this.status = status;
        this.progressDescription = progressDescription;
        this.email = email;
        this.usernameID = usernameID;
        this.progressStatus = progressStatus;
    }
    
    public int getComplaintID() {
        return complaintID;
    }

    public void setComplaintID(int complaintID) {
        this.complaintID = complaintID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProgressDescription() {
        return progressDescription;
    }

    public void setProgressDescription(String progressDescription) {
        this.progressDescription = progressDescription;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsernameID() {
        return usernameID;
    }

    public void setUsernameID(String usernameID) {
        this.usernameID = usernameID;
    }

    public String getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(String progressStatus) {
        this.progressStatus = progressStatus;
    }
    
}