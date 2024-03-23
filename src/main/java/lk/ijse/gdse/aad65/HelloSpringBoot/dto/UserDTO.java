package lk.ijse.gdse.aad65.HelloSpringBoot.dto;

import lk.ijse.gdse.aad65.HelloSpringBoot.entity.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
