package com.example.lab05.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AppExceptionHandler")
public class AppExceptionHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        processError(req, resp);
    }

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {

        processError(req, resp);
    }

    private void processError(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin")==null) {
            response.sendRedirect("login.jsp");
            return;
        }
        // Analyze the servlet exception
        Throwable throwable = (Throwable) request
                .getAttribute("jakarta.servlet.error.exception");
        Integer statusCode = (Integer) request
                .getAttribute("jakarta.servlet.error.status_code");
        String servletName = (String) request
                .getAttribute("jakarta.servlet.error.servlet_name");
        if (servletName == null) {
            servletName = "Unknown";
        }
        String requestUri = (String) request
                .getAttribute("jakarta.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }

        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.write("<html><head><title>Exception/Error Details</title></head><body>");
        if(statusCode != 500){
            out.write("<h3>Error Details</h3>");
            out.write("<strong>Status Code</strong>:"+statusCode+"<br>");
            out.write("<strong>Requested URI</strong>:"+requestUri);
        }else{
            out.write("<h3>Exception Details</h3>");
            out.write("<ul><li>Servlet Name:"+servletName+"</li>");
            out.write("<li>Exception Name:"+throwable.getClass().getName()+"</li>");
            out.write("<li>Requested URI:"+requestUri+"</li>");
            out.write("<li>Exception Message:"+throwable.getMessage()+"</li>");
            out.write("</ul>");
        }

        out.write("<br><br>");
        out.write("<a href=\"product\">Home Page</a>");
        out.write("</body></html>");
    }
}