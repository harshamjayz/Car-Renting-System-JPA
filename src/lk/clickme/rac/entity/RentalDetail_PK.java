/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.entity;

/**
 *
 * @author Harsha madushan
 */
public class RentalDetail_PK {
    private int customerID;
    private int vehicleID;

    public RentalDetail_PK() {
    }

    public RentalDetail_PK(int customerID, int vehicleID) {
        this.customerID = customerID;
        this.vehicleID = vehicleID;
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
    
}
