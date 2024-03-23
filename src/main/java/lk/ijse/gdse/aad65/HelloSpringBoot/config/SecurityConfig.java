package lk.ijse.gdse.aad65.HelloSpringBoot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
   SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http.csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests()
               .anyRequest().authenticated()
               .and()
               .httpBasic();
               return http.build();
   }
   @Bean
   public InMemoryUserDetailsManager userDetailsManager(){
       UserDetails buildUser = User.withDefaultPasswordEncoder()
               .username("kamal")
               .password("1234")
               .roles("USER").build();
       return new InMemoryUserDetailsManager(buildUser);
   }
}
