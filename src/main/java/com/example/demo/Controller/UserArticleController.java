package com.example.demo.Controller;

import com.example.demo.Common.ResultJson;
import com.example.demo.Service.imp.ArticleServiceImpl;
import com.example.demo.entity.mysql.Article;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserArticleController {

@Resource
ArticleServiceImpl articleSerive;

@PostMapping("/Article/insert")
@ResponseBody
    public ResultJson insertArticle(@RequestBody Article article) {
return articleSerive.insertArticle(article);
}
    @DeleteMapping("/Article/delete")
    @ResponseBody
    public ResultJson deleteArticle(@RequestBody Article article) {
return articleSerive.deleteArticle(article);
    }
    @PutMapping("/Article/update")
    @ResponseBody
    public ResultJson updateArticle(@RequestBody Article article) {
return articleSerive.updateArticle(article);
    }
    @GetMapping("/Article/select")
    @ResponseBody
    public ResultJson getAllArticles(@RequestBody Article article) {
        return articleSerive.selectArticle(article);
    }
}
