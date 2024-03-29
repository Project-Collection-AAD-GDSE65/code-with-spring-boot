package lk.ijse.gdse.aad65.HelloSpringBoot.service.impl;

import lk.ijse.gdse.aad65.HelloSpringBoot.service.JWTService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JWTServiceIMPL implements JWTService {
    @Override
    public String extractUsername(String token) {
        return "";
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return "";
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        return false;
    }
}
