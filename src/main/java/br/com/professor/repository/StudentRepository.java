package br.com.professor.repository;

import br.com.professor.infra.DAO;
import br.com.professor.model.Student;

public class StudentRepository extends DAO<Student>{
    
    public StudentRepository(){
        super(Student.class);
    }

    @Override
    public Student getById(Object id) {
        Student student = new Student();
        try {
            String studentCode = (String) id;
            if(id == null || studentCode.isBlank()) throw new IllegalArgumentException("matrícula do aluno é inválida");
            student = entityManager.find(Student.class, studentCode);
            return student;
        } catch (ClassCastException e) {
            throw new ClassCastException("Tipo de dado incompatível, a matrícula deve ser uma String");
        }
    }
}
