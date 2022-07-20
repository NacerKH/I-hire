/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Main.FXMain;
import Models.Interview;
import services.InterviewService;
import Utils.AppDbContext;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.SupportService;

/**
 * FXML Controller class
 *
 * @author Maryouma
 */
public class GetAllController implements Initializable {

    Connection cnx = AppDbContext.GetInstance().GetDbConnection();

    @FXML
    private Button ok;
    @FXML
    private TableView<Interview> tableview;
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
    private final ObservableList<Interview> data = FXCollections.observableArrayList();
    
    @FXML 
    Button goBackButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void getAll(ActionEvent event) {

        InterviewService is = new InterviewService();
        List<Interview> listinter = is.GetAll();
        id_interview.setCellValueFactory(new PropertyValueFactory<>("id_interview"));
        date_interview.setCellValueFactory(new PropertyValueFactory<>("date_interview"));
        update_interview.setCellValueFactory(new PropertyValueFactory<>("update_interview"));
        type_interview.setCellValueFactory(new PropertyValueFactory<>("type_interview"));
        statut.setCellValueFactory(new PropertyValueFactory<>("statut"));

        tableview.setItems(data);
        for (Interview t : listinter) {
            data.add(t);
        } 
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
