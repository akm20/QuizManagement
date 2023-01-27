package UserQuizManagement.demoUserQuiz.Service;

import UserQuizManagement.demoUserQuiz.CustomException;
import UserQuizManagement.demoUserQuiz.Entity.Users;
import UserQuizManagement.demoUserQuiz.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


    public Users updateUser(Users user) throws CustomException{
        Optional<Users> userOptional = userRepository.findById(user.getUser_id());
        if(!userOptional.isPresent()){
            //throw new CustomException();
            throw new CustomException("No such id exists");
        }
//        Optional<User1> user1Optional = userRepository.findById(user1.getId());
        if(user.getUser_name() != null) {
            userOptional.get().setUser_name(user.getUser_name());
        }
        if(user.getUser_phone_no() != null) {
            userOptional.get().setUser_phone_no(user.getUser_phone_no());
        }
        if(user.getUserEmail() != null) {
            userOptional.get().setUserEmail(user.getUserEmail());
        }
        if (user.getDob()!=null){
            userOptional.get().setDob(user.getDob());
        }
        Users user1 = userRepository.save(userOptional.get());
        return user1;


    }
    public Map<String,Boolean> deleteUser(Long user_id) throws CustomException{
        Optional<Users> userOptional = userRepository.findById(user_id);
        if(!userOptional.isPresent()){
            throw new CustomException("User with this id not found");
        }
        userRepository.delete(userOptional.get());
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return response;
    }

}

