package com.mappingcollection;

import com.Certificate;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HibernateMappingListInsertDemo {

    static SessionFactory sfactory;
    public static void main(String[] args) {


        sfactory=new Configuration().configure().buildSessionFactory();

        List<Certificate> certificates1=new ArrayList<>();
        certificates1.add(new Certificate("cert1","tech"));
        certificates1.add(new Certificate("cert2","tech"));

        addEmployee("gonu","kr",new BigDecimal("22.22"),certificates1);

    }

    private static void addEmployee(String fname, String lname, BigDecimal salary, List<Certificate> certificates) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnid=null;
        try {
            tx = session.beginTransaction();

            Employee emp=new Employee(fname,lname,salary,certificates);
           returnid= (Integer) session.save(emp);
            tx.commit();
        }catch(Exception e){

            if(tx!=null){
                tx.rollback();
            }
        }finally{
            session.close();
        }


        System.out.println("return id="+returnid);
    }
}
