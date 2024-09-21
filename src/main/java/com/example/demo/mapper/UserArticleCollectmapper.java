package com.example.demo.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.mysql.Account;
import com.example.demo.entity.mysql.Article;
import com.example.demo.entity.mysql.UserArticleCollect;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserArticleCollectmapper  extends BaseMapper<UserArticleCollect> {
    @Insert("INSERT INTO UserArticleCollect (accountId, articleId) VALUES (#{accountId}, #{articleId})")
    int insertCollect( Integer accountId, Integer articleId);

    // 根据主键删除一条记录
    @Delete("DELETE FROM UserArticleCollect WHERE CollectID = #{collectId}")
    boolean deleteCollectById(Integer collectId);

    @Select("SELECT  uac.AccountID, uac.ArticleID, uac.CollectDate, a.title, a.content, a.publishDate, a.tags, a.likes, a.views " +
            "FROM UserArticleCollect uac " +
            "INNER JOIN Article a ON uac.ArticleID = a.id " +
            "WHERE uac.AccountID = #{accountId}")
    List<UserArticleCollect> selectCollectsByAccountId(Integer accountId);
}