package com.manytomany;

import com.Certificate;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class HibernateMappingManyToManyInsert {

    static SessionFactory sfactory;
    public static void main(String[] args) {

        sfactory = new Configuration().configure().buildSessionFactory();


        Set<Certificate> certs=new HashSet<>();
        certs.add(new Certificate("cert","java"));
        certs.add(new Certificate("cert","polity"));

        Employee employee=new Employee("gonu2","kr",new BigDecimal("33.3"),certs);
        addEmployee(employee);

    }

    private static void addEmployee(Employee emp) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnId = null;
        try {
            tx = session.beginTransaction();

             returnId = (Integer) session.save(emp);

            tx.commit();
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        System.out.println("employee return id="+returnId);

    }

}
