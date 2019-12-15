package com.batchprocessing;

import com.Employee;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.math.BigDecimal;

public class hibernatebatchUpdate {
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
        updateEmployees();
    }

    private static Integer updateEmployees( ) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnId = null;
        int count=0;
        try{
            tx=session.beginTransaction();

            ScrollableResults cursor = session.createQuery("from Employee").scroll();
            while(cursor.next()){

                Employee employee = (Employee) cursor.get(0);
                employee.setSalaryAmount(new BigDecimal("10"));
                session.update(employee);
                count++;
                if(count%50==0){
                    session.flush();
                    session.clear();
                }


            }

            tx.commit();

        }catch(Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }

        return  returnId;
    }
}
