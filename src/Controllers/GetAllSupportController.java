/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Main.FXMain;
import Models.Interview;
import Models.Support;
import java.io.IOException;
import services.InterviewService;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.SupportService;

/**
 * FXML Controller class
 *
 * @author Maryouma
 */
public class GetAllSupportController implements Initializable {
    

    @FXML
    private Button get;
    @FXML
    private TableView<Support> tableview;
    @FXML
    private TableColumn<Support, Integer> id_support;
    @FXML
    private TableColumn<Support, Interview> id_interview;
    @FXML
    private TableColumn<Support, String> description_offre;
    @FXML
    private TableColumn<Support, String> cv_candidate;
    @FXML 
    Button goBackButton;
    
    private ObservableList<Support> data = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        InterviewService is = new InterviewService();
        List<Interview> interviews = is.GetAll();
    }    

    @FXML
    private void getAllSupport(ActionEvent event) {
        
       data = FXCollections.observableArrayList( SupportService.GetInstance().GetAll());
        id_support.setCellValueFactory(new PropertyValueFactory<>("id_support"));
        id_interview.setCellValueFactory(new PropertyValueFactory<>("interview"));
        description_offre.setCellValueFactory(new PropertyValueFactory<>("description_offre"));
        cv_candidate.setCellValueFactory(new PropertyValueFactory<>("cv_candidate"));
        
        
         tableview.setItems(data);
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
