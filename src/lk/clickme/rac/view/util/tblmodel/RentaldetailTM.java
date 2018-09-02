/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.view.util.tblmodel;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Harsha madushan
 */
public class RentaldetailTM {
    
    
    private int RentalID;
    private int customerID;
    private int vehicleID;
    private String rentalState;
    private Date rentFrom;
    private Date rentTo;

    public RentaldetailTM() {
    }

    public RentaldetailTM(int RentalID, int customerID, int vehicleID, String rentalState, Date rentFrom, Date rentTo) {
        this.RentalID = RentalID;
        this.customerID = customerID;
        this.vehicleID = vehicleID;
        this.rentalState = rentalState;
        this.rentFrom = rentFrom;
        this.rentTo = rentTo;
    }

    /**
     * @return the RentalID
     */
    public int getRentalID() {
        return RentalID;
    }

    /**
     * @param RentalID the RentalID to set
     */
    public void setRentalID(int RentalID) {
        this.RentalID = RentalID;
    }

    /**
     * @return the customerID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * @return the vehicleID
     */
    public int getVehicleID() {
        return vehicleID;
    }

    /**
     * @param vehicleID the vehicleID to set
     */
    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    /**
     * @return the rentalState
     */
    public String getRentalState() {
        return rentalState;
    }

    /**
     * @param rentalState the rentalState to set
     */
    public void setRentalState(String rentalState) {
        this.rentalState = rentalState;
    }

    /**
     * @return the rentFrom
     */
    public Date getRentFrom() {
        return rentFrom;
    }

    /**
     * @param rentFrom the rentFrom to set
     */
    public void setRentFrom(Date rentFrom) {
        this.rentFrom = rentFrom;
    }

    /**
     * @return the rentTo
     */
    public Date getRentTo() {
        return rentTo;
    }

    /**
     * @param rentTo the rentTo to set
     */
    public void setRentTo(Date rentTo) {
        this.rentTo = rentTo;
    }
    
    
    

   
    
    
}
