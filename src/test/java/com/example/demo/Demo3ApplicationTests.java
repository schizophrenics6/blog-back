package com.example.demo;

import com.example.demo.Service.UserService;
import com.example.demo.mapper.Usermapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo3ApplicationTests {
@Resource Usermapper usermapper;
    @Test
    void contextLoads() {
       System.out.println(usermapper.selectById(1));
    }

}
