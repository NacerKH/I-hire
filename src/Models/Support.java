/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Maryouma
 */
public class Support {
    //var
    private int id_support;
    private Interview interview;
    private String description_offre ;
    private String cv_candidate;
    
    // constructor

    public Support() {
    }

    public Support(int id_support, Interview interview, String description_offre, String cv_candidate) {
        this.id_support = id_support;
        this.interview = interview;
        this.description_offre = description_offre;
        this.cv_candidate = cv_candidate;
    }

    public Support(Interview interview, String description_offre, String cv_candidate) {
        this.interview = interview;
        this.description_offre = description_offre;
        this.cv_candidate = cv_candidate;
    }
    
    //getters & setters 

    public int getId_support() {
        return id_support;
    }

    public void setId_support(int id_support) {
        this.id_support = id_support;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public String getDescription_offre() {
        return description_offre;
    }

    public void setDescription_offre(String description_offre) {
        this.description_offre = description_offre;
    }

    public String getCv_candidate() {
        return cv_candidate;
    }

    public void setCv_candidate(String cv_candidate) {
        this.cv_candidate = cv_candidate;
    }
  

    @Override
    public String toString() {
        return "Support{" + "id_support=" + id_support + ", id_interview=" + interview + ", description_offre=" + description_offre + ", cv_candidate=" + cv_candidate + '}';
    }

  

  
    
    
    
}
