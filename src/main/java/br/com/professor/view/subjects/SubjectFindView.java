package br.com.professor.view.subjects;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;



import br.com.professor.controller.SubjectController;
import br.com.professor.model.Student;
import br.com.professor.model.Subject;

public class SubjectFindView {
    private SubjectController subjectController;
    private Scanner scanner;

    public SubjectFindView(SubjectController subjectController, Scanner scanner) {
        this.subjectController = subjectController;
        this.scanner = scanner;
    }

    public Boolean execute(){
        System.out.print("Qual o código da matéria: ");
        String subjectCode = scanner.nextLine();

        try {
            Subject subject = subjectController.findSubjectBySubjectCode(subjectCode);
            System.out.printf("Código da matéria: %s, Matéria: %s\n", subject.getSubjectCode(), subject.getName());
            System.out.println("Alunos matriculados: ");
            List<Student> enrolled = subjectController.getAllStudentEnrolledSubjectBySubjectCode(subjectCode);
            enrolled.forEach((e) -> {
                System.out.printf("\t- %s (%s)\n",e.getName(), e.getStudentCode());
            });
            System.out.println("Digite ENTER para continuar.");
            scanner.nextLine();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
