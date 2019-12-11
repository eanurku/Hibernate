package com.crud.delete;

import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDeleteDemo {

    static SessionFactory sfactory;
    public static void main(String[] args) {

        sfactory=new Configuration().configure().buildSessionFactory();

        deleteEmployee(3);


    }

    private static void deleteEmployee(int id) {

        Session session = sfactory.openSession();
        Transaction tx=null;
        try {
            tx = session.beginTransaction();

            Employee emp = session.get(Employee.class, id);
            session.delete(emp);
            tx.commit();
        }catch(Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }
        finally{
            session.close();
        }

    }
}
