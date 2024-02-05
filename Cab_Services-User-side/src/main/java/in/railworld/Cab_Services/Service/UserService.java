package in.railworld.Cab_Services.Service;

import in.railworld.Cab_Services.DTOs.NewUserDto;
import in.railworld.Cab_Services.Entity.User;
import in.railworld.Cab_Services.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public ResponseEntity<String> addUser(User newUser){

        if(userRepository.existsById(newUser.getId())){
            return new ResponseEntity<>("User phle se hi h", HttpStatus.ALREADY_REPORTED);
        }

        newUser.setUserBookings(new ArrayList<>());

        userRepository.save(newUser);

        return new ResponseEntity<>("User bna diya", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteByUserId(int id) {
        if(userRepository.existsById(id)==false){
            return new ResponseEntity<>("User nhi mila", HttpStatus.ALREADY_REPORTED);
        }

        userRepository.deleteById(id);
        return new ResponseEntity<>("User hta diya",HttpStatus.GONE);
    }

    public ResponseEntity<String> updatePassword(int id,String oldPassword, String password, String confirm) {
        User user = userRepository.findById(id);
        if(oldPassword==user.getPassword()){
            if(password==confirm){
                user.setPassword(password);
                userRepository.save(user);
            }
        }
        return new ResponseEntity<>("Password change ho gya",HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> updateEmail(int id, String email) {
        User user = userRepository.findById(id);
        user.setPassword(email);
        userRepository.save(user);
        return new ResponseEntity<>("email badal diya",HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> updatePhone(int id, String phone) {
        User user = userRepository.findById(id);
        user.setPassword(phone);
        userRepository.save(user);
        return new ResponseEntity<>("phone number badal gya",HttpStatus.ACCEPTED);
    }
}
