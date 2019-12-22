package com.onetoone;

import com.Address;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.math.BigDecimal;

public class HibernateMappingOneToOneInsert {

    static SessionFactory sfactory;
    public static void main(String[] args) {

        sfactory = new Configuration().configure().buildSessionFactory();

        Address address = new Address("street", "city1", "state1", "country2");
        Employee employee1=new Employee("gonu3","kr",new BigDecimal("33.3"),address);
        addEmployee(employee1);
        Employee employee2=new Employee("gonu3","kr",new BigDecimal("33.3"),address);
        addEmployee(employee2);

    }


    private static void addEmployee(Employee emp) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnId = null;
        try {
            tx = session.beginTransaction();

             returnId = (Integer) session.save(emp);

            tx.commit();
            System.out.println("employee return id="+returnId);
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }


    }

}
