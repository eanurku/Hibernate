package com.uniderectional;

import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class HibernateSelectAll {

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
        getEmployee();

    }

    private static void getEmployee() {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnId=null;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Employee");
            List list = query.list();

            for(Object emp:list)
            System.out.println("list:"+emp);

            tx.commit();
            System.out.println("return id="+returnId);

        }catch(Exception e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

}
