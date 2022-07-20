/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Enums.UserType;
import Main.FXMain;
import Models.User;
import Services.UserServices;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dhiaeddsn
 */
public class CreateUserPageController implements Initializable {
 
    @FXML 
    Button goBackButton;
     
    @FXML 
    Label msgLabel; 
    @FXML 
    TextField userNameTextFieled; 
    @FXML 
    TextField passwordTextFieled;
    @FXML 
    TextField emailTextFieled;
    @FXML 
    TextField jobTitleTextFieled; 
    
    UserServices _service; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        _service = UserServices.GetInstance(); 
    }    
    
    public void onCreateButtonClicked()
    {
        msgLabel.setText("Creating...");
        if(userNameTextFieled.getText().isBlank() || emailTextFieled.getText().isBlank() || passwordTextFieled.getText().isBlank() || jobTitleTextFieled.getText().isBlank() )
        {
            msgLabel.setText("you must fill the all fields...");
        }
        else
        {
            /*
            LocalDate localDate = birdthdayDatePicker.getValue(); 

            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));

            Date date = Date.from(instant);
            */
            Date date = new Date(2022,02,02); 
            _service.Post(new User(userNameTextFieled.getText(), emailTextFieled.getText(), UserType.RH, "",date ,  jobTitleTextFieled.getText())); 
            
            onGoBackButtonClicked(); 
        }
    }
    
    public void onCancelButtonClicked()
    {
        onGoBackButtonClicked();    
    }
    
    public void onGoBackButtonClicked()
    {
       try
       {
           Parent root = FXMLLoader.load(getClass().getResource("../GUI/HomePage.fxml"));
        
           Stage window = (Stage)goBackButton.getScene().getWindow(); 
           
           window.setScene(new Scene(root,1280 , 720 ));
           
       }
       catch (IOException ex) 
        {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
