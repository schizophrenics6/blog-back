package com.example.demo.entity.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("UserArticleCollect")
public class UserArticleCollect {

    @TableId(value = "CollectID", type = IdType.AUTO)
    private Integer collectId;

    @TableField("AccountID")
    private Integer accountId;

    @TableField("ArticleID")
    private Integer articleId;

    @TableField("CollectDate")
    private Date collectDate;

}