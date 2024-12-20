package in.railworld.Cab_Services.Service;

import in.railworld.Cab_Services.DTOs.NewUserDto;
import in.railworld.Cab_Services.Entity.User;
import in.railworld.Cab_Services.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class  UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private JavaMailSender emailSender;
    public ResponseEntity<String> addUser(User newUser){

        if(userRepository.existsById(newUser.getId())){
            return new ResponseEntity<>("User phle se hi h", HttpStatus.ALREADY_REPORTED);
        }

        newUser.setUserBookings(new ArrayList<>());

        userRepository.save(newUser);

        sendEmail(newUser.getEmail(), "Account Created", "aap add kr liye gye hain");

        return new ResponseEntity<>("User bna diya", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteByUserId(int id) {
        try{
        if(userRepository.existsById(id)==false){
            return new ResponseEntity<>("User nhi mila", HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(id);}
        catch(Exception e){

        }
        return new ResponseEntity<>("User hta diya",HttpStatus.GONE);
    }

    public ResponseEntity<String> updatePassword(int id,String oldPassword, String password, String confirm) throws Exception {
        if(!userRepository.existsById(id)){
            throw new Exception("nhi mila");
        }
            User user = userRepository.findById(id);
            if (oldPassword == user.getPassword()) {
                if (password == confirm) {
                    user.setPassword(password);
                    userRepository.save(user);
                }
            }

        return new ResponseEntity<>("Password change ho gya",HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> updateEmail(int id, String email) throws Exception{
        if(!userRepository.existsById(id)){
            throw new Exception("User h hi nhi");
        }

        User currUser = userRepository.findById(id);
        currUser.setEmail(email);
        userRepository.save(currUser);

        return new ResponseEntity<>("Email badal diya",HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> updatePhone(int id, String phone) throws Exception {
      if(!userRepository.existsById(id)){
          throw new Exception("nhi mila");
      }
        User user = userRepository.findById(id);
        user.setPassword(phone);
        userRepository.save(user);

        return new ResponseEntity<>("phone number badal gya",HttpStatus.ACCEPTED);
    }

    private void sendEmail(String receiver, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sender_email_id");
        message.setTo(receiver);
        message.setSubject(subject);
        message.setText(body);
        emailSender.send(message);
    }
}