package br.com.professor;

import java.util.ArrayList;
import java.util.List;

import br.com.professor.infra.StudentDAO;
import br.com.professor.infra.SubjectDAO;
import br.com.professor.model.Student;
import br.com.professor.model.Subject;

public class App 
{
    public static void main( String[] args )
    {
        StudentDAO sDAO = new StudentDAO();
        SubjectDAO suDAO = new SubjectDAO();

        List<Student> teste = suDAO.getStudentsBySubjectCode("123A");
        teste.stream().forEach(e -> System.out.println(e.getName()));
    }
}
