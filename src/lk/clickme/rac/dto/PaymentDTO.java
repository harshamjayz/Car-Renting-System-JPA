/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.dto;

import java.math.BigDecimal;

/**
 *
 * @author Harsha madushan
 */
public class PaymentDTO {
    
    private int pID;
    private int rentID;
    private String pMethod;
    private BigDecimal paneltyFee;
    private BigDecimal amount;
    private int rentalID;

    public PaymentDTO() {
    }

    public PaymentDTO(int pID, String pMethod, BigDecimal paneltyFee, BigDecimal amount, int rentalID) {
        this.pID = pID;
        this.rentID = rentID;
        this.pMethod = pMethod;
        this.paneltyFee = paneltyFee;
        this.amount = amount;
        this.rentalID = rentalID;
    }

    /**
     * @return the pID
     */
    public int getpID() {
        return pID;
    }

    /**
     * @param pID the pID to set
     */
    public void setpID(int pID) {
        this.pID = pID;
    }

    /**
     * @return the rentID
     */
    public int getRentID() {
        return rentID;
    }

    /**
     * @param rentID the rentID to set
     */
    public void setRentID(int rentID) {
        this.rentID = rentID;
    }

    /**
     * @return the pMethod
     */
    public String getpMethod() {
        return pMethod;
    }

    /**
     * @param pMethod the pMethod to set
     */
    public void setpMethod(String pMethod) {
        this.pMethod = pMethod;
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
        return "PaymentDTO{" +
                "pID=" + pID +
                ", rentID=" + rentID +
                ", pMethod='" + pMethod + '\'' +
                ", paneltyFee=" + paneltyFee +
                ", amount=" + amount +
                '}';
    }

    public int getRentalID() {
        return rentalID;
    }

    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }
}
