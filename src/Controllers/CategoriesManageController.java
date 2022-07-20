/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Category;
import Services.CategoryService;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
public class CategoriesManageController implements Initializable {

    @FXML
    private TableView<Category> TableView;
    @FXML
    private TableColumn<Category, String> col_CatName;
    @FXML
    private TextField txt_idCategory;
    @FXML
    private TextField txt_CategoryName;
    ObservableList<Category> CategoriesList = FXCollections.observableArrayList();
    private Category Category ;
    private Alert alertConfirmation = new Alert(Alert.AlertType.CONFIRMATION);
    private Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);

    private Alert alertWarning = new Alert(Alert.AlertType.WARNING);


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ShowCategories();
    }    

    @FXML
    private void Table_clikecked(MouseEvent event) {
        Category = TableView.getSelectionModel().getSelectedItem();
        txt_idCategory.setText(String.valueOf(Category.getId_cat()));
        txt_CategoryName.setText(String.valueOf(Category.getName_cat()));
        
    }

    @FXML
    private void Bttn_Add(ActionEvent event) {
        if (!txt_CategoryName.getText().equals("")) {
        Category = new Category(txt_CategoryName.getText());
        CategoryService.GetInstance().Post(Category);
        ShowCategories();
        txt_CategoryName.setText("");
         alertInformation.setTitle("Done!");
             alertInformation.setHeaderText(null);
             alertInformation.setContentText("Category added.");
             alertInformation.showAndWait();}
        else {
            alertWarning.setTitle("Warning!");
            alertWarning.setHeaderText(null);
            alertWarning.setContentText("Please fill in the appropriate information !");

            alertWarning.showAndWait();
        }
        
    }

    @FXML
    private void Bttn_Update(ActionEvent event) {
       Category = new Category(Integer.parseInt(txt_idCategory.getText()), txt_CategoryName.getText());
        CategoryService.GetInstance().Put(Category);
        ShowCategories();
    }   

    @FXML
    private void Bttn_Delete(ActionEvent event) {
          alertConfirmation.setTitle("Delete Category");
        alertConfirmation.setHeaderText(null);
        alertConfirmation.setContentText("Delete " + Category.getName_cat()+ "?");

        Optional<ButtonType> result = alertConfirmation.showAndWait();
         if (result.get() == ButtonType.OK) {
              CategoryService.GetInstance().Delete(Integer.parseInt(txt_idCategory.getText()));
              ShowCategories();
              txt_idCategory.setText("");
              txt_CategoryName.setText("");
            
        }
    }
    
    private void ShowCategories () {
    TableView.getItems().clear();
    col_CatName.setCellValueFactory(new PropertyValueFactory<>("name_cat"));

    CategoriesList = FXCollections.observableArrayList(CategoryService.GetInstance().GetAll());
    TableView.setItems(CategoriesList);
}
    

    
}
