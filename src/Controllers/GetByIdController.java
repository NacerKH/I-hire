/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Interview;
import services.InterviewService;
import java.net.URL;
import java.util.Date;
import java.util.List;
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

/**
 * FXML Controller class
 *
 * @author Maryouma
 */
public class GetByIdController implements Initializable {

    @FXML
    private Button ok;
    @FXML
    private TextField id;
    @FXML
    private TableColumn<Interview, Integer> id_interview;
    @FXML
    private TableColumn<Interview, Date> date_interview;
    @FXML
    private TableColumn<Interview, Date> update_interview;
    @FXML
    private TableColumn<Interview, String> type_interview;
    @FXML
    private TableColumn<Interview, String> statut;
    @FXML
    private TableView<Interview> tableView;
    private final ObservableList<Interview> data = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getAll(ActionEvent event) {
        InterviewService is = new InterviewService();
       
       Interview listinter = is.GetById(Integer.parseInt(id.getText()));
        id_interview.setCellValueFactory(new PropertyValueFactory<>("id_interview"));
        date_interview.setCellValueFactory(new PropertyValueFactory<>("date_interview"));
        update_interview.setCellValueFactory(new PropertyValueFactory<>("update_interview"));
        type_interview.setCellValueFactory(new PropertyValueFactory<>("type_interview"));
        statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        
         tableView.setItems(data);
            data.add(listinter);
    }
    
}
