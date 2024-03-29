package lk.ijse.gdse.aad65.HelloSpringBoot.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad65.HelloSpringBoot.dao.UserRepo;
import lk.ijse.gdse.aad65.HelloSpringBoot.dto.UserDTO;
import lk.ijse.gdse.aad65.HelloSpringBoot.service.UserService;
import lk.ijse.gdse.aad65.HelloSpringBoot.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {
    private final UserRepo userRepo;
    private final Mapping map;
    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                userRepo.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public void save(UserDTO user) {
        map.toUserDTO(userRepo.save(map.toUserEntity(user)));
    }
}
