package com.mappingsortedset;

import com.Certificate;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.SortedSet;
import java.util.TreeSet;

public class HibernateMappingSortedSetUpdate {
    static SessionFactory sfactory;
    public static void main(String[] args) {
        sfactory=new Configuration().configure().buildSessionFactory();


        SortedSet<Certificate> certificates=new TreeSet<>();
        certificates.add(new Certificate(null,"Java"));
        certificates.add(new Certificate(null,null));
        updateEmployee(36,certificates);

    }

    private static void updateEmployee(int empId, SortedSet<Certificate> certificates) {


        Session session = sfactory.openSession();
        Transaction tx = null;
        try{
            tx=session.beginTransaction();

            Employee emp = session.get(Employee.class, empId);

            SortedSet<Certificate> certs = emp.getCertificates();
            certs.addAll(certificates);

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
