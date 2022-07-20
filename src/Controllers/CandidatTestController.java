/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Enums.Status;
import Models.CandidatOffre;
import Models.Question;
import Models.Test;
import Services.CandidatOffreService;
import Services.TestService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

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
    @FXML
    private ScrollPane globalPane;
    private Test test;
    TestService testRepo = TestService.GetInstance();
    @FXML
    private Button endTest;
    List<CheckBox> reps = new ArrayList<CheckBox>();
    private CandidatOffre candidatOffre;
    VBox boxG;
    @FXML
    private Text duration;
    CandidatOffreService candidatOffreRepo = CandidatOffreService.GetInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }

    @FXML
    private void globalPane(MouseEvent event
    ) {
    }

    private void calResult() {
        float result = 0;
        float scoreTotale = 0;
        int n = 0;
        for (int i = 0; i < test.getQuestions().size(); i++) {
            scoreTotale += test.getQuestions().get(i).getScore();
            boolean valid = true;
            String repch = "";

            if (reps.get(n).getId().contains(i + "A") && reps.get(n).isSelected() == true) {
                repch += "A";
            }
            if (reps.get(n + 1).getId().contains(i + "B") && reps.get(n + 1).isSelected() == true) {
                repch += "B";
            }
            if (reps.get(n + 2).getId().contains(i + "C") && reps.get(n + 2).isSelected() == true) {
                repch += "C";
            }
            if (reps.get(n + 3).getId().contains(i + "D") && reps.get(n + 3).isSelected() == true) {
                repch += "D";
            }

            if (repch.length() != test.getQuestions().get(i).getRightAnswer().length()) {
                valid = false;
            } else {
                for (int j = 0; j < repch.length(); j++) {
                    if (!test.getQuestions().get(i).getRightAnswer().contains(repch.charAt(j) + "")) {
                        valid = false;
                    }
                }
            }
            if (valid == true) {
                result += test.getQuestions().get(i).getScore();
            }
            n += 4;
        }
        String mres = result + "/" + scoreTotale + " Points";
        String acc="";
        if((result) < (scoreTotale/2))
            
        {
           candidatOffre.setStatus(Status.REJECT);
           candidatOffreRepo.setStatus(candidatOffre);
            acc="Désolé , vous n’avez pas eu la moyenne ! Essayer d’autres offres";
        }
       
        else
        { 
           candidatOffre.setStatus(Status.ACCEPTED);
           candidatOffreRepo.setStatus(candidatOffre);
            acc="Félicitations ! Vous avez eu la moyenne.\nVous serez contacté le plutôt  possible pour un entretien.";}

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "../GUI/ResutInterface.fxml"
                )
        );
        try {
            
            Parent root = loader.load();
            ResutInterfaceController controller = loader.getController();
            controller.setmScore(mres,acc);
            fileTest.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void endTest(ActionEvent event
    ) {
        calResult()  ;
    }
    public void jsp(CandidatOffre candidatOffre) {


        this.candidatOffre=candidatOffre;
        test = testRepo.GetById(candidatOffre.getIdTest());
        initData();
    }
    public void initData()
    {
        candidatOffre.setStatus(Status.REJECT);
        candidatOffreRepo.setStatus(candidatOffre);
        candidatOffre.setStatus(Status.REJECT);
        candidatOffreRepo.setStatus(candidatOffre);
                Timeline timeline = new Timeline(new KeyFrame(Duration.minutes(test.getDuration()), (ActionEvent event) -> {
            calResult();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        ArrayList<Question> vartest = new ArrayList<Question>();
        List<Integer> aliaNum = new ArrayList<Integer>();

        for (int i = 0; i < test.getTotalQuestions(); i++) {
            int number = new Random().nextInt(test.getTotalQuestions());
            if (aliaNum.size() == 0) {
                aliaNum.add(number);
            } else {
                while (aliaNum.contains(number)) {
                    number = new Random().nextInt(test.getTotalQuestions());
                }
                aliaNum.add(number);
            }

        }
        for (int i = 0; i < aliaNum.size(); i++) {
            vartest.add(test.getQuestions().get(aliaNum.get(i)));
        }
        
        test.setQuestions(vartest);
        globalPane.setStyle("-fx-background-color:transparent; -fx-background: rgb(255,255,255); -fx-background-color: rgb(255,255,255)");
        boxG = new VBox();
        System.out.println("Controllers.CandidatTestController.initialize()" + test);
        for (int i = 0; i < test.getQuestions().size(); i++) {

            VBox box = new VBox();
            box.setId(i + "");
            Text questionNumber = new Text("Question " + (i + 1));
            Text question = new Text("  " + test.getQuestions().get(i).getDescription());
            question.setId(i + "");
            questionNumber.setId(i + "");
            questionNumber.setStyle("-fx-font: 16 arial;");
            question.setStyle("-fx-font: 14 arial;");
            HBox box1 = new HBox();
            box1.setId(i + "");
            Text choixA = new Text(test.getQuestions().get(i).getChoiceA());
            choixA.setId(i + "");
            choixA.setWrappingWidth(500);
            CheckBox repA = new CheckBox();
            repA.setId(i + "A");
            choixA.setStyle("-fx-font: 14 arial;");
            choixA.setLayoutX(50);
            box1.getChildren().addAll(repA, choixA);

            HBox box2 = new HBox();
            box2.setId(i + "");
            Text choixB = new Text(test.getQuestions().get(i).getChoiceB());
            choixB.setId(i + "");
            choixB.setWrappingWidth(500);
            CheckBox repB = new CheckBox();
            repB.setId(i + "B");
            choixB.setStyle("-fx-font: 14 arial;");
            choixB.setLayoutX(50);
            box2.getChildren().addAll(repB, choixB);

            HBox box3 = new HBox();
            box3.setId(i + "");
            Text choixC = new Text(test.getQuestions().get(i).getChoiceC());
            choixC.setId(i + "");
            choixC.setWrappingWidth(500);
            CheckBox repC = new CheckBox();
            repC.setId(i + "C");
            choixC.setStyle("-fx-font: 14 arial;");
            choixC.setLayoutX(50);
            box3.getChildren().addAll(repC, choixC);

            HBox box4 = new HBox();
            box4.setId(i + "");
            Text choixD = new Text(test.getQuestions().get(i).getChoiceD());
            choixD.setId(i + "");
            choixD.setWrappingWidth(500);
            CheckBox repD = new CheckBox();
            repD.setId(i + "D");
            choixD.setStyle("-fx-font: 14 arial;");
            choixD.setLayoutX(50);
            box4.getChildren().addAll(repD, choixD);
            box1.setSpacing(20);
            box1.setMargin(repA, new Insets(0, 0, 0, 20));
            box2.setSpacing(20);
            box2.setMargin(repB, new Insets(0, 0, 0, 20));
            box3.setSpacing(20);
            box3.setMargin(repC, new Insets(0, 0, 0, 20));
            box4.setSpacing(20);
            box4.setMargin(repD, new Insets(0, 0, 0, 20));
            box.getChildren().addAll(questionNumber, question, box1, box2, box3, box4);
            box.setSpacing(30);
            boxG.setSpacing(48);
            boxG.getChildren().addAll(box);
            repA.setSelected(false);
            repB.setSelected(false);
            repC.setSelected(false);
            repD.setSelected(false);

            reps.add(repA);
            reps.add(repB);
            reps.add(repC);
            reps.add(repD);

        }
        switch (test.getDuration()) {
            case 15:
                duration.setText("15 Min");
                break;
            case 30:
                duration.setText("30 Min");
                break;
            case 45:
                duration.setText("45 Min");
                break;
            case 60:
                duration.setText("1H");
                break;
            case 90:
                duration.setText("1H 30Min");
                break;

            case 120:
                duration.setText("2H");
                break;
            default:
            // code block
        }
        globalPane.setContent(boxG);

    }
}
