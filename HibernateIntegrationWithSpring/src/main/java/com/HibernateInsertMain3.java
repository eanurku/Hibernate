package com;


import com.dao.EmployeeDAO;
import com.daoimpl.EmployeeDAOHibernateImpl;
import com.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class HibernateInsertMain3 {



    public static void main(String[] args) {

        ClassPathXmlApplicationContext cxt=new ClassPathXmlApplicationContext("app.xml");

        Test test = cxt.getBean("test",Test.class);

        System.out.println(test.getId());


        //without autowiring
        SessionFactory sfactory = cxt.getBean("hibernateSessionFactory", SessionFactory.class);

        Employee employee=new Employee("gonu5","kr",new BigDecimal("40.3"));
        EmployeeDAO empImpl=new EmployeeDAOHibernateImpl(sfactory);
        int id=empImpl.saveEmployee(employee);
        System.out.println("return id="+id);

        //After autowiring
        EmployeeDAOHibernateImpl employeeDAOHibernateImpl = cxt.getBean("employeeDAOHibernateImpl", EmployeeDAOHibernateImpl.class);

        id= employeeDAOHibernateImpl.saveEmployee(employee);
        System.out.println("return id="+id);

        //


    }

}
