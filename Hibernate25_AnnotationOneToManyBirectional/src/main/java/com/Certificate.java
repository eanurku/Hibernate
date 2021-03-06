package com;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CERTIFICATE")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    int id;

    @Column(name = "certificate_name")
    String certificateName;

    @Column(name = "certificate_type")
    String certificateType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    Employee  employee;


    public Certificate() {
    }

    public Certificate(String certificateName, String certificateType, Employee employee) {
        this.certificateName = certificateName;
        this.certificateType = certificateType;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "id=" + id +
                ", certificateName='" + certificateName + '\'' +
                ", certificateType='" + certificateType + '\'' +
                ", employee=" + employee +
                '}';
    }
}
