package com.criteriaquery.restrictions;

import com.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import java.math.BigDecimal;
import java.util.List;

public class hibernateCriteriaRestrictionsLogicalExpAnd {
    static SessionFactory sfactory;
    static void setUp(){

        StandardServiceRegistry registry = null;

        try {
            registry = new StandardServiceRegistryBuilder().configure().build();
            sfactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }catch (Exception e){
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError("error in creating session factory");
        }

    }
    public static void main(String[] args) {
        setUp();
        getEmployee();
    }

    private static void getEmployee() {

        Session session = sfactory.openSession();
        Transaction tx = null;
        try{
            tx=session.beginTransaction();

            Criteria criteria = session.createCriteria(Employee.class);

            SimpleExpression cond1 = Restrictions.gt("salaryAmount", new BigDecimal("100"));
            SimpleExpression cond2 = Restrictions.like("firstName", "%gonu2%");
            LogicalExpression andCond = Restrictions.and(cond1, cond2);

            criteria.add(andCond);


            List<Employee> list = criteria.list();

            for(Employee emp:list)
                System.out.println(emp);

            tx.commit();

        }catch(Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }

    }
}
