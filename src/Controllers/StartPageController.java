/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Main.FXMain;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dhiaeddsn
 */
public class StartPageController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    Button submitOfferButton;
    @FXML
    Button LoginButton;   
    @FXML 
    Button startTestButton;
    @FXML 
    Button showJobOffer;
    
    public void onSubmitOfferButtonCliked()
    {
       try
       {
           
           Parent root = FXMLLoader.load(getClass().getResource("../GUI/PostCondidatEmploye.fxml"));
        
           Stage window = (Stage)submitOfferButton.getScene().getWindow(); 
           
           window.setScene(new Scene(root,1280 , 720 ));
           
       }
       catch (IOException ex) 
        {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onLoginButtonCliked()
    {
       try
       {
           Parent root = FXMLLoader.load(getClass().getResource("../GUI/LoginPage.fxml"));
        
           Stage window = (Stage)LoginButton.getScene().getWindow(); 
           
           window.setScene(new Scene(root,1280 , 720 ));
           
       }
       catch (IOException ex) 
        {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onStartTestButton()
    {
       try
       {
           Parent root = FXMLLoader.load(getClass().getResource("../GUI/TestIdentificationInterface.fxml"));
        
           Stage window = (Stage)startTestButton.getScene().getWindow(); 
           
           window.setScene(new Scene(root,1280 , 720 ));
           
       }
       catch (IOException ex) 
        {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onShowJobOffers()
    {
       try
       {
           Parent root = FXMLLoader.load(getClass().getResource("../GUI/JobOffersMain.fxml"));
        
           Stage window = (Stage)showJobOffer.getScene().getWindow(); 
           
           window.setScene(new Scene(root,1280 , 720 ));
           
       }
       catch (IOException ex) 
        {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
