package br.com.professor.view.subjects;

import java.util.NoSuchElementException;
import java.util.Scanner;

import br.com.professor.controller.SubjectController;

public class AddStudentForm {
    private SubjectController subjectController;
    private Scanner scanner;

    public AddStudentForm(SubjectController subjectController, Scanner scanner) {
        this.subjectController = subjectController;
        this.scanner = scanner;
    }

    public Boolean execute(){
        System.out.print("Qual o código da matéria: ");
        String subjectCode = scanner.nextLine();

        System.out.print("Qual a matrícula do aluno: ");
        String studentCode = scanner.nextLine();

        try {
            return subjectController.addStudentInSubjectBySubjectCode(studentCode, subjectCode);
        } catch (Exception e) {
            return false;
        }
    }
    
}
