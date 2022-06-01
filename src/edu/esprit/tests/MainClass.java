/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tests;

import java.sql.Connection;
import edu.esprit.utils.MyConnection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;


/**
 *
 * @author fsgha
 */


    
public class MainClass {
    private final static String url ="jdbc:mysql://localhost:3306/e-hire-congé";
    private final static String login ="root";
    private final static String pwd = "";
    static Connection cnx;


    public static void main(String [] args){
        try {
            //Data Base
            
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Congratulations! Connexion etablie avec succes");
            
        } catch (SQLException ex) {
            System.out.println(ex);        }
        
       // MyConnection mc =new MyConnection ();
        
    
     

// Ajout
/////Conge c = new Conge("Annuel", "prevu", "Conge annuel 2022");
java.util.Date myDate = new java.util.Date("10/10/2020");
java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
Conge c = new Conge("nns", sqlDate, new Date(2022, 06, 16), "rr", "eee", new Date(2022, 16, 13));
        try {
            
//            Statement st = cnx.createStatement();
//            String req = "INSERT INTO `Congé`(`type`, `DateDebut`, `DateFin`, `status`, `description`, `DateValidation`) VALUES ('"
//                    + c.gettype() + "','"
//                    + p.getDateDebut()+"','"
//                    + p.getDateFin() +"','"
//                    + p.getstatus() +"')";
//                    + p.getdescription()+"','"
//                    + p.getDateValidation() +"','"
//            st.executeUpdate(req);
            String req2 = "INSERT INTO `Congé`(`type`, `DateDebut`, `DateFin`, `status`, `description`, `DateValidation` )"
                    + " VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req2);
            ps.setString(1, c.getType());
            ps.setDate(2, c.getDateDebut());
            ps.setDate(3, c.getDateFin());
            ps.setString(4, c.getStatus());
            ps.setString(5, c.getDescription());
            ps.setDate(6, c.getDateValidation());
            ps.executeUpdate();
            
            System.out.println("Congé ajouté avec succes. En instance de validation");
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
}

