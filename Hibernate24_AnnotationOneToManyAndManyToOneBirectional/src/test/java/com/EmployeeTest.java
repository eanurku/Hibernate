package com;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;

public class EmployeeTest {


    @Test
    public void testsname(){
        Employee emp=new Employee("monu","kumar",new BigDecimal("22.32"),new HashSet<>());

        Assert.assertEquals(new BigDecimal("22.32"),emp.getSalary());

    }
}
