/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.view.util.tblmodel;

/**
 *
 * @author Harsha madushan
 */
public class CustomerTM {
    private int cID;
    private String nIC;
    private String name;
    private String telNO;
    private String address;

    public CustomerTM() {
    }

    public CustomerTM(int cID, String nIC, String name, String telNO, String address) {
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
    

    

    
    
}
