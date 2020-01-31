package com.main;

import com.model.Student;
import com.dao.StudentJdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJdbcInsertRow {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentJdbcTemplate studentjdbcTemplate = context.getBean("studentJdbcTemplate", StudentJdbcTemplate.class);


        Student student = new Student();
        student.setStudentName("aname");
        student.setStudentContact(98769L);

        int count = studentjdbcTemplate.addStudent(student);

        System.out.println("inserted rows:" + count);

    }
}
