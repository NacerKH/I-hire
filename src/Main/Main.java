/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Services.CategoryService;
import Services.JobOfferService;


/**
 *
 * @author Dhiaeddsn
 */
public class Main {
    
    public static void main(String[] args){
        
        
        JobOfferService.GetInstance().GetJoboffersCat();
        CategoryService.GetInstance().GetAll();
        System.out.println(JobOfferService.GetInstance().GetJoboffersCat());
        
    }
}
