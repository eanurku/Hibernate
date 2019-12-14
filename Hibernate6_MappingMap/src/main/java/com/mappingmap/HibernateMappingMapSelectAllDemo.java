package com.mappingmap;

import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class HibernateMappingMapSelectAllDemo {

    static SessionFactory sfactory;

    public static void main(String[] args) {

        sfactory = new Configuration().configure().buildSessionFactory();


        getAllEmployee();

    }

    private static void getAllEmployee() {

            Session session = sfactory.openSession();
            Transaction tx = null;
            Integer returnid = null;
            try {
                tx = session.beginTransaction();

                List<Employee> list = session.createQuery("From Employee").list();
                Iterator<Employee> iterator;

                for (iterator = list.iterator(); iterator.hasNext(); )
                    System.out.println(iterator.next());


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
