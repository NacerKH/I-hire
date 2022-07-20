/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.JobOffer;
import Models.Question;
import Models.Test;
import Services.JobOfferService;
import Services.TestService;
import Validation.TestQuestionValidation;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Validation.AlertInterface;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author e.bentijani
 */
public class QuestionInterfaceController implements Initializable {

    @FXML
    private Text fxErrorChoixD;
    @FXML
    private Text fxErrorChoixC;
    @FXML
    private Text fxQuestNum;
    @FXML
    private CheckBox fxrRepB;
    @FXML
    private CheckBox fxrRepA;
    @FXML
    private TextArea fxChoixC;
    @FXML
    private TextArea fxChoixA;
    @FXML
    private TextArea fxDescription;
    @FXML
    private TextArea fxChoixD;
    @FXML
    private TextArea fxChoixB;
    @FXML
    private CheckBox fxrRepD;
    @FXML
    private CheckBox fxrRepC;
    @FXML
    private Text fxErrorDescription;
    @FXML
    private Text fxErrorChoixA;
    @FXML
    private Text fxErrorChoixB;
    private Test test;
    TestService testRepo = TestService.GetInstance();
    @FXML
    private Button aDDTest;
    @FXML
    private Button aDDQuestion;
    @FXML
    private Text fxErrorScore;
    @FXML
    private TextField score;


    public void setFxQuestNum(String fxQuestNum) {
        this.fxQuestNum.setText(fxQuestNum);
    }

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
        // TODO
    }

    @FXML
    private void aDDTest(ActionEvent event) {
        if (validateQuestion()) {

            if (test.getQuestions().size() < test.getTotalQuestions()) {
                Stage stage = (Stage) fxrRepC.getScene().getWindow();
                AlertInterface.showAlertWithHeaderTextWARNING(stage, "le nombre de questions doit être supérieur ou égal aux membres de questions a sélectionné");
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "../GUI/QuestionInterface.fxml"
                        )
                );
                try {
                    Parent root = loader.load();
                    QuestionInterfaceController controller = loader.getController();

                    controller.jsp(test);
                    fxDescription.getScene().setRoot(root);
                    if (test.getQuestions() == null) {
                        controller.setFxQuestNum("1");
                    } else {
                        controller.setFxQuestNum((test.getQuestions().size() + 1) + "");
                    }
                    //controller.jsp(test);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
               int idTest=testRepo.Post(test);
                JobOfferService jobOfferService = JobOfferService.GetInstance();
               JobOffer offre=jobOfferService.GetById(test.getIdOffre());

             offre.setIdTest(idTest);
              jobOfferService.Put(offre);
              
                     FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "../GUI/ListOffreInterface.fxml"
                    )
            );
            try {
                Parent root = loader.load();
                fxChoixA.getScene().setRoot(root);
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            }
        }
    }

    public void jsp(Test test) {
        this.test = test;
    }

    @FXML
    private void aDDQuestion(ActionEvent event) {
   if (validateQuestion()) {        
       FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "../GUI/QuestionInterface.fxml"
                )
        );
        try {
            Parent root = loader.load();
            QuestionInterfaceController controller = loader.getController();
            controller.jsp(test);
            fxDescription.getScene().setRoot(root);
            if (test.getQuestions() == null) {
                controller.setFxQuestNum("1");
            } else {
                controller.setFxQuestNum((test.getQuestions().size() + 1) + "");
            }
            //controller.jsp(test);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
   }
    }

    public boolean validateQuestion() {
        fxErrorDescription.setText(TestQuestionValidation.ifInputStringEmptyDO("Question", fxDescription.getText()));
        fxErrorScore.setText(TestQuestionValidation.validateStringOfFloat("Score",score.getText()));
        fxErrorChoixA.setText(TestQuestionValidation.ifInputStringEmptyDO("Choix A", fxChoixA.getText()));
        fxErrorChoixB.setText(TestQuestionValidation.ifInputStringEmptyDO("Choix B", fxChoixB.getText()));
        fxErrorChoixC.setText(TestQuestionValidation.ifInputStringEmptyDO("Choix C", fxChoixC.getText()));
        fxErrorChoixD.setText(TestQuestionValidation.ifInputStringEmptyDO("Choix D", fxChoixD.getText()));
        boolean test = false;
        if (fxErrorDescription.getText().trim().isEmpty() && fxErrorChoixA.getText().trim().isEmpty() && fxErrorChoixB.getText().trim().isEmpty()
                && fxErrorChoixC.getText().trim().isEmpty() && fxErrorChoixD.getText().trim().isEmpty()) {
            test = true;
            Question question = new Question();
            question.setDescription(fxDescription.getText());
            question.setChoiceA(fxChoixA.getText());
            question.setChoiceB(fxChoixC.getText());
            question.setChoiceC(fxChoixC.getText());
            question.setChoiceD(fxChoixD.getText());
            question.setScore( Float.valueOf(score.getText()));
            question.setCreatedDate(new Date());
            question.setUpdatedDate(new Date());
            question.setRightAnswer("");
            if (fxrRepC.isSelected()) {
                question.setRightAnswer(question.getRightAnswer() + "C");
            }
            if (fxrRepA.isSelected()) {
                question.setRightAnswer(question.getRightAnswer() + "A");
            }
            if (fxrRepB.isSelected()) {
                question.setRightAnswer(question.getRightAnswer() + "B");
            }
            if (fxrRepD.isSelected()) {
                question.setRightAnswer(question.getRightAnswer() + "D");
            }
            this.test.getQuestions().add(question);
            System.out.println("Controllers.QuestionInterfaceController.aDDQuestion() " + test);
        }
        return test;
    }
}
