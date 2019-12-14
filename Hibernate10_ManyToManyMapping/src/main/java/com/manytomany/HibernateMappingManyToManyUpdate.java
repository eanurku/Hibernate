package com.manytomany;

import com.Certificate;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class HibernateMappingManyToManyUpdate {
    static SessionFactory sfactory;
    public static void main(String[] args) {

        sfactory = new Configuration().configure().buildSessionFactory();

        Set<Certificate> certs=new HashSet<>();
        certs.add(new Certificate("certxx","java"));
        certs.add(new Certificate("certyy","polity"));
        updateEmployee(60,certs);

    }

    private static void updateEmployee(int empId,Set<Certificate> certs) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnId = null;
        try {
            tx = session.beginTransaction();


            Employee emp = session.get(Employee.class, empId);
            Set<Certificate> cert = emp.getCertificates();
            emp.setCertificates(certs);


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
