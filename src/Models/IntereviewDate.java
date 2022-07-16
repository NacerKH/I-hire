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
public class IntereviewDate {

    int id;
    Date intrvDate;
    String intrvTime;
    Date createdDate;
    Date updatedDate;
    ArrayList<Candidat> candidats = new ArrayList<>();

    public IntereviewDate() {
    }

    public IntereviewDate(Date intrvDate, Date createdDate, Date updatedDate, ArrayList<Candidat> candidat) {
        this.intrvDate = intrvDate;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.candidats = candidats;
    }

    public IntereviewDate(Date intrvDate, int totalQuestions, int duration, Date createdDate, Date updatedDate) {
        this.intrvDate = intrvDate;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public IntereviewDate(int id, Date intrvDate, String intrvTime, Date createdDate, Date updatedDate) {
        this.id = id;
        this.intrvDate = intrvDate;
        this.intrvTime = intrvTime;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public IntereviewDate(int id, Date intrvDate, Date createdDate, Date updatedDate, ArrayList<Candidat> candidat) {
        this.id = id;
        this.intrvDate = intrvDate;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.candidats = candidat;
    }

    public IntereviewDate(int id, Date intrvDate, String intrvTime, Date createdDate, Date updatedDate, ArrayList<Candidat> candidats) {
        this.id = id;
        this.intrvDate = intrvDate;
        this.intrvTime = intrvTime;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.candidats = candidats;
    }

    public IntereviewDate(Date intrvDate, String intrvTime, Date createdDate, Date updatedDate) {
        this.intrvDate = intrvDate;
        this.intrvTime = intrvTime;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public String getIntrvTime() {
        return intrvTime;
    }

    public void setIntrvTime(String intrvTime) {
        this.intrvTime = intrvTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getIntrvDate() {
        return intrvDate;
    }

    public void setIntrvDate(Date intrvDate) {
        this.intrvDate = intrvDate;
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

    public ArrayList<Candidat> getCandidats() {
        return candidats;
    }

    public void setCandidats(ArrayList<Candidat> candidats) {
        this.candidats = candidats;
    }

    @Override
    public String toString() {
        return "IntereviewDate{" + "id=" + id + ", intrvDate=" + intrvDate + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", candidat=" + candidats + '}';
    }

}
