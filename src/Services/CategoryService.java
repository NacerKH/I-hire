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
import Utils.MyConnection;

/**
 *
 * @author wawa
 */
public class CategoryService {
    //var
    Connection cnx = MyConnection.getInstance().getCnx();
    
    //Create
    public void insertCategory(Category c){
        
        try {
            String req = "INSERT INTO `category`(`name_cat`) VALUES (?)";
            
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, c.getName_cat());
            ps.executeUpdate();
            System.out.println("Category added successfully!");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    //Select by id
    public Category getCategoryByID(int id){
        
        Category c = new Category();
        
        try {
            String req = "SELECT * from Category WHERE id_cat = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
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
    //delete
    public void DeleteCategory(int id){
        try {
            String Request4 =  "DELETE FROM category WHERE Id = ? ; ";
            PreparedStatement ps = cnx.prepareStatement(Request4);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("JobOffer supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(JobOfferService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       //update
    public void UpdateCategory(Category p){
        try {
            String Request3 ="UPDATE `category` SET `name_cat`=? WHERE id_cat ="+ p.getId_cat();
            PreparedStatement ps = cnx.prepareStatement(Request3);
            ps.setString(1, p.getName_cat());
            ps.executeUpdate();
            System.out.println("Catégorie modifié");
        } catch (SQLException ex) {
            Logger.getLogger(JobOfferService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
