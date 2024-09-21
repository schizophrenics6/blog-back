package com.example.demo.entity.mysql;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("articletag")
public class ArticleTag
{
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("ArticleID")
    private Integer articleId;
    @TableField("TagName")
    private String tagName;
}
