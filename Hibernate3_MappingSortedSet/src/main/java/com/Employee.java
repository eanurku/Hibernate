package com;

import java.math.BigDecimal;
import java.util.Set;
import java.util.SortedSet;

//Employee pojo
public class Employee {

    private int id;
    private String firstname;
    private String lastname;
    private BigDecimal salary;
    private SortedSet<Certificate> certificates;

    public Employee() {
    }

    public Employee(String firstname, String lastname, BigDecimal salary, SortedSet<Certificate> certificates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.certificates = certificates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public SortedSet<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(SortedSet<Certificate> certificates) {
        this.certificates = certificates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salary=" + salary +
                ", certificates=" + certificates +
                '}';
    }
}
