package com;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "EMP_CERT",
            joinColumns = { @JoinColumn(name = "certificate_id")},
            inverseJoinColumns = { @JoinColumn(name = "employee_id")}
    )
    Set<Employee> employees;

    public Certificate() {
    }

    public Certificate(String certificateName, String certificateType, Set<Employee> employees) {
        this.certificateName = certificateName;
        this.certificateType = certificateType;
        this.employees = employees;
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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "id=" + id +
                ", certificateName='" + certificateName + '\'' +
                ", certificateType='" + certificateType + '\'' +
                ", employees=" + employees +
                '}';
    }
}
