package com.main;

import com.dao.StudentNamedParameterTemplate;
import com.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringJdbcNamedParameterJdbcTemplateSetup {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentNamedParameterTemplate studentNamedParameterTemplate = context.getBean("studentNamedParameterJdbcTemplate", StudentNamedParameterTemplate.class);


       List<Student> students=studentNamedParameterTemplate.getAllStudents();
       for(Student student:students){
           System.out.println(student);
       }

    }
}
