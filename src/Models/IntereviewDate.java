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
public class IntereviewDate extends BaseEntity {

public Date intrvDate;

public Candidat candidat;

    public IntereviewDate() {
    }

    public IntereviewDate(Date intrvDate, Candidat candidat) {
        this.intrvDate = intrvDate;
        this.candidat = candidat;
    }

    public IntereviewDate(Date intrvDate, Candidat candidat, int Id, Date CreatedDate, Date UpdatedDate) {
        super(Id, CreatedDate, UpdatedDate);
        this.intrvDate = intrvDate;
        this.candidat = candidat;
    }

    public Date getIntrvDate() {
        return intrvDate;
    }

    public void setIntrvDate(Date intrvDate) {
        this.intrvDate = intrvDate;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
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
        return "IntereviewDate{" + "intrvDate=" + intrvDate + ", candidat=" + candidat + ", CreatedDate=" + CreatedDate +", UpdatedDate=" + UpdatedDate +'}';
    }

   



  
    
}
