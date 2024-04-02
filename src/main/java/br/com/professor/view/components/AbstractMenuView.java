package br.com.professor.view.components;

import java.util.List;
import java.util.Scanner;

import br.com.professor.model.Message;
import br.com.professor.view.MenuInterface;

public abstract class AbstractMenuView implements MenuInterface{
    private List<MenuItem> itens;
    protected Scanner scanner;
    protected Runnable clearConsole;
    protected Message message;

    public AbstractMenuView(List<MenuItem> itens, Message message) {
        this.itens = itens;
        this.scanner = new Scanner(System.in);
        this.clearConsole = () -> {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        };
        this.message = message;
    }

    @Override
    public void execute() {
        this.clearConsole.run();
        System.out.println(this.message.getTitle());
        System.out.println(this.message.getDefaultText());
        this.itens.forEach((i) -> {
            System.out.println(i.getOPTION() + " - " + i.getOPTIONTEXT());
        });
        System.out.print("Escolha uma opção: ");
        Integer choice = this.scanner.nextInt();
        scanner.nextLine();
        executeOption(choice);
    }
    
    @Override
    public abstract void executeOption(Integer choice);
    
}
