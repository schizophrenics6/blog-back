package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.mysql.Comments;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface Commentsmapper extends BaseMapper<Comments> {
@Insert("INSERT INTO Comments (articleId,accountId,commentText) VALUES (#{articleId}, #{accountId},#{commentText})")
   int insertComments( Comments comments) ;

    @Delete("DELETE FROM Comments WHERE id = #{id}")
    boolean deleteCommentsById( int id);

    @Select("SELECT commentText,CommentDate  from Comments WHERE articleId=#{id}")
    Comments selectComments(int articleId);
}

