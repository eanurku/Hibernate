package com.main;

import com.model.Address;
import com.model.Employee;
import com.model.Skill;
import com.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HibernateInsertStudentMain {

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

        Student student=new Student();
        student.setStudentContact(21L);
        student.setStudentName("anurag1");

        List<String> skills = new ArrayList<>();
        skills.add("sk11");
        skills.add("sk22");

        Address address=new Address("india","bh","sm",1232L);

        student.setStudentSkills(skills);
        student.setStudentAddress(address);
        addStudent(student);

    }


    private static Integer addStudent(Student student) {
        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnId = null;
        try {
            tx = session.beginTransaction();

            returnId = (Integer) session.save(student);

            tx.commit();
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("student return id="+returnId);

        return  returnId;

    }

}
