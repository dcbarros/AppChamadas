package br.com.professor.view.student;

import java.util.Arrays;

import br.com.professor.controller.StudentController;
import br.com.professor.model.Message;
import br.com.professor.view.components.AbstractMenuView;
import br.com.professor.view.components.MenuItem;

public class StudentView extends AbstractMenuView{

    private StudentController studentController;

    public StudentView() {
        super(Arrays.asList(
                new MenuItem(1, "Adicionar Estudante"),
                new MenuItem(2, "Alterar o nome do aluno pela Matricula"),
                new MenuItem(3, "Busca Estudante pela sua matrícula"),
                new MenuItem(4, "Voltar")
            ), new Message("###### Menu - Alunos ######"));
        this.studentController = new StudentController();
    }

    @Override
    public void executeOption(Integer choice) {
        switch (choice) {
            case 1 -> {
                this.clearConsole.run();
                Boolean isSave = new StudentFormView(this.studentController, this.scanner).execute();
                if(isSave){
                    this.message.setDefaultText("O Aluno foi salvo no banco, com sucesso!\n");
                }else{
                    this.message.setDefaultText("Ocorreu um problema ao salvar!\n");
                }
            }
            case 2 -> {
                this.clearConsole.run();
                Boolean isSave = new StudentFormUpdateView(this.studentController, this.scanner).execute();
                if(isSave){
                    this.message.setDefaultText("O Aluno foi modificado no banco, com sucesso!\n");
                }else{
                    this.message.setDefaultText("O aluno não foi encontrado na base de dados.");
                }
            }
            case 3 -> {
                this.clearConsole.run();
                Boolean isSave = new StudentFindView(this.studentController, this.scanner).execute();
                if(!isSave){
                    this.message.setDefaultText("O aluno não foi encontrado na base de dados.\n");
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
