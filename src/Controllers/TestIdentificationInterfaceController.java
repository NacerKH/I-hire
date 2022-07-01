/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.CandidatOffre;
import Services.CandidatOffreService;
import Validation.TestQuestionValidation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author e.bentijani
 */
public class TestIdentificationInterfaceController implements Initializable {

    @FXML
    private TextField password;
    @FXML
    private Button startTest;
    @FXML
    private Text fxErrorIdOffreCandidat;
    @FXML
    private Text fxErrorPassword;
    @FXML
    private TextField idCandidatOffre;
    @FXML
    private Text fxErrorIdentification;
    private CandidatOffre candidature;
    CandidatOffreService candidatOffreRepo = CandidatOffreService.GetInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void startTest(ActionEvent event) {
        fxErrorIdOffreCandidat.setText(TestQuestionValidation.validateStringOfNumber("ID Candidature", idCandidatOffre.getText()));
        fxErrorPassword.setText(TestQuestionValidation.ifInputStringEmptyDO("Mot de passe", idCandidatOffre.getText()));
        if (fxErrorIdOffreCandidat.getText().trim().isEmpty() && fxErrorPassword.getText().trim().isEmpty()) {
            candidature = candidatOffreRepo.GetById(Integer.valueOf(idCandidatOffre.getText()));
            if (candidature.getStatus().toString().contains("REJECT")) {
                fxErrorIdentification.setText("Candidat déjà rejeté !");
            } else {
                if (candidature.getStatus().toString().contains("ACCEPTED")) {
                    fxErrorIdentification.setText("Candidat déjà accepté !");
                } else {
                    if (candidature == null || !candidature.getStatus().toString().contains("PRESELECTION")) {
                        fxErrorIdentification.setText("Coordonnées invalide !");
                    } else {
                        if (!candidature.getPasswordTest().contains(password.getText())) {
                            fxErrorIdentification.setText("Coordonnées invalide !");

                        } else {
                            FXMLLoader loader = new FXMLLoader(
                                    getClass().getResource(
                                            "../GUI/CandidatTest.fxml"
                                    )
                            );

                            try {
                                Parent root = loader.load();
                                CandidatTestController controller = loader.getController();
                                password.getScene().setRoot(root);
                                controller.jsp(candidature);
                            } catch (IOException ex) {
                                System.out.println("Controllers.TestIdentificationInterfaceController.startTest()");
                            }
                        }
                    }
                }
            }
        }
    }
}
