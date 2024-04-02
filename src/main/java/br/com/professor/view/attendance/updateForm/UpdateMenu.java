package br.com.professor.view.attendance.updateForm;

import java.util.Arrays;
import java.util.Scanner;

import br.com.professor.controller.AttendanceController;
import br.com.professor.model.Message;
import br.com.professor.view.components.AbstractMenuView;
import br.com.professor.view.components.MenuItem;

public class UpdateMenu extends AbstractMenuView{

    private AttendanceController attendanceController;

    public UpdateMenu(AttendanceController attendanceController) {
        super(
                Arrays.asList(
                new MenuItem(1, "Buscar presenças relacionadas a matéria pelo código"),
                new MenuItem(2, "Atualizar o dia da Aula"),
                new MenuItem(3, "Atualizar os tópicos da aula"),
                new MenuItem(4, "Atualizar a lista de presença da aula"),
                new MenuItem(5, "Voltar")
            ),
            new Message("###### Menu Update da Lista de Presença ######")
        );
        this.attendanceController = attendanceController;
    }

    @Override
    public void executeOption(Integer choice) {
        this.message.setDefaultText("");
        switch (choice) {
            case 1 -> {
                this.clearConsole.run();
                Boolean isSave = new SeachUpdantView(this.attendanceController, this.scanner).execute();
                if(!isSave){
                    this.message.setDefaultText("Código da matéria não encontrado.\n");
                }
            }
            case 2 -> {
                this.clearConsole.run();
                try {
                    new UpdateAttendanceDate(attendanceController, scanner).execute();
                    this.message.setDefaultText("Alteração realizada com sucesso.\n");
                } catch (Exception e) {
                    this.message.setDefaultText(e.getMessage() +"\n");
                }
            }
            case 3 -> {
            try {
                    this.clearConsole.run();
                    new UpdateTopicsView(attendanceController, scanner).execute();
                    this.message.setDefaultText("Alteração das presenças realizada com sucesso.\n");
                } catch (Exception e) {
                    this.message.setDefaultText(e.getMessage() +"\n");
                }
            }
            case 4 -> {
                try {
                    this.clearConsole.run();
                    new UpdatePresencesView(attendanceController, scanner).execute();
                    this.message.setDefaultText("Alteração das presenças realizada com sucesso.\n");
                } catch (Exception e) {
                    this.message.setDefaultText(e.getMessage() +"\n");
                }
            }
            case 5 -> {return;}
            default -> {
                this.message.setDefaultText(choice + ": Opção não localizada no menu.\n");      
            }
        }
        execute();
    }
}
