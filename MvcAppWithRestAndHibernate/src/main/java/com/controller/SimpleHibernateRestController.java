package com.controller;

import com.factory.HibernateFactoryutil;
import com.model.Employee;
import com.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Boolean> addEmployeeDetails1(@RequestBody Employee employee) {

        System.out.println("employee details for creating record:" + employee);
        addEmployee(employee);

        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getStudentDetail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentDetail(@PathVariable("id") int studentId) {

        System.out.println("student details for creating record:" + studentId);
        Student student = getStudent(studentId);

        System.out.println(student);
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }

    private Student getStudent(int studentId) {

        Session session = factoryutil.getSfactory().openSession();
        Transaction tx = null;
        Integer returnId = null;
        Student student=new Student();
        try {
            tx = session.beginTransaction();

             student = session.get(Student.class, studentId);


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

        return student;
    }

    @RequestMapping(value = "/addStudent1", method = RequestMethod.POST)
    public ResponseEntity<Integer> addStudentDetail1(@RequestBody Student student) {

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
