package lk.clickme.rac.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class JPAUtil {
    private static EntityManagerFactory  entityManagerFactory;
    private static JPAUtil jpaUtil;

    private  JPAUtil() {
        File file = new File("application.properties");
        FileReader propReader = null;
        try {
            propReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties jpaProperties = new Properties();
        try {
            jpaProperties.load(propReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        entityManagerFactory = Persistence.createEntityManagerFactory("hashboot1",jpaProperties);
    }

    public static JPAUtil getInstance(){
        if(jpaUtil == null){
            jpaUtil  = new JPAUtil();
        }
        return jpaUtil;
    }

    public  EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }
}
