package UserQuizManagement.demoUserQuiz.Service;

import UserQuizManagement.demoUserQuiz.CustomException;
import UserQuizManagement.demoUserQuiz.Entity.Users;
import UserQuizManagement.demoUserQuiz.Repository.UserRepository;
import ch.qos.logback.core.util.COWArrayList;
import org.apache.tomcat.util.buf.CharChunk;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigDecimal;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public List<Users> getUsers(){
        return userRepository.findAll();
    }
    public Users getUserById(Long userId){
        Optional<Users> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent()){

        }
        return userOptional.get();
    }
    
    public Users createNewUser(Users user) throws Exception {
        boolean optional= userRepository.existsByUserEmail(user.getUserEmail());
        if(optional){
            throw new CustomException("Email ID already exists !");
        }
        return userRepository.save(user);
    }
//    public Users loginUser(Users user) throws Exception {
//
//        Optional<Users> usersOptional = userRepository.findByUserEmail(user.getUserEmail());
//        Integer secretKey= 123455;
//        String password = usersOptional.get().getUserPassword();
//        String plainText = decrypt(password,secretKey);
//        if(!plainText.equals(user.getUserPassword())){
//            throw new CustomException("User not Found");
//        }
//        return user;
//    }

    public Users updateUser(Users user) throws CustomException{
        Optional<Users> userOptional = userRepository.findById(user.getUserId());
        if(!userOptional.isPresent()){
            //throw new CustomException();
            throw new CustomException("No such id exists");
        }
//        Optional<User1> user1Optional = userRepository.findById(user1.getId());
        if(user.getUserName() != null) {
            userOptional.get().setUserName(user.getUserName());
        }
        if(user.getUserPhoneNo() != null) {
            userOptional.get().setUserPhoneNo(user.getUserPhoneNo());
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

