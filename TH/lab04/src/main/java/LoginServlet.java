import java.io.*;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("LoginServlet")
public class LoginServlet extends HttpServlet {
    private HashMap<String,String> accounts;

    public void init() {
        accounts = new HashMap<>();
        accounts.put("admin","123");
        accounts.put("user","123");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("<h3>Check Login</h3><br/>");
        int flag = 0;
        for (String i : accounts.keySet()) {
            if(i.equals(username) && accounts.get(i).equals(password)){
                flag = 1;
                out.print("Name/Password match");
                break;
            }
        }
        if(flag == 0) out.print("Name/Password does not match");
        out.print("</body></html>");
//        response.getWriter().println("user name: "  + username);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        response.sendRedirect("login.html");
        pw.close();
    }

}