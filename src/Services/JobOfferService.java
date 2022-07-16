/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Category;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.JobOffer;
import Utils.AppDbContext;

/**
 *
 * @author wawa
 */
public class JobOfferService {

    Connection Connection;  
    
    // <editor-fold defaultstate="collapsed" desc="Init Creation Instance -> Singleton">
    private JobOfferService() 
    {
        Connection = AppDbContext.GetInstance().GetDbConnection(); 
    }
    private static JobOfferService instance = new JobOfferService(); 
    
    public static JobOfferService GetInstance() 
    {
        return instance; 
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Main Methods">
    
    // <editor-fold defaultstate="collapsed" desc="GetAll">
    public ArrayList<JobOffer> GetAll()
    {
        ArrayList<JobOffer> resultList = new ArrayList<JobOffer>(); 
        try
        {
            String req = "SELECT * FROM joboffer"; 
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery(); 
                 
            while (result.next()) {
                
                try
                {
                    resultList.add(InitJobOffer(result)); 
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
    public JobOffer GetById(int id)
    {
        try
        {
            String req = "SELECT * FROM joboffer WHERE id = " + id + ";"; 
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery(); 
            while (result.next()) {
                
                try
                {
                    return InitJobOffer(result); 
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
     public void Post(JobOffer p) {
        try {

            String Request = "INSERT INTO `joboffer`(`jobDescription`, `AverageSallary`, `totalPlaces`, `Status`, `CreatedDate`, `UpdatedDate`, `category`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = Connection.prepareStatement(Request);
            ps.setString(1, p.getJobDescription());
            ps.setInt(2, p.getAverageSallary());
            ps.setInt(3, p.getTotalPlaces());
            ps.setString(4, p.getStatus());
            ps.setDate(5, (Date) p.getCreatedDate());
            ps.setDate(6, (Date) p.getUpdatedDate());
            ps.setInt(7, p.getCategory().getId_cat());
            ps.executeUpdate();
            System.out.println("JobOffer ajouté");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Put">
      public void Put(JobOffer p){
        try {
            String Request3 ="UPDATE `joboffer` SET `jobDescription`=?,`AverageSallary`=?,`totalPlaces`=?,`Status`=?,`CreatedDate`=?,`UpdatedDate`=?,`category`=? WHERE id ="+ p.getId();
            PreparedStatement ps = Connection.prepareStatement(Request3);
            ps.setString(1, p.getJobDescription());
            ps.setInt(2, p.getAverageSallary());
            ps.setInt(3, p.getTotalPlaces());
            ps.setString(4, p.getStatus());
            ps.setDate(5, (Date) p.getCreatedDate());
            ps.setDate(6, (Date) p.getUpdatedDate());
            ps.setInt(7, p.getCategory().getId_cat());
            ps.executeUpdate();
            System.out.println("JobOffer modifié");
        } catch (SQLException ex) {
            Logger.getLogger(JobOfferService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // </editor-fold>
     
    // <editor-fold defaultstate="collapsed" desc="Delete">
    public void Delete(int id){
        try {
            String Request4 =  "DELETE FROM joboffer WHERE Id = ? ; ";
            PreparedStatement ps = Connection.prepareStatement(Request4);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("JobOffer supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(JobOfferService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    // </editor-fold>
     // get joboff
         public ArrayList<String> GetJoboffersCat()
    {
        ArrayList<String> resultList = new ArrayList<String>(); 
         
        try
        {
            String req = "SELECT `jobDescription`, `AverageSallary`, `totalPlaces`, `Status`, `CreatedDate`, `UpdatedDate`, `name_cat` FROM `joboffer` JOIN `category` ON joboffer.category = category.id_cat"; 
            PreparedStatement ps = Connection.prepareStatement(req);
            ResultSet result = ps.executeQuery(); 
                 
            while (result.next()) {
                
                try
                {
                    resultList.add(result.getString(1));
                    resultList.add(result.getString(2));
                    resultList.add(result.getString(3));
                    resultList.add(result.getString(4));
                    resultList.add(result.getString(5));
                    resultList.add(result.getString(6));
                    resultList.add(result.getString(7));
           
                    
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
    
    //update
   
    //delete
    

    // <editor-fold defaultstate="collapsed" desc="Other Methods">
    
    // <editor-fold defaultstate="collapsed" desc="InitJobOffer">
    private JobOffer InitJobOffer(ResultSet result)
    {
        try
        {
             
            return new JobOffer(
                result.getInt("Id"),
                result.getString("jobDescription"),
                result.getInt("AverageSallary"),
                result.getInt("totalPlaces"),
                result.getString("Status"),
                result.getDate("CreatedDate"),
                result.getDate("UpdatedDate"),
                CategoryService.GetInstance().getCategoryByID(result.getInt("category"))
                   
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
