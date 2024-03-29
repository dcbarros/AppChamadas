package br.com.professor.service;

import br.com.professor.model.Student;
import br.com.professor.repository.StudentRepository;

public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(){
        this.studentRepository = new StudentRepository();
    }

    public Boolean save(Student request){
        if(request == null) throw new IllegalArgumentException("Estudante não encontrado.");
        if(request.getName() == null || request.getName().isBlank()) throw new IllegalArgumentException("Nome do estudante não pode está vazio.");
        if(request.getStudentCode() == null || request.getStudentCode().isBlank()) throw new IllegalArgumentException("Matrícula do estudante não pode está vazio.");

        Student student = studentRepository.getById(request.getStudentCode());
        
        if(student == null){
            studentRepository.addAtomicTransaction(request);
        }else{
            studentRepository.updateAtomicTransaction(request);
        }
        return true;
    }

    public Student findStudentByStudentCode(String studentCode){
        if(studentCode == null || studentCode.isBlank()) throw new IllegalArgumentException("A matrícula do estudante está inválida");
        return studentRepository.getById(studentCode);
    }
}
