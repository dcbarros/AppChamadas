package br.com.professor.view.subjects;

import java.util.Arrays;

import br.com.professor.controller.SubjectController;
import br.com.professor.model.Message;
import br.com.professor.view.components.AbstractMenuView;
import br.com.professor.view.components.MenuItem;


public class SubjectView extends AbstractMenuView{
    
    private SubjectController subjectController;

    public SubjectView() {
        super(Arrays.asList(
                new MenuItem(1, "Adicionar Matéria"),
                new MenuItem(2, "Alterar o nome da matéria pelo código da matéria"),
                new MenuItem(3, "Atribuir estudante a matéria"),
                new MenuItem(4, "Encontrar matéria pelo código da matéria"),
                new MenuItem(5, "Voltar")
            ), new Message("###### Menu - Matérias ######"));
        this.subjectController = new SubjectController();
    }


    @Override
    public void executeOption(Integer choice) {
        switch (choice) {
            case 1 -> {
                this.clearConsole.run();
                Boolean isSave = new SubjectFormView(this.subjectController, this.scanner).execute();
                if(isSave){
                    this.message.setDefaultText("A matéria foi salva no banco, com sucesso!\n");
                }else{
                    this.message.setDefaultText("Ocorreu um problema ao salvar!\n");
                }
            }
            case 2 -> {
                this.clearConsole.run();
                Boolean isSave = new SubjectFormUpdateView(subjectController, scanner).execute();
                if(isSave){
                    this.message.setDefaultText("A matéria foi modificada no banco, com sucesso!\n");
                }else{
                    this.message.setDefaultText("A matéria não foi encontrada na base de dados.");
                }
            }
            case 3 -> {
                this.clearConsole.run();
                Boolean isSave = new AddStudentForm(subjectController, scanner).execute();
                if(isSave){
                    this.message.setDefaultText("Aluno adicionado a matéria com sucesso! \n");
                }else{
                    this.message.setDefaultText("Ocorreu um erro: A Matéria ou O Aluno não foram encontrados no sistema.\n");
                }
            }
            case 4 -> {
                this.clearConsole.run();
                Boolean isSave = new SubjectFindView(subjectController, scanner).execute();
                if(!isSave){
                    this.message.setDefaultText("Matéria não cadastrada no sistema.\n");
                }
            }
            case 5 -> {
                return;
            }
            default -> {
                this.message.setDefaultText(choice + ": Opção não localizada no menu.\n");
            }    
        }
        execute();
    }

}
