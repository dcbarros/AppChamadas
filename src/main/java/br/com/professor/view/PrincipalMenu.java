package br.com.professor.view;

import java.util.Arrays;

import br.com.professor.model.Message;
import br.com.professor.view.attendance.AttendanceView;
import br.com.professor.view.components.AbstractMenuView;
import br.com.professor.view.components.MenuItem;
import br.com.professor.view.student.StudentView;
import br.com.professor.view.subjects.SubjectView;

public class PrincipalMenu extends AbstractMenuView{

    public PrincipalMenu() {
        super(
            Arrays.asList(
                new MenuItem(1, "Aluno"),
                new MenuItem(2, "Matéria"),
                new MenuItem(3, "Presenças"),
                // new MenuItem(4, "Relatório"),
                new MenuItem(5, "Sair")
            ),
            new Message("###### Menu Principal ######")
        );
    }

    @Override
    public void executeOption(Integer choice) {
        this.message.setDefaultText("");
        switch (choice) {
            case 1 -> new StudentView().execute();
            case 2 -> new SubjectView().execute();
            case 3 -> new AttendanceView().execute();
            // case 4 -> System.out.println("Relatório");
            case 4 -> {
                this.clearConsole.run();
                System.out.println("Obrigado!!!!!");
                System.exit(0);
            }
            default -> {
                this.message.setDefaultText(choice + ": Opção não localizada no menu.\n");      
            }
        }
        execute();
    }
    
}
