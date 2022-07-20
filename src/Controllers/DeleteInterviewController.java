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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
public class DeleteInterviewController implements Initializable {

    InterviewService is = new InterviewService();

    @FXML
    private TextField id;
    @FXML
    private Button delete;
    @FXML
    private TableColumn<Interview, Integer> id_interview;
    @FXML
    private TableColumn<Interview, Date> date_interview;
    @FXML
    private TableColumn<Interview, String> type_interview;
    @FXML
    private TableColumn<Interview, String> statut;
    @FXML
    private TableColumn<Interview, Date> update_interview;

    private ObservableList<Interview> data = FXCollections.observableArrayList();
    @FXML
    private TableView<Interview> table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showall();
    }

    @FXML
    private void deleteInterview(ActionEvent event) {

        InterviewService is = new InterviewService();
        Alert a = new Alert(Alert.AlertType.INFORMATION, "Souhaitez-vous supprimez cette ligne?", ButtonType.OK);
        a.showAndWait();
        is.Delete(Integer.parseInt(id.getText()));

        List<Interview> listinter = is.GetAll();
        id_interview.setCellValueFactory(new PropertyValueFactory<>("id_interview"));
        date_interview.setCellValueFactory(new PropertyValueFactory<>("date_interview"));
        update_interview.setCellValueFactory(new PropertyValueFactory<>("update_interview"));
        type_interview.setCellValueFactory(new PropertyValueFactory<>("type_interview"));
        statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        table.setItems(data);
        for (Interview t : listinter) {
            data.add(t);
        }
        id.clear();

    }

    private void getAll(ActionEvent event) {
        showall();
        
        }
     public void showall() { 
        table.getItems().clear();
         data = FXCollections.observableArrayList( InterviewService.GetInstance().GetAll());
        id_interview.setCellValueFactory(new PropertyValueFactory<>("id_interview"));
        date_interview.setCellValueFactory(new PropertyValueFactory<>("date_interview"));
        update_interview.setCellValueFactory(new PropertyValueFactory<>("update_interview"));
        type_interview.setCellValueFactory(new PropertyValueFactory<>("type_interview"));
        statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        table.setItems(data);
      

}

    @FXML
    private void getAllnow(ActionEvent event) {
        showall();
    }

    }

 

   