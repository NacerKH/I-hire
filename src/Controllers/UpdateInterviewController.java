/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Interview;
import services.InterviewService;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Maryouma
 */
public class UpdateInterviewController implements Initializable {
    InterviewService is = new InterviewService();
    

    @FXML
    private TextField id;
    @FXML
    private TextField type;
    @FXML
    private TextField statut;
    @FXML
    private DatePicker date;
    @FXML
    private DatePicker update;
    @FXML
    private Button btupdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void updateInterview(ActionEvent event) {
        
         Date mDate = Date.valueOf(date.getValue().toString());
         Date uDate = Date.valueOf(update.getValue().toString());
        Interview i = new Interview(Integer.parseInt(id.getText()), mDate, uDate, type.getText(), statut.getText());
        is.Put(i);

        Alert a = new Alert(Alert.AlertType.INFORMATION, "table interview est à jour ", ButtonType.CLOSE);
        a.showAndWait();
    }
    
}
