/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.clickme.rac.business.BOFactory;
import lk.clickme.rac.business.custom.RentalDetailBO;
import lk.clickme.rac.business.custom.VehicleBO;
import lk.clickme.rac.dto.RentaldetailDTO;
import lk.clickme.rac.dto.VehicleDTO;
import lk.clickme.rac.main.Rent_a_car;
import lk.clickme.rac.view.util.tblmodel.VehicleTM;

/**
 * FXML Controller class
 *
 * @author Harsha madushan
 */
public class RentCarFormController implements Initializable {

    @FXML
    private AnchorPane root;
    private JFXTextField txtVNumber;
    @FXML
    private JFXDatePicker txtRentDate;
    @FXML
    private JFXDatePicker txtRentEndDate;
    @FXML
    private TableView<VehicleTM> tblVehicle;
    @FXML
    private JFXTextField txtcID;
    
    RentalDetailBO rentalDetailBO;
    VehicleBO vehicleBO;
    @FXML
    private JFXTextField txtVehicleID;
    

    public RentCarFormController() {
        this.vehicleBO = (VehicleBO) BOFactory.getInstance().getBO(BOFactory.BOType.VehicleBO);
        this.rentalDetailBO = (RentalDetailBO) BOFactory.getInstance().getBO(BOFactory.BOType.RentaldetailBO);
    }
    
    
    
    private void LoadTable(){
        try {
            ArrayList<VehicleDTO> DAOVehicles = vehicleBO.getAllVehicle();
            ArrayList<VehicleTM> TMVehicles = new ArrayList<>();
            for (VehicleDTO DAOVehicle : DAOVehicles) {
                VehicleTM vehicleTM = new VehicleTM(DAOVehicle.getvID(), DAOVehicle.getvNO(), DAOVehicle.getCategory(), DAOVehicle.getBrand(), DAOVehicle.getvRate());
                TMVehicles.add(vehicleTM);
                
            }
            
            tblVehicle.setItems(FXCollections.observableArrayList(TMVehicles));
            
        } catch (Exception ex) {
            Logger.getLogger(AddVehicleFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       tblVehicle.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("vID"));
       tblVehicle.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("vNO"));
       tblVehicle.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("category"));
       tblVehicle.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("brand"));
       tblVehicle.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("vRate"));
       LoadTable();
    }    

    @FXML
    private void btnBackClicked(ActionEvent event) {
        
        Rent_a_car.navigateToHome(root, (Stage)this.root.getScene().getWindow());
    }

    @FXML
    private void cacelrentClicked(ActionEvent event) {
        if(tblVehicle.getSelectionModel().getSelectedIndex() >= 0){
            tblVehicle.getSelectionModel().clearSelection();
            txtcID.setText("");
            txtVehicleID.setText("");
            
        }
    }

    @FXML
    private void rentVehicleClicked(ActionEvent event) {
        String cID = txtcID.getText();
        String vID = txtVehicleID.getText();
        LocalDate stLocaldate = txtRentDate.getValue();
        Date startdate = Date.from(stLocaldate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        LocalDate endLocaldate = txtRentEndDate.getValue();
        Date enddate = Date.from(endLocaldate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        RentaldetailDTO detail = new RentaldetailDTO(0,Integer.parseInt(cID), Integer.parseInt(vID), 1, startdate, enddate);
        
        Boolean result = false;
        try {
            result = rentalDetailBO.saveRentaldetail(detail);
        } catch (Exception ex) {
            Logger.getLogger(RentCarFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result == true){
            new Alert(Alert.AlertType.INFORMATION, "you have successfully rented the vehicle.", ButtonType.OK).show();
            if(tblVehicle.getSelectionModel().getSelectedIndex() >= 0){
                 tblVehicle.getSelectionModel().clearSelection();
            }
            txtcID.setText("");
            txtVehicleID.setText("");
    
        }else{
            new Alert(Alert.AlertType.INFORMATION, "Something went wrong.", ButtonType.OK).show();
        }
        
    }

    @FXML
    private void tblVehicleClicked(MouseEvent event) {
        VehicleTM TMVehicle =  tblVehicle.getSelectionModel().getSelectedItem();
        txtVehicleID.setText(String.valueOf( TMVehicle.getVID() ));
        
    }
    
}
