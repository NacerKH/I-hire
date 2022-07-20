/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Maryouma
 */
public class SendSmsController implements Initializable {

    @FXML
    private TextField mobileNum;
    @FXML
    private TextArea textMsg;
    @FXML 
    Button goBackButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void sendMsg(ActionEvent event) {
        Api ap = new Api();
        ap.SendSms("hiresolution", "Hiresolution2022", mobileNum.getText(), textMsg.getText());
        Alert a = new Alert(Alert.AlertType.INFORMATION, "message envoyé!!", ButtonType.OK);
        a.showAndWait();
        mobileNum.clear();
        textMsg.clear();
    }

    @FXML
    private void resetBtn(ActionEvent event) {
        mobileNum.clear();
        textMsg.clear();
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
