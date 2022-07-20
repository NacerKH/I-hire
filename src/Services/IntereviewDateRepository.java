/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Candidat;
import Models.IntereviewDate;
import Utils.AppDbContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;


/**
 *
 * @author KHLIFI-MED
 */
public class IntereviewDateRepository {
    
    Connection Connection;
    IntereviewDate inter;

    // <editor-fold defaultstate="collapsed" desc="Init Creation Instance -> Singleton">
    public IntereviewDateRepository() {
        Connection = AppDbContext.GetInstance().GetDbConnection();
    }
    private static IntereviewDateRepository instance = new IntereviewDateRepository();
    private static CandidatRepository instancecandidatRepo = new CandidatRepository();

    public static IntereviewDateRepository GetInstance() {
        return instance;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Main Methods">
    // <editor-fold defaultstate="collapsed" desc="GetAll">
    public ArrayList<IntereviewDate> GetAll() {
        ArrayList<IntereviewDate> resultList = new ArrayList();
        try {
            String req = "SELECT * FROM intereviewDate";
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                try {
                     resultList.add(InitIntereviewDate(result)); 
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
    public IntereviewDate GetById(int id) {
        try {
            String req = "SELECT * FROM intereviewDate WHERE Id = " + id + ";";
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                return InitIntereviewDate(result);                  
            }
        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return null;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Post">
    public boolean Post(IntereviewDate model) {
        try {

            String req = "INSERT INTO `intereviewdate`(`intrvDate`, `createdDate`, `updatedDate`)"
                    + " VALUES (?,?,?)";
            PreparedStatement ps = Connection.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
          //  ps.setInt(1, model.getId());
            ps.setDate(1, new Date(model.getIntrvDate().getTime()));
            ps.setDate(2, new java.sql.Date(model.getCreatedDate().getTime()));
            ps.setDate(3, new java.sql.Date(model.getUpdatedDate().getTime()));
            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idq = generatedKeys.getInt(1);
                    System.out.println(idq);
                    
                    /*
                    // ???
                    model.getCandidat().forEach(q -> {
                        q.setIdIntereviewDate(idq);
                        instancecandidatRepo.Post(q);
                    });
                    */
                    
                } else {
                    System.err.println("Creating test failed, no ID obtained.");
                    return false;
                }
            }
            return true;
        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }
        return false;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Put">
    public boolean Put(IntereviewDate model) {

        try {
            String req = "UPDATE `intereviewDate` SET intrvDate = ?, createdDate = ?, updatedDate = ?"
                    + "WHERE Id = " + model.getId();

            PreparedStatement ps = Connection.prepareStatement(req);

            
            ps.setDate(1, new Date(model.getIntrvDate().getTime()));
            ps.setDate(2, new java.sql.Date(model.getCreatedDate().getTime()));
            ps.setDate(3, new java.sql.Date(model.getUpdatedDate().getTime()));
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
            if (instancecandidatRepo.DeleteIntereviewDateCandidat(id) == true) {
                String req = "DELETE FROM intereviewDate WHERE Id = ? ; ";
                PreparedStatement ps = Connection.prepareStatement(req);
                ps.setInt(1, id);
                ps.executeUpdate();
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return false;
    }
    // </editor-fold>

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Other Methods">
    // <editor-fold defaultstate="collapsed" desc="InitUser">
    private IntereviewDate InitIntereviewDate(ResultSet result) {
        try {
            return new IntereviewDate(
                result.getDate("intrvDate"),
                (Candidat)result.getObject("candidat"),
                result.getInt("Id"),
                result.getDate("CreatedDate"),
                result.getDate("UpdatedDate")
            ); 
        } catch (SQLException ex) {
            System.err.println("[Exception] " + ex.getMessage());
        }

        return null;
    }
    // </editor-fold>

    // </editor-fold>
}
