/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class CustomDTO {
    
    private int cID;
    private String customerName;
    private String vehicleNumber;
    private Date rentDate;
    private Date rentEndDate;
    private int rentState;
    private BigDecimal paneltyFee;
    private BigDecimal amount;

    public CustomDTO() {
    }

    public CustomDTO(int cID, String customerName, String vehicleNumber, Date rentDate, Date rentEndDate, int rentState, BigDecimal paneltyFee, BigDecimal amount) {
        this.cID = cID;
        this.customerName = customerName;
        this.vehicleNumber = vehicleNumber;
        this.rentDate = rentDate;
        this.rentEndDate = rentEndDate;
        this.rentState = rentState;
        this.paneltyFee = paneltyFee;
        this.amount = amount;
    }

    /**
     * @return the cID
     */
    public int getcID() {
        return cID;
    }

    /**
     * @param cID the cID to set
     */
    public void setcID(int cID) {
        this.cID = cID;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the vehicleNumber
     */
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    /**
     * @param vehicleNumber the vehicleNumber to set
     */
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    /**
     * @return the rentDate
     */
    public Date getRentDate() {
        return rentDate;
    }

    /**
     * @param rentDate the rentDate to set
     */
    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    /**
     * @return the rentEndDate
     */
    public Date getRentEndDate() {
        return rentEndDate;
    }

    /**
     * @param rentEndDate the rentEndDate to set
     */
    public void setRentEndDate(Date rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    /**
     * @return the rentState
     */
    public int getRentState() {
        return rentState;
    }

    /**
     * @param rentState the rentState to set
     */
    public void setRentState(int rentState) {
        this.rentState = rentState;
    }

    /**
     * @return the paneltyFee
     */
    public BigDecimal getPaneltyFee() {
        return paneltyFee;
    }

    /**
     * @param paneltyFee the paneltyFee to set
     */
    public void setPaneltyFee(BigDecimal paneltyFee) {
        this.paneltyFee = paneltyFee;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CustomDTO{" + "cID=" + cID + ", customerName=" + customerName + ", vehicleNumber=" + vehicleNumber + ", rentDate=" + rentDate + ", rentEndDate=" + rentEndDate + ", rentState=" + rentState + ", paneltyFee=" + paneltyFee + ", amount=" + amount + '}';
    }
    
    
}
