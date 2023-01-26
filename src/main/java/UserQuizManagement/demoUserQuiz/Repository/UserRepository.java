package UserQuizManagement.demoUserQuiz.Repository;

import UserQuizManagement.demoUserQuiz.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    public boolean existsByUserEmail(String email);

}
