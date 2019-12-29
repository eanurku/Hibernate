package com.controller;

import com.factory.HibernateFactoryutil;
import com.model.Employee;
import com.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SimpleHibernateRestController {


    @Autowired
    HibernateFactoryutil factoryutil;

    @RequestMapping(value = "/test" ,method = RequestMethod.GET)
    public List<Employee> getStudents(){

        List<Employee> list=new ArrayList<>();
        list.add(new Employee("monu","l1",new BigDecimal("23")));
        list.add(new Employee("monu","l1",new BigDecimal("23")));

        return list;
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public ResponseEntity<Boolean> addEmployeeDetails(@RequestBody Employee employee) {

        System.out.println("employee details for creating record:" + employee);
        addEmployee(employee);

        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ResponseEntity<Integer> addStudentDetail(@RequestBody Student student) {

        System.out.println("student details for creating record:" + student);
        Integer returnId = addStudent(student);

        return new ResponseEntity<Integer>(returnId, HttpStatus.CREATED);
    }
    private  Integer addStudent(Student student) {

        Session session = factoryutil.getSfactory().openSession();
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

        return returnId;
    }

    private  void addEmployee(Employee emp) {

        Session session = factoryutil.getSfactory().openSession();
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
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("employee return id="+returnId);

    }

}
