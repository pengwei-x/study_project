package com.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatisplus.bean.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @author pengwei
 * @date 2020/12/20
 */
@Component
public interface UserMapper extends BaseMapper<User> {
}
