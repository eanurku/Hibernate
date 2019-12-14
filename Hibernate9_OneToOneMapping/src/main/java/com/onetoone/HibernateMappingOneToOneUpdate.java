package com.onetoone;

import com.Address;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateMappingOneToOneUpdate {
    static SessionFactory sfactory;
    public static void main(String[] args) {

        sfactory = new Configuration().configure().buildSessionFactory();

        updateEmployee(55,4);

    }

    private static void updateEmployee(int empId,int addId) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnId = null;
        try {
            tx = session.beginTransaction();


            Address add = session.get(Address.class, addId);

            Employee emp = session.get(Employee.class, empId);

            emp.setAddress(add);
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
