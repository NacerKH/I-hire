/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HireSolution.services;

import HireSolution.entities.Support;
import HireSolution.util.MaConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Maryouma
 */
public class SupportService {
    
     // var
     Connection cnx = MaConnexion.getInstance().getCnx();
    // create
     public void InsertSupport(Support S) throws SQLException{
         String req = "INSERT INTO `support`(`id_support`, `id_interview`, `description_offre`, `cv_candidate`)"
                 + " VALUES (?,?,?,?)";
         PreparedStatement ps = cnx.prepareStatement(req);
     }
    
}
