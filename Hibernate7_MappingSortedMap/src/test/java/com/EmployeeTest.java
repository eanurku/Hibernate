package com;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeTest {

    @Test
    public void test(){
        Employee emp=new Employee("monu","kumar",new BigDecimal("22.32"), new TreeMap<>());

        Assert.assertEquals(new BigDecimal("22.32"),emp.getSalary());



    }
}
