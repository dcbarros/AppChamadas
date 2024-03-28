package br.com.professor.service;

import java.util.List;

import br.com.professor.model.Student;
import br.com.professor.model.Subject;
import br.com.professor.repository.SubjectRepository;

public class SubjectService {

    SubjectRepository subjectRepository;

    public SubjectService(){
        this.subjectRepository = new SubjectRepository();
    }

    public boolean save(Subject request){
        if(request == null) throw new IllegalArgumentException("Estudante não encontrado.");
        if(request.getName() == null || request.getName().isBlank()) throw new IllegalArgumentException("Nome da matéria não pode está vazio.");
        if(request.getSubjectCode() == null || request.getSubjectCode().isBlank()) throw new IllegalArgumentException("Código da matéria não pode está vazio.");        
        
        Subject subject = subjectRepository.getById(request.getSubjectCode());

        if(subject == null){
            subjectRepository.addAtomicTransaction(request);
        }else{
            subjectRepository.updateAtomicTransaction(request);
        }
        return true;
    }

    public Subject getSubjectBySubjectCode(String subjectCode){
        if(subjectCode == null || subjectCode.isBlank()) throw new IllegalArgumentException("O Código da matéria está inválida");
        return subjectRepository.getById(subjectCode);
    }

    public List<Student> getAllStudentEnrolledSubjectBySubjectCode(String subjectCode){
        if(subjectCode == null || subjectCode.isBlank()) throw new IllegalArgumentException("O Código da matéria está inválida");
        return subjectRepository.getStudentsBySubjectCode(subjectCode);
    }
}
