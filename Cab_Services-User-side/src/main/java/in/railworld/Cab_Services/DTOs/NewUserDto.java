package in.railworld.Cab_Services.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserDto {

    private String name;
    private String phone;
    private String email;
    private String password;
}
