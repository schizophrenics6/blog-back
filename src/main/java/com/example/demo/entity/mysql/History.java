package com.example.demo.entity.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("History")
public class History {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("accountid")
    private Integer accountId;
    @TableField("articleid")
    private Integer articleId;
    @TableField("ActionTime")
    private Date actionTime;
}
