/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.business.custom;

import java.util.ArrayList;
import lk.clickme.rac.business.SuperBO;
import lk.clickme.rac.dto.CustomerDTO;

/**
 *
 * @author Harsha madushan
 */
public interface CustomerBO extends SuperBO{
    
    public boolean saveCustomer(CustomerDTO customer)throws Exception;
    
    public boolean updateCustomer(CustomerDTO customer)throws Exception;
    
    public boolean  deleteCustomer(int id)throws Exception;
    
    public CustomerDTO findByID(int id)throws Exception;
    
    public ArrayList<CustomerDTO> getAllCustomer()throws Exception;
}
