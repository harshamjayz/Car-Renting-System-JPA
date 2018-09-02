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
public class VehicleDTO {
    private int vID;
    private String vNO;
    private String category;
    private String brand;
    private BigDecimal vRate;

    public VehicleDTO() {
    }

    public VehicleDTO(int vID, String vNO, String category, String brand, BigDecimal vRate) {
        this.vID = vID;
        this.vNO = vNO;
        this.category = category;
        this.brand = brand;
        this.vRate = vRate;
    }

    /**
     * @return the vID
     */
    public int getvID() {
        return vID;
    }

    /**
     * @param vID the vID to set
     */
    public void setvID(int vID) {
        this.vID = vID;
    }

    /**
     * @return the vNO
     */
    public String getvNO() {
        return vNO;
    }

    /**
     * @param vNO the vNO to set
     */
    public void setvNO(String vNO) {
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
    public BigDecimal getvRate() {
        return vRate;
    }

    /**
     * @param vRate the vRate to set
     */
    public void setvRate(BigDecimal vRate) {
        this.vRate = vRate;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "vID=" + vID + ", vNO=" + vNO + ", category=" + category + ", brand=" + brand + ", vRate=" + vRate + '}';
    }
}
