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
public class JobOffersUpdateController implements Initializable {

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
    private ChoiceBox<String> Choice_Categories;
    private JobOffer joboffer;
    @FXML
    private TextField txt_idJoboffer;
           
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txt_idJoboffer.setDisable(true);
        ShowJobs();
        Choice_Categories.setItems(FXCollections.observableArrayList(CategoryService.GetInstance().GetCategoryName()));
        Choice_Categories.getSelectionModel().select(0);

    }    


    @FXML
    private void FillChoice_Categories(MouseEvent event) {
    }

    @FXML
    private void Update_validate(MouseEvent event) {
        Date CreDate = Date.valueOf(val_CreDate.getValue().toString());
        Date UpdDate = Date.valueOf(val_UpDate.getValue().toString());
        JobOffer joboffer = new JobOffer(Integer.parseInt(txt_idJoboffer.getText()),txt_JobDescription.getText(),Integer.parseInt(txt_Averagesalary.getText()),Integer.parseInt(txt_Totalplaces.getText()),txt_status.getText(), CreDate,UpdDate,CategoryService.GetInstance().getCategoryByName(Choice_Categories.getValue()));
        JobOfferService.GetInstance().Put(joboffer);
        ShowJobs();

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

    @FXML
    private void Table_clikecked(MouseEvent event) {
        joboffer = TableView.getSelectionModel().getSelectedItem();
        txt_JobDescription.setText(joboffer.getJobDescription());
        txt_idJoboffer.setText(String.valueOf(joboffer.getId()));
        txt_Averagesalary.setText(String.valueOf(joboffer.getAverageSallary()));
        txt_Totalplaces.setText(String.valueOf(joboffer.getTotalPlaces()));
        txt_status.setText(String.valueOf(joboffer.getStatus()));
        Date crdate = (Date) joboffer.getCreatedDate();
        val_CreDate.setValue(crdate.toLocalDate());
        Date update = (Date) joboffer.getUpdatedDate();
        val_UpDate.setValue(update.toLocalDate());
        
        
        Choice_Categories.getSelectionModel().select(joboffer.getCategory().getName_cat());
        
    }
}
