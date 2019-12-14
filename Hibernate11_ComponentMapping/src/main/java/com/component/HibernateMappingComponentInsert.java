package com.component;

import com.Address;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class HibernateMappingComponentInsert {

    static SessionFactory sfactory;
    public static void main(String[] args) {

        sfactory = new Configuration().configure().buildSessionFactory();


        Address address = new Address("street1", "city1", "country1");
        Employee employee=new Employee("gonu2","kr",new BigDecimal("33.3"),address);
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
