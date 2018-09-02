/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.business.custom;

import java.util.ArrayList;
import lk.clickme.rac.business.SuperBO;
import lk.clickme.rac.dto.CustomerDTO;
import lk.clickme.rac.dto.PaymentDTO;
import lk.clickme.rac.dto.RentaldetailDTO;

/**
 *
 * @author Harsha madushan
 */
public interface RentalDetailBO extends SuperBO{
    
    public boolean saveRentaldetail(RentaldetailDTO customer)throws Exception;
    
    public boolean updateRentaldetail(RentaldetailDTO customer)throws Exception;
    
    public boolean  deleteRentaldetail(int id)throws Exception;
    
    public RentaldetailDTO findByID(int id)throws Exception;
    
    public ArrayList<RentaldetailDTO> getAllRentaldetail()throws Exception;
    
    
   /* public ArrayList<CustomerDTO> getAllFinalRentalDetails()throws Exception;*/
    
}
