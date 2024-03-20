package br.com.professor.infra;

import br.com.professor.model.Attendance;

public class AttendanceDAO extends DAO<Attendance>{
    
    public AttendanceDAO(){
        super(Attendance.class);
    }

    @Override
    public Attendance getById(Object id) {
        
        Attendance attendance = new Attendance();
        try {
            id = (Long) id;
            if(id == null) throw new IllegalArgumentException("matrícula do aluno é inválida");
            attendance = entityManager.find(Attendance.class, id);
            if(attendance == null) throw new NullPointerException("Id não localizada no sistema: " + id);
            return attendance;
        } catch (ClassCastException e) {
            throw new ClassCastException("Tipo de dado incompatível, o id deve ser um Long");
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro não esperado");
        }
    }
}
