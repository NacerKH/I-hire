/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.JobOffer;
import Services.CategoryService;
import Services.JobOfferService;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author wawa
 */
public class JobOffersAddController implements Initializable {

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
    private DatePicker val_UpDate;
    @FXML
    private ChoiceBox<String> Choice_Categories;
    private Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
    private Alert alertWarning = new Alert(Alert.AlertType.WARNING);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Choice_Categories.setItems(FXCollections.observableArrayList(CategoryService.GetInstance().GetCategoryName()));
        Choice_Categories.getSelectionModel().select(0);
        // TODO
    }    

    @FXML
    private void Add_validate(MouseEvent event) {
        if (!isEmpty())
        {      try {
            Date CreDate = Date.valueOf(val_CreDate.getValue().toString());
//            Date UpdDate = Date.valueOf(val_UpDate.getValue().toString());
                  
            JobOffer joboffer = new JobOffer(txt_JobDescription.getText(),Integer.parseInt(txt_Averagesalary.getText()),Integer.parseInt(txt_Totalplaces.getText()),txt_status.getText(), CreDate,CreDate,CategoryService.GetInstance().getCategoryByName(Choice_Categories.getValue()));
            
            JobOfferService.GetInstance().Post(joboffer);
             alertInformation.setTitle("Done!");
             alertInformation.setHeaderText(null);
             alertInformation.setContentText("Job offer added.");
             alertInformation.showAndWait();
            } catch (NumberFormatException ex) {
                 Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                a.showAndWait();
               
            }
             catch (NullPointerException ex) {
                  Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
                a.showAndWait();
             }
            
            
         }
        else {
            alertWarning.setTitle("Warning!");
            alertWarning.setHeaderText(null);
            alertWarning.setContentText("Please fill in the appropriate information !");

            alertWarning.showAndWait();
        }
    }
    
    public boolean isEmpty() {

        if (!txt_JobDescription.getText().equals("") && !txt_Averagesalary.getText().equals("") && !txt_Totalplaces.getText().equals("") && !txt_status.getText().equals("") && val_CreDate.getValue() ==null && !Choice_Categories.getSelectionModel().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
}
