/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fsgha
 */
public class MyConnection {
    public String url ="jdbc:mysql://localhost:3306/e-hire-congé";
    public String login ="root";
    public String pwd ="";
    Connection cnx;

    public MyConnection(){
        try {
        cnx =  DriverManager.getConnection(url, login, pwd);
        System.out.println("Connexion établie avec succes");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
}
