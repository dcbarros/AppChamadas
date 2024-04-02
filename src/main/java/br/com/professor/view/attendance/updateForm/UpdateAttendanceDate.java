package br.com.professor.view.attendance.updateForm;

import java.time.LocalDate;
import java.util.Scanner;

import br.com.professor.controller.AttendanceController;
import br.com.professor.model.Attendance;
import br.com.professor.utils.DateConverter;

public class UpdateAttendanceDate {

    private AttendanceController attendanceController;
    private Scanner scanner;

    public UpdateAttendanceDate(AttendanceController attendanceController, Scanner scanner) {
        this.attendanceController = attendanceController;
        this.scanner = scanner;
    }

    public void execute(){
        
        System.out.print("Qual o id do registro que quer alterar a data: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        try {
            Attendance attendance = attendanceController.getAttendanceById(id);
            System.out.print("A data registrada nessa presença é: " + DateConverter.LocalDate2String(attendance.getCheckIn()) + " Deseja alterar? (S ou N)");
            String choice = scanner.nextLine().toUpperCase();
            if(choice.equals("S")){
                System.out.print("Digite o dia da aula no formato dd/mm/yyyy: ");
                String dateSTR = scanner.nextLine();
                LocalDate date = DateConverter.String2LocalDate(dateSTR);
                attendance.setCheckIn(date);
                attendanceController.updateAttendance(attendance);
            }else{
                throw new RuntimeException("");
            }
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro indesejádo ao atualizar.");
        }

    
    }

    
}
