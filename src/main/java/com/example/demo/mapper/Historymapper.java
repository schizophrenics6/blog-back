package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.mysql.Article;
import com.example.demo.entity.mysql.Comments;
import com.example.demo.entity.mysql.History;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Historymapper extends BaseMapper<History> {


    @Delete("DELETE FROM History WHERE id = #{id}")
    boolean deleteHistoryById( int id);

    @Select("SELECT uac.accountId AS accountId, uac.articleId AS articleId, uac.actionTime AS actionTime, " +
            "a.title AS title, a.content AS content, a.publishDate AS publishDate, " +
            "a.tags AS tags, a.likes AS likes, a.views AS views " +
            "FROM History uac " +
            "INNER JOIN Article a ON uac.articleid = a.id " +
            "WHERE uac.accountId = #{accountId}")
    List<History> selectHistory(int accountId);
}


//    @Select("SELECT accountId,articleId from History WHERE accountId=#{accountId}")
//    @Select("SELECT  uac.AccountID, uac.ArticleID, uac.CollectDate, a.title, a.content, a.publishDate, a.tags, a.likes, a.views " +
//            "FROM UserArticleCollect uac " +
//            "INNER JOIN Article a ON uac.ArticleID = a.id " +
//            "WHERE uac.AccountID = #{accountId}")
//    History selectHistory(int accountId);



