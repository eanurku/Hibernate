package com.dao;

import com.model.Employee;

public interface EmployeeDAO {

    int saveEmployee(Employee employee);
    int deleteEmployee();
    int updateEmployee();


}
