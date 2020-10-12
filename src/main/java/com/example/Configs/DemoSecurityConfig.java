package com.example.Configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(securityDataSource);
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated().and()
//                .formLogin().loginPage("/showCustomLoginForm").loginProcessingUrl("/authThisUser").permitAll();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.anyRequest().authenticated()
                .antMatchers("/").permitAll()  // allow public access to home page
                .antMatchers("/homePage").authenticated()   //*** basic user/any user without roles
                .antMatchers("/employees/**").hasRole("EMPLOYEE")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/showFancyLoginForm").loginProcessingUrl("/authThisUser").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/customAccessDenied")
                .and()
                .logout().logoutSuccessUrl("/").permitAll();
        // after logout then redirect to landing page (root)
    }
}



