/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EHire;

import Modules.CondidatEmployee.src.Controllers.EmployeeCondidatController;

/**
 *
 * @author LENOVO
 */
public class EHire {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("edqsds");
        System.out.println(EmployeeCondidatController.index());
        EmployeeCondidatController.store(0, 0, "kali", 0);     
        EmployeeCondidatController.update(1, 1, "kali", 0,1); //update By Id  in this cas 1  last params      
        EmployeeCondidatController.delete(1); //delete By Id  in this cas 1  last params        
        System.out.println( EmployeeCondidatController.show(2)); //show By Id  in this cas 2 last params

        


     

    }

}
