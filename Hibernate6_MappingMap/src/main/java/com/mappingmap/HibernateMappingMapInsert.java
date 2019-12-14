package com.mappingmap;

import com.Certificate;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class HibernateMappingMapInsert {

    static SessionFactory sfactory;

    public static void main(String[] args) {

        sfactory = new Configuration().configure().buildSessionFactory();


        Map<String,Certificate> cert=new HashMap<>();
        cert.put("US",new Certificate("abc","ttt"));
        cert.put("IN",new Certificate("ggg","st"));
        cert.put("CN",new Certificate("eee","re"));
        addEmployee("monu","kr",new BigDecimal("22.2"),cert);

    }

    private static void addEmployee(String fname, String lname, BigDecimal salary, Map<String,Certificate> cert) {



            Session session = sfactory.openSession();
            Transaction tx = null;
            Integer returnid = null;
            try {
                tx = session.beginTransaction();
                Employee emp=new Employee(fname,lname,salary,cert);
                returnid= (Integer) session.save(emp);

                tx.commit();
            } catch (Exception e) {

                if (tx != null) {
                    tx.rollback();
                }
            } finally {
                session.close();
            }

        System.out.println("return id="+returnid);
        }


}
