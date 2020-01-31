package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("student_id")
    int studentId;


    @Column(name = "name")
    @JsonProperty("student_name")
    @Size(min=2,max=32)
    String studentName;

    @Column(name = "contact")
    @JsonProperty("student_contact")
    @Max(value = 9999999999L)
    Long studentContact;

    @Column(name = "dob")
    @JsonProperty("student_dob")
    @Past
    Date studentDob;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable( name = "skill",joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "skill_name")
    @JsonProperty("student_skills")
    List<String> studentSkills;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    Address studentAddress;

    public Student() {
    }

    public Student(@Size(min = 2, max = 32) String studentName, @Max(value = 200) Long studentContact) {
        this.studentName = studentName;
        this.studentContact = studentContact;
    }

    public Student(@Size(min = 2, max = 32) String studentName, @Max(value = 200) Long studentContact, @Past Date studentDob) {
        this.studentName = studentName;
        this.studentContact = studentContact;
        this.studentDob = studentDob;
    }

    public Student(int studentId, String studentName, Long studentContact) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentContact = studentContact;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getStudentContact() {
        return studentContact;
    }

    public void setStudentContact(Long studentContact) {
        this.studentContact = studentContact;
    }

    public Date getStudentDob() {
        return studentDob;
    }

    public void setStudentDob(Date studentDob) {
        this.studentDob = studentDob;
    }

    public List<String> getStudentSkills() {
        return studentSkills;
    }

    public void setStudentSkills(List<String> studentSkills) {
        this.studentSkills = studentSkills;
    }

    public Address getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(Address studentAddress) {
        this.studentAddress = studentAddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentContact=" + studentContact +
                ", studentDob=" + studentDob +
                ", studentSkills=" + studentSkills +
                ", studentAddress=" + studentAddress +
                '}';
    }
}
