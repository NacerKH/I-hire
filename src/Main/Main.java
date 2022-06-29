/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Models.JobOffer;
import Services.JobOfferService;
import java.util.ArrayList;
import com.google.auth.oauth2.GoogleCredentials;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import com.google.auth.http.HttpCredentialsAdapter;

/**
 *
 * @author Dhiaeddsn
 */
public class Main {
    
    public static void main(String[] args){
      
   MailService.send(
    "ehire04@gmail.com",
    "ehire12345678",
    "ehire04@gmail.com",
    "Bienvenu sur WayToLearnX",
    "mail de test!"
  );
 }

    
       
}
