package UserQuizManagement.demoUserQuiz.Repository;

import QuizSystem.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
