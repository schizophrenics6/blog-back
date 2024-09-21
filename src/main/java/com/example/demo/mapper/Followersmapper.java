package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.mysql.Article;
import com.example.demo.entity.mysql.Followers;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Followersmapper  extends BaseMapper<Followers> {

    @Insert("INSERT INTO Followers (fanid, idolid) VALUES (#{fanid}, #{idolid})")
    int insertFollower(Followers follower);

@Delete("DELETE FROM Followers WHERE fanid = #{fanid} AND idolid = #{idolid}")
int deleteFollower(Integer fanid, Integer idolid);

    @Select("SELECT * FROM Followers WHERE fanid = #{fanid}")
    List<Followers> selectFollowersByFanId(Integer fanid);




}
