/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.business;

import lk.clickme.rac.business.custom.impl.CustomerBOImpl;
import lk.clickme.rac.business.custom.impl.PaymentBOImpl;
import lk.clickme.rac.business.custom.impl.RentaldetailBOImpl;
import lk.clickme.rac.business.custom.impl.VehicleBOImpl;

/**
 *
 * @author Harsha madushan
 */
public class BOFactory {
    private static BOFactory bOFactory;
    
    private BOFactory(){
    
    }
    
    public static BOFactory getInstance(){
        if(bOFactory == null){
            bOFactory = new BOFactory();
        }
        
        return bOFactory;
    }
    
    public enum BOType{
        CustomerBO,VehicleBO,RentaldetailBO,PaymentBO
    }
    
    public SuperBO getBO(BOType boType){
        switch(boType){
            case CustomerBO :
                return new CustomerBOImpl();
            case VehicleBO:
                return new VehicleBOImpl();
            case RentaldetailBO:
                return new RentaldetailBOImpl();
            case PaymentBO:
                return new PaymentBOImpl();
            default:
                return null;
                
        }
        
    }
}
