package br.com.professor.service;

import java.util.List;
import java.util.NoSuchElementException;

import br.com.professor.model.Attendance;
import br.com.professor.model.Student;
import br.com.professor.model.StudentPresence;
import br.com.professor.repository.AttendanceRepository;
import br.com.professor.repository.StudentPresenceRepository;

public class AttendanceService {

    private AttendanceRepository attendanceRepository;
    private StudentPresenceRepository studentPresenceRepository;

    public AttendanceService(){
        this.attendanceRepository = new AttendanceRepository();
        this.studentPresenceRepository = new StudentPresenceRepository();
    }

    public Boolean save(Attendance request){

        if(request == null) throw new IllegalArgumentException("Estudante não encontrado.");
        
        if(request.getId() == null){
            attendanceRepository.addAtomicTransaction(request);
        }else{
            if(attendanceRepository.getById(request.getId()) == null) throw new NoSuchElementException("Não foi possível localizar a ficha de presença");
            attendanceRepository.updateAtomicTransaction(request);
        }
        return true;
    }

    public Boolean addPresenceInStudents(Long id, List<Student> presences){
        Attendance attendance = attendanceRepository.getById(id);
        if(attendance == null) throw new NoSuchElementException("Não foi possível localizar a ficha de presença");
        List<String> presentStudentCodes = presences.stream().map(Student::getStudentCode).toList();
        attendance.getSubject().getStudents().stream().forEach(
            (student) -> {
                StudentPresence presence = new StudentPresence();
                presence.setStudent(student);
                presence.setAttendance(attendance);
                presence.setIsPresence(presentStudentCodes.contains(student.getStudentCode()));
                studentPresenceRepository.addAtomicTransaction(presence);
            }
        );

        return true;
    }

    public Attendance getAttendanceById(Long id){
        try {
            return attendanceRepository.getById(id);       
        } catch (Exception e) {
            throw new NoSuchElementException("Não foi possível localizar a ficha de presença");
        }
    }

    public List<Attendance> getAllAttendances(){
        return attendanceRepository.getAll();
    }

    public List<Attendance> getAllAttendancesBySubjectCode(String subjectCode){
        if(subjectCode == null || subjectCode.isBlank()) throw new IllegalArgumentException("O cód. da materia deve ser preenchido");
        return attendanceRepository.getAllBySubjectCode(subjectCode);
    }
    
}
