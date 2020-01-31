package com.dao;

import com.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    @Autowired
    SessionFactory sessionfactory;


    public EmployeeDAOHibernateImpl(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

    @Override
    public int saveEmployee(Employee employee) {

        Session session = sessionfactory.openSession();
        Transaction tx=null;
        Integer returnId=null;

        try{
            tx = session.beginTransaction();
            returnId= (Integer) session.save(employee);
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
    public int deleteEmployee() {
        return 0;
    }

    @Override
    public int updateEmployee() {
        return 0;
    }
}
