package br.com.professor.view.student;

import java.util.Scanner;

import br.com.professor.controller.StudentController;
import br.com.professor.model.Student;

public class StudentFormView{
    private StudentController studentController;
    private Scanner scanner;

    public StudentFormView(StudentController studentController, Scanner scanner) {
        this.studentController = studentController;
        this.scanner = scanner;
    }

    public Boolean execute(){
        Boolean isSave = false;
        System.out.print("Qual o Nome do Estudante: ");
        String name = scanner.nextLine();
        System.out.print("Qual a matricula do Estudante: ");
        String studentCode = scanner.nextLine();
        Student student = new Student(studentCode,name);
        try {
            isSave = studentController.createNewStudent(student);
        } catch (IllegalArgumentException e) {
            System.out.println("Ocorreu um erro na criação do novo aluno");
            execute();
        }
        return isSave;
    }
    

    
}
