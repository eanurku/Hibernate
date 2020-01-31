package com.main;


import com.dao.StudentNamedParameterTemplate;
import com.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class SpringJdbcNamedParameterBasedBatchcInsert {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentNamedParameterTemplate studentNamedParameterTemplate = context.getBean("studentNamedParameterJdbcTemplate", StudentNamedParameterTemplate.class);


        List<Student> list = new ArrayList<>();
        list.add(new Student("zname3", 5432L));
        list.add(new Student("zname3", 5432L));
        list.add(new Student("zname3", 5432L));

        int[] count = studentNamedParameterTemplate.objectBatchAddStudents(list);

        System.out.println("insert count:");
        for(int i=0;i<count.length;i++){
            System.out.println(count[i]);
        }
    }
}
