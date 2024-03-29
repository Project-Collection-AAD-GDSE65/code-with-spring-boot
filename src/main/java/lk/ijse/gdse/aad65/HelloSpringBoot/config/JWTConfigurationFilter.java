package lk.ijse.gdse.aad65.HelloSpringBoot.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.aad65.HelloSpringBoot.service.JWTService;
import lk.ijse.gdse.aad65.HelloSpringBoot.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Enumeration;

@Configuration
@RequiredArgsConstructor
public class JWTConfigurationFilter extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final UserService userService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
           final String userEmail;
           final  String jwt;
           final String authorizationHeader = request.getHeader("Authorization");

           //validation - Get Auth Header status
         if(StringUtils.isEmpty(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")) {
             filterChain.doFilter(request,response);
             return;
         }
         jwt = authorizationHeader.substring(7);
         userEmail = jwtService.extractUsername(jwt);

         //validation - Email validation and status of SecurityContextHolder
        if(StringUtils.isNotEmpty(userEmail) && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails =
                    userService.userDetailsService().loadUserByUsername(userEmail);
            //Validation of Token Status
            if(jwtService.isTokenValid(jwt, userDetails)) {
                SecurityContext emptyContext =
                        SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                emptyContext.setAuthentication(authToken);
                SecurityContextHolder.setContext(emptyContext);
            }
        }
        filterChain.doFilter(request,response);
    }
}
