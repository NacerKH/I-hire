/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Maryouma
 */
public class MaConnexion {

    //var
    private Connection cnx;
    static MaConnexion instance = null;

    //constructor
    private MaConnexion() {
        try {
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/hiresolution", "root", "");
            System.out.println("Connexion etablie!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    //getters 
    public Connection getCnx() {
        return cnx;
    }

    public static MaConnexion getInstance() {

        if (instance == null) {
            instance = new MaConnexion();
        }

        return instance;
    }

}
