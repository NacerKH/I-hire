/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.CondidatEmployee.src.Services;

import Envirement.env;
import Modules.CondidatEmployee.src.Contracts.EmployeeCondidatInterface;
import Modules.CondidatEmployee.src.Models.EmployeesCondidat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class CrudCondidatEmployeeService implements EmployeeCondidatInterface {

    static Connection cnx = env.getConnection();
    //Add 

    @Override
    public void AddEmpCondidat(int offer_id, int user_id, String Cv_url, int status) {
        Date Currentdate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(Currentdate.getTime());
        try {

            String req2 = "INSERT INTO `condidatEmployees`(`offer_id`,`user_id`, `cv_url`,`postedate`,`status`)"
                    + " VALUES (?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req2);
            ps.setInt(1, offer_id);
            ps.setInt(2, user_id);
            ps.setString(3, Cv_url);
            ps.setDate(4, sqlDate);
            ps.setInt(5, status);

            ps.executeUpdate();

            System.out.println("CondidatEmpolyer Added with success : *");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Select  
    @Override
    
    public List<EmployeesCondidat> fetchEmpCs() {

        List<EmployeesCondidat> Emc = new ArrayList<>();

        try {

            String req = "SELECT * FROM condidatEmployees";

            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EmployeesCondidat Ec = new EmployeesCondidat();


               Ec.setId(rs.getInt(1));
                Ec.setOffer_id( rs.getInt(2));
                Ec.setUser_id(rs.getInt(3));
                Ec.setCv_url(rs.getString(4));               
                Ec.setPostedate(rs.getDate(5));
                Ec.setStatus(rs.getInt(5));

                
     

                Emc.add(Ec);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CrudCondidatEmployeeService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Emc;
    }
}
