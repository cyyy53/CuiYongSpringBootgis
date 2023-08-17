package com.itcy.postgresql;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itcy.postgresql.model.User;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongsProject: cyspring
 * @BelongsPackage: com.itcy.postgresql
 * @Author: cuiYong
 * @CreateTime: 2023-08-07  10:05
 * @Description: TODO
 * @Version: 1.0
 */

public class Demo {

    @Test
    public void test1(){

// 创建三个user
        User user1 = new User("111", "18", 180);
        User user2 = new User("222", "18", 175);
        User user3 = new User("333", "19", 170);
        List<User> userList = new ArrayList<>();
       userList.add(user1);
       userList.add(user2);
       userList.add(user3);
        List<String> userNameList1 = new ArrayList<>();
        for (User user : userList) {
            userNameList1.add(user.getName());
        }
        System.out.println("userNameList1=====>"+userNameList1);
        // Stream流
        List<String> userNameList2 = userList.stream().map(User::getAge).collect(Collectors.toList());
        System.out.println("userNameList2=====>"+userNameList2);
       List<String> demo = userList.stream().map((item) -> {
           String s = new String();
           s="wodedazhaohaol";
           return s;
        }).collect(Collectors.toList());

        System.out.println("demo=====>"+demo);
    }

}
