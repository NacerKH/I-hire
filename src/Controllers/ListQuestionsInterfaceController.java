/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Question;
import java.util.*;

import Models.TableQuestionDto;
import Models.Test;
import Services.QuestionService;
import Validation.AlertInterface;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author e.bentijani
 */
public class ListQuestionsInterfaceController implements Initializable {

    @FXML
    private TableView<TableQuestionDto> table;
    @FXML
    private TableColumn<TableQuestionDto, String> question;
    @FXML
    private TableColumn<TableQuestionDto, Void> actions;
    private final ObservableList<TableQuestionDto> tvObservableList = FXCollections.observableArrayList();
    private Test test;

    @FXML
    private Text titre;
    @FXML
    private TableColumn<TableQuestionDto, Number> idQuestion;
    QuestionService QuestionRepo = QuestionService.GetInstance();
    @FXML
    private Button aDDQuestion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        table.setItems(tvObservableList);
        idQuestion.setCellValueFactory(new PropertyValueFactory<>("idQuestion"));
        question.setCellValueFactory(new PropertyValueFactory<>("question"));

        addButtonToTable();
    }

    private void fillTableObservableListWithSampleData(Test test) {

        for (Question t : test.getQuestions()) {
            tvObservableList.add(new TableQuestionDto(t.getId(), t.getUpdatedDate(), t.getDescription()));
        }
        titre.setText("Les Questions du Test " + test.getTopic());

    }

    private void addButtonToTable() {
        actions.setCellValueFactory(new PropertyValueFactory<>("actions"));

        Callback<TableColumn<TableQuestionDto, Void>, TableCell<TableQuestionDto, Void>> cellFactory = new Callback<TableColumn<TableQuestionDto, Void>, TableCell<TableQuestionDto, Void>>() {
            @Override
            public TableCell<TableQuestionDto, Void> call(final TableColumn<TableQuestionDto, Void> param) {
                final TableCell<TableQuestionDto, Void> cell = new TableCell<TableQuestionDto, Void>() {
                    final HBox hbox = new HBox();

                    Button btn1 = new Button("Modifier");

                    final Button btn2 = new Button("Effacer");

                    {
                        btn1.setStyle("-fx-text-fill: #21848B");
                        btn2.setStyle("-fx-text-fill: #C70039");

                        btn1.setOnAction((ActionEvent event) -> {
                            TableQuestionDto tableQuestionDto = getTableView().getItems().get(getIndex());
                            FXMLLoader loader = new FXMLLoader(
                                    getClass().getResource(
                                            "../GUI/UpdateQuestionInterface.fxml"
                                    )
                            );

                            try {
                                Parent root = loader.load();
                                UpdateQuestionInterfaceController controller = loader.getController();
                                titre.getScene().setRoot(root);
                                controller.jsp(test,tableQuestionDto.getIdQuestion() );
                            } catch (IOException ex) {
                                Logger.getLogger(UpdateTestInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        });
                        btn2.setOnAction((ActionEvent event) -> {
                            TableQuestionDto tableQuestionDto = getTableView().getItems().get(getIndex());
                            if (((test.getQuestions().size()) - 1) < test.getTotalQuestions()) {
                                Stage stage = (Stage) titre.getScene().getWindow();
                                AlertInterface.showAlertWithHeaderTextWARNING(stage, "le nombre de questions doit être supérieur ou égal aux nombre de questions a sélectionné, Merci d'ajouter des questions avant de supprimer des question ou de modifier le nombre de questions a sélectionné.");
                            } else {
                                Stage stage = (Stage) titre.getScene().getWindow();
                                Boolean res = AlertInterface.showAlertWithHeaderTextCONFIRMATION(stage, "Êtes-vous sur de vouloir supprimer la question de l'ID " + tableQuestionDto.getIdQuestion() + " ?");
                                if (res == true) {
                                    QuestionRepo.Delete(tableQuestionDto.getIdQuestion());
                                    for (int i = 0; i < tvObservableList.size(); i++) {
                                        if (tvObservableList.get(i).getIdQuestion()==tableQuestionDto.getIdQuestion()) {
                                            tvObservableList.remove(i);
                                        }
                                    }
                                } else {
                                    System.out.println("Canceling..");
                                }
                            }

                        });
                        hbox.getChildren().addAll(btn1, btn2);
                        hbox.setSpacing(10);
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {

                            setGraphic(hbox);

                        }
                    }
                };
                return cell;
            }
        };

        actions.setCellFactory(cellFactory);
        table.setItems(tvObservableList);
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public void jsp(Test test) {
        this.test = test;
        fillTableObservableListWithSampleData(test);

    }

    @FXML
    private void aDDQuestion(ActionEvent event) {
        
        FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "../GUI/AddOneQuestion.fxml"
                    )
            );
            try {
                Parent root = loader.load();
                AddOneQuestionController controller = loader.getController();
                titre.getScene().setRoot(root);
                controller.jsp(test);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

    }

}
