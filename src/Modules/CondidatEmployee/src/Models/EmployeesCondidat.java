/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.CondidatEmployee.src.Models;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class EmployeesCondidat {
                 public int id;
                public int offer_id;
	public int user_id;
	public String cv_url;
	public Date postedate; 
                  public int status;

    public EmployeesCondidat() {
    }

    public EmployeesCondidat(int id, int offer_id, int user_id, String cv_url, Date postedate, int status) {
        this.id = id;
        this.offer_id = offer_id;
        this.user_id = user_id;
        this.cv_url = cv_url;
        this.postedate = postedate;
        this.status = status;
    }

    public EmployeesCondidat(int offer_id, int user_id, String cv_url, Date postedate, int status) {
        this.offer_id = offer_id;
        this.user_id = user_id;
        this.cv_url = cv_url;
        this.postedate = postedate;
        this.status = status;
    }

    public EmployeesCondidat(int offer_id, int user_id, String cv_url, int status) {
        this.offer_id = offer_id;
        this.user_id = user_id;
        this.cv_url = cv_url;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCv_url() {
        return cv_url;
    }

    public void setCv_url(String cv_url) {
        this.cv_url = cv_url;
    }

    public Date getPostedate() {
        return postedate;
    }

    public void setPostedate(Date postedate) {
        this.postedate = postedate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmployeesCondidat{" + "id=" + id + ", offer_id=" + offer_id + ", user_id=" + user_id + ", cv_url=" + cv_url + ", postedate=" + postedate + ", status=" + status + '}';
    }
                  
}
