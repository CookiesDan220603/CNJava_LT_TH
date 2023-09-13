package com.example.lab05.Servlet;

import com.example.lab05.DAO.UserDAO;
import com.example.lab05.Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserDAO userDAO;
    @Override
    public void init(){
        userDAO = UserDAO.getInstance();
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("register.jsp");
    }

        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("passwordConfirm");
        String message;
        if(Objects.equals(username, "") || Objects.equals(email, "")
                || Objects.equals(password, "") || Objects.equals(passwordConfirm, "")){
            message = "Hãy nhập đầy đủ thông tin";
        }
        else if(userDAO.read(username) != null){
            message = "Tên tài khoản đã tồn tại";
        }
        else if(password.equals(passwordConfirm)){
            userDAO.add(new User(username,password,email));
            message = "Đăng ký thành công";
        }
        else{
            message = "Mật khẩu xác nhận không đúng";
        }
        req.setAttribute("messageErr", message);
        RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
        rd.forward(req , resp);
    }
    public void destroy(){
        userDAO.close();
    }
}
