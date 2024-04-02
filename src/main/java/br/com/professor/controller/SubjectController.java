package br.com.professor.controller;

import java.util.List;

import br.com.professor.model.Student;
import br.com.professor.model.Subject;
import br.com.professor.service.SubjectService;

public class SubjectController {
    private SubjectService subjectService;

    public SubjectController() {
        this.subjectService = new SubjectService();
    }

    public Boolean createNewSubject(Subject request){
        return subjectService.save(request);
    }

    public Boolean updateSubjectName(Subject request){
        return subjectService.save(request);
    }

    public Boolean addStudentInSubjectBySubjectCode(String studentCode, String subjectCode){
        return subjectService.addStudentBySubjectCode(studentCode, subjectCode);
    }

    public Subject findSubjectBySubjectCode(String subjectCode){
        return subjectService.getSubjectBySubjectCode(subjectCode);
    }

    public List<Student> getAllStudentEnrolledSubjectBySubjectCode(String subjectCode){
        return subjectService.getAllStudentEnrolledSubjectBySubjectCode(subjectCode);
    }
}
