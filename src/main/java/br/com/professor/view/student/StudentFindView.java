package br.com.professor.view.student;

import java.util.Scanner;

import br.com.professor.controller.StudentController;
import br.com.professor.model.Student;

public class StudentFindView {

    private StudentController studentController;
    private Scanner scanner;

    public StudentFindView(StudentController studentController, Scanner scanner) {
        this.studentController = studentController;
        this.scanner = scanner;
    }
    
    public Boolean execute(){
        Boolean isSave = false;
        System.out.print("Qual a matrícula do aluno: ");
        String studentCode = scanner.nextLine();
        try {
            Student student = studentController.findStudentByStudentCode(studentCode);
            System.out.printf("Matricula: %s, Nome: %s\n", student.getStudentCode(), student.getName());
            System.out.println("Matriculado em: ");
            student.getSubjects().forEach((s) -> {
                System.out.printf("\t- %s\n", s.getName());
            });
            System.out.println("Digite ENTER para continuar.");
            scanner.nextLine();
            return isSave = true;
        } catch (Exception e) {
            return isSave;
        }
    }
}
