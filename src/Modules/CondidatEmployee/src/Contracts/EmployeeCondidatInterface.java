/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules.CondidatEmployee.src.Contracts;

import Modules.CondidatEmployee.src.Models.EmployeesCondidat;
import java.util.List;

/**
 *
 * @author LENOVO
 */

public interface EmployeeCondidatInterface {
   public  void AddEmpCondidat(int offer_id,int  user_id, String Cv_url, int status);
 public List<EmployeesCondidat> fetchEmpCs();
  public void UpdateEmpCondidat(EmployeesCondidat emc ,int id);
    
}
