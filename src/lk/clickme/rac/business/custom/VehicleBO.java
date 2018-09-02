/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.business.custom;

import java.util.ArrayList;
import lk.clickme.rac.business.SuperBO;
import lk.clickme.rac.dto.VehicleDTO;

/**
 *
 * @author Harsha madushan
 */
public interface VehicleBO extends SuperBO{
    
    public boolean saveVehicle(VehicleDTO customer)throws Exception;
    
    public boolean updateVehicle(VehicleDTO customer)throws Exception;
    
    public boolean  deleteVehicle(int id)throws Exception;
    
    public VehicleDTO findByID(int id)throws Exception;
    
    public ArrayList<VehicleDTO> getAllVehicle()throws Exception;
    
   /* public ArrayList<VehicleDTO> getAvailableVehicles()throws Exception;*/
}
