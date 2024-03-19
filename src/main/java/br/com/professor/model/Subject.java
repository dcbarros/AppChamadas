package br.com.professor.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Subject {
    
    @Id
    private String subjectCode;
    private String name;

    @OneToMany
    List<Student> students;

    public Subject(String subjectCode, String name) {
        this.subjectCode = subjectCode;
        this.name = name;
    }

    public Subject() {
    }

    public String getSubjectCode() {
        return subjectCode;
    }
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        students = students.stream()
                            .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                            .collect(Collectors.toList());
        this.students = students;
    }

    
}
