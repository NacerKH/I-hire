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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dhiaeddsn
 */
public class HomePageController implements Initializable {

    @FXML
    private BorderPane mainView;
    @FXML
    Button getOfferListButton;
    @FXML
    Button getListOffreListButton;
    @FXML
    Button sendSMSButton;
    @FXML
    Button getAllInterviewsListButton;
    @FXML
    Button getAllsupportListButton;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     
    public void onGetOfferListButtonClicked()
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListCandidatOffreInterface.fxml"));
        
            Stage window = (Stage)getOfferListButton.getScene().getWindow(); 
            
            window.setScene(new Scene(root,1280 , 720 ));
        }
        catch (IOException ex) 
        {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public void onGetListOffreListButtonClicked()
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListOffreInterface.fxml"));
        
            Stage window = (Stage)getListOffreListButton.getScene().getWindow(); 
            
            window.setScene(new Scene(root,1280 , 720 ));
        }
        catch (IOException ex) 
        {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      
    public void onSendSMSButtonClicked()
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/SendSms.fxml"));
        
            Stage window = (Stage)sendSMSButton.getScene().getWindow(); 
            
            window.setScene(new Scene(root,1280 , 720 ));
        }
        catch (IOException ex) 
        {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void onGetAllInterviewsListButtonClicked()
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/getAll.fxml"));
        
            Stage window = (Stage)getAllInterviewsListButton.getScene().getWindow(); 
            
            window.setScene(new Scene(root,1280 , 720 ));
        }
        catch (IOException ex) 
        {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void onGetAllsupportListButtonClicked()
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/getAllSupport.fxml"));
        
            Stage window = (Stage)getAllsupportListButton.getScene().getWindow(); 
            
            window.setScene(new Scene(root,1280 , 720 ));
        }
        catch (IOException ex) 
        {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
    @FXML
    private void handleChangeView(ActionEvent event) {
        String viewName = ((MenuItem) event.getSource()).getId();
        InitView(viewName); 
    }
    
    private void InitView(String viewName)
    {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(viewName + ".fxml"));
            loader.setController(this);

            mainView.setCenter(loader.load());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
