package com.example.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.Common.ResultJson;
import com.example.demo.entity.mysql.Followers;
import org.springframework.stereotype.Service;


public interface FollowersService extends IService<Followers> {
    ResultJson insertFollowers(Followers followers);
    ResultJson deleteFollowers(Followers followers);

    ResultJson getFollowers(Followers followers);



}
