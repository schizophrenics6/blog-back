package com.example.demo.Controller;
import com.example.demo.Common.ResultJson;
import com.example.demo.Service.UserArticleCollectService;
import com.example.demo.Service.imp.UserArticleCollectServiceImpl;
import com.example.demo.entity.mysql.Article;
import com.example.demo.entity.mysql.UserArticleCollect;
import com.example.demo.mapper.UserArticleCollectmapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
@RestController
public class UserArticleCollectController {
    @Resource
   UserArticleCollectServiceImpl CollectService;
    @PostMapping("/Collect/insert")
    @ResponseBody
    public ResultJson insertArticle(@RequestBody UserArticleCollect userArticleCollect) {
        return CollectService.insertcontroller(userArticleCollect);
    }
    @DeleteMapping("/Collect/delete")
    @ResponseBody
    public ResultJson deleteArticle(@RequestBody UserArticleCollect userArticleCollect) {
        return CollectService.deletcontroller(userArticleCollect);
    }
    @GetMapping("/Collect/select")
    @ResponseBody
    public ResultJson getAllArticles(@RequestBody UserArticleCollect userArticleCollect) {
        return CollectService.selectcontroller(userArticleCollect);
    }
}
