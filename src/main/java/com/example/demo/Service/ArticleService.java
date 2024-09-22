package com.example.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.Common.ResultJson;
import com.example.demo.entity.mysql.Account;
import com.example.demo.entity.mysql.Article;

public interface ArticleService extends IService<Article> {



    ResultJson insertArticle(Article article);

    ResultJson updateArticle(Article article);

    ResultJson deleteArticle(Article article);

    ResultJson selectArticle(Article article);
    ResultJson updatetop(Article article);

}
