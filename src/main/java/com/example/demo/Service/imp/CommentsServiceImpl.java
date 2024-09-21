package com.example.demo.Service.imp;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Common.ResultJson;
import com.example.demo.Service.CommentsService;
import com.example.demo.entity.mysql.Comments;
import com.example.demo.mapper.Commentsmapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CommentsServiceImpl extends ServiceImpl<Commentsmapper, Comments> implements CommentsService {

@Resource
Commentsmapper commentsmapper;
    @Override
    public ResultJson insertComments(Comments comments) {
       commentsmapper.insertComments(comments);
       System.out.println(comments);
        return ResultJson.success("评论成功");
    }

    @Override
    public ResultJson deleteComments(Comments comments) {
        boolean deleted = commentsmapper.deleteCommentsById(comments.getId());
        if (deleted) {
            return ResultJson.success("删除成功");
        } else {
            return ResultJson.error(" not found or already deleted");
        }
    }

    @Override
    public ResultJson selectComments(Comments comments) {
        int id = comments.getArticleId();
        return ResultJson.success(commentsmapper.selectComments(id));
    }


}
