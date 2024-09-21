package com.example.demo.Service.imp;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Common.ResultJson;
import com.example.demo.Service.ArticleService;
import com.example.demo.Service.HistoryService;
import com.example.demo.entity.mysql.Article;
import com.example.demo.entity.mysql.History;
import com.example.demo.mapper.Articlemapper;
import com.example.demo.mapper.Historymapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl extends ServiceImpl<Historymapper, History> implements HistoryService {
@Resource
private Historymapper historymapper;
@Resource
Articlemapper articlemapper;

    @Override
    public ResultJson insertHistory(History history) {
        historymapper.insert(history);
        articlemapper.updateArticleviews(history.getId());
        return ResultJson.success("添加成功");
    }

    @Override
    public ResultJson deleteHistory(History history) {
        boolean deleted = historymapper.deleteHistoryById(history.getId());
        if (deleted) {
            return ResultJson.success("删除成功");
        } else {
            return ResultJson.error(" not found or already deleted");
        }
    }

    @Override
    public ResultJson selectHistory(History history) {
        Integer accountId=history.getAccountId();
        return ResultJson.success(historymapper.selectHistory(accountId));
    }
}
