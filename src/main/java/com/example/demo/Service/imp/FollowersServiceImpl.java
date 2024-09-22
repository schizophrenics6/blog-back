package com.example.demo.Service.imp;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Common.ResultJson;
import com.example.demo.Service.FollowersService;
import com.example.demo.entity.mysql.Followers;
import com.example.demo.mapper.Followersmapper;
import com.example.demo.mapper.Usermapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.function.Function;

@Service
public class FollowersServiceImpl extends ServiceImpl<Followersmapper,Followers> implements FollowersService {
@Resource
    Followersmapper followersmapper;
@Resource
    Usermapper usermapper;
    @Override
    public ResultJson insertFollowers(Followers followers) {
        boolean saved = this.save(followers);
        if (saved && followers.getIdolid() != null) {
            // 插入成功后，使用文章的 ID 插入标签
            int idolid = followers.getIdolid().intValue();
            int fanid = followers.getFanid().intValue();
            // 确保 ID 不为 null
            usermapper.updateUseridolinsert(fanid);
            usermapper.updateUserfansinsert(idolid);
        }
       // followersmapper.insertFollower(followers);
            return ResultJson.success("添加成功");

    }

        @Override
        public ResultJson deleteFollowers (Followers followers){

            int result = followersmapper.deleteFollower(followers.getFanid(), followers.getIdolid());
        if(result == 1){
            usermapper.updateUseridoldelete(followers.getFanid());
            usermapper.updateUserfansdelete(followers.getIdolid());
        }

            return result == 1 ?
                    ResultJson.success("删除成功") :
                    ResultJson.error(" not found or already deleted");
        }

        @Override
        public ResultJson getFollowers (Followers followers){
            return ResultJson.success(followersmapper.selectFollowersByFanId(followers.getFanid()));
        }


}
