/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Candidat;
import Models.IntereviewDate;
import Services.CandidatRepository;
import Services.IntereviewDateRepository;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author KHLIFI-MED
 */
public class DateController implements Initializable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Candidat candidat = new Candidat();
    @FXML
    private DatePicker date;
    @FXML
    private ChoiceBox<String> heure;
    private Button btnSupp;
    @FXML
    private Label lbAffectedDate;

    private IntereviewDateRepository repo = new IntereviewDateRepository();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (Integer i = 8; i <= 17; i++) {
            heure.getItems().add((i < 10 ? '0' + i.toString() : i.toString()));
        }
        Platform.runLater(() -> {
            refresh();
        });
    }

    public void refresh() {
        try {
            CandidatRepository candidatRepo = new CandidatRepository();
            candidat = candidatRepo.GetById(getId());
            IntereviewDate candDate = repo.GetById(candidat.getIdIntereviewDate());

            System.out.println(candDate.toString());
            lbAffectedDate.setText("Date affectée: " + candDate.getIntrvDate().toString() + " à " + candDate.getIntrvTime() + ":00h");
            btnSupp.setVisible(false);
        } catch (Exception ex) {
            System.out.println("");
        }
    }

    @FXML
    private void affecter(ActionEvent event) {
        LocalDate datePicker = date.getValue();
        Date date = Date.from(datePicker.atStartOfDay(ZoneId.systemDefault()).toInstant());
        IntereviewDate intereviewDate = new IntereviewDate(date, heure.getValue(), new Date(), new Date());
        intereviewDate.getCandidats().add(candidat);
        repo.Post(intereviewDate);
        refresh();
    }

    @FXML
    private void deleteCand(ActionEvent event) {
        CandidatRepository candidatRepo = new CandidatRepository();
        candidatRepo.Delete(getId());
        back(event);
    }

    @FXML
    private void back(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/InterviewDate.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DateController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
