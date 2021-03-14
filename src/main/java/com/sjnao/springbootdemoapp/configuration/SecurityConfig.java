package com.sjnao.springbootdemoapp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/swagger-ui.html");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        // .and() more rules

        // enables h2-console in browser
        http.headers().frameOptions().sameOrigin();
    }
}
