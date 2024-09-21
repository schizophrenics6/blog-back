package com.example.demo.Service.imp;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.mysql.Account;
import com.example.demo.mapper.Usermapper;
import jakarta.annotation.Resource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeService1 implements AuthenticationProvider {
    @Resource
    Usermapper usermapper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        Account user = usermapper.selectOne(queryWrapper);

        if (user == null)
        {
            System.out.println("尚未注册");
            throw new BadCredentialsException("尚未注册");
        }

        if (!user.getPassword().equals(password))
        {
            System.out.println("密码错误");
            throw new BadCredentialsException("密码错误");
        }

        // 认证成功，创建一个包含用户权限的 UserDetails 对象
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_USER")); // 根据实际情况分配角色
System.out.println("success");
        // 创建一个 Authentication 对象并返回
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}















