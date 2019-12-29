package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SpringJdbcDataSourceSetup {

    public static void main(String[] args) throws SQLException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        DataSource datasource = context.getBean("dataSource", DataSource.class);

        Connection conn = datasource.getConnection();

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("select * from student");
        while (rs.next()) {

            System.out.println(rs.getString(1)+" "+rs.getBigDecimal(2)+" "+rs.getInt(3));

        }
    }
}

/*
ant run -Dmainclass=com.datasource.setup.SpringJdbcDataSourceSetup
 */