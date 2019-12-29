package com.dao;

import com.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentDAO {

    //select
    List<Student> getAllStudents();
    Student getStudent(int studentId);

    //insert
    int addStudent(Student student);
    int addStudents(List<Student> students);
    int[] batchAddStudents(List<Student> students);
    int[][] multipleBatchesAddStudents(List<Student> studentList, int batchSize);
    int[] objectBatchAddStudents(List<Student> students);

    //update
    int updateStudent(Student student);
    int updateStudents(List<Student> student);
    int[] batchUpdateStudents(List<Student> students);
    int[][] multipleBatchesUpdateStudents(List<Student> studentList, int batchSize);
    int[] objectBatchUpdateStudents(List<Student> students);

    //delete
    int deleteStudent(int studentId);

    //store procedure
    Map<String, Object> callProcedure(String proc, Map<String, Object> inputParams);


}
