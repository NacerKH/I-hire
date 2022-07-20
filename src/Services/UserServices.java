/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.AppDbContext;
import Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Enums.UserType;
import java.sql.Date;

public class UserServices 
{
    Connection Connection;  
    
    // <editor-fold defaultstate="collapsed" desc="Init Creation Instance -> Singleton">
    private UserServices() 
    {
        Connection = AppDbContext.GetInstance().GetDbConnection(); 
    }
    private static UserServices instance = new UserServices(); 
    
    public static UserServices GetInstance() 
    {
        return instance; 
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Main Methods">
    
    // <editor-fold defaultstate="collapsed" desc="GetAll">
    public ArrayList<User> GetAll()
    {
        ArrayList<User> resultList = new ArrayList<User>(); 
        try
        {
            String req = "SELECT * FROM User"; 
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery(); 
                 
            while (result.next()) {
                
                try
                {
                    resultList.add(InitUser(result)); 
                }
                catch(Exception ex)
                {
                    System.err.println("[Exception] " + ex.getMessage());
                }
            }
        }
        catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }
        
        return resultList; 
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="GetById">
    public User GetById(int id)
    {
        try
        {
            String req = "SELECT * FROM User WHERE Id = " + id + ";"; 
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery(); 
            while (result.next()) {
                
                try
                {
                    return InitUser(result); 
                }
                catch(Exception ex)
                {
                    System.err.println("[Exception] " + ex.getMessage());
                }
            }
        }
        catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }
        
        return null; 
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="GetByUserName">
    public User GetByUserName(String userName)
    {
        try
        {
            String req = "SELECT * FROM User WHERE UserName = '" + userName + "';"; 
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery(); 
            while (result.next()) {
                
                try
                {
                    return InitUser(result); 
                }
                catch(Exception ex)
                {
                    System.err.println("[Exception] " + ex.getMessage());
                }
            }
        }
        catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }
        
        return null; 
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Post">
    public boolean Post(User model)
    {
        try
        {
            String req =  "INSERT INTO `User`(`UserName`, `Password`, `Email`, `UserType`, `ProfilePicture`, `Birthday`, `JobTitle`, `CreatedDate`, `UpdatedDate`)" + 
                      " VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = Connection.prepareStatement(req);
            
            ps.setString(1, model.getUserName());
            ps.setString(2, model.getPassword());
            ps.setString(3, model.getEmail());
            ps.setString(4, model.getUserType().name());
            ps.setString(5, model.getProfilePicture());
            ps.setDate(6, new java.sql.Date(model.getBirthday().getTime()));
            ps.setString(7, model.getJobTitle());
            ps.setTimestamp(8, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setTimestamp(9, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.executeUpdate();
            
            return true; 
            
        }
        catch (SQLException ex) {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }
        
        return false; 
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Put">
    public boolean Put(User model)
    {
    
        try
        {
            String req =  "UPDATE `User` SET UserName = ?, Password = ? , Email = ?, UserType = ?, ProfilePicture = ?, Birthday = ?, JobTitle = ?, UpdatedDate = ? "
                    + "WHERE Id = " + model.getId() ; 
                    
                       
            PreparedStatement ps = Connection.prepareStatement(req);

            ps.setString(1, model.getUserName());
            ps.setString(2, model.getPassword());
            ps.setString(3, model.getEmail());
            ps.setString(4, model.getUserType().name());
            ps.setString(5, model.getProfilePicture());
            ps.setDate(6, new java.sql.Date(model.getBirthday().getTime()));
            ps.setString(7, model.getJobTitle());
            ps.setDate(8, new Date(model.getCreatedDate().getTime()));
            ps.setTimestamp(8, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.executeUpdate();
            
            return true; 
            
        }
        catch (SQLException ex) 
        {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }
        
        return false; 
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Delete">
     public boolean Delete(int id)
    {
    
        try
        {
            String req =  "DELETE FROM User WHERE Id = ? ; "; 
            PreparedStatement ps = Connection.prepareStatement(req);

            ps.setInt(1, id);
            ps.executeUpdate();
            return true; 
        }
        catch (SQLException ex) 
        {
            System.err.println("[SQL Exception] " + ex.getMessage());
        }
        
        return false; 
    }
    // </editor-fold>
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Other Methods">
    
    // <editor-fold defaultstate="collapsed" desc="InitUser">
    private User InitUser(ResultSet result)
    {
        try
        {
            UserType type = UserType.valueOf(result.getString("UserType")); 
            return new User(
                            result.getString("UserName"),
                            result.getString("Password"),
                            result.getString("Email"),
                            type,
                            result.getString("ProfilePicture"),
                            result.getDate("Birthday"),
                            result.getString("JobTitle"),
                            result.getInt("Id"),
                            result.getDate("CreatedDate"),
                            result.getDate("UpdatedDate")); 
        }
        catch(SQLException ex)
        {
            System.err.println("[Exception] " + ex.getMessage());
        }
       
        return null; 
    }
    // </editor-fold>
    
    // </editor-fold>
}
