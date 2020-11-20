package seg3102.calculatorapi.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class SecurityConfig: WebSecurityConfigurerAdapter() {
  @Throws(Exception::class)
  override fun configure(auth: AuthenticationManagerBuilder) {
    auth.inMemoryAuthentication()
          .passwordEncoder(passwordEncoder())
          .withUser("admin")
          .password(passwordEncoder().encode("adminpass"))
          .roles("ADMIN","USER")
          .and()
          .withUser("user")
          .password(passwordEncoder().encode("userpass"))
          .roles("USER")
  }

  @Throws(java.lang.Exception::class)
  override fun configure(http: HttpSecurity) {
    http.csrf().disable().authorizeRequests().
      antMatchers("/calculator/add/**").hasAnyRole("USER").
      antMatchers("/calculator/subtract/**").hasAnyRole("USER").
      antMatchers("/calculator/multiply/**").hasAnyRole("ADMIN").
      antMatchers("/calculator/divide/**").hasAnyRole("ADMIN").
    and().httpBasic().
    and().requiresChannel().anyRequest()
  }

  @Bean
  fun passwordEncoder(): BCryptPasswordEncoder {
    return BCryptPasswordEncoder()
  }
}