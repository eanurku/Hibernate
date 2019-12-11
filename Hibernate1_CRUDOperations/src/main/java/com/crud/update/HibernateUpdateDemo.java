package com.crud.update;

import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;

public class HibernateUpdateDemo {

    static SessionFactory sfactory;

    public static void main(String[] args) {

        sfactory=new Configuration().configure().buildSessionFactory();

        updateEmployee(4,new BigDecimal("90"));


    }

    private static void updateEmployee(Integer id, BigDecimal salary) {

        Session session = sfactory.openSession();

        Transaction tx =null;
        try {
            tx = session.beginTransaction();

            Employee employee = session.get(Employee.class, id);
            employee.setSalary(salary);
            session.update(employee);

            tx.commit();
        }catch (Exception e){
            if(tx!=null)
                tx.rollback();
        }finally {
            session.close();
        }



    }
}
