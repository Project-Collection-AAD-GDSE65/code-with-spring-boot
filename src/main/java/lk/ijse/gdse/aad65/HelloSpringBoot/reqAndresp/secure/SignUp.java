package lk.ijse.gdse.aad65.HelloSpringBoot.reqAndresp.secure;


import lk.ijse.gdse.aad65.HelloSpringBoot.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SignUp {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
}
