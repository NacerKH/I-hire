/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Question;
import Models.Test;
import Services.TestService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author e.bentijani
 */
public class CandidatTestController implements Initializable {

    @FXML
    private Pane fileTest;
    @FXML
    private Text topic;
    private Test test;
    TestService testRepo = TestService.GetInstance();
    @FXML
    private ScrollBar scroll;
    @FXML
    private Pane globalPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        test = testRepo.GetById(40);
         VBox boxG = new VBox();
        

        System.out.println("Controllers.CandidatTestController.initialize()" + test);
                for (int i = 0; i < test.getQuestions().size(); i++) 
{
    
            VBox box = new VBox();
            box.setId(i+"");       
           Text questionNumber = new Text("Question "+(i+1)); 
           questionNumber.setId(i+"");
           questionNumber.setStyle("-fx-font: 16 arial;");
           HBox box1 = new HBox();
           box1.setId(i+"");
           Text choixA = new Text(test.getQuestions().get(i).getChoiceA());
           choixA.setId(i+"");
           choixA.setWrappingWidth(500);
           CheckBox repA = new CheckBox();
           repA.setId(i+"");
           choixA.setStyle("-fx-font: 14 arial;");
           choixA.setLayoutX(50);
           box1.getChildren().addAll(repA,choixA);
           
           HBox box2 = new HBox();
           box2.setId(i+"");
           Text choixB = new Text(test.getQuestions().get(i).getChoiceB());
           choixB.setId(i+"");
           choixB.setWrappingWidth(500);
           CheckBox repB = new CheckBox();
           repB.setId(i+"");
           choixB.setStyle("-fx-font: 14 arial;");
           choixB.setLayoutX(50);
           box2.getChildren().addAll(repB,choixB);
       
           
           HBox box3 = new HBox();
           box3.setId(i+"");
           Text choixC = new Text(test.getQuestions().get(i).getChoiceC());
           choixC.setId(i+"");
           choixC.setWrappingWidth(500);
           CheckBox repC = new CheckBox();
           repC.setId(i+"");
           choixC.setStyle("-fx-font: 14 arial;");
           choixC.setLayoutX(50);
           box3.getChildren().addAll(repC,choixC);
           
            HBox box4 = new HBox();
            box4.setId(i+"");
           Text choixD = new Text(test.getQuestions().get(i).getChoiceD());
           choixD.setId(i+"");
           choixD.setWrappingWidth(500);
           CheckBox repD = new CheckBox();
           repD.setId(i+"");
           choixD.setStyle("-fx-font: 14 arial;");
           choixD.setLayoutX(50);
           box4.getChildren().addAll(repD,choixD);
            box1.setSpacing(20);
            box1.setMargin(repA,new Insets (0, 0, 0, 20));
            box2.setSpacing(20);
            box2.setMargin(repB,new Insets (0, 0, 0, 20));
            box3.setSpacing(20);
            box3.setMargin(repC,new Insets (0, 0, 0, 20));
            box4.setSpacing(20);
            box4.setMargin(repD,new Insets (0, 0, 0, 20));
           box.getChildren().addAll(questionNumber,box1,box2,box3,box4);
            box.setSpacing(30);
           boxG.setSpacing(50);
           boxG.getChildren().addAll(box);
            scroll.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
               boxG.setLayoutY(-new_val.doubleValue());
            });
        }
                scroll.setMax(10);
        globalPane.getChildren().add(boxG);
        

    }

}
