package br.com.professor.view;

import java.util.Arrays;
import java.util.Scanner;

public class PrincipalMenu implements MenuInterface{
    private Runnable clearConsole;
    private String[] options;
    private Scanner scanner;

    public PrincipalMenu() {
        this.options = new String[]{"1 - Alunos","2 - Matérias","3 - Presenças", "4 - Sair"};
        this.scanner = new Scanner(System.in);
        this.clearConsole = () -> {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        };
    }

    @Override
    public void execute() {
        clearConsole.run();
        System.out.println("Registrador de Presença");
        Arrays.asList(options).stream().forEach(System.out::println);
        System.out.print("Qual opção você quer escolher? ");
        executeOption(scanner.nextInt());
    }

    @Override
    public void executeOption(Integer choice) {
        switch (choice) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                scanner.close();
                System.exit(0);        
            default:
                System.out.println("Opção inválida, Digite ENTER para continuar.");
                scanner.nextLine();
                scanner.nextLine();
                execute();
        }
    }
    
}
