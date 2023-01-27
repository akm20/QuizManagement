package UserQuizManagement.demoUserQuiz.Utils;

import lombok.Data;

@Data
public class Responces {

    private Long question_id;
    private int given_answer;

    public Responces(Long question_id, int given_answer) {
        this.question_id = question_id;
        this.given_answer = given_answer;
    }
}
