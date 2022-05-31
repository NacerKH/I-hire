/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HireSolution.entities;

/**
 *
 * @author Maryouma
 */
public class Support {
    //var
    private int id_support;
    private Interview id_interview;
    private String description_offre ;
    private String cv_candidate;
    
    // constructor

    public Support() {
    }

    public Support(int id_support, Interview id_interview, String description_offre, String cv_candidate) {
        this.id_support = id_support;
        this.id_interview = id_interview;
        this.description_offre = description_offre;
        this.cv_candidate = cv_candidate;
    }

    public Support(Interview id_interview, String description_offre, String cv_candidate) {
        this.id_interview = id_interview;
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

    public Interview getId_interview() {
        return id_interview;
    }

    public void setId_interview(Interview id_interview) {
        this.id_interview = id_interview;
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
    //to_string

    @Override
    public String toString() {
        return "Support{" + "id_support=" + id_support + ", id_interview=" + id_interview + ", description_offre=" + description_offre + ", cv_candidate=" + cv_candidate + '}';
    }
    
    
    
}
