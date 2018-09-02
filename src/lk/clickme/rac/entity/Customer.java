/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Harsha madushan
 */
@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "keep")
    @TableGenerator(name = "keep",table = "sequence",pkColumnName = "Table_name",pkColumnValue = "Customer",
                    valueColumnName = "Next_ID",initialValue = 0,allocationSize = 1)
    private int cID;
    private String nIC; 
    private String name;
    private String telNO;
    private String address;
    @OneToMany(mappedBy = "customer")
    private List<RentalDetail> rentalDetailList = new ArrayList<>();


    public Customer() {
    }

    public Customer( String nIC, String name, String telNO, String address) {
        this.nIC = nIC;
        this.name = name;
        this.telNO = telNO;
        this.address = address;
    }

    public Customer(int cID, String nIC, String name, String telNO, String address) {
        this.cID = cID;
        this.nIC = nIC;
        this.name = name;
        this.telNO = telNO;
        this.address = address;
    }

    /**
     * @return the cID
     */
    public int getCID() {
        return cID;
    }

    /**
     * @param cID the cID to set
     */
    public void setCID(int cID) {
        this.cID = cID;
    }

    /**
     * @return the nIC
     */
    public String getNIC() {
        return nIC;
    }

    /**
     * @param nIC the nIC to set
     */
    public void setNIC(String nIC) {
        this.nIC = nIC;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the telNO
     */
    public String getTelNO() {
        return telNO;
    }

    /**
     * @param telNO the telNO to set
     */
    public void setTelNO(String telNO) {
        this.telNO = telNO;
    }

    public void addRentalDetail(RentalDetail rentalDetail){
        rentalDetail.setCustomer(this);
        this.getRentalDetailList().add(rentalDetail);
    }

    public List<RentalDetail> getRentalDetailList() {
        return rentalDetailList;
    }

    public void setRentalDetailList(List<RentalDetail> rentalDetailList) {
        this.rentalDetailList = rentalDetailList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cID=" + cID +
                ", nIC='" + nIC + '\'' +
                ", name='" + name + '\'' +
                ", telNO='" + telNO + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
