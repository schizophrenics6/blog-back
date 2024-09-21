package com.example.demo.Service.imp;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Common.ResultJson;
import com.example.demo.Service.UserArticleCollectService;
import com.example.demo.entity.mysql.UserArticleCollect;
import com.example.demo.mapper.Articlemapper;
import com.example.demo.mapper.UserArticleCollectmapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
@Service
public class UserArticleCollectServiceImpl extends ServiceImpl<UserArticleCollectmapper, UserArticleCollect> implements UserArticleCollectService {
   @Resource
   UserArticleCollectmapper Collectmapper;
   @Resource
    Articlemapper articlemapper;



    @Override
    public ResultJson insertcontroller(UserArticleCollect userArticleCollect) {

        Collectmapper.insertCollect(userArticleCollect.getAccountId(),userArticleCollect.getArticleId());//添加收藏

         articlemapper.updateArticlelikes(userArticleCollect.getArticleId());//收藏数加1

        return ResultJson.success("添加成功");
    }





    @Override
    public ResultJson deletcontroller(UserArticleCollect userArticleCollect) {
        boolean deleted = Collectmapper.deleteCollectById(userArticleCollect.getCollectId());
        if (deleted) {
            return ResultJson.success("删除成功");
        } else {
            return ResultJson.error(" not found or already deleted");
        }
    }
    @Override
    public ResultJson selectcontroller(UserArticleCollect userArticleCollect) {
        int id = userArticleCollect.getAccountId();
        return ResultJson.success(Collectmapper.selectCollectsByAccountId(id));
    }
}
