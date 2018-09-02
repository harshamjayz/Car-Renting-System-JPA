/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Harsha madushan
 */
public class MainFormController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgAddCustomer;
    @FXML
    private ImageView imgAddVehicle;
    @FXML
    private ImageView imgRent;
    @FXML
    private ImageView imgReports;
    @FXML
    private ImageView imgFinishRent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }    

    @FXML
    private void navigateThrough(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            
            Parent root = null;
            
            switch(icon.getId()){
                case "imgAddCustomer":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/clickme/rac/view/AddUserForm.fxml"));
                    break;
                case "imgAddVehicle":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/clickme/rac/view/AddVehicleForm.fxml"));
                    break;
                case "imgRent":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/clickme/rac/view/RentCarForm.fxml"));
                    break;
                case "imgFinishRent":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/clickme/rac/view/RentalPaymentForm.fxml"));
                    break;
                case "imgReports":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/clickme/rac/view/RentDetailForm.fxml"));
                    break;
            }
            
            if (root != null){
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();
                
                
                TranslateTransition tt = new TranslateTransition(Duration.millis(200), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();
                
            }
        }
    }

    @FXML
    private void imgSettingsClicked(MouseEvent event) {
    }
    
}
