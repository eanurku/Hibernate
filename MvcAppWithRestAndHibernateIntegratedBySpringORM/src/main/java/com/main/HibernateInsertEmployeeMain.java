package com.main;

import com.model.Employee;
import com.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.math.BigDecimal;

public class HibernateInsertEmployeeMain {

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

        addEmployee(employee);

    }

    private static void addEmployee(Employee emp) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnId = null;
        try {
            tx = session.beginTransaction();

             returnId = (Integer) session.save(emp);

            tx.commit();
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("employee return id="+returnId);

    }



}
