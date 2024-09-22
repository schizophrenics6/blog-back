package com.example.demo.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.mysql.Account;
import com.example.demo.entity.mysql.Article;
import com.example.demo.entity.mysql.personal;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Articlemapper extends BaseMapper<Article> {
    @Insert("INSERT INTO article (title, content, tags) VALUES (#{title}, #{content},#{tags})")
    int insertArticle(Article article);


    @Delete("DELETE FROM article WHERE id = #{id}")
    boolean deleteArticleById( int id);

    // 更新
    @Update("UPDATE article SET title = #{title}, content = #{content}, tags = #{tags} WHERE id = #{id}")
    int updateArticle(Article article);
    // 更新like
    @Update("UPDATE article SET likes = likes + 1 WHERE id = #{id}")
    int updateArticlelikes(Integer id);
    // 更新view
    @Update("UPDATE article SET views = views + 1 WHERE id = #{id}")
    int updateArticleviews(Integer id);

    @Select("SELECT * FROM Article WHERE title LIKE CONCAT('%', #{keyword}, '%')")
    List<Article> selectArticlesByKeyword(String keyword);

    @Update("UPDATE article SET top = CASE WHEN top = 1 THEN 0 ELSE 1 END WHERE id = #{id}")
    int updatetop(Article article);

    @Select("SELECT * FROM article WHERE authorid = #{authorid} ORDER BY top DESC, publishDate DESC")
    List<Article> selectpersonalarticle(int authorid);
}
