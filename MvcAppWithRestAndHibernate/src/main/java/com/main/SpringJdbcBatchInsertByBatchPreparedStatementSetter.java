package com.main;


import com.dao.StudentJdbcTemplate;
import com.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class SpringJdbcBatchInsertByBatchPreparedStatementSetter {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentJdbcTemplate studentjdbcTemplate = context.getBean("studentJdbcTemplate", StudentJdbcTemplate.class);

        List<Student> list = new ArrayList<>();
        list.add(new Student("xname1", 213L));
        list.add(new Student("xname2", 214L));


        int[] count = studentjdbcTemplate.batchAddStudents(list);

        System.out.println("batch inserts:");
        for (int i = 0; i < count.length; i++)
            System.out.println(count[i]);

    }
}
