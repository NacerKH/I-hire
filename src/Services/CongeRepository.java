/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.AppDbContext;
import Models.Conge;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Enums.CongeType;
import Enums.StatusCongeType;
import java.sql.Date;

public class CongeRepository {

    Connection Connection;

    // <editor-fold defaultstate="collapsed" desc="Init Creation Instance -> Singleton">
    private CongeRepository() {
        Connection = AppDbContext.GetInstance().GetDbConnection();
    }
    private static CongeRepository instance = new CongeRepository();

    public static CongeRepository GetInstance() {
        return instance;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Main Methods">
    // <editor-fold defaultstate="collapsed" desc="GetAll">
    public ArrayList<Conge> GetAll() {
        ArrayList<Conge> resultList = new ArrayList<Conge>();
        try {
            String req = "SELECT * FROM conge";
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery();

            while (result.next()) {

                try {
                    resultList.add(InitConge(result));
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
    public Conge GetById(int id) {
        try {
            String req = "SELECT * FROM Conge WHERE Id = " + id + ";";
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery();
            while (result.next()) {

                try {
                    return InitConge(result);
                } catch (Exception ex) {
                    System.err.println("[Exception] " + ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return null;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Post">
    public boolean Post(Conge model) {
        try {
            String req = "INSERT INTO `Conge`(`Type`, `StartDate`, `EndDate`, `Status`, `Description`, `ValidationDate`, `CreatedDate`, `UpdatedDate`)"
                        + " VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = Connection.prepareStatement(req);

            ps.setString(1, model.getType().name());
            ps.setDate(2, (Date) model.getStartDate());
            ps.setDate(3, (Date) model.getEndDate());
            ps.setString(4, model.getStatus().name());
            ps.setString(5, model.getDescription());
            ps.setDate(6, new java.sql.Date(model.getValidationDate().getTime()));
            ps.setTimestamp(7, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setTimestamp(8, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return false;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Put">
    public boolean Put(Conge model) {

        try {
            String req = "UPDATE `Conge` SET Type = ?, StartDate = ? , EndDate = ?, Status = ?, Description = ?, ValidationDate = ? "
                        + "WHERE Id = " + model.getId();

            PreparedStatement ps = Connection.prepareStatement(req);

            ps.setString(1, model.getType().name());
            ps.setDate(2, (Date) model.getStartDate());
            ps.setDate(3, (Date) model.getEndDate());
            ps.setString(4, model.getStatus().name());
            ps.setString(5, model.getDescription());
            ps.setDate(6, new java.sql.Date(model.getValidationDate().getTime()));

            //ps.setDate(8, new Date(model.getCreatedDate().getTime()));
            ps.setTimestamp(8, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return false;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Delete">
    public boolean Delete(int id) {

        try {
            String req = "DELETE FROM Conge WHERE Id = ? ; ";
            PreparedStatement ps = Connection.prepareStatement(req);

            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return false;
    }
    // </editor-fold>

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Other Methods">
    // <editor-fold defaultstate="collapsed" desc="InitConge">
    private Conge InitConge(ResultSet result) {
        try {
            CongeType type = CongeType.valueOf(result.getString("type"));
            StatusCongeType typestatus = StatusCongeType.valueOf(result.getString("status"));
            return new Conge(
                        type,
                        result.getDate("StartDate"),
                        result.getDate("EndDate"),
                          result.getString("Description"),
                        typestatus,
                        result.getDate("ValidationDate")
                      
            );

        } catch (SQLException ex) {
            System.err.println("[Exception] " + ex.getMessage());
        }

        return null;
    }
    // </editor-fold>

    // </editor-fold>
}
