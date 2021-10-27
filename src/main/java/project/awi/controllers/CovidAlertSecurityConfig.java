package project.awi.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class CovidAlertSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(final HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers(":login*").permitAll()
                .antMatchers("/static/css/**","/static/js/**","/image/**").permitAll()
                .antMatchers("/index*").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login")
                .loginProcessingUrl("/doLogin")
                .failureUrl("/login?error=true").permitAll()
                .defaultSuccessUrl("/",true);
    }

    /*
    protected void configure( final AuthentificationManagerBuilder auth ) throws Exception {
        auth.inMemoryAuthentification()
                .withUser("bob").password(passwordEncoder())
                .encode("password_de_bob").roles("USER");
    }
    */
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
