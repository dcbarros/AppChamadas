package br.com.professor.infra;

import br.com.professor.model.Student;

public class StudentDAO extends DAO<Student>{
    
    public StudentDAO(){
        super(Student.class);
    }

    @Override
    public Student getById(Object id) {
        Student student = new Student();
        try {
            String studentCode = (String) id;
            if(id == null || studentCode.isBlank()) throw new IllegalArgumentException("matrícula do aluno é inválida");
            student = entityManager.find(Student.class, studentCode);
            if(student == null) throw new NullPointerException("Matrícula não localizada no sistema: " + studentCode);
            return student;
        } catch (ClassCastException e) {
            throw new ClassCastException("Tipo de dado incompatível, a matrícula deve ser uma String");
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro não esperado");
        }
    }
}
