/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Interview;
import Models.Support;
import services.InterviewService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import services.SupportService;

/**
 * FXML Controller class
 *
 * @author Maryouma
 */
public class UpdateSupportController implements Initializable {

    SupportService ss = new SupportService();

    Interview I;

    @FXML
    private TextField id;
    @FXML
    private TextField interview;
    @FXML
    private TextField offre;
    @FXML
    private TextField cv;
    @FXML
    private Button update;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        InterviewService is = new InterviewService();
        List<Interview> interviews = is.GetAll();
        I = interviews.get(0);

        interview.setText(String.valueOf(I.getId_interview()));
    }

    @FXML
    private void updateSupport(ActionEvent event) {

        if (id.getText().isEmpty() || offre.getText().isEmpty() || cv.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Veuillez remplir les champs!!", ButtonType.OK);
            a.showAndWait();
        } else {
            Support s = new Support(Integer.parseInt(id.getText()), I, offre.getText(), cv.getText());
            ss.Put(s);
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Support updated!", ButtonType.OK);
            a.showAndWait();

        }

    }

}
