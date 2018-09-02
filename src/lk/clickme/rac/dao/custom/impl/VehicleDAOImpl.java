/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import lk.clickme.rac.dao.CrudDAOImpl;
import lk.clickme.rac.entity.Vehicle;
import lk.clickme.rac.dao.custom.VehicleDAO;

/**
 *
 * @author Harsha madushan
 */
public class VehicleDAOImpl extends CrudDAOImpl<Vehicle,Integer> implements VehicleDAO{

//    @Override
//    public boolean save(Vehicle entity) throws Exception {
//        return CrudUtil.executeUpdate("Insert into vehicle(vNO,category,brand,vRate) Values(?,?,?,?)", entity.getvNO(),entity.getCategory(),entity.getBrand(),entity.getvRate());
//    }
//
//    @Override
//    public boolean delete(Integer id) throws Exception {
//        return CrudUtil.executeUpdate("delete from vehicle where vID = ?", id);
//    }
//
//    @Override
//    public boolean update(Vehicle entity) throws Exception {
//        return CrudUtil.executeUpdate("Update vehicle set vNO = ?, category = ?, brand = ?, vRate = ? where vID = ?", entity.getvNO(),entity.getCategory(),entity.getBrand(),entity.getvRate(),entity.getvID());
//    }
//
//    @Override
//    public Vehicle findByID(Integer id) throws Exception {
//        ResultSet rs = CrudUtil.executeQuery("select * from vehicle where vID = ?", id);
//        rs.next();
//        Vehicle vehicle= new Vehicle(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getBigDecimal(5));
//        return vehicle;
//    }
//
//    @Override
//    public ArrayList<Vehicle> getAll() throws Exception {
//        ResultSet rs = CrudUtil.executeQuery("select * from vehicle");
//        ArrayList<Vehicle> vehicles = new ArrayList<>();
//        while(rs.next()){
//            Vehicle vehicle = new Vehicle(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getBigDecimal(5));
//            vehicles.add(vehicle);
//        }
//        return vehicles;
//    }
    
}
