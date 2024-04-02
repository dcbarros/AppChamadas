package br.com.professor.view.subjects;

import java.util.Scanner;

import br.com.professor.controller.SubjectController;
import br.com.professor.model.Subject;

public class SubjectFormUpdateView {
    private SubjectController subjectController;
    private Scanner scanner;

    public SubjectFormUpdateView(SubjectController subjectController, Scanner scanner) {
        this.subjectController = subjectController;
        this.scanner = scanner;
    }

    public Boolean execute(){
        Boolean isSave = false;
        System.out.print("Qual o código da matéria: ");
        String subjectCode = scanner.nextLine();
        try {
            Subject subject = subjectController.findSubjectBySubjectCode(subjectCode);
            System.out.println("A matéria encontrada foi: " + subject.getName());
            System.out.print("Deseja alterar o nome? (S ou N) ");
            String choice = scanner.nextLine().toUpperCase();
            if(choice.equals("S")){
                System.out.print("Digite o nome que quer alterar: ");
                String name = scanner.nextLine();
                subject.setName(name);
                isSave = subjectController.updateSubjectName(subject);
            }else if(choice.equals("N")){
                subjectController.updateSubjectName(subject);
            }else {
                return isSave;
            }
        } catch (Exception e) {
            return isSave;
        }
        return isSave;
    }
    
}
