package com.example.demo.Controller;
import com.example.demo.Common.ResultJson;
import com.example.demo.Service.imp.ArticleServiceImpl;
import com.example.demo.Service.imp.CommentsServiceImpl;
import com.example.demo.entity.mysql.Article;
import com.example.demo.entity.mysql.Comments;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
@RestController
public class CommentsController {
    @Resource
    CommentsServiceImpl commentsService;

    @PostMapping("/Comments/insert")
    @ResponseBody
    public ResultJson insertArticle(@RequestBody Comments comments) {
        return commentsService.insertComments(comments);
    }
    @DeleteMapping("/Comments/delete")
    @ResponseBody
    public ResultJson deleteArticle(@RequestBody Comments comments) {
        return commentsService.deleteComments(comments);
    }
    @GetMapping("/Comments/select")
    @ResponseBody
    public ResultJson getAllArticles(@RequestBody Comments comments) {
        return commentsService.selectComments(comments);
    }
}
