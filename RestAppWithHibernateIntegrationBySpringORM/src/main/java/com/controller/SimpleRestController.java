package com.controller;



import com.dao.EmployeeDAO;
import com.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
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
public class SimpleRestController {

    @Autowired
    EmployeeDAO EmployeeDAOImpl;


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

        EmployeeDAOImpl.saveEmployee(employee);

        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }




}
