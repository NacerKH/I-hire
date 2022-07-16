/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Candidat;
import Services.CandidatRepository;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author KHLIFI-MED
 */
public class CandidatController implements Initializable {

    @FXML
    private TextField tfcv_url;

    @FXML
    private TextField tfemail;

    @FXML
    private TextField tffullName;

    @FXML
    private TextField tfphoneNumber;
    @FXML
    private Label lbFullName;
    @FXML
    private Label lbNum;
    @FXML
    private Label lbEmail;
    @FXML
    private Label lbCv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void btnValider(ActionEvent event) {
        String fullName = tffullName.getText();
        String phoneNumber = tfphoneNumber.getText();
        String email = tfemail.getText();
        String cv_url = tfcv_url.getText();

        boolean isValid = true;

        if (fullName.isEmpty() || onlyLettersSpaces(fullName) == false) {
            lbFullName.setVisible(true);
            isValid = false;
        } else {
            lbFullName.setVisible(false);
        }
        if (phoneNumber.length() != 8 || phoneNumber.matches("[0-9]+") == false) {
            lbNum.setVisible(true);
            isValid = false;
        } else {
            lbNum.setVisible(false);
        }
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        if (pattern.matcher(email).matches() == false) {
            lbEmail.setVisible(true);
            isValid = false;
        } else {
            lbEmail.setVisible(false);
        }
        if (!isValidURL(cv_url)) {
            lbCv.setVisible(true);
            isValid = false;
        } else {
            lbCv.setVisible(false);
        }

        if (isValid == false) {
            return;
        }
        Candidat c = new Candidat(fullName, phoneNumber, email, cv_url, new Date(), new Date());
        CandidatRepository cr = new CandidatRepository();
        cr.Post2(c);
    }

    public void start(Stage stage) {

        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.of(2016, 7, 25));
        datePicker.setShowWeekNumbers(true);

        FlowPane root = new FlowPane();
        root.getChildren().add(datePicker);
        root.setPadding(new Insets(10));

        stage.setTitle("DatePicker (o7planning.org)");
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static boolean isValidURL(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean onlyLettersSpaces(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch) || ch == ' ') {
                continue;
            }
            return false;
        }
        return true;
    }

}
