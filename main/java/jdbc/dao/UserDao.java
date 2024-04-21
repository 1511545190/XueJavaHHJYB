package jdbc.dao;

import com.example.ConnectionPools;
import jdbc.bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserDao {


    public static User query(String username) throws SQLException {
        //创建QueryRunner对象
        QueryRunner qr = new QueryRunner(ConnectionPools.getDataSource());
        String sql = "SELECT *   FROM users   WHERE username = ?";
        User user  = (User) qr.query(sql, new BeanHandler(User.class), username);

        if(user != null) {
            System.out.println("查询成功");
            System.out.println(user);
        } else {
            System.out.println("查询失败");
        }
        return user;
    }
    public static Boolean AddUser(User user) throws SQLException {
        //创建QueryRunner对象
        QueryRunner qr = new QueryRunner(ConnectionPools.getDataSource());
        String sql = "insert into users(username, password, email, birthday) values(?, ?, ?, ?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = sdf.format(new Date(2003, 0, 1));

        int stmt = qr.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), birthday);
        return stmt > 0;
    }

    public static Boolean UpdateUser(User user) throws SQLException {
        //创建QueryRunner对象
        QueryRunner qr = new QueryRunner(ConnectionPools.getDataSource());
        String sql = "update users   set username = ?, password = ?, email = ?, birthday = ? where id = 1";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = sdf.format(new Date(2003, 0, 1));
        int stmt = qr.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), birthday);
        return stmt > 0;
    }

    //query all users return list
    public static List<User> queryAll() throws SQLException {
        //创建QueryRunner对象
        QueryRunner qr = new QueryRunner(ConnectionPools.getDataSource());
        String sql = "SELECT *   FROM users   WHERE username = ?";
        List<User> users = new ArrayList<>();
        users  = (List<User>) qr.query(sql, new BeanListHandler(User.class), "zhangsan");

        if(users.size()!=0) {
            System.out.println("查询成功");
            for (User user : users) {
                System.out.println(user);
            }
        } else {
            System.out.println("查询失败");
        }
        return users;
    }

    //delete user by user id
    public static Boolean deleteUser(int id) throws SQLException {
        //创建QueryRunner对象
        QueryRunner qr = new QueryRunner(ConnectionPools.getDataSource());
        String sql = "delete from users where id = ?";
        int stmt = qr.update(sql, id);
        return stmt > 0;
    }

    //query user by user email
    public static User queryByEmail(String email) throws SQLException {
        //创建QueryRunner对象
        QueryRunner qr = new QueryRunner(ConnectionPools.getDataSource());
        String sql = "SELECT *   FROM users   WHERE email = ?";
        User user  = (User) qr.query(sql, new BeanHandler(User.class), email);

        if(user != null) {
            System.out.println("查询成功");
            System.out.println(user);
        } else {
            System.out.println("查询失败");
        }
        return user;
    }

}