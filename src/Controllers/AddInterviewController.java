/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Interview;
import java.io.IOException;
import services.InterviewService;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Maryouma
 */
public class AddInterviewController implements Initializable {

    InterviewService is = new InterviewService();

    @FXML
    private Button add_inteview;
    @FXML
    private TextField type;
    @FXML
    private TextField statut;
    @FXML
    private DatePicker update_interview;
    @FXML
    private DatePicker date_interview;
    @FXML
    private Button sms;
    private Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
    private Alert alertWarning = new Alert(Alert.AlertType.WARNING);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addInterview(ActionEvent event) {
        if (type.getText().isEmpty() || statut.getText().isEmpty() || update_interview.getValue() == null || date_interview.getValue() == null) {
            Alert a = new Alert(Alert.AlertType.ERROR, "vérifiez les informations SVP!!", ButtonType.OK);
            a.showAndWait();
        } else {
            try {
                Date mDate = Date.valueOf(date_interview.getValue().toString());
                Date uDate = Date.valueOf(update_interview.getValue().toString());
                Interview i = new Interview(mDate, uDate, type.getText(), statut.getText());
                InterviewService.GetInstance().Post(i);
                alertInformation.setTitle("Done!");
                alertInformation.setHeaderText(null);
                alertInformation.setContentText("Interview ajouté");
                alertInformation.showAndWait();

                type.clear();
                statut.clear();
                date_interview.setValue(null);
                update_interview.setValue(null);

            } catch (Exception e) {
                Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                a.showAndWait();
            }

        }

    }

    @FXML
    private void sendSms(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SendSms.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

}
