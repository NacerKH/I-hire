/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Category;
import Models.JobOffer;
import Services.JobOfferService;
import java.net.URL;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author wawa
 */
public class JobOffersDeleteController implements Initializable {

    @FXML
    private TableView<JobOffer> TableView;
    @FXML
    private TableColumn<JobOffer, String> col_JobD;
    @FXML
    private TableColumn<JobOffer, Integer> col_avgs;
    @FXML
    private TableColumn<JobOffer, Integer> col_totalp;
    @FXML
    private TableColumn<JobOffer, Date> col_Crd;
    @FXML
    private TableColumn<JobOffer,Date> col_upd;
    @FXML
    private TableColumn<JobOffer, String> col_Status;
    @FXML
    private TableColumn<JobOffer, Category> col_categ;
    ObservableList<JobOffer> joblist = FXCollections.observableArrayList();
   
    private JobOffer joboffer;
    @FXML
    private TextField txt_idJoboffer;
    private Alert alertConfirmation = new Alert(Alert.AlertType.CONFIRMATION);


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ShowJobs();
    }    

    @FXML
    private void Table_clikecked(MouseEvent event) {
          joboffer = TableView.getSelectionModel().getSelectedItem();
          txt_idJoboffer.setText(String.valueOf(joboffer.getId()));
          txt_idJoboffer.setDisable(true);
    }

    @FXML
    private void Delete_validate(MouseEvent event) {
        alertConfirmation.setTitle("Delete Job offer");
        alertConfirmation.setHeaderText(null);
        alertConfirmation.setContentText("Delete " + joboffer.getJobDescription()+ "?");

        Optional<ButtonType> result = alertConfirmation.showAndWait();
         if (result.get() == ButtonType.OK) {
              JobOfferService.GetInstance().Delete(Integer.parseInt(txt_idJoboffer.getText()));
              ShowJobs();
            
        }

       
       
    }
     private void ShowJobs () {
        TableView.getItems().clear();
        col_JobD.setCellValueFactory(new PropertyValueFactory<>("jobDescription"));
        col_avgs.setCellValueFactory(new PropertyValueFactory<>("AverageSallary"));
        col_totalp.setCellValueFactory(new PropertyValueFactory<>("totalPlaces"));
        col_Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        col_Crd.setCellValueFactory(new PropertyValueFactory<>("CreatedDate"));
        col_upd.setCellValueFactory(new PropertyValueFactory<>("UpdatedDate"));
        col_categ.setCellValueFactory(new PropertyValueFactory<>("category"));
        joblist = FXCollections.observableArrayList(JobOfferService.GetInstance().GetAll());
        TableView.setItems(joblist);
    }
    
}
