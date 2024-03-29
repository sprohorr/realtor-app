package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/userpage", "/useredit").access("hasRole('ADMIN') or hasRole('USER')")
                .antMatchers("/adminpage", "/registrationadmin",
                        "/agentpage", "/agentadd", "/agentedit", "/agentlist", "/agenterror",
                        "/apartmentadd", "/apartmentedit", "/apartmentlist", "/apartmenterror", "/apartmentsuccess",
                        "/buildingadd", "/buildingedit", "/buildingapartmentlist", "/buildinglist", "/buildingsuccess").hasRole("ADMIN")
                .antMatchers("/usersuccess").hasRole("USER")
                .antMatchers("/mainpage", "/registration", "/import", "/export").permitAll()
                .and().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/mainpage");
        http
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

}
