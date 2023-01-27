package UserQuizManagement.demoUserQuiz.Entity;


import UserQuizManagement.demoUserQuiz.Utils.ScoreId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
@Table(name ="scores")
@IdClass(ScoreId.class)
@NoArgsConstructor
@Getter
@Setter
public class Score {
    @Id
    private Long userId ;

    @Id
    private Long subjectId ;

    @Max(value = 100)
    private Long score ;

    public Score(Long userId, Long studentId, Long score) {
        this.userId = userId;
        this.subjectId= studentId;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "userId=" + userId +
                ", studentId=" + subjectId+
                ", score=" + score +
                '}';
    }
}
