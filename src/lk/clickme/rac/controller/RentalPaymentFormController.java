/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
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
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.ContinueNode;
import lk.clickme.rac.business.BOFactory;
import lk.clickme.rac.business.custom.CustomerBO;
import lk.clickme.rac.business.custom.PaymentBO;
import lk.clickme.rac.business.custom.RentalDetailBO;
import lk.clickme.rac.business.custom.VehicleBO;
import lk.clickme.rac.dto.CustomerDTO;
import lk.clickme.rac.dto.PaymentDTO;
import lk.clickme.rac.dto.RentaldetailDTO;
import lk.clickme.rac.dto.VehicleDTO;
import lk.clickme.rac.main.Rent_a_car;
import lk.clickme.rac.view.util.tblmodel.RentaldetailTM;
import sun.nio.cs.ext.Big5;

/**
 * FXML Controller class
 *
 * @author Harsha madushan
 */
public class RentalPaymentFormController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private TableView<RentaldetailTM> tblRentalPayment;
    @FXML
    private JFXTextField txtCustomerID;
    @FXML
    private JFXTextField txtPaneltyFee;
    @FXML
    private JFXTextField txtAmount;
    
    private String state;
    
    
    
    @FXML
    private JFXTextField txtCustomerName;
    @FXML
    private JFXComboBox<String> cmdPayaMethod;
    
    RentalDetailBO rentaldetailBo;
    CustomerBO customerBO;
    VehicleBO vehicleBO;
    PaymentBO paymentBO;
    

    public RentalPaymentFormController() {
        this.paymentBO = (PaymentBO)BOFactory.getInstance().getBO(BOFactory.BOType.PaymentBO);
        this.vehicleBO = (VehicleBO)BOFactory.getInstance().getBO(BOFactory.BOType.VehicleBO);
        this.customerBO = (CustomerBO)BOFactory.getInstance().getBO(BOFactory.BOType.CustomerBO);
        this.rentaldetailBo = (RentalDetailBO)BOFactory.getInstance().getBO(BOFactory.BOType.RentaldetailBO);
    }
    
    private void loadTable(){
        ArrayList<RentaldetailTM> rentaldetailTM = new ArrayList<>();
        ArrayList<RentaldetailDTO> rentalDTOs = null ;
        try {
            rentalDTOs = rentaldetailBo.getAllRentaldetail();
        } catch (Exception ex) {
            Logger.getLogger(RentalPaymentFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(rentalDTOs == null){
            return;
        }
        for (RentaldetailDTO rentalDTO : rentalDTOs) {
            if(rentalDTO.getRentalState() ==1){
                state = "continue" ;
            }else{
                state = "Finished" ;
            }
            RentaldetailTM rentalTM = new RentaldetailTM(rentalDTO.getRentalID(), rentalDTO.getCustomerID(), rentalDTO.getVehicleID(), state, rentalDTO.getRentFrom(), rentalDTO.getRentTo());
            rentaldetailTM.add(rentalTM);
        }
        
        
        tblRentalPayment.setItems(FXCollections.observableArrayList(rentaldetailTM));
        
    }
    
    
    private void loadComboBox(){
        
        ArrayList<String> methods = new ArrayList<>();
        methods.add("Cash");
        methods.add("Check");
        methods.add("Credit Card");
        
        cmdPayaMethod.setItems(FXCollections.observableArrayList(methods));
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tblRentalPayment.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("RentalID"));
        tblRentalPayment.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customerID"));
        tblRentalPayment.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        tblRentalPayment.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("rentFrom"));
        tblRentalPayment.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("rentTo"));
        tblRentalPayment.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("rentalState"));
        /*tblRentalPayment.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("PaneltyAmount"));
        tblRentalPayment.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("rentAmount")); */
        
        loadTable();
        loadComboBox();
    }  
    
     @FXML
    private void tblRowSelected(MouseEvent event) {
        
        BigDecimal amount = new BigDecimal(0);
        BigDecimal panelty  = new BigDecimal(0);
        
        try {
            RentaldetailTM rentaldetail = tblRentalPayment.getSelectionModel().getSelectedItem();
            int id = rentaldetail.getCustomerID();
            CustomerDTO customerDTO = customerBO.findByID(id);
            txtCustomerID.setText(customerDTO.getcID()+"");
            txtCustomerName.setText(customerDTO.getName());
            
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fromDate = format.parse(rentaldetail.getRentFrom().toString());
            Date toDate = format.parse(rentaldetail.getRentTo().toString());
            
            
            
            Long diff = toDate.getTime() - fromDate.getTime();
            
            Long diffDays = diff / (24*60*60*1000);
            
            BigDecimal days = new BigDecimal(diffDays.toString());    ////////////////////////////////////////////////
            
            
            VehicleDTO vehicleDTO = vehicleBO.findByID(rentaldetail.getVehicleID());
            System.out.println(vehicleDTO);
            BigDecimal vehicleRate = vehicleDTO.getvRate();
            amount = vehicleRate.multiply(days);
            BigDecimal p = new BigDecimal(0);
            
            Date date = new Date();
          
            if(toDate.compareTo(date) == 0 || date.compareTo(toDate) > 0 ){
                p = new BigDecimal(5000);
                panelty = p;
                amount = amount.add(p);
                txtPaneltyFee.setText(panelty.toString());
                txtAmount.setText(amount.toString());
            }
            
            txtPaneltyFee.setText(panelty.toString());
            txtAmount.setText(amount.toString());
      
            
            } catch (Exception ex) {
            Logger.getLogger(RentalPaymentFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnBackClicked(ActionEvent event) {
        
        Rent_a_car.navigateToHome(root, (Stage)this.root.getScene().getWindow());
    }

    @FXML
    private void btnSearchClicked(ActionEvent event) {
        
    }

    @FXML
    private void btnFinishPaymentClicked(ActionEvent event) {
        
        RentaldetailTM rentaldetail = tblRentalPayment.getSelectionModel().getSelectedItem();
        int rentId = rentaldetail.getRentalID();
        int customerId = rentaldetail.getCustomerID();
        String method = cmdPayaMethod.getValue().toString();
        BigDecimal paneltyfee = new BigDecimal(txtPaneltyFee.getText());
        BigDecimal amount  = new BigDecimal(txtAmount.getText());

        PaymentDTO payment = new PaymentDTO(0, method, paneltyfee, amount, rentId);
        RentaldetailDTO rentaldetailDTO = new RentaldetailDTO(rentaldetail.getRentalID(), rentaldetail.getCustomerID(), rentaldetail.getVehicleID(), 0, rentaldetail.getRentFrom(), rentaldetail.getRentTo());
        Boolean result;
        try {
            result = paymentBO.FinishPayment(payment, rentaldetailDTO);
            if(result == true){
                new Alert(Alert.AlertType.INFORMATION, "Payment has been succesfully Finished...", ButtonType.OK).show();
                loadTable();
                txtCustomerID.setText("");
                txtCustomerName.setText("");
                txtPaneltyFee.setText("");
                txtAmount.setText("");
                cmdPayaMethod.setSelectionModel(null);
            }else{
                new Alert(Alert.AlertType.INFORMATION, "Payment hasn't finished.Something went wrong", ButtonType.OK).show();
            }
        } catch (Exception ex) {
            Logger.getLogger(RentalPaymentFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   

   
    
}
