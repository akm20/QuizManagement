package UserQuizManagement.demoUserQuiz.Controller;


import QuizSystem.Entity.Subject;

import UserQuizManagement.demoUserQuiz.Service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subjects")
public class SubjectController {

    private SubjectService subjectService ;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects() ;
    }

    @PostMapping
    public void addSubject(@RequestBody Subject subject){
        subjectService.addSubject(subject) ;
    }


}
