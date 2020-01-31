package com;

import com.dao.EmployeeDAO;
import com.daoimpl.EmployeeDAOHibernateImpl;
import com.model.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.math.BigDecimal;

public class HibernateInsertMain2 {

    static SessionFactory sfactory;
    static void  setUp(){
        StandardServiceRegistry registry = null;

        try{
            registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            sfactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

        }catch (Exception e){
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
            throw new ExceptionInInitializerError("failed in creating session factory");
        }

    }

    public static void main(String[] args) {




        setUp();
        Employee employee=new Employee("gonu4","kr",new BigDecimal("40.3"));
        EmployeeDAO empImpl=new EmployeeDAOHibernateImpl(sfactory);
        empImpl.saveEmployee(employee);
    }

}
