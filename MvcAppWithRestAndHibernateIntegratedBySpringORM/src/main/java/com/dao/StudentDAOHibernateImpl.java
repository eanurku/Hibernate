package com.dao;

import com.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class StudentDAOHibernateImpl implements StudentDAO {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public Student getStudent(int studentId) {
        return null;
    }

    @Override
    public int addStudent(Student student) {


        Session session = sessionFactory.openSession();
        Transaction tx=null;
        Integer returnId=null;

        try{
            tx = session.beginTransaction();
            returnId= (Integer) session.save(student);
            tx.commit();
        }catch (Exception e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally {

            session.close();
        }

        return returnId;
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
        return new int[0];
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
    public int[] objectBatchUpdateStudents(List<Student> students) {
        return new int[0];
    }

    @Override
    public int deleteStudent(int studentId) {
        return 0;
    }

    @Override
    public Map<String, Object> callProcedure(String proc, Map<String, Object> inputParams) {
        return null;
    }
}
