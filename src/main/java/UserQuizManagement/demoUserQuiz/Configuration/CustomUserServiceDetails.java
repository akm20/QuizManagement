package UserQuizManagement.demoUserQuiz.Configuration;

import UserQuizManagement.demoUserQuiz.CustomException;
import UserQuizManagement.demoUserQuiz.Entity.Users;
import UserQuizManagement.demoUserQuiz.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomUserServiceDetails implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByUserEmail(userEmail);
        CustomUserDetails userDetails=null;
        if (user!=null){
            userDetails=new CustomUserDetails();
            userDetails.setUsers(user.get());
        }
        else {
            throw new UsernameNotFoundException("User Not Found");
        }

        return userDetails;
    }
}
