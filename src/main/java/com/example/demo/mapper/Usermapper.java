package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Common.ResultJson;
import com.example.demo.entity.mysql.Account;
import com.example.demo.entity.mysql.Article;
import com.example.demo.entity.mysql.Comments;
import com.example.demo.entity.mysql.personal;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Usermapper extends BaseMapper <Account>
{
    @Insert("insert into account(username,password,number) values(#{username},#{password},#{number})")
    void createUser(String username, String password, String number);

    @Delete("delete from account where number = #{number}")
    void deleteUserByEmail(String number);

    @Update("UPDATE account SET fans =fans + 1 WHERE id = #{id}")
    int updateUserfansinsert(Integer id);

    @Update("UPDATE account SET idol =idol + 1 WHERE id = #{id}")
    int updateUseridolinsert(Integer id);

    @Update("UPDATE account SET fans =fans - 1 WHERE id = #{id}")
    int updateUserfansdelete(Integer id);

    @Update("UPDATE account SET idol =idol - 1 WHERE id = #{id}")
    int updateUseridoldelete(Integer id);

    @Update("UPDATE account SET sex = #{sex}, year = #{year}, introduce = #{introduce} WHERE id = #{id}")
    int updateaccountpersonal(Account account);

    @Select("select sex,year,introduce from Account where id=#{id}")
    personal selectpersonalpage(int id);

//        @Select("SELECT * FROM article WHERE authorid = #{authorid} ORDER BY top DESC, publishDate DESC")
//        List<Article> selectpersonalarticle(int authorid);


}


