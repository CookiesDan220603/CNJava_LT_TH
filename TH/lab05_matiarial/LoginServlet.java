package controller;

import dao.UserDAO;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        check if session exist then redirect to index.jsp
        if (request.getSession().getAttribute("username") != null) {
            response.sendRedirect("/Lab05/");
        } else {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    request.setAttribute("username", cookie.getValue());
                }

                if (cookie.getName().equals("password")) {
                    request.setAttribute("password", cookie.getValue());
                }
            }
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String remember = request.getParameter("remember");
        System.out.println(username + " " + password);

        User user = UserDAO.login(username, password);
        if (user == null) {
            request.setAttribute("error", "Username or password is incorrect");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
//            set session
            if (remember != null) {
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(60 * 60 * 24 * 30); // 30 days
                response.addCookie(cookie);
            }
            request.getSession().setAttribute("username", username);
            request.setAttribute("username", username);
//            request.getRequestDispatcher("index.jsp").forward(request, response);
            response.sendRedirect("/Lab05/");
        }
    }
}