/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.dto;

/**
 *
 * @author Harsha madushan
 */
public class CustomerDTO {
    private int cID;
    private String nIC; 
    private String name;
    private String address;
    private String telNO;

    public CustomerDTO() {
    }

    public CustomerDTO(int cID, String nIC, String name, String address, String telNO) {
        this.cID = cID;
        this.nIC = nIC;
        this.name = name;
        this.address = address;
        this.telNO = telNO;
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
     * @return the nIC
     */
    public String getnIC() {
        return nIC;
    }

    /**
     * @param nIC the nIC to set
     */
    public void setnIC(String nIC) {
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

    @Override
    public String toString() {
        return "Customer{" + "cID=" + cID + ", nIC=" + nIC + ", name=" + name + ", address=" + address + ", telNO=" + telNO + '}';
    }
}
