package com.example;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties; // Added import statement

public class ConnectionPools {
    public static DataSource dataSource = null;

    static {
        // 读取配置文件
        InputStream in = ConnectionPools.class.getClassLoader().
                getResourceAsStream("dbcpconfig.properties");
        if(in == null) {
            System.out.println("配置文件加载失败");
            System.exit(1);
        }

        // Declare and initialize properties
        Properties properties = new Properties(); // Added line

        try {
            //加载文件
            properties.load(in);
            //通过工厂对象创建数据源
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // Added closing brace

    public static DataSource getDataSource() {
        //打印连接信息

        return dataSource;
    }
    public static void main(String[] args) throws SQLException {
        //获取连接
        Connection cnn = dataSource.getConnection();
        //打印连接信息
        DatabaseMetaData databaseMetaData = cnn.getMetaData();
        System.out.println("URL:" + databaseMetaData.getURL());
        System.out.println("UserName:" + databaseMetaData.getUserName());
        System.out.println("DriverName:" + databaseMetaData.getDriverName());
        System.out.println("DriverVersion:" + databaseMetaData.getDriverVersion());
        System.out.println("DatabaseProductName:" + databaseMetaData.getDatabaseProductName());
        System.out.println("DatabaseProductVersion:" + databaseMetaData.getDatabaseProductVersion());
        //关闭连接




        cnn.close();


    }
}