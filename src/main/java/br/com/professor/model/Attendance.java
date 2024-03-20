package br.com.professor.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate checkIn;
    private String topics;

    @OneToMany(mappedBy = "attendance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentPresence> studentPresenceList;

    @OneToOne
    private Subject subject;

    

    public Attendance() {
    }

    public Attendance(LocalDate checkIn, String topics, List<StudentPresence> studentPresenceList, Subject subject) {
        this.checkIn = checkIn;
        this.topics = topics;
        this.studentPresenceList = studentPresenceList;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public List<StudentPresence> getStudentPresenceList() {
        return studentPresenceList;
    }

    public void setStudentPresenceList(List<StudentPresence> studentPresenceList) {
        this.studentPresenceList = studentPresenceList;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
