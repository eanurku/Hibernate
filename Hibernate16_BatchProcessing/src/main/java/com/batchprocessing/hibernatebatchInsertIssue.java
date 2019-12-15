package com.batchprocessing;

import com.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;

import java.math.BigDecimal;
import java.util.List;

public class hibernatebatchInsertIssue {
    static SessionFactory sfactory;
    static void setUp(){

        StandardServiceRegistry registry = null;

        try {
            registry = new StandardServiceRegistryBuilder().configure().build();
            sfactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }catch (Exception e){
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError("error in creating session factory");
        }

    }
    public static void main(String[] args) {
        setUp();

        int val;
        addEmployees();

    }

    private static void addEmployees() {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnId=null;
        try{
            tx=session.beginTransaction();

            for(int i=1;i<10000000;i++){
                Employee emp=new Employee("me","kumar",new BigDecimal("1200"));
                session.save(emp);
            }


            tx.commit();

        }catch(Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }

    }
}
