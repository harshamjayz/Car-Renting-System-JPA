/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.controller;

import com.jfoenix.controls.JFXTextField;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
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
import lk.clickme.rac.business.custom.VehicleBO;
import lk.clickme.rac.dto.VehicleDTO;
import lk.clickme.rac.main.Rent_a_car;
import lk.clickme.rac.view.util.tblmodel.VehicleTM;

/**
 *
 * @author Harsha madushan
 */
public class AddVehicleFormController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtVNumber;
    @FXML
    private JFXTextField txtCategory;
    @FXML
    private JFXTextField txtBrand;
    @FXML
    private JFXTextField txtVRate;
    @FXML
    private TableView<VehicleTM> tblVehicle;
    
    private boolean decide = false;
    
    
    VehicleBO vehicleBO;

    public AddVehicleFormController() {
        this.vehicleBO = (VehicleBO)BOFactory.getInstance().getBO(BOFactory.BOType.VehicleBO);
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblVehicle.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("vID"));
        tblVehicle.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("vNO"));
        tblVehicle.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("category"));
        tblVehicle.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblVehicle.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("vRate"));
        LoadTable();
        
    }
    
    @FXML
    private void tblVehicleSelected(MouseEvent event) {
        VehicleTM TMVehicle =  tblVehicle.getSelectionModel().getSelectedItem();
        txtVNumber.setText(TMVehicle.getVNO());
        txtCategory.setText(TMVehicle.getCategory());
        txtBrand.setText(TMVehicle.getBrand());
        txtVRate.setText(TMVehicle.getVRate().toString());
    }

    @FXML
    private void btnBackClicked(ActionEvent event) {
        
        Rent_a_car.navigateToHome(root, (Stage)this.root.getScene().getWindow());
    }

    @FXML
    private void cacelVehicleClicked(ActionEvent event) {
        
        txtVNumber.setText("");
        txtCategory.setText("");
        txtBrand.setText("");
        txtVRate.setText("");
        if(tblVehicle.getSelectionModel().getSelectedIndex() >= 0){
            tblVehicle.getSelectionModel().clearSelection();
        }
        
    }

    @FXML
    private void addVehicleClicked(ActionEvent event) {
        
        if(decide == true){
            boolean result = saveVehicle();
            decide = false;
            if(result == true){
                new Alert(Alert.AlertType.INFORMATION, "Vehicle has been successfully saved.", ButtonType.OK).show();
                LoadTable();
            }else{
                new Alert(Alert.AlertType.INFORMATION, "Something went wrong please enter valid Vehicle number.", ButtonType.OK).show();
            }
        }else if(tblVehicle.getSelectionModel().getSelectedIndex() >= 0 && decide == false){
            boolean result = UpdateVehicle();
            if(result == true){
                new Alert(Alert.AlertType.INFORMATION, "Vehicle has been successfully Updated.", ButtonType.OK).show();
                LoadTable();
                tblVehicle.getSelectionModel().clearSelection();
            }else{
                new Alert(Alert.AlertType.INFORMATION, "Something went wrong please enter valid Vehicle number.", ButtonType.OK).show();
            }
        }else{
            new Alert(Alert.AlertType.INFORMATION, "Please press Add NEW VEHICLE button to add a Vehicle.", ButtonType.OK).show();
        }
       
        
    }

    @FXML
    private void removeVehicleClicked(ActionEvent event) {
        if(tblVehicle.getSelectionModel().getSelectedIndex()>=0){
            int vID = tblVehicle.getSelectionModel().getSelectedItem().getVID();
            try {
                boolean result = vehicleBO.deleteVehicle(vID);
                if(result == true){
                    txtVNumber.setText("");
                    txtCategory.setText("");
                    txtBrand.setText("");
                    txtVRate.setText("");
                    new Alert(Alert.AlertType.INFORMATION, "Vehicle has been successfully deleted.", ButtonType.OK).show();
                    LoadTable();
                }else{
                    new Alert(Alert.AlertType.INFORMATION, "Something went Wrong.", ButtonType.OK).show();
                }
            } catch (Exception ex) {
                Logger.getLogger(AddUserFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void addNewBtn(ActionEvent event) {
        tblVehicle.getSelectionModel().clearSelection();
        txtVNumber.setText("");
        txtCategory.setText("");
        txtBrand.setText("");
        txtVRate.setText("");
        decide = true;
    }

    private boolean UpdateVehicle(){
        VehicleTM vehicleTM = tblVehicle.getSelectionModel().getSelectedItem();
        
        int vID = vehicleTM.getVID();
        String vNumber = txtVNumber.getText();
        String category = txtCategory.getText();
        String brand = txtBrand.getText();
        BigDecimal vRate =new BigDecimal(txtVRate.getText()) ;
        
        VehicleDTO DTOvehicle = new VehicleDTO(vID, vNumber, category, brand, vRate);
        boolean result = false;
        try {
             result = vehicleBO.updateVehicle(DTOvehicle);
        } catch (Exception ex) {
            Logger.getLogger(AddVehicleFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    private Boolean saveVehicle(){
        String vNumber = txtVNumber.getText();
        String category = txtCategory.getText();
        String brand = txtBrand.getText();
        BigDecimal vRate =new BigDecimal(txtVRate.getText()) ;
        
        VehicleDTO DTOvehicle = new VehicleDTO(0, vNumber, category, brand, vRate);
        boolean result = false;
        try {
             result = vehicleBO.saveVehicle(DTOvehicle);
        } catch (Exception ex) {
            Logger.getLogger(AddVehicleFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    
    
}
