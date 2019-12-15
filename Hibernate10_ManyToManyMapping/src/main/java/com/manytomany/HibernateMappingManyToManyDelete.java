package com.manytomany;

import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateMappingManyToManyDelete {

    static SessionFactory sfactory;

    public static void main(String[] args) {
        sfactory = new Configuration().configure().buildSessionFactory();
        deleteEmployee(68);
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
