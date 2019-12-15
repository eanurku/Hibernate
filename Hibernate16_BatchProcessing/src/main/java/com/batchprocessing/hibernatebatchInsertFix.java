package com.batchprocessing;

import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.math.BigDecimal;

public class hibernatebatchInsertFix {
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
        addEmployees();
    }

    private static Integer addEmployees( ) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnId = null;
        try{
            tx=session.beginTransaction();

            for(int i=1;i<10;i++){
                Employee emp=new Employee("me","kumar",new BigDecimal("1200"));
                returnId= (Integer) session.save(emp);
                System.out.println(returnId);
                if(i%50 == 0){
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
