package tdtu.edu.ex01;

import java.io.*;
import java.util.HashMap;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private String userName, passWord;
    private HashMap<String,String> accounts;

    public void init() {
        accounts = new HashMap<>();
        accounts.put("admin","123");
        accounts.put("user","123");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        userName = request.getParameter("userName");
        passWord = request.getParameter("passWord");
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("<h3>Check Login</h3><br/>");
        int flag = 0;
        for (String i : accounts.keySet()) {
            if(i.equals(userName) && accounts.get(i).equals(passWord)){
                flag = 1;
                out.print("Name/Password match");
                break;
            }
        }
        if(flag == 0) out.print("Name/Password does not match");
        out.print("</body></html>");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        response.sendRedirect("login.html");
        pw.close();
    }

    public void destroy() {
    }
}