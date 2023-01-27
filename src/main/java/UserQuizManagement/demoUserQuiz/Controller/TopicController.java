package UserQuizManagement.demoUserQuiz.Controller;


import UserQuizManagement.demoUserQuiz.Entity.Topic;
import UserQuizManagement.demoUserQuiz.Service.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subjects")
public class TopicController {

    private TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public List<Topic> getAllSubjects(){
        return topicService.getAllSubjects() ;
    }

    @PostMapping
    public void addSubject(@RequestBody Topic topic){
        topicService.addSubject(topic) ;
    }


}
