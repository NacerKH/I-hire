/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.AppDbContext;
import Models.CondidatEmployee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Enums.Status;
import java.sql.Date;

/**
 *
 * @author Kali
 */
public class CondidatEmployeeRepository {

    Connection Connection;

    // <editor-fold defaultstate="collapsed" desc="Init Creation Instance -> Singleton">
    public CondidatEmployeeRepository() {
        Connection = AppDbContext.GetInstance().GetDbConnection();
    }
    private static CondidatEmployeeRepository instance = new CondidatEmployeeRepository();

    public static CondidatEmployeeRepository GetInstance() {
        return instance;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Main Methods">
    
    // <editor-fold defaultstate="collapsed" desc="GetAll">
    public ArrayList<CondidatEmployee> GetAll() {
        ArrayList<CondidatEmployee> resultList = new ArrayList<CondidatEmployee>();
        try {
            String req = "SELECT * FROM condidatEmployees ";
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery();

            while (result.next()) {

                try {

                    resultList.add(InitCondidatEmployee(result));
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
    public CondidatEmployee GetById(int id) {
        try {
            String req = "SELECT * FROM condidatEmployees WHERE Id = " + id + ";";
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery();
            while (result.next()) {

                try {
                    return InitCondidatEmployee(result);
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
    public boolean Post(CondidatEmployee model) {
        try {
            String req = "INSERT INTO `condidatEmployees`(`offer_id`,`user_id`, `cv_url`,`CreatedDate`,`UpdatedDate`,`status`)"
                    + " VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = Connection.prepareStatement(req);

            ps.setInt(1, model.getOffer_id().getId());
            ps.setInt(2, model.getUser_id().getId());
            ps.setString(3, model.getCv_url());
            ps.setTimestamp(4, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setTimestamp(5, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setString(6, model.getStatus().name());

            ps.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }

        return false;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Put">
    public boolean Put(CondidatEmployee model) {

        try {
            String req = "UPDATE condidatEmployees  SET  offer_id=?,user_id=?, cv_url=?,CreatedDate=?,UpdatedDate=?,status=?    WHERE id = ?";

            PreparedStatement ps = Connection.prepareStatement(req);
           
            ps.setInt(1, model.getOffer_id().getId());
            ps.setInt(2, model.getUser_id().getId());
            ps.setString(3, model.getCv_url());
            ps.setTimestamp(4, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setTimestamp(5, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setString(6, model.getStatus().name());
            ps.setInt(7, model.getId());

            ps.executeUpdate();

            System.out.println("Condidat Employee "
                    + model.getOffer_id() + " added successfully with " + model.getUser_id());
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
            String req = "DELETE FROM condidatEmployees  WHERE Id = ? ; ";
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
    
    // <editor-fold defaultstate="collapsed" desc="InitCondidatEmployee">
    private CondidatEmployee InitCondidatEmployee(ResultSet result) {
        try {
          
            Status type = Status.valueOf(result.getString("status"));
           JobOfferService jb= JobOfferService.GetInstance();
           UserServices userSer =UserServices.GetInstance();
            return new CondidatEmployee(
                   jb.GetById(result.getInt("offer_id")) ,
                   userSer.GetById(result.getInt("user_id")) ,
                    result.getString("cv_url"),
                    type,
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
