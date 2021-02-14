package com.mybatisplus.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.mybatisplus.handler.MyMataObjectHandler;
import lombok.Data;

import java.util.Date;

/**
 * @author pengwei
 * @date 2020/12/20
 */
@Data
@TableName("t_user")
public class User {
    /**
     * 主键自动生成
     */
    //mp自带策略，生成19位，数字类型使用
//    @TableId(type = IdType.ID_WORKER)
    //字符串类型使用
//    @TableId(type = IdType.ID_WORKER_STR)
    @TableId(type = IdType.ID_WORKER)
    private long id;
    private String name;
    private int age;
    private String password;
    //自动填充
    /**
     * @see MyMataObjectHandler
     */

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT)
    private Date updateTime;

    /**
     * 乐观锁
     */
    @Version
    @TableField(fill =FieldFill.INSERT)
    private Integer version;
}
