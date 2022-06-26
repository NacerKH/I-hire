/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Models.Candidat;
import Utils.AppDbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author KHLIFI-MED
 */
public class CandidatRepository {
    
 Connection Connection;

    // <editor-fold defaultstate="collapsed" desc="Init Creation Instance -> Singleton">
    CandidatRepository() {
        Connection = AppDbContext.GetInstance().GetDbConnection();
    }
    private static CandidatRepository instance = new CandidatRepository();

    public static CandidatRepository GetInstance() {
        return instance;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Main Methods">
    
    // <editor-fold defaultstate="collapsed" desc="GetAll">
    public ArrayList<Candidat> GetAll() {
        ArrayList<Candidat> resultList = new ArrayList<Candidat>();
        try {
            String req = "SELECT * FROM candidat";
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery();

            while (result.next()) {

                try {
                    resultList.add(InitCandidat(result));
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
    public Candidat GetById(int id) {
        try {
            String req = "SELECT * FROM candidat WHERE Id = " + id + ";";
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery();
            while (result.next()) {

                try {
                    return InitCandidat(result);
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
    public boolean Post(Candidat model) {
        System.out.println (model);
                
        try {
            String req = "INSERT INTO `candidat`(`fullName`, `phoneNumber`, `email`, `cv_url`,  `createdDate`, `updatedDate`,`idIntereviewDate`)"
                    + " VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = Connection.prepareStatement(req);

           // ps.setInt(1, model.getId());
            ps.setString(1, model.getFullName());
            ps.setString(2, model.getPhoneNumber());
            ps.setString(3, model.getEmail());
            ps.setString(4, model.getCv_url());
            ps.setDate(5, new java.sql.Date(model.getCreatedDate().getTime()));
            ps.setDate(6, new java.sql.Date(model.getUpdatedDate().getTime()));
            ps.setInt(7, model.getIdIntereviewDate());

            ps.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return false;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Put">
    public boolean Put(Candidat model) {

        try {
            String req = "UPDATE `candidat` SET fullName = ?, phoneNumber = ? , email = ?, cv_url = ?, createdDate = ?, updatedDate = ?, idIntereviewDate = ? WHERE Id = " + model.getId();

            PreparedStatement ps = Connection.prepareStatement(req);

         //   ps.setInt(1, model.getId());
            ps.setString(1, model.getFullName());
            ps.setString(2, model.getPhoneNumber());
            ps.setString(3, model.getEmail());
            ps.setString(4, model.getCv_url());
            ps.setDate(5, new java.sql.Date(model.getCreatedDate().getTime()));
            ps.setDate(6, new java.sql.Date(model.getUpdatedDate().getTime()));
            ps.setInt(7, model.getIdIntereviewDate());
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
            String req = "DELETE FROM candidat WHERE Id = ? ; ";
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
    
    // <editor-fold defaultstate="collapsed" desc="GetAllByIntereviewDateId">
    public ArrayList<Candidat> GetAllByIntereviewDateId(int id) {
        ArrayList<Candidat> resultList = new ArrayList<Candidat>();
        try {
            String req = "SELECT * FROM candidat WHERE idIntereviewDate = " + id + ";";
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery();

            while (result.next()) {

                try {
                    resultList.add(InitCandidat(result));
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

    // <editor-fold defaultstate="collapsed" desc="DeleteIntereviewDateCandidat(">
    public boolean DeleteIntereviewDateCandidat(int id) {

        try {
            String req = "DELETE FROM candidat  WHERE idIntereviewDate = " + id + ";";
            PreparedStatement ps = Connection.prepareStatement(req);
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
    
    // <editor-fold defaultstate="collapsed" desc="InitCandidat">
    private Candidat InitCandidat(ResultSet result) {
        try {
            return new Candidat(
                    result.getString("fullName"),
                    result.getString("phoneNumber"),
                    result.getString("email"),
                    result.getString("cv_url"),
                    result.getDate("createdDate"),
                    result.getDate("updatedDate"),
                    result.getInt("idIntereviewDate"));

        } catch (SQLException ex) {
            System.err.println("[Exception] " + ex.getMessage());
        }

        return null;
    }
    // </editor-fold>

    // </editor-fold>   

  
}
