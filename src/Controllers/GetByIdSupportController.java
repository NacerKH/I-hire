/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Interview;
import Models.Support;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import services.SupportService;


/**
 * FXML Controller class
 *
 * @author Maryouma
 */
public class GetByIdSupportController implements Initializable {

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
    private Button getSupportById;
    @FXML
    private TextField id;
    private ObservableList<Support> data = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getSupportById(ActionEvent event) {
        
        
        data = FXCollections.observableArrayList( SupportService.GetInstance().GetById(Integer.parseInt(id.getText())));
        id_support.setCellValueFactory(new PropertyValueFactory<>("id_support"));
        id_interview.setCellValueFactory(new PropertyValueFactory<>("interview"));
        description_offre.setCellValueFactory(new PropertyValueFactory<>("description_offre"));
        cv_candidate.setCellValueFactory(new PropertyValueFactory<>("cv_candidate"));
        
        
         tableview.setItems(data);
            
    }
    
}
