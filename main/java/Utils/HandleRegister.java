package Utils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc.bean.User;
import jdbc.dao.UserDao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(name = "HandleUserRegister", urlPatterns = "/HandleUserRegister")
public class HandleRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String birthday = request.getParameter("age");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = null;
        try {
            //根据年龄计算出生年份
            date = sdf.parse(String.valueOf(Integer.parseInt(sdf.format(new Date())) - Integer.parseInt(birthday)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        User user = new User(username, password, email, date);
        System.out.println(user);

        User isExist = null;
        try {
            isExist = UserDao.query(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (isExist != null) {
            System.out.println("用户已存在");
            //跳转到注册失败页面,GET请求格式发送状态 1为用户已存在, 2为邮箱已存在
            response.sendRedirect("Fail-UserRegister.jsp?status=1");
            return;
        }
        isExist = null;
        try {
            isExist = UserDao.queryByEmail(email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (isExist != null) {
            System.out.println("邮箱已存在");
            //跳转到注册失败页面,GET请求格式发送状态 1为用户已存在, 2为邮箱已存在
            response.sendRedirect("Fail-UserRegister.jsp?status=2");
            return;
        }


        //调用UserDao中的AddUser方法
        Boolean added = false;
        try {
            added = UserDao.AddUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(added) {
            System.out.println("注册成功");
            response.sendRedirect("Succeess-UserRegister.jsp");
            //src/main/webapp/Succeess-UserRegister.jsp
        } else {
            System.out.println("注册失败");
        }


    }
}
