/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author wawa
 */
public class JobOffersMainController implements Initializable {
    private Parent fxml;
    
    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            try {
            fxml = FXMLLoader.load(getClass().getResource("..//GUI//JobOffersTable.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
            
            
        } catch (IOException ex) {
            Logger.getLogger(JobOffersMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void BttnOffreDeTravail(ActionEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("..//GUI//JobOffersTable.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
            
            
        } catch (IOException ex) {
            Logger.getLogger(JobOffersMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void BttnUpdate(ActionEvent event) {
         try {
            fxml = FXMLLoader.load(getClass().getResource("..//GUI//JobOffersUpdate.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
            
            
        } catch (IOException ex) {
            Logger.getLogger(JobOffersMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void BttnDelete(ActionEvent event) {
          try {
            fxml = FXMLLoader.load(getClass().getResource("..//GUI//JobOffersDelete.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
            
            
        } catch (IOException ex) {
            Logger.getLogger(JobOffersMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void BttnAdd(ActionEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("..//GUI//JobOffersAdd.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
            
            
        } catch (IOException ex) {
            Logger.getLogger(JobOffersMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void BttnQrCode(ActionEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("..//GUI//JobOffersQr.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
            
            
        } catch (IOException ex) {
            Logger.getLogger(JobOffersMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void BttnCategories(ActionEvent event) {
          try {
            fxml = FXMLLoader.load(getClass().getResource("..//GUI//CategoriesManage.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
            
            
        } catch (IOException ex) {
            Logger.getLogger(JobOffersMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
