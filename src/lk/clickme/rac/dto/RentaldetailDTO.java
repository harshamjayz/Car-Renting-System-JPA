/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.dto;

import java.util.Date;

/**
 *
 * @author Harsha madushan
 */
public class RentaldetailDTO {
    
    private int rentalID;
    private int customerID;
    private int vehicleID;
    private int rentalState;
    private Date rentFrom;
    private Date rentTo;

    public RentaldetailDTO() {
    }

    public RentaldetailDTO(int rentalID, int customerID, int vehicleID, int rentalState, Date rentFrom, Date rentTo) {
        this.rentalID = rentalID;
        this.customerID = customerID;
        this.vehicleID = vehicleID;
        this.rentalState = rentalState;
        this.rentFrom = rentFrom;
        this.rentTo = rentTo;
    }

    /**
     * @return the rentalID
     */
    public int getRentalID() {
        return rentalID;
    }

    /**
     * @param rentalID the rentalID to set
     */
    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
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
    public int getRentalState() {
        return rentalState;
    }

    /**
     * @param rentalState the rentalState to set
     */
    public void setRentalState(int rentalState) {
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
