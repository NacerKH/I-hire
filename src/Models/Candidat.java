/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author KHLIFI-MED
 */
public class Candidat {
    
     int id;
  String fullName;
   String phoneNumber;
   String email;
    String cv_url;
    Date createdDate;
    Date updatedDate;
   IntereviewDate intereviewDate;
     int idIntereviewDate;

    public Candidat() {
    }

    public Candidat(int id, String fullName, String phoneNumber, String email, String cv_url, Date createdDate, Date updatedDate, IntereviewDate intereviewDate, int idIntereviewDate) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.cv_url = cv_url;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.intereviewDate = intereviewDate;
        this.idIntereviewDate = idIntereviewDate;
    }
    
    
        public Candidat(int id, String fullName, String phoneNumber, String email, String cv_url, Date createdDate, Date updatedDate) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.cv_url = cv_url;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;}
    

    public Candidat(int id, String fullName, String phoneNumber, String email, String cv_url, Date createdDate, Date updatedDate,int idIntereviewDate) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.cv_url = cv_url;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.idIntereviewDate = idIntereviewDate;
    }
    
    
     public Candidat( String fullName, String phoneNumber, String email, String cv_url, Date createdDate, Date updatedDate) {
        
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.cv_url = cv_url;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        
    }

    public Candidat( String fullName, String phoneNumber, String email, String cv_url, Date createdDate, Date updatedDate,int idIntereviewDate) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.cv_url = cv_url;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.idIntereviewDate = idIntereviewDate;
    }
    
    public Candidat(String fullName, String phoneNumber, String email, String cv_url, Date createdDate, Date updatedDate, IntereviewDate intereviewDate) {

        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.cv_url = cv_url;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.intereviewDate = intereviewDate;
    }

 

    public int getId() {
        return id;
    }

   

    

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCv_url() {
        return cv_url;
    }

    public void setCv_url(String cv_url) {
        this.cv_url = cv_url;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public IntereviewDate getIntereviewDate() {
        return intereviewDate;
    }

    public void setIntereviewDate(IntereviewDate intereviewDate) {
        this.intereviewDate = intereviewDate;
    }

    public int getIdIntereviewDate() {
        return idIntereviewDate;
    }

    public void setIdIntereviewDate(int idIntereviewDate) {
        this.idIntereviewDate = idIntereviewDate;
    }
       
    public String toString() {
        return "Candidat{" + "id=" + id + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", email=" + email + ", cv_url=" + cv_url + ",createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", intereviewDate=" + intereviewDate + ", idIntereviewDate=" + idIntereviewDate+ '}';
    }
}
