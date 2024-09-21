package com.example.demo.Service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.Common.ResultJson;
import com.example.demo.entity.mysql.ArticleTag;

public interface TagService extends IService<ArticleTag> {

    ResultJson selectTag(ArticleTag tag);


}
