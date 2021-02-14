package com.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自动填充数据
 * @author pengwei
 * @date 2020/12/22
 */
@Component
public class MyMataObjectHandler implements MetaObjectHandler {
    //使用mp 实现添加操作
    @Override
    public void insertFill(MetaObject metaObject) {
        //字段名称
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("version",1,metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
