package br.com.professor.controller;

import java.util.List;

import br.com.professor.model.Attendance;
import br.com.professor.model.Student;
import br.com.professor.service.AttendanceService;

public class AttendanceController {

    private AttendanceService attendanceService;

    public AttendanceController() {
        this.attendanceService = new AttendanceService();
    }

    public boolean createNewAttendance(Attendance request){
        return attendanceService.save(request);
    }
    public boolean updateAttendance(Attendance request){
        return attendanceService.save(request);
    }
    public boolean addPresenceInStudents(Long id, List<Student> presence){
        return attendanceService.addPresenceInStudents(id, presence);
    }
    public Attendance getAttendanceById(Long id){
        return attendanceService.getAttendanceById(id);
    }
    public List<Attendance> getAllAttendances(){
        return attendanceService.getAllAttendances();
    }
    public List<Attendance> getAllAttendancesBySubjectCode(String subjectCode){
        return attendanceService.getAllAttendancesBySubjectCode(subjectCode);
    }
}
