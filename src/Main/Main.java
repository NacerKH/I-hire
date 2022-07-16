/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Models.Candidat;
import Services.CandidatRepository;
import Services.IntereviewDateRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dhiaeddsn
 */
public class Main {

    public static void main(String[] args) {

        IntereviewDateRepository intrep = IntereviewDateRepository.GetInstance();

        CandidatRepository ct = CandidatRepository.GetInstance();

//   POST
        Candidat c = new Candidat("yyy", "test", "test", "test", new Date(), new Date());
        Candidat c1 = new Candidat("ss", "ddd", "kkk", "t", new Date(), new Date());
        ArrayList<Candidat> lc = new ArrayList<Candidat>();
        lc.add(c);
        lc.add(c1);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        /*IntereviewDate intdate = new IntereviewDate(date, new Date(), new Date(), lc);

        intdate.setCandidats(lc);
        intrep.Post(intdate);*/
        //intrep.GetById(26);
        // intrep.GetAll();
        // System.out.println(ct.GetAll());
        //PUT
        //  IntereviewDate intdate= new IntereviewDate(19,"emna",new Date(),new Date());
        // intrep.Put(intdate);
        // put candidat
        Candidat con = new Candidat(15, "d", "test", "test", "test", new Date(), new Date(), 24);

        ct.Put(con);

        //delet candidat
        // ct.Delete(23);
        //delete intereviewDate
        // intrep.Delete(23);
    }

}
