package com.mappingsortedmap;

import com.Certificate;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.SortedMap;
import java.util.TreeMap;

public class HibernateMappingSortedMapUpdate {
    static SessionFactory sfactory;

    public static void main(String[] args) {

        sfactory = new Configuration().configure().buildSessionFactory();

        SortedMap<String, Certificate> cert = new TreeMap<>();
        cert.put("CN",new Certificate("as1","agri"));
        cert.put("SA",new Certificate("as1","agri"));
        cert.put("IN",new Certificate("as1","agri"));
        updateEmployee(43,cert);

    }

    private static void updateEmployee(int empId,SortedMap<String,Certificate> certificates) {



        Session session = sfactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Employee emp = session.get(Employee.class, empId);
            SortedMap<String, Certificate> cert = emp.getCertificates();
            cert.putAll(certificates);
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
