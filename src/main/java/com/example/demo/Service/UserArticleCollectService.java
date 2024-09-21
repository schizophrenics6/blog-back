package com.example.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.Common.ResultJson;
import com.example.demo.entity.mysql.Article;
import com.example.demo.entity.mysql.UserArticleCollect;

public interface UserArticleCollectService extends IService<UserArticleCollect> {

    ResultJson insertcontroller(UserArticleCollect userArticleCollect);

    ResultJson deletcontroller(UserArticleCollect userArticleCollect);

    ResultJson selectcontroller(UserArticleCollect userArticleCollect);
}
