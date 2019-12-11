package com.mappingsortedset;

import com.Certificate;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class HibernateMappingSetUpdateDemo {

    static SessionFactory sfactory;
    public static void main(String[] args) {

        sfactory=new Configuration().configure().buildSessionFactory();

        Set<Certificate> certificates=new HashSet<>();
        certificates.add(new Certificate("c4","nontech"));
        updateEmployee(11,certificates);

    }

    private static void updateEmployee(int empId, Set<Certificate> certificates) {


        Session session = sfactory.openSession();
        Transaction tx = null;
        try{
            tx=session.beginTransaction();

            Employee emp = session.get(Employee.class, empId);
            Set<Certificate> cert = emp.getCertificates();
            cert.clear();//TO DO: this is not deleting rows in certificate table but making foreign key as null.
            cert.addAll(certificates);

            session.update(emp);

            tx.commit();
        }catch(Exception e){
            if(tx!=null)
                tx.rollback();
        }finally{
            session.close();
        }


    }
}
