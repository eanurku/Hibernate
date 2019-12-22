package com.annotationbased;

import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateAnnotationBasedDelete {

    static SessionFactory sfactory;

    static void setUp() {
        StandardServiceRegistry registry = null;

        try {

            registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            sfactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError("failed in creating session factory");
        }

    }

    public static void main(String[] args) {
        setUp();
        deleteEmployee(65);
    }

    private static void deleteEmployee(int empId) {

        Session session = sfactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Employee emp = session.get(Employee.class, empId);

            System.out.println("deleting employee id:" + empId);
            session.delete(emp);

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
