package UserQuizManagement.demoUserQuiz.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;

@Entity
@Table(name = "topics")
@Getter
@Setter
@NoArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subjectId ;

    @Column(unique = true)
    private String subjectName ;
    private final Long noOfQuestions = 25L;
    private final Duration timeDuration = Duration.ofHours(1) ;
    public Topic(String subjectName) {
        this.subjectName = subjectName;
    }

    public Topic(Long subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }
}
