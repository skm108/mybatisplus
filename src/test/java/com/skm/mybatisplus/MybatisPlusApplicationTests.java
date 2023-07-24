package com.skm.mybatisplus;

import com.skm.mybatisplus.mapper.UserMapper;
import com.skm.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setAge(22);
        user.setName("纷纷");
        user.setEmail("1112@qq.com");
        int result = userMapper.insert(user);
        System.out.println("result:"+result+",id:"+user.getId());
    }

    @Test
    public void testDeleteById(){
        int result = userMapper.deleteById(1683346773749829634l);
        System.out.println("受影响行数"+ result);
    }

    @Test
    public void testDeleteBatchById(){
        List<Long> list = Arrays.asList(1L,2L,3L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println("受影响行数"+ result);
    }

    @Test
    public void testDeleteByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("age",20);
        System.out.println("受影响行数"+ userMapper.deleteByMap(map));
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(5l);
        user.setAge(44);
        user.setEmail("11111111@qq.com");
        user.setName("11111111111");
        userMapper.updateById(user);
        System.out.println(user);
    }

    @Test
    public void testSelectById(){
        User user = userMapper.selectById(5L);
        System.out.println(user);
    }
    /**
     * testSelectByBatchIds/testSelectByMap
     */

    @Test
    public void testConsumer(){
        Map<String,Object> map = userMapper.selectMapById(5l);

        System.out.println(map);
    }

}
