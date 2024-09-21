package com.example.demo.entity.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
@Data
@TableName("Comment")
public class Comments {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("ArticleId")
    private Integer articleId;
    @TableField("AccountId")
    private Integer accountId;
    @TableField("CommentText")
    private String commentText;
    @TableField("CommentDate")
    private Date CommentDate;
}