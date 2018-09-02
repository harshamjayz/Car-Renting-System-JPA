package lk.clickme.rac.dao;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class CrudDAOImpl<T,Id> implements CrudDAO<T,Id>{

    protected EntityManager entityManager;
    private Class<T> entity;

    public CrudDAOImpl(){
        entity = (Class<T>)(((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    public void setEntityManager(EntityManager entityManager){

        this.entityManager= entityManager;
    }

    @Override
    public void save(T entity) throws Exception {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Id id) throws Exception {
        T t = entityManager.find(entity,id);
        entityManager.remove(t);

    }

    @Override
    public void update(T entity) throws Exception {
        entityManager.persist(entity);
    }

    @Override
    public T findByID(Id id) throws Exception {
        return entityManager.find(entity,id);
    }

    @Override
    public List<T> getAll() throws Exception {
        return entityManager.createQuery("FROM "+ entity.getName()).getResultList();
    }
}
