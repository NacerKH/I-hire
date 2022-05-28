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
import Modules.CondidatEmployee.src.Models. EmployeesCondidat;
import  Modules.CondidatEmployee.src.Contracts.EmployeeCondidatInterface;
import javax.xml.ws.BindingType;

/**
 *
 * @author LENOVO
 */
@BindingType
public class WriteEmployeeCondidatService implements EmployeeCondidatInterface  {
       static  Connection cnx  =env.getConnection();
     
    @Override
     public void  InsertEmpCondidat( int offer_id,int  user_id, String Cv_url, int status){
  
   
      try {
              
            String req2 = "INSERT INTO `condidatEmployees`(`offer_id`,`user_id`, `cv_url`,`status`)"
                    + " VALUES (?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req2);
          ps.setInt(1,  offer_id);
            ps.setInt(2, user_id);
            ps.setString(3,Cv_url);        
            ps.setInt(4, status);

           // ps.setDate(5, Ec.getPostedate());        
           // ps.setInt(5, Ec.getStatus());   
           

            
            ps.executeUpdate();
            
            System.out.println("condidatEmpolyer ajoutée avec succes");
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
}
}

