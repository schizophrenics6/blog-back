package com.example.demo.entity.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("Article")
public class Article
{

    private Integer id;

    @TableField("title")
    private String title;

    @TableField("content")
    private String content;

    @TableField("authorid")
    private int authorid;

    @TableField("publishDate")
    private Date publishDate;

    @TableField("tags")
    private String tags;

    @TableField("likes")
    private Integer likes;

    @TableField("views")
    private Integer views;

    @TableField("top")
    private boolean top;
}
