package com.crud.select;

import com.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateSelectDemo {

    static SessionFactory sfactory;
    public static void main(String[] args) {

        sfactory=new Configuration().configure().buildSessionFactory();
        getEmployee(2);

    }

    private static void getEmployee(int id) {
        Session session = sfactory.openSession();
        Transaction tx=null;
        try {
            tx = session.beginTransaction();

            Employee emp = session.get(Employee.class, id);
            System.out.println(emp);

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
