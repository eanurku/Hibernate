package com.mappingcollection;

import com.Certificate;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Collection;

public class HibernateMappingCollectionDelete {
    static SessionFactory sfactory;
    public static void main(String[] args) {

        sfactory=new Configuration().configure().buildSessionFactory();

        deleteEmployee(37);
    }

    private static void deleteEmployee(int empid) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnid = null;
        try {
            tx = session.beginTransaction();
            Employee emp=session.get(Employee.class,empid);
            System.out.println("deleting empid:"+emp.getId());
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
