package in.railworld.Cab_Services.Service;

import in.railworld.Cab_Services.DTOs.NewUserDto;
import in.railworld.Cab_Services.Entity.User;
import in.railworld.Cab_Services.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
}
