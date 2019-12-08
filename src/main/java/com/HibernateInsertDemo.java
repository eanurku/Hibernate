package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;


public class HibernateInsertDemo {
    public static SessionFactory sfactoy;

    public static void main(String[] args) {
        System.out.println("hello to hibernate");


        sfactoy = new Configuration().configure().buildSessionFactory();

        Integer id = AddEmployee("anurag", "kumar", new BigDecimal("2100.34"));
        System.out.println("id="+id);


    }
    private static Integer AddEmployee(String fname, String lname, BigDecimal salary) {

        Session session = sfactoy.openSession();
        Transaction txn = null;
        Integer idval=-1;
        try {
            txn = session.beginTransaction();
            Employee emp = new Employee(fname, lname, salary);
              idval = (Integer) session.save(emp);
            txn.commit();

        } catch (Exception e) {
            if (txn != null)
                txn.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return idval;
    }
}
