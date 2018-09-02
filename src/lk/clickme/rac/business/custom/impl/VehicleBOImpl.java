/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.business.custom.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.clickme.rac.business.custom.VehicleBO;
import lk.clickme.rac.controller.RentCarFormController;
import lk.clickme.rac.dao.DAOFactory;
import static lk.clickme.rac.dao.DAOFactory.DAOType.Rentaldetail;
import lk.clickme.rac.dao.custom.RentaldetailDAO;
import lk.clickme.rac.dao.custom.VehicleDAO;
import lk.clickme.rac.dto.RentaldetailDTO;
import lk.clickme.rac.dto.VehicleDTO;
import lk.clickme.rac.entity.RentalDetail;
import lk.clickme.rac.entity.Vehicle;
import lk.clickme.rac.util.JPAUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Harsha madushan
 */
public class VehicleBOImpl implements VehicleBO{

    VehicleDAO vehicleDAO;
    RentaldetailDAO rentaldetailDAO;
    EntityManagerFactory entityManagerFactory;

    public VehicleBOImpl() {
        //this.rentaldetailDAO = (RentaldetailDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOType.Rentaldetail);
        this.vehicleDAO = (VehicleDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOType.Vehicle);
        entityManagerFactory = JPAUtil.getInstance().getEntityManagerFactory();
    }

    @Override
    public boolean saveVehicle(VehicleDTO vehicleDTO) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        vehicleDAO.setEntityManager(entityManager);
        Vehicle vehicle = new Vehicle(vehicleDTO.getvNO(),vehicleDTO.getCategory(),vehicleDTO.getBrand(),vehicleDTO.getvRate());
        vehicleDAO.save(vehicle);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;

//        Vehicle Evehicle = new Vehicle(vehicle.getvID(), vehicle.getvNO(), vehicle.getCategory(), vehicle.getBrand(), vehicle.getvRate());
//        return vehicleDAO.save(Evehicle);
    }

    @Override
    public boolean updateVehicle(VehicleDTO vehicleDTO) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        vehicleDAO.setEntityManager(entityManager);
            Vehicle vehicle = vehicleDAO.findByID(vehicleDTO.getvID());
            vehicle.setvNO(vehicleDTO.getvNO());
            vehicle.setCategory(vehicleDTO.getCategory());
            vehicle.setBrand(vehicleDTO.getBrand());
            vehicle.setvRate(vehicleDTO.getvRate());
            //vehicle = new Vehicle(vehicleDTO.getvNO(),vehicleDTO.getCategory(),vehicleDTO.getBrand(),vehicleDTO.getvRate());
            vehicleDAO.update(vehicle);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;

//        Vehicle Evehicle = new Vehicle(vehicle.getvID(), vehicle.getvNO(), vehicle.getCategory(), vehicle.getBrand(), vehicle.getvRate());
//        return vehicleDAO.update(Evehicle);
    }

    @Override
    public boolean deleteVehicle(int id) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
            vehicleDAO.setEntityManager(entityManager);
            vehicleDAO.delete(id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
//        return vehicleDAO.delete(id);
    }

    @Override
    public VehicleDTO findByID(int id) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        vehicleDAO.setEntityManager(entityManager);

        Vehicle vehicle = vehicleDAO.findByID(id);
        VehicleDTO vehicleDTO = new VehicleDTO(vehicle.getvID(),vehicle.getvNO(),vehicle.getCategory(),
                                      vehicle.getBrand(),vehicle.getvRate());
        entityManager.getTransaction().commit();
        entityManager.close();
        return vehicleDTO;


//        Vehicle eVehicle = vehicleDAO.findByID(id);
//        VehicleDTO vehicleDTO = new VehicleDTO(eVehicle.getvID(), eVehicle.getvNO(), eVehicle.getCategory(), eVehicle.getBrand(), eVehicle.getvRate());
//        return vehicleDTO;
    }

    @Override
    public ArrayList<VehicleDTO> getAllVehicle() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        vehicleDAO.setEntityManager(entityManager);
            List<Vehicle> allVehicles = vehicleDAO.getAll();
        entityManager.getTransaction().commit();
        entityManager.close();
            ArrayList<VehicleDTO> vehicleDTOS = new ArrayList<>();
            for (Vehicle vehicle : allVehicles) {
                VehicleDTO vehicleDTO = new VehicleDTO(vehicle.getvID(), vehicle.getvNO(), vehicle.getCategory(),
                        vehicle.getBrand(), vehicle.getvRate());
                vehicleDTOS.add(vehicleDTO);
            }
            return vehicleDTOS;

//        ArrayList<Vehicle> vehicles = vehicleDAO.getAll();
//        ArrayList<VehicleDTO> vehicleDTOs = new ArrayList<>();
//        for (Vehicle vehicle : vehicles) {
//            VehicleDTO vehicleDTO = new VehicleDTO(vehicle.getvID(), vehicle.getvNO(), vehicle.getCategory(), vehicle.getBrand(), vehicle.getvRate());
//            vehicleDTOs.add(vehicleDTO);
//        }
    }

    /*@Override
    public ArrayList<VehicleDTO> getAvailableVehicles() throws Exception{
       
            ArrayList<Rentaldetail> Rentals = rentaldetailDAO.getAll();
            ArrayList<Integer> rentedvehicleIDs = new ArrayList<>();
            for (Rentaldetail ERental : Rentals) {
                if(ERental.getRentalState() == "continue"){
                    int vehileNumber = ERental.getRentaldetail_PK().getVehicleID();
                    rentdvehicleIDs.add(vehileNumber);
                }
            }
            ArrayList<RentaldetailDAO> rentaldetailDAO = new ArrayList<>();
            ArrayList<VehicleDTO> vehiclesDTO = new ArrayList<>();
            ArrayList<Vehicle> allvehicles = vehicleDAO.getAll();
            for (Vehicle vehicleID : allvehicles) {
                
                VehicleDTO vehicleDTO = new VehicleDTO(vehicle.getvID(), vehicle.getvNO(), vehicle.getCategory(), vehicle.getBrand(), vehicle.getvRate());
                vehiclesDTO.add(vehicleDTO);
            }
            return vehiclesDTO;
       
    }*/
    
}
