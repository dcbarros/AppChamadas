package br.com.professor.infra;

import java.util.List;

import br.com.professor.model.StudentPresence;
import jakarta.persistence.TypedQuery;

public class StudentPresenceDAO extends DAO<StudentPresence>{

    public StudentPresenceDAO(){
        super(StudentPresence.class);
    }

    @Override
    public StudentPresence getById(Object id) {
        StudentPresence studentPresence = new StudentPresence();
        try {
            id = (Long) id;
            if(id == null) throw new IllegalArgumentException("matrícula do aluno é inválida");
            studentPresence = entityManager.find(StudentPresence.class, id);
            if(studentPresence == null) throw new NullPointerException("Id não localizada no sistema: " + id);
            return studentPresence;
        } catch (ClassCastException e) {
            throw new ClassCastException("Tipo de dado incompatível, o id deve ser um Long");
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro não esperado");
        }
    }

    public List<StudentPresence> getAllPresenceByAttendanceId(Long attendanceId){
        if(attendanceId == null) throw new IllegalArgumentException("O id não pode ser nulo.");
        TypedQuery<StudentPresence> query = entityManager.createQuery(
                "SELECT sp FROM StudentPresence sp WHERE sp.attendance.id = :attendanceId",
                StudentPresence.class);
        query.setParameter("attendanceId", attendanceId);
        return query.getResultList();
    }
    
}
