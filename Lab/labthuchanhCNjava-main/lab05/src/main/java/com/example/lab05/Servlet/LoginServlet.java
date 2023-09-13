package com.example.lab05.Servlet;

import com.example.lab05.DAO.UserDAO;
import com.example.lab05.Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO;
    @Override
    public void init(){
        userDAO = UserDAO.getInstance();
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession();
            if (!session.isNew()) {
                session.invalidate();
            }
        resp.sendRedirect("login.jsp");
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String messageErr = "";
        User user = userDAO.read(username);
        if(username.equals("")|| password.equals("")){
            messageErr = "Vui lòng nhập đầy đủ thông tin";
        }
        else if(user!=null){
            if(user.password.equals(password)){
                Cookie ck = new Cookie("username",username);
                Cookie ck1 = new Cookie("password",password);
                HttpSession session = req.getSession();
                session.setAttribute("isLogin","123");
                // set due time 30 days
                ck.setMaxAge(2592000);
                ck1.setMaxAge(2592000);
                resp.addCookie(ck);
                resp.addCookie(ck1);
                resp.sendRedirect("product");
                return;
            }
            else {
                messageErr = "Nhập sai tên hoặc mật khẩu";
            }
        }
        else {
            messageErr = "Nhập sai tên hoặc mật khẩu";
        }
        req.setAttribute("messageErr",messageErr);
        RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
        rd.forward(req , resp);
    }
    public void destroy(){
        userDAO.close();
    }
}
