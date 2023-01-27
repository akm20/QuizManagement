package UserQuizManagement.demoUserQuiz.Controller;


import UserQuizManagement.demoUserQuiz.Entity.Questions;
import UserQuizManagement.demoUserQuiz.Service.QuestionService;
import UserQuizManagement.demoUserQuiz.Utils.Responces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public void addQuestion(@RequestBody Questions question){
        questionService.addquestion(question);
        //System.out.println(question);
    }

    @GetMapping(path="/checkanswers")
    public int checkAnswers(){

        Long user_id=null;
        Responces res= null;

        int marks =questionService.checkAnswer(user_id, Arrays.asList(res));
        return marks;
    }

    @GetMapping
    public List<Questions> getQuestions(){
        Long subject_id=1l;

        return questionService.generateQestions(subject_id);
    }



}
