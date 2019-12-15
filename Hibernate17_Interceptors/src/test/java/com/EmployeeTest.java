package com;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class EmployeeTest {

    @Test
    public void test(){
        Employee emp=new Employee("monu","kumar",new BigDecimal("22.32"));

        Assert.assertEquals(new BigDecimal("22.32"),emp.getSalaryAmount());



    }
}
