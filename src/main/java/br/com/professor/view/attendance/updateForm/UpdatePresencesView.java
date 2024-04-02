package br.com.professor.view.attendance.updateForm;

import java.util.Scanner;

import br.com.professor.controller.AttendanceController;
import br.com.professor.model.Attendance;

public class UpdatePresencesView {
    
    private AttendanceController attendanceController;
    private Scanner scanner;

    public UpdatePresencesView(AttendanceController attendanceController, Scanner scanner) {
        this.attendanceController = attendanceController;
        this.scanner = scanner;
    }

    public void execute(){
        
        System.out.print("Qual o id do registro que quer alterar a data: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        try {
            Attendance attendance = attendanceController.getAttendanceById(id);
            attendance.getStudentPresenceList().forEach(s -> {
                System.out.print(s.getStudent().getName() + " esta presente (S ou N)? ");
                s.setIsPresence(scanner.nextLine().toUpperCase().equals("S"));
        });
        attendanceController.updateAttendance(attendance);
        } catch (Exception e) {
            throw new RuntimeException("Id não encontrado!");
        }
    }
}
