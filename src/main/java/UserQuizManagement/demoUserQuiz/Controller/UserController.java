package UserQuizManagement.demoUserQuiz.Controller;

import UserQuizManagement.demoUserQuiz.CustomException;
import UserQuizManagement.demoUserQuiz.Entity.Users;
import UserQuizManagement.demoUserQuiz.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PutMapping("/users/{user_id}")
    public ResponseEntity<Users> updateUser(@RequestBody Users user ) throws CustomException {
        Users updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("users/{user_id}")
    public Map<String,Boolean> deleteUsers(@PathVariable(value = "user_id") Long user_id) throws CustomException {
        return userService.deleteUser(user_id);
    }

}
