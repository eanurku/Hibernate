package com.hql.update;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class hibernateUpdate {
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
        getEmployee();

    }

    private static void getEmployee() {

        Session session = sfactory.openSession();
        Transaction tx = null;
        try{
            tx=session.beginTransaction();

            Query query = session.createQuery("UPDATE Employee set salaryAmount=:salaryvalue where id=:employeeid");

            query.setParameter("salaryvalue",new BigDecimal("200"));
            query.setParameter("employeeid",70);

            int result = query.executeUpdate();
            System.out.println("result="+result);

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
