package com.controller;


import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SimpleRestController {

    static SessionFactory sfactory;

    @RequestMapping(value = "/test" ,method = RequestMethod.GET)
    public List<Employee> getStudents(){

        List<Employee> list=new ArrayList<>();
        list.add(new Employee("monu","l1",new BigDecimal("23")));
        list.add(new Employee("monu","l1",new BigDecimal("23")));

        return list;

    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public ResponseEntity<Boolean> updateMethod(@RequestBody Employee employee) {


        System.out.println("student details for creating record:" + employee);

        setUp();
        addEmployee(employee);

        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }

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

    private static void addEmployee(Employee emp) {

        Session session = sfactory.openSession();
        Transaction tx = null;
        Integer returnId = null;
        try {
            tx = session.beginTransaction();

            returnId = (Integer) session.save(emp);

            tx.commit();
        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        System.out.println("employee return id="+returnId);

    }

}
