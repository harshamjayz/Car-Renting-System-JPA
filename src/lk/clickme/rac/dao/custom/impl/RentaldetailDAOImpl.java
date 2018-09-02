/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import lk.clickme.rac.dao.CrudDAOImpl;
import lk.clickme.rac.dao.custom.RentaldetailDAO;
import lk.clickme.rac.entity.RentalDetail;
import lk.clickme.rac.entity.RentalDetail_PK;

/**
 *
 * @author Harsha madushan
 */
public class RentaldetailDAOImpl extends CrudDAOImpl<RentalDetail,Integer> implements RentaldetailDAO{

//    @Override
//    public boolean save(Rentaldetail entity) throws Exception {
//        return CrudUtil.executeUpdate("Insert into rentaldetail(customerID,vehicleID,rentalState,rentFrom,rentTo) Values(?,?,?,?,?)", entity.getCustomerID(),entity.getVehicleID(),entity.getRentalState(),entity.getRentFrom(),entity.getRentTo());
//    }
//
//    @Override
//    public boolean delete(Integer id) throws Exception {
//        return CrudUtil.executeUpdate("delete from rentaldetail where RentalID = ?", id);
//    }
//
//    @Override
//    public boolean update(Rentaldetail entity) throws Exception {
//        return CrudUtil.executeUpdate("Update rentaldetail set customerID = ?, vehicleID = ?, rentalState = ?, rentFrom = ?, rentTo = ? where RentalID = ?  ", entity.getCustomerID(),entity.getVehicleID(), entity.getRentalState(),entity.getRentFrom(),entity.getRentTo(),entity.getRentalID());
//    }
//
//    @Override
//    public Rentaldetail findByID(Integer id) throws Exception {
//        ResultSet rs = CrudUtil.executeQuery("select * from rentaldetail where RentalID = ?", id);
//        Rentaldetail rentaldetail = new Rentaldetail(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4) , rs.getDate(5),rs.getDate(6));
//        return rentaldetail;
//    }
//
//    @Override
//    public ArrayList<Rentaldetail> getAll() throws Exception {
//        ResultSet rs = CrudUtil.executeQuery("select * from rentaldetail");
//        ArrayList<Rentaldetail> rentaldetails = new ArrayList<>();
//        while(rs.next()){
//            Rentaldetail rentaldetail = new Rentaldetail(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4), rs.getDate(5),rs.getDate(6));
//            rentaldetails.add(rentaldetail);
//        }
//        return rentaldetails;
//    }
    
}
