package com.uniderectional;

import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.math.BigDecimal;

public class HibernateDelete {

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
        deleteEmployee(174);

    }

    private static void deleteEmployee(Integer empId) {

        Session session = sfactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee emp = session.get(Employee.class, empId);
            System.out.println("deleteing employee with id="+emp.getId());
            session.delete(emp);

            tx.commit();
        }catch(Exception e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

}
