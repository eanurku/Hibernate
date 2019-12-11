package com.mappingcollection;

import com.Certificate;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;

public class HibernateMappingCollectionUpdate {
    static SessionFactory sfactory;
    public static void main(String[] args) {

        sfactory=new Configuration().configure().buildSessionFactory();

        Collection<Certificate> collection = new ArrayList<>();
        collection.add(new Certificate("mycert1","personal"));
        collection.add(new Certificate("mycert2","personal"));

        updateEmployee(39,collection);
    }

    private static void updateEmployee(int empId, Collection<Certificate> certificates) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnid = null;
        try {
            tx = session.beginTransaction();
            Employee emp = session.get(Employee.class, empId);
            Collection<Certificate> cert = emp.getCertificates();
            cert.addAll(certificates);
            session.update(emp);
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
