package UserQuizManagement.demoUserQuiz.Controller;

import UserQuizManagement.demoUserQuiz.CustomException;
import UserQuizManagement.demoUserQuiz.Entity.Users;
import UserQuizManagement.demoUserQuiz.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<Users> getAllUser(){
        return userService.getUsers();
    }

    @GetMapping("/users/{user_id}")
    public Users getUserById(@PathVariable(value = "user_id") Long user_id ){
        return userService.getUserById(user_id);
    }

    @PostMapping("/users")
    public Users createUser(@RequestBody Users user) throws CustomException {
        return userService.createNewUser(user);
    }

}
