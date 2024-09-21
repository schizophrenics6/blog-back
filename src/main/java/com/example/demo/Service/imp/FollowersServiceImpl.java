package com.example.demo.Service.imp;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Common.ResultJson;
import com.example.demo.Service.FollowersService;
import com.example.demo.entity.mysql.Followers;
import com.example.demo.mapper.Followersmapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.function.Function;

@Service
public class FollowersServiceImpl extends ServiceImpl<Followersmapper,Followers> implements FollowersService {
@Resource
    Followersmapper followersmapper;
    @Override
    public ResultJson insertFollowers(Followers followers) {
        followersmapper.insertFollower(followers);
        return ResultJson.success("添加成功");
    }

    @Override
    public ResultJson deleteFollowers(Followers followers) {
        int result = followersmapper.deleteFollower(followers.getFanid(), followers.getIdolid());
        return result==1 ?
                ResultJson.success("删除成功"):
                ResultJson.error(" not found or already deleted");
    }

    @Override
    public ResultJson getFollowers(Followers followers) {
        return ResultJson.success(followersmapper.selectFollowersByFanId(followers.getFanid()));
    }




}
