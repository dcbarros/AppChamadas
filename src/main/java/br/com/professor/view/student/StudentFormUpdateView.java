package br.com.professor.view.student;

import java.util.Scanner;

import br.com.professor.controller.StudentController;
import br.com.professor.model.Student;

public class StudentFormUpdateView {
    private StudentController studentController;
    private Scanner scanner;

    public StudentFormUpdateView(StudentController studentController, Scanner scanner) {
        this.studentController = studentController;
        this.scanner = scanner;
    }

    public Boolean execute(){
        Boolean isSave = false;
        System.out.print("Qual a matrícula do aluno: ");
        String studentCode = scanner.nextLine();
        try {
            Student student = studentController.findStudentByStudentCode(studentCode);
            System.out.println("O estudante encontrado com a matricula: " + student.getStudentCode() + " foi: " + student.getName());
            System.out.print("Deseja alterar o nome? (S ou N) ");
            String choice = scanner.nextLine().toUpperCase();
            if(choice.equals("S")){
                System.out.print("Digite o nome que quer alterar: ");
                String name = scanner.nextLine();
                student.setName(name);
                isSave = studentController.updateStudentName(student);
            }else if(choice.equals("N")){
                studentController.updateStudentName(student);
            }else {
                return isSave;
            }
        } catch (Exception e) {
            return isSave;
        }
        return isSave;
    }
    
}
