package in.railworld.Cab_Services.Controller;

import in.railworld.Cab_Services.DTOs.NewUserDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    public void addNewUser(@RequestBody NewUserDto newUserDto){

    }
}
