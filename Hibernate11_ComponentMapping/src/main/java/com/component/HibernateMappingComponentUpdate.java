package com.component;

import com.Address;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class HibernateMappingComponentUpdate {
    static SessionFactory sfactory;
    public static void main(String[] args) {

        sfactory = new Configuration().configure().buildSessionFactory();

        Address address = new Address("streetx", "cityx", "countryx");
        updateEmployee(64,address);

    }

    private static void updateEmployee(int empId,Address addr) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnId = null;
        try {
            tx = session.beginTransaction();

            Employee emp = session.get(Employee.class, empId);
            emp.setAddress(addr);
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
