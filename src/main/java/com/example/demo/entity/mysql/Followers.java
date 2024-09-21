package com.example.demo.entity.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("Followers")
public class Followers {

    @TableField("idolid")
    private Integer idolid;

    @TableField("fanid")
        private Integer fanid;

    @TableField("followdate")
        private Date followdate;
}
