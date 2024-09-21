package com.example.demo.Config;
import com.example.demo.Common.ResultJson;
import com.example.demo.Service.imp.AuthorizeService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.IOException;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
return http
        .authorizeHttpRequests(conf->
                 conf
//                         .requestMatchers("/","/posts/**").permitAll()
                         .requestMatchers("/comments/**").authenticated()//评论需登录
                         .anyRequest().permitAll()
                )
        .formLogin(conf->conf
                .loginProcessingUrl("/login")
                .failureHandler(this::onAuthenticationFailure)
                .successHandler(this::onAuthenticationSuccess)
        )
        .logout(conf->conf
                .logoutUrl("/logout")
                .logoutSuccessHandler(this::onLogoutSuccess)
        )
        .cors(conf -> {
            CorsConfiguration cors = new CorsConfiguration();
            //添加前端站点地址，这样就可以告诉浏览器信任了
            cors.addAllowedOrigin("http://localhost:8080");
            //虽然也可以像这样允许所有 cors.addAllowedOriginPattern("*");
            //但是这样并不安全，我们应该只许可给我们信任的站点
            cors.setAllowCredentials(true);  //允许跨域请求中携带Cookie
            cors.addAllowedHeader("*");   //其他的也可以配置，为了方便这里就 * 了
            cors.addAllowedMethod("*");
            cors.addExposedHeader("*");
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", cors);  //直接针对于所有地址生效
            conf.configurationSource(source);
        })

        .csrf(AbstractHttpConfigurer::disable)
        .sessionManagement(conf->conf
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )//jwt
        .build();
    }

public void onAuthenticationSuccess(HttpServletRequest request,
                                    HttpServletResponse response,
                                    Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
    User user=(User) authentication.getPrincipal();
response.getWriter().write(ResultJson.success("success").asJonString());
   response.getWriter().write("success1");
}
public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException execption) throws IOException {
    response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(ResultJson.error( execption.getMessage(),"401" ).asJonString() );
   response.getWriter().write("failure");
}
public void onLogoutSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                      Authentication authentication) throws IOException {
    response.setContentType("application/json;charset=UTF-8");
    User user=(User) authentication.getPrincipal();
    response.getWriter().write(ResultJson.success("TD success").asJonString());
 }
}

















