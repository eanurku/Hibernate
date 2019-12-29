package com.dao;

import com.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {


        Student student=new Student();

        student.setStudentId(rs.getInt("id"));
        student.setStudentName(rs.getString("name"));
        student.setStudentContact(Long.parseLong(rs.getString("contact")));


        return student;
    }
}
