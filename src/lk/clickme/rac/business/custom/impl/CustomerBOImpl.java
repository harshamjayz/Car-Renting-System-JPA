/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.clickme.rac.business.custom.impl;

import java.util.ArrayList;
import java.util.List;

import lk.clickme.rac.business.custom.CustomerBO;
import lk.clickme.rac.dao.CrudDAO;
import lk.clickme.rac.dao.DAOFactory;
import lk.clickme.rac.dao.custom.CustomerDAO;
import lk.clickme.rac.dao.custom.impl.CustomerDAOImpl;
import lk.clickme.rac.dto.CustomerDTO;
import lk.clickme.rac.entity.Customer;
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
public class CustomerBOImpl implements CustomerBO{
    
    
    CustomerDAO customerDAO;
    EntityManagerFactory entityManagerFactory;

    public CustomerBOImpl() {
        this.customerDAO = (CustomerDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOType.Customer);
        entityManagerFactory = JPAUtil.getInstance().getEntityManagerFactory();
    }
    
    
    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws Exception {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        customerDAO.setEntityManager(entityManager);
        entityManager.getTransaction().begin();
        Customer customer = new Customer(customerDTO.getnIC(),customerDTO.getName(),customerDTO.getTelNO(),customerDTO.getAddress());
        customerDAO.save(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        customerDAO.setEntityManager(entityManager);
        entityManager.getTransaction().begin();
        Customer customer = customerDAO.findByID(customerDTO.getcID());
        customer.setNIC(customerDTO.getnIC());
        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setTelNO(customerDTO.getTelNO());
        //Customer customer = new Customer(customerDTO.getnIC(),customerDTO.getName(),customerDTO.getTelNO(),customerDTO.getAddress());
        customerDAO.update(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;

    }

    @Override
    public boolean deleteCustomer(int id) throws Exception {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        customerDAO.setEntityManager(entityManager);
        entityManager.getTransaction().begin();
        customerDAO.delete(id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public CustomerDTO findByID(int id) throws Exception {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        customerDAO.setEntityManager(entityManager);
        entityManager.getTransaction().begin();
        Customer customer = customerDAO.findByID(id);
        entityManager.getTransaction().commit();
        entityManager.close();
        CustomerDTO customerDTO = new CustomerDTO(customer.getCID(), customer.getNIC(), customer.getName(),
                customer.getAddress(), customer.getTelNO());
        return customerDTO;

    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws Exception {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        customerDAO.setEntityManager(entityManager);
        entityManager.getTransaction().begin();
        List<Customer> allCustomers = customerDAO.getAll();
        entityManager.getTransaction().commit();
        entityManager.close();
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : allCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(customer.getCID(), customer.getNIC(), customer.getName(),
                        customer.getAddress(), customer.getTelNO());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;

    }
    
}
