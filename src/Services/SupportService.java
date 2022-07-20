/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Models.Support;
import Models.Interview;
import services.InterviewService;
import Utils.AppDbContext;
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

    Connection Connection = AppDbContext.GetInstance().GetDbConnection();

    ;  
    
    
    // <editor-fold defaultstate="collapsed" desc="Init Creation Instance -> Singleton">
    public SupportService() {

    }
    private static SupportService instance = new SupportService(); 

    public static SupportService GetInstance() 
    {
        return instance; 
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Main Methods">
    // <editor-fold defaultstate="collapsed" desc="GetAll">
    public List<Support> GetAll() {
       
        List<Support> supports = new ArrayList<>();

        try {
            String req = "SELECT * FROM `support`";
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Support s = new Support();
                s.setId_support(rs.getInt(1));
                s.setInterview(InterviewService.GetInstance().GetById(rs.getInt(2)));
                s.setDescription_offre(rs.getString(3));
                s.setCv_candidate(rs.getString(4));
                supports.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupportService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return supports;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GetById">
    public Support GetById(int id) {
        Support s = new Support();
        
        try {
            String req = "SELECT * FROM `support` WHERE id_support=?";
            PreparedStatement ps = Connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            while (rs.next()) {
                s.setId_support(rs.getInt(1));
                s.setInterview(InterviewService.GetInstance().GetById(rs.getInt(2)));
                s.setDescription_offre(rs.getString(3));
                s.setCv_candidate(rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupportService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return s;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Post">
    public void Post(Support s) {

        String req = "INSERT INTO `Support`(`id_interview`, `description_offre`, `cv_candidate`)"
                + " VALUES (?,?,?)";
        try {
            PreparedStatement ps = Connection.prepareStatement(req);

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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Put">
    public void Put(Support s) {

        try {
            String req = "UPDATE `support` SET `id_interview`=?,`description_offre`=?,"
                    + "`cv_candidate`=? WHERE id_support=" + s.getId_support();
            PreparedStatement ps = Connection.prepareStatement(req);
            ps.setInt(1, s.getInterview().getId_interview());
            ps.setString(2, s.getDescription_offre());
            ps.setString(3, s.getCv_candidate());
            ps.executeUpdate();
            System.out.println("table support à jour");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Delete">
    public void Delete(int id) {

        try {
            String req = "DELETE FROM `support` WHERE id_support=?";
            PreparedStatement ps = Connection.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("ligne supprimée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    // </editor-fold>

    // </editor-fold>
}
