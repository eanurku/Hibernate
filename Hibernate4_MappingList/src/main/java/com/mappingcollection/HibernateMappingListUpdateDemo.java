package com.mappingcollection;

import com.Certificate;
import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class HibernateMappingListUpdateDemo {

    static SessionFactory sfactory;
    public static void main(String[] args) {


        sfactory=new Configuration().configure().buildSessionFactory();

        List<Certificate> certificates1=new ArrayList<>();
        certificates1.add(new Certificate("cert3","tech"));
        certificates1.add(new Certificate("cert4","tech"));

        updateEmployee(24,certificates1);


    }

    private static void updateEmployee(int empId, List<Certificate> certificates1) {

        {

            Session session = sfactory.openSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();

                Employee emp = session.get(Employee.class, empId);

                List<Certificate> cert = emp.getCertificates();
                cert.addAll(certificates1);

                tx.commit();
            }catch(Exception e){

                if(tx!=null){
                    tx.rollback();
                }
            }finally{
                session.close();
            }

        }
    }
}
