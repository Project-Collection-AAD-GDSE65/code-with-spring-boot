package lk.ijse.gdse.aad65.HelloSpringBoot.service.impl;

import lk.ijse.gdse.aad65.HelloSpringBoot.dao.UserRepo;
import lk.ijse.gdse.aad65.HelloSpringBoot.dto.UserDTO;
import lk.ijse.gdse.aad65.HelloSpringBoot.entity.Role;
import lk.ijse.gdse.aad65.HelloSpringBoot.entity.UserEntity;
import lk.ijse.gdse.aad65.HelloSpringBoot.reqAndresp.response.JwtAuthResponse;
import lk.ijse.gdse.aad65.HelloSpringBoot.reqAndresp.secure.SignIn;
import lk.ijse.gdse.aad65.HelloSpringBoot.reqAndresp.secure.SignUp;
import lk.ijse.gdse.aad65.HelloSpringBoot.service.AuthenticationService;
import lk.ijse.gdse.aad65.HelloSpringBoot.service.JWTService;
import lk.ijse.gdse.aad65.HelloSpringBoot.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceIMPL implements AuthenticationService {
    private final UserRepo userRepo;
    private final JWTService jwtService;
    private final Mapping mapping;
    //utils
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword()));
        var userByEmail = userRepo.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
       var generatedToken = jwtService.generateToken(userByEmail);
       return JwtAuthResponse.builder().token(generatedToken).build() ;
    }

    @Override
    public JwtAuthResponse signUp(SignUp signUp) {
        var buildUser = UserDTO.builder()
                .id(UUID.randomUUID().toString())
                .email(signUp.getEmail())
                .firstName(signUp.getFirstName())
                .lastName(signUp.getLastName())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(Role.valueOf(signUp.getRole()))
                .build();
        var savedUser = userRepo.save(mapping.toUserEntity(buildUser));
        var genToken = jwtService.generateToken(savedUser);
        return JwtAuthResponse.builder().token(genToken).build();
    }

    @Override
    public JwtAuthResponse refreshToken(String accessToken) {
        var userName = jwtService.extractUsername(accessToken);
        var userEntity = userRepo.findByEmail(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var refreshToken = jwtService.generateToken(userEntity);
        return JwtAuthResponse.builder().token(refreshToken).build();
    }
}
