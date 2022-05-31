/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HireSolution.services;

import HireSolution.entities.Interview;
import HireSolution.util.MaConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String req = "INSERT INTO `interview`(`id_interview`, `date_interview`, `update_interview`, `type_interview`, `statut`) "
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, i.getId_interview());
            ps.setDate(2, i.getDate_interview());
            ps.setDate(3, i.getUpdate_interview());
            ps.setString(4, i.getType_interview());
            ps.setString(5, i.getStatut());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(InterviewService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //select by id
    public Interview getInterviewById(Interview i) {
        String req = "SELECT * FROM `interview` WHERE `id_interview`=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, i.getId_interview());
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

}
