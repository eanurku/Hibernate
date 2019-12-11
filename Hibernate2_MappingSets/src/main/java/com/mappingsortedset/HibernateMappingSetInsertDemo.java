package com.mappingsortedset;

import com.Certificate;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class HibernateMappingSetInsertDemo {

    static SessionFactory sfactory;
    public static void main(String[] args) {

        sfactory=new Configuration().configure().buildSessionFactory();

        Set<Certificate> certificateset1=new HashSet<>();
        certificateset1.add(new Certificate("scjp","java"));
        certificateset1.add(new Certificate("stl","cpp"));


        addEmployee("monu","kr",new BigDecimal("12.1"),certificateset1);


        Set<Certificate> certificateset2=new HashSet<>();
        certificateset2.add(new Certificate("functionprogg","lisp"));
        certificateset2.add(new Certificate("spring","java"));


        addEmployee("monu","kr",new BigDecimal("12.1"),certificateset2);



    }

    private static void addEmployee(String fname, String lname, BigDecimal salary, Set<Certificate> certificates) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnId=null;

        try{
            tx=session.beginTransaction();
            Employee emp=new Employee(fname,lname,salary,certificates);
             returnId= (Integer) session.save(emp);

            tx.commit();
        }catch(Exception e){

            if(tx!=null)
                tx.rollback();
        }finally{

            session.close();
        }

        System.out.println("return id="+returnId);


    }
}
