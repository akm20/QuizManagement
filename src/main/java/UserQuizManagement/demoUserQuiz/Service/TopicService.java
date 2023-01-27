package UserQuizManagement.demoUserQuiz.Service;

import UserQuizManagement.demoUserQuiz.Entity.Topic;
import UserQuizManagement.demoUserQuiz.Repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    private final TopicRepository topicRepository;


    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getAllSubjects() {
        return topicRepository.findAll() ;
    }

    public void addSubject(Topic topic) {
        topicRepository.save(topic) ;
    }
}
