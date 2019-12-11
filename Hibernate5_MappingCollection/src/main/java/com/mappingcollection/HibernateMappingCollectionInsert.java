package com.mappingcollection;

import com.Certificate;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HibernateMappingCollectionInsert {
    static SessionFactory sfactory;
    public static void main(String[] args) {

        sfactory=new Configuration().configure().buildSessionFactory();

        Collection<Certificate> collection = new ArrayList<>();
        collection.add(new Certificate("mycert3","personal"));
        collection.add(new Certificate("mycert4","personal"));

        addEmployee("gonu","kr",new BigDecimal("30.3"),collection);

    }

    private static void addEmployee(String fname, String lname, BigDecimal salary, Collection<Certificate> collection) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnid = null;
        try {
            tx = session.beginTransaction();

            Employee emp=new Employee(fname,lname,salary,collection);
            returnid= (Integer) session.save(emp);

            tx.commit();
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        System.out.println("return id="+returnid);
    }
}
