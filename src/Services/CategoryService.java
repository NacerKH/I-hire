/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Category;
import Utils.AppDbContext;
import java.util.ArrayList;

/**
 *
 * @author wawa
 */
public class CategoryService {

    Connection Connection;  

    // <editor-fold defaultstate="collapsed" desc="Init Creation Instance -> Singleton">
    private CategoryService() 
    {
        Connection = AppDbContext.GetInstance().GetDbConnection(); 
    }
    private static CategoryService instance = new CategoryService(); 
    
    public static CategoryService GetInstance() 
    {
        return instance; 
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Main Methods">
    
    // <editor-fold defaultstate="collapsed" desc="GetAll">
    public ArrayList<Category> GetAll()
    {
        ArrayList<Category> resultList = new ArrayList<Category>(); 
        try
        {
            String req = "SELECT * FROM Category"; 
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
    public Category getCategoryByID(int id){
        
        Category c = new Category();
        
        try {
            String req = "SELECT * from Category WHERE id_cat = ?";
            PreparedStatement ps = Connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                c.setId_cat(rs.getInt(1));
                c.setName_cat(rs.getString(2));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Post">
    public void Post(Category c){
        
        try {
            String req = "INSERT INTO `category`(`name_cat`) VALUES (?)";
            
            PreparedStatement ps = Connection.prepareStatement(req);
            ps.setString(1, c.getName_cat());
            ps.executeUpdate();
            System.out.println("Category added successfully!");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
     // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Put">
    public void Put(Category p){
        try {
            String Request3 ="UPDATE `category` SET `name_cat`=? WHERE id_cat ="+ p.getId_cat();
            PreparedStatement ps = Connection.prepareStatement(Request3);
            ps.setString(1, p.getName_cat());
            ps.executeUpdate();
            System.out.println("Catégorie modifié");
        } catch (SQLException ex) {
            Logger.getLogger(JobOfferService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Delete">
    public void Delete(int id){
        try {
            String Request4 =  "DELETE FROM category WHERE Id = ? ; ";
            PreparedStatement ps = Connection.prepareStatement(Request4);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("JobOffer supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(JobOfferService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    // </editor-fold>
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Other Methods">
    
    // <editor-fold defaultstate="collapsed" desc="InitUser">
    private Category InitUser(ResultSet result)
    {
        try
        {
            return new Category(
                result.getInt("id_cat"),
                result.getString("name_cat")
            ); 
             
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
