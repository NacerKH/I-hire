/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author e.bentijani
 */
public class TableCandidatOffreDto {
        private Candidat candidat;
     private int id;
    private String status;
    private Date postuDate;
    private String fullName;
    private JobOffer Offer;
    private int idTest;
    private int idCandidat;
    private String passwordTest;
    public TableCandidatOffreDto(Candidat candidat, String status, Date postuDate, String fullName,JobOffer Offer,int id,int idTest,int idCandidat) {
        this.candidat = candidat;
        this.status = status;
        this.postuDate = postuDate;
        this.fullName = fullName;
        this.Offer=Offer;
        this.id=id;
        this.idTest=idTest;
        this.idCandidat=idCandidat;
    }

    public TableCandidatOffreDto(Candidat candidat, int id, String status, Date postuDate, String fullName, JobOffer Offer, int idTest, int idCandidat, String passwordTest) {
        this.candidat = candidat;
        this.id = id;
        this.status = status;
        this.postuDate = postuDate;
        this.fullName = fullName;
        this.Offer = Offer;
        this.idTest = idTest;
        this.idCandidat = idCandidat;
        this.passwordTest = passwordTest;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPostuDate() {
        return postuDate;
    }

    public void setPostuDate(Date postuDate) {
        this.postuDate = postuDate;
    }

    public int getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(int idCandidat) {
        this.idCandidat = idCandidat;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public JobOffer getOffer() {
        return Offer;
    }

    public void setOffer(JobOffer Offer) {
        this.Offer = Offer;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public String getPasswordTest() {
        return passwordTest;
    }

    public void setPasswordTest(String passwordTest) {
        this.passwordTest = passwordTest;
    }
    

}
