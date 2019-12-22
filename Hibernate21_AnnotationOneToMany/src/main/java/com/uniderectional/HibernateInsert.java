package com.uniderectional;

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

        Set<Certificate> certs=new HashSet<Certificate>();
        Certificate cert1 = new Certificate();
        cert1.setCertificateName("sigma");
        cert1.setCertificateType("tech");

        Certificate cert2 = new Certificate();
        cert2.setCertificateName("java");
        cert2.setCertificateType("nontech");

        certs.add(cert1);
        certs.add(cert2);


        Employee employee=new Employee("first1","last1",new BigDecimal("1.1"),certs);

        addEmployee(employee);



    }


    private static void addEmployee(Employee employee) {

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
