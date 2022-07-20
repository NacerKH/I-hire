/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Models.Interview;
import Utils.AppDbContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maryouma
 */
public class InterviewService {

    Connection Connection = AppDbContext.GetInstance().GetDbConnection();

    // <editor-fold defaultstate="collapsed" desc="Init Creation Instance -> Singleton">
    public InterviewService() {
    }
    private static InterviewService instance = new InterviewService();

    public static InterviewService GetInstance() {
        return instance;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Main Methods">
    // <editor-fold defaultstate="collapsed" desc="GetAll">
    public ArrayList<Interview> GetAll() {
        ArrayList<Interview> resultList = new ArrayList<Interview>();
        try {
            String req = "SELECT * FROM interview";
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery();

            while (result.next()) {

                try {
                    resultList.add(InitInterview(result));
                } catch (Exception ex) {
                    System.err.println("[Exception] " + ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return resultList;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GetById">
    public Interview GetById(int id) {
        Interview i = new Interview();
        String req = "SELECT * FROM `interview` WHERE `id_interview`=?";
        try {
            PreparedStatement ps = Connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {

               i.setId_interview(result.getInt("id_interview"));
               i.setDate_interview( result.getDate("date_interview"));
               i.setUpdate_interview(result.getDate("update_interview"));    
               i.setType_interview( result.getString("type_interview"));
               i.setStatut(  result.getString("statut"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(InterviewService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Post">
    public void Post(Interview i) {
        String req = "INSERT INTO `interview`(`date_interview`, `update_interview`, `type_interview`, `statut`) "
                + "VALUES (?,?,?,?)";
        try {
            System.out.println("Connection " + Connection);
            PreparedStatement ps = Connection.prepareStatement(req);

            ps.setDate(1, i.getDate_interview());
            ps.setDate(2, i.getUpdate_interview());
            ps.setString(3, i.getType_interview());
            ps.setString(4, i.getStatut());
            ps.executeUpdate();
            System.out.println("interview ajouté");

        } catch (SQLException ex) {
            Logger.getLogger(InterviewService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Put">
    public void Put(Interview i) {

        try {
            String req = "UPDATE `interview` SET `date_interview`=?, `update_interview`=?,"
                    + "`type_interview`=?,`statut`=? WHERE id_interview=" + i.getId_interview();
            PreparedStatement ps = Connection.prepareStatement(req);
            ps.setDate(1, (Date) i.getDate_interview());
            ps.setDate(2, (Date) i.getUpdate_interview());
            ps.setString(3, i.getType_interview());
            ps.setString(4, i.getStatut());
            ps.executeUpdate();
            System.out.println("table interview modifiée");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Delete">
    public void Delete(int id) {
        String req = "DELETE FROM `interview` WHERE id_interview= ?";
        try {
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
    // <editor-fold defaultstate="collapsed" desc="Other Methods">
    // <editor-fold defaultstate="collapsed" desc="InitUser">
    private Interview InitInterview(ResultSet result) {
        try {
            return new Interview(
                    result.getInt("id_interview"),
                    result.getDate("date_interview"),
                    result.getDate("update_interview"),
                    result.getString("type_interview"),
                    result.getString("statut")
            );
        } catch (SQLException ex) {
            System.err.println("[Exception] " + ex.getMessage());
        }

        return null;
    }
    // </editor-fold>

    // </editor-fold>
}
