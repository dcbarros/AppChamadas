package br.com.professor.view;

import java.util.Arrays;

import br.com.professor.view.components.AbstractMenuView;
import br.com.professor.view.components.MenuItem;

public class PrincipalMenu extends AbstractMenuView{



    public PrincipalMenu() {
        super(
            Arrays.asList(
                new MenuItem(1, "Aluno"),
                new MenuItem(2, "Matéria"),
                new MenuItem(3, "Presenças"),
                new MenuItem(4, "Relatório"),
                new MenuItem(5, "Sair")
            )
        );
    }

    @Override
    public void executeOption(Integer choice) {
        switch (choice) {
            case 1 -> System.out.println("Aluno");
            case 2 -> System.out.println("Matéria");
            case 3 -> System.out.println("Presenças");
            case 4 -> System.out.println("Relatório");
            case 5 -> {
                this.clearConsole.run();
                System.out.println("Obrigado!!!!!");
                System.exit(0);
            }
            default -> {
                System.out.println(choice + ": Opção não localizada no menu.");
                execute();        
            }
        }
    }
    
}
