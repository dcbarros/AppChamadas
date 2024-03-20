package br.com.professor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.professor.infra.AttendanceDAO;
import br.com.professor.infra.StudentDAO;
import br.com.professor.infra.StudentPresenceDAO;
import br.com.professor.infra.SubjectDAO;
import br.com.professor.model.Attendance;
import br.com.professor.model.Student;
import br.com.professor.model.StudentPresence;

public class App 
{
    public static void main( String[] args )
    {
        StudentDAO sDAO = new StudentDAO();
        SubjectDAO suDAO = new SubjectDAO();
        AttendanceDAO aDAO = new AttendanceDAO();
        StudentPresenceDAO spDAO = new StudentPresenceDAO();
    }
}
