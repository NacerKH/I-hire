/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Category;
import Models.JobOffer;
import Services.CategoryService;
import Services.JobOfferService;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
public class JobOffersTableController implements Initializable {

    @FXML
    private TableView<JobOffer> TableView;
    @FXML
    private TextField txt_JobDescription;
    @FXML
    private TextField txt_Averagesalary;
    @FXML
    private TextField txt_Totalplaces;
    @FXML
    private TextField txt_status;
    @FXML
    private DatePicker val_CreDate;
    @FXML
    private DatePicker val_UpDate;
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
    @FXML
    private ChoiceBox<Category> Choice_Categories;
           

UserServices _service; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ShowJobs();
        Choice_Categories.setItems(FXCollections.observableArrayList(CategoryService.GetInstance().GetAll()));
    }    

    @FXML
    private void HandleMouseAction(MouseEvent event) {
    }
    private void ShowJobs () {
        TableView.getItems().clear();
        col_JobD.setCellValueFactory(new PropertyValueFactory<>("jobDescription"));
        col_avgs.setCellValueFactory(new PropertyValueFactory<>("AverageSalary"));
        col_totalp.setCellValueFactory(new PropertyValueFactory<>("totalPlaces"));
        col_Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        col_Crd.setCellValueFactory(new PropertyValueFactory<>("CreatedDate"));
        col_upd.setCellValueFactory(new PropertyValueFactory<>("UpdatedDate"));
        col_categ.setCellValueFactory(new PropertyValueFactory<>("category"));
        
        joblist = FXCollections.observableArrayList(JobOfferService.GetInstance().GetAll());
        TableView.setItems(joblist);
    }

    @FXML
    private void FillChoice_Categories(MouseEvent event) {
    }

    @FXML
    private void Update_validate(MouseEvent event) {
    }
    
}
