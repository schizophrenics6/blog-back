package com.example.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.Common.ResultJson;
import com.example.demo.entity.mysql.Article;
import com.example.demo.entity.mysql.Comments;
import com.example.demo.entity.mysql.History;

public interface HistoryService extends IService<History> {
    ResultJson insertHistory(History history);

    ResultJson deleteHistory(History history);

    ResultJson selectHistory(History history);
}
