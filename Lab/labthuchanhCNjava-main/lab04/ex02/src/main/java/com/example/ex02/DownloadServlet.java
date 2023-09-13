package com.example.ex02;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.regex.Pattern;

@WebServlet(name = "DownloadServlet", value = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    public void init() {
    }
    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String fileName = request.getParameter("file");
        String strSpeed = request.getParameter("speed");
        int speed=0;
        if(!Objects.equals(strSpeed, "") && strSpeed!=null){
            if(isNumeric(strSpeed))
            speed = Integer.parseInt(strSpeed);
        }
        if(Objects.equals(fileName, "") || fileName==null){
            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            printWriter.print("<html>");
            printWriter.print("<body>");
            printWriter.print("<p> file not found</p>");
            printWriter.print("</body>");
            printWriter.print("</html>");
            printWriter.close();
        }
        else {
            URL res = getClass().getClassLoader().getResource(fileName);
            File file;
            try {
                assert res != null;
                file = Paths.get(res.toURI()).toFile();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
            if(!file.exists()){
                throw new ServletException("File doesn't exists on server.");
            }
            System.out.println("File location on server::"+file.getAbsolutePath());
            ServletContext ctx = getServletContext();
            InputStream fis = new FileInputStream(file);
            String mimeType = ctx.getMimeType(file.getAbsolutePath());
            response.setContentType(mimeType != null? mimeType:"application/octet-stream");
            response.setContentLength((int) file.length());
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

            ServletOutputStream os = response.getOutputStream();

            byte[] bufferData = new byte[1000];
            int read=0;
            int total = 0;
            while((read = fis.read(bufferData))!= -1){
                if(speed !=0){
                    total +=read;
                }
                if(total%(1000*speed)==0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                os.write(bufferData, 0, read);
            }
            os.flush();
            os.close();
            fis.close();
            System.out.println("File downloaded at client successfully");
        }
    }
    public void destroy() {
    }
}

