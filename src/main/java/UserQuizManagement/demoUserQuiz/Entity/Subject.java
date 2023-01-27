package QuizSystem.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;

@Entity
@Table(name = "subjects")
@Getter
@Setter
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subjectId ;

    @Column(unique = true)
    private String subjectName ;
    private final Long noOfQuestions = 25L;
    private final Duration timeDuration = Duration.ofHours(1) ;
    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public Subject(Long subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }
}
