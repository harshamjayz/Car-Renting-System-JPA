/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.dao;

import lk.clickme.rac.dao.custom.impl.CustomerDAOImpl;
import lk.clickme.rac.dao.custom.impl.PaymentDAOImpl;
import lk.clickme.rac.dao.custom.impl.QueryDAOImpl;
import lk.clickme.rac.dao.custom.impl.RentaldetailDAOImpl;
import lk.clickme.rac.dao.custom.impl.VehicleDAOImpl;
/**
 *
 * @author Harsha madushan
 */
public class DAOFactory {
    private static DAOFactory dAOFactory;
    
    private DAOFactory(){
        
    }
    
    public static DAOFactory getInstance(){
        if(dAOFactory == null){
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }
    
    public enum DAOType{
        Customer,Payment,Rentaldetail,Vehicle,Query
    }
    
    public static SuperDAO getDAO(DAOType type){
        switch(type){
            case Customer:
                return new CustomerDAOImpl() ;
            case Payment:
                return new PaymentDAOImpl();
            case Rentaldetail:
                return new RentaldetailDAOImpl();
            case Vehicle:
                return new VehicleDAOImpl();
            case Query:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }
    

}
