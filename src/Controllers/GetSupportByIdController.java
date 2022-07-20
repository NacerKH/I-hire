/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.SupportService;

/**
 * FXML Controller class
 *
 * @author Maryouma
 */
public class GetSupportByIdController implements Initializable {
    
    SupportService ss = new SupportService();

    @FXML
    private Button ok;
    @FXML
    private TextField id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getAllById(ActionEvent event) {
        System.out.println(ss.GetById(Integer.parseInt(id.getText())));
    }
    
    
}
