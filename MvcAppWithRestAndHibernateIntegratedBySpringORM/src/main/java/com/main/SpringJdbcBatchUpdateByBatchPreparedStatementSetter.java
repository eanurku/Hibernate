package com.main;

import com.model.Student;
import com.dao.StudentJdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class SpringJdbcBatchUpdateByBatchPreparedStatementSetter {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentJdbcTemplate studentjdbcTemplate = context.getBean("studentJdbcTemplate", StudentJdbcTemplate.class);


        List<Student> list = new ArrayList<>();
        list.add(new Student(45,"yname2", 5432L ));
        list.add(new Student(46,"yname2", 5432L ));
        list.add(new Student(47,"yname2", 5432L));


        int[] count = studentjdbcTemplate.batchUpdateStudents(list);

        System.out.println("update count:");
        for(int i=0;i<count.length;i++)
            System.out.println(count[i]);

    }
}
