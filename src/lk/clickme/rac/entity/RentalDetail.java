/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.entity;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Harsha madushan
 */
@Entity
@Table(name = "RentalDetail")
public class RentalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "keep2")
    @TableGenerator(name="keep2",table = "sequence",pkColumnName = "Table_Name",pkColumnValue = "RentalDetail"
                    ,valueColumnName = "Next_ID",initialValue = 0,allocationSize = 1)
    private int rentalID;
    private int rentalState;
    @Temporal(TemporalType.DATE)
    private Date rentFrom;
    @Temporal(TemporalType.DATE)
    private Date rentTo;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cID",referencedColumnName = "cid" )
    private Customer customer;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vID",referencedColumnName = "vID")
    private Vehicle vehicle;
    @OneToOne(mappedBy = "rentalDetail",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Payment payment;

    public RentalDetail() {
    }

    public RentalDetail(int rentalState, Date rentFrom, Date rentTo,Customer customer,Vehicle vehicle) {


        this.rentalState = rentalState;
        this.rentFrom = rentFrom;
        this.rentTo = rentTo;
        this.setCustomer(customer);
        this.setVehicle(vehicle);
    }

    public RentalDetail(int rentalID, int rentalState, Date rentFrom, Date rentTo,Customer customer,Vehicle vehicle) {
        this.rentalID = rentalID;
        this.rentalState = rentalState;
        this.rentFrom = rentFrom;
        this.rentTo = rentTo;
        this.setCustomer(customer);
        this.setVehicle(vehicle);
        this.setPayment(payment);
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "RentalDetail{" +
                "rentalID=" + rentalID +
                ", rentalState=" + rentalState +
                ", rentFrom=" + rentFrom +
                ", rentTo=" + rentTo +
                ", customer=" + customer +
                ", vehicle=" + vehicle +
                ", payment=" + payment +
                '}';
    }
}
