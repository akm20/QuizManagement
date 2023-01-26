package UserQuizManagement.demoUserQuiz.Service;

import UserQuizManagement.demoUserQuiz.CustomException;
import UserQuizManagement.demoUserQuiz.Entity.Users;
import UserQuizManagement.demoUserQuiz.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public List<Users> getUsers(){
        return userRepository.findAll();
    }
    public Users getUserById(Long user_id){
        Optional<Users> userOptional = userRepository.findById(user_id);
        if(!userOptional.isPresent()){

        }
        return userOptional.get();
    }


    public Users createNewUser(Users user) throws CustomException {
        boolean optional= userRepository.existsByUserEmail(user.getUserEmail());
        if(optional){
            throw new CustomException("Email ID already exists !");
        }
        return userRepository.save(user);
    }
}
