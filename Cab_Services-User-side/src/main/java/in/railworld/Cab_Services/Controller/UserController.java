package in.railworld.Cab_Services.Controller;

import in.railworld.Cab_Services.DTOs.NewUserDto;
import in.railworld.Cab_Services.Entity.User;
import in.railworld.Cab_Services.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("/del_user/{}")
    public String removeUser(@PathVariable int id){
        try{
            userService.deleteByUserId(id);
        }
        catch(Exception e){
            return e.getMessage();
        }
        return null;
    }
    @PutMapping("/")
    public String updatePhone(@PathVariable int id, @RequestParam String phone){
        try{
            userService.updatePhone(id,phone);
        }
        catch(Exception e){
            return e.getMessage();
        }
        return null;

    }
    @PutMapping("/")
    public String updateEmail(@PathVariable int id, @RequestParam String email){
        try{
            userService.updateEmail(id,email);
        }
        catch(Exception e){
            return e.getMessage();
        }
        return null;

    }
    @PutMapping("/")
    public String updatePassword(@PathVariable int id,@RequestParam String oldPassword, @RequestParam String password,@RequestParam String confirm){
        try{
            userService.updatePassword(id,oldPassword, password,confirm);
        }
        catch(Exception e){
            return e.getMessage();
        }
        return null;

    }

}
