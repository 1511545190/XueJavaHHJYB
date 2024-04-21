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

@WebServlet(name = "HandleLogin", urlPatterns = "/HandleLogin")
public class HandleLogin extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");


        User user = new User(username, password, null, null);
        User isExist = null;
        try {
            isExist = UserDao.query(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (isExist == null) {
            System.out.println("用户不存在");
            //跳转到注册失败页面,GET请求格式发送状态 1为用户不存在, 2为密码错误
            response.sendRedirect("login.jsp?status=1");
            return;
        }
        if (!isExist.getPassword().equals(password)) {
            System.out.println("密码错误");
            //跳转到注册失败页面,GET请求格式发送状态 1为用户不存在, 2为密码错误
            response.sendRedirect("login.jsp?status=2");
            return;
        }
        System.out.println("登录成功");
        //跳转到登录成功页面,解决乱码问题
        response.sendRedirect("loginSuccess.jsp");

    }
}
