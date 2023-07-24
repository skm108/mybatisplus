package com.skm.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.skm.mybatisplus.mapper.UserMapper;
import com.skm.mybatisplus.pojo.User;
import com.skm.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MybatisPlusApplicationServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testGetCount(){
        Long reslt = userService.count();
        System.out.println(reslt);
    }

    @Test
    public void testBatchInsert(){
        List<User> list = new ArrayList<>();
        for (int i=0;i<5;i++){
            User user = new User();
            user.setAge(22+i);
            user.setName("派昂"+i);
            user.setEmail(i+"@qq.com");
            list.add(user);
        }
      boolean  b = userService.saveBatch(list);
        System.out.println(b);
    }

    @Test
    public void testQueryMapper01(){
//        SELECT id,name,age,email FROM user WHERE (name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        QueryWrapper<User> mapper = new QueryWrapper<>();
        mapper.like("name","派")
                .between("age",20,30)
                .isNotNull("email");
       List<User> list = userMapper.selectList(mapper);
       list.forEach(System.out::println);
    }

    @Test
    public void testQueryMapper02(){
//        SELECT id,name,age,email FROM user ORDER BY age DESC,id ASC
        QueryWrapper<User> mapper = new QueryWrapper<>();
        mapper.orderByDesc("age")
                .orderByAsc("id");

//
//        mapper.like("name","派")
//                .and(i -> i.gt("age",20)
//                        .or()
//                       .isNotNull("email"));

        List<User> list = userMapper.selectList(mapper);
        list.forEach(System.out::println);
    }
}
