package br.com.professor.view.attendance.updateForm;

import java.util.Scanner;

import br.com.professor.controller.AttendanceController;
import br.com.professor.model.Attendance;

public class UpdateTopicsView {
    private AttendanceController attendanceController;
    private Scanner scanner;

    public UpdateTopicsView(AttendanceController attendanceController, Scanner scanner) {
        this.attendanceController = attendanceController;
        this.scanner = scanner;
    }

    public void execute(){
        
        System.out.print("Qual o id do registro que quer alterar a data: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        try {
            Attendance attendance = attendanceController.getAttendanceById(id);
            System.out.printf("O tópico registrado foi:\n%s, Deseja Alterar? (S ou N): ", attendance.getTopics());
            String choice = scanner.nextLine().toUpperCase();
            if(choice.equals("S")){
                System.out.print("Qual o novo tópico da aula: ");
                attendance.setTopics(scanner.nextLine());
                attendanceController.updateAttendance(attendance);
            }else{return;}
        } catch (Exception e) {
            throw new RuntimeException("Id não encontrado!");
        }
    }
}
