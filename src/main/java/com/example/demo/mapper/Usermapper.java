package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.mysql.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

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
}


