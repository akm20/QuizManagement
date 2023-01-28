package UserQuizManagement.demoUserQuiz.Service;

import UserQuizManagement.demoUserQuiz.CustomException;
import UserQuizManagement.demoUserQuiz.Entity.Questions;
import UserQuizManagement.demoUserQuiz.Repository.QuestionRepository;
import UserQuizManagement.demoUserQuiz.Utils.Responces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public void addquestion(Questions question){
        /*
         Recieves: question Object
         Action: Adds question to database
         */
        if(question.getCorrectAnswer()<1 || question.getCorrectAnswer()>4 ){
            throw new IllegalStateException("Answer should be between 1-4");
        }

        System.out.println(question);
        questionRepository.save(question);

    }

    public int checkAnswer(Long user_id, List<Responces> responces)  {
        /*
         Recieves: user_id , responce object array.{question_id,given_ans }
         Action: checks answer and RETURNS marks.
         Return marks(int);
         */
        int marks=0;

        for (Responces responce1 : responces) {
            //System.out.println(responce1.getQuestion_id()+" "+responce1.getGiven_answer());

            List<Integer> q1 = questionRepository.findByquestionId(responce1.getQuestion_id());

            Integer answer= q1.get(0);

            if(answer==responce1.getGiven_answer()){
                marks++;
            }

        }

        System.out.println();
        return marks;
    }


    public List<Questions> generateQestions(Long SubjectId){
        /*
        Recieves: SubjectId
        Action: Generates (10/20) random questions
        Return: List<Questions>
         */

        return questionRepository.findBysubjectId(SubjectId);

    }

    public List<Questions> getAllQuestions() {
        return  questionRepository.findAll();
    }
}
