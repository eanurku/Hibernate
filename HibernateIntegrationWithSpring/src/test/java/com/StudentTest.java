package com;

import com.model.Employee;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class StudentTest {


    @Test
    public void testsname(){

        Employee st=new Employee("monu","qwe",new BigDecimal("22"));

        Assert.assertEquals("monu",st.getFirstname());

    }
}
