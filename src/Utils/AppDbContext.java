/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Utils.DbConfig; 

public class AppDbContext {
    
    Connection Connection; 
    
    // <editor-fold defaultstate="collapsed" desc="Init Creation Instance -> Singleton">
    private AppDbContext() { }
    private static AppDbContext instance = new AppDbContext(); 
    
    public static AppDbContext GetInstance() 
    {
        return instance; 
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Methods">
     
    // <editor-fold defaultstate="collapsed" desc="Init SQL Connection">
    public boolean InitSqlConnection() 
    {
        try
        {
            Connection = DriverManager.getConnection(DbConfig.URL, DbConfig.UserName, DbConfig.Password); 
            return true; 
        }
        catch(SQLException ex)
        {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }
        return false; 
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get Db Connection">
    public Connection GetDbConnection() 
    {
        if(Connection != null)
            return Connection; 
        else 
        {
            if(InitSqlConnection())
                return Connection; 
        }
        return null; 
    }
    // </editor-fold>

    // </editor-fold>
    
}
