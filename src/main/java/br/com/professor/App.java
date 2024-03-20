package br.com.professor;

import br.com.professor.infra.AttendanceDAO;
import br.com.professor.infra.StudentDAO;
import br.com.professor.infra.SubjectDAO;

public class App 
{
    public static void main( String[] args )
    {
        StudentDAO sDAO = new StudentDAO();
        SubjectDAO suDAO = new SubjectDAO();
        AttendanceDAO aDAO = new AttendanceDAO();
    }
}
