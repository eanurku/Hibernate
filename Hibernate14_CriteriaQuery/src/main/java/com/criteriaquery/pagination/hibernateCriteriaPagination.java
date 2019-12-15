package com.criteriaquery.pagination;

import com.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class hibernateCriteriaPagination {
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

            Criteria criteria = session.createCriteria(Employee.class);
            criteria.setFirstResult(1);
            criteria.setMaxResults(3);

            List result = criteria.list();
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
