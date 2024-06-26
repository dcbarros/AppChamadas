package br.com.professor.repository;

import java.util.List;

import br.com.professor.infra.DAO;
import br.com.professor.model.Student;
import br.com.professor.model.Subject;
import jakarta.persistence.TypedQuery;

public class SubjectRepository extends DAO<Subject>{
    
    public SubjectRepository(){
        super(Subject.class);
    }

    @Override
    public Subject getById(Object id) {
        Subject subject = new Subject();
        try {
            String subjectCode = (String) id;
            if(id == null || subjectCode.isBlank()) throw new IllegalArgumentException("O código da matéria é inválida");
            subject = entityManager.find(Subject.class, subjectCode);
            return subject;
        } catch (ClassCastException e) {
            throw new ClassCastException("Tipo de dado incompatível, o código da matéria deve ser uma String");
        }
    }

    public List<Student> getStudentsBySubjectCode(String subjectCode){
        try {
            if(subjectCode == null || subjectCode.isBlank()) throw new IllegalArgumentException("Código da matéria inválido");
            return entityManager.createQuery("SELECT s FROM Student s JOIN s.subjects subj WHERE subj.subjectCode = :subjectCode", Student.class)
                .setParameter("subjectCode", subjectCode)
                .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro não esperado");
        }
    }
    
}
