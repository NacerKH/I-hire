/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joboffers;

import java.sql.Date;
import models.Category;
import models.JobOffer;
import services.CategoryService;
import services.JobOfferService;

/**
 *
 * @author wawa
 */
public class JobOffers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //call service
//        
       CategoryService cs = new CategoryService();
       JobOfferService js = new JobOfferService();
//        
//        
//        //instanciate
        Category c = new Category(2,"GraphicDesign");
//
//        java.util.Date myDate = new java.util.Date("10/10/2020");
//        java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
//        
//        JobOffer p = new JobOffer(1,"full time", 3500, 1," en cours",new Date(System.currentTimeMillis()),sqlDate,c);
//        
//                
//        
//        //insert
//         cs.insertCategory(c);
//         js.InsertJoboffer(p);
//        js.UpdateJobOffer(p);
//          js.DeleteJobOffer(3);
            cs.UpdateCategory(c);
        
        System.out.println(js.FetchJobOffers());
    }
    
}
