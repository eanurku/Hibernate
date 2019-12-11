package com;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Set;

//Employee pojo
public class Employee {

    private int id;
    private String firstname;
    private String lastname;
    private BigDecimal salary;
    private Collection<Certificate> certificates;

    public Employee() {
    }

    public Employee(String firstname, String lastname, BigDecimal salary, Collection<Certificate> certificates) {
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

    public Collection<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(Collection<Certificate> certificates) {
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
