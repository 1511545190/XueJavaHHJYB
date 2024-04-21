package com.example;


import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.util.ArrayList;
import java.util.List;

/*
CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50),
    email VARCHAR(50),
    birthday DATE
);
 */
public class Test {
    public static void main(String[] args) {
        BaseDao baseDao = new BaseDao();
        String sql = "select * from users where id = ?";
        //..params 为占位符的值
        User user = (User) baseDao.query(sql, new BeanHandler(User.class), 3);
        System.out.println(user);

        //查询全部
        String sql2 = "select * from users";
        List<User> list = (List<User>) baseDao.query(sql2, new BeanListHandler(User.class));
        for(User u : list) {
            System.out.println(u);
        }

        //用handler处理每一列
        String sql3 = "select * from users";
        List<String> list2 = (List<String>) baseDao.query(sql3, new ColumnListHandler("username"));
        for(String u : list2) {
            System.out.println(u);
        }



    }
}
