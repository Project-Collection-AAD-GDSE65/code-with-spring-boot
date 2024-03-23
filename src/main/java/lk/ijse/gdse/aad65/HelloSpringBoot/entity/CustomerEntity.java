package lk.ijse.gdse.aad65.HelloSpringBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerEntity implements SuperEntity {
    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
}
