package org.perscholas.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /*
    1. filtering config
    2. in memory auth
    3. Principal definition
    4. hashing type
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    }
}
