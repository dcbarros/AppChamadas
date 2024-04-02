package br.com.professor.view.attendance;

import java.util.Arrays;

import br.com.professor.controller.AttendanceController;
import br.com.professor.controller.SubjectController;
import br.com.professor.model.Message;
import br.com.professor.view.attendance.updateForm.UpdateMenu;
import br.com.professor.view.components.AbstractMenuView;
import br.com.professor.view.components.MenuItem;
import br.com.professor.view.subjects.AddStudentForm;
import br.com.professor.view.subjects.SubjectFindView;
import br.com.professor.view.subjects.SubjectFormUpdateView;
import br.com.professor.view.subjects.SubjectFormView;

public class AttendanceView extends AbstractMenuView{
    private SubjectController subjectController;
    private AttendanceController attendanceController;

    public AttendanceView() {
        super(Arrays.asList(
                new MenuItem(1, "Cria registro de presença"),
                new MenuItem(2, "Atualizar registros de presenças"),
                new MenuItem(3, "Encontrar matéria pelo código da matéria"),
                new MenuItem(4, "Voltar")
            ), new Message("###### Menu - Presenças ######"));
        this.attendanceController = new AttendanceController();
        this.subjectController = new SubjectController();
    }

    @Override
    public void executeOption(Integer choice) {
        switch (choice) {
            case 1 -> {
                this.clearConsole.run();
                Boolean isSave = new AttendanceForm(scanner, attendanceController, subjectController).execute();
                if(isSave){
                    this.message.setDefaultText("O registro de presença foi adicionado com sucesso, com sucesso!\n");
                }else{
                    this.message.setDefaultText("Ocorreu um problema ao salvar!\n");
                }
            }
            case 2 -> {
                this.clearConsole.run();
                new UpdateMenu(this.attendanceController).execute();
            }
            case 3 -> {
                this.clearConsole.run();
                Boolean isSave = true;
                if(!isSave){
                    this.message.setDefaultText("Matéria não cadastrada no sistema.\n");
                }
            }
            case 4 -> {
                return;
            }
            default -> {
                this.message.setDefaultText(choice + ": Opção não localizada no menu.\n");
            }    
        }
        execute();
    }
    
}
