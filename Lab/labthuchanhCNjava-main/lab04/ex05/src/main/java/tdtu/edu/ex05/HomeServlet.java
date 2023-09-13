package tdtu.edu.ex05;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HomeServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String page = request.getParameter("page");
        if(page.equals("")){
            response.sendRedirect("index.jsp");
        }
        else if(page.equals("help")){
            response.sendRedirect("help.jsp");
        }
        else if(page.equals("contact")){
            response.sendRedirect("contact.jsp");
        }
        else if(page.equals("about")){
            response.sendRedirect("about.jsp");
        }
        else {
            response.setContentType("text/html");
            PrintWriter pw=response.getWriter();
            pw.write("Welcome to our website");
            pw.close();
        }
    }

    public void destroy() {
    }
}
