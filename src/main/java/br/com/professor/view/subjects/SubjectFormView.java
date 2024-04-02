package br.com.professor.view.subjects;

import java.util.Scanner;

import br.com.professor.controller.SubjectController;
import br.com.professor.model.Subject;

public class SubjectFormView {

    private SubjectController subjectController;
    private Scanner scanner;

    public SubjectFormView(SubjectController subjectController, Scanner scanner) {
        this.subjectController = subjectController;
        this.scanner = scanner;
    }

    public Boolean execute(){
        Boolean isSave = false;
        System.out.print("Qual o código da matéria: ");
        String subjectCode = scanner.nextLine();
        System.out.print("Qual o nome da matéria: ");
        String name = scanner.nextLine();
        Subject subject = new Subject(subjectCode, name);
        try {
            isSave = subjectController.createNewSubject(subject);
        } catch (IllegalArgumentException e) {
            System.out.println("Ocorreu um erro na criação da matéria");
            return isSave;
        }
        return isSave;
    }
}
