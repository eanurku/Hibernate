package com;


import com.daoimpl.EmployeeDAOHibernateImpl;
import com.model.Employee;
import com.model.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class HibernateInsertMain {



    public static void main(String[] args) {

        ClassPathXmlApplicationContext cxt=new ClassPathXmlApplicationContext("hibernateConfigurations.xml");

        Test test = cxt.getBean("test",Test.class);

        System.out.println(test.getId());

        EmployeeDAOHibernateImpl empImpl = cxt.getBean("employeeDAOHibernateImpl", EmployeeDAOHibernateImpl.class);

        Employee employee=new Employee("gonu5","kr",new BigDecimal("40.3"));
        int id=empImpl.saveEmployee(employee);
        System.out.println("return id="+id);
    }

}
