/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.JobOffer;
import util.MyConnection;

/**
 *
 * @author wawa
 */
public class JobOfferService {

    Connection cnx = MyConnection.getInstance().getCnx();
    CategoryService cs = new CategoryService();


    //Insert
    public void InsertJoboffer() {
    }

    public void InsertJoboffer(JobOffer p) {
        try {

            String Request = "INSERT INTO `joboffer`(`jobDescription`, `AverageSallary`, `totalPlaces`, `Status`, `CreatedDate`, `UpdatedDate`, `category`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(Request);
            ps.setString(1, p.getJobDescription());
            ps.setInt(2, p.getAverageSallary());
            ps.setInt(3, p.getTotalPlaces());
            ps.setString(4, p.getStatus());
            ps.setDate(5, (Date) p.getCreatedDate());
            ps.setDate(6, (Date) p.getUpdatedDate());
            ps.setInt(7, p.getCategory().getId_cat());
            ps.executeUpdate();
            System.out.println("JobOffer ajouté");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    //Select
    public List<JobOffer> FetchJobOffers() {
        List <JobOffer> joboffers = new ArrayList<>();
        try {
            
            String Request2 ="SELECT * FROM joboffer";
            PreparedStatement ps = cnx.prepareStatement(Request2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                JobOffer p = new JobOffer();
                p.setId(rs.getInt("id"));
                p.setJobDescription(rs.getString("jobDescription"));
                p.setAverageSallary(rs.getInt("AverageSallary"));
                p.setTotalPlaces(rs.getInt("totalPlaces"));
                p.setStatus(rs.getString("Status"));
                p.setCreatedDate(rs.getDate("CreatedDate"));
                p.setUpdatedDate(rs.getDate("UpdatedDate"));
                p.setCategory(cs.getCategoryByID(rs.getInt("category")));
                joboffers.add(p);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return joboffers;
        
    }
    //update
    public void UpdateJobOffer(JobOffer p){
        try {
            String Request3 ="UPDATE `joboffer` SET `jobDescription`=?,`AverageSallary`=?,`totalPlaces`=?,`Status`=?,`CreatedDate`=?,`UpdatedDate`=?,`category`=? WHERE id ="+ p.getId();
            PreparedStatement ps = cnx.prepareStatement(Request3);
            ps.setString(1, p.getJobDescription());
            ps.setInt(2, p.getAverageSallary());
            ps.setInt(3, p.getTotalPlaces());
            ps.setString(4, p.getStatus());
            ps.setDate(5, (Date) p.getCreatedDate());
            ps.setDate(6, (Date) p.getUpdatedDate());
            ps.setInt(7, p.getCategory().getId_cat());
            ps.executeUpdate();
            System.out.println("JobOffer modifié");
        } catch (SQLException ex) {
            Logger.getLogger(JobOfferService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //delete
    public void DeleteJobOffer(int id){
        try {
            String Request4 =  "DELETE FROM joboffer WHERE Id = ? ; ";
            PreparedStatement ps = cnx.prepareStatement(Request4);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("JobOffer supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(JobOfferService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
