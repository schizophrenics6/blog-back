package com.example.demo.entity.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@Data
@TableName("Account")
public class Account {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("email")
    private String number;

}
