package com.example;

import org.apache.commons.dbutils.ResultSetHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50),
    email VARCHAR(50),
    birthday DATE
);
 */
public class BaseDao {


    //优化查询
    public static Object query(String sql, ResultSetHandler<?> rsh, Object... params) {
        Connection cnn = null;
        ResultSet resultSet = null;
        try {
            //获取连接
            cnn = ConnectionPools.getDataSource().getConnection();
            //执行查询
            PreparedStatement preparedStatement = cnn.prepareStatement(sql);
            // 设置参数, 从1开始
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            // 执行查询
            resultSet = preparedStatement.executeQuery();

            return rsh.handle(resultSet);  // 通过结果集处理器处理结果集, 并返回结果

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(cnn != null) {
                    cnn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static void main(String[] args) throws SQLException {
        ConnectionPools cpools = new ConnectionPools();
        DataSource dataSource = cpools.getDataSource();

        Connection cnn = dataSource.getConnection();
        System.out.println("URL:" + cnn.getMetaData().getURL());
        System.out.println("UserName:" + cnn.getMetaData().getUserName());
        System.out.println("DriverName:" + cnn.getMetaData().getDriverName());
        System.out.println("DriverVersion:" + cnn.getMetaData().getDriverVersion());
        System.out.println("DatabaseProductName:" + cnn.getMetaData().getDatabaseProductName());
        System.out.println("DatabaseProductVersion:" + cnn.getMetaData().getDatabaseProductVersion());




    }
}
