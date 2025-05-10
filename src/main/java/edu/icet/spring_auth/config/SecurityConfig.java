package edu.icet.spring_auth.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.PasswordManagementDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        auth ->auth
                                .requestMatchers("/public/**").permitAll()
                                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        return  http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
          UserDetails user= User
                .withUsername("saman")
                .password(encoder.encode("saman1234"))
                .roles("USER")
                .build();


          UserDetails admin = User
                  .withUsername("admin")
                  .password(encoder.encode("admin123"))
                  .roles("ADMIN")
                  .build();

          UserDetails manager = User
                  .withUsername("manager")
                  .password(encoder.encode("manager123"))
                  .roles("MANAGER")
                  .build();

          UserDetails employee = User
                  .withUsername("employee")
                  .password(encoder.encode("employee123"))
                  .roles("EMPLOYEE")
                  .build();
          UserDetails supervisor = User
                  .withUsername("supervisor")
                  .password(encoder.encode("super123"))
                  .roles("SUPERVISOR")
                  .build();

        return new InMemoryUserDetailsManager(user , admin ,manager,supervisor,employee);
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
