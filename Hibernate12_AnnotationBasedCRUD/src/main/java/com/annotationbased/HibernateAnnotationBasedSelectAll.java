package com.annotationbased;

import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class HibernateAnnotationBasedSelectAll {

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
        getAllEmployee();

    }

    private static void getAllEmployee() {

            Session session = sfactory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();

                List<Employee> list = session.createQuery("From Employee").list();
                Iterator<Employee> iterator;

                for (iterator = list.iterator(); iterator.hasNext(); )
                    System.out.println(iterator.next());


                tx.commit();
            } catch (Exception e) {

                if (tx != null) {
                    tx.rollback();
                }
            } finally {
                session.close();
            }



    }
}
