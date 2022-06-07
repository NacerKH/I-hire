/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Models.Support;
import Models.Interview;
import Utils.MaConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Maryouma
 */
public class SupportService {

    // var
    Connection cnx = MaConnexion.getInstance().getCnx();
    InterviewService is= new InterviewService();
    // create
    public void insertSupport(Support s){
        
        String req="INSERT INTO `Support`(`id_interview`, `description_offre`, `cv_candidate`)"
                + " VALUES (?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
           
            ps.setInt(1, s.getInterview().getId_interview());
            ps.setString(2, s.getDescription_offre());
            ps.setString(3, s.getCv_candidate());
            ps.executeUpdate();
           // ps.executeUpdate();
            System.out.println("support ajouté");
            
        } catch (SQLException ex) {
            Logger.getLogger(SupportService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
       
    }
    //select
    public List<Support> fetchSupports(){
            List<Support> supports = new ArrayList<>();
            
        try {
            String req = "SELECT * FROM `support`";
            PreparedStatement ps= cnx.prepareStatement(req);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Support s= new Support();
                s.setId_support(rs.getInt(1));
                s.setInterview(is.getInterviewById(rs.getInt(2)));
                s.setDescription_offre(rs.getString(3));
                s.setCv_candidate(rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupportService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return supports;
        }
   
  //select by Id
    public Support getSupportById(int id){
        Support s = new Support();
        
        try {
            String req= "SELECT * FROM `support` WHERE id_support=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                s.setId_support(rs.getInt(1));
                s.setInterview(is.getInterviewById(rs.getInt(2)));
                s.setDescription_offre(rs.getString(3));
                s.setCv_candidate(rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupportService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return s;
    }
    
    //update
    public void updateSupportById(Support s){
       
        try {
             String req = "UPDATE `support` SET `id_interview`=?,`description_offre`=?,"
                + "`cv_candidate`=? WHERE id_support="+s.getId_support();
            PreparedStatement ps= cnx.prepareStatement(req);
            ps.setInt(1, s.getInterview().getId_interview());
            ps.setString(2, s.getDescription_offre());
            ps.setString(3, s.getCv_candidate());
            ps.executeUpdate();
            System.out.println("table support à jour");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    // delete
    public void deleteSupportById( int id){
        
        try {
            String req="DELETE FROM `support` WHERE id_support=?";
            PreparedStatement ps= cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("ligne supprimée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    
    
    
    
    
    
        
}
