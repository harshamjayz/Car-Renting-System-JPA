/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import lk.clickme.rac.dao.CrudDAOImpl;
import lk.clickme.rac.dao.custom.PaymentDAO;
import lk.clickme.rac.entity.Payment;

/**
 *
 * @author Harsha madushan
 */
public class PaymentDAOImpl extends CrudDAOImpl<Payment,Integer> implements PaymentDAO{

//    @Override
//    public boolean save(Payment entity) throws Exception {
//        return CrudUtil.executeUpdate("Insert into payment(cID,rentID,pMethod,paneltyFee,amount) Values(?,?,?,?,?)", entity.getcID(),entity.getRentID(),entity.getpMethod(),entity.getPaneltyFee(),entity.getAmount());
//    }
//
//    @Override
//    public boolean delete(Integer id) throws Exception {
//        return CrudUtil.executeUpdate("delete from payment where pID = ?", id);
//    }
//
//    @Override
//    public boolean update(Payment entity) throws Exception {
//        return CrudUtil.executeUpdate("Update payment set cID = ?,rentID, pMethod = ?, peneltyFee = ?, amount = ? where pID = ?" , entity.getcID(),entity.getRentID(),entity.getpMethod(), entity.getPaneltyFee(),entity.getAmount(),entity.getpID());
//    }
//
//    @Override
//    public Payment findByID(Integer id) throws Exception {
//        ResultSet rs = CrudUtil.executeQuery("select * from payment where pID = ?", id);
//        Payment payment = new Payment(rs.getInt(1),rs.getInt(2),rs.getInt(3) ,rs.getString(4), rs.getBigDecimal(5),rs.getBigDecimal(6));
//        return payment;
//    }
//
//    @Override
//    public ArrayList<Payment> getAll() throws Exception {
//        ResultSet rs = CrudUtil.executeQuery("select * from payment");
//        ArrayList<Payment> payments = new ArrayList<>();
//        while(rs.next()){
//            Payment payment = new Payment(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4), rs.getBigDecimal(5),rs.getBigDecimal(6));
//            payments.add(payment);
//        }
//        return payments;
//    }
    
}
