package com.example.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.Common.ResultJson;
import com.example.demo.entity.mysql.Article;
import com.example.demo.entity.mysql.Comments;

public interface CommentsService extends IService<Comments> {

    ResultJson insertComments(Comments comments);
    ResultJson deleteComments(Comments comments);
    ResultJson selectComments(Comments comments);
}