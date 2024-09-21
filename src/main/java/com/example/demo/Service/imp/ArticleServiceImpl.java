package com.example.demo.Service.imp;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Common.ResultJson;
import com.example.demo.Service.ArticleService;
import com.example.demo.entity.mysql.Article;
import com.example.demo.mapper.Articlemapper;
import com.example.demo.mapper.Tagmapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
@Service
public class ArticleServiceImpl extends ServiceImpl<Articlemapper, Article> implements ArticleService {
@Resource
Articlemapper articlemapper;
@Resource
    Tagmapper tagmapper;
    @Override
    public ResultJson insertArticle(Article article)
    {
//        articlemapper.insertArticle(article);
        boolean saved = this.save(article);
        if (saved && article.getTags() != null) {
            // 插入成功后，使用文章的 ID 插入标签
            int articleId = article.getId().intValue(); // 确保 ID 不为 null
            tagmapper.insertTag(articleId, article.getTags());
        }
//        if(article.getTags()!=null)
//        {
//            int articleId = articlemapper.getLastInsertId();
//            tagmapper.insertTag(articleId,article.getTags());
//        }
        return ResultJson.success("添加成功");
    }

    @Override
    public ResultJson updateArticle(Article article) {
//        if(article.getTags()!=null)
//        {
//            tagmapper.updateArticleTag(article);
//        }
        articlemapper.updateArticle(article);
        return ResultJson.success("更新成功");
    }

    @Override
    public ResultJson deleteArticle(Article article) {
        boolean deleted = articlemapper.deleteArticleById(article.getId());
        if (deleted) {
            return ResultJson.success("删除成功");
        } else {
            return ResultJson.error("Article not found or already deleted");
        }
    }

    @Override
    public ResultJson selectArticle(Article article) {
        String title = article.getTitle();
        return ResultJson.success(articlemapper.selectArticlesByKeyword(title));
    }
}
