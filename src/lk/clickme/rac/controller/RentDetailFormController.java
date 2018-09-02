/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.controller;

import com.jfoenix.controls.JFXDatePicker;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.clickme.rac.business.BOFactory;
import lk.clickme.rac.business.custom.CustomerBO;
import lk.clickme.rac.business.custom.RentalDetailBO;
import lk.clickme.rac.db.DBConnection;
import lk.clickme.rac.dto.RentaldetailDTO;
import lk.clickme.rac.main.Rent_a_car;
import lk.clickme.rac.view.util.tblmodel.RentaldetailTM;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Harsha madushan
 */
public class RentDetailFormController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private TableView<RentaldetailTM> tblRentDetail;
    
    private String state;
    
    CustomerBO customerBO;
    RentalDetailBO rentaldetailBo;
    @FXML
    private JFXDatePicker pickerFromDate;
    @FXML
    private JFXDatePicker pickerToDate;

    public RentDetailFormController() {
        this.rentaldetailBo = (RentalDetailBO)BOFactory.getInstance().getBO(BOFactory.BOType.RentaldetailBO);
        this.customerBO = (CustomerBO)BOFactory.getInstance().getBO(BOFactory.BOType.CustomerBO);
    }
    
    
    
    
    
    

    private void LoadTable(){
        
        ArrayList<RentaldetailTM> rentaldetailTM = new ArrayList<>();
        ArrayList<RentaldetailDTO> rentalDTOs = null ;
        try {
            rentalDTOs = rentaldetailBo.getAllRentaldetail();
        } catch (Exception ex) {
            Logger.getLogger(RentalPaymentFormController.class.getName()).log(Level.SEVERE, null, ex);
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
        
        
        tblRentDetail.setItems(FXCollections.observableArrayList(rentaldetailTM));
        
    }
    
    
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblRentDetail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("RentalID"));
        tblRentDetail.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customerID"));
        tblRentDetail.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        tblRentDetail.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("rentFrom"));
        tblRentDetail.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("rentTo"));
        tblRentDetail.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("rentalState"));
        LoadTable();
        
    }    

    @FXML
    private void btnBackClicked(ActionEvent event) {
        
        Rent_a_car.navigateToHome(root, (Stage)this.root.getScene().getWindow());
    }

    

    @FXML
    private void btnGenarateReport(ActionEvent event) {
//        String fromDate = pickerFromDate.getValue().toString();
//        String toDate = pickerToDate.getValue().toString();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date fDate = null;
//        Date tDate = null;
//        try {
//            fDate = format.parse(fromDate);
//            tDate = format.parse(toDate);
//        } catch (ParseException ex) {
//            Logger.getLogger(RentDetailFormController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        InputStream strm = getClass().getResourceAsStream("/lk/clickme/rac/jasper/Report.jasper");
//        HashMap map = new HashMap();
//        map.put("Fromdate", fDate);
//        map.put("Todate", tDate);
//        try {
//            JasperPrint fillreport = JasperFillManager.fillReport(strm, map, DBConnection.getInstance().getConnection());
//            JasperViewer.viewReport(fillreport,false);
//            JasperPrintManager.printReport(strm, true);
//        } catch (Exception ex) {
//            Logger.getLogger(RentDetailFormController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
}
