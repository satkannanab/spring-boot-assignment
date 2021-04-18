/*
 * Copyright (c) 2021 by Eyefreight BV (www.eyefreight.com). All rights reserved.
 *
 * This software is provided by the copyright holder and contributors "as is" and any express or implied warranties, including, but
 * not limited to, the implied warranties of merchantability and fitness for a particular purpose are disclaimed. In no event shall
 * Eyefreight BV or contributors be liable for any direct, indirect, incidental, special, exemplary, or consequential damages
 * (including, but not limited to, procurement of substitute goods or services; * loss of use, data, or profits; or business
 * interruption) however caused and on any theory of liability, whether in contract, strict liability, or tort (including
 * negligence or otherwise) arising in any way out of the use of this software, even if advised of the possibility of such damage.
 */
package com.my.assignment.app.framework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * Spring configuration class that enables spring security with basic authentication.
 *
 * @author satheesh.arunachalam
 */
@Configuration
@EnableWebSecurity
public class AppSecutiryConfig extends WebSecurityConfigurerAdapter {
  private static final String BASIC_AUTH_REALM_NAME = "Assignment Rest web services";

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.antMatcher("/api/" + "**").authorizeRequests().anyRequest().authenticated().and().httpBasic().realmName(BASIC_AUTH_REALM_NAME).and().csrf()

        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().exceptionHandling();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("user")).authorities("ROLE_USER");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
