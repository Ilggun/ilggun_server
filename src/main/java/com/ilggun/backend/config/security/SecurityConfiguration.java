package com.ilggun.backend.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .httpBasic().disable()      // REST API 이므로 스프링 시큐리티 기본설정(비인증시 로그인 화면으로 리다이렉트됨) 사용안함.
                .csrf().disable()           // REST API 이므로 CSRF 보안이 필요 없음.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)     // JWT 로 인증하므로 세션은 필요없으니 생성 안함.
                .and()
                .authorizeRequests()            // 다음 리퀘스트에 대한 사용권한 체크.
                .antMatchers("/api/v1/signin", "/api/v1/signup").permitAll()              // 가입 및 인증 주소는 누구나 접근 가능.
                .antMatchers(HttpMethod.POST, "/api/v1/data/**").permitAll()     // DATA API 에 접근하는 POST METHOD 는 모두 접근 가능. (개선 필요)
                .antMatchers(HttpMethod.GET, "/api/v1/user").hasRole("ADMIN")
                .anyRequest().hasRole("USER")   // 그 외 나머지 요청은 모두 인증된 회원만 접근 가능
                .and()
                .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint())
                .and()
                // JWT 필터를 ID / PASSWORD 인증 필터 전에 넣는다.
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * API DOCS 는 예외
     * @param webSecurity
     */
    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().antMatchers("/v2/api-docs", "/swagger-resources/**",
                "/swagger-ui.html", "/webjars/**", "/swagger/**");
    }
}
