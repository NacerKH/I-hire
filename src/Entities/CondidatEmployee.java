/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;
import Enums.CondidatEmployeeType;
/**
 *
 * @author LENOVO
 */
public class CondidatEmployee extends BaseEntity {

    public int offer_id;
    public int user_id;
    public String cv_url;
    public CondidatEmployeeType status;

    public CondidatEmployee() {
    }

    public CondidatEmployee(int offer_id, int user_id, String cv_url, CondidatEmployeeType status) {
        this.offer_id = offer_id;
        this.user_id = user_id;
        this.cv_url = cv_url;
        this.status = status;
    }

    public CondidatEmployee(int offer_id, int user_id, String cv_url, CondidatEmployeeType status, int Id, Date CreatedDate, Date UpdatedDate) {
        super(Id, CreatedDate, UpdatedDate);
        this.offer_id = offer_id;
        this.user_id = user_id;
        this.cv_url = cv_url;
        this.status = status;
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

    public CondidatEmployeeType getStatus() {
        return status;
    }

    public void setStatus(CondidatEmployeeType status) {
        this.status = status;
    }
@Override
    public int getId() {
        return Id;
    }
@Override

    public void setId(int Id) {
        this.Id = Id;
    }
@Override

    public Date getCreatedDate() {
        return CreatedDate;
    }
@Override

    public void setCreatedDate(Date CreatedDate) {
        this.CreatedDate = CreatedDate;
    }
@Override

    public Date getUpdatedDate() {
        return UpdatedDate;
    }
@Override

    public void setUpdatedDate(Date UpdatedDate) {
        this.UpdatedDate = UpdatedDate;
    }

    @Override
    public String toString() {
        return "CondidatEmployee{" + "offer_id=" + offer_id + ", user_id=" + user_id + ", cv_url=" + cv_url + ", status=" + status + '}';
    }

  
    

}
