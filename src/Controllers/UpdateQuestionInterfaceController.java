/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Question;
import Models.Test;
import Services.QuestionService;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author e.bentijani
 */
public class UpdateQuestionInterfaceController implements Initializable {

    @FXML
    private Text fxErrorChoixD;
    @FXML
    private Text fxErrorChoixC;
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
    private Button updateQuestion;
    @FXML
    private Button cancel;
    @FXML
    private Text fxTestTitle;
    private Test test;
    QuestionService QuestionRepo = QuestionService.GetInstance();
    Question question;
    int idQuestion;
    @FXML
    private Text fxCreatedDate;
    @FXML
    private Text fxUpdatedDate;
    @FXML
    private TextField score;
    @FXML
    private Text fxErrorScore;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
  } 
    private void initData()
    {
         question = QuestionRepo.GetById(idQuestion);
        fxDescription.setText(question.getDescription());
        fxTestTitle.setText("Modifier le question de l'ID "+question.getId()+" du Test " +test.getTopic());
        fxChoixD.setText(question.getChoiceD());
        fxChoixA.setText(question.getChoiceA());
        fxChoixB.setText(question.getChoiceB());
        fxChoixC.setText(question.getChoiceC());
        fxCreatedDate.setText(question.getCreatedDate().toString());
        fxUpdatedDate.setText(question.getUpdatedDate().toString());
        score.setText(question.getScore()+"");
        if(question.getRightAnswer().contains("A"))
            fxrRepA.setSelected(true);

        if(question.getRightAnswer().contains("B"))
            fxrRepB.setSelected(true);

        if(question.getRightAnswer().contains("C"))
            fxrRepC.setSelected(true);

        if(question.getRightAnswer().contains("D"))
            fxrRepD.setSelected(true);
    }



    @FXML
    private void updateQuestion(ActionEvent event) {
         if (validateQuestion()) {   
        QuestionRepo.Put(question);
          FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "../GUI/ListQuestionsInterface.fxml"
                )
        );

        try {
            Parent root = loader.load();
            ListQuestionsInterfaceController controller = loader.getController();
            fxChoixA.getScene().setRoot(root);
                        System.out.println("emna"+ test);

            for (int i = 0; i < test.getQuestions().size(); i++) {
             if(test.getQuestions().get(i).getId()== question.getId()) 
               {
                test.getQuestions().remove(i);
               }   
            }
            
            test.getQuestions().add(question);
            controller.jsp(test);
        } catch (IOException ex) {
            Logger.getLogger(UpdateTestInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
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
            question.setDescription(fxDescription.getText());
            question.setChoiceA(fxChoixA.getText());
            question.setChoiceB(fxChoixC.getText());
            question.setChoiceC(fxChoixC.getText());
            question.setChoiceD(fxChoixD.getText());    
            question.setScore( Float.valueOf(score.getText()));
            question.setCreatedDate(question.getCreatedDate());
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
        }
        return test;
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
                fxChoixA.getScene().setRoot(root);
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }
        public void jsp(Test test,int idQuestion) {
            this.idQuestion=idQuestion;
        this.test = test;
        initData();
    }
        
}
