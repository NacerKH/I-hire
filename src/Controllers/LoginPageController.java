/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Main.FXMain;
import Models.User;
import Services.UserServices;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dhiaeddsn
 */
public class LoginPageController implements Initializable {

    @FXML
    private PasswordField passwordFiled;
    @FXML
    private TextField userNameTextFiled;
    @FXML
    private Label notifLabel;
    @FXML
    private Button loginButton;
    @FXML
    private Button goBackButton;
    UserServices _service; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        _service = UserServices.GetInstance(); 
        // TODO
    }    

     
    @FXML
    public void onLoginButtonClicked()
    {
        notifLabel.setText("Connecting...");
        if(userNameTextFiled.getText().isBlank() || passwordFiled.getText().isBlank())
        {
            notifLabel.setText("You must fill the email and the password to login");
        }
        
        User user = _service.GetByUserName(userNameTextFiled.getText()); 
        
        if(user == null)
        {
            notifLabel.setText("This User Dosen't exist!");
        }
        else if(!passwordFiled.getText().equals(user.getPassword()) )
        {
            notifLabel.setText("Password is incorrect...");
        }
        else
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
    @FXML
    public void onGoBackButtonClicked()
    {
       try
       {
           Parent root = FXMLLoader.load(getClass().getResource("../GUI/StartPage.fxml"));
        
           Stage window = (Stage)goBackButton.getScene().getWindow(); 
           
           window.setScene(new Scene(root,1280 , 720 ));
           
       }
       catch (IOException ex) 
        {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}