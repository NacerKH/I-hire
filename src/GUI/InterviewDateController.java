/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Candidat;
import Services.CandidatRepository;
import Utils.AppDbContext;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author KHLIFI-MED
 */
public class InterviewDateController implements Initializable {

    Connection cnx = AppDbContext.GetInstance().GetDbConnection();

    @FXML
    private TableView<Candidat> table;

    @FXML
    private TableColumn<Candidat, String> fullName;

    @FXML
    private TableColumn<Candidat, String> phoneNumber;

    @FXML
    private TableColumn<Candidat, String> email;

    @FXML
    private TableColumn<Candidat, String> cv_url;

    public ObservableList<Candidat> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Candidat, Void> gere;

    CandidatRepository cand = CandidatRepository.GetInstance();

    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        try {
            String req = "SELECT id, fullName,phoneNumber,email,cv_url FROM candidat";
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                //  ArrayList<Candidat> list = cand.GetAll();
                //  System.out.println("kjnn" + list);
                //   for (Candidat candidat : list) {
                //      data.add(new Candidat(candidat.getId(), candidat.getFullName(), candidat.getPhoneNumber(), candidat.getEmail(), candidat.getCv_url()));
                //  }
                data.add(new Candidat(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        fullName.setCellValueFactory(new PropertyValueFactory<Candidat, String>("fullName"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Candidat, String>("phoneNumber"));
        email.setCellValueFactory(new PropertyValueFactory<Candidat, String>("email"));
        cv_url.setCellValueFactory(new PropertyValueFactory<Candidat, String>("cv_url"));
        table.setItems(data);
        addButtonToTable();
    }

    private void addButtonToTable() {
        gere.setCellValueFactory(new PropertyValueFactory<>("Gere Candidat"));

        Callback<TableColumn<Candidat, Void>, TableCell<Candidat, Void>> cellFactory = new Callback<TableColumn<Candidat, Void>, TableCell<Candidat, Void>>() {
            @Override
            public TableCell<Candidat, Void> call(final TableColumn<Candidat, Void> param) {
                final TableCell<Candidat, Void> cell = new TableCell<Candidat, Void>() {
                    final HBox hbox = new HBox();

                    Button btn1 = new Button("Gérer");

                    {
                        btn1.setStyle("-fx-text-fill: #21848B");

                        btn1.setOnAction((ActionEvent event) -> {
                            Candidat candidat = getTableView().getItems().get(getIndex());
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Date.fxml"));
                            try {
                                Scene scene = new Scene(loader.load());
                                DateController controller = loader.getController();
                                controller.setId(candidat.getId());
                                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                stage.setTitle("gérer le candidat " + candidat.getFullName());
                                stage.setScene(scene);
                                stage.show();
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }

                        });

                        hbox.getChildren().addAll(btn1);
                        hbox.setSpacing(10);
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {

                            setGraphic(hbox);

                        }
                    }
                };
                return cell;
            }
        };

        gere.setCellFactory(cellFactory);
        table.setItems(data);

    }
}
