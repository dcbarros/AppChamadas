package br.com.professor.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {

    @Id
    private String studentCode;
    private String name;

    @ManyToMany(mappedBy = "students")
    private List<Subject> subjects;
    
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

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

}
