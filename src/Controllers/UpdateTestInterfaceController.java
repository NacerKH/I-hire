/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Test;
import Services.TestService;
import Validation.AlertInterface;
import Validation.TestQuestionValidation;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author e.bentijani
 */
public class UpdateTestInterfaceController implements Initializable {

    @FXML
    private TextField fxTotalQuestions;
    @FXML
    private ChoiceBox<String> fxDuration;
    @FXML
    private Button fxSaveExamen;
    @FXML
    private Button btnCancel;
    @FXML
    private Text fxErrorTopic;
    @FXML
    private Text fxErrorTotalQuestions;
    @FXML
    private TextField fxTopic;
    TestService testRepo = TestService.GetInstance();
    private Test test;
    @FXML
    private Text fxCreatedDate;
    @FXML
    private Text fxUpdatedDate;
    @FXML
    private Button fxagetQuestions;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
private void initData()
{
     test = testRepo.GetById(test.getId());
        fxDuration.getItems().add("15 Min");
        fxDuration.getItems().add("30 Min");
        fxDuration.getItems().add("45 Min");
        fxDuration.getItems().add("1H");
        fxDuration.getItems().add("1H 30Min");
        fxDuration.getItems().add("2H");
        fxTotalQuestions.setText(test.getTotalQuestions() + "");
        fxTopic.setText(test.getTopic());
        fxCreatedDate.setText(test.getCreatedDate() + "");
        fxUpdatedDate.setText(test.getUpdatedDate() + "");
        switch (test.getDuration()) {
            case 15:
                fxDuration.setValue("15 Min");
                break;
            case 30:
                fxDuration.setValue("30 Min");
                break;
            case 45:
                fxDuration.setValue("45 Min");
                break;
            case 60:
                fxDuration.setValue("1H");
                break;
            case 90:
                fxDuration.setValue("1H 30Min");
                break;

            case 120:
                fxDuration.setValue("2H");
                break;
            default:
            // code block
        }
}
    @FXML
    private void saveExamen(ActionEvent event) {
        fxErrorTopic.setText(TestQuestionValidation.ifInputStringEmptyDO("Titre", fxTopic.getText()));
        fxErrorTotalQuestions.setText(TestQuestionValidation.validateStringOfNumber("Nombre de question à selectionné",
                fxTotalQuestions.getText()));

        if (fxErrorTopic.getText().trim().isEmpty() && fxErrorTotalQuestions.getText().trim().isEmpty()) {
            if (Integer.valueOf(fxTotalQuestions.getText()) > test.getQuestions().size()) {
                Stage stage = (Stage) fxDuration.getScene().getWindow();
                AlertInterface.showAlertWithHeaderTextWARNING(stage, "le nombre de questions doit être supérieur ou égal aux nombre de questions a sélectionné, Merci d'ajouter des questions avant de le modifier.");
            } else {
                switch (fxDuration.getValue()) {
                    case "15 Min":
                        test.setDuration(15);
                        break;
                    case "30 Min":
                        test.setDuration(30);
                        break;
                    case "45 Min":
                        test.setDuration(45);
                        break;
                    case "1H":
                        test.setDuration(60);
                        break;
                    case "1H 30Min":
                        test.setDuration(90);
                        break;

                    case "2H":
                        test.setDuration(120);
                        break;
                    default:
                    // code block
                }

                test.setTopic(fxTopic.getText());
                test.setTotalQuestions(Integer.valueOf(fxTotalQuestions.getText()));
                test.setUpdatedDate(new Date());

                testRepo.Put(test);
                         FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "../GUI/ListOffreInterface.fxml"
                    )
            );
            try {
                Parent root = loader.load();
                fxCreatedDate.getScene().setRoot(root);
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            }
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
                 FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "../GUI/ListOffreInterface.fxml"
                    )
            );
            try {
                Parent root = loader.load();
                fxCreatedDate.getScene().setRoot(root);
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }

    @FXML
    private void getQuestions(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "../GUI/ListQuestionsInterface.fxml"
                )
        );

        try {
            Parent root = loader.load();
            ListQuestionsInterfaceController controller = loader.getController();
            System.out.println("Controllers.UpdateTestInterfaceController.getQuestions()" + test);
            controller.setTest(test);

            fxCreatedDate.getScene().setRoot(root);
            controller.jsp(test);
        } catch (IOException ex) {
            Logger.getLogger(UpdateTestInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        public void jsp(Test test) {
        this.test = test;
        initData();
  
    }
}













