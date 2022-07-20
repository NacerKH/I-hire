/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Enums.Status;
import Models.CandidatOffre;
import Models.CondidatEmployee;
import Models.TableCandidatOffreDto;
import Models.Test;
import Utils.AppDbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author e.bentijani
 */
public class CandidatOffreService {

    Connection Connection;

    // <editor-fold defaultstate="collapsed" desc="Init Creation Instance -> Singleton">
    CandidatOffreService() {
        Connection = AppDbContext.GetInstance().GetDbConnection();
    }
    private static CandidatOffreService instance = new CandidatOffreService();

    public static CandidatOffreService GetInstance() {
        return instance;
    }

    public ArrayList<CandidatOffre> GetAllByIdOffre(int id) {
        ArrayList<CandidatOffre> resultList = new ArrayList<CandidatOffre>();
        try {
            String req = "SELECT * FROM offercandidat WHERE offerId = " + id + ";";
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery();

            while (result.next()) {

                try {
                    resultList.add(InitCandidatOffre(result));
                } catch (Exception ex) {
                    System.err.println("[Exception] " + ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return resultList;
    }

    // <editor-fold defaultstate="collapsed" desc="InitCandidatOffre ">
    private CandidatOffre InitCandidatOffre(ResultSet result) {
        try {

            Status type = Status.valueOf(result.getString("status"));

            return new CandidatOffre(
                    result.getInt("id"),
                    result.getInt("offerId"),
                    result.getInt("condidatId"),
                    result.getDate("postedDate"),
                    type,
                    result.getString("passwordTest"),
                    result.getInt("idTest")
            );
        } catch (SQLException ex) {
            System.err.println("[Exception] " + ex.getMessage());
        }

        return null;
    }

    // </editor-fold>
    public boolean AffectTest(TableCandidatOffreDto model) {

        try {
            String req = "UPDATE `offercandidat` SET status = ?, idTest = ? , passwordTest = ? WHERE id = " + model.getId();

            PreparedStatement ps = Connection.prepareStatement(req);

            ps.setString(1, model.getStatus());
            ps.setInt(2, model.getIdTest());
            ps.setString(3, model.getPasswordTest());

            ps.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return false;
    }

    public CandidatOffre GetById(int id) {
        try {
            String req = "SELECT * FROM offercandidat WHERE id = " + id + ";";
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery();
            while (result.next()) {

                try {
                    return InitCandidatOffre(result);
                } catch (Exception ex) {
                    System.err.println("[Exception] " + ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return null;
    }

    public boolean setStatus(CandidatOffre model) {

        try {

            String req = "UPDATE `offercandidat` SET status = ? WHERE id = " + model.getId() + ";";

            PreparedStatement ps = Connection.prepareStatement(req);

            ps.setString(1, model.getStatus().toString());

            ps.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return false;
    }
}
