package br.com.professor.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.hibernate.ObjectNotFoundException;

import br.com.professor.model.Student;
import br.com.professor.model.Subject;
import br.com.professor.repository.StudentRepository;
import br.com.professor.repository.SubjectRepository;

public class SubjectService {

    private SubjectRepository subjectRepository;
    private StudentRepository studentRepository;

    public SubjectService(){
        this.subjectRepository = new SubjectRepository();
        this.studentRepository = new StudentRepository();
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

    public boolean addStudentBySubjectCode(String studentCode, String subjectCode){

        if(subjectCode == null || subjectCode.isBlank()) throw new IllegalArgumentException("O Código da matéria está inválida");
        if(studentCode == null || studentCode.isBlank()) throw new IllegalArgumentException("A Matrícula do estudante está inválida");
        
        Student student = studentRepository.getById(studentCode);
        Subject subject = subjectRepository.getById(subjectCode);

        if(student == null) throw new NoSuchElementException("O Estudante deve ser cadastrado no sistema");
        if(subject == null) throw new NoSuchElementException("A Matéria deve ser cadastrada no sistema");

        Set<Student> students = new HashSet<>(subject.getStudents());
        students.add(student);
        subject.setStudents(new ArrayList<>(students));
        this.save(subject);
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
