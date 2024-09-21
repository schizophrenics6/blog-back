//package com.example.demo.utils;
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//@Component
//public class JwtUtils {
//@Value("${spring.security.jwt.key}")
//String key;
//public String createJwt(UserDetails Details)
//{
//    Algorithm algorithm = Algorithm.HMAC256(key);
//    return JWT.create()
//            .withClaim("id",id)
//            .withClaim("name",username)
//}
//
//
//}
