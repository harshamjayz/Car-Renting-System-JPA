/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.view.util.tblmodel;

import java.math.BigDecimal;

/**
 *
 * @author Harsha madushan
 */
public class VehicleTM {
    private int vID;
    private String vNO; 
    private String category;
    private String brand;
    private BigDecimal vRate;

    public VehicleTM() {
    }

    public VehicleTM(int vID, String vNO, String category, String brand, BigDecimal vRate) {
        this.vID = vID;
        this.vNO = vNO;
        this.category = category;
        this.brand = brand;
        this.vRate = vRate;
    }

    /**
     * @return the vID
     */
    public int getVID() {
        return vID;
    }

    /**
     * @param vID the vID to set
     */
    public void setVID(int vID) {
        this.vID = vID;
    }

    /**
     * @return the vNO
     */
    public String getVNO() {
        return vNO;
    }

    /**
     * @param vNO the vNO to set
     */
    public void setVNO(String vNO) {
        this.vNO = vNO;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the vRate
     */
    public BigDecimal getVRate() {
        return vRate;
    }

    /**
     * @param vRate the vRate to set
     */
    public void setVRate(BigDecimal vRate) {
        this.vRate = vRate;
    }
    
}
