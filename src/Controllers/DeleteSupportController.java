/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Support;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import services.SupportService;

/**
 * FXML Controller class
 *
 * @author Maryouma
 */
public class DeleteSupportController implements Initializable {

    SupportService ss = new SupportService();

    @FXML
    private TextField id;
    @FXML
    private Button delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void deleteSupport(ActionEvent event) {
        
        if (id.getText().isEmpty() ) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Veuillez entrer l'Id svp!!", ButtonType.OK);
            a.showAndWait();
        } else {
            SupportService ss = new SupportService();
            ss.Delete(Integer.parseInt(id.getText()));
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Support deleted!", ButtonType.OK);
            a.showAndWait();
        }
        }

    }


