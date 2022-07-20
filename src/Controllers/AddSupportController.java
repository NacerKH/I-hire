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
public class AddSupportController implements Initializable {

    //var
    Interview interview;

    @FXML
    private TextField idInterview;
    @FXML
    private TextField descri;
    @FXML
    private TextField cv;
    @FXML
    private Button add;
    private Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
    private Alert alertWarning = new Alert(Alert.AlertType.WARNING);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        InterviewService is = new InterviewService();
        List<Interview> interviews = is.GetAll();
        interview = interviews.get(0);

        idInterview.setText(String.valueOf(interview.getId_interview()));

    }

    @FXML
    private void addSupport(ActionEvent event) {

        if (cv.getText().isEmpty() || descri.getText().isEmpty() || idInterview.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "vérifiez les informations SVP!!", ButtonType.OK);
            a.showAndWait();
        } else {
            try {

                Support support = new Support(interview, descri.getText(), cv.getText());
                SupportService.GetInstance().Post(support);
                alertInformation.setTitle("Done!");
                alertInformation.setHeaderText(null);
                alertInformation.setContentText("Support ajouté");
                alertInformation.showAndWait();

                idInterview.clear();
                descri.clear();
                cv.clear();

            } catch (Exception e) {
                Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                a.showAndWait();
            }

//        SupportService ss = new SupportService();
//        System.out.println("**************** " + interview);
//        Support support = new Support(interview, descri.getText(), cv.getText());
//        ss.Post(support);
//        Alert a = new Alert(Alert.AlertType.INFORMATION, "ligne ajoutée!!", ButtonType.OK);
//        a.showAndWait();
//        idInterview.clear();
//        descri.clear();
//        cv.clear();
        }
    }
}
