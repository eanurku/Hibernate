package com.querylevel;

import com.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.stat.Statistics;

import java.math.BigDecimal;
import java.util.List;

public class hibernateQuerylevelCache {
    static SessionFactory sfactory;

    static void setUp() {

        StandardServiceRegistry registry = null;

        try {
            registry = new StandardServiceRegistryBuilder().configure().build();
            sfactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError("error in creating session factory");
        }

    }

    public static void main(String[] args) {

        setUp();

        getEmployees();


    }

    private static void getEmployees() {

        Session session = sfactory.openSession();
        Session othersession = sfactory.openSession();

        Statistics stats = sfactory.getStatistics();
        System.out.println("stats enabled:"+stats.isStatisticsEnabled());
        stats.setStatisticsEnabled(true);
        System.out.println("stats enabled:"+stats.isStatisticsEnabled());

        Transaction tx = null;
        Transaction othertx=null;

        Employee emp=null;

        try {
            tx = session.beginTransaction();
            othertx=othersession.beginTransaction();

            Query query = session.createQuery("from Employee");

            query.setCacheable(true);
            query.setCacheRegion("employee");
            query.list();

            Query query2 = othersession.createQuery("from Employee");
            query2.list();


            tx.commit();
            othertx.commit();

        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            if (othertx != null)
                othertx.rollback();
            e.printStackTrace();
        } finally {

            session.close();
            othersession.clear();

        }
        sfactory.close();

    }

    private static void printStats(Employee emp,Statistics stats,int count) {


        System.out.println("******start of "+count+" ************");
        if(emp!=null)
        System.out.println(emp.getId()+" "+emp.getFirstName()+" "+emp.getLastName());
        System.out.println("second level fetch count:"+stats.getEntityLoadCount());
        System.out.println("second level cache hit count:"+stats.getSecondLevelCacheHitCount());
        System.out.println("second level cache miss count:"+stats.getSecondLevelCacheMissCount());
        System.out.println("second level cache put count:"+stats.getSecondLevelCachePutCount());
        System.out.println("***********end of "+count+"**********");
    }
}
