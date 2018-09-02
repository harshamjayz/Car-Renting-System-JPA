/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.business.custom;

import java.util.ArrayList;
import lk.clickme.rac.business.SuperBO;
import lk.clickme.rac.dto.PaymentDTO;
import lk.clickme.rac.dto.RentaldetailDTO;

/**
 *
 * @author Harsha madushan
 */
public interface PaymentBO extends SuperBO{
    
    public boolean savePayment(PaymentDTO customer)throws Exception;
    
    public boolean updatePayment(PaymentDTO customer)throws Exception;
    
    public boolean  deletePayment(int id)throws Exception;
    
    public PaymentDTO findByID(int id)throws Exception;
    
    public ArrayList<PaymentDTO> getAllPayment()throws Exception;
    
    public boolean FinishPayment(PaymentDTO payment,RentaldetailDTO rentaldetail)throws Exception;
}
