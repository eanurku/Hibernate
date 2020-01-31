package com.dao;

import com.model.Student;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class StudentNamedParameterTemplate implements StudentDAO {



    DataSource datasourceobj;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public StudentNamedParameterTemplate(){

    }


    public DataSource getDatasourceobj() {
        return datasourceobj;
    }

    public void setDatasourceobj(DataSource datasourceobj) {
        this.datasourceobj = datasourceobj;
        this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(datasourceobj);
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }




    @Override
    public List<Student> getAllStudents() {

        String SQL="select * from student";
        List<Student> list = namedParameterJdbcTemplate.query(SQL, new StudentMapper());

        return list;
    }

    @Override
    public Student getStudent(int studentId) {
        return null;
    }

    @Override
    public int addStudent(Student student) {
        return 0;
    }

    @Override
    public int addStudents(List<Student> students) {
        return 0;
    }

    @Override
    public int[] batchAddStudents(List<Student> students) {
        return new int[0];
    }

    @Override
    public int[][] multipleBatchesAddStudents(List<Student> studentList, int batchSize) {
        return new int[0][];
    }


    @Override
    public int[] objectBatchAddStudents(List<Student> students) {

        String SQL_INSERT="insert into student set name=:studentName,contact=:studentContact";
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(students.toArray());
        int[] count = namedParameterJdbcTemplate.batchUpdate(SQL_INSERT, batch);

        return count;
    }

    @Override
    public int updateStudent(Student student) {
        return 0;
    }

    @Override
    public int updateStudents(List<Student> student) {
        return 0;
    }

    @Override
    public int[] batchUpdateStudents(List<Student> students) {
        return new int[0];
    }

    @Override
    public int[][] multipleBatchesUpdateStudents(List<Student> studentList, int batchSize) {
        return new int[0][];
    }

    @Override
    public Map<String, Object> callProcedure(String proc, Map<String, Object> inputParams) {
        return null;
    }

    /*
      batch update by NamedParameterJdbcTemplate,SqlParameterSource
     */
    @Override
    public int[] objectBatchUpdateStudents(List<Student> students) {


        String SQL = "update student set name=:studentName,contact=:studentContact where id=:studentId";
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(students.toArray());

        int[] count = namedParameterJdbcTemplate.batchUpdate(SQL, batch);
        return count;
    }

    @Override
    public int deleteStudent(int studentId) {
        return 0;
    }

}
