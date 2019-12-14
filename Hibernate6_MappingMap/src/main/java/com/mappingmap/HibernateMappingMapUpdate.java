package com.mappingmap;

import com.Certificate;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashMap;
import java.util.Map;

public class HibernateMappingMapUpdate {
    static SessionFactory sfactory;

    public static void main(String[] args) {

        sfactory = new Configuration().configure().buildSessionFactory();

        HashMap<String, Certificate> cert = new HashMap<>();
        cert.put("AS",new Certificate("as1","agri"));
        updateEmployee(27,cert);

    }

    private static void updateEmployee(int empId,Map<String,Certificate> certificates) {



        Session session = sfactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Employee emp = session.get(Employee.class, empId);
            Map<String, Certificate> cert = emp.getCertificates();
            emp.setCertificates(certificates);
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
