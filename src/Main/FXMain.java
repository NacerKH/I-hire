/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package Main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Dhiaeddsn
 */
public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("../GUI/StartPage.fxml"));
            primaryStage.setTitle("E-Hire Solution");
                primaryStage.setScene(new Scene(root,1280 , 720 ));
            primaryStage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
