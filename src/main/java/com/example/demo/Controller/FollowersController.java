package com.example.demo.Controller;

import com.example.demo.Common.ResultJson;
import com.example.demo.Service.FollowersService;
import com.example.demo.Service.HistoryService;
import com.example.demo.Service.imp.FollowersServiceImpl;
import com.example.demo.entity.mysql.Followers;
import com.example.demo.entity.mysql.History;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FollowersController {
    @Resource
    FollowersServiceImpl followersServiceImpl;


    @PostMapping("/Followers/insert")
    @ResponseBody
    public ResultJson insertHistory(@RequestBody Followers followers)
    {
        return followersServiceImpl.insertFollowers(followers);
    }

    @DeleteMapping("/Followers/delete")
    @ResponseBody
    public ResultJson deleteHistory(@RequestBody Followers followers) {
        return followersServiceImpl.deleteFollowers(followers);
    }

    @GetMapping("/Followers/select")
    @ResponseBody
    public ResultJson selectHistory(@RequestBody Followers followers) {
        return followersServiceImpl.getFollowers(followers);
    }
}
