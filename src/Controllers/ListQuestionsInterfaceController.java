/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeTableColumn;

/**
 * FXML Controller class
 *
 * @author e.bentijani
 */
public class ListQuestionsInterfaceController implements Initializable {

    @FXML
    private TreeTableColumn<Date,String> lastUpdate;
    @FXML
    private TreeTableColumn<String, String> question;
    @FXML
    private TreeTableColumn<?, ?> actions;
    @FXML
    private TreeTableColumn<Number, String> idQuestion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
