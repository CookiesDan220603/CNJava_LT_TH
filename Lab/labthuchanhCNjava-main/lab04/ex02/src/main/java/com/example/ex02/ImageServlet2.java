package com.example.ex02;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

@WebServlet(name = "ImageServlet2", value = "/ImageServlet2")
public class ImageServlet2 extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpg");
        ServletOutputStream out;
        out = response.getOutputStream();
        URL res = getClass().getClassLoader().getResource("image2.jpg");
        File file = null;
        try {
            assert res != null;
            file = Paths.get(res.toURI()).toFile();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        String absolutePath = file.getAbsolutePath();
        String name = "image2.jpg";
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + name + "\"");
        FileInputStream fin = new FileInputStream(absolutePath);
        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(out);

        int ch =0;
        while((ch=bin.read())!=-1)
        {
            // display image
            bout.write(ch);
        }
        bin.close();
        fin.close();
        bout.close();
        out.close();
    }
    public void destroy() {
    }
}