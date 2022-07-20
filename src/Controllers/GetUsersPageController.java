/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Enums.UserType;
import Main.FXMain;
import Models.User;
import Services.UserServices;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

/**
 * FXML Controller class
 *
 * @author Dhiaeddsn
 */
public class GetUsersPageController implements Initializable {

    @FXML
    private TableView<User> TableView;
    @FXML
    private TableColumn<User, Integer> col_id;
    @FXML
    private TableColumn<User, String> col_username;
    private TableColumn<User, String> colcol_email_id;
    @FXML
    private TableColumn<User, UserType> col_type;
    @FXML
    private TableColumn<User, Date> col_birth;
    @FXML
    private TableColumn<User, String> col_jobTitle;
    
    ObservableList<User> userlist = FXCollections.observableArrayList();
    UserServices _service; 
    @FXML
    private TableColumn<?, ?> col_email;
    
    @FXML
    Button CreateUserButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Init Home Page is starting...");
        _service = UserServices.GetInstance(); 
        InitUserList(); 
    }    
   
    
    private void InitUserList()
    {
        TableView.getItems().clear();
        col_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        col_username.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("UserType"));
        col_birth.setCellValueFactory(new PropertyValueFactory<>("Birthday"));
        col_jobTitle.setCellValueFactory(new PropertyValueFactory<>("JobTitle"));
        
        userlist = FXCollections.observableArrayList(_service.GetAll());
        TableView.setItems(userlist);
        
        
    }
    
    @FXML
    public void onRefreshButtonClicked()
    {
        InitUserList(); 
    }
    
    public void onCreateUserButtonClicked()
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/CreateUserPage.fxml"));
        
            Stage window = (Stage)CreateUserButton.getScene().getWindow(); 
            
            window.setScene(new Scene(root,1280 , 720 ));
        }
        catch (IOException ex) 
        {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
