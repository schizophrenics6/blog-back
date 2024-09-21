package com.example.demo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//只需要添加Configuration用于注册配置类，不需要其他任何注解，已经自动配置好了
@Configuration
public class WebConfiguration implements WebMvcConfigurer {


}
