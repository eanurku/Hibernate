package com;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeTest {

    @Test
    public void test(){
        Employee emp=new Employee("monu","kumar",new BigDecimal("22.32"), new HashMap());

        Assert.assertEquals(new BigDecimal("22.32"),emp.getSalary());



    }
}
