package com.ehrsystem.hr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
public class SpringSecConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/index/**", "/product/**", "/checkout", "/docheckout").permitAll()
                .and().authorizeRequests().antMatchers("/login","logout").permitAll()
                .and().authorizeRequests().antMatchers("/static/css/**","/js/**", "/images/**").permitAll()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll()
                .and().logout()
                        .deleteCookies("remove")
                        .invalidateHttpSession(true)
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/logout-success")
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
               ;

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/h2-console/**").permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
