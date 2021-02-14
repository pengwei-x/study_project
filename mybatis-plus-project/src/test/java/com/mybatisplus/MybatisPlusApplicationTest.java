package com.mybatisplus;

import com.mybatisplus.bean.User;
import com.mybatisplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @author pengwei
 * @date 2020/12/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisPlusApplication.class)
public class MybatisPlusApplicationTest {

    @Autowired(required = false)
    private UserMapper userMapper;

// 按照名称(by-name)装配，需结合@Qualifier注解使用，即
//    @Autowired(required = false)
//    @Qualifier("userMapper")
//    private UserMapper userMapper;

    @Resource
    private UserMapper userMapper2;


    @Test
    public void test01() {

        List<User> userList = userMapper.selectList(null);
        userList.forEach((user) -> {
            System.out.println(user.getName());
        });
    }

    @Test
    public void insertUser(){
        User user=new User();
        user.setName("秘书2");
        user.setAge(20);
        userMapper.insert(user);
    }

    //测试乐观锁
   @Test
    public void OptimisticLockTest(){
       User user = userMapper.selectById(4276230425791451116L);
       user.setPassword("123456");
       userMapper.updateById(user);

   }

}