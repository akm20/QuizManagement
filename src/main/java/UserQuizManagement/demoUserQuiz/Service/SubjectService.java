package UserQuizManagement.demoUserQuiz.Service;

import QuizSystem.Entity.Subject;

import UserQuizManagement.demoUserQuiz.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository ;


    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll() ;
    }

    public void addSubject(Subject subject) {
        subjectRepository.save(subject) ;
    }
}
