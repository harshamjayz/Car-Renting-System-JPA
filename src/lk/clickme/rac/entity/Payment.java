/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Harsha madushan
 */
@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "keep1")
    @TableGenerator(name = "keep1",table = "sequence",pkColumnName = "Table_name",pkColumnValue = "Payment",
                    valueColumnName = "Next_ID",initialValue = 0,allocationSize = 1)
    private int pID;
    private String pMethod;
    private BigDecimal paneltyFee;
    private BigDecimal amount;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
    @JoinColumn(name = "rentalID",referencedColumnName = "rentalID")
    private RentalDetail rentalDetail;

    public Payment() {
    }

    public Payment( String pMethod, BigDecimal paneltyFee, BigDecimal amount, RentalDetail rentalDetail) {
        this.pID = pID;
        this.pMethod = pMethod;
        this.paneltyFee = paneltyFee;
        this.amount = amount;
        this.rentalDetail = rentalDetail;
    }

    public Payment(int pID, String pMethod, BigDecimal paneltyFee, BigDecimal amount, RentalDetail rentalDetail) {
        this.pID = pID;
        this.pMethod = pMethod;
        this.paneltyFee = paneltyFee;
        this.amount = amount;
        this.rentalDetail = rentalDetail;
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
        return "Payment{" +
                "pID=" + pID +
                ", pMethod='" + pMethod + '\'' +
                ", paneltyFee=" + paneltyFee +
                ", amount=" + amount +
                '}';
    }


    public RentalDetail getRentalDetail() {
        return rentalDetail;
    }

    public void setRentalDetail(RentalDetail rentalDetail) {
        this.rentalDetail = rentalDetail;
    }
}
