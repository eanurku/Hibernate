package com.bidirectional;

import com.Address;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.math.BigDecimal;

public class HibernateInsert1 {

    static SessionFactory sfactory;


    static void  setUp(){
        StandardServiceRegistry registry = null;

        try{
            registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            sfactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

        }catch (Exception e){
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
            throw new ExceptionInInitializerError("failed in creating session factory");
        }

    }


    public static void main(String[] args) {

        setUp();

        Employee employee=new Employee();
        employee.setFirstname("anurag");

        Address addr=new Address();
        addr.setStreet("firststreet");

        addr.setEmployee(employee);
        employee.setEmployeeAddress(addr);//this will make hibernate update emp_id in adress to respective employee
        addAddress(addr);

    }

    private static void addAddress(Address address) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnId=null;

        try {
            tx = session.beginTransaction();
            returnId= (Integer) session.save(address);

            tx.commit();
            System.out.println("return id="+returnId);
        }catch(Exception e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }
    private static void AddEmployee(Employee employee) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnId=null;

        try {
            tx = session.beginTransaction();
            returnId= (Integer) session.save(employee);

            tx.commit();
            System.out.println("return id="+returnId);
        }catch(Exception e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

}
