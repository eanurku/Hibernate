package com.mappingsortedset;

import com.Certificate;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.SortedSet;
import java.util.TreeSet;

public class HibernateMappingSortedSetInsertDemo {

    static SessionFactory sfactory;
    public static void main(String[] args) {

        sfactory=new Configuration().configure().buildSessionFactory();

        SortedSet<Certificate> certificateset1=new TreeSet<>();
        certificateset1.add(new Certificate("scjp","java"));
        certificateset1.add(new Certificate("stl","cpp"));
        certificateset1.add(new Certificate(null,"cpp"));


        addEmployee("monu","kr",new BigDecimal("12.1"),certificateset1);
    }

    private static void addEmployee(String fname, String lname, BigDecimal salary, SortedSet<Certificate> certificates) {

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
