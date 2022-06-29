/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author e.bentijani
 */
public class ResutInterfaceController implements Initializable {

    @FXML
    private Text mScore;
    @FXML
    private Text acceptation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public Text getmScore() {
        return mScore;
    }

    public void setmScore(String mScore,String acceptation) {
        this.mScore.setText(mScore);
        this.acceptation.setText(acceptation);
            }
    
}
