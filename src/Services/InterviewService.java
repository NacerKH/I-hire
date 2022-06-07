/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Interview;
import Utils.MaConnexion;
import java.sql.Connection;
import java.sql.Date;
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
public class InterviewService {

    //var
    Connection cnx = MaConnexion.getInstance().getCnx();

    //create
    public void insertInterview(Interview i) {
        String req = "INSERT INTO `interview`(`date_interview`, `update_interview`, `type_interview`, `statut`) "
                + "VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);

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

    //select by id
    public Interview getInterviewById(int id) {
        Interview i = new Interview();
        String req = "SELECT * FROM `interview` WHERE `id_interview`=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                i.setId_interview(rs.getInt(1));
                i.setDate_interview(rs.getDate(2));
                i.setUpdate_interview(rs.getDate(3));
                i.setType_interview(rs.getString(4));
                i.setStatut(rs.getString(5));

            }

        } catch (SQLException ex) {
            Logger.getLogger(InterviewService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    // select 
    public List<Interview> fetchInterviews() {
        List<Interview> interviews = new ArrayList<>();

        try {
            String req = "SELECT * FROM `interview`";
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Interview i = new Interview();
                i.setId_interview(rs.getInt(1));
                i.setDate_interview(rs.getDate(2));
                i.setUpdate_interview(rs.getDate(3));
                i.setStatut(rs.getString(4));
                i.setType_interview(rs.getString(5));
                interviews.add(i);

            }
        } catch (SQLException ex) {
            Logger.getLogger(InterviewService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return interviews;
    }
    //update

    public void updateInterviewById(Interview i) {

        try {
            String req = "UPDATE `interview` SET `date_interview`=?, `update_interview`=?,"
                    + "`type_interview`=?,`statut`=? WHERE id_interview=" + i.getId_interview();
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setDate(1,(Date) i.getDate_interview());
            ps.setDate(2,(Date) i.getUpdate_interview());
            ps.setString(3, i.getType_interview());
            ps.setString(4, i.getStatut());
            ps.executeUpdate();
            System.out.println("table interview modifiée");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    //delete
    public void deleteInterview(int id){
        String req="DELETE FROM `interview` WHERE id_interview= ?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("ligne supprimée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
                
        
    }

}
