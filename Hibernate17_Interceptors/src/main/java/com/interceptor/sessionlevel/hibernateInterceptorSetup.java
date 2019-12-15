package com.interceptor.sessionlevel;

import com.Employee;
import com.interceptor.MyInterceptor;
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

public class hibernateInterceptorSetup {
    static SessionFactory sfactory;

    static void setUp() {

        StandardServiceRegistry registry = null;

        try {
            registry = new StandardServiceRegistryBuilder().configure().build();
            sfactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError("error in creating session factory");
        }

    }

    public static void main(String[] args) {

        setUp();
        Employee emp = new Employee("me", "kumar", new BigDecimal("1200"));
        addEmployee(emp);


    }

    private static void addEmployee(Employee emp) {

        Session session = sfactory.withOptions().interceptor(new MyInterceptor()).openSession();
        Transaction tx = null;
        Integer returnId = null;
        try {
            tx = session.beginTransaction();

            returnId = (Integer) session.save(emp);
            emp.setSalaryAmount(new BigDecimal("12"));

            tx.commit();

        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {

            session.close();
        }
        System.out.println("return id=" + returnId);

    }
}
