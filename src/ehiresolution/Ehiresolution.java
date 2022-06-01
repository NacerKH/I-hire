/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehiresolution;
import Infrastructure.AppDbContext;
import Entities.CondidatEmployee;
import Enums.CondidatEmployeeType;
import Repositories.CondidatEmployeeRepository;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author KALI 
 */
public class Ehiresolution {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

     CondidatEmployeeRepository condidatEmployeeRepo = CondidatEmployeeRepository.GetInstance(); 
        
        /*
         *  To Test Post User
         condidatEmployeeRepo.Post(new CondidatEmployee ("dhiaeddsn1", "123456789", "dhia1@email.com",UserType.RH , "imguri", new Date(1999,7,29), "CTO")); 
         */
        
        /*
         *  To Test Post Get All CondidatEmployeeRepo 
        // condidatEmployeeRepo.GetAll().forEach(u -> System.out.println(u.toString()));
        */
        
        /*
         *  To Test Get CondidatEmployeeRepo  By Id
        //System.out.println( condidatEmployeeRepo.GetById(1).toString()); 
         */

       
        
        /*
         * To Test Put CondidatEmployee
       CondidatEmployee condidatEmployee=  condidatEmployeeRepo.GetById(1); 
        System.out.println("CondidatEmployee before update"); 
        System.out.println(condidatEmployee.toString()); 
        System.out.println("condidatEmployee after update"); 
        condidatEmployee.setPassword("1234");
        condidatEmployeeRepo.Put(user); 
        System.out.println( condidatEmployeeRepo.GetById(1).toString()); 
         */
        
        /*
         * To Test Delete User
        System.out.println("List Before Deleting one item size is " +  condidatEmployeeRepo.GetAll().size());
        userRepo.Delete(1); 
        System.out.println("List after Deleting one item size is " +  condidatEmployeeRepo.GetAll().size());
        */
        
            
         condidatEmployeeRepo.GetAll().forEach(u -> System.out.println(u.toString()));
    }
}
