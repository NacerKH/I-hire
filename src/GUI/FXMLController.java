/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author wawa
 */
public class FXMLController implements Initializable {
    //var
    
    //widget
    @FXML
    private Label label;
    @FXML
    private Button b1;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private TextField jobdescription;
    @FXML
    private TextField averagesallary;
    @FXML
    private TextField totalplaces;
    @FXML
    private DatePicker date;
    @FXML
    private TextField status;
    @FXML
    private Button afficher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouteraction(ActionEvent event) {
    }

    @FXML
    private void listeraction(ActionEvent event) {
    }
    
}
