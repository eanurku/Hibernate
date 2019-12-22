package com.bidirectional;

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
        employee.setSalary(new BigDecimal("300"));

        Set<Certificate> certs=new HashSet<Certificate>();
        Certificate cert1 = new Certificate();
        cert1.setCertificateName("sigma");
        cert1.setCertificateType("tech");

        cert1.setEmployee(employee);


        addCertificate(cert1);



    }


    private static void addCertificate(Certificate cert) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnId=null;

        try {
            tx = session.beginTransaction();
            returnId= (Integer) session.save(cert);

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
