/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.CondidatEmployee.src.Controllers;
import Modules.CondidatEmployee.src.Contracts.EmployeeCondidatInterface;
import Modules.CondidatEmployee.src.Models.EmployeesCondidat;

/**
 *
 * @author LENOVO
 */
public class EmployeeCondidatController {
   public   EmployeeCondidatInterface emc ;

    public EmployeeCondidatController(EmployeeCondidatInterface emc) {
        this.emc = emc;
    }

    
  

    
    
    
   public void store ( int offer_id,int user_id,String Cv_url, int status){
       EmployeesCondidat Ec = new EmployeesCondidat(offer_id,user_id,Cv_url, status); 
       this.emc.InsertEmpCondidat(Ec.getOffer_id(),Ec.getUser_id(),Ec.getCv_url(),Ec.getStatus());
       
   }
    
    
    
}
