/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Main.FXMain;
import Models.JobOffer;
import Models.TableJobOffreDto;
import Models.Test;
import Services.JobOfferService;
import Services.QuestionService;
import Services.TestService;
import Validation.AlertInterface;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author e.bentijani
 */
public class ListOffreInterfaceController implements Initializable {

    @FXML
    private Text titre;
    @FXML
    private TableView<TableJobOffreDto> table;
    @FXML
    private TableColumn<TableJobOffreDto, Number> idOffre;
    @FXML
    private TableColumn<TableJobOffreDto, Date> CreatedDate;
    @FXML
    private TableColumn<TableJobOffreDto, Date> UpdatedDate;
    @FXML
    private TableColumn<TableJobOffreDto, Date> totalPlaces;
    @FXML
    private TableColumn<TableJobOffreDto, Void> actions;
    private List<JobOffer> offres;
    JobOfferService jobOfferService = JobOfferService.GetInstance();
    private final ObservableList<TableJobOffreDto> tvObservableList = FXCollections.observableArrayList();
    TestService testService = TestService.GetInstance();
    QuestionService QuestionRepo = QuestionService.GetInstance();
    @FXML 
    Button goBackButton; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        offres = jobOfferService.GetAll();
        System.out.println("Controllers.ListOffreInterfaceController.initialize()" + jobOfferService.GetAll());
        table.setItems(tvObservableList);
        for (JobOffer j : offres) {
            tvObservableList.add(new TableJobOffreDto(j.getId(), j.getCreatedDate(), j.getUpdatedDate(), j.getTotalPlaces(), j.getIdTest()));
        }
        idOffre.setCellValueFactory(new PropertyValueFactory<>("idOffre"));
        CreatedDate.setCellValueFactory(new PropertyValueFactory<>("CreatedDate"));
        UpdatedDate.setCellValueFactory(new PropertyValueFactory<>("UpdatedDate"));
        totalPlaces.setCellValueFactory(new PropertyValueFactory<>("totalPlaces"));
        addButtonToTable();

    }

    private void addButtonToTable() {
        actions.setCellValueFactory(new PropertyValueFactory<>("actions"));

        Callback<TableColumn<TableJobOffreDto, Void>, TableCell<TableJobOffreDto, Void>> cellFactory = new Callback<TableColumn<TableJobOffreDto, Void>, TableCell<TableJobOffreDto, Void>>() {
            @Override
            public TableCell<TableJobOffreDto, Void> call(final TableColumn<TableJobOffreDto, Void> param) {
                final TableCell<TableJobOffreDto, Void> cell = new TableCell<TableJobOffreDto, Void>() {
                    final HBox hbox = new HBox();
                    final Button btn1 = new Button("Modifier Test");
                    final Button btn2 = new Button("Effacer Test");
                    final Button btn3 = new Button("Ajouter Test");
                    final Button btn4 = new Button("Gérer Candidatures");

                    {
                        btn2.setStyle("-fx-text-fill: #21848B");
                        btn3.setStyle("-fx-text-fill: #C70039");
                        btn1.setStyle("-fx-text-fill: #908D8E");
                        btn4.setStyle("-fx-text-fill: #908D8E");

                        btn1.setOnAction((ActionEvent event) -> {
                            TableJobOffreDto tableJobOffreDto = getTableView().getItems().get(getIndex());

                            if (tableJobOffreDto.getIdTest() == 0) {
                                Stage stage = (Stage) titre.getScene().getWindow();
                                AlertInterface.showAlertWithHeaderTextWARNING(stage, "L'offre d'emploi n'a pas de test!");
                            } else {
                                FXMLLoader loader = new FXMLLoader(
                                        getClass().getResource(
                                                "../GUI/UpdateTestInterface.fxml"
                                        )
                                );

                                try {
                                    Parent root = loader.load();
                                    UpdateTestInterfaceController controller = loader.getController();
                                    titre.getScene().setRoot(root);
                                    controller.jsp(new Test(tableJobOffreDto.getIdTest()));
                                } catch (IOException ex) {
                                    Logger.getLogger(UpdateTestInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }

                        });
                        btn2.setOnAction((ActionEvent event) -> {
                            TableJobOffreDto tableJobOffreDto = getTableView().getItems().get(getIndex());

                            if (tableJobOffreDto.getIdTest() == 0) {
                                Stage stage = (Stage) titre.getScene().getWindow();
                                AlertInterface.showAlertWithHeaderTextWARNING(stage, "L'offre d'emploi n'a pas de test !");
                            } else {
                                Stage stage = (Stage) titre.getScene().getWindow();
                                Boolean res = AlertInterface.showAlertWithHeaderTextCONFIRMATION(stage, "Êtes-vous sur de vouloir supprimer le test de l'ID " + tableJobOffreDto.getIdTest() + " ?");
                                if (res == true) {
                                    jobOfferService.PutNullTest(new JobOffer(tableJobOffreDto.getIdOffre()));
                                    QuestionRepo.DeleteTestQuestion(tableJobOffreDto.getIdTest());
                                    testService.Delete(tableJobOffreDto.getIdTest());
                                   tableJobOffreDto.setIdTest(0);
                                } else {
                                    System.out.println("Canceling..");
                                }
                            }

                        });
                        btn3.setOnAction((ActionEvent event) -> {
                            TableJobOffreDto tableJobOffreDto = getTableView().getItems().get(getIndex());

                            if (tableJobOffreDto.getIdTest() != 0) {
                                Stage stage = (Stage) titre.getScene().getWindow();
                                AlertInterface.showAlertWithHeaderTextWARNING(stage, "L'offre de l'emploi  possède déjà un test !");
                            } else {
                                FXMLLoader loader = new FXMLLoader(
                                        getClass().getResource(
                                                "../GUI/TestInterface.fxml"
                                        )
                                );

                                try {
                                    Parent root = loader.load();
                                    TestInterfaceController controller = loader.getController();
                                    titre.getScene().setRoot(root);
                                    controller.jsp(tableJobOffreDto.getIdOffre());
                                } catch (IOException ex) {
                                    Logger.getLogger(UpdateTestInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }

                        });
                        
                          btn4.setOnAction((ActionEvent event) -> {
                            TableJobOffreDto tableJobOffreDto = getTableView().getItems().get(getIndex());

                                FXMLLoader loader = new FXMLLoader(
                                        getClass().getResource(
                                                "../GUI/ListCandidatOffreInterface.fxml"
                                        )
                                );

                                try {
                                    Parent root = loader.load();
                                    ListCandidatOffreController controller = loader.getController();
                                    titre.getScene().setRoot(root);
                                    controller.jsp(tableJobOffreDto.getIdOffre());
                                } catch (IOException ex) {
                                    Logger.getLogger(UpdateTestInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            

                        });
                        hbox.getChildren().addAll(btn1, btn2, btn3,btn4);

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
    
    public void onGoBackButtonClicked()
    {
       try
       {
           Parent root = FXMLLoader.load(getClass().getResource("../GUI/HomePage.fxml"));
        
           Stage window = (Stage)goBackButton.getScene().getWindow(); 
           
           window.setScene(new Scene(root,1280 , 720 ));
           
       }
       catch (IOException ex) 
        {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
