package com.main;

import com.model.Address;
import com.model.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateInsertAddressMain {

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
        Address address=new Address("india","bh","sm",1232L);

        addAdddress(address);

    }

    private static void addAdddress(Address address) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnId = null;
        try {
            tx = session.beginTransaction();

             returnId = (Integer) session.save(address);

            tx.commit();
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("skill return id="+returnId);

    }



}
