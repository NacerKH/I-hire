/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Main.FXMain;
import Services.JobOfferService;
import java.awt.Desktop;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class PostCondidatEmploye implements Initializable {
    //widgets

    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<?> OfferId;
    @FXML
    private Button Cv_url;
    @FXML
    private Button btn_Post;
    @FXML 
    Button goBackButton; 

    private Desktop desktop = Desktop.getDesktop();
    final FileChooser fileChooser = new FileChooser();
    final DirectoryChooser dirChooser = new DirectoryChooser();
    final Stage stage = new Stage();
    public String id;
    public String path;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }

    private void loadData() {
        list.removeAll(list);
                        list.add( "choose Your Offer");

        JobOfferService.GetInstance().GetAll().
        forEach(u->  
                list.add(u.getId(), u.getJobDescription())
        );   
            OfferId.getItems().addAll(list);
               OfferId.getSelectionModel().selectFirst();
        
    }

    @FXML
    public void  Dowload(ActionEvent event) {
     
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("src"));
        configureFileChooser(fileChooser);
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Pdf Files", "*.pdf"));
        File selectedFile = fileChooser.showOpenDialog(stage);
   //     System.out.println(selectedFile.getName()); 

       if (selectedFile != null) { openFile(selectedFile);
              }
         

        //File selectedDirectory = directoryChooser.showDialog(stage);
      //  final File settingsFile = new File(selectedDirectory.getAbsolutePath());
           //
    }

    @FXML
    private void PostCondidatEmp(ActionEvent event) {

        /// we must get the userid login 
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); we must do this class authentifcation
        
       // User user = (User)authentication.getPrincipal();
        //int userId = user.getId();

        int EmployeOfferId =OfferId.getSelectionModel().selectedIndexProperty().getValue();
        System.out.println(path);
        //CondidatEmployee condidatEmployee = new CondidatEmployee(EmployeOfferId,userId);

    }

    private static void configureFileChooser(final FileChooser fileChooser) {
        fileChooser.setTitle("View attachement");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
    }

    private String  openFile(File file) {
      return   path =file.getName();
    }
    
    public void onGoBackButtonClicked()
    {
       try
       {
           Parent root = FXMLLoader.load(getClass().getResource("../GUI/StartPage.fxml"));
        
           Stage window = (Stage)goBackButton.getScene().getWindow(); 
           
           window.setScene(new Scene(root,1280 , 720 ));
           
       }
       catch (IOException ex) 
        {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
