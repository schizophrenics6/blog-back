package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.mysql.Article;
import com.example.demo.entity.mysql.ArticleTag;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Tagmapper extends BaseMapper<ArticleTag> {


    @Insert("INSERT INTO articletag(articleId,tagName)VALUES (#{articleId}, #{tagName})")
   int insertTag(Integer articleId, String tagName);

//@Update("UPDATE Tag SET tags = #{tags} WHERE  articleId = #{articleId}")
//int updateArticleTag(Article article);
//
//
@Select("SELECT * FROM Article WHERE CONCAT(',',tags, ',') LIKE CONCAT('%,', #{tagName}, ',%')")
List<Article> selectArticlesByTag( String tagName);
}



