/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;
import Enums.Status;

/**
 *
 * @author LENOVO
 */
public class CandidatOffre {

    private int id;
    private int offerId;
    private int condidatId;
    private Date postedDate;
    private Status status;
    private String passwordTest;
    private int idTest;

    public CandidatOffre() {
    }

    public CandidatOffre(int id, int offerId, int condidatId, Date postedDate, Status status, String passwordTest, int idTest) {
        this.id = id;
        this.offerId = offerId;
        this.condidatId = condidatId;
        this.postedDate = postedDate;
        this.status = status;
        this.passwordTest = passwordTest;
        this.idTest = idTest;
    }

    public CandidatOffre(int id, int offerId, int condidatId, Date postedDate, Status status) {
        this.id = id;
        this.offerId = offerId;
        this.condidatId = condidatId;
        this.postedDate = postedDate;
        this.status = status;
    }

    public CandidatOffre(int id, int offerId, int condidatId, Date postedDate, Status status, String passwordTest) {
        this.id = id;
        this.offerId = offerId;
        this.condidatId = condidatId;
        this.postedDate = postedDate;
        this.status = status;
        this.passwordTest = passwordTest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getCondidatId() {
        return condidatId;
    }

    public void setCondidatId(int condidatId) {
        this.condidatId = condidatId;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPasswordTest() {
        return passwordTest;
    }

    public void setPasswordTest(String passwordTest) {
        this.passwordTest = passwordTest;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    @Override
    public String toString() {
        return "CandidatOffre{" + "id=" + id + ", offerId=" + offerId + ", condidatId=" + condidatId + ", postedDate=" + postedDate + ", status=" + status + ", passwordTest=" + passwordTest + '}';
    }

}
