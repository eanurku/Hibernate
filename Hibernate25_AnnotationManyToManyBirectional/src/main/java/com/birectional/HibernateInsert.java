package com.birectional;

import com.Certificate;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class HibernateInsert {

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

        Certificate certificate = new Certificate();
        certificate.setCertificateName("newsigma");
        certificate.setCertificateType("tech");


        Set<Employee> employees=new HashSet<>();

        Employee employee1=new Employee();
        employee1.setFirstname("xyz");



        Employee employee2=new Employee();
        employee2.setFirstname("abc1");


        employees.add(employee1);
        employees.add(employee2);

        certificate.setEmployees(employees);
        addEmployee(certificate);



    }


    private static void addEmployee(Certificate certificate) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnId=null;

        try {
            tx = session.beginTransaction();
            returnId= (Integer) session.save(certificate);

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
