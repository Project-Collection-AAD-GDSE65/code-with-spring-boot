package lk.ijse.gdse.aad65.HelloSpringBoot.service;

import lk.ijse.gdse.aad65.HelloSpringBoot.dto.UserDTO;
import lk.ijse.gdse.aad65.HelloSpringBoot.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
    void save(UserDTO user);
}
