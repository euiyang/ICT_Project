package com.example.ict.config;
import com.example.ict.jwt.JwtAccessDeniedHandler;
import com.example.ict.jwt.JwtAuthenticationEntryPoint;
import com.example.ict.jwt.JwtSecurityConfig;
import com.example.ict.jwt.TokenProvider;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    public SecurityConfig(TokenProvider tokenProvider, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtAccessDeniedHandler jwtAccessDeniedHandler) {
        this.tokenProvider = tokenProvider;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf().disable()//csrf: 사용자의 의지와 무관하게 요청하게 하는 공격

                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)// 세션을 사용하지 않기에 stateless

                .and()
                .authorizeRequests() //HttpServletRequest를 사용하는 요청들에 대한 접근 제한
                .antMatchers("/api/hello").permitAll() // /api/hello에 대한 요청은 인증없이 허용
                .antMatchers("/api/authenticate").permitAll()
                .anyRequest().authenticated() //나머지는 모두 인증 적용

                .and()
                .apply(new JwtSecurityConfig(tokenProvider));

        return httpSecurity.build();
    }

}
