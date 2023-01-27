package UserQuizManagement.demoUserQuiz.Service;

import UserQuizManagement.demoUserQuiz.Entity.Questions;
import UserQuizManagement.demoUserQuiz.Repository.QuestionRepository;
import UserQuizManagement.demoUserQuiz.Utils.Responces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public void addquestion(Questions question){
        /*
         Recieves: question Object
         Action: Adds question to database
         */

        System.out.println(question);
        questionRepository.save(question);

    }

    public int checkAnswer(Long user_id, List<Responces> responce){
        /*
         Recieves: user_id , responce object array.{question_id,given_ans }
         Action: checks answer and RETURNS marks
         Return marks(int);
         */

        int marks=0;
        return marks;
    }


    public List<Questions> generateQestions(Long SubjectId){
        /*
        Recieves: SubjectId
        Action: Generates (10/20) random questions
        Return: List<Questions>
         */

        return questionRepository.findAll();

    }

}
