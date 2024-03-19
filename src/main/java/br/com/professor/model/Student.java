package br.com.professor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {

    @Id
    private String studentCode;
    private String name;

    @ManyToOne
    private Subject subject;


    public Student() {
    }

    public Student(String studentCode, String name) {
        this.studentCode = studentCode;
        this.name = name;
    }

    public String getStudentCode() {
        return studentCode;
    }
    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
