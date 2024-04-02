package br.com.professor.repository;

import java.util.List;

import br.com.professor.infra.DAO;
import br.com.professor.model.Attendance;
import jakarta.persistence.TypedQuery;

public class AttendanceRepository extends DAO<Attendance>{
    
    public AttendanceRepository(){
        super(Attendance.class);
    }

    @Override
    public Attendance getById(Object id) {
        
        Attendance attendance = new Attendance();
        try {
            id = (Long) id;
            if(id == null) throw new IllegalArgumentException("matrícula do aluno é inválida");
            attendance = entityManager.find(Attendance.class, id);
            return attendance;
        } catch (ClassCastException e) {
            throw new ClassCastException("Tipo de dado incompatível, o id deve ser um Long");
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro não esperado");
        }
    }

    public List<Attendance> getAll(){
        TypedQuery<Attendance> query = entityManager.createQuery("SELECT e FROM YourEntity e", Attendance.class);
        return query.getResultList();
    }

    public List<Attendance> getAllBySubjectCode(String subjectCode){
        TypedQuery<Attendance> query = entityManager
        .createQuery("SELECT a FROM Attendance a WHERE a.subject.subjectCode = :subjectCode", Attendance.class);
        query.setParameter("subjectCode", subjectCode);
        return query.getResultList();
    }
}
