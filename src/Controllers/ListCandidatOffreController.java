/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Main.FXMain;
import Services.JobOfferService;
import Models.Candidat;
import Models.CandidatOffre;
import Models.JobOffer;
import Models.TableCandidatOffreDto;
import Services.CandidatOffreService;
import Services.CandidatRepository;
import Validation.AlertInterface;
import Validation.StringRandom;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import java.util.Date;
import javax.mail.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author e.bentijani
 */
public class ListCandidatOffreController implements Initializable {

    @FXML
    private Text titre;
    @FXML
    private TableView<TableCandidatOffreDto> table;
    @FXML
    private TableColumn<TableCandidatOffreDto, Void> actions;
    @FXML
    private TableColumn<TableCandidatOffreDto, Integer> idCandidat;
    @FXML
    private TableColumn<TableCandidatOffreDto, String> status;
    @FXML
    private TableColumn<TableCandidatOffreDto, Date> postuDate;
    @FXML
    private TableColumn<TableCandidatOffreDto, String> fullName;
    CandidatOffreService candidatOffreRepo = CandidatOffreService.GetInstance();
    CandidatRepository candidatRepo = CandidatRepository.GetInstance();
    JobOfferService jobOfferService = JobOfferService.GetInstance();
    private int idOffre;
    private final ObservableList<TableCandidatOffreDto> tvObservableList = FXCollections.observableArrayList();
    @FXML 
    Button goBackButton; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void addButtonToTable() {
        actions.setCellValueFactory(new PropertyValueFactory<>("actions"));

        Callback<TableColumn<TableCandidatOffreDto, Void>, TableCell<TableCandidatOffreDto, Void>> cellFactory = new Callback<TableColumn<TableCandidatOffreDto, Void>, TableCell<TableCandidatOffreDto, Void>>() {
            @Override
            public TableCell<TableCandidatOffreDto, Void> call(final TableColumn<TableCandidatOffreDto, Void> param) {
                final TableCell<TableCandidatOffreDto, Void> cell = new TableCell<TableCandidatOffreDto, Void>() {
                    final HBox hbox = new HBox();
                    final Button btn1 = new Button("Affécter Test");

                    {

                        btn1.setStyle("-fx-text-fill: #B70AAF");

                        btn1.setOnAction((ActionEvent event) -> {
                            TableCandidatOffreDto candidatOffreDto = getTableView().getItems().get(getIndex());

                            if (candidatOffreDto.getOffer().getIdTest() == 0) {
                                Stage stage = (Stage) titre.getScene().getWindow();
                                AlertInterface.showAlertWithHeaderTextWARNING(stage, "L'offre ne posséde pas un test !");

                            } else {

                                if (candidatOffreDto.getCandidat().getId() != 0) {
                                    Stage stage = (Stage) titre.getScene().getWindow();
                                    AlertInterface.showAlertWithHeaderTextWARNING(stage, "Le Candidat posséde  déjà un test !");
                                } else {
                                    if (!candidatOffreDto.getStatus().contains("PANDING")) {
                                        Stage stage = (Stage) titre.getScene().getWindow();
                                        AlertInterface.showAlertWithHeaderTextWARNING(stage, "Le Candidat doit avoir une candidature de status <<PANDING>> !");
                                    } else {

                                        try {
                                            candidatOffreDto.setStatus("PRESELECTION");
                                            candidatOffreDto.setIdTest(candidatOffreDto.getOffer().getIdTest());
                                            candidatOffreDto.setPasswordTest(StringRandom.randomString(candidatOffreDto.getId() + "034FJEFU?"));
                                            candidatOffreRepo.AffectTest(candidatOffreDto);
                                            MailService m = new MailService();
                                            m.sendPlainTextEmail("smtp.gmail.com", "587",
                                                    "ehire04@gmail.com", "nokagttkxfxbktyy", candidatOffreDto.getCandidat().getEmail(),
                                                    "Évaluation pour l'Offre de l'ID : " + candidatOffreDto.getOffer().getId(), "Cher " + candidatOffreDto.getFullName() + ",\n"
                                                    + "Votre candidature pour le poste de l'ID : " + candidatOffreDto.getOffer().getId() + " au sein de notre société a retenu toute notre attention et nous souhaiterions vous évaluer merci de accédé à notre application et passé le test.\n"
                                                    + "Votre coordonnées :\nID Candidature : " + candidatOffreDto.getId() + "\n"
                                                    + "Mot de passe : " + candidatOffreDto.getPasswordTest() + "\n" + "Cordialement,\nEquipe E-hire   "
                                            );
                                            FXMLLoader loader = new FXMLLoader(
                                                    getClass().getResource(
                                                            "../GUI/ListCandidatOffreInterface.fxml"
                                                    )
                                            );

                                            try {
                                                Parent root = loader.load();
                                                ListCandidatOffreController controller = loader.getController();
                                                titre.getScene().setRoot(root);
                                                controller.jsp(candidatOffreDto.getOffer().getId());
                                            } catch (IOException ex) {
                                                Logger.getLogger(UpdateTestInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        } catch (MessagingException ex) {
                                            System.out.println("problem while sending email");
                                        }
                                    }
                                }

                            }

                        });
                        hbox.getChildren().addAll(btn1);

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

    public void jsp(int idOffre) {
        this.idOffre = idOffre;
        initData();

    }

    public void initData() {
        ArrayList<CandidatOffre> list = candidatOffreRepo.GetAllByIdOffre(idOffre);
        System.out.println(list);
        table.setItems(tvObservableList);
        idCandidat.setCellValueFactory(new PropertyValueFactory<>("idCandidat"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        postuDate.setCellValueFactory(new PropertyValueFactory<>("postuDate"));
        fullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        for (CandidatOffre j : list) {
            JobOffer jobOffer = jobOfferService.GetById(j.getOfferId());
            Candidat d = candidatRepo.GetById(j.getCondidatId());
            tvObservableList.add(new TableCandidatOffreDto(d, j.getStatus() + "", j.getPostedDate(), d.getFullName(), jobOffer, j.getId(), jobOffer.getId(), j.getCondidatId()));
        }
        addButtonToTable();
        // TODO
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
