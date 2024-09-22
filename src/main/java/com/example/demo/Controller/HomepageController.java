package com.example.demo.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Common.ResultJson;
import com.example.demo.entity.mysql.Article;
import com.example.demo.mapper.Articlemapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomepageController {
    @Resource
    Articlemapper articlemapper;

    @PostMapping("/Homepage")
    @ResponseBody
    public ResultJson Homepage() {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("likes"); // 按收藏数降序排序
        List<Article> hotArticles = articlemapper.selectList(queryWrapper);
        return ResultJson.success(hotArticles);
    }
}
