/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehiresolution;
import Infrastructure.AppDbContext;
import Entities.CondidatEmployee;
import Enums.Status;
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
         *  To Test Post User */
         condidatEmployeeRepo.Post(new CondidatEmployee(1, 2, "storage/kaali.pdf",Status.ACCEPTED)); 
        
        
        /*
         *  To Test Post Get All CondidatEmployeeRepo 
        // condidatEmployeeRepo.GetAll().forEach(u -> System.out.println(u.toString()));
        */
        
        /*
         *  To Test Get CondidatEmployeeRepo  By Id   */
        
        System.out.println("this for getByID"+ condidatEmployeeRepo.GetById(18).toString()); 
      

       
        
        /*
         * To Test Put CondidatEmployee   */
       CondidatEmployee condidatEmployee=  condidatEmployeeRepo.GetById(18); 
        System.out.println("CondidatEmployee before update"); 
        System.out.println(condidatEmployee.toString()); 
        System.out.println("condidatEmployee after update"); 
        condidatEmployee.setStatus(Status.PANDING);
        condidatEmployeeRepo.Put(condidatEmployee); 
        System.out.println( "YOU CAN IS UPDATED NOW "+condidatEmployeeRepo.GetById(18).toString()); 
      
        
        /*
         * To Test Delete User */
        System.out.println("List Before Deleting one item size is " +  condidatEmployeeRepo.GetAll().size());
        condidatEmployeeRepo.Delete(10); 
        System.out.println("List after Deleting one item size is " +  condidatEmployeeRepo.GetAll().size());
       

            
        condidatEmployeeRepo.GetAll().forEach(u -> System.out.println(u.toString()));
    }
}
