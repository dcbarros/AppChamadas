package br.com.professor.view.attendance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.professor.controller.AttendanceController;
import br.com.professor.controller.SubjectController;
import br.com.professor.model.Attendance;
import br.com.professor.model.Student;
import br.com.professor.model.StudentPresence;
import br.com.professor.model.Subject;
import br.com.professor.utils.DateConverter;

public class AttendanceForm {

    private Scanner scanner;
    private AttendanceController attendanceController;
    private SubjectController subjectController;

    public AttendanceForm(Scanner scanner, 
    AttendanceController attendanceController,
    SubjectController subjectController) {
        this.scanner = scanner;
        this.attendanceController = attendanceController;
        this.subjectController = subjectController;
    }
    
    public Boolean execute(){
        System.out.print("Qual o tópico apresentado na aula: ");
        String topics = scanner.nextLine();

        System.out.print("Qual o código da matéria: ");
        String subjectCode = scanner.nextLine();

        System.out.print("Digite o dia da aula no formato dd/mm/yyyy: ");
        String dateSTR = scanner.nextLine();
        LocalDate date = DateConverter.String2LocalDate(dateSTR);
        Attendance attendance = new Attendance();
        try {
            Subject subject = subjectController.findSubjectBySubjectCode(subjectCode);
            List<StudentPresence> presences = new ArrayList<>();
            List<Student> enroledStudent = subjectController.getAllStudentEnrolledSubjectBySubjectCode(subjectCode);
            enroledStudent.forEach(e -> {
                System.out.println(e.getName() + " Está presente (S ou N)? ");
                String choice = scanner.nextLine().toUpperCase();
                StudentPresence presence = new StudentPresence(e, choice.equals("S"), attendance);
                presences.add(presence);
            });
            attendance.setCheckIn(date);
            attendance.setSubject(subject);
            attendance.setTopics(topics);
            attendance.setStudentPresenceList(presences);
            attendanceController.createNewAttendance(attendance);
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
}
