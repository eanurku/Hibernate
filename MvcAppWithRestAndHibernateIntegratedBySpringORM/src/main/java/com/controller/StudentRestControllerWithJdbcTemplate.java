package com.controller;


import com.dao.StudentJdbcTemplate;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRestControllerWithJdbcTemplate {


    @Autowired
    StudentJdbcTemplate studentJdbcTemplate;


    @RequestMapping(value = "/test3", method = RequestMethod.GET)
    public Student test() {

        return new Student("anurag", 542L);

    }


    @RequestMapping(value = "/getStudents", method = RequestMethod.GET)
    public List<Student> getStudents() {

        return studentJdbcTemplate.getAllStudents();
    }


    @RequestMapping(value = "/getStudent/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable("id") int id) {


        return studentJdbcTemplate.getStudent(id);
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ResponseEntity<Integer> addStudent(@RequestBody Student student) {


        int count = studentJdbcTemplate.addStudent(student);

        return new ResponseEntity<Integer>(count, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/addStudents", method = RequestMethod.POST)
    public ResponseEntity<Integer> addStudents(@RequestBody List<Student> students) {


        int count = studentJdbcTemplate.addStudents(students);

        return new ResponseEntity<Integer>(count, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/batchAddStudents", method = RequestMethod.POST)
    public ResponseEntity<Integer> batchAddStudents(@RequestBody List<Student> students) {


        int count[] = studentJdbcTemplate.batchAddStudents(students);

        return new ResponseEntity<Integer>(count.length, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public ResponseEntity<Integer> updateStudent(@RequestBody Student student) {

        int count = studentJdbcTemplate.updateStudent(student);
        return new ResponseEntity<Integer>(count, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/batchUpdateStudents",method = RequestMethod.POST)

    public ResponseEntity<Integer> batchUpdateStudents(@RequestBody List<Student> students){

        int updateCount[]=studentJdbcTemplate.batchUpdateStudents(students);

        return new ResponseEntity<Integer>(updateCount.length, HttpStatus.CREATED);
    }

}
