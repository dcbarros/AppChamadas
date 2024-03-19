package br.com.professor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class StudentPresence {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Student student;

    private Boolean isPresence;
    
    @ManyToOne
    private Attendance attendance;

    public StudentPresence() {
    }

    public StudentPresence(Student student, Boolean isPresence, Attendance attendance) {
        this.student = student;
        this.isPresence = isPresence;
        this.attendance = attendance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Boolean getIsPresence() {
        return isPresence;
    }

    public void setIsPresence(Boolean isPresence) {
        this.isPresence = isPresence;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }



    
}
