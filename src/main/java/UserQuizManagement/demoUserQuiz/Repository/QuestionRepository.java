package UserQuizManagement.demoUserQuiz.Repository;

import UserQuizManagement.demoUserQuiz.Entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Questions,Long> {
}
