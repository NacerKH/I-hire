/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;

/**
 *
 * @author Maryouma
 */
public class Interview {
    // var
    private int id_interview;
    private Date date_interview;
    private Date update_interview;
    private String type_interview;
    private String statut;
    
    //consturctor

    public Interview() {
    }

    public Interview(Date date_interview, Date update_interview, String type_interview, String statut) {
        this.date_interview = date_interview;
        this.update_interview = update_interview;
        this.type_interview = type_interview;
        this.statut = statut;
    }

    public Interview(int id_interview, Date date_interview, Date update_interview, String type_interview, String statut) {
        this.id_interview = id_interview;
        this.date_interview = date_interview;
        this.update_interview = update_interview;
        this.type_interview = type_interview;
        this.statut = statut;
    }
    // getters & setters 

   

    public int getId_interview() {
        return id_interview;
    }

    public void setId_interview(int id_interview) {
        this.id_interview = id_interview;
    }

    public Date getDate_interview() {
        return date_interview;
    }

    public void setDate_interview(Date date_interview) {
        this.date_interview = date_interview;
    }

    public Date getUpdate_interview() {
        return update_interview;
    }

    public void setUpdate_interview(Date update_interview) {
        this.update_interview = update_interview;
    }

    public String getType_interview() {
        return type_interview;
    }

    public void setType_interview(String type_interview) {
        this.type_interview = type_interview;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
    
    //to_string 

    @Override
    public String toString() {
        return "Interview{" + "id_interview=" + id_interview + ", date_interview=" + date_interview + ", update_interview=" + update_interview + ", type_interview=" + type_interview + ", statut=" + statut + '}';
    }
    
}
