package com.mappingsortedset;

import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class HibernateMappingSetSelectAllDemo {
    static SessionFactory sessionFactory;
    public static void main(String[] args) {

        sessionFactory=new Configuration().configure().buildSessionFactory();
        getAllEmployee();
    }

    private static void getAllEmployee() {

        Session session = sessionFactory.openSession();
        Transaction tx=null;
        try {
            tx = session.beginTransaction();

            Query<Employee> query = session.createQuery("From Employee");
            List<Employee> emp = query.list();

            Iterator<Employee> it;
            for(it=emp.iterator();it.hasNext();){
                System.out.println(it.next());

            }

            tx.commit();
        }catch(Exception e){
            if(tx!=null)
                tx.rollback();

            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
}
