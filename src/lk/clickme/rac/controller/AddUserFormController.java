/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.controller;

import com.jfoenix.controls.JFXTextField;
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
import lk.clickme.rac.business.custom.CustomerBO;
import lk.clickme.rac.dto.CustomerDTO;
import lk.clickme.rac.main.Rent_a_car;
import lk.clickme.rac.view.util.tblmodel.CustomerTM;

/**
 * FXML Controller class
 *
 * @author Harsha madushan
 */
public class AddUserFormController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private TableView<CustomerTM> tblCustomer;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtNIC;
    @FXML
    private JFXTextField txtTelNo;
    @FXML
    private JFXTextField txtAddress;
    
    private boolean decide = false;
    
    CustomerBO customerBO;
    

    public AddUserFormController() {
        this.customerBO = (CustomerBO)BOFactory.getInstance().getBO(BOFactory.BOType.CustomerBO);
    }
    
    
    
    private void LoadTable(){
        try {
            ArrayList<CustomerDTO> DTOCustomers = customerBO.getAllCustomer();
            ArrayList<CustomerTM> TMCustomers = new ArrayList<>();
            for (CustomerDTO DTOCustomer : DTOCustomers) {
                CustomerTM TMCustomer = new CustomerTM(DTOCustomer.getcID(), DTOCustomer.getnIC(), DTOCustomer.getName(), DTOCustomer.getTelNO(), DTOCustomer.getAddress());
                TMCustomers.add(TMCustomer);
                
            }
            tblCustomer.setItems(FXCollections.observableArrayList(TMCustomers));
            
            
        } catch (Exception ex) {
            Logger.getLogger(AddUserFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cID"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("nIC"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("telNO"));
        tblCustomer.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("address"));
        
        LoadTable();
    }  
    
    @FXML
    private void addNewBtn(ActionEvent event) {
        txtName.setText("");
        txtNIC.setText("");
        txtTelNo.setText("");
        txtAddress.setText("");
        decide = true;
        if(tblCustomer.getSelectionModel().getSelectedIndex() >=0){
            tblCustomer.getSelectionModel().clearSelection();
        }
    }

    @FXML
    private void tblCustomerSelected(MouseEvent event) {
        if(tblCustomer.getSelectionModel().getSelectedIndex() >=0){
            CustomerTM customer = tblCustomer.getSelectionModel().getSelectedItem(); 
            txtName.setText(customer.getName());
            txtNIC.setText(customer.getNIC());
            txtTelNo.setText(customer.getTelNO());
            txtAddress.setText(customer.getAddress());
            
        }
    }

    @FXML
    private void addCustomer(ActionEvent event) {
        
        if(decide == true){
            String NIC = txtNIC.getText();
            boolean check = NIC.matches("^\\d{9}[V|v]$");
        if(check == false){
            new Alert(Alert.AlertType.INFORMATION, "Enter a valid ID ", ButtonType.OK).show();
            txtNIC.requestFocus();
            return;
        }
            boolean result1 =  SaveCustomer();
            decide = false;
           if(result1 == true){
               new Alert(Alert.AlertType.INFORMATION, "Customer has been successfully saved.", ButtonType.OK).show();
               LoadTable();
           }else{
               new Alert(Alert.AlertType.INFORMATION, "Something went wrong please enter valid NIC.", ButtonType.OK).show();
           }
        }else if(tblCustomer.getSelectionModel().getSelectedIndex() >=0 && decide == false){
            boolean result2 =  UpdateCustomer();
           if(result2 == true){
               new Alert(Alert.AlertType.INFORMATION, "Customer has been successfully Updated.", ButtonType.OK).show();
               LoadTable();
               tblCustomer.getSelectionModel().clearSelection();
           }else{
               new Alert(Alert.AlertType.INFORMATION, "Something went wrong when updating please enter valid NIC.", ButtonType.OK).show();
           }
        }else{
            new Alert(Alert.AlertType.WARNING, "Please press the Add new Button to add Customer..", ButtonType.OK).show();
        }
       
    }

    @FXML
    private void cancelButton(ActionEvent event) {
        
        txtName.setText("");
        txtNIC.setText("");
        txtTelNo.setText("");
        txtAddress.setText("");
        if(tblCustomer.getSelectionModel().getSelectedIndex() >=0){
            tblCustomer.getSelectionModel().clearSelection();
        }
    }

    @FXML
    private void RemoveCustomer(ActionEvent event) {
        
        if(tblCustomer.getSelectionModel().getSelectedIndex()>=0){
            int cID = tblCustomer.getSelectionModel().getSelectedItem().getCID();
            try {
                boolean result = customerBO.deleteCustomer(cID);
                if(result == true){
                    txtName.setText("");
                    txtNIC.setText("");
                    txtTelNo.setText("");
                    txtAddress.setText("");
                    new Alert(Alert.AlertType.INFORMATION, "Customer has been successfully deleted.", ButtonType.OK).show();
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
    private void btnBackClicked(ActionEvent event) {
        
        Rent_a_car.navigateToHome(root, (Stage)this.root.getScene().getWindow());
        
    }

    private boolean UpdateCustomer(){
        CustomerTM customerTM = tblCustomer.getSelectionModel().getSelectedItem();
        int cID = customerTM.getCID();
        String name = txtName.getText();
        String NIC = txtNIC.getText();
        String telNo = txtTelNo.getText();
        String address = txtAddress.getText();
        
        CustomerDTO customer = new CustomerDTO(cID, NIC, name, address, telNo);
        boolean uresult = false;
        try {
            uresult =  customerBO.updateCustomer(customer);
        } catch (Exception ex) {
            Logger.getLogger(AddUserFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uresult;
    }
    
    private Boolean SaveCustomer(){
        String name = txtName.getText();
        String NIC = txtNIC.getText();
        boolean check = NIC.matches("^\\d{9}[V|v]$");
        if(check == false){
            new Alert(Alert.AlertType.INFORMATION, "Enter a valid ID ", ButtonType.OK).show();
            txtNIC.requestFocus();
            
        }
        
        String telNo = txtTelNo.getText();
        String address = txtAddress.getText();
        
        CustomerDTO customer = new CustomerDTO(0, NIC, name, address, telNo);
        boolean result = false;
        try {
            result =  customerBO.saveCustomer(customer);
        } catch (Exception ex) {
            Logger.getLogger(AddUserFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }  
    
}
