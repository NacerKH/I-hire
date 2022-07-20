/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Question;
import Models.Test;
import Services.QuestionService;
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

/**
 * FXML Controller class
 *
 * @author e.bentijani
 */
public class AddOneQuestionController implements Initializable {

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
    @FXML
    private Button aDDQuestion;
    @FXML
    private Button cancel;
    private Test test;
    QuestionService QuestionRepo = QuestionService.GetInstance();
    Question question = new Question();
    TestService testRepo = TestService.GetInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void aDDQuestion(ActionEvent event) {
         if (validateQuestion()) {        
       FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "../GUI/ListQuestionsInterface.fxml"
                )
        );
        try {
            Parent root = loader.load();
            ListQuestionsInterfaceController controller = loader.getController();
            System.out.println("Controllers.AddOneQuestionController.aDDQuestion()"+question);
            QuestionRepo.Post(question);
            fxDescription.getScene().setRoot(root);
            test=testRepo.GetById(test.getId());
            controller.jsp(test);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
   }
    }
  public boolean validateQuestion() {
        fxErrorDescription.setText(TestQuestionValidation.ifInputStringEmptyDO("Question", fxDescription.getText()));
        fxErrorChoixA.setText(TestQuestionValidation.ifInputStringEmptyDO("Choix A", fxChoixA.getText()));
        fxErrorChoixB.setText(TestQuestionValidation.ifInputStringEmptyDO("Choix B", fxChoixB.getText()));
        fxErrorChoixC.setText(TestQuestionValidation.ifInputStringEmptyDO("Choix C", fxChoixC.getText()));
        fxErrorChoixD.setText(TestQuestionValidation.ifInputStringEmptyDO("Choix D", fxChoixD.getText()));
        boolean test = false;
        if (fxErrorDescription.getText().trim().isEmpty() && fxErrorChoixA.getText().trim().isEmpty() && fxErrorChoixB.getText().trim().isEmpty()
                && fxErrorChoixC.getText().trim().isEmpty() && fxErrorChoixD.getText().trim().isEmpty()) {
            test = true;
            question.setDescription(fxDescription.getText());
            question.setChoiceA(fxChoixA.getText());
            question.setChoiceB(fxChoixC.getText());
            question.setChoiceC(fxChoixC.getText());
            question.setChoiceD(fxChoixD.getText());
            question.setCreatedDate(new Date());
            question.setUpdatedDate(new Date());
            question.setRightAnswer("");
            if (fxrRepC.isSelected()) {
                question.setRightAnswer(question.getRightAnswer() + "C" );
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
            question.setIdTest(this.test.getId());
        }
        return test;
    }
    @FXML
    private void cancel(ActionEvent event) {
    }
        public void jsp(Test test) {
        this.test = test;
         if (test.getQuestions() == null) {
            fxQuestNum.setText("1" );
            } else {
                fxQuestNum.setText((test.getQuestions().size() + 1) + "");
            }
    }
}
