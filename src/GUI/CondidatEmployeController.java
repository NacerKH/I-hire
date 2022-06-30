/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.CondidatEmployee;
import Models.JobOffer;
import Services.CondidatEmployeeRepository;
import Services.JobOfferService;
import java.awt.Desktop;
import java.awt.ScrollPane;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import java.nio.file.Files;
import static java.nio.file.Files.list;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.stage.Window;
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class CondidatEmployeController implements Initializable {
    //widgets

    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<?> OfferId;
    @FXML
    private Button Cv_url;
    @FXML
    private Button btn_Post;

    private Desktop desktop = Desktop.getDesktop();
    final FileChooser fileChooser = new FileChooser();
    final DirectoryChooser dirChooser = new DirectoryChooser();
    final Stage stage = new Stage();
public String id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }

    private void loadData() {
        list.removeAll(list);
        JobOfferService.GetInstance().GetAll().
        forEach(u->  list.add( u.getJobDescription()));   
            OfferId.getItems().addAll(list);
            OfferId.getOnKeyPressed();
    }

    @FXML
    public void Dowload(ActionEvent event) {
        /**
         * JFileChooser fc=new JFileChooser(); fc.showSaveDialog(fc); File f=
         * fc.getSelectedFile();
         *
         * FileWriter fw= new FileWriter(f);
         */
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("src"));
        configureFileChooser(fileChooser);
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Pdf Files", "*.pdf"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        System.out.println(selectedFile.getName());
        /**
         * if (selectedFile != null) { openFile(selectedFile);
              }*
         */

        File selectedDirectory = directoryChooser.showDialog(stage);
        final File settingsFile = new File(selectedDirectory.getAbsolutePath());
    }

    @FXML
    private void PostCondidatEmp(ActionEvent event) {
        System.out.println( Cv_url);

        CondidatEmployee condidatEmployee = new CondidatEmployee();

    }

    private static void configureFileChooser(final FileChooser fileChooser) {
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                    CondidatEmployeController.class.getName()).log(
                    Level.ALL.SEVERE, null, ex
            );
        }
    }
}
