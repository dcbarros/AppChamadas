package br.com.professor.controller;

import br.com.professor.model.Student;
import br.com.professor.service.StudentService;

public class StudentController {
    private StudentService studentService;

    public StudentController() {
        this.studentService = new StudentService();
    }
    
    public Boolean createNewStudent(Student request){
        return studentService.save(request);
    } 

    public Student findStudentByStudentCode(String code){
        return studentService.findStudentByStudentCode(code);
    }

    public Boolean updateStudentName(Student request){
        return studentService.save(request);
    }
}
