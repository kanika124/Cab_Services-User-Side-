package in.railworld.Cab_Services.Controller;

import in.railworld.Cab_Services.DTOs.NewUserDto;
import in.railworld.Cab_Services.Entity.User;
import in.railworld.Cab_Services.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/add")
    public String addNewUser(@RequestBody User user) throws Exception{
        try{
            userService.addUser(user);
        }
        catch (Exception e){
            return e.getMessage();
        }
        return null;
    }
}
