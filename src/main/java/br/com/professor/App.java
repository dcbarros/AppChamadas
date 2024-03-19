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

        List<Student> teste = suDAO.getStudentsBySubjectCode("12345AA");

        teste.stream().forEach(e -> System.out.printf("%s - %s\n", e.getStudentCode(), e.getName()));

        // Student s1 = sDAO.getById("123A");
        // Student s2 = sDAO.getById("123B");
        // Student s3 = sDAO.getById("123C");
        // // Student s1 = new Student("123A", "Jairo");
        // // Student s2 = new Student("123B", "Cleiton");
        // // Student s3 = new Student("123C", "Jeremias");

        // List<Student> teste1 = new ArrayList<>();
        // teste1.add(s1);
        // teste1.add(s2);
        // teste1.add(s3);
        // List<Student> teste2 = new ArrayList<>();
        // teste2.add(s1);
        // teste2.add(s2);

        // Subject sub1 = suDAO.getById("12345AB");
        // sub1.setStudents(teste1);
        // suDAO.updateAtomicTransaction(sub1);
        // Subject sub2 = suDAO.getById("12345AC");
        // sub2.setStudents(teste2);
        // suDAO.updateAtomicTransaction(sub2);

        // // sDAO.startTransaction()
        // //     .addTransaction(s1)
        // //     .addTransaction(s2)
        // //     .addTransaction(s3)
        // //     .commitTransaction();
    }
}
