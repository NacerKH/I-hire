/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.CondidatEmployee.src.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Envirement.env;

import Modules.CondidatEmployee.src.Contracts.EmployeeCondidatInterface;
import java.util.Date;

/**
 *
 * @author KALI 
 */
public class WriteEmployeeCondidatService implements EmployeeCondidatInterface {

    static Connection cnx = env.getConnection();

    @Override
    public void InsertEmpCondidat(int offer_id, int user_id, String Cv_url, int status) {
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
}
