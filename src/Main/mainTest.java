/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Models.Interview;
import Models.Support;
import Services.InterviewService;
import services.SupportService;
import Utils.MaConnexion;
import java.sql.Date;

/**
 *
 * @author Maryouma
 */
public class mainTest {

    public static void main(String[] args) {

        //connection data base 
        MaConnexion.getInstance();
//        //call service
        InterviewService in = new InterviewService();
        SupportService sup = new SupportService();
//        //Date
         java.util.Date myDate = new java.util.Date("10/10/2020");
         java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
//    //instanciate
        Interview i = new Interview(sqlDate, new Date(System.currentTimeMillis()), "présentielle", "accepté");
        //Interview i= in.getInterviewById(2);
         //System.out.println(i);
        //Support s = new Support(i, "description_offre", "cv_candidate");
        
//         
//        
//        //insert
        in.insertInterview(i);
          //sup.insertSupport(s);
//         
        //select by id 
        //System.out.println(in.getInterviewById(2));
        //select by id support
        // System.out.println(sup.getSupportById(5));
        // update interview
        //Interview i = new Interview( sqlDate, new Date(System.currentTimeMillis()), "présentielle", "refusé");
        //in.updateInterviewById(i);
        // delete ligne avec id = 1
       // in.deleteInterview(1);
       //update support
      //  Interview i= new Interview(2, sqlDate, sqlDate, "classe", "en attente");
       //Support s= new Support(14, i, "offre medecin", "cv disponible");
       // sup.updateSupportById(s);
       //delete support
      // sup.deleteSupportById(15);

    }

}
