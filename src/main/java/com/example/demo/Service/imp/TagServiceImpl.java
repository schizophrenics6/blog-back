package com.example.demo.Service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Common.ResultJson;
import com.example.demo.Service.TagService;
import com.example.demo.entity.mysql.ArticleTag;
import com.example.demo.mapper.Tagmapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl extends ServiceImpl<Tagmapper, ArticleTag> implements TagService {
    @Resource
    Tagmapper tagmapper;

    @Override
    public ResultJson selectTag(ArticleTag tag)
    {
        return ResultJson.success(tagmapper.selectArticlesByTag(tag.getTagName()));
    }
}
