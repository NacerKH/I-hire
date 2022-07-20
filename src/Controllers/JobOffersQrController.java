/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Category;
import Models.JobOffer;
import Services.JobOfferService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author wawa
 */
public class JobOffersQrController implements Initializable {

    @FXML
    private ImageView qrView;
    @FXML
    private TableView<JobOffer> TableView;
    @FXML
    private TableColumn<JobOffer, String> col_JobD;
    @FXML
    private TableColumn<JobOffer, Integer> col_avgs;
    @FXML
    private TableColumn<JobOffer, Integer> col_totalp;
    @FXML
    private TableColumn<JobOffer, Date> col_Crd;
    @FXML
    private TableColumn<JobOffer,Date> col_upd;
    @FXML
    private TableColumn<JobOffer, String> col_Status;
    @FXML
    private TableColumn<JobOffer, Category> col_categ;
    ObservableList<JobOffer> joblist = FXCollections.observableArrayList();
   
    private JobOffer joboffer;
    private String Description;
    @FXML
    private Button generateQr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ShowJobs();
        // TODO
        

        
    }
     private void ShowJobs () {
        TableView.getItems().clear();
        col_JobD.setCellValueFactory(new PropertyValueFactory<>("jobDescription"));
        col_avgs.setCellValueFactory(new PropertyValueFactory<>("AverageSallary"));
        col_totalp.setCellValueFactory(new PropertyValueFactory<>("totalPlaces"));
        col_Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        col_Crd.setCellValueFactory(new PropertyValueFactory<>("CreatedDate"));
        col_upd.setCellValueFactory(new PropertyValueFactory<>("UpdatedDate"));
        col_categ.setCellValueFactory(new PropertyValueFactory<>("category"));
        joblist = FXCollections.observableArrayList(JobOfferService.GetInstance().GetAll());
        TableView.setItems(joblist);
    }
    @FXML
    private void Table_clikecked(MouseEvent event) {
          joboffer = TableView.getSelectionModel().getSelectedItem();
          Description = joboffer.toString();
          
          
    }

    @FXML
    private void generateQr(ActionEvent event) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWeb = Description;
        int width = 300;
        int height = 300;
        
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);

//Create a Canvas (a place to draw on), with a 2D Graphic (a kind of drawing)
            Canvas canvas = new Canvas(width, height);
            GraphicsContext gc2D = canvas.getGraphicsContext2D();

//in white, paint a rectangle on it, with the full size
            gc2D.setFill(javafx.scene.paint.Color.WHITE);
            gc2D.fillRect(0, 0, width, height);

//start painting in black: each bit/pixel set in the bitMatix
            gc2D.setFill(javafx.scene.paint.Color.BLACK);
            for (int v = 0; v < height; v++) {
                for (int h = 0; h < width; h++) {
                    if (bitMatrix.get(v, h)) {
                        gc2D.fillRect(h, v, 1, 1);
                    }
                }
            }

//Take a snapshot of the canvas and set it as an image in the ImageView control
            qrView.setImage(canvas.snapshot(null, null));
        } catch (WriterException e) {
            e.printStackTrace();
        }
        
    }

}
