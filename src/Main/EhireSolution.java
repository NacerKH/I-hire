/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Models.Candidat;
import Models.IntereviewDate;
import Services.CandidatRepository;
import Services.IntereviewDateRepository;
import java.util.ArrayList;
import java.util.Date;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author KHLIFI-MED
 */
public class EhireSolution  {
    
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
IntereviewDateRepository intrep =IntereviewDateRepository.GetInstance();      

CandidatRepository ct = CandidatRepository.GetInstance();   


// /*  POST
     /*   Candidat c = new Candidat("test","test","test","test",new Date(),new Date());
         Candidat c1 = new Candidat("ss","jj","test","t",new Date(),new Date());
          ArrayList<Candidat> lc = new ArrayList<Candidat>();
          lc.add(c);
           lc.add(c1);
         IntereviewDate intdate= new IntereviewDate("test",new Date(),new Date(),lc);

        intdate.setCandidats(lc);
         intrep.Post(intdate); */
       
         //intrep.GetById(26);
         
     // intrep.GetAll();
         
     // System.out.println(ct.GetAll());
     //PUT
     //  IntereviewDate intdate= new IntereviewDate(19,"emna",new Date(),new Date());
       
      // intrep.Put(intdate);
       
      
      
      //put candidat
     // Candidat con = new Candidat(2,"d","test","test","test",new Date(),new Date(),23);
       
     // ct.Put(con);
       
     
     //delet candidat
      // ct.Delete(23);
      
      
      //delete intereviewDate
         // intrep.Delete(23);
    }
    
}
