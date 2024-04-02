package br.com.professor.view.attendance.updateForm;

import java.util.List;
import java.util.Scanner;

import br.com.professor.controller.AttendanceController;
import br.com.professor.model.Attendance;
import br.com.professor.model.StudentPresence;
import br.com.professor.model.Subject;
import br.com.professor.utils.DateConverter;

public class SeachUpdantView {

    private AttendanceController attendanceController;
    private Scanner scanner;
    
    public SeachUpdantView(AttendanceController attendanceController, Scanner scanner) {
        this.attendanceController = attendanceController;
        this.scanner = scanner;
    }

    public boolean execute(){
        
        System.out.print("Qual o código da matéria: ");
        String subjectCode = scanner.nextLine();
        try {
            List<Attendance> attendances = attendanceController.getAllAttendancesBySubjectCode(subjectCode);
            System.out.println();
            Subject subject = attendances.get(0).getSubject();

            System.out.printf("\nMatéria: %s\n", subject.getName());
            attendances.forEach(a -> {
                Long presents = a.getStudentPresenceList().stream().filter(StudentPresence::getIsPresence).count();
                System.out.printf("(Id: %d) - %s - %s - Total de alunos presentes: %d\n", 
                a.getId(),
                DateConverter.LocalDate2String(a.getCheckIn()),
                a.getTopics(),
                presents
                );
            });
            System.out.println("Aperte ENTER para voltar ao menu.");
            scanner.nextLine();
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
}
